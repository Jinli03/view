/**
 * 功能：
 * 作者：JInli
 * 日期： 2024/3/2 15:16
 */
package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("tables")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tables {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String school;
    private String sub;
    private Integer subcode;
    private String city;
    private String square;
    private Integer person23;
    private Integer reperson23;
    private Integer rescore23;
    private Integer person22;
    private Integer reperson22;
    private Integer rescore22;
    private Integer person21;
    private Integer reperson21;
    private Integer rescore21;
    @TableField(exist = false)
    private Integer userId;
    @TableField(exist = false)
    private String user;
}
