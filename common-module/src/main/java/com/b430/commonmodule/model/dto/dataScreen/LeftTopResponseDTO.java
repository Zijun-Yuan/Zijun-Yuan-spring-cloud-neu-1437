package com.b430.commonmodule.model.dto.dataScreen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "数据大屏左上返回值DTO", description = "数据大屏左上返回值DTO")
public class LeftTopResponseDTO {
    @ApiModelProperty(value = "信息总数")
    private Integer InfoTotal;
    @ApiModelProperty(value = "公众监督信息数量")
    private Integer InfoSupervisorCount;
    @ApiModelProperty(value = "网格员反馈信息数量")
    private Integer InfoInspectorCount;
    @ApiModelProperty(value = "污染超标数量")
    private Integer ExceedTotal;
}
