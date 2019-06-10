package com.djt.ssmdemo.dao;

import com.djt.ssmdemo.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoDAO {
    List<Student> findAll(int pageNow, int pageSize, @Param("name") String name);
    Student findById(Integer id);
    int insert(Student student);
    int update(Student student);
    int delete(Integer id);
    int findCount(@Param("name") String name);
}
