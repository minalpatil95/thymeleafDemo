package com.minal.springweb.thymeleafdemo.controllers;

import com.minal.springweb.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    //send text data from controller to template
    @RequestMapping("/sendData")
    public ModelAndView sendData() {
        ModelAndView mav = new ModelAndView("data"); // data is a template i.e html file which will be rendered in UI
        mav.addObject("message", "Data sent successfully from controller to View");
        return mav;
    }

    //send object or model class from controller to template
    @RequestMapping("/student")
    public ModelAndView getStudent() {
        ModelAndView mav = new ModelAndView("student"); // student.html
        Student student = new Student();
        student.setName("Minal");
        student.setScore(100);
        mav.addObject("student", student);
        return mav;
    }

    //Rendering multiple objects
    @RequestMapping("/students")
    public ModelAndView getStudents() {
        ModelAndView mav = new ModelAndView("studentList"); // studentList.html
        Student student = new Student();
        student.setName("Minal");
        student.setScore(100);
        Student student2 = new Student();
        student2.setName("Mohit");
        student2.setScore(200);

        List<Student> students = Arrays.asList(student, student2);
        mav.addObject("students", students);
        return mav;
    }

    //create student form
    @RequestMapping("/studentForm")
    public ModelAndView displayStudentForm() {
        ModelAndView mav = new ModelAndView("studentForm"); // student.html
        Student student = new Student();
        student.setName("Minal");
        student.setScore(100);
        mav.addObject("student", student);
        return mav;
    }

    //process student form values
    @RequestMapping("/saveStudent")
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        ModelAndView mav = new ModelAndView("result"); // student.html
        System.out.println(student.getName());
        System.out.println(student.getScore());
        return mav;
    }
}
