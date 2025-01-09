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
@ApiModel(description = "用户实体类")
public class User {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("openid")
    private String openid;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

}
