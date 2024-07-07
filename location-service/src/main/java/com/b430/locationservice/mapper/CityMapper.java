package com.b430.locationservice.mapper;

import com.b430.commonmodule.model.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-06-07
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {

    /**
     * 根据省份ID查询城市
     * @param provinceId 省份ID
     * @return 城市列表
     */
    List<City> selectByProvinceId(Integer provinceId);

    /**
     * 根据城市ID查询城市
     * @param cityId 城市ID
     * @return 城市对象
     */
    City selectByCityId(Integer cityId);

    /**
     * 查询所有城市
     * @return 城市列表
     */
    List<City> selectAllCities();

    /**
     * 插入City
     * @param city City对象
     */
    void insertCity(City city);

    /**
     * 更新City
     * @param city City对象
     */
    void updateCity(City city);

}
