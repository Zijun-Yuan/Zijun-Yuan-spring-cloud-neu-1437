package com.b430.admindataservice.mapper;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataMapper {
    Integer getCountByAqiLevel(Integer aqiLevel);

    Integer getCountOfCityCodeList(@Param("CityCodeList") List<String> CityCodeList);

    Integer getCountByMonth(String month);

    List<Info> getInfoListInspector();

    Province getProvinceByCityCode(String cityCode);

    List<Province> getProvinceList();

}
