package com.calculator.enno.DTO;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.calculator.enno.model.Multiplication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class MultiplicationForm {
     private Long operA;
     private Long MultiplicationTable;

    private  List<Multiplication> result;
    private Date timestamp;
    private String error;

}
