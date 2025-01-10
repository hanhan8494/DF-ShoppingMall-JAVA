package com.itcast.admin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "秒杀实体类")
public class Seckill {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("秒杀名称")
    private String name;

    @ApiModelProperty("价格")
    private double price;

    @ApiModelProperty("秒杀开始时间")
    private LocalDateTime createTime;

    @ApiModelProperty("秒杀结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("商品id")
    private Long dityId;

    @ApiModelProperty("秒杀状态")
    private Long status;

}
