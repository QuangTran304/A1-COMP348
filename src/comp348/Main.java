package comp348;


import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //input test (by parsa)
//        Employee e1 = e1.parse("0132435,John,Doe,30000.00");
//        System.out.println(e1.toString());
//        System.out.println(e1.getSalary());
//        System.out.println(e1.getID());
//        System.out.println(e1.getName());

        // Test by Quang
        Person worker1 = new Employee("1234567", "John", "Doe", new BigDecimal("3000.02"));
        System.out.println(worker1.toString());

    }
}
