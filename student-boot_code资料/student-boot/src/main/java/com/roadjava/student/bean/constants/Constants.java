package com.roadjava.student.bean.constants;

import java.nio.charset.StandardCharsets;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface Constants {
    String USER_TOKEN_KEY = "user_token";
    String UTF_8_NAME = StandardCharsets.UTF_8.name();
    Integer DEFAULT_PAGE_NOW = 1;
    Integer DEFAULT_PAGE_SIZE = 10;
}
