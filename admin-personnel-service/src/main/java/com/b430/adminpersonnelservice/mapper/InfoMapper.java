package com.b430.adminpersonnelservice.mapper;

import com.b430.commonmodule.model.dto.info.InfoSearchRequestDTO;
import com.b430.commonmodule.model.entity.Info;
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
public interface InfoMapper extends BaseMapper<Info> {

    /**
     * 根据城市代码查询Info
     * @param cityCode 城市代码
     * @return Info对象列表
     */
    List<Info> selectByCityCode(String cityCode);

    /**
     * 根据多条件查询Info列表
     * @return Info对象列表
     */
    List<Info> selectMultiQuery(InfoSearchRequestDTO infoSearchRequestDTO);


    /**
     * 插入Info
     * @param info Info对象
     */
    void insertInfo(Info info);

    /**
     * 更新Info
     * @param info Info对象
     */
    void updateInfo(Info info);

    /**
     * 根据多条件获取info数据表数量
     * @return info数据条数
     */
    Integer getMultiQueryInfoNum(InfoSearchRequestDTO infoSearchRequestDTO);

    /**
     * 获取info数据表数据量
     * @return
     */
    Integer getInfoNum();

    /**
     * 获取info数据表列表
     * @return
     */
    List<Info> getInfoList();

    /**
     * 公众监督员反馈事务信息
     * @param info
     * @param infoCount
     */
    void addInfo(Info info, Integer infoCount);

    /**
     * 添加关联信息
     * @param infoCount
     * @param relateCount
     * @param supervisorId
     */
    void addRelate(Integer infoCount, Integer relateCount, Integer supervisorId);

    /**
     * 根据网格员Id查询Info
     * @param inspectorCode inspectorId的id
     */
    List<Info> selectByInspectorCode(String inspectorCode);

    /**
     * 根据大众监督员Id查询Info
     * @param supervisorId
     * @return
     */
    List<Info> selectBySupervisorId(Integer supervisorId);

    /**
     * 管理员获取指定信息
     * @return
     */
    Info getInfoById(Integer id);

    /**
     * 更新监督员姓名
     * @param
     */
    void updateInfoSupervisorName(Integer supervisorId, String supervisorName);

    /**
     * 更新网格员姓名
     * @param
     */
    void updateInfoInspectorName(Integer inspectorId, String inspectorName);

}
