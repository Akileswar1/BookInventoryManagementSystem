package com.cg.bim.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.bim.entity.UserData;
@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {

    List<UserData> findByEmail(String email);
    
}
