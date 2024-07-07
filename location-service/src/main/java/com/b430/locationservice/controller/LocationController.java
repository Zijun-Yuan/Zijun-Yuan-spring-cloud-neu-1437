package com.b430.locationservice.controller;

import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.entity.City;
import com.b430.commonmodule.model.entity.Province;
import com.b430.locationservice.service.ILocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "省市相关接口")
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private ILocationService locationService;

    /**
     * 获得所有省份
     * @return
     */
    @ApiOperation(value = "获得所有省份", notes = "获得所有省份")
    @GetMapping("/province/getAllProvinces")
    public BaseResponse<List<Province>> getAllProvinces(){
        return ResultUtils.success(locationService.getAllProvinces());
    }

    /**
     * 根据省份id获得省份
     * @param provinceId
     * @return
     */
    @ApiOperation(value = "根据省份id获得省份", notes = "根据省份名称获得省份")
    @PostMapping("/province/getProvinceById")
    public BaseResponse<Province> getProvinceById(@RequestParam Integer provinceId){
        return ResultUtils.success(locationService.getProvinceById(provinceId));
    }

    /**
     * 获得所有城市
     * @return
     */
    @ApiOperation(value = "获得所有城市", notes = "获得所有城市")
    @GetMapping("/city/getAllCities")
    public BaseResponse<List<City>> getAllCities(){
        return ResultUtils.success(locationService.getAllCities());
    }

    /**
     * 根据省份Id获得对应城市
     * @param provinceId
     * @return
     */
    @ApiOperation(value = "根据省份Id获得对应城市", notes = "根据省份Id获得对应城市")
    @PostMapping("/city/getAllCitiesByProvinceId")
    public BaseResponse<List<City>> getAllCitiesByProvinceId(@RequestParam Integer provinceId){
        return ResultUtils.success(locationService.getAllCitiesByProvinceId(provinceId));
    }

    /**
     * 根据城市Id获得城市信息
     * @param CityId
     * @return     */
    @ApiOperation(value = "根据城市Id获得城市信息", notes = "根据城市Id获得城市信息")
    @PostMapping("/city/getCityById")
    public BaseResponse<City> getCityById(@RequestParam Integer CityId){
        return ResultUtils.success(locationService.getCityById(CityId));
    }

}
