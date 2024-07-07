package com.b430.datascreenservice.service;

import com.b430.commonmodule.model.dto.dataScreen.*;

import java.util.List;

public interface IDataScreenService {

    /**
     * 获取数据大屏左上数据
     * @return LeftTopResponseDTO
     */
    LeftTopResponseDTO getLeftTopData();

    /**
     * 获取数据大屏左中数据
     * @return LeftCenterResponseDTO
     */
    LeftCenterResponseDTO getLeftCenterData();

    /**
     * 获取数据大屏左下数据
     * @return LeftBottomResponseDTO
     */
    List<LeftBottomResponseDTO> getLeftBottomData();

    /**
     * 获取数据大屏中心地图数据
     * @return CenterMapResponseDTO
     */
    List<CenterMapResponseDTO> getCenterMapDataProvinceList(Integer regionCode);

//    /**
//     * 获取数据大屏中心地图城市数据
//     * @return CenterMapResponseDTO
//     */
//    List<CenterMapResponseDTO> getCenterMapDataCityList(Integer provinceId);

    /**
     * 获取数据大屏中心下部数据
     * @return CenterBottomResponseDTO
     */
    List<CenterBottomResponseDTO> getCenterBottomData();

    /**
     * 获取数据大屏右上数据
     * @return RightTopResponseDTO
     */
    List<RightTopResponseDTO> getRightTopData();

    /**
     * 获取数据大屏右中数据
     * @return RightCenterResponseDTO
     */
    List<RightCenterResponseDTO> getRightCenterData();

    /**
     * 获取数据大屏右下数据
     * @return RightBottomResponseDTO
     */
    List<RightBottomResponseDTO> getRightBottomData();
}

