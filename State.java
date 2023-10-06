package com.cg.bim.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "state")
@NoArgsConstructor
@JsonIgnoreProperties(value = "publishers")
public class State {
    @Id
    @Column(name = "statecode",length = 2,columnDefinition = "char(2)")
    String stateCode;
    @Column(name = "statename",length = 50)
    String stateName;
    @OneToOne(cascade = CascadeType.ALL)
    @Transient
    List<Publisher> publishers;
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public List<Publisher> getPublishers() {
        return publishers;
    }
    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

}