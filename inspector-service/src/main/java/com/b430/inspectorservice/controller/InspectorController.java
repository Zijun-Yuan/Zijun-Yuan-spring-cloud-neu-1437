package com.b430.inspectorservice.controller;


import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.dto.inspector.InspectorLoginRequestDTO;
import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.util.JwtUtil;
import com.b430.inspectorservice.service.IInspectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Api(tags = "网格员接口")
@RestController
@RequestMapping("/inspector")
public class InspectorController {

    @Autowired
    private IInspectorService inspectorService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 网格员登录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "网格员登录", notes = "网格员登录")
    @PostMapping("/login")
    public BaseResponse<Inspector> login(@RequestBody InspectorLoginRequestDTO request) {
//        Inspector inspector = inspectorService.login(request.getInspectorCode(), request.getPassword());
//        if (inspector != null){
//            session.setAttribute("inspector", inspector);
//            return ResultUtils.success(inspector);
//        }else {
//            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "InspectorLogin failed");
//        }
        Inspector inspector = inspectorService.login(request.getInspectorCode(), request.getPassword());
        if (inspector != null) {
            String token = JwtUtil.getToken(request.getInspectorCode(), "Inspector", "inspector-issuer");
            String redisKey = "Inspector:" + request.getInspectorCode();
            redisTemplate.opsForValue().set(redisKey, token, 1, TimeUnit.DAYS);
            inspector.setToken(token);
            return ResultUtils.success(inspector);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "网格员登录失败");
        }

    }

    /**
     * 网格员获取详细事务信息
     *
     * @param infoId
     * @return
     */
    @ApiOperation(value = "网格员获取详细事务信息", notes = "网格员获取详细事务信息")
    @GetMapping("/getDetailedInfo")
    public BaseResponse<Info> getDetailedInfo(@RequestParam Integer infoId) {
        Info info = inspectorService.getDetailedInfo(infoId);
        return ResultUtils.success(info);
    }

    /**
     * 网格员反馈实时数据信息
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "网格员反馈实时数据信息", notes = "网格员反馈实时数据信息")
    @PostMapping("/feedbackInfo")
    public BaseResponse<Boolean> feedbackInfo(@RequestBody Info info) {
        if (inspectorService.feedbackInfo(info)) {
            return ResultUtils.success(true);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "Feedback failed");
        }
    }

    /**
     * 网格员获取对应事务列表
     *
     * @param inspectorCode
     * @return
     */
//    @CrossOrigin(origins = "http://localhost:8080")
    @ApiOperation(value = "网格员获取对应事务列表", notes = "网格员获取对应事务列表")
    @GetMapping("/getInfoList")
    public BaseResponse<List<Info>> getInfoList(@RequestParam String inspectorCode) {
        List<Info> infoList = inspectorService.getInfoList(inspectorCode);
        return ResultUtils.success(infoList);
    }

    /**
     * 网格员根据账户获取自己
     *
     * @param inspectorCode
     * @return
     */
    @ApiOperation(value = "网格员根据账户获取自己", notes = "网格员根据账户获取自己")
    @GetMapping("/getInspectorByCode")
    public BaseResponse<Inspector> getInspectorByCode(@RequestBody String inspectorCode) {
        Inspector inspector = inspectorService.getInspectorByCode(inspectorCode);
        if (inspector == null) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "Inspector is null");
        } else {
            return ResultUtils.success(inspector);
        }
    }

}
