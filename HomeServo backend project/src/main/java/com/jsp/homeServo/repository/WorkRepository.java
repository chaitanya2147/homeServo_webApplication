package com.jsp.homeServo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.homeServo.dto.Work;

public interface WorkRepository extends JpaRepository<Work,Integer>{
@Query("select a from Work a where a.startDate=null")
public List<Work> ListOfWorks();
	

}
