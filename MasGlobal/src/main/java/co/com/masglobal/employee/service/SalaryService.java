package co.com.masglobal.employee.service;

import co.com.masglobal.employee.util.Constants;

public class SalaryService {


    /**
     * @param salary salario del empleado de acuerdo a su contrato
     * @param typeContract tipo de contrato del empleado
     * @return el salario anual
     * @since 1.0
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
