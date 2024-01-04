package com.roadjava.student.handler;/*
 *ClassName:StudentHandler
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 23:00
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentHandler {

    
    /*
    * 根据id查询
    * */
    @GetMapping("/selectById")
    public String selectById(Long id){
        return  "1234";
    }

}
