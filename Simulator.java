import java.util.Scanner;

/**
 * The <CODE>Simulator</CODE> is a Java Applicaton that simulates the environment for an elevator, 
 * and returns the anticipated waiting time 
 * @author rezoanhasib
 * <A> HREF= "mailto:rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 */
public class Simulator 
{
	/**
	 * This method takes in parameters, simulates the environment according to those parameters, and 
	 * calculates the average time a request has to wait until an elevator picks up that request and 
	 * moves towards the destination floor
	 * @param probability
	 * 		the probability of producing a request each second 
	 * @param floors
	 * 		the total number of floors in the building 
	 * @param totalElevators
	 * 		the total number of elevators in the building 
	 * @param length
	 * 		the intended length of the simulation 
	 * @throws EmptyQueueException
	 * 		informs if the Queue is empty and there's no request to serve
	 * @throws FullQueueException
	 * 		informs if the queue is full and no more request can be added to the queue
	 */
	public static void simulate(double probability,int floors,int totalElevators,int length) throws EmptyQueueException 
	{
		RequestQueue mainQueue=new RequestQueue(); 
		int currentTime; 
		BooleanSource request=null;
		Scanner input=new Scanner(System.in); 
		boolean flag=false; 
		while(flag==false)
		{
			try
			{
				request=new BooleanSource(probability);
				flag=true; 
			}catch(IllegalArgumentException e)
			{
				System.out.println("\nEntered probability is out of range!!"); 
				e.printStackTrace();
				System.out.println("Please enter a value between 0.0 and 1.0 inclusive: ");
				probability=input.nextDouble(); 
			}
		}
		int totalWaitingTime=0; 
		int requestServed=0;
		double avgWaitingTime; 
		Elevator[] currentElevator =new Elevator[totalElevators]; 
		int a=0; 
		//debug variable decleration 
		boolean debug=false; 
		//creating the total number of elevators as objects 
		for(int b=0;b<totalElevators;b++)
		{
			currentElevator[b]=new Elevator();
			
			if(debug)
			{
				System.out.println("Elevator "+b+" Status "+currentElevator[b].getStatus()+"CurrentFloor: "+currentElevator[b].getCurrentFloor());
			}
		}
		for(currentTime=0;currentTime<length;currentTime++)
		{
			if(debug)
			{
				System.out.println("Time: "+currentTime+"\n");
			}
			//if request arrives
				if(request.arrived())
				{
				Request newRequest=new Request(floors); 

				if(debug)
				{
					System.out.println("A request has arrived");
				}
				mainQueue.enqueue(newRequest);
				/*
				newRequest.setDestinationFloor((int)(Math.random()*floors+1));
				newRequest.setSourceFloor((int)(Math.random()*floors+1));
				newRequest.setTimeEntered(currentTime);
				mainQueue.enqueue(newRequest); 
				*/

			//if there's a request and any elevator is idle
			if(!mainQueue.isEmpty())
			{
				//checking which elevator is idle 
				for(a=0;a<totalElevators;a++)
				{
					if(currentElevator[a].getStatus()==0)
					{
						if(debug)
						{
							System.out.println("Elevator: "+a+" is idle and being given a request");
						}
						//idle elevator is being given the request and it's corresponding source and destination floor is set  
						try{
							currentElevator[a].setRequest(mainQueue.dequeue());
						
						}catch(EmptyQueueException e){
							System.out.println("Queue is empty at this time");
							e.printStackTrace();
						}
						
						currentElevator[a].setDestinationFloor(currentElevator[a].getRequest().getDestinationFloor());
						currentElevator[a].setSourceFloor(currentElevator[a].getRequest().getSourceFloor());
						currentElevator[a].setTimeEntered(currentElevator[a].getRequest().getTimeEntered());
						currentElevator[a].setStatus(1); 
						/*
						if(debug)
						{
							System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
						}
						*/
						break; 
					}
				}
				if(debug)
				{
					if(a==totalElevators)
					{
						System.out.println("All the Elevators are busy at this time");
					}
				}
			}	
			for(a=0;a<totalElevators;a++)
			{
				if(currentElevator[a].getStatus()!=0)
				{
					if(debug)
					{
						System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
					}
					//Given elevators status will change now 
					//if elevator has reached the source floor or if it has picked up before and going towards destination 
					if(currentElevator[a].getCurrentFloor()==currentElevator[a].getSourceFloor() || currentElevator[a].getStatus()==3)
					{
						if(currentElevator[a].getCurrentFloor()==currentElevator[a].getSourceFloor())
						{	
							totalWaitingTime+=(currentTime-currentElevator[a].getTimeEntered());
							requestServed++;
							if(debug)
							{
								System.out.println(totalWaitingTime+"   "+requestServed);
								System.out.println("Elevator: "+a+" has just picked up a request!");
							}
						}
						
						if(currentElevator[a].getCurrentFloor()<currentElevator[a].getDestinationFloor())
						{	
							if(debug)
							{
								System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
							}
							
							currentElevator[a].setStatus(3); 
							currentElevator[a].setCurrentFloor(currentElevator[a].getCurrentFloor()+1); 
						
							if(debug)
							{
								System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
							}
						
						}
						else if(currentElevator[a].getCurrentFloor()==currentElevator[a].getDestinationFloor())
						{
							currentElevator[a].setStatus(0);
							if(debug)
							{
								System.out.println("Elevator "+a+" has reached the destination floor. Is idle now");	
								System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
							}
						}
					
						else 
						{
							if(debug)
							{
								System.out.println("Elevator "+a+" has picked up the request");
								System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
							}
							currentElevator[a].setStatus(3); 
							currentElevator[a].setCurrentFloor(currentElevator[a].getCurrentFloor()-1);
						
							if(debug)
							{
								System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
							}
						}
					}
					//if the elevator has not picked up and going towards the source floor
					else if(currentElevator[a].getCurrentFloor()<currentElevator[a].getSourceFloor() && (currentElevator[a].getStatus()==1 || currentElevator[a].getStatus()==2))
					{
						if(debug)
						{
							System.out.println("Elevator "+a+" is going up to pick up");
						}
						currentElevator[a].setStatus(2); 
						currentElevator[a].setCurrentFloor(currentElevator[a].getCurrentFloor()+1); 
						
						if(debug)
						{
							System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
						}
					}
				
					//if the elevator has not picked up and going towards the source floor
					else if(currentElevator[a].getCurrentFloor()>currentElevator[a].getSourceFloor() && (currentElevator[a].getStatus()==1 || currentElevator[a].getStatus()==2))
					{
						if(debug)
						{
							System.out.println("Elevator "+a+" is going down to pick up");
							System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
						}
						currentElevator[a].setStatus(2);
						currentElevator[a].setCurrentFloor(currentElevator[a].getCurrentFloor()-1); 
					
						if(debug)
						{
							System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
						}
					}
					
				}
				
			}
		
		}
				
		}
		if(debug)
		{
			System.out.print("\nSimulation time: "+length+"s has ended.No more unhandled requests will");
			System.out.println(" be served at this time.\n");
		}
		System.out.println("Result: ");
		System.out.println("------\n");
		System.out.println("Total wait time: "+totalWaitingTime+"s.");
		System.out.println("Total Requests: "+requestServed+".");
		avgWaitingTime=(double)totalWaitingTime/requestServed; 
		
		if(Double.isNaN(avgWaitingTime))
		{
			System.out.println("\nThe average waiting time is not a number!!");
		}
		else 
		{
			System.out.printf("Average wait time: %.2f",avgWaitingTime);
			System.out.println("s.");
		}
	
		input.close();
	}
}
