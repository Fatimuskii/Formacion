package com.formacion.practica4MVC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.practica4MVC.entities.Student;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Integer> {

	
	public Student findByEmail(String email);
	
	//private static Map<String, Student> repo = new HashMap<>();

	/*static {

		Student student;

		student = new Student();
		student.setId("1");
		student.setName("Bethanie G. Addams");
		student.setEmail("Bethanie.Adams@oneself.io");
		repo.put(student.getId(), student);

		student = new Student();
		student.setId("2");
		student.setName("John F. McReally");
		student.setEmail("John.McReally@oneself.io");
		repo.put(student.getId(), student);

		student = new Student();
		student.setId("3");
		student.setName("Claudia M. Kirshner");
		student.setEmail("Claudia.Kirshner@oneself.io");
		repo.put(student.getId(), student);

		student = new Student();
		student.setId("4");
		student.setName("Nelson B. Ransom");
		student.setEmail("Nelson.Ransom@oneself.io");
		repo.put(student.getId(), student);

		student = new Student();
		student.setId("5");
		student.setName("Roxane L. Russell");
		student.setEmail("Roxane.Russell@oneself.io");
		repo.put(student.getId(), student);
		
			public Student findByEmail(String email) {
		if (email != null && email.length() > 0) {
			for (Student student : repo.values()) {
				if (student.getEmail() != null && student.getEmail().equals(email))
					return student;
			}
		}

		return null;
	}
	}*/


}
