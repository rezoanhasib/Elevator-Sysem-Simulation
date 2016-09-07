/**
 * The <CODE>Elevator</CODE> is a Java Applicaton that creates an elevator 
 * @author rezoanhasib
 * <A> HREF= "mailto:rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 */
public class Elevator {
	
	public final int IDLE=0;
	public final int NOT_IDLE=1;
	public final int TO_SOURCE=2; 
	public final int TO_DESTINATION=3; 
	private int currentFloor;
	private int destinationFloor; 
	private int sourceFloor;
	private int timeEntered; 
	public int elevatorState; 
	public Request request; 
	public int status;
	
	//extra credit
	public final int UP=4; 
	public final int DOWN=5; 
	public int direction; 
	//
	/**
	 * The default constructor creates an elevator object that has a status 0 and 
	 * current floor= destination floor=source floor=1 
	 */
	public Elevator()
	{
		status=0;
		currentFloor=1; 
		destinationFloor=1; 
		sourceFloor=1; 
	}
	/**
	 * Method to obtain the current floor of an elevator
	 * @return
	 * 		the current floor of selected floor
	 * @postcondition 
	 * 		the current floor of selected floor is returned
	 */
	public int getCurrentFloor()
	{
		return currentFloor; 
	}
	/**
	 * Method to obtain the status of an elevator
	 * @return
	 * 		the status of selected floor
	 * @postcondition 
	 * 		the status of selected floor is returned
	 */
	public int getElevatorState()
	{
		return elevatorState; 
	}
	/**
	 * Method to return the request a corresponding elevator is dealing with 
	 * @return
	 * 		the request an elevator is serving at current time 
	 * @postcondition 
	 * 		the request an elevator is serving at current time is returned
	 */
	public Request getRequest()
	{
		return request; 
	}
	/**
	 * Method to set the current floor of an elevator
	 * @param currentFloor
	 * 		the current floor of an elevator 
	 * @postcondition 
	 * 		the current floor of selected elevator is set 
	 */
	public void setCurrentFloor(int currentFloor)
	{
		this.currentFloor=currentFloor; 
	}
	/**
	 * Method to set the status of an elevator
	 * @param elevatorState
	 * 		the status of an elevator 
	 * @postcondition 
	 * 		the status of selected elevator is set 
	 */
	public void setElevatorState(int elevatorState)
	{
		this.elevatorState=elevatorState; 
	}
	/**
	 * Method to set the destination floor of an elevator
	 * @param destinationFloor
	 * 		the current floor of an elevator 
	 * @postcondition 
	 * 		the destination floor of selected elevator is set 
	 */
	public void setDestinationFloor(int destinationFloor)
	{
		this.destinationFloor=destinationFloor; 
	}
	/**
	 * Method to set the source floor of an elevator
	 * @param sourceFloor
	 * 		the source floor of an elevator 
	 * @postcondition 
	 * 		the source floor of selected elevator is set 
	 */
	public void setSourceFloor(int sourceFloor)
	{
		this.sourceFloor=sourceFloor; 
	}
	/**
	 * Method to set the time a request was given to an elevator
	 * @param timeEntered
	 * 		the time when selected elevator was given a request 
	 * @postcondition 
	 * 		the time when selected elevator was given a request is set 
	 */
	public void setTimeEntered(int timeEntered)
	{
		this.timeEntered=timeEntered; 
	}
	/**
	 * Method to obtain the destination floor of an elevator
	 * @postcondition 
	 * 		the destination floor of selected elevator is returned
	 */
	public int getDestinationFloor()
	{
		return destinationFloor; 
	}
	/**
	 * Method to obtain the source floor of an elevator
	 * @postcondition 
	 * 		the source floor of selected elevator is returned
	 */
	public int getSourceFloor()
	{
		return sourceFloor; 
	}
	/**
	 * Method to get the time a request was given to an elevator
	 * @postcondition 
	 * 		the time when selected elevator was given a request is returned 
	 */
	public int getTimeEntered()
	{
		return timeEntered; 
	}
	/**
	 * Method to set the request a corresponding elevator is being given  
	 * @postcondition 
	 * 		the request a corresponding elevator needs to serve at current time is set 
	 */
	public void setRequest(Request request)
	{
		this.request=request; 
	}
	/**
	 * Method to set the status of an elevator whether it's going to destination or source or it's idle 
	 * @param status
	 * 		the status of corresponding elevator 
	 * @postcondition 
	 * 		the status of corresponding elevator is set 
	 */
	//set the status of the elevator 
	public void setStatus(int status)
	{
		this.status=status; 
	}
	/**
	 * Method to obtain the status of corresponding elevator
	 * @return
	 * 		the status of corresponding elevator
	 */
	//get the status of the elevator 
	public int getStatus()
	{
		return status; 
	}
	
	
	//EXTRA CREDIT
	public void setDirection(int direction)
	{
		this.direction=direction; 
	}
	public int getDirection()
	{
		return direction; 
	}
	//
}
