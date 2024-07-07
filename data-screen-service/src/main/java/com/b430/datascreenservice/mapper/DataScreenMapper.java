package com.b430.datascreenservice.mapper;

import com.b430.commonmodule.model.dto.dataScreen.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataScreenMapper {
    // left-top
    LeftTopResponseDTO getLeftTopData();

    // left-center
    Integer getAqiTotal(Integer aqiLevel);

    // left-bottom
    List<LeftBottomResponseDTO> getLatestSupInfo();

    // center-map
    List<CenterMapResponseDTO> getMapDataProvinceList(Integer regionCode);

    List<CenterMapResponseDTO> getMapDataCityList(Integer provinceId);

    // center-bottom
    List<CenterBottomResponseDTO> getProvinceExceed();

    // right-top
    List<RightTopResponseDTO> getOneYearAqiExceed();

    // right-center
    List<RightCenterResponseDTO> getPollutionRank();

    // right-bottom
    List<RightBottomResponseDTO> getLatestInsInfo();
}
