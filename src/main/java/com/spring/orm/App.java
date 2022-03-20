package com.spring.orm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	Student student = new Student(3,"Naman","Gurugram");
    	studentDao.insert(student);
    	studentDao.update(new Student(4, "Sagar", "Ambala"), 2);
    	studentDao.delete(3);
    	System.out.println(studentDao.get(1));
    	System.out.println(studentDao.getAll());
    	context.close();
    }
}
