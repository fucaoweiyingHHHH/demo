package com.djt.ssmdemo.service;

import com.djt.ssmdemo.Vo.R;
import com.djt.ssmdemo.dao.StudentInfoDAO;
import com.djt.ssmdemo.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentInfoService {
    @Resource
    private StudentInfoDAO studentInfoDAO;

    public R findAll(int pageNow,int pageSize,String name){
        if(pageNow>1){
           int page = (pageNow-1)*pageSize;
            pageNow= page;
        }
        R r=new R();
        r.setTotal(studentInfoDAO.findCount(name));
        r.setData(studentInfoDAO.findAll(pageNow,pageSize,name));
        return r;
    }

    public Student findById(Integer id){
        return studentInfoDAO.findById(id);
    }

    public R save(Student student){
        R r=new R();
        r.setData(studentInfoDAO.insert(student));
        r.setCode(200);
        r.setMsg("成功");
        return r;
    }

    public R update(Student student){
        R r=new R();
        r.setData(studentInfoDAO.update(student));
        r.setCode(200);
        r.setMsg("成功");
        return r;
    }

    public R delete(Integer id) {
        R r = new R();
        r.setData(studentInfoDAO.delete(id));
        r.setCode(200);
        r.setMsg("成功");
        return r;
    }
}
