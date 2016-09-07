
public class OptimalSimulator {
	
	public static void simulate(double probability,int floors,int totalElevators,int length) throws FullQueueException, EmptyQueueException
	{
		RequestQueue mainQueue=new RequestQueue(); 
		int currentTime; 
		BooleanSource request=new BooleanSource(probability); 
		int totalWaitingTime=0; 
		int requestServed=0;
		double avgWaitingTime; 
		Request newRequest=new Request(); 
		Elevator[] currentElevator =new Elevator[totalElevators]; 
		int a=0; 
		//debug variable decleration 
		boolean debug=true; 
		
		//creating the total number of elevators as separate objects 
		for(int b=0;b<totalElevators;b++)
		{
			currentElevator[b]=new Elevator();
			
			if(debug)
			{
				System.out.println("Elevator "+b+" Status "+currentElevator[b].getStatus()+"CurrentFloor: "+currentElevator[b].getCurrentFloor());
			}

		}
		//time count starts 
		for(currentTime=0;currentTime<length;currentTime++)
		{
			//if request arrives
			if(request.arrived())
			{
				if(debug)
				{
					System.out.println("A request has arrived");
				}
				newRequest.setDestinationFloor((int)(Math.random()*floors+1));
				newRequest.setSourceFloor((int)(Math.random()*floors+1));
				newRequest.setTimeEntered(currentTime);
				mainQueue.enqueue(newRequest); 
				
			}
		
		//if there's a request 
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
					currentElevator[a].setRequest(mainQueue.dequeue());
					currentElevator[a].setDestinationFloor(currentElevator[a].getRequest().getDestinationFloor());
					currentElevator[a].setSourceFloor(currentElevator[a].getRequest().getSourceFloor());
					currentElevator[a].setTimeEntered(currentElevator[a].getRequest().getTimeEntered());
					currentElevator[a].setStatus(1); 
						
					if(debug)
					{
						System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
					}
					break; 
				}
			}
				if(a==totalElevators)
				{
					System.out.println("All the Elevators are busy at this time");
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
						currentElevator[a].setDirection(4);
					
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
						currentElevator[a].setDirection(5);
						
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
					currentElevator[a].setDirection(4);

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
					currentElevator[a].setDirection(5);

					if(debug)
					{
						System.out.println("Time: "+currentTime+" Elevator"+a+" CurrentFloor: "+currentElevator[a].getCurrentFloor()+"Source Floor: "+currentElevator[a].getSourceFloor()+"Destination floor: "+currentElevator[a].getDestinationFloor()+"timeentered: "+currentElevator[a].getTimeEntered()+" status: "+currentElevator[a].getStatus()); 
					}
				}
				
			}
			
		}
		
	}
		
	}

}
