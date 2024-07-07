package com.b430.inspectorservice.service.impl;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.inspectorservice.mapper.InfoMapper;
import com.b430.inspectorservice.mapper.InspectorMapper;
import com.b430.inspectorservice.service.IInspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorServiceImpl implements IInspectorService {

    @Autowired
    private InspectorMapper inspectorMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public Inspector login(String inspectorCode, String password) {
        Inspector inspector = inspectorMapper.selectByInspectorCode(inspectorCode);
        if (inspector.getPassword().equals(password)) {
            return inspector;
        }
        return null;
    }

    @Override
    public Info getDetailedInfo(Integer infoId) {
        Info info = infoMapper.selectById(infoId);
        return info;
    }

    @Override
    public boolean feedbackInfo(Info info) {
        if(infoMapper.selectById(info.getInfoId())==null){
            System.out.println("feedbackInfo finding info failed\n");
            return false;
        }else {
            infoMapper.updateInfo(info);
            if(infoMapper.selectById(info.getInfoId()).toString().equals(info.toString())){
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
