package com.b430.admindataservice.service;

import com.b430.commonmodule.model.dto.admin.ProvincialStatisticResponseDTO;

import java.util.List;

public interface IAdminDataService {

    Integer getCountByAqiLevel(Integer aqiLevel);

    Double getPerOfMajorCities();

    Double getPerOfCapitals();

    Integer getCountByMonth(String month);

    List<ProvincialStatisticResponseDTO> getProvincialStatisticData();

}
