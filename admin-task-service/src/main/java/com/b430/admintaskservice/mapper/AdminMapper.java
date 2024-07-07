package com.b430.admintaskservice.mapper;


import com.b430.commonmodule.model.entity.Admin;
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
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 根据admin_code查询Admin
     *
     * @param adminCode 系统管理员登录编码
     * @return Admin对象
     */
    Admin selectByAdminCode(String adminCode);

    /**
     * 查询所有Admin
     *
     * @return Admin列表
     */
    List<Admin> selectAllAdmins();

    /**
     * 插入Admin
     *
     * @param admin Admin对象
     */
    void insertAdmin(Admin admin);

    /**
     * 更新Admin
     *
     * @param admin Admin对象
     */
    void updateAdmin(Admin admin);

}
