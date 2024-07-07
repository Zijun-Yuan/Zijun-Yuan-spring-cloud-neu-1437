package com.b430.adminpersonnelservice.service.impl;

import com.b430.adminpersonnelservice.mapper.InfoMapper;
import com.b430.adminpersonnelservice.mapper.InspectorMapper;
import com.b430.adminpersonnelservice.mapper.SupervisorMapper;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;
import com.b430.adminpersonnelservice.service.IAdminPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPersonnelServiceImpl implements IAdminPersonnelService {

    @Autowired
    private InspectorMapper inspectorMapper;

    @Autowired
    private SupervisorMapper supervisorMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public boolean editSuperVisor(Supervisor supervisor) {
        Supervisor check = supervisorMapper.selectBySupervisorId(supervisor.getSupervisorId());
        if (check == null){
            System.out.println("edit Supervisor not found");
            return false;
        }else {
            if (!check.getTelId().equals(supervisor.getTelId()) && supervisorMapper.selectByTelId(supervisor.getTelId()) != null){
                System.out.println("edit Supervisor telId already exist");
                return false;
            }else {
                supervisorMapper.updateSupervisor(supervisor);
                return true;
            }
        }
    }

    @Override
    public List<Supervisor> getAllSupervisor() {
        List<Supervisor> supervisorList = supervisorMapper.selectAllNotDeleted();
        return supervisorList;
    }

    @Override
    public Supervisor getOneSupervisor(String telId) {
        Supervisor supervisor = supervisorMapper.selectByTelId(telId);
        if (supervisor == null) {
            System.out.println("get Supervisor not found");
            return null;
        } else {
            return supervisor;
        }
    }

    @Override
    public List<Inspector> getAllInspectors() {
        List<Inspector> inspectorList = inspectorMapper.selectAllNotDeleted();
        return inspectorList;
    }

    @Override
    public Inspector getOneInspector(String inspectorCode) {
        Inspector inspector = inspectorMapper.selectByInspectorCode(inspectorCode);
        if (inspector == null) {
            System.out.println("get Inspector not found");
            return null;
        } else {
            return inspector;
        }
    }

    @Override
    public boolean editInspector(Inspector inspector) {
        Inspector check = inspectorMapper.selectByInspectorId(inspector.getInspectorId());
        if (check == null){
            System.out.println("edit Inspector not found");
            return false;
        }else {
            if (check.getInspectorCode() != inspector.getInspectorCode() && inspectorMapper.selectByInspectorCode(inspector.getInspectorCode()) != null){
                System.out.println("edit Inspector inspectorCode already exist");
                return false;
            }else {
                inspectorMapper.updateById(inspector);
                // 判断网格员名字是否存在变更
                if (!check.getRealName().equals(inspector.getRealName())){
                    infoMapper.updateInfoInspectorName(inspector.getInspectorId(), inspector.getRealName());
                }
                return true;
            }
        }
    }

    @Override
    public boolean addInspector(Inspector inspector) {
        if (inspectorMapper.selectByInspectorCode(inspector.getInspectorCode()) != null) {
            System.out.println("add inspector already exist");
            return false;
        } else {
            inspectorMapper.insert(inspector);
            return true;
        }
    }

    @Override
    public List<Inspector> getListByCityCodeList(List<String> cityCodeList) {
        List<Inspector> inspectorList = inspectorMapper.selectByCityCodeList(cityCodeList);
        return inspectorList;
    }
}
