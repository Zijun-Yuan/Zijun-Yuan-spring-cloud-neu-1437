package com.b430.admintaskservice.repository;

import com.b430.commonmodule.model.entity.Info;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface InfoRepository extends ElasticsearchRepository<Info, Integer> {
    List<Info> findBySupervisorName(String supervisorName);
}
