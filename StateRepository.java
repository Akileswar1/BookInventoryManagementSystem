package com.cg.bim.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bim.entity.*;
public interface StateRepository extends JpaRepository<State,String>{
	List<State> findStatesByStateCode(String stateCode);
}