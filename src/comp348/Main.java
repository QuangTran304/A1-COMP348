package comp348;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //input test (by parsa)
//        Employee e1 = e1.parse("0132435,John,Doe,30000.00");
//        System.out.println(e1.toString());
//        System.out.println(e1.getSalary());
//        System.out.println(e1.getID());
//        System.out.println(e1.getName());


        // Test by Quang
        Employee worker1 = new Employee("1234567", "John", "Doe", new BigDecimal("3000.02"));
        System.out.println("Worker1: " + worker1.toString());
        System.out.println("\nID: " + worker1.getID());
        System.out.println("Name: " + worker1.getName());
        System.out.println("Salary: " + worker1.getSalary());

        System.out.println("\n---------");

        Employee worker2 = Employee.parse("1528950,Jane,Doe,3500.24");
        System.out.println("Worker2: " + worker2.toString());

        System.out.println("\n---------");

        Employee worker3 = Employee.parse("2593950,Bruno,Mars,2900.89");
        System.out.println("Worker3: " + worker3.toString());

        System.out.println("\n---------");




        Scanner fileReader = null;                                     // Do this because we need to handle exception inside 'try' block

        try {
            fileReader = new Scanner(new FileInputStream("src/comp348/inputStrings.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(1);
        }


        List<Employee> employeeList = new ArrayList<>();       // Dynamic array is more efficient than raw array

        while (fileReader.hasNext()) {
            Employee e = Employee.parse(fileReader.nextLine());        // Parse employee information from each line in the file
            employeeList.add(e);
        }
        fileReader.close();                                            // Done reading file. Close the file stream


        // Sort and Display employees by last-name & first-name
        List<Employee> employeeByName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName))       // Use method-reference == Lambda
                .collect(Collectors.toList());
        System.out.println("\n------ Sorted Employees by first & last name ------");
        employeeByName.forEach(System.out::println);                   // Use method-reference == Lambda


        // Sort & Display employees by ID
        List<Employee> employeeByID = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getID))
                .collect(Collectors.toList());

        System.out.println("\n------ Sorted Employees by ID ------");
        employeeByID.forEach(System.out::println);
    }
}
