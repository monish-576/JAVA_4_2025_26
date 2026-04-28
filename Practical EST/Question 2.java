import java.util.*;
public class Try
{
    public static void main(String[] args)
    {
        int a=10;
        try{
            int b=a/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Exception Occured");
        }
        finally
        {
            System.out.println("Program Executed");
        }
    }
}
