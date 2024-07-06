package com.b430.commonmodule.model.dto.inspector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "InspectorLoginRequest", description = "网格员登录请求参数")
public class InspectorLoginRequestDTO {
    @ApiModelProperty(value = "网格员登录编号", required = true)
    private String inspectorCode;

    @ApiModelProperty(value = "网格员登录密码", required = true)
    private String password;
}
