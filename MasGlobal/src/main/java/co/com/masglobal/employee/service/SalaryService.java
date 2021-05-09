package co.com.masglobal.employee.service;

import co.com.masglobal.employee.util.Constants;

public class SalaryService {


    /**
     * Calcula el salario anual dependiendo del tipo de contrato
     *
     * @param salary salary {@link Integer}
     * @param typeContract typeContract {@link String}
     * @return {@link Integer}
     * @see Integer
     */
    public Integer calculateHourValue(Integer salary, String typeContract) {

        if(typeContract.equals(Constants.CONTRACT_HOUR)) {
            return Constants.MONTH * salary * Constants.YEAR;
        }else if(typeContract.equals(Constants.CONTRACT_MONTH)) {
            return salary * Constants.YEAR;
        }else {
            return salary;
        }
    }

}
