package com.signup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.signup.model.DataModel;

public interface SingnupRepo extends JpaRepository<DataModel, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM data_model where email_id = id")
    public List<Object[]> checkData( String  id);
    

}
