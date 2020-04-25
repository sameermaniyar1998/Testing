package com.example.howtodoinjava.springhystrixstudentservice.controller;

import com.example.howtodoinjava.springhystrixstudentservice.domain.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentServiceController {

    private static Map<String, List<Student>> schoolRepo = new HashMap<String, List<Student>>();

    static {
        schoolRepo = new HashMap<String, List<Student>>();

        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student("Sajal", "Class IV");
        studentList.add(student);
        student = new Student("Lokesh", "Class V");
        studentList.add(student);

        schoolRepo.put("abcschool", studentList);

        studentList = new ArrayList<Student>();
        student = new Student("Kajal", "Class III");
        studentList.add(student);
        student = new Student("Sukesh", "Class VI");
        studentList.add(student);

        schoolRepo.put("xyzschool", studentList);

    }

    @RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname)  throws Exception{
        Thread.sleep(3000);
        System.out.println("Getting Student details for " + schoolname);

        List<Student> studentList = schoolRepo.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student student = new Student("Not Found", "N/A");
            studentList.add(student);
        }
        return studentList;
    }
}


