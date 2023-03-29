package com.eleazer.crud.demo;

import com.eleazer.crud.demo.dao.StudentDAO;
import com.eleazer.crud.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();

		//print number of rows deleted
		System.out.println("Number of rows deleted: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		//change first name to "scooby"
		System.out.println("Updating student");
		student.setFirstName("Emmanuel");


		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Afotey");

		//display list of students
		for(Student student: theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display the students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating the student object...");
		Student tempStudent = new Student("Dafft", "Ryler", "dafft.ryler@gmail.com");

		//save the student
		studentDAO.save(tempStudent);

		//display id of the student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		//retrieve student based on the id:primary key
		System.out.println("Retrieving student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		//display student
		System.out.println("Found the student" + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple student objects
		Student tempStudent1 = new Student("Marc ", "Stone", "marc.stone@gmail.com");
		Student tempStudent2 = new Student("Don ", "Rock", "bonifac@gmail.com");
		Student tempStudent3 = new Student("Arianna ", "Burford", "ari.burford@gmail.com");

		//saving students to the database
		System.out.println("Saving students to thhe database");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display the id of the student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		Student tempStudent = new Student("Eleazer ", "Afotey", "eleazerallnice@gmail.com");

		//save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);

		//display the id of the student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
