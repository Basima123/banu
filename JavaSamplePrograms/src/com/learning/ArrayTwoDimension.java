package com.learning;

public class ArrayTwoDimension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayTwoDimension td=new ArrayTwoDimension();
		td.method4();
		//td.method5();
		
		
	}
		
		private void method5() {
		    
		    int[][] a= { {1,2,3},{4,5,6},{7,8,9} };
		    int[] [] b= { {10,11,12},{13,14,15},{16,17,18} };
		    //  0 1 2  0   1  2 
		   //0 |1 2 3||10 11 12|
		    //1|4 5 6||13 14 15|
		    //2|7 8 9||16 17 18|
		    
		    int [][] c=new int[3][3];
		    
		    for(int i=0;i<a.length;i++)
		    {
		      for(int j=0;j<a.length;j++)
		      {
		        c[i][j]=a[i][j]+b[i][j];
		        System.out.print(c[i][j]+" ");
		      }
		      System.out.println();
		    }
		    
		    
		    
		  }

		  private void method4() {
		    
		    int [][] a= { {1,2},{3,4} };//int[2][2]
		    int [][] b= { {5,6},{7,8} };
		    
		    /*a[0][0]=1;
		    a[0][1]=2;
		    a[1][0]=3;
		    a[1][1]=4;
		    
		    b[0][0]=5;
		    b[0][1]=6;
		    b[1][0]=7;
		    b[1][1]=8;*/
	//	       i=0 i=1   
//		   j=0 | 1 2 |  | 5 6 |
//		   j=1 | 3 4 |  | 7 8 |
		    
		    
		    int [][] c=new int[2][2];
		    
		    //c[0][0]= a[0][0]+b[0][0]; 
		    //c[0][1]=a[0][1]+b[0][1];
		    //c[1][0]=a[1][0]+b[1][0];
		    //c[1][1]=a[1][1]+b[1][1];
		    
		    for(int j=0;j<a.length;j++)//a[0]
		    {
		    for(int i=0;i<a.length;i++)
		    {
		      c[j][i]=a[j][i]*b[j][i];  //j=0;i=0; j=0;i=1; //j=1;i=0; j=1;i=1;
		      System.out.print(c[j][i]+" ");
		      
		    }
		    System.out.println();
		    }
		      
		  }

	}

