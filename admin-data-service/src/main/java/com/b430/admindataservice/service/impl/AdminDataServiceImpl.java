package com.b430.admindataservice.service.impl;

import com.b430.admindataservice.mapper.DataMapper;
import com.b430.commonmodule.model.dto.admin.ProvincialStatisticResponseDTO;
import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Province;
import com.b430.admindataservice.service.IAdminDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.b430.commonmodule.constant.CommonConstant.*;

@Service
public class AdminDataServiceImpl implements IAdminDataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public Integer getCountByAqiLevel(Integer aqiLevel) {
        return dataMapper.getCountByAqiLevel(aqiLevel);
    }

    @Override
    public Double getPerOfMajorCities() {
        Double result = (double) dataMapper.getCountOfCityCodeList(MAJOR_CITIES) / (double) MAJOR_CITIES.size();
        return result;
    }

    @Override
    public Double getPerOfCapitals() {
        Double result = (double) dataMapper.getCountOfCityCodeList(PROVINCIAL_CAPITALS) / (double) PROVINCIAL_CAPITALS.size();
        return result;
    }

    @Override
    public Integer getCountByMonth(String month) {
        Integer result = dataMapper.getCountByMonth(month);
        return result;
    }

    @Override
    public List<ProvincialStatisticResponseDTO> getProvincialStatisticData() {
        List<ProvincialStatisticResponseDTO> result = new ArrayList<>(34);
        List<Province> provinceList = dataMapper.getProvinceList();
        for (Province province : provinceList) {
            ProvincialStatisticResponseDTO dto = new ProvincialStatisticResponseDTO();
            dto.setProvinceName(province.getProvinceName());
            dto.setSimpleName(province.getSimpleName());
            result.add(dto);
        }

        List<Info> infoList = dataMapper.getInfoListInspector();
        for (Info info : infoList) {
            Province province = dataMapper.getProvinceByCityCode(info.getCityCode());

            int index = province.getIndex() - 1;

            // AQI判断逻辑
            if (info.getAqiLevel() > 2){
                result.get(index).setAqiExceed(result.get(index).getAqiExceed() + 1);
            }

            // so2判断逻辑
            if (info.getSo2() > SO2_STANDARD){
                result.get(index).setSo2Exceed(result.get(index).getSo2Exceed() + 1);
            }

            // co判断逻辑
            if (info.getCo() > CO_STANDARD){
                result.get(index).setCoExceed(result.get(index).getCoExceed() + 1);
            }

            // o3判断逻辑
            if (info.getO3() > O3_STANDARD){
                result.get(index).setO3Exceed(result.get(index).getO3Exceed() + 1);
            }

            // pm2.5判断逻辑
            if (info.getPm25() > PM25_STANDARD){
                result.get(index).setPm25Exceed(result.get(index).getPm25Exceed() + 1);
            }
        }
        return result;
    }
}
