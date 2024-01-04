package com.roadjava.student.bean.vo;/*
 *ClassName:JwtManagerVO
 *Description: 
 *@Author:deanzhou
 *@Date:2024-01-03 22:29
 */

import com.roadjava.student.bean.dto.JwtManagerDTO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JwtManagerVO  extends JwtManagerDTO {
    private String token;
}
