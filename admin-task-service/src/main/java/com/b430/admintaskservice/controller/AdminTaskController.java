package com.b430.admintaskservice.controller;

import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.dto.admin.AdminLoginRequestDTO;
import com.b430.commonmodule.model.dto.admin.InfoAssignmentRequestDTO;
import com.b430.commonmodule.model.dto.info.InfoSearchRequestDTO;
import com.b430.commonmodule.model.entity.Admin;
import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;
import com.b430.admintaskservice.service.IAdminTaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(tags = "管理员任务管理")
@RestController
@RequestMapping("/admin")
public class AdminTaskController {

    @Autowired
    private IAdminTaskService adminTaskService;

    /**
     * 管理员登录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "管理员登录", notes = "管理员登录接口")
    @PostMapping("/login")
    public BaseResponse<Boolean> login(@RequestBody AdminLoginRequestDTO request, HttpSession session) {
        Admin admin = adminTaskService.login(request.getAdminCode(), request.getPassword());
        if (admin != null) {
            session.setAttribute("admin", admin);
            return ResultUtils.success(true);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "管理员登录失败");
        }
    }

    /**
     * 指派网格员
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "指派网格员", notes = "指派网格员接口")
    @PostMapping("/setInfoToInspector")
    public BaseResponse<Boolean> setInfoToInspector(@RequestBody InfoAssignmentRequestDTO request) {
        if (adminTaskService.setInfoToInspector(request.getInfoId(), request.getInspectorId())) {
            return ResultUtils.success(true);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "指派网格员失败");
        }
    }

    /**
     * 通过ID获取信息
     *
     * @return
     */
    @ApiOperation(value = "通过ID获取信息", notes = "通过ID获取信息")
    @GetMapping("/getInfoById")
    public BaseResponse<Info> getInfoById(@RequestParam Integer id) {
        Info info = adminTaskService.getInfoById(id);
        if (info == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取事务失败");
        } else {
            return ResultUtils.success(info);
        }
    }

    /**
     * 管理员多条件查询获取事务列表
     *
     * @return
     */
    @ApiOperation(value = "管理员多条件查询获取事务列表", notes = "管理员多条件查询获取事务列表")
    @PostMapping("/getMultiQueryInfoList")
    public BaseResponse<PageInfo<Info>> getAllInfoList(@RequestBody InfoSearchRequestDTO request) {
        System.out.println(request);
        System.out.println(request.getPageNum());
        System.out.println(request.getPageSize());
        PageHelper.startPage(request.getPageNum(), request.getPageSize());

        List<Info> infoList = adminTaskService.getMultiQueryInfoList(request);
        PageInfo<Info> pageInfo = new PageInfo<>(infoList);
        if (infoList == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取事务信息列表失败");
        } else {
            return ResultUtils.success(pageInfo);
        }
    }

    /**
     * 管理员多条件查询获取事务数量
     *
     * @return
     */
    @ApiOperation(value = "管理员多条件查询获取事务数量", notes = "管理员多条件查询获取事务数量")
    @PostMapping("/getMultiQueryInfoCount")
    public BaseResponse<Integer> getInfoCount(@RequestBody InfoSearchRequestDTO request) {
        System.out.println(request);
        Integer count = adminTaskService.getMultiQueryInfoCount(request);
        if (count == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "管理员多条件查询获取事务数量失败");
        } else {
            return ResultUtils.success(count);
        }
    }

    /**
     * 获取网格员事务列表
     *
     * @param inspectorCode
     * @return
     */
    @ApiOperation(value = "获取网格员事务列表", notes = "获取网格员事务列表接口")
    @GetMapping("/getInspectorInfoList")
    public BaseResponse<List<Info>> getInspectorInfoList(@RequestParam String inspectorCode) {
        List<Info> infoList = adminTaskService.getInspectorInfoList(inspectorCode);
        if (infoList == null || infoList.isEmpty()) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取某一网格员事务信息列表失败");
        } else {
            return ResultUtils.success(infoList);
        }
    }

    /**
     * 获取公众监督员事务列表
     *
     * @param supervisorId
     * @return
     */
    @ApiOperation(value = "获取公众监督员事务列表", notes = "获取公众监督员事务列表接口")
    @GetMapping("/getSupervisorInfoList")
    public BaseResponse<List<Info>> getSupervisorInfoList(@RequestParam Integer supervisorId) {
        List<Info> infoList = adminTaskService.getSupervisorInfoList(supervisorId);
        if (infoList == null || infoList.isEmpty()) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取某一公众监督员事务信息列表失败");
        } else {
            return ResultUtils.success(infoList);
        }
    }

    /**
     * 根据info_id获取对应Inspector对象
     *
     * @param infoId
     * @return Inspector对象
     */
    @ApiOperation(value = "根据info_id获取对应Inspector对象", notes = "根据info_id获取对应Inspector对象")
    @GetMapping("/getInspectorByInfoId")
    public BaseResponse<Inspector> getInspectorByInfoId(@RequestParam Integer infoId) {
        Inspector inspector = adminTaskService.getInspectorByInfoId(infoId);
        if (inspector == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "通过infoId获取Inspector对象失败");
        } else {
            return ResultUtils.success(inspector);
        }
    }

    /**
     * 根据info_id获取对应Supervisor对象
     *
     * @param infoId
     * @return Supervisor对象
     */
    @ApiOperation(value = "根据info_id获取对应Supervisor对象", notes = "根据info_id获取对应Supervisor对象")
    @GetMapping("/getSupervisorByInfoId")
    public BaseResponse<Supervisor> getSupervisorByInfoId(@RequestParam Integer infoId) {
        Supervisor supervisor = adminTaskService.getSupervisorByInfoId(infoId);
        if (supervisor == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "通过infoId获取Supervisor对象失败");
        } else {
            return ResultUtils.success(supervisor);
        }
    }
}
