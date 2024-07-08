package com.b430.adminpersonnelservice.controller;

import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;
import com.b430.adminpersonnelservice.service.IAdminPersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理员人员管理接口")
@RestController
@RequestMapping("/admin/personnel")
public class AdminPersonnelController {

    @Autowired
    private IAdminPersonnelService adminPersonnelService;

    /**
     * 编辑公众监督员
     * @param supervisor
     * @return
     */
    @ApiOperation(value = "编辑公众监督员", notes = "编辑公众监督员")
    @PostMapping("/editSuperVisor")
    public BaseResponse<Boolean> editSuperVisor(@RequestBody Supervisor supervisor) {
        if (adminPersonnelService.editSuperVisor(supervisor)){
            return ResultUtils.success(true);
        }else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "Edit SuperVisor failed");
        }
    }

    /**
     * 查询所有公众监督员（未删除的）
     * @return
     */
    @ApiOperation(value = "查询所有公众监督员（未删除的）", notes = "查询所有公众监督员（未删除的）")
    @GetMapping("/getAllSupervisor")
    public BaseResponse<List<Supervisor>> getAllSupervisor() {
        List<Supervisor> supervisorList = adminPersonnelService.getAllSupervisor();
        return ResultUtils.success(supervisorList);
    }

    /**
     * 查询一个公众监督员
     * @param telId
     * @return
     */
    @ApiOperation(value = "查询一个公众监督员", notes = "查询一个公众监督员")
    @GetMapping("/getOneSupervisor")
    public BaseResponse<Supervisor> getOneSupervisor(@RequestParam String telId) {
        Supervisor supervisor = adminPersonnelService.getOneSupervisor(telId);
        return ResultUtils.success(supervisor);
    }

    /**
     * 查询所有网格员
     * @return
     */
    @ApiOperation(value = "查询所有网格员", notes = "查询所有网格员")
    @GetMapping("/getAllInspectors")
    public BaseResponse<List<Inspector>> getAllInspectors() {
        List<Inspector> inspectorList = adminPersonnelService.getAllInspectors();
        return ResultUtils.success(inspectorList);
    }

    /**
     * 查询一个网格员
     * @param inspectorCode
     * @return
     */
    @ApiOperation(value = "查询一个网格员", notes = "查询一个网格员")
    @GetMapping("/getOneInspector")
    public BaseResponse<Inspector> getOneInspector(@RequestParam String inspectorCode) {
        Inspector inspector = adminPersonnelService.getOneInspector(inspectorCode);
        return ResultUtils.success(inspector);
    }

    /**
     * 编辑网格员
     * @param inspector
     * @return
     */
    @ApiOperation(value = "编辑网格员", notes = "编辑网格员")
    @PostMapping("/editInspector")
    public BaseResponse<Boolean> editInspector(@RequestBody Inspector inspector) {
        if (adminPersonnelService.editInspector(inspector)){
            return ResultUtils.success(true);
        }else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "Edit Inspector failed");
        }
    }

    /**
     * 新增网格员
     * @param inspector
     * @return
     */
    @ApiOperation(value = "新增网格员", notes = "新增网格员")
    @PostMapping("/addInspector")
    public BaseResponse<Boolean> addInspector(@RequestBody Inspector inspector) {
        if (adminPersonnelService.addInspector(inspector)){
            return ResultUtils.success(true);
        }else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "Add Inspector failed");
        }
    }

    /**
     * 网格员根据城市获取网格员列表
     * @param cityCodeList
     * @return
     */
    @ApiOperation(value = "网格员根据城市获取网格员列表", notes = "网格员根据城市获取网格员列表")
    @PostMapping ("/getListByCityCodeList")
    public BaseResponse<List<Inspector>> getListByCityCodeList(@RequestBody List<String> cityCodeList){
        List<Inspector> inspectorList = adminPersonnelService.getListByCityCodeList(cityCodeList);
        if (inspectorList == null || inspectorList.isEmpty()){
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "InspectorList is empty");
        }else {
            return ResultUtils.success(inspectorList);
        }
    }
}
