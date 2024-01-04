package com.roadjava.student.service;

import com.roadjava.student.bean.req.CommonSearchReq;
import com.roadjava.student.bean.req.LoginReq;
import com.roadjava.student.bean.req.StudentAddReq;
import com.roadjava.student.bean.req.StudentUpdateReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;
import com.roadjava.student.bean.vo.StudentVO;

import java.util.List;

public interface StudentService {
   /**
    * 新增学生
    */
   void add(StudentAddReq addReq);

   /**
    * 学生的分页查询
    */
   Result<List<StudentVO>> selectPage(CommonSearchReq searchReq);

   void deleteById(Long id);

   Result<StudentVO> selectById(Long id);

   void updateById(StudentUpdateReq updateReq);

   Result<List<StudentVO>> selectAll();

}
