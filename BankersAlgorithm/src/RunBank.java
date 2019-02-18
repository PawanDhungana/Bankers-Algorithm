import java.util.Scanner;
//import java.util.*;

public class RunBank {

	public static void main(String[] args) {

		int numOfCustomers; //the number of customers
		int numOfResources; //the number of resources
		
		int []available; //the available amount of each resource
		int [][]maximum; //the maximum demand of each customer
		int [][]allocation; //the amount currently allocated to each customer
		
		int [][]need; //the remaining needs of each customer
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of resources and customers: ");
		numOfResources = scanner.nextInt();
		numOfCustomers = scanner.nextInt();
		scanner.close();
		
		available = new int [numOfResources]; 
		for(int i = 0; i < numOfResources; ++i)
		{
		    available[i]= (int)(Math.random()*9);   
		 }
		
		for(int i = 0; i < numOfResources; ++i)
		{
		   System.out.println(+available[i]); 
		 }
		
		//initializing arrays
		maximum = new int [numOfResources][numOfCustomers]; 
		need = new int [numOfResources][numOfCustomers]; 
		allocation = new int [numOfResources][numOfCustomers]; 

		for(int i=0;i<numOfCustomers;++i)
		{
            for(int j=0;j<numOfResources;++j)
            {
                 maximum[i][j]= (int)(Math.random()* available[j]);
                 //allocation[i][j] = 0;
                 //need[i][j] = maximum[i][j];
            }
        }
		

	}
	
	
	//ya bata
	Bank bank = new ImplBank(maximum, available,numberOfResources,numberOfCustomers);
    bank.initial();
    Thread[] customers = new Thread[numberOfCustomers];
    
          for(int i =0; i< numberOfCustomers;i++){
            customers[i] = new Thread(new Customer(i, maximumM, bank));
            //bank.addCustomer(i, maximumM[i]);
         }
     
     for (Thread thread : customers) {
         thread.start();
     }//wait
     
     try {
     for (Thread thread : customers) {
         thread.join();
       }
       }catch (InterruptedException e) {
    // thread.interrupt();
     }
     bank.finalState();
 }
//ya samma
	
	
	
}
