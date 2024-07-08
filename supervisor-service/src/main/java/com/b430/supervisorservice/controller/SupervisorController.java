package com.b430.supervisorservice.controller;


import com.b430.commonmodule.common.BaseResponse;
import com.b430.commonmodule.common.ErrorCode;
import com.b430.commonmodule.common.ResultUtils;
import com.b430.commonmodule.model.dto.supervisor.SupervisorLoginRequestDTO;
import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Supervisor;
import com.b430.commonmodule.util.JwtUtil;
import com.b430.supervisorservice.service.ISupervisorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Api(tags = "公众监督员相关接口")
@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private ISupervisorService supervisorService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 公众监督员登录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "公众监督员登录", notes = "输入监督员编号和密码进行登录")
    @PostMapping("/login")
    public BaseResponse<Supervisor> login(@RequestBody SupervisorLoginRequestDTO request) {
//        Supervisor supervisor = supervisorService.login(request.getTelId(), request.getPassword());
//        if (supervisor != null){
//            session.setAttribute("supervisor", supervisor);
//            return ResultUtils.success(supervisor);
//        }else {
//            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "SupervisorLogin failed");
//        }
        Supervisor supervisor = supervisorService.login(request.getTelId(), request.getPassword());
        if (supervisor != null) {
            String token = JwtUtil.getToken(request.getTelId(), "Supervisor", "supervisor-issuer");
            String redisKey = "Supervisor:" + request.getTelId();
            redisTemplate.opsForValue().set(redisKey, token, 1, TimeUnit.DAYS);
            supervisor.setToken(token);
            return ResultUtils.success(supervisor);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "监督员登录失败");
        }

    }

    /**
     * 公众监督员注册
     *
     * @param supervisor
     * @return
     */
    @ApiOperation(value = "公众监督员注册", notes = "输入监督员信息进行注册")
    @PostMapping("/register")
    public BaseResponse<Boolean> register(@RequestBody Supervisor supervisor) {
        if (supervisorService.register(supervisor)) {
            System.out.println("SupervisorRegister success");
            return ResultUtils.success(true);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "SupervisorRegister failed");
        }
    }

    /**
     * 公众监督员退出登录
     *
     * @param session
     * @return
     */
    @ApiOperation(value = "公众监督员退出登录", notes = "退出当前登录的公众监督员")
    @PostMapping("/logout")
    public BaseResponse<Boolean> logout(HttpSession session) {
        // 使当前会话失效
        session.invalidate();
        return ResultUtils.success(true);
    }

    /**
     * 根据用户id查询公众监督员信息
     *
     * @param telId
     * @return
     */
    @ApiOperation(value = "根据用户id查询公众监督员信息", notes = "输入监督员电话号码查询监督员信息")
    @GetMapping("/getSupervisorByTelId")
    public BaseResponse<Supervisor> getSupervisorByTelId(@RequestParam String telId) {
        Supervisor supervisor = supervisorService.getSupervisorByTelId(telId);
        return ResultUtils.success(supervisor);
    }

    /**
     * 编辑公众监督员个人信息
     *
     * @param supervisor
     * @return
     */
    @ApiOperation(value = "编辑公众监督员个人信息", notes = "输入监督员信息进行编辑")
    @PostMapping("/editPersonal")
    public BaseResponse<Boolean> editPersonal(@RequestBody Supervisor supervisor) {
        System.out.println("SupervisorEditPersonal: " + supervisor.toString());
        if (supervisorService.editPersonal(supervisor)) {
            return ResultUtils.success(true);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "SupervisorEditPersonal failed");
        }
    }

    /**
     * 查询公众监督员历史反馈信息列表
     *
     * @param supervisorId
     * @return
     */
    @ApiOperation(value = "查询公众监督员历史反馈信息列表", notes = "输入监督员编号查询历史反馈信息列表")
    @GetMapping("/getAllFeedbackList")
    public BaseResponse<List<Info>> getAllFeedbackList(@RequestParam Integer supervisorId) {
        List<Info> feedbackList = supervisorService.getAllFeedbackList(supervisorId, "time_supervisor");
        return ResultUtils.success(feedbackList);
    }

    /**
     * 公众监督员反馈监督信息
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "公众监督员反馈监督信息", notes = "输入监督信息进行反馈")
    @PostMapping("/addInfo")
    public BaseResponse<Boolean> addInfo(@RequestBody Info info) {
        if (supervisorService.addInfo(info)) {
            return ResultUtils.success(true);
        } else {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "SupervisorAddInfo failed");
        }
    }
}
