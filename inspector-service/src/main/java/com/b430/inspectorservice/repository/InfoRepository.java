package com.b430.inspectorservice.repository;

import com.b430.commonmodule.model.entity.Info;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface InfoRepository extends ElasticsearchRepository<Info, Integer> {
}
