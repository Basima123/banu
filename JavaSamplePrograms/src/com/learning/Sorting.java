package com.learning;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorting st=new Sorting();
		st.new_method();
		
		}
		
	void new_method()
	{
		int[] ar={10,7,3,1};
        System.out.println("Before Swap");

        for (int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]+" ");
        }
        System.out.println();

        for (int j=1;j<=ar.length-1;j++)
        {
            for (int i=0;i<ar.length-j;i++)
            {
                if (ar[i]>ar[i+1])
                {
                    int temp= ar[i];
                    ar[i]=ar[i+1];
                    ar[i+1]=temp;

                }
            }
        }

        System.out.println("After Swap");
        for (int i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]+" ");
        }


	}

	void old_method()
	{
		int[] ar= {10,7,3,1};
		for(int i=0;i<ar.length;i++)
		{
			System.out.println(ar[i] + " ");
		}
		System.out.println();
		for(int i=0;i<ar.length-1;i++)
		{
			if(ar[i]>ar[i+1])
			{
				int temp=ar[i];
				ar[i]=ar[i+1];
				ar[i+1]=temp;
			}
		}
		System.out.println("After first swap");
		for(int i=0;i<ar.length-1;i++)
		{
			System.out.println(ar[i] + " ");
		}
		
		for(int i=0;i<ar.length-2;i++)
		{
			if(ar[i]>ar[i+1])
			{
				int temp = ar[i]; 
				ar[i] = ar[i+1]; 
				ar[i+1] = temp; 
			}
		}
			System.out.println("After Second Swap");
			for(int i=0; i<ar.length;i++)
			{
				System.out.print(ar[i]+" ");
			}
	}
	
	}

