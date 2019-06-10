package com.djt.ssmdemo.controller;

import com.djt.ssmdemo.Vo.PageVo;
import com.djt.ssmdemo.Vo.R;
import com.djt.ssmdemo.entity.Student;
import com.djt.ssmdemo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;
    @RequestMapping("/addOrUpdate")
    public R update(Student student){
        if(StringUtils.isEmpty(student.getId())){
            return studentInfoService.save(student);
        }
        return studentInfoService.update(student);
    }
    @RequestMapping("/delete")
    public R delete(int id){
        return studentInfoService.delete(id);
    }
    @RequestMapping("/studentList")
    public String studentList(){
        return "/student/studentList";
    }
    @RequestMapping("/List")
    @ResponseBody
    public R studentList(int page, int rows, String name){
        return  studentInfoService.findAll(page,rows,name);
    }
}
