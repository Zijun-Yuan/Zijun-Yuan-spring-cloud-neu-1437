package com.b430.supervisorservice.service.impl;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Supervisor;
import com.b430.commonmodule.util.SqlUtils;
import com.b430.supervisorservice.mapper.InfoAndCharacterRelationMapper;
import com.b430.supervisorservice.mapper.InfoMapper;
import com.b430.supervisorservice.mapper.SupervisorMapper;
import com.b430.supervisorservice.service.ISupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceImpl implements ISupervisorService {

    @Autowired
    private SupervisorMapper supervisorMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private InfoAndCharacterRelationMapper infoAndCharacterRelationMapper;

    @Override
    public Supervisor login(String supervisorCode, String password) {
        Supervisor supervisor = supervisorMapper.selectByTelId(supervisorCode);
        if (supervisor != null && supervisor.getPassword().equals(password)) {
            return supervisor;
        }
        return null;
    }

    @Override
    public boolean register(Supervisor supervisor) {
        // 判断是否存在该用户
        Supervisor check = supervisorMapper.selectByTelId(supervisor.getTelId());
        if (check != null) {
            return false;
        } else {
            // 注册用户
            supervisorMapper.insertSupervisor(supervisor);
            check = supervisorMapper.selectByTelId(supervisor.getTelId());
            if (check != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Supervisor getSupervisorByTelId(String supervisorTelId) {
        return supervisorMapper.selectByTelId(supervisorTelId);
    }

    @Override
    public boolean editPersonal(Supervisor supervisor) {
        // 判断是否存在该用户
        Supervisor check = supervisorMapper.selectBySupervisorId(supervisor.getSupervisorId());
        System.out.println(supervisor.getSupervisorId()+" "+supervisor.getTelId());
        if (check == null){
            System.out.println("edit Supervisor not found");
            return false;
        }else {
            if (!check.getTelId().equals(supervisor.getTelId()) && supervisorMapper.selectByTelId(supervisor.getTelId()) != null){
                System.out.println("edit Supervisor telId already exist");
                return false;
            }else {
                supervisorMapper.updateSupervisor(supervisor);
                // 判断一下名字前后是否发生了改变
                if (!check.getRealName().equals(supervisor.getRealName())) {
                    infoMapper.updateInfoSupervisorName(supervisor.getSupervisorId(), supervisor.getRealName());
                }
                return true;
            }
        }
    }

    @Override
    public List<Info> getAllFeedbackList(Integer supervisorId, String sortField) {
        if (!SqlUtils.validSortField(sortField)){
            throw new IllegalArgumentException("Invalid sort field");
        }
        return supervisorMapper.getInfoListToSupervisor(supervisorId);
    }

    @Override
    public boolean addInfo(Info info) {
        int infoCount = infoMapper.getInfoNum();
        int relateCount = infoAndCharacterRelationMapper.getInfoWithSupervisorNum();
        int supervisorId = supervisorMapper.getSupervisorIdByName(info.getSupervisorName());
        infoMapper.addInfo(info, infoCount);
        infoMapper.addRelate(infoCount, relateCount, supervisorId);
        return true;
    }
}
