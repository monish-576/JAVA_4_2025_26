class Student
{
    public int age;
    public String name;
    public int uid;
    Student()
    {
        System.out.println("Hello");
    }
    Student(int x)
    {
        System.out.println("World");
    }
    public void show(int Age,String Name,int Uid)
    {
        age=Age;
        name=Name;
        uid=Uid;
        System.out.println(age);
        System.out.println(name);
        System.out.println(uid);
    }
}
public class Main
{
    public static void main(String[] args)
    {
    Student s=new Student(10);
    s.show(18,"monish",121);
    Student s1=new Student();
    }
}