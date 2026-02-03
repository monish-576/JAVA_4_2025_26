class Shapes
{
    public int s,l,b;
    public void area(int S)
    {
        s=S;
        System.out.println(s*s);
    }
    public void area(int L,int B)
    {
        l=L;
        b=B;
        System.out.println(l*b);
    }
}
public class Main
{
    public static void main(String[] args)
    {
       Shapes s=new Shapes();
       s.area(10);
       Shapes l=new Shapes();
       s.area(10,20);
       
    }
}