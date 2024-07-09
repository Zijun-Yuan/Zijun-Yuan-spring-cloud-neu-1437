package com.b430.commonmodule.model.dto.inspector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "InspectorSelectDTO对象", description = "InspectorSelectDTO对象")
public class InspectorSelectDTO {

    @ApiModelProperty(value = "页码")
    private Integer pageNum;
    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
    @ApiModelProperty(value = "城市代码列表")
    private List<String> cityCodeList;
    @ApiModelProperty(value = "电话号码")
    private String telNum;
    @ApiModelProperty(value = "推进器")
    private Integer offset;

}
