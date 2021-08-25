package codegym.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepoImpl implements ICalculatorRepo{

    @Override
    public Double calculate(double numb1, double numb2, char operator) {
        Double result = null;
        switch (operator) {
            case '+':
                result = numb1 + numb2;
                break;
            case '-':
                result = numb1 - numb2;
                break;
            case '*':
                result = numb1 * numb2;
                break;
            case '/':
                if (numb2 != 0) {
                    result = numb1 / numb2;
                }
        }
        return result;
    }
}
