package com.company.AdvancedJava.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializable {
    public static void main(String[] args) {
        Employee emp = null;
        Employee emp1 = null;
        try{
            FileInputStream file = new FileInputStream("E:\\COLLEGE\\SEM 5\\file.txt");
            ObjectInputStream obj =new ObjectInputStream(file);
            emp = (Employee) obj.readObject();
            emp1 = (Employee) obj.readObject();
            obj.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Employee1 Details");
        System.out.println("Name: "+emp.name);
        System.out.println("City: "+emp.city);
        System.out.println("Id: "+emp.id);
        System.out.println("Password: "+emp.password);
        System.out.println("Employee2 Details");
        System.out.println("Name: "+emp1.name);
        System.out.println("City: "+emp1.city);
        System.out.println("Id: "+emp1.id);
        System.out.println("Password: "+emp1.password);
    }
}
