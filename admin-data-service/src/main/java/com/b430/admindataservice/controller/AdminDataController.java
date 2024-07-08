package com.b430.admindataservice.controller;

import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.dto.admin.ProvincialStatisticResponseDTO;
import com.b430.admindataservice.service.IAdminDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "管理员统计数据管理")
@RestController
@RequestMapping("/admin/data")
public class AdminDataController {
    @Autowired
    private IAdminDataService adminDataService;

    /**
     * 获取AQI等级统计数据
     * @param aqiLevel
     * @return
     */
    @ApiOperation(value = "获取AQI等级统计数据", notes = "获取AQI等级统计数据")
    @GetMapping("/countByAqiLevel")
    public BaseResponse<Integer> getCountByAqiLevel(@RequestParam Integer aqiLevel){
        Integer count = adminDataService.getCountByAqiLevel(aqiLevel);
        if (count == null){
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取AQI等级统计数据失败");
        }else {
            return ResultUtils.success(count);
        }
    }

    /**
     * 获取省会城市覆盖率
     * @return
     */
    @ApiOperation(value = "获取省会城市覆盖率", notes = "获取省会城市覆盖率")
    @GetMapping("/getPerOfCapitals")
    public BaseResponse<Double> getPerOfCapitals(){
        Double per = adminDataService.getPerOfCapitals();
        if (per == null){
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取省会城市覆盖率失败");
        }else {
            return ResultUtils.success(per);
        }
    }

    /**
     * 获取大城市覆盖率
     * @return
     */
    @ApiOperation(value = "获取大城市覆盖率", notes = "获取大城市覆盖率")
    @GetMapping("/getPerOfMajorCities")
    public BaseResponse<Double> getPerOfMajorCities(){
        Double per = adminDataService.getPerOfMajorCities();
        if (per == null){
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取大城市覆盖率失败");
        }else {
            return ResultUtils.success(per);
        }
    }

    /**
     * 获取月份AQI超标数量
     * @param month
     * @return
     */
    @ApiOperation(value = "获取月份AQI超标数量", notes = "获取月份AQI超标数量")
    @GetMapping("/getCountByMonth")
    public BaseResponse<Integer> getCountByMonth(@RequestParam String month){
        Integer count = adminDataService.getCountByMonth(month);
        if (count == null){
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取月份AQI超标数量失败");
        }else {
            return ResultUtils.success(count);
        }
    }

    /**
     * 获取省份分组统计数据
     * @return
     */
    @ApiOperation(value = "获取省份分组统计数据", notes = "获取省份分组统计数据")
    @GetMapping("/getProvincialStatisticData")
    public BaseResponse<List<ProvincialStatisticResponseDTO>> getProvincialStatisticData(){
        List<ProvincialStatisticResponseDTO> data = adminDataService.getProvincialStatisticData();
        if (data == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取省份分组统计数据失败");
        } else {
            return ResultUtils.success(data);
        }
    }
}
