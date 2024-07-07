package com.b430.datascreenservice.service.impl;

import com.b430.datascreenservice.mapper.DataScreenMapper;
import com.b430.commonmodule.model.dto.dataScreen.*;
import com.b430.datascreenservice.service.IDataScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataScreenServiceImpl implements IDataScreenService {
    @Autowired
    private DataScreenMapper dataScreenMapper;

    @Override
    public LeftTopResponseDTO getLeftTopData() {
        return dataScreenMapper.getLeftTopData();
    }

    @Override
    public LeftCenterResponseDTO getLeftCenterData() {
        LeftCenterResponseDTO leftCenterResponseDTO = new LeftCenterResponseDTO();
        leftCenterResponseDTO.setAqiLevel_1(dataScreenMapper.getAqiTotal(1));
        leftCenterResponseDTO.setAqiLevel_2(dataScreenMapper.getAqiTotal(2));
        leftCenterResponseDTO.setAqiLevel_3(dataScreenMapper.getAqiTotal(3));
        leftCenterResponseDTO.setAqiLevel_4(dataScreenMapper.getAqiTotal(4));
        leftCenterResponseDTO.setAqiLevel_5(dataScreenMapper.getAqiTotal(5));
        leftCenterResponseDTO.setAqiLevel_6(dataScreenMapper.getAqiTotal(6));
        return leftCenterResponseDTO;
    }

    @Override
    public List<LeftBottomResponseDTO> getLeftBottomData() {
        List<LeftBottomResponseDTO> data = dataScreenMapper.getLatestSupInfo();
        for (LeftBottomResponseDTO dto : data) {
            dto.setFormattedTime(dto.getFormattedTime());
        }
        return data;
    }

    @Override
    public List<CenterMapResponseDTO> getCenterMapDataProvinceList(Integer regionCode) {
        if (regionCode == 100000){
            List<CenterMapResponseDTO> centerMapResponseDTOList = dataScreenMapper.getMapDataProvinceList(regionCode);
            System.out.println(centerMapResponseDTOList.get(0).getRegionCode()+" "+centerMapResponseDTOList.get(0).getDataList());
            return centerMapResponseDTOList;
        }else {
            return dataScreenMapper.getMapDataCityList(regionCode);
        }
    }

    @Override
    public List<CenterBottomResponseDTO> getCenterBottomData() {
        return dataScreenMapper.getProvinceExceed();
    }

    @Override
    public List<RightTopResponseDTO> getRightTopData() {
        return dataScreenMapper.getOneYearAqiExceed();
    }

    @Override
    public List<RightCenterResponseDTO> getRightCenterData() {
        return dataScreenMapper.getPollutionRank();
    }

    @Override
    public List<RightBottomResponseDTO> getRightBottomData() {
        List<RightBottomResponseDTO> data = dataScreenMapper.getLatestInsInfo();
        for (RightBottomResponseDTO dto : data) {
            dto.setFormattedTime(dto.getFormattedTime());
        }
        return data;
    }
}
