package com.happy;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class someF {

    void hello() throws InterruptedException, SQLException, ClassNotFoundException {

        DataBase db = new DataBase();
        Main main = new Main();
       TimeUnit.SECONDS.sleep(3);
        db.Conn();   //подкючение к БД
        db.CreateDB();   //создание/проверка

       main.arrayWithObject = db.ReadDB(main.arrayWithObject);

        System.out.println("1 - добавить");
        System.out.println("2 - посмотреть список");
        System.out.println("3 - посмотреть ближайшие ДР");
        System.out.println("4 - отредактировать");
        System.out.println("5 - удаление");
        System.out.println("6 - сохранить");
        System.out.println("0 - выход");
    }


     void demo(){
         System.out.println("╔══╗" +  "    "+ "╔══╗" +  "    "+ "╔═══╗"+   "    "+" ╔══╗" +   "    "+ "╔═══╗" +  "    "+ "╔══╗" +   "    "+ "╔══╗" +  "    "+ " ╔══╗"+  "    "+"╔═══╗" +  "    "+ "╔════╗" +  "    "+ "╔══╗" +  "    "+ "╔═══╗");
         System.out.println("║╔╗║" +  "    "+ "║╔╗║" +  "    "+ "╚══╗║"+   "    "+" ║╔╗║" +   "    "+ "║╔═╗║" +  "    "+ "║╔╗║" +   "    "+ "║╔╗║" +  "    "+ " ║╔╗║"+  "    "+"║╔═╗║" +  "    "+ "╚═╗╔═╝" +  "    "+ "║╔╗║" +  "    "+ "║╔═╗║");
         System.out.println("║║║║" +  "    "+ "║║║║" +  "    "+ " ╔═╝║"+   "    "+" ║║║║" +   "    "+ "║╚═╝║" +  "    "+ "║╚╝║" +   "    "+ "║╚╝╚╗" +  "   "+" ║║║║"+  "    "+"║╚═╝║" +  "    "+ "  ║║  " +  "    "+ "║║║║" +  "    "+ "║╚═╝║");
         System.out.println("║║║║" +  "    "+ "║║║║" +  "    "+ " ╚═╗║"+   "    "+" ║║║║" +   "    "+ "║╔══╝" +  "    "+ "║╔╗║" +   "    "+ "║╔═╗║" +  "   "+" ║║║║"+  "    "+"╚╗╔╗║" +  "    "+ "  ║║  " +  "    "+ "║║║║" +  "    "+ "║╔══╝");
         System.out.println("║║║║" +  "    "+ "║╚╝║" +  "    "+ "╔══╝║"+   "    "+"╔╝╚╝╚╗" +  "  "+" ║║   " +  "    "+ "║║║║" +   "    "+ "║╚═╝║" +  "   "+"╔╝║║║"+  "    "+" ║║║║" +  "    "+ "  ║║  " +  "    "+ "║╚╝║" +  "    "+ "║║   ");
         System.out.println("╚╝╚╝" +  "    "+ "╚══╝" +  "    "+ "╚═══╝"+   "    "+"╚════╝" +  "  " +" ╚╝   " +  "    "+ "╚╝╚╝" +   "    "+ "╚═══╝" +  "   "+"╚═╝╚╝"+  "    "+" ╚╝╚╝" +  "    "+ "  ╚╝  " +  "    "+ "╚══╝" +  "    "+ "╚╝   ");

     }


     void age(int age){
        if(age%10 == 1 && age!=11){
            System.out.println(" год");
        }
         else if(age>=5 && age<=20 || age%10 == 0 || age%10>= 5 && age%10<=9){
             System.out.println(" лет");
         }
        else if (age%10>=2 && age%10<=4){
            System.out.println(" года");
        }
     }
}
