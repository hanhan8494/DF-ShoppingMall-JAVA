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
@ApiModel(description = "分类实体类")
public class Sort {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
