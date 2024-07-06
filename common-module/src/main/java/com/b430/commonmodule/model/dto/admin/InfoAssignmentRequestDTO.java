package com.b430.commonmodule.model.dto.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "指派网格员信息DTO", description = "指派网格员信息DTO")
public class InfoAssignmentRequestDTO {
    @ApiModelProperty(value = "信息ID")
    private Integer infoId;

    @ApiModelProperty(value = "网格员ID")
    private Integer inspectorId;
}
