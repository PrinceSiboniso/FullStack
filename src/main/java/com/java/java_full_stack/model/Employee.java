package com.java.java_full_stack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id ;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String department;

//    public String getFirstname() {
//    }
//
//    public void setEmal(String email) {
//    }
}
