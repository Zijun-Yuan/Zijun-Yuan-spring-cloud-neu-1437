package com.b430.inspectorservice.service.impl;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.util.MD5Util;
import com.b430.inspectorservice.mapper.InfoMapper;
import com.b430.inspectorservice.mapper.InspectorMapper;
import com.b430.inspectorservice.repository.impl.SyncService;
import com.b430.inspectorservice.service.IInspectorService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorServiceImpl implements IInspectorService {

    @Autowired
    private SyncService syncService;

    @Autowired
    private InspectorMapper inspectorMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public Inspector login(String inspectorCode, String password) {
        Inspector inspector = inspectorMapper.selectByInspectorCode(inspectorCode);
        if (inspector != null) {
            String salt = inspector.getSalt();
            String MD5Password = MD5Util.md5(password, salt);
            if (inspector.getPassword().equals(MD5Password)){
                return inspector;
            }
        }
        return null;
    }

    @Override
    public Info getDetailedInfo(Integer infoId) {
        Info info = infoMapper.selectById(infoId);
        return info;
    }

    @Override
    @GlobalTransactional(name = "my_test_tx_group")
    public boolean feedbackInfo(Info info) {
        if(infoMapper.getInfoById(info.getInfoId())==null){
            System.out.println("feedbackInfo finding info failed\n");
            return false;
        }else {
            infoMapper.updateInfo(info);
            if(infoMapper.getInfoById(info.getInfoId()).toString().equals(info.toString())){
                syncService.updateInfoInES(info);
                return true;
            }else {
                System.out.println("feedbackInfo update info failed\n");
                return false;
            }
        }
    }

    @Override
    public List<Info> getInfoList(String inspectorCode) {
        List<Info> infoList = infoMapper.selectByInspectorCode(inspectorCode);
        return infoList;
    }

    @Override
    public Inspector getInspectorByCode(String inspectorCode) {
        Inspector inspector = inspectorMapper.selectByInspectorCode(inspectorCode);
        return inspector;
    }
}
