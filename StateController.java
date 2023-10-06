package com.cg.bim.controller;
import java.util.List;
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
import com.cg.bim.entity.*;
import com.cg.bim.exception.RequestIdNotFound;
import com.cg.bim.repository.StateRepository;
@RestController
@RequestMapping("/api")
public class StateController {
    @Autowired
    private StateRepository stateRepository;
    @PostMapping("/states")
    public ResponseEntity<State> createState(@RequestBody State state){
        if(state==null) {
            return new ResponseEntity<State>(HttpStatus.NO_CONTENT);
        }else {
            stateRepository.save(state);
            return new ResponseEntity<State>(state, HttpStatus.OK);
        }
    }
    @GetMapping("/states")
    public ResponseEntity<List<State>> getallStates(){// Check Once    getStates(){
        List<State> states= stateRepository.findAll();
        if(states==null) {
            return new ResponseEntity<List<State>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<State>>(states,HttpStatus.OK);
    }
    @GetMapping("/states/{stateCode}")
    public ResponseEntity<State> modifyByStateCode(@PathVariable("stateCode") String stateCode) throws RequestIdNotFound{
        List<State> state1=stateRepository.findStatesByStateCode(stateCode);
        if(state1.get(0)==null) {
            throw new RequestIdNotFound("Idiot Request Id Not Found");
        }
        else{
            return new ResponseEntity<State>(state1.get(0), HttpStatus.OK);
        }
    }
    @PutMapping("/state/update/name/{stateCode}")
    public ResponseEntity<State> UpdateNameByStateCode(@PathVariable("stateCode") String stateCode,@RequestBody String name) throws RequestIdNotFound{
        List<State> state=stateRepository.findStatesByStateCode(stateCode);
        if(state.get(0)==null) {
            throw new RequestIdNotFound("Idiot Id not Found!");
        }else {
            state.get(0).setStateName(name);
            stateRepository.save(state.get(0));
            return new ResponseEntity<State>(state.get(0),HttpStatus.OK);
        }
    }
}