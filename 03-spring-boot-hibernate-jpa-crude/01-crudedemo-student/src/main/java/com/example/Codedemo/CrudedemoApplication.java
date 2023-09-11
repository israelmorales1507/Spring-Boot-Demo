package com.example.Codedemo;

import com.example.Codedemo.DAO.StudentDAO;
import com.example.Codedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		System.out.println("Deleted row count: "+studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		System.out.println("Getting student with id: "+ 4);
		Student student = studentDAO.findById(4);
		// change firts name to "Scooby"
		System.out.println("Update student...");
		student.setFirstName("Asmet");
		// update the student
		studentDAO.update(student);
		// display the update student
		System.out.println("Updated Student: "+ student);
	}

	private void queryForStudentsLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.finByLastName("Asmet");
		// display list of students
		students.forEach(x -> {
			System.out.println(x.toString());
		});
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.finAll();
		// display a list of students
		students.forEach( x -> {
			System.out.println(x.toString());
		});
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tmp = new Student("Asmet","Morales", "a@a.com");
		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tmp);
		// display id of the saved student
		System.out.println("Save student. Genarated id: "+ tmp.getId());
		// retrieve student bases on the id: primary key
		System.out.println("Found student with id: " + tmp.getId());
		Student res = studentDAO.findById(tmp.getId());
		// display student
		System.out.println("Found the student: "+res);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tmp = new Student("Israel","Morales", "a@a.com");
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tmp);

		// display id of the saved student
		System.out.println("Save student. Genarated id: "+ tmp.getId());
	}
}
