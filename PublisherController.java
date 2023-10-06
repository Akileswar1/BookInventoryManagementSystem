package com.cg.bim.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bim.entity.Publisher;
import com.cg.bim.repository.PublisherRepository;
import com.cg.bim.service.PublisherService;
import java.util.List;
@RestController
@RequestMapping("/api")
public class PublisherController {
    private  PublisherService publisherService;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);
    }
    @GetMapping("/publisher/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable int publisherId) {
        Publisher publisher = publisherService.getPublisherById(publisherId);
        if (publisher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
    @GetMapping("/publisher/name/{name}")
    public ResponseEntity<Publisher> getPublisherByName(@PathVariable String name) {
        Publisher publisher = publisherService.getPublisherByName(name);
        if (publisher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
    @GetMapping("/publisher/city/{city}")
    public ResponseEntity<List<Publisher>> getPublishersByCity(@PathVariable String city) {
        List<Publisher> publishers = publisherService.getPublishersByCity(city);
        if (publishers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }
    @GetMapping("/publisher/state/{state}")
    public ResponseEntity<List<Publisher>> getPublishersByState(@PathVariable String state) {
        List<Publisher> publishers = publisherService.getPublishersByState(state);
        if (publishers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }
    @PutMapping("/publisher/update/name/{publisherId}")
    public ResponseEntity<Publisher> updateNameByPublisherId(@PathVariable("publisherId") Integer publisherId,@RequestBody String name) {
        Publisher publisher = publisherService.getPublisherById(publisherId);
        if (publisher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        publisher.setName(name);
        publisherService.save(publisher);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
    @PutMapping("/publisher/update/city/{publisherId}")
    public ResponseEntity<Publisher> updateCityByPublisherId(@PathVariable("publisherId") Integer publisherId,@RequestBody String city) {
        List<Publisher> publisher = publisherRepository.findPublisherByPublisherID(publisherId);
        if (publisher.get(0) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        publisher.get(0).setCity(city);
        publisherRepository.save(publisher.get(0));
        return new ResponseEntity<Publisher>(publisher.get(0), HttpStatus.OK);
    }
    @PutMapping("/publisher/update/state/{publisherId}")
    public ResponseEntity<Publisher> updateStateByPublisherId(@PathVariable("publisherId") Integer publisherId,@RequestBody String statecode) {
        List<Publisher> publisher = publisherRepository.findPublisherByPublisherID(publisherId);
        if (publisher.get(0) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        publisher.get(0).setStateCode(statecode);
        publisherRepository.save(publisher.get(0));
        return new ResponseEntity<Publisher>(publisher.get(0), HttpStatus.OK);
    }
    @PostMapping("/publisher/post")
    public ResponseEntity<Publisher> addPublishers(@RequestBody Publisher publisher) {
        if (publisher == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        publisherService.save(publisher);
        return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
    }
}