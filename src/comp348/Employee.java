package comp348;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Employee implements Person{
    String firstName, lastName, id;
    double salary; //I couldn't declare a variable in BigDecimal without assigning a value!!

    Employee(String id, String fname, String lname, double salary){
        this.id = id;
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public BigDecimal getSalary(){
        BigDecimal returnSalray = BigDecimal.valueOf(salary);
        return returnSalray;
    }

    public String toString(){
        NumberFormat salaryInDollar = NumberFormat.getCurrencyInstance();
        return this.id + ", "
                + this.firstName + ", "
                + this.lastName + ", "
                + salaryInDollar.format(this.salary);
    }

    static Employee parse(String input){
        String[] inputs = new String[4];
        inputs = input.split(",");
        Employee newEmployee = new Employee(inputs[0],
                                            inputs[1],
                                            inputs[2],
                                            Double.parseDouble(inputs[3]));
        return newEmployee;
    }

}
