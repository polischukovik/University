package com.oleksii.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleksii.data.domain.Group;
import com.oleksii.data.domain.Student;
import com.oleksii.data.repository.GroupRepository;
import com.oleksii.data.repository.StudentRepository;

@Service
public class GroupService {
	
	private GroupRepository groupRepository;
	
	private StudentRepository studentRepository;
	
	@Autowired
	public GroupService(GroupRepository groupRepository, StudentRepository studentRepository){
		this.groupRepository = groupRepository;
		this.studentRepository = studentRepository;
	}

	public void addAllStudents(Integer groupId, List<Student> students) {
		Group group = this.groupRepository.findOne(groupId);
		if(group == null){
			System.out.println("No group with this id: " + groupId);
		}
		students.forEach(s -> addStudent(groupId, s));
	}
	
	public void addStudent(Integer groupId, Student student) {
		Group group = this.groupRepository.findOne(groupId);
		if(group == null){
			System.out.println("No group with this id: " + groupId);
		}
		
		student.setGroup(group);
		studentRepository.save(student);			
		
		group.getStudents().add(student);
	}

	public void addAll(List<Group> groups) {
		groups.forEach(g -> this.groupRepository.save(g));
	}

	public Iterable<Group> findAll() {
		return groupRepository.findAll();
	}

}
