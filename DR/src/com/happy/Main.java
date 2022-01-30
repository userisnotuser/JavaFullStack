package com.happy;

import java.sql.SQLException;
import java.util.*;
import static com.happy.DataBase.*;

public class Main {
    static List arrayWithObject = new ArrayList();
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        someF someF = new someF();
        someF.demo();
        try {
            someF.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
       }


        Scanner menu = new Scanner(System.in);
        int temp = 1;
        while(temp!=0){
            temp = menu.nextInt();
            switch (temp){
                case (1):addPerson(arrayWithObject);
                    break;
                case (2):outputAll(arrayWithObject);
                    break;
                case (3):birthday(arrayWithObject);
                    break;
                case (4):Change(arrayWithObject);
                    break;
                case (5):DeleteElement(arrayWithObject);
                    break;
                case (6):Save(arrayWithObject);
                    System.out.println("Успешно сохранена.");;
                    break;
            }
        }

        Save(arrayWithObject);

    }


}




