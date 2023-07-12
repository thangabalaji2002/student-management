package com.example.StudentCrud.services;

import java.util.List;



import com.example.StudentCrud.domain.Student;

public interface StudentService {
	List<Student>getallstudents();
	Student savestudent(Student student);
	Student getbyid(Long id );
	Student updatestudent (Student student);
	void  deletestudent(Long id);
}
