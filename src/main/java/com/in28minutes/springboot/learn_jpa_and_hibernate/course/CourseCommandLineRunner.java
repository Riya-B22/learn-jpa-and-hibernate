package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.SpringDataJpa.CourseSpringDataJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//	@Autowired
//	private CourseJdbcRepository repository; // step 5,6,7 used this
	
//	@Autowired
//	private CourseJpaRepository repository; // step 8
	
	@Autowired
	private CourseSpringDataJpaRepository repository; // step 10
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/* used for spring jdbc, jpa 
//		repository.insert(); // step 5: hardcoded value insertion
		repository.insert(new Course(1,"Learn AWS now!","in28minutes")); // step 6
		repository.insert(new Course(2,"Learn Docker now!","in28minutes"));
		repository.insert(new Course(3,"Learn Microservices now!","in28minutes"));
		
		//Delete the course by id
		repository.deleteById(2);
		
		//show the selected data:
		System.out.println(repository.findById(3)); upto step 8*/
		
		// Step 10: following changes alone to execute spring data jpa repository commands:
		repository.save(new Course(1,"Learn AWS SpringDataJPA!","in28minutes")); // step 10
		repository.save(new Course(2,"Learn Docker SpringDataJPA!","in28minutes"));
		repository.save(new Course(3,"Learn Microservices SpringDataJPA!","in28minutes"));
		
		//Delete the course by id
		repository.deleteById(2l);
		
		//show the selected data:
		System.out.println(repository.findById(3l));
		
		// step 11 adding custom methods to the CourseSpringDataJpaRepository:
		System.out.println(repository.findByAuthor("in28minutes"));
		
		System.out.println(repository.findByName("Learn AWS SpringDataJPA!"));
		
		
		
	}
	

}
