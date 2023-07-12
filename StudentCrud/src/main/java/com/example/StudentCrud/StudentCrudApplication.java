package com.example.StudentCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.repository.StudentRepository;


@SpringBootApplication

public class StudentCrudApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentrepository;
	public static void main(String[] args) {
		SpringApplication.run(StudentCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 =new Student("mahendra","dhoni","dhoni@gmail.com");
		studentrepository.save(student1);
		Student student2 =new Student("ashok","kumar","ashok@gmail.com");
		studentrepository.save(student2);
		Student student3 =new Student("saran","balaji","saranbalaji@gmail.com");
		studentrepository.save(student3);
		
		
	}

}
