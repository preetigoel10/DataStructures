package com.company.AdvancedJava.Serialization;

import java.io.*;

public class TestMain {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Preeti");
        emp.setCity("Chandigarh");
        emp.setPassword("abcccc");
        emp.setId(1233);
        Employee emp1 = new Employee();
        emp1.setName("Shivam");
        emp1.setCity("MOHALI");
        emp1.setPassword("chitkara");
        emp1.setId(9876);
        try{
            FileOutputStream file = new FileOutputStream("E:\\COLLEGE\\SEM 5\\file.txt");
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(emp);
            object.writeObject(emp1);
            object.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
