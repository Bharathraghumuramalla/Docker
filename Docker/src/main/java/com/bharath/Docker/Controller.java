package com.bharath.Docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Controller
{

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getStudents")
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student s)
    {
        studentRepository.save(s);
        return "Added successfully";
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/updateStudent/")
    public String updateStudent(@RequestBody Student student)
    {
        Student s = studentRepository.findById(student.getId()).orElseThrow(()-> new RuntimeException("User Not Found"));
        if(student.getMarks() != null)
        {
            s.setMarks(student.getMarks());
        }
        if(student.getName() != null)
        {
            s.setName(student.getName());
        }
        studentRepository.save(s);
        return "Updated Successfully";
    }




}
