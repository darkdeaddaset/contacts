using System;

namespace Notebook
{
    public class Person
    {
        public int Id { get; set; }
        public int age { get; set; }
        public string name { get; set; }
        public string number { get; set; }
        public string email { get; set; }

        public Person() : this("not number")
        {
            //throw new Exception("Нельзя создать пустой контакт\n Необходим хотя бы номер");
        }
        public Person(string number) : this(number, "no name", 0)
        {

        }
        public Person(string number, string name) : this(number, name, 0)
        {

        }
        public Person(string number, string name, int age) : this(number, name, age, "example@mail.com")
        {

        }
        public Person(string number, string name, int age, string email)
        {
            this.age = age;
            this.name = name;
            this.number = number;
            this.email = email;
        }

        public void GetInfo()
        {
            Console.WriteLine(age);
            Console.WriteLine(name);
            Console.WriteLine(number);
            Console.WriteLine(email);
        }
    }
}
