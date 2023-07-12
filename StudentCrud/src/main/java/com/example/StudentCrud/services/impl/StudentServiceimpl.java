package com.example.StudentCrud.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.repository.StudentRepository;
import com.example.StudentCrud.services.StudentService;

@Service
public class StudentServiceimpl implements StudentService {
	
	private StudentRepository studentrepository;
	
	public StudentServiceimpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	} 
	@Override
	@Transactional
	public List<Student>getallstudents(){
		return studentrepository.findAll();
}
	@Override
	public Student savestudent(Student student) {
	return studentrepository.save(student);
	
	}
	@Override
	public Student getbyid(Long id) {
		
		return studentrepository.findById(id).get();
	}
	@Override
	public Student updatestudent(Student student) {
		
		return studentrepository.save(student);
	}
	@Override
	public void deletestudent(Long id) {
		studentrepository.deleteById(id);
		
	}
	
}
