package com.cg.bim.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bim.entity.Publisher;
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    List<Publisher> findPublisherByPublisherID(Integer publisherId);
     Publisher findByName(String name);
     List<Publisher> findByCity(String city);
     List<Publisher> findPublisherByName(String name);
     List<Publisher> findPublisherByStateCode(String stateCode);

}