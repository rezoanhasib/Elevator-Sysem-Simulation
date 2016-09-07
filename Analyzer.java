import java.util.Scanner;
/**
 * The <CODE>Analyzer</CODE> is a Java Applicaton that interacts with the user in order to simulate an 
 * intended environment which is done by reaching helping methods to calculate the waiting time 
 * for an elevator to reach a request.
 * if entered values are out of range. 
 * @author rezoanhasib
 * <A> HREF= "mailto:rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 */
public class Analyzer 
{
	/**
	 * This main method asks the user to enter four parameters, the probability of a request in each second, 
	 * the number of floors and the number of elevators in the building, and the length of the simulation. 
	 * @param args
	 * @throws EmptyQueueException
	 * 		Informs if the queue is empty and there's no request to assign an elevator 
	 * 
	 */
	public static void main(String[] args) throws EmptyQueueException
	{
		double probability; 
		int floors,elevators,simulationLength,selection; 
		
		Scanner input=new Scanner(System.in); 
		System.out.println("Welcome!!");
		
		
		System.out.println("Please enter the probability of a request: ");
		probability=input.nextDouble();
		/*
		while(probability<0.0||probability>1.0)
		{
			System.out.println("\nEntered probability is out of range!!"); 
			System.out.println("Please enter a value between 0.0 and 1.0 inclusive: ");
			probability=input.nextDouble(); 
		}
		*/
		System.out.println("Enter the number of floors in the building: "); 
		floors=input.nextInt(); 
		while(floors<=1)
		{
			System.out.println("\nThere should be more than one floor in the building!!");
			System.out.println("Please enter the correct number of floors: ");
			floors=input.nextInt(); 
		}
		System.out.println("Enter the number of elevator(s) in the building: ");
		elevators=input.nextInt(); 
		while(elevators<=0)
		{
			System.out.println("\nThere should be at least one elevators in the building!!");
			System.out.println("Please enter the correct number of elevators: ");
			elevators=input.nextInt(); 
		}
		System.out.println("Enter the length of the simulation: ");
		simulationLength=input.nextInt();
		while(simulationLength<=0)
		{
			System.out.println("\nSimulation length should be greater than 0!!");
			System.out.println("Please enter the correct simulation length: ");
			simulationLength=input.nextInt(); 
		}
		System.out.println("Enter 1 for regular simulation or 2 for optimal simulation: ");
		selection=input.nextInt(); 
		while(selection!=1 && selection!=2)
		{
			System.out.println("Invalid entry!! Only values accepted are: "); 
			System.out.println("1- Regular simulation or 2- Optimal simulation");
			System.out.println("Please enter either a 1 or 2");
			selection=input.nextInt(); 
		}
		System.out.println("\nEntered values:");
		System.out.println("---------------\n");
		System.out.println("Probability: "+probability+".");
		System.out.println("Floors: "+floors+".");
		System.out.println("Elevators: "+elevators+"."); 
		System.out.println("Simulation length: "+simulationLength+"s.");
		if(selection==1)
		{
			System.out.println("Simulation mode: Regular.\n");
			//Simulator.simulate(probability, floors, elevators, simulationLength);
			try
			{	
				Simulator.simulate(probability, floors, elevators, simulationLength);
			}catch(EmptyQueueException e)
			{
				System.out.println("Queue is empty at this time");
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Sorry there was not enough time to complete the extra credit");
			System.out.println("But thats because of the MIDTERM!!!!");
			System.out.println("See you after the midterm buddy!!");
			System.out.println("Program terminating");
		}
		/*
		else
		{
			System.out.println("Simulatoin mode: Optimal.\n");
			try
			{	
				Simulator.simulate(probability, floors, elevators, simulationLength);
			}catch(EmptyQueueException e)
			{
				System.out.println("Queue is empty at this time");
				e.printStackTrace();
			}
		}
		*/
		
		input.close();
	}
}
