package com.cg.bim.service;
import java.util.List;
import com.cg.bim.entity.Publisher;
public interface PublisherService {
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(int publisherId);
     Publisher getPublisherByName(String name);
     List<Publisher> getPublishersByCity(String city);
    List<Publisher> getPublishersByState(String state);
    void save(Publisher publisher);
    }