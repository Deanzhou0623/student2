package com.roadjava.student.context;/*
 *ClassName:ManagerContext
 *Description: TODO
 *@Author:deanzhou
 *@Date:2024-01-06 22:43
 */

import com.roadjava.student.bean.dto.JwtManagerDTO;

public class ManagerContext {
    private static ThreadLocal<JwtManagerDTO> threadLocal = new ThreadLocal<>();
    public static void set(JwtManagerDTO dto) {
        threadLocal.set(dto);
    }
    public static JwtManagerDTO get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
