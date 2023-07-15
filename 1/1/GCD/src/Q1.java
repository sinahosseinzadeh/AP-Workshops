import java.util.Scanner;

public class Q1
{
    private static Scanner in = new Scanner(System.in);

    public static int gcd(int n1, int n2)
    {
        int gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i)
        {
            if(n1 % i==0 && n2 % i==0)
                gcd = i;
        }

        return gcd;
    }



    public static void main(String[] args)
    {
        System.out.print("adad aval ra vared konid:  ");
        int num1 = in.nextInt();

        System.out.print("adad dovom ra vared konid:  ");
        int num2 = in.nextInt();


        if (gcd(num1, num2) == 1)
            System.out.println("2 adad nesbat be ham aval and");
        else
            System.out.println("2 adad nesbat be ham aval nistand");
    }
}
