package com.roadjava.student.bean.req;

import com.roadjava.student.bean.constants.Constants;
import lombok.Data;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class CommonSearchReq {
    /**
     * 当前要查询第几页
     */
    private Integer pageNow = Constants.DEFAULT_PAGE_NOW;
    /**
     * 每页的大小
     */
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    /**
     * 通用的搜索词
     */
    private String searchWord;
}
