package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Repository // step 4
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	/* hardcoding the insert values: step 5
	private static String INSERT_QUERY = """
			insert into course(id,name,author) 
			values(1,'learn AWS','in28minutes');
			""";
	
	public void insert(){
		springJdbcTemplate.update(INSERT_QUERY);
	}*/
	
	// steps 06 Inserting object valyes
	private static String INSERT_QUERY = """
			insert into course(id,name,author) 
			values(?,?,?);
			""";
	
	public void insert(Course course){
		springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	// Step 6- to delete a course by id:
	private static String DELETE_QUERY = """
			delete from  course where id=?
			""";
	public void deleteById(long id){
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	
	// Step 7- to delete a course by id:
		private static String SELECT_QUERY = """
				SELECT * from  course where id=?
				""";
		public Course findById(long id){
			return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
		}
	
	

}
