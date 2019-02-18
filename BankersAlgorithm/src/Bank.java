
public interface Bank {
	
	//add customer
	public void addCustomer(int customerNum, int[] maximumDemand);
	
	//output the value of available, maximum, allocation, and need
	public void getState();
	
	//request resources
	public boolean requestResources(int customerNum, int[] request);
	
	//release resources
	public void releaseResources(int customerNum, int[] release);
	
	void initial();
	void finalState();
}
