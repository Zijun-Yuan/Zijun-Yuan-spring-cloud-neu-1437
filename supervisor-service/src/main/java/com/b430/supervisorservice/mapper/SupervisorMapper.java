package com.b430.supervisorservice.mapper;

import com.b430.commonmodule.model.entity.Info;
import com.b430.commonmodule.model.entity.Supervisor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-06-07
 */
@Mapper
public interface SupervisorMapper extends BaseMapper<Supervisor> {

    /**
     * 根据tel_id查询Supervisor
     * @param telId 公众监督员编号（手机号码）
     * @return Supervisor对象
     */
    Supervisor selectByTelId(String telId);

    /**
     * 根据supervisor_id查询Supervisor
     * @param supervisorId
     * @return Supervisor对象
     */
    Supervisor selectBySupervisorId(Integer supervisorId);

    /**
     * 查询所有未删除的Supervisor
     * @return 未删除的Supervisor列表
     */
    List<Supervisor> selectAllNotDeleted();

    /**
     * 插入Supervisor
     * @param supervisor Supervisor对象
     */
    void insertSupervisor(Supervisor supervisor);

    /**
     * 更新Supervisor
     * @param supervisor Supervisor对象
     */
    void updateSupervisor(Supervisor supervisor);

    /**
     * 根据Supervisor_id查询对应事务列表
     * @param supervisorId
     */
    List<Info> getInfoListToSupervisor(Integer supervisorId);

    /**
     * 根据info_id查询详细的事务信息
     * @param infoId
     * @return 详细事务数据
     */
    Info getDetailedInfo(Integer infoId);

    /**
     * 通过name查id
     * @param supervisorName
     * @return id
     */
    Integer getSupervisorIdByName(String supervisorName);

}
