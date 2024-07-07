package com.b430.locationservice.service.impl;

import com.b430.locationservice.mapper.CityMapper;
import com.b430.locationservice.mapper.ProvinceMapper;
import com.b430.commonmodule.model.entity.City;
import com.b430.commonmodule.model.entity.Province;
import com.b430.locationservice.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<Province> getAllProvinces() {
        return provinceMapper.selectAllProvinces();
    }

    @Override
    public Province getProvinceById(Integer provinceId) {
        return provinceMapper.selectByProvinceId(provinceId);
    }

    @Override
    public List<City> getAllCities() {
        return cityMapper.selectAllCities();
    }

    @Override
    public List<City> getAllCitiesByProvinceId(Integer provinceId) {
        return cityMapper.selectByProvinceId(provinceId);
    }

    @Override
    public City getCityById(Integer CityId) {
        return cityMapper.selectByCityId(CityId);
    }
}
