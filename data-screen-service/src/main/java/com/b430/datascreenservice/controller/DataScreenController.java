package com.b430.datascreenservice.controller;

import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.dto.dataScreen.*;
import com.b430.datascreenservice.service.IDataScreenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "数据大屏相关接口")
@RestController
@RequestMapping("/dataScreen")
public class DataScreenController {
    @Autowired
    private IDataScreenService dataScreenService;

    /**
     * 获取数据大屏左上数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏左上数据")
    @GetMapping("/leftTop")
    public BaseResponse<LeftTopResponseDTO> getLeftTopData() {
        LeftTopResponseDTO leftTopResponseDTO = dataScreenService.getLeftTopData();
        if (leftTopResponseDTO == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "左上获取数据失败");
        } else {
            return ResultUtils.success(leftTopResponseDTO);
        }
    }

    /**
     * 获取数据大屏左中数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏左中数据")
    @GetMapping("/leftCenter")
    public BaseResponse<LeftCenterResponseDTO> getLeftCenterData() {
        LeftCenterResponseDTO leftCenterResponseDTO = dataScreenService.getLeftCenterData();
        if (leftCenterResponseDTO == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "左中获取数据失败");
        } else {
            return ResultUtils.success(leftCenterResponseDTO);
        }
    }

    /**
     * 获取数据大屏左下数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏左下数据")
    @GetMapping("/leftBottom")
    public BaseResponse<List<LeftBottomResponseDTO>> getLeftBottomData() {
        List<LeftBottomResponseDTO> leftBottomResponseDTOList = dataScreenService.getLeftBottomData();
        if (leftBottomResponseDTOList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "左下获取数据失败");
        } else {
            return ResultUtils.success(leftBottomResponseDTOList);
        }
    }

    /**
     * 获取数据大屏中心数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏中心地图数据")
    @GetMapping("/centerMap")
    public BaseResponse<List<CenterMapResponseDTO>> getCenterMapData(@RequestParam Integer regionCode) {
        List<CenterMapResponseDTO> centerMapResponseDTOList = dataScreenService.getCenterMapDataProvinceList(regionCode);
        if (centerMapResponseDTOList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "中心地图获取数据失败");
        } else {
            return ResultUtils.success(centerMapResponseDTOList);
        }
    }

    /**
     * 获取数据大屏中心下部数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏中心下部数据")
    @GetMapping("/centerBottom")
    public BaseResponse<List<CenterBottomResponseDTO>> getCenterBottomData() {
        List<CenterBottomResponseDTO> centerBottomResponseDTOList = dataScreenService.getCenterBottomData();
        if (centerBottomResponseDTOList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "中心底部获取数据失败");
        } else {
            return ResultUtils.success(centerBottomResponseDTOList);
        }
    }

    /**
     * 获取数据大屏右上数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏右上数据")
    @GetMapping("/rightTop")
    public BaseResponse<List<RightTopResponseDTO>> getRightTopData() {
        List<RightTopResponseDTO> rightTopResponseDTOList = dataScreenService.getRightTopData();
        if (rightTopResponseDTOList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "右上获取数据失败");
        } else {
            return ResultUtils.success(rightTopResponseDTOList);
        }
    }

    /**
     * 获取数据大屏右中数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏右中数据")
    @GetMapping("/rightCenter")
    public BaseResponse<List<RightCenterResponseDTO>> getRightCenterData() {
        List<RightCenterResponseDTO> rightCenterResponseDTOList = dataScreenService.getRightCenterData();
        if (rightCenterResponseDTOList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "右中获取数据失败");
        } else {
            return ResultUtils.success(rightCenterResponseDTOList);
        }
    }

    /**
     * 获取数据大屏右下数据
     * @return
     */
    @ApiOperation(value = "获取数据大屏右下数据")
    @GetMapping("/rightBottom")
    public BaseResponse<List<RightBottomResponseDTO>> getRightBottomData() {
        List<RightBottomResponseDTO> rightBottomResponseDTOList = dataScreenService.getRightBottomData();
        if (rightBottomResponseDTOList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "右下获取数据失败");
        } else {
            return ResultUtils.success(rightBottomResponseDTOList);
        }
    }

}
