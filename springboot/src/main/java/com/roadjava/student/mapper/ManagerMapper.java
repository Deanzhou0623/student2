package com.roadjava.student.mapper;/*
 *ClassName:ManagerMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-28 22:36
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.student.bean.entity.ManagerDO;

public interface ManagerMapper extends BaseMapper<ManagerDO> {

    /*
    * select by username && id
    * */
//    ManagerDO selectUser(LambdaQueryWrapper<ManagerDO> lqw);
}
