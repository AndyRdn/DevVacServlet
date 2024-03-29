import mapping.Employer;

import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
//        new Employer(0,"Nandri",20).insert(null);
        Vector<Employer> emp= Employer.getAll();
        System.out.println(emp.size());
    }
}