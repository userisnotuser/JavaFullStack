package com.happy;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

public class DataBase {
    private static Connection conn;
    private static Statement statmt;
    private static ResultSet resSet;
    private static int resUpt;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:src/dataBase.s3db");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text, 'dOb' date, 'post' text);");

    }


    public static List ReadDB(List array) throws SQLException {

        resSet = statmt.executeQuery("SELECT * FROM users");
        while (resSet.next()) {
            Person p = new Person();
            p.setId(resSet.getInt("id"));
            p.setName(resSet.getString("name"));
            p.setSurname(resSet.getString("surname"));
            String s = resSet.getString("dOb");
            p.setPost(resSet.getString("post"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            LocalDate d = LocalDate.parse(s, formatter);
            p.setDate(d);
            array.add(p);
        }

        return array;
    }


    public static void DeleteDB() throws SQLException {
        resUpt = statmt.executeUpdate("DROP TABLE users");
        CreateDB();
    }

    public static List addPerson(List arrayWithObject){
        Scanner add = new Scanner(System.in);
        Person p = new Person();
        System.out.println("Введите имя и фамилию:");
        System.out.print("⟶ ");p.setName(add.next());
        p.setSurname(add.next());
        System.out.println("Год рождения:");
        System.out.print("⟶ ");int year = add.nextInt();
        System.out.println("Месяц рождения:");
        System.out.print("⟶ ");int mouth = add.nextInt()-1;
        System.out.println("День рождения:");
        System.out.print("⟶ ");int day = add.nextInt();
        GregorianCalendar calendar = new GregorianCalendar(year, mouth, day);
        String s= String.valueOf(calendar.getTime());
        String sTest = s.substring(0, 19);
        sTest += s.substring(s.length() - 5, s.length());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd hh:mm:ss yyyy", Locale.ENGLISH);
        LocalDate d = LocalDate.parse(sTest, formatter);
        p.setDate(d);
        System.out.println("Должность:");
        System.out.print("⟶ ");p.setPost(add.next());
        arrayWithObject.add(p);
        outputAll(arrayWithObject);
        return arrayWithObject;
    }

    public static void outputAll(List arrayWithObject){
        System.out.print("╭─[поздравлятор]───────────────────────────────────────────────╮\n" +
                         "├───┬───────────────┬───────────────┬──────────┬───────────────┤\n" +
                         "│ ID│      ИМЯ      │    ФАМИЛИЯ    │   ДАТА   │   ДОЛЖНОСТЬ   │\n" +
                         "╞═══╪═══════════════╪═══════════════╪══════════╪═══════════════╡\n");
        for(int i=0;i< arrayWithObject.size();i++){
            System.out.printf("│%03d│%15.15s│%15.15s│%10.10s│%15.15s│\n├───┼───────────────┼───────────────┼──────────┼───────────────┤\n",i+1,((Person) arrayWithObject.get(i)).getName(),((Person) arrayWithObject.get(i)).getSurname()
                    ,((Person) arrayWithObject.get(i)).getDate(),((Person) arrayWithObject.get(i)).getPost());
        }
        System.out.print("╰───┴───────────────┴───────────────┴──────────┴───────────────╯\n");
    }

    public static void DeleteElement(List arrayWithObject){
        System.out.println("Выберите номер для удаления:");
        for(int i=0;i< arrayWithObject.size();i++){
            System.out.printf("%d %s %s\n",i+1,((Person) arrayWithObject.get(i)).getName(),((Person) arrayWithObject.get(i)).getSurname());
        }
        arrayWithObject.remove(new Scanner(System.in).nextInt()-1);
    }

    public static void Save(List array) throws SQLException {
        String name,surname,post;
        LocalDate newDate;
        DeleteDB();
       for(int i=0;i<array.size();i++) {
           name = ((Person) array.get(i)).getName();
           surname = ((Person) array.get(i)).getSurname();
           post = ((Person) array.get(i)).getPost();
           newDate = ((Person) array.get(i)).getDate();
           statmt.execute("INSERT INTO 'users' ('name', 'surname', 'dOb','post') VALUES ('" + name + "', '" + surname + "','" + newDate + "','" + post + "'); ");
       }
    }


    public static List Change(List arrayWithObject) throws SQLException {
        System.out.println("Выберите номер для изменения:");
        for(int i=0;i< arrayWithObject.size();i++){
            System.out.printf("%d %s %s\n",i+1,((Person) arrayWithObject.get(i)).getName(),((Person) arrayWithObject.get(i)).getSurname());
        }
        Scanner ch = new Scanner(System.in);
        int id = ch.nextInt()-1;
        System.out.println("Введите новое имя и фамилию:");
        System.out.print("⟶ ");((Person)arrayWithObject.get(id)).setName(ch.next());
        ((Person)arrayWithObject.get(id)).setSurname(ch.next());
        System.out.println("Год рождения:");
        System.out.print("⟶ ");int year = ch.nextInt();
        System.out.println("Месяц рождения:");
        System.out.print("⟶ ");int mouth = ch.nextInt()-1;
        System.out.println("День рождения:");
        System.out.print("⟶ ");int day = ch.nextInt();
        GregorianCalendar calendar = new GregorianCalendar(year, mouth, day);
        String s= String.valueOf(calendar.getTime());
        String sTest = s.substring(0, 19);
        sTest += s.substring(s.length() - 5, s.length());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd hh:mm:ss yyyy", Locale.ENGLISH);
        LocalDate d = LocalDate.parse(sTest, formatter);
        ((Person)arrayWithObject.get(id)).setDate(d);
        System.out.println("Должность:");
        System.out.print("⟶ "); ((Person) arrayWithObject.get(id)).setPost(ch.next());
        outputAll(arrayWithObject);
       return arrayWithObject;
    }

   public static List birthday(List arrayWithObject) throws SQLException {

        someF ageF = new someF();
       System.out.print("╭─[день Рождения]──────────────────────────────────────────────╮\n" +
               "╞══════════════════════════════════════════════════════════════╡\n");
        for (int i = 0; i < arrayWithObject.size(); i++) {

            int a = ((Person) arrayWithObject.get(i)).getDate().getMonth().getValue();
            int b = new Date().getMonth() + 1;
            if (a == b) {
                a = ((Person) arrayWithObject.get(i)).getDate().getDayOfMonth();
                b = new Date().getDate();
                if (a == b) {
                    int age = (new Date().getYear() + 1900 - (int) ((Person) arrayWithObject.get(i)).getDate().getYear());
                    System.out.print("╞Сегодня " + ((Person) arrayWithObject.get(i)).getName() + " " + ((Person) arrayWithObject.get(i)).getSurname() + " исполняется "
                            + (new Date().getYear() + 1900 - (int) ((Person) arrayWithObject.get(i)).getDate().getYear()));
                    ageF.age(age);
                }

                a = ((Person) arrayWithObject.get(i)).getDate().getDayOfMonth();
                b = new Date().getDate()+1;
                if (a == b) {
                    int age = (new Date().getYear() + 1900 - (int) ((Person) arrayWithObject.get(i)).getDate().getYear());
                    System.out.print("╞Завтра " + ((Person) arrayWithObject.get(i)).getName() + " " + ((Person) arrayWithObject.get(i)).getSurname() + " исполняется "
                            + (new Date().getYear() + 1900 - (int) ((Person) arrayWithObject.get(i)).getDate().getYear()));
                    ageF.age(age);
                }


            }
        }

       System.out.print("╰──────────────────────────────────────────────────────────────╯\n");
       return arrayWithObject;
   }
}