package comp348;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;

public class Employee implements Person{
    String firstName, lastName, id;
    BigDecimal salary;

    Employee(String id, String fname, String lname, BigDecimal salary){

        // ID length needs to be 7 digits
        if (id.length() == 7 ) {
            this.id = id;
            this.firstName = fname;
            this.lastName = lname;
            this.salary = salary;
        } else {
            System.out.println("Error: Employee's ID needs to be a 7-digit string");
            System.exit(1);
        }
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public BigDecimal getSalary(){ return salary; }

    public String toString(){
        NumberFormat salaryInDollar = NumberFormat.getCurrencyInstance();
        return this.id + ", "
                + this.firstName + ", "
                + this.lastName + ", "
                + salaryInDollar.format(this.salary);
    }

    public static Employee parse(String input){
        String[] inputs = input.split(",");
        return ( new Employee(inputs[0], inputs[1], inputs[2], new BigDecimal(inputs[3])) );
    }

}
