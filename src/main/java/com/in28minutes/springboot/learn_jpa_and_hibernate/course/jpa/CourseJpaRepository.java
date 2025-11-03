package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// whole class created as part of step 8 
@Repository
@Transactional   // without this annotation the app wont run for JPA
public class CourseJpaRepository {
	@PersistenceContext // better recommendation for annotation other than @Autowired
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

}
