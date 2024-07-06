package com.b430.commonmodule.model.dto.supervisor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "监督员登录请求参数", description = "网格员登录请求参数")
public class SupervisorLoginRequestDTO {
    @ApiModelProperty(value = "监督员账号")
    private String telId;
    @ApiModelProperty(value = "监督员密码")
    private String password;

}
