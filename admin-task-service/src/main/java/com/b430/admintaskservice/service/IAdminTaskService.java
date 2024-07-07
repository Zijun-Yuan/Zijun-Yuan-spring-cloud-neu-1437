package com.b430.admintaskservice.service;


import com.b430.commonmodule.model.dto.info.InfoSearchRequestDTO;
import com.b430.commonmodule.model.entity.Admin;
import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;

import java.util.List;

public interface IAdminTaskService {

    /**
     * 管理员登录
     * @param adminCode 账号
     * @param password 密码
     * @return
     */
    Admin login(String adminCode, String password);

    /**
     * 管理员指派网格员处理事务
     * @param infoId 事务ID
     * @param inspectorId 网格员ID
     * @return
     */
    boolean setInfoToInspector(Integer infoId, Integer inspectorId);

    /**
     * 管理员多条件查询获取事务列表
     * @return
     */
    List<Info> getMultiQueryInfoList(InfoSearchRequestDTO infoSearchRequestDTO);

    /**
     * 管理员多条件查询获取事务数量
     * @return
     */
    Integer getMultiQueryInfoCount(InfoSearchRequestDTO infoSearchRequestDTO);

//    /**
//     * 管理员获取指定状态的事务数量
//     * @param status
//     * @return
//     */
//    Integer getInfoCountByStatus(Integer status);

    /**
     * 管理员获取指定信息
     * @return
     */
    Info getInfoById(Integer id);

//    /**
//     * 管理员根据状态查看列表
//     * @return
//     */
//    List<Info> getInfoListByStatus(Integer status);


    /**
     * 管理员查看对应网格员事务
     * @param inspectorCode 网格员ID
     * @return
     */
    List<Info> getInspectorInfoList(String inspectorCode);

    /**
     * 管理员查看对应公众监督员事务
     * @param supervisorId 公众监督员ID
     * @return
     */
    List<Info> getSupervisorInfoList(Integer supervisorId);

    /**
     * 根据info_id获取对应Inspector对象
     * @param infoId
     * @return Inspector对象
     */
    Inspector getInspectorByInfoId(Integer infoId);

    /**
     * 根据info_id获取对应Supervisor对象
     * @param infoId
     * @return Supervisor对象
     */
    Supervisor getSupervisorByInfoId(Integer infoId);
}
