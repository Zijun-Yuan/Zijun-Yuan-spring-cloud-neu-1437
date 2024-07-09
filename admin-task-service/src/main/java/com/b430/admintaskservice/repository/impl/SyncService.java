package com.b430.admintaskservice.repository.impl;

import com.b430.admintaskservice.mapper.InfoMapper;
import com.b430.admintaskservice.repository.InfoRepository;
import com.b430.commonmodule.model.entity.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyncService {

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private InfoRepository infoRepository;

    public void syncData() {
        List<Info> infoList = infoMapper.getInfoList();
        for (Info info : infoList) {
            infoRepository.save(info);
        }
    }
}
