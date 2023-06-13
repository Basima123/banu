package com.learning;

import java.util.Scanner;

public class SpyNumber {
    public static void main(String[] args) {
        SpyNumber spy=new SpyNumber();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number:");
        int no=in.nextInt();

        int add=spy.Sum_of_digit(no);
        int mul=spy.mul_of_digit(no);

        if (mul==add)
        {
            System.out.println(no+" is Spy number");
        }
        else
        {
            System.out.println(no+" is not Spy number");
        }
    }

    int mul_of_digit(int num) {
        int rem=0,total=1;

        while (num>0)
        {
            rem=num%10;
            total=total*rem;

            num=num/10;
        }
        return total;
    }


    int Sum_of_digit(int num)
    {
        int rem=0,total=0;

        while (num>0)
        {
            rem=num%10;
            total=total+rem;

            num=num/10;
        }
        return total;
    }
}