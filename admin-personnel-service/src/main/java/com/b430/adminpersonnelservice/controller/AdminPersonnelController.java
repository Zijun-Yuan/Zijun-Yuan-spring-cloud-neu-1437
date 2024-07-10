package com.b430.adminpersonnelservice.controller;

import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.dto.inspector.InspectorSelectDTO;
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

    /**
     * 通过电话号码和city模糊查询网格员数量
     * @param inspectorSelectDTO
     * @return
     */
    @ApiOperation(value = "通过电话号码和city模糊查询网格员数量", notes = "通过电话号码和city模糊查询网格员数量")
    @PostMapping("/getInspectorNum")
    public BaseResponse<Integer> getInspectorNum(@RequestBody InspectorSelectDTO inspectorSelectDTO) {
        Integer inspectorNum = adminPersonnelService.getInspectorNum(inspectorSelectDTO);
        if (inspectorNum == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "inspectorNum is null");
        } else {
            return ResultUtils.success(inspectorNum);
        }
    }

    /**
     * 获取查询后的网格员分页列表
     * @param inspectorSelectDTO
     * @return
     */
    @ApiOperation(value = "获取查询后的网格员分页列表", notes = "取查询后的网格员分页列表")
    @PostMapping("/getInspectorList")
    public BaseResponse<List<Inspector>> getInspectorList(@RequestBody InspectorSelectDTO inspectorSelectDTO) {
        List<Inspector> inspectorList = adminPersonnelService.getInspectorList(inspectorSelectDTO);
        if (inspectorList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "inspectorList is null");
        } else {
            return ResultUtils.success(inspectorList);
        }
    }

    /**
     * 通过电话号码模糊查询公众监督员数量
     * @param telNum
     * @return
     */
    @ApiOperation(value = "通过电话号码模糊查询公众监督员数量", notes = "通过电话号码模糊查询公众监督员数量")
    @GetMapping("/getSupervisorNum")
    public BaseResponse<Integer> getSupervisorNum(@RequestParam(required = false) String telNum) {
        Integer supervisorNum = adminPersonnelService.getSupervisorNum(telNum);
        if (supervisorNum == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "supervisorNum is null");
        } else {
            return ResultUtils.success(supervisorNum);
        }
    }

    /**
     * 获取查询后的公众监督员分页列表
     * @param telNum
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取查询后的公众监督员分页列表", notes = "获取查询后的公众监督员分页列表")
    @GetMapping("/getSupervisorList")
    public BaseResponse<List<Supervisor>> getSupervisorList(@RequestParam(required = false) String telNum,
                                                            @RequestParam Integer pageNum,
                                                            @RequestParam Integer pageSize) {
        List<Supervisor> supervisorList = adminPersonnelService.getSupervisorList(telNum, pageNum, pageSize);
        if (supervisorList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "supervisorList is null");
        } else {
            return ResultUtils.success(supervisorList);
        }
    }
}
