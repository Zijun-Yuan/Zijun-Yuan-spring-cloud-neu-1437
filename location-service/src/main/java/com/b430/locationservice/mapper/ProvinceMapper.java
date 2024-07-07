package com.b430.locationservice.mapper;

import com.b430.commonmodule.model.entity.Province;
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
public interface ProvinceMapper extends BaseMapper<Province> {

    /**
     * 根据省ID查询Province
     * @param provinceId 省ID
     * @return Province对象
     */
    Province selectByProvinceId(Integer provinceId);

    /**
     * 查询所有省
     * @return 省列表
     */
    List<Province> selectAllProvinces();

    /**
     * 插入Province
     * @param province Province对象
     */
    void insertProvince(Province province);

    /**
     * 更新Province
     * @param province Province对象
     */
    void updateProvince(Province province);

}
