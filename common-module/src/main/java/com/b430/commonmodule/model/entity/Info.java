package com.b430.commonmodule.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "info")
@Accessors(chain = true)
@TableName("info")
@ApiModel(value="Info对象", description="")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "信息id")
    @Id
    private Integer infoId;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "0已删除 1公众监督员supervisor已提交 2已指派网格员inspector 3网格员inspector已填写")
    private Integer status;

    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "aqi等级1-6")
    private Integer aqiLevel;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "城市代码")
    private String cityCode;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "详细地址")
    private String address;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "反馈信息")
    private String feedback;

    @Field(type = FieldType.Date,format = {},
            pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd'T'HH:mm:ss'+08:00' || strict_date_optional_time || epoch_millis")
    @ApiModelProperty(value = "反馈时间（公众监督员）")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeSupervisor;

    @Field(type = FieldType.Date,format = {},
            pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd'T'HH:mm:ss'+08:00' || strict_date_optional_time || epoch_millis")
    @ApiModelProperty(value = "反馈时间（网格员监督员）")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeInspector;

    @Field(type = FieldType.Double)
    @ApiModelProperty(value = "so2浓度")
    private Double so2;

    @Field(type = FieldType.Double)
    @ApiModelProperty(value = "co浓度")
    private Double co;

    @Field(type = FieldType.Double)
    @ApiModelProperty(value = "臭氧")
    private Double o3;

    @Field(type = FieldType.Double)
    @ApiModelProperty(value = "pm2.5浓度")
    private Double pm25;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "公众监督员姓名")
    private String supervisorName;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "网格员姓名")
    private String inspectorName;

    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "aqi实际值")
    private Integer aqiReal;

}
