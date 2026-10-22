package com.bharath.Docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AddStudents implements CommandLineRunner
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println(studentRepository.count());
        if(studentRepository.count() > 0)
        {
            return;
        }

        List<Student> s = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("Bharath");
        student1.setMarks(20);
        student1.setId(1);
        s.add(student1);

        Student student2 = new Student();
        student2.setName("Raghu");
        student2.setMarks(30);
        student2.setId(2);
        s.add(student2);

        Student student3 = new Student();
        student3.setName("pavan");
        student3.setMarks(32);
        student3.setId(3);
        s.add(student3);

        studentRepository.saveAll(s);
    }
}
