package com.task;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pattern pt = new Pattern();
		//pt.pattern1();
		//pt.pattern2();
		//pt.pattern3();
		//pt.pattern4();
		//pt.pattern5();
		//pt.pattern6();
		//pt.pattern7();
		//pt.pattern9();
		//pt.pattern10();
		pt.pattern12();
		

	}

	private void pattern8() {
		// TODO Auto-generated method stub
		for(int count = 5;count>=1; count--)
		{
		    for(int no=count; no>=1; no--)
		    {   System.out.print(no+" ");   }
		    System.out.println(); 
		}
		
	}

	private void pattern1() {
		// TODO Auto-generated method stub
		for (int count = 1; count <= 3; count++) {
			for (int no = 1; no <= 5; no++) {
				System.out.print(no + " ");
			}
			System.out.println();
		}
	}
	
	private void pattern2() {
		// TODO Auto-generated method stub
		for(int no=1; no<=25; no++)
		{
		System.out.print(no+" ");
		if(no%5==0)
		{
			System.out.println();
		}
		}
		
	}
	
	private void pattern3()
	{
		
		int count = 5; 
	    while(count>=3)
	    {
	        for(int no=1; no<=count; no++) {
	        System.out.print(no+" "); 
	        }
	        System.out.println(); 
	    count--; 
	    }
	}
	private void pattern4() {
		// TODO Auto-generated method stub
		for(int count = 5;count>=1; count--)
		{
		    for(int no=count; no>=1; no--)
		    {   System.out.print(no+" ");   }
		    System.out.println(); 
		}
		
	}
	
	private void pattern5() {
		
		    for(int no=1; no<=15; no++)
		    {   System.out.print(no+"\t");   
		    
		    if(no%5==0)
		    {
		    	System.out.println();
		    }
		     
		    }
		
	}
	
	private void pattern6() {
	    // TODO Auto-generated method stub
	    int count =5; 
	    int num = 1; 
	    while(count>=1)
	    {
	    for(int no=1; no<=count; no++)
	    { 
	      System.out.print(num + "\t");
	      num++; 
	    }
	    System.out.println(); 
	    count--; 
	    }
	  }
	
	private void pattern7() {
	    // TODO Auto-generated method stub
	    for(int no = 5; no>=1; no--)
	    {
	        for(int star = 1; star<no; star++)
	        {   System.out.print("* ");     }
	        System.out.println(); 
	    }
	    
	  }
	private void pattern9() {
	    // TODO Auto-generated method stub
	    for(int no = 5; no>=1; no--)
	    {
	        for(int star = 1; star<no; star++)
	          {   
	          System.out.print("* ");     
	          }
	        for(int num=1; num<=6-no; num++)
	          { 
	          System.out.print(1+ " ");
	          }
	         System.out.println(); 
	    }
	  }
	private void pattern10() {
	    // TODO Auto-generated method stub
	    for(int no = 5; no>=1; no--)
	    {
	        for(int star = 1; star<no; star++)
	          {   
	          System.out.print(" ");     
	          }
	        for(int num=1; num<=6-no; num++)
	          { 
	          System.out.print(1+ " ");
	          }
	         System.out.println(); 
	    }
	  }
	
	private void pattern11() {
	    // TODO Auto-generated method stub
	    for(int no = 5; no>=1; no--)
	    {
	        for(int star = 1; star<no; star++)
	          {   
	          System.out.print("* ");     
	          }
	        for(int num=1; num<=6-no; num++)
	          { 
	          System.out.print(num+ " ");
	          }
	         System.out.println(); 
	    }
	  }

		private void pattern12() {
			// TODO Auto-generated method stub
			int count=15;
			for(int col = 1; col<=5; col++) 
			{			
			for(int row=1; row<=col; row++)
			{
				System.out.print(count-- +"\t ");			 
			} 
			System.out.println();
			}
	}
		

}
