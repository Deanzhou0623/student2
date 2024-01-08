package com.roadjava.student.util;/*
 *ClassName:pageUtil
 *Description: Paging tool
 *@Author:deanzhou
 *@Date:2024-01-07 20:39
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.student.bean.res.Result;

import java.util.List;

public class PageUtil {

    /*
    * start page
    * */
    public static void startPage(Integer pageNow,Integer pageSize){
        PageHelper.startPage(pageNow,pageSize);
    }

    /*
    * convert result to page
    * */
    public  static <T> Result<List<T>> wrapPageData(List<T> queryList){
        PageInfo<T> pageInfo = new PageInfo<>(queryList);
        return Result.buildSuccess(queryList, pageInfo.getTotal());
    }
}
