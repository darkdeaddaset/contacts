package com.company;

import java.sql.*;
import java.util.*;

public class Main
{
    private static final String url = "jdbc:postgresql://localhost/contacts";

    public static void main(String[] args)
    {
        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "your_password");
        properties.setProperty("ssl", "false");

        System.out.print("Блокнот: приложение для сохранение контактов\n");
        System.out.print("Выберите опцию:\n");
        System.out.print("1) Добавить контакт\n");
        System.out.print("2) Просматреть список контактов\n");
        System.out.print("3) Редактировать существующий контакт\n");
        System.out.print("4) Удалить существующий контакт\n");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1)
        {
            Scanner l = new Scanner(System.in);
            System.out.print("Введите имя: ");
            String name = l.nextLine();
            System.out.print("Введите номер: ");
            String number = l.nextLine();
            System.out.print("Введите email: ");
            String email = l.nextLine();
            System.out.print("Введите возраст: ");
            String age = l.nextLine();

            //Ситуация когда все поля пустые
            if (name.length() == 0 && number.length() == 0 && email.length() == 0 && age.length() == 0)
            {
                try
                {
                    Persons person = new Persons();
                    person.GetInfo();
                }
                catch (ExceptionContact e)
                {
                    System.out.println(e.getMessage());
                }
            }
            //Ситуация когда пользователь ввел номер
            if (name.length() == 0 && number.length() != 0 && email.length() == 0 && age.length() == 0)
            {
                try
                {
                    Persons person = new Persons(number);
                    person.GetInfo();

                    try(Connection connection = DriverManager.getConnection(url, properties))
                    {
                        System.out.println("Подключение выполнено");
                        String sql ="INSERT INTO persons(name, number, email, age) Values (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, person.getName());
                        preparedStatement.setString(2, person.getNumber());
                        preparedStatement.setString(3, person.getEmail());
                        preparedStatement.setInt(4, person.getAge());

                        int exec = preparedStatement.executeUpdate();
                        System.out.printf("Строк добавлено %d\n", exec);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Неудалось подключиться...");
                        System.out.println(ex);
                    }


                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            //Ситуация, когда пользователь ввел имя и телефон
            if (name.length() != 0 && number.length() != 0 && email.length() == 0 && age.length() == 0)
            {
                try
                {
                    Persons person = new Persons(name, number);
                    person.GetInfo();

                    try(Connection connection = DriverManager.getConnection(url, properties))
                    {
                        System.out.println("Подключение выполнено");
                        String sql ="INSERT INTO persons(name, number, email, age) Values (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, person.getName());
                        preparedStatement.setString(2, person.getNumber());
                        preparedStatement.setString(3, person.getEmail());
                        preparedStatement.setInt(4, person.getAge());

                        int exec = preparedStatement.executeUpdate();
                        System.out.printf("Строк добавлено %d\n", exec);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Неудалось подключиться...");
                        System.out.println(ex);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            //Ситуация, когда пользователь ввел имя, телефон, электронную почту
            if (name.length() != 0 && number.length() != 0 && email.length() != 0 && age.length() == 0)
            {
                try
                {
                    Persons person = new Persons(name, number, email);
                    person.GetInfo();

                    try(Connection connection = DriverManager.getConnection(url, properties))
                    {
                        System.out.println("Подключение выполнено");
                        String sql ="INSERT INTO persons(name, number, email, age) Values (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, person.getName());
                        preparedStatement.setString(2, person.getNumber());
                        preparedStatement.setString(3, person.getEmail());
                        preparedStatement.setInt(4, person.getAge());

                        int exec = preparedStatement.executeUpdate();
                        System.out.printf("Строк добавлено %d\n", exec);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Неудалось подключиться...");
                        System.out.println(ex);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            //Ситуация, когда пользователь ввел все данные
            if (name.length() != 0 && number.length() != 0 && email.length() != 0 && age.length() != 0)
            {
                int conv_age = Integer.parseInt(age);
                try
                {
                    Persons person = new Persons(name, number, email, conv_age);
                    person.GetInfo();

                    try(Connection connection = DriverManager.getConnection(url, properties))
                    {
                        System.out.println("Подключение выполнено");
                        String sql ="INSERT INTO persons(name, number, email, age) Values (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, person.getName());
                        preparedStatement.setString(2, person.getNumber());
                        preparedStatement.setString(3, person.getEmail());
                        preparedStatement.setInt(4, person.getAge());

                        int exec = preparedStatement.executeUpdate();
                        System.out.printf("Строк добавлено %d\n", exec);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Неудалось подключиться...");
                        System.out.println(ex);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            l.close();
        }

        if (choice==2)
        {
            try(Connection connection = DriverManager.getConnection(url, properties))
            {
                System.out.println("Все контакты");
                System.out.println("Подключение выполнено");
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM persons");
                while(resultSet.next())
                {
                    System.out.println("==================");
                    String name = resultSet.getString(1);
                    String number = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    int age = resultSet.getInt(4);

                    System.out.printf("Name: %s\nNumber: %s\nEmail:%s\nAge: %d\n2", name, number, email, age);
                }
            }
            catch (Exception ex)
            {
                System.out.println("Неудалось подключиться...");
                System.out.println(ex);
            }

        }

        if (choice==3)
        {
            System.out.println("1) Изменить имя контакта");
            System.out.println("2) Изменить номер контакта");
            System.out.println("3) Изменить электронную почту");

            Scanner in1 = new Scanner(System.in);
            int choice_1 = in1.nextInt();

            if (choice_1==1)
            {
                System.out.print("Введите имя контакта: ");
                Scanner str = new Scanner(System.in);
                String search_name = str.nextLine();

                System.out.print("Введите новое имя: ");
                Scanner str1 = new Scanner(System.in);
                String changed_name = str1.nextLine();

                try(Connection connection = DriverManager.getConnection(url, properties))
                {
                    System.out.println("Подключение выполнено");
                    String sql ="UPDATE persons SET name=? WHERE name=?";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, changed_name);
                    preparedStatement.setString(2, search_name);

                    int exec = preparedStatement.executeUpdate();
                    System.out.println("Имя изменено");

                    str.close();
                    str1.close();
                }
                catch (Exception ex)
                {
                    System.out.println("Неудалось подключиться...");
                    System.out.println(ex);
                }
            }
            if (choice_1==2)
            {
                System.out.print("Введите номер контакта: ");
                Scanner str = new Scanner(System.in);
                String search_number = str.nextLine();

                System.out.print("Введите новый номер: ");
                Scanner str1 = new Scanner(System.in);
                String changed_number = str1.nextLine();

                try(Connection connection = DriverManager.getConnection(url, properties))
                {
                    System.out.println("Подключение выполнено");
                    String sql ="UPDATE persons SET number=? WHERE number=?";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, changed_number);
                    preparedStatement.setString(2, search_number);

                    int exec = preparedStatement.executeUpdate();
                    System.out.println("Номер изменен");

                    str.close();
                    str1.close();
                }
                catch (Exception ex)
                {
                    System.out.println("Неудалось подключиться...");
                    System.out.println(ex);
                }
            }
            if (choice_1==3)
            {
                System.out.print("Введите электронную почту пользователя: ");
                Scanner str = new Scanner(System.in);
                String search_number = str.nextLine();

                System.out.print("Введите новую почту пользователя: ");
                Scanner str1 = new Scanner(System.in);
                String changed_number = str1.nextLine();

                try(Connection connection = DriverManager.getConnection(url, properties))
                {
                    System.out.println("Подключение выполнено");
                    String sql ="UPDATE persons SET email=? WHERE email=?";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, changed_number);
                    preparedStatement.setString(2, search_number);

                    int exec = preparedStatement.executeUpdate();
                    System.out.println("Электронная почта изменена");

                    str.close();
                    str1.close();
                }
                catch (Exception ex)
                {
                    System.out.println("Неудалось подключиться...");
                    System.out.println(ex);
                }
            }
        }

        if (choice==4)
        {
            System.out.print("Введите имя контакта: ");
            Scanner str = new Scanner(System.in);
            String search_name = str.nextLine();

            try(Connection connection = DriverManager.getConnection(url, properties))
            {
                System.out.println("Подключение выполнено");
                String sql ="DELETE FROM persons WHERE name=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, search_name);

                int exec = preparedStatement.executeUpdate();
                System.out.println("Контакт удален");

                str.close();
            }
            catch (Exception ex)
            {
                System.out.println("Неудалось подключиться...");
                System.out.println(ex);
            }
        }
        in.close();
    }
}
