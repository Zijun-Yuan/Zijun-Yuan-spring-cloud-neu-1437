package com.b430.commonmodule.model.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminLoginRequestDTO对象", description = "AdminLoginRequestDTO对象")
public class AdminLoginRequestDTO {
    @ApiModelProperty(value = "管理员账号")
    private String adminCode;

    @ApiModelProperty(value = "管理员密码")
    private String password;
}
