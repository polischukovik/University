package com.oleksii;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oleksii.data.service.GroupService;
import com.oleksii.data.service.StudentService;
import com.oleksii.data.domain.Group;
import com.oleksii.data.domain.Student;

@SpringBootApplication
public class PersistanceApplication implements CommandLineRunner{
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(PersistanceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		List<Student> students = Arrays.asList(
				  new Student("Eddard", "Stark")
				, new Student("Robert", "Baratheon")
				, new Student("Jaime", "Lannister")
				, new Student("Catelyn", "Stark")
				, new Student("Cersei", "Lannister")
				, new Student("Daenerys", "Targaryen")
				, new Student("Jorah", "Mormont")
				, new Student("Petyr", "Baelish")
				, new Student("Viserys", "Targaryen")
				, new Student("Jon", "Snow")
				, new Student("Sansa", "Stark")
				, new Student("Arya", "Stark")
				, new Student("Robb", "Stark")
				, new Student("Theon", "Greyjoy")
				, new Student("Bran", "Stark")
				, new Student("Joffrey", "Baratheon")
				, new Student("Sandor", "Clegane")
				, new Student("Tyrion", "Lannister")
				, new Student("Khal", "Drogo")
				, new Student("Tywin", "Lannister")
				, new Student("Davos", "Seaworth")
				, new Student("Varys", "")
				);
		
		List<Group> groups = Arrays.asList(
			  new Group("S03")
			, new Group("S07")
			, new Group("T05")
			);
		
		groupService.addAll(groups);
		studentService.addAll(students);
		
		groupService.addAllStudents(groups.get(0).getId(), students.subList(0, 7));
		groupService.addAllStudents(groups.get(1).getId(), students.subList(7, 14));
		groupService.addAllStudents(groups.get(2).getId(), students.subList(14, 21));
				

		/*System.out.println("==========================================");
		Iterable<Group> retrievedGroups= groupService.findAll();
		Iterable<Student> retrievedStudents = studentService.findAll();		
		
		
		retrievedGroups.forEach(g -> System.out.println(g.info()));
		retrievedStudents.forEach(s -> System.out.println(s.info()));
		
		System.out.println("==========================================");		*/
	}
}
