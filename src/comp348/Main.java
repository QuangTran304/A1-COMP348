package comp348;

import static comp348.Employee.parse;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!!");



        // Write anything here => Try to 'pull' (VCS -> Git -> Pull...), 'commit' and 'push' to remote repository!!
        System.out.println("testing");




        // Write anything here => Try to 'pull' (VCS -> Git -> Pull...), 'commit' and 'push' to remote repository!!



        // Write anything here => Try to 'pull' (VCS -> Git -> Pull...), 'commit' and 'push' to remote repository!!


        // Write anything here => Try to 'pull' (VCS -> Git -> Pull...), 'commit' and 'push' to remote repository!!


        //input test (by parsa)
        Employee e1 = parse("0132435,John,Doe,30000.00");
        System.out.println(e1.toString());
        System.out.println(e1.getSalary());
        System.out.println(e1.getID());
        System.out.println(e1.getName());
    }
}
