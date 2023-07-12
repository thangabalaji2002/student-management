package com.example.StudentCrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.services.StudentService;



@Controller
public class StudentController {

	private StudentService studentservice;
	
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	} 
	@GetMapping("/students")
	public String ListStudents(Model model) {
		model.addAttribute("students",studentservice.getallstudents());
		
		return "students";
}
	@GetMapping("/students/new")
	public String addstudent(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "createstudent";
		
	}
	@PostMapping("/students")
	public String savestudents(@ModelAttribute("student") Student student) {
		
		studentservice.savestudent(student);
	
		return "redirect:/students";
		
	}
	@GetMapping("/students/edit/{id}")
	public String editstudent(@PathVariable Long id,Model model ) {
	model.addAttribute("student",studentservice.getbyid(id));
	return "editstudent";
		
	}
	@PostMapping("/students/{id}")
	public String updatestudent(@PathVariable Long id ,@ModelAttribute("student") Student student) {
		Student existingstudent=studentservice.getbyid(id);
		existingstudent.setId(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		studentservice.savestudent(existingstudent);
		return "redirect:/students";
		
	}
	@GetMapping("/students/{id}")
	 public String  deleteStudent(@PathVariable Long id) {
		studentservice.deletestudent(id);
		return "redirect:/students";
		
	}

}
