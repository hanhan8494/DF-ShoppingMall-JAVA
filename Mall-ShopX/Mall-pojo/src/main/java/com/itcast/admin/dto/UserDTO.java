package com.itcast.admin.dto;

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
@ApiModel(description = "新增或修改用户数据")
public class UserDTO {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("头像")
    private String avatar;

}
