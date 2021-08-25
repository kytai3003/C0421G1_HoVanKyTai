package codegym.model.service;

import codegym.model.repository.ICalculatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService{

    @Autowired
    ICalculatorRepo iCalculatorRepo;

    @Override
    public double calculate(double numb1, double numb2, char operator) {
        return iCalculatorRepo.calculate(numb1, numb2, operator);
    }
}
