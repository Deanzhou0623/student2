package com.roadjava.student.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.student.bean.res.Result;

import java.util.List;

/**
 * 分页工具类
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public class PageUtil {
    /**
     * 开始分页
     */
    public static void startPage(Integer pageNow,Integer pageSize) {
        PageHelper.startPage(pageNow,pageSize);
    }

    /**
     * 转换查询结果
     */
    public static <T> Result<List<T>> wrapPageData(List<T> queryList) {
        PageInfo<T> pageInfo = new PageInfo<>(queryList);
        return Result.buildSuccess(queryList,pageInfo.getTotal());
    }

}
