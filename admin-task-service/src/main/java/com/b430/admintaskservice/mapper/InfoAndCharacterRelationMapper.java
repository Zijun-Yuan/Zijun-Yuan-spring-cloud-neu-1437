package com.b430.admintaskservice.mapper;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Inspector;
import com.b430.commonmodule.model.entity.Supervisor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-06-12
 */
@Mapper
public interface InfoAndCharacterRelationMapper {

    /**
     * 指派事务给inspector网格员
     * @param iId
     * @param infoId
     * @param inspectorId
     * @return boolean是否成功
     */
    boolean assignInspector(@Param("iId") Integer iId,@Param("infoId") Integer infoId,@Param("inspectorId") Integer inspectorId);

    /**
     * supervisor公众监督员上传事务关联表插入
     * @param sId
     * @param infoId
     * @param supervisorId
     * @return
     */
    boolean assignSupervisor(Integer sId, Integer infoId, Integer supervisorId);

    /**
     * 获取info_with_supervisor数据量
     * @return info_with_supervisor表的数据条数
     */
    Integer getInfoWithSupervisorNum();

    /**
     * 获取info_with_inspector数据量
     * @return info_with_inspector表的数据条数
     */
    Integer getInfoWithInspectorNum();

    /**
     * 根据inspector_id获取对应info列表
     * @param inspectorId
     * @return info列表
     */
    List<Info> getInfoByInspectorId(Integer inspectorId);

    /**
     * 根据supervisor_id获取对应info列表
     * @param supervisorId
     * @return info列表
     */
    List<Info> getInfoBySupervisorId(Integer supervisorId);

    /**
     * 根据info_id获取对应inspector对象
     * @param infoId
     * @return inspector对象
     */
    Inspector getInspectorByInfoId(@Param("infoId") Integer infoId);

    /**
     * 根据info_id获取对应supervisor对象
     * @param infoId
     * @return supervisor对象
     */
    Supervisor getSupervisorByInfoId(@Param("infoId") Integer infoId);

    /**
     * 根据i_id获取对应info对象
     * @param iId
     * @return info对象
     */
    Info getInfoByIId(Integer iId);

    /**
     * 根据s_id获取对应info对象
     * @param sId
     * @return info对象
     */
    Info getInfoBySId(Integer sId);

    /**
     * 根据i_id获取对应inspector对象
     * @param iId
     * @return inspector对象
     */
    Inspector getInspectorByIId(Integer iId);

    /**
     * 根据s_id获取对应supervisor对象
     * @param sId
     * @return supervisor对象
     */
    Supervisor getSupervisorBySId(Integer sId);

}
