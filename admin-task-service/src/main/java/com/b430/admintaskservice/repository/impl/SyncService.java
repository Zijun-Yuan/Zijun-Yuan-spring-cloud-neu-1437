package com.b430.admintaskservice.repository.impl;

import com.b430.admintaskservice.mapper.InfoMapper;
import com.b430.admintaskservice.repository.InfoRepository;
import com.b430.commonmodule.model.dto.info.InfoSearchRequestDTO;
import com.b430.commonmodule.model.entity.Info;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SyncService {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private InfoRepository infoRepository;

    @PostConstruct
    public void init() {
        try {
            if (!isIndexExists("info")) {
                createIndex("info");
            }
            if (!isIndexPopulated("info")) {
                syncData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isIndexExists(String indexName) {
        try {
            GetIndexRequest request = new GetIndexRequest();
            request.indices(indexName);
            return client.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private void createIndex(String indexName) {
        try {
            String mapping = "{\n" +
                    "  \"info\": {\n" +
                    "    \"mappings\": {\n" +
                    "      \"properties\": {\n" +
                    "        \"_class\": {\n" +
                    "          \"type\": \"keyword\",\n" +
                    "          \"index\": false,\n" +
                    "          \"doc_values\": false\n" +
                    "        },\n" +
                    "        \"address\": {\n" +
                    "          \"type\": \"text\"\n" +
                    "        },\n" +
                    "        \"aqiLevel\": {\n" +
                    "          \"type\": \"integer\"\n" +
                    "        },\n" +
                    "        \"aqiReal\": {\n" +
                    "          \"type\": \"text\"\n" +
                    "        },\n" +
                    "        \"cityCode\": {\n" +
                    "          \"type\": \"text\"\n" +
                    "        },\n" +
                    "        \"co\": {\n" +
                    "          \"type\": \"double\"\n" +
                    "        },\n" +
                    "        \"feedback\": {\n" +
                    "          \"type\": \"text\"\n" +
                    "        },\n" +
                    "        \"infoId\": {\n" +
                    "          \"type\": \"long\"\n" +
                    "        },\n" +
                    "        \"inspectorName\": {\n" +
                    "          \"type\": \"text\"\n" +
                    "        },\n" +
                    "        \"o3\": {\n" +
                    "          \"type\": \"double\"\n" +
                    "        },\n" +
                    "        \"pm25\": {\n" +
                    "          \"type\": \"double\"\n" +
                    "        },\n" +
                    "        \"so2\": {\n" +
                    "          \"type\": \"double\"\n" +
                    "        },\n" +
                    "        \"status\": {\n" +
                    "          \"type\": \"integer\"\n" +
                    "        },\n" +
                    "        \"supervisorName\": {\n" +
                    "          \"type\": \"text\"\n" +
                    "        },\n" +
                    "        \"timeInspector\": {\n" +
                    "          \"type\": \"date\",\n" +
                    "          \"format\": \"yyyy-MM-dd HH:mm:ss || yyyy-MM-dd'T'HH:mm:ss'+08:00' || strict_date_optional_time || epoch_millis\"\n" +
                    "        },\n" +
                    "        \"timeSupervisor\": {\n" +
                    "          \"type\": \"date\",\n" +
                    "          \"format\": \"yyyy-MM-dd HH:mm:ss || yyyy-MM-dd'T'HH:mm:ss'+08:00' || strict_date_optional_time || epoch_millis\"\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";

            CreateIndexRequest request = new CreateIndexRequest(indexName);
            request.settings(Settings.builder()
                    .put("index.number_of_shards", 1)
                    .put("index.number_of_replicas", 0)
            );
            request.mapping(mapping, XContentType.JSON);
            client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isIndexPopulated(String indexName) {
        try {
            CountRequest countRequest = new CountRequest(indexName);
            CountResponse countResponse = client.count(countRequest, RequestOptions.DEFAULT);
            return countResponse.getCount() > 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void syncData() {
        List<Info> infoList = infoMapper.getInfoList();
        for (Info info : infoList) {
            infoRepository.save(info);
        }
    }

    public Integer getMultiQueryInfoCount(InfoSearchRequestDTO request) {
        try {
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

            if (request.getCityCode() != null && !request.getCityCode().isEmpty()) {
                boolQuery.must(QueryBuilders.termsQuery("cityCode", request.getCityCode()));
            }
            if (request.getAqiLevel() != null) {
                boolQuery.must(QueryBuilders.termQuery("aqiLevel", request.getAqiLevel()));
            }
            if (request.getTimeSupervisor() != null) {
                boolQuery.must(QueryBuilders.termQuery("timeSupervisor", request.getTimeSupervisor().toString()));
            }
            if (request.getTimeInspector() != null) {
                boolQuery.must(QueryBuilders.termQuery("timeInspector", request.getTimeInspector().toString()));
            }
            if (request.getStatus() != null) {
                boolQuery.must(QueryBuilders.termQuery("status", request.getStatus()));
            }
            if (request.getSupervisorName() != null && !request.getSupervisorName().isEmpty()) {
                boolQuery.must(QueryBuilders.matchPhraseQuery("supervisorName", request.getSupervisorName()));
            }
            if (request.getInspectorName() != null && !request.getInspectorName().isEmpty()) {
                boolQuery.must(QueryBuilders.matchPhraseQuery("inspectorName", request.getInspectorName()));
            }

            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(boolQuery);

            CountRequest countRequest = new CountRequest("info"); // 修改为正确的索引名
            countRequest.source(searchSourceBuilder);

            CountResponse countResponse = client.count(countRequest, RequestOptions.DEFAULT);
            return (int) countResponse.getCount();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PageInfo<Info> getMultiQueryInfoList(InfoSearchRequestDTO request) {
        List<Info> infoList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

            if (request.getCityCode() != null && !request.getCityCode().isEmpty()) {
                boolQuery.must(QueryBuilders.termsQuery("cityCode", request.getCityCode()));
            }
            if (request.getAqiLevel() != null) {
                boolQuery.must(QueryBuilders.termQuery("aqiLevel", request.getAqiLevel()));
            }
            if (request.getTimeSupervisor() != null) {
                boolQuery.must(QueryBuilders.termQuery("timeSupervisor", request.getTimeSupervisor().toString()));
            }
            if (request.getTimeInspector() != null) {
                boolQuery.must(QueryBuilders.termQuery("timeInspector", request.getTimeInspector().toString()));
            }
            if (request.getStatus() != null) {
                boolQuery.must(QueryBuilders.termQuery("status", request.getStatus()));
            }
            if (request.getSupervisorName() != null && !request.getSupervisorName().isEmpty()) {
                boolQuery.must(QueryBuilders.matchPhraseQuery("supervisorName", request.getSupervisorName()));
            }
            if (request.getInspectorName() != null && !request.getInspectorName().isEmpty()) {
                boolQuery.must(QueryBuilders.matchPhraseQuery("inspectorName", request.getInspectorName()));
            }

            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(boolQuery);
            searchSourceBuilder.from((request.getPageNum() - 1) * request.getPageSize());
            searchSourceBuilder.size(request.getPageSize());
            searchSourceBuilder.sort("timeInspector", SortOrder.DESC); // 修改为正确的排序字段

            SearchRequest searchRequest = new SearchRequest("info"); // 修改为正确的索引名
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();

            for (SearchHit hit : hits) {
                Info info = new Info();
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();

                // 映射字段
                info.setInfoId((int) Long.parseLong(hit.getId()));
                info.setStatus((Integer) sourceAsMap.get("status"));
                info.setAqiLevel((Integer) sourceAsMap.get("aqiLevel"));
                info.setCityCode((String) sourceAsMap.get("cityCode"));
                info.setAddress((String) sourceAsMap.get("address"));
                info.setFeedback((String) sourceAsMap.get("feedback"));

                // 检查时间字段是否为null
                String timeSupervisorStr = (String) sourceAsMap.get("timeSupervisor");
                if (timeSupervisorStr != null) {
                    info.setTimeSupervisor(LocalDateTime.parse(timeSupervisorStr, formatter));
                }

                String timeInspectorStr = (String) sourceAsMap.get("timeInspector");
                if (timeInspectorStr != null) {
                    info.setTimeInspector(LocalDateTime.parse(timeInspectorStr, formatter));
                }

                info.setSo2((Double) sourceAsMap.get("so2"));
                info.setCo((Double) sourceAsMap.get("co"));
                info.setO3((Double) sourceAsMap.get("o3"));
                info.setPm25((Double) sourceAsMap.get("pm25"));
                info.setSupervisorName((String) sourceAsMap.get("supervisorName"));
                info.setInspectorName((String) sourceAsMap.get("inspectorName"));
                info.setAqiReal((Integer) sourceAsMap.get("aqiReal"));

                infoList.add(info);
            }

            // 使用PageHelper分页
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
            PageInfo<Info> pageInfo = new PageInfo<>(infoList);

            return pageInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // info更改
    public boolean updateInfoInES(Info info) {
        try {
            UpdateRequest updateRequest = new UpdateRequest("info", info.getInfoId().toString());
            updateRequest.doc("status", info.getStatus(), "inspectorName", info.getInspectorName());
            UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
            if (updateResponse.status().getStatus() == 200) {
                System.out.println("Successfully updated info in ES: " + info.getInfoId() + " " + info.getInspectorName() + " " + info.getStatus());
                return true;
            } else {
                System.out.println("Failed to update info in ES: " + updateResponse.status());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
