using System;
using System.Linq;
using Microsoft.EntityFrameworkCore;

namespace Notebook
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.Write("Блокнот: приложение для сохранение контактов\n");
            Console.Write("Выберите опцию:\n");
            Console.Write("1) Добавить контакт\n");
            Console.Write("2) Просмотреть список контактов\n");
            Console.Write("3) Редактировать существующий контакт\n");
            Console.Write("4) Удалить существующий контакт\n");
            Console.WriteLine();

            if(Console.ReadKey(true).Key == ConsoleKey.D1 || Console.ReadKey(true).Key == ConsoleKey.NumPad1)
            {
                    Console.Write("Введите номер контакта: ");
                    string number = Console.ReadLine();

                    Console.Write("Введите имя контакта: ");
                    string name = Console.ReadLine();

                    Console.Write("Введите возраст контакта: ");
                    int age = Convert.ToInt32(Console.ReadLine());

                    Console.Write("Введите электронную почту контакта: ");
                    string email = Console.ReadLine();
                    Console.WriteLine();

                    using (ApplicationContext db = new ApplicationContext())
                    {
                        Person person = new Person(number, name, age, email);

                        db.persons.Add(person);
                        db.SaveChanges();
                        Console.WriteLine("Контакт создан");
                    }
            }


            if(Console.ReadKey(true).Key == ConsoleKey.D2 || Console.ReadKey(true).Key == ConsoleKey.NumPad2)
            {
                    using (ApplicationContext db = new ApplicationContext())
                    {
                        var persons = db.persons.ToList();
                        Console.WriteLine("Список контактов:");
                        foreach (Person p in persons)
                        {
                            Console.Write($"{p.Id}.{p.name} {p.age}--{p.number}, {p.email}\n");
                        }
                    }
            }

            if(Console.ReadKey(true).Key == ConsoleKey.D3 || Console.ReadKey(true).Key == ConsoleKey.NumPad3)
            {
                Console.WriteLine("1) Изменить имя имя контакта");
                Console.WriteLine("2) Изменить номер контакта");
                Console.WriteLine("3) Изменить электронную почту");

                if(Console.ReadKey(true).Key == ConsoleKey.D1 || Console.ReadKey(true).Key == ConsoleKey.NumPad1)
                {
                    using (ApplicationContext db = new ApplicationContext())
                    {
                        Console.Write("Введите имя контакта, которое вы хотите изменить: ");
                        string search_name = Console.ReadLine();
                        Console.Write("Введите новое имя для контакта: ");
                        string change_name = Console.ReadLine();

                        int change = db.Database.ExecuteSqlRaw("UPDATE persons SET name={0} WHERE name={1}", change_name, search_name);
                        db.SaveChanges();

                        Console.WriteLine("Изменения сохранены");
                    }
                }

                if (Console.ReadKey(true).Key == ConsoleKey.D2 || Console.ReadKey(true).Key == ConsoleKey.NumPad2)
                {
                    using (ApplicationContext db = new ApplicationContext())
                    {
                        Console.Write("Введите номер контакта: ");
                        string search_number = Console.ReadLine();
                        Console.Write("Введите новый номер контакта для контакта: ");
                        int change_number = Convert.ToInt32(Console.ReadLine());

                        int change = db.Database.ExecuteSqlRaw("UPDATE persons SET number={0} WHERE number = {1} ", change_number, search_number);
                        db.SaveChanges();

                        Console.WriteLine("Изменения сохранены");
                    }
                }

                if(Console.ReadKey(true).Key == ConsoleKey.D3 || Console.ReadKey(true).Key == ConsoleKey.NumPad3)
                {
                    using (ApplicationContext db = new ApplicationContext())
                    {
                        Console.Write("Введите электронную почту контакта, которое вы хотите изменить: ");
                        string search_email = Console.ReadLine();
                        Console.Write("Введите новую электронную почту для контакта: ");
                        int change_email = Convert.ToInt32(Console.ReadLine());

                        int change = db.Database.ExecuteSqlRaw("UPDATE persons SET email={0} WHERE email = {1} ", change_email, search_email);
                        db.SaveChanges();

                        Console.WriteLine("Изменения сохранены");
                    }
                }
            }

            if(Console.ReadKey(true).Key == ConsoleKey.D4 || Console.ReadKey(true).Key == ConsoleKey.NumPad4)
            {
                using (ApplicationContext db = new ApplicationContext())
                {
                    Console.Write("Введите имя контакта, который хотите удалить: ");
                    string delete_name = Console.ReadLine();

                    int deleted_contact = db.Database.ExecuteSqlRaw("DELETE FROM persons WHERE name={0}", delete_name);
                    db.SaveChanges();

                    Console.WriteLine("Контакт удален");
                }
            }
        }
        }
        }

