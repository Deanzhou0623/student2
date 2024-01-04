package com.roadjava.student.bean.dto;/*
 *ClassName:JwtManagerDTO
 *Description: what information in the token
               and token will be returned to front-end
 *@Author:deanzhou
 *@Date:2024-01-03 22:46
 */

import lombok.Data;

@Data
public class JwtManagerDTO {

    /*
    * id
    * */
    private Long id;
    /*
    * username
    * */
    private String username;
}
