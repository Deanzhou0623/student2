package com.roadjava.student.bean.request;/*
 *ClassName:CommonSearchReq
 *Description: student/manager search
 *@Author:deanzhou
 *@Date:2024-01-07 20:23
 */

import com.roadjava.student.bean.constants.Constants;

public class CommonSearchReq {
    /*
    *  page number
    * */
    private Integer pageNow= Constants.DEFAULT_PAGE_NOW;
    /*
    * how many records in a page
    * */
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    /*
    * common search word
    * */
    private String searchWorld;

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchWorld() {
        return searchWorld;
    }

    public void setSearchWorld(String searchWorld) {
        this.searchWorld = searchWorld;
    }
}

