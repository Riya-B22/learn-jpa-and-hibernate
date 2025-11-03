package com.in28minutes.springboot.learn_jpa_and_hibernate.course.SpringDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

// created in Step 10
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	List<Course> findByAuthor(String string);
	
	List<Course> findByName(String string);

}
