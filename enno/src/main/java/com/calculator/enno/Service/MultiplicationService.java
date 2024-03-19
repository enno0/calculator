package com.calculator.enno.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calculator.enno.DAO.MultiplicationRepository;
import com.calculator.enno.model.Multiplication;

@Service
@Transactional
public class MultiplicationService {

    @Autowired
    private MultiplicationRepository multiplicationRepository;

    private void saveMultiplication(long operand, long multiplicand, long result) {
        Multiplication multiplicationmod = new Multiplication();
        multiplicationmod.setOperA(operand);
        multiplicationmod.setMultiplicationTable(multiplicand);
        multiplicationmod.setResult(result);
        multiplicationmod.setTimestamp(new Date());
        multiplicationRepository.save(multiplicationmod);
    }

    public List<Multiplication> Multiply(long a, long MultiplicationTable) {
        
        if (MultiplicationTable != 0) {
            List<Multiplication> multiplicationSteps = new ArrayList<>();
            for (long z = 0; z <= MultiplicationTable; z++) {
                long result = a * z;
                saveMultiplication(a, z, result);
                multiplicationSteps.add(new Multiplication(a, z, result, new Date()));
            }

            return multiplicationSteps;
        } else {
            throw new IllegalArgumentException("Cannot Multiply by zero");
        }
    }

    public List<Multiplication> getAll() {
        return multiplicationRepository.findAll();
    }

    public void delete(long id) {
        multiplicationRepository.deleteById(id);
    }
    public void deleteAll(){
        multiplicationRepository.deleteAll();
    }

}
