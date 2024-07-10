package com.b430.supervisorservice.repository.impl;

import com.b430.commonmodule.model.entity.Info;
import com.b430.supervisorservice.repository.InfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SyncService {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private InfoRepository infoRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // 将新生成的Info同步到Elasticsearch
    public boolean addInfoToES(Info info) {
//        try {
//            IndexRequest indexRequest = new IndexRequest("info")
//                    .id(info.getInfoId().toString())
//                    .source(objectMapper.writeValueAsString(info), XContentType.JSON);
//
//            client.index(indexRequest, RequestOptions.DEFAULT);
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
        try {
            infoRepository.save(info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
