package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {
		Integer num_records = (Integer) this.hibernateTemplate.save(student);
		return num_records;
	}
	
	@Transactional
	public void update(Student student, int studentId) {
		this.hibernateTemplate.update(student);
	}
	
	@Transactional
	public void delete(int studentId) {
		Student student = this.get(studentId);
		this.hibernateTemplate.delete(student);
	}
	
	public Student get(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	public List<Student> getAll() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}
