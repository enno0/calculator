package com.calculator.enno.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "calc_multiplication")
public class Multiplication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long operA;
    private Long MultiplicationTable;

    public Multiplication() {
    }
    private Long result;
    private Date timestamp;

    public Multiplication( Long operA, Long multiplicationTable, Long result, Date timestamp) {
        this.operA = operA;
        MultiplicationTable = multiplicationTable;
        this.result = result;
        this.timestamp = timestamp;
    }



    
}
