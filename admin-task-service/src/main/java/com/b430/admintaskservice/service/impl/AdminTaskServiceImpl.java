package com.b430.admintaskservice.service.impl;


import com.b430.admintaskservice.mapper.AdminMapper;
import com.b430.admintaskservice.mapper.InfoAndCharacterRelationMapper;
import com.b430.admintaskservice.mapper.InfoMapper;
import com.b430.admintaskservice.repository.impl.SyncService;
import com.b430.admintaskservice.service.IAdminTaskService;
import com.b430.commonmodule.model.dto.info.InfoSearchRequestDTO;
import com.b430.commonmodule.model.entity.Admin;
import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {

    @Autowired
    private SyncService syncService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private InfoAndCharacterRelationMapper relationMapper;

    @Override
    public Admin login(String adminCode, String password) {
        Admin admin = adminMapper.selectByAdminCode(adminCode);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        } else {
            return null;
        }
    }

    @Override
    public boolean setInfoToInspector(Integer infoId, Integer inspectorId) {
        if (infoId == null || inspectorId == null) {
            System.out.println("Info id or Inspector id is null.");
            return false;
        } else {
            int i_id = relationMapper.getInfoWithInspectorNum();
            relationMapper.assignInspector(i_id + 1, infoId, inspectorId);
            System.out.println("连接表插入成功.");
            Info info = infoMapper.getInfoById(infoId);
            info.setStatus(2);
            info.setInspectorName(relationMapper.getInspectorByInfoId(infoId).getRealName());
            infoMapper.updateInfo(info);
            System.out.println("Info状态更新成功."+info.getStatus());
            syncService.updateInfoInES(info);
            return true;
        }
    }

    @Override
    public List<Info> getMultiQueryInfoList(InfoSearchRequestDTO requestDTO) {
        return infoMapper.selectMultiQuery(requestDTO);
    }

    @Override
    public Integer getMultiQueryInfoCount(InfoSearchRequestDTO requestDTO) {
        return infoMapper.getMultiQueryInfoNum(requestDTO);
    }

//    @Override
//    public Integer getInfoCountByStatus(Integer status) {
//        return infoMapper.getInfoNumByStatus(status);
//    }

    @Override
    public Info getInfoById(Integer id) {
        return infoMapper.getInfoById(id);
    }

//    @Override
//    public List<Info> getInfoListByStatus(Integer status) {
//        return infoMapper.selectAllByStatus(status);
//    }

//    @Override
//    public List<Info> getAllAssignedInfoList() {
//        return infoMapper.selectAllAssigned();
//    }

    @Override
    public List<Info> getInspectorInfoList(String inspectorCode) {
        if (inspectorCode == null) {
            System.out.println("Inspector code is null.");
            return null;
        } else {
            return infoMapper.selectByInspectorCode(inspectorCode);
        }
    }

    @Override
    public List<Info> getSupervisorInfoList(Integer supervisorId) {
        if (supervisorId == null) {
            System.out.println("Supervisor id is null.");
            return null;
        } else {
            return infoMapper.selectBySupervisorId(supervisorId);
        }
    }

    @Override
    public Inspector getInspectorByInfoId(Integer infoId) {
        if (infoId == null) {
            System.out.println("info id is null");
            return null;
        } else {
            PageHelper.clearPage();
            return relationMapper.getInspectorByInfoId(infoId);
        }
    }

    @Override
    public Supervisor getSupervisorByInfoId(Integer infoId) {
        if (infoId == null) {
            System.out.println("info id is null");
            return null;
        } else {
            PageHelper.clearPage();
            return relationMapper.getSupervisorByInfoId(infoId);
        }
    }

}
