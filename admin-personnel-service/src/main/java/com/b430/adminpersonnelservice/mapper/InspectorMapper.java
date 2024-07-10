package com.b430.adminpersonnelservice.mapper;

import com.b430.commonmodule.model.dto.inspector.InspectorSelectDTO;
import com.b430.commonmodule.model.entity.Inspector;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-06-07
 */
@Mapper
public interface InspectorMapper extends BaseMapper<Inspector> {

    /**
     * 根据inspector_code查询Inspector
     *
     * @param inspectorCode 网格员登录编码
     * @return Inspector对象
     */
    Inspector selectByInspectorCode(String inspectorCode);

    /**
     * 根据inspector_id查询Inspector
     *
     * @param inspectorId
     * @return Inspector对象
     */
    Inspector selectByInspectorId(Integer inspectorId);

    /**
     * 查询所有未删除的Inspector
     *
     * @return 未删除的Inspector列表
     */
    List<Inspector> selectAllNotDeleted();

    /**
     * 插入Inspector
     *
     * @param inspector Inspector对象
     */
    void insertInspector(Inspector inspector);

    /**
     * 更新Inspector
     *
     * @param inspector Inspector对象
     */
    void updateInspector(Inspector inspector);

    /**
     * 根据inspector_id软删除Inspector
     *
     * @param inspectorId 网格员编号
     */
    void softDeleteInspector(Integer inspectorId);

    /**
     * 根据cityCodeList查询Inspector列表
     *
     * @param cityCodeList 城市编码列表
     * @return Inspector列表
     */
    List<Inspector> selectByCityCodeList(@Param("cityCodeList") List<String> cityCodeList);

    /**
     * 通过电话号码和city模糊查询网格员数量
     *
     * @param inspectorSelectDTO
     * @return 查询后的Inspector数量
     */
    Integer getInspectorNum(InspectorSelectDTO inspectorSelectDTO);

    /**
     * 获取查询后的网格员分页列表
     *
     * @param inspectorSelectDTO
     * @return 查询后的Inspector列表
     */
    List<Inspector> getInspectorList(@Param("inspectorSelectDTO") InspectorSelectDTO inspectorSelectDTO);


}
