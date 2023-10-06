package com.cg.bim.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bim.entity.Publisher;
import com.cg.bim.repository.PublisherRepository;
import com.cg.bim.service.PublisherService;
import java.util.List;
@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
    @Override
    public Publisher getPublisherById(int publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }
    @Override
    public Publisher getPublisherByName(String name) {
        return publisherRepository.findByName(name);
    }
    @Override
    public List<Publisher> getPublishersByCity(String city) {
        return publisherRepository.findByCity(city);
    }
    @Override
    public List<Publisher> getPublishersByState(String state) {
        // TODO Auto-generated method stub
        return publisherRepository.findPublisherByStateCode(state);
    }
    @Override
    public void save(Publisher publisher) {
        // TODO Auto-generated method stub
        publisherRepository.save(publisher);
    }
}