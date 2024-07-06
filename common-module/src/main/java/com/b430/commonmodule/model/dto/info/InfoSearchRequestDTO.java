package com.b430.commonmodule.model.dto.info;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("info_search_request")
@ApiModel(value = "InfoSearchRequestDTO对象", description = "InfoSearchRequestDTO对象")
public class InfoSearchRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;
    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
    @ApiModelProperty(value = "城市代码列表")
    private List<String> cityCode;
    @ApiModelProperty(value = "污染等级")
    private Integer aqiLevel;
    @ApiModelProperty(value = "监督员上报时间")
    private Date timeSupervisor;
    @ApiModelProperty(value = "网格员上报时间")
    private Date timeInspector;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "监督员名称")
    private String supervisorName;
    @ApiModelProperty(value = "网格员名称")
    private String inspectorName;

}
