package com.b430.locationservice.service;

import com.b430.commonmodule.model.entity.City;
import com.b430.commonmodule.model.entity.Province;

import java.util.List;

public interface ILocationService {
    List<Province> getAllProvinces();

    Province getProvinceById(Integer provinceId);

    List<City> getAllCities();

    List<City> getAllCitiesByProvinceId(Integer provinceId);

    City getCityById(Integer CityId);
}
