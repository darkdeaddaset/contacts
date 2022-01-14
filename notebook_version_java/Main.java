import model.Person;
import services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static void AddContactException(){
        System.out.println("Вы ничего не ввели при добавлении контакта");
        System.out.println("Контакт не создан!");
    }
    static void AddContactName(String name){
        Person person = new Person(name);

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Номер: " + person.getNumber());
        System.out.println("Email: " + person.getEmail());

        System.out.print("Добавить контакт? Y/n: ");
        Scanner in1 = new Scanner(System.in);
        String YesOrNo = in1.nextLine();

        if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
            UserService userService = new UserService();
            userService.savePerson(person);

            System.out.println("Контакт создан");
        }
        if (YesOrNo.equals("N") || YesOrNo.equals("n")){
            System.out.println("Контакт не создан");
        }
        in1.close();
    }
    static void AddContactNameNumber(String name, String number){
        Person person = new Person(name, number);

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Номер: " + person.getNumber());
        System.out.println("Email: " + person.getEmail());

        System.out.print("Добавить контакт? Y/n: ");
        Scanner in1 = new Scanner(System.in);
        String YesOrNo = in1.nextLine();

        if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
            UserService userService = new UserService();
            userService.savePerson(person);

            System.out.println("Контакт создан");
        }
        if (YesOrNo.equals("N") || YesOrNo.equals("n")){
            System.out.println("Контакт не создан");
        }
        in1.close();
    }
    static void AddContactNameNumberEmail(String name, String number, String email){
        Person person = new Person(name, number, email);

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Номер: " + person.getNumber());
        System.out.println("Email: " + person.getEmail());

        System.out.print("Добавить контакт? Y/n: ");
        Scanner in1 = new Scanner(System.in);
        String YesOrNo = in1.nextLine();

        if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
            UserService userService = new UserService();
            userService.savePerson(person);

            System.out.println("Контакт создан");
        }
        if (YesOrNo.equals("N") || YesOrNo.equals("n")){
            System.out.println("Контакт не создан");
        }
        in1.close();
    }
    static void AddContactNameNumberEmailAge(String name, String number, String email, int age){
        Person person = new Person(name, number, email, age);

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Номер: " + person.getNumber());
        System.out.println("Email: " + person.getEmail());

        System.out.print("Добавить контакт? Y/n: ");
        Scanner in1 = new Scanner(System.in);
        String YesOrNo = in1.nextLine();

        if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
            UserService userService = new UserService();
            userService.savePerson(person);

            System.out.println("Контакт создан");
        }
        if (YesOrNo.equals("N") || YesOrNo.equals("n")){
            System.out.println("Контакт не создан");
        }
        in1.close();
    }

    static void ChangeName(List<Person> personList){
        UserService userService = new UserService();
        System.out.print("Введите новое имя: ");
        Scanner in = new Scanner(System.in);
        String change_name = in.nextLine();
        for (Person person : personList){
            person.setName(change_name);

            System.out.println();
            System.out.println(person.getId() + "." + "Имя:" + person.getName());
            System.out.println("Возраст: " + person.getAge());
            System.out.println("Номер: " + person.getNumber());
            System.out.println("Email:" + person.getEmail());

            System.out.print("Сохранить изменения? Y/n: ");
            String YesOrNo = in.nextLine();

            if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
                userService.updatePerson(person);
                System.out.println("Изменения успешно сохранены");

                in.close();
            }
            if (YesOrNo.equals("N") || YesOrNo.equals("n")){
                System.out.println("Изменения не сохранены!");

                in.close();
            }
        }
    }
    static void ChangeAge(List<Person> personList){
        UserService userService = new UserService();
        System.out.print("Введите новый возраст: ");
        Scanner in = new Scanner(System.in);
        int change_age = in.nextInt();
        for (Person person : personList){
            person.setAge(change_age);

            System.out.println();
            System.out.println(person.getId() + "." + "Имя:" + person.getName());
            System.out.println("Возраст: " + person.getAge());
            System.out.println("Номер: " + person.getNumber());
            System.out.println("Email:" + person.getEmail());

            Scanner in1 = new Scanner(System.in);
            System.out.print("Сохранить изменения? Y/n: ");
            String YesOrNo = in1.nextLine();

            if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
                userService.updatePerson(person);
                System.out.println("Изменения успешно сохранены");

                in.close();
                in1.close();
            }
            if (YesOrNo.equals("N") || YesOrNo.equals("n")){
                System.out.println("Изменения не сохранены!");

                in.close();
                in1.close();
            }
        }
    }
    static void ChangeNumber(List<Person> personList){
        UserService userService = new UserService();
        System.out.print("Введите новый номер: ");
        Scanner in = new Scanner(System.in);
        String change_number = in.nextLine();
        for (Person person : personList){
            person.setNumber(change_number);

            System.out.println();
            System.out.println(person.getId() + "." + "Имя:" + person.getName());
            System.out.println("Возраст: " + person.getAge());
            System.out.println("Номер: " + person.getNumber());
            System.out.println("Email:" + person.getEmail());

            System.out.print("Сохранить изменения? Y/n: ");
            String YesOrNo = in.nextLine();

            if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
                userService.updatePerson(person);
                System.out.println("Изменения успешно сохранены");

                in.close();
            }
            if (YesOrNo.equals("N") || YesOrNo.equals("n")){
                System.out.println("Изменения не сохранены!");

                in.close();
            }
        }
    }
    static void ChangeEmail(List<Person> personList){
        UserService userService = new UserService();
        System.out.print("Введите новый email: ");
        Scanner in = new Scanner(System.in);
        String change_email = in.nextLine();
        for (Person person : personList){
            person.setEmail(change_email);

            System.out.println();
            System.out.println(person.getId() + "." + "Имя:" + person.getName());
            System.out.println("Возраст: " + person.getAge());
            System.out.println("Номер: " + person.getNumber());
            System.out.println("Email:" + person.getEmail());

            System.out.print("Сохранить изменения? Y/n: ");
            String YesOrNo = in.nextLine();

            if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
                userService.updatePerson(person);
                System.out.println("Изменения успешно сохранены");

                in.close();
            }
            if (YesOrNo.equals("N") || YesOrNo.equals("n")){
                System.out.println("Изменения не сохранены!");

                in.close();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Блокнот: приложение для сохранение контактов");
        System.out.println("Выберите опцию:");
        System.out.println("1) Добавить контакт");
        System.out.println("2) Просмотреть список контактов");
        System.out.println("3) Редактировать существующий контакт");
        System.out.println("4) Удалить существующий контакт");
        System.out.println();
        System.out.print("Ваш выбор: ");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        do {
            if (choice.equals("1")){
                Scanner in1 = new Scanner(System.in);
                System.out.print("Имя контакта: ");
                String name = in1.nextLine();
                System.out.print("Номер контакта: ");
                String number = in1.nextLine();
                System.out.print("Email контакта: ");
                String email = in1.nextLine();
                System.out.print("Введите возраст контакта: ");
                String ageS = in1.nextLine();
                int age = Integer.parseInt(ageS);

                if (name.isEmpty() && number.isEmpty() && email.isEmpty() && age == 0){
                    AddContactException();
                }
                if (!name.isEmpty() && number.isEmpty() && email.isEmpty() && age == 0){
                    AddContactName(name);
                }
                if (!name.isEmpty() && !number.isEmpty() && email.isEmpty() && age == 0){
                    AddContactNameNumber(name, number);
                }
                if (!name.isEmpty() && !number.isEmpty() && !email.isEmpty() && age == 0){
                    AddContactNameNumberEmail(name, number, email);
                }
                if (!name.isEmpty() && !number.isEmpty() && !email.isEmpty() && age != 0){
                    AddContactNameNumberEmailAge(name, number, email, age);
                }
                in.close();
            }
            if (choice.equals("2")){
                UserService userService = new UserService();
                List<Person> personList = new ArrayList<>();
                personList = userService.findAllPerson();
                for (Person person : personList){
                    System.out.println();
                    System.out.println("=================");
                    System.out.println( person.getId() + "." + "Имя: " + person.getName());
                    System.out.println("Возраст: " + person.getAge());
                    System.out.println("Номер: " + person.getNumber());
                    System.out.println("Email:" + person.getEmail());
                    System.out.println("=================");
                }
            }
            if (choice.equals("3")){
                System.out.print("Введите имя редактируемого контакта: ");
                Scanner in1 = new Scanner(System.in);
                String name = in1.nextLine();

                UserService userService = new UserService();
                List<Person> personList = userService.personSearch(name);

                for (Person person : personList){
                    System.out.println();
                    System.out.println("Найден контакт");
                    System.out.println("=================");
                    System.out.println(person.getId() + "." + "Имя:" + person.getName());
                    System.out.println("Возраст: " + person.getAge());
                    System.out.println("Номер: " + person.getNumber());
                    System.out.println("Email:" + person.getEmail());
                    System.out.println("=================");
                }

                System.out.println("1) Изменить имя контакта");
                System.out.println("2) Изменить возраст контакта");
                System.out.println("3) Изменить номер контакта");
                System.out.println("4) Изменить email контакта");

                System.out.print("Ваш выбор: ");
                choice = in1.nextLine();

                if (choice.equals("1")){
                    ChangeName(personList);
                }
                if (choice.equals("2")){
                    ChangeAge(personList);
                }
                if (choice.equals("3")){
                    ChangeNumber(personList);
                }
                if (choice.equals("4")){
                    ChangeEmail(personList);
                }
                in.close();
            }
            if (choice.equals("4")){
                System.out.println("Удаление");
                Scanner in1 = new Scanner(System.in);

                System.out.print("Введите имя контакта: ");
                String name = in1.nextLine();

                UserService userService = new UserService();
                List<Person> personList = userService.personSearch(name);

                for (Person person : personList){
                    System.out.println();
                    System.out.println("Найден контакт");
                    System.out.println("=================");
                    System.out.println(person.getId() + "." + "Имя:" + person.getName());
                    System.out.println("Возраст: " + person.getAge());
                    System.out.println("Номер: " + person.getNumber());
                    System.out.println("Email:" + person.getEmail());
                    System.out.println("=================");

                    System.out.print("Вы действительно хотите удалить контакт? Y/n: ");
                    String YesOrNo = in1.nextLine();

                    if (YesOrNo.equals("Y") || YesOrNo.equals("y")){
                        userService.deletePerson(person);
                        System.out.println("Контакт удален");
                    }
                    if (YesOrNo.equals("N") || YesOrNo.equals("n")){
                        System.out.println("Отмена удаления контакта");
                    }
                    in1.close();
                }
            }
            System.out.println("Выберить опцию или");
            System.out.println("введите exit, чтобы выйти из программы");
            choice = in.nextLine();
        }while (!choice.equals("exit"));
        in.close();
    }
}
