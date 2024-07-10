package com.b430.inspectorservice.repository.impl;

import com.b430.commonmodule.model.entity.Info;

import com.b430.inspectorservice.repository.InfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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

    // 更新Info到Elasticsearch的方法
    public boolean updateInfoInES(Info info) {
//        try {
//            UpdateRequest updateRequest = new UpdateRequest("info", info.getInfoId().toString());
//            updateRequest.doc(objectMapper.writeValueAsString(info), XContentType.JSON);
//            UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
//            return updateResponse.status().getStatus() == 200;
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
