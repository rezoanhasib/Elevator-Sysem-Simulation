/**
 * The <CODE>Request</CODE> is a Java Applicaton that creates a request object that has a 
 * given source floor, a destination floor and the time it was created. 
 * @author rezoanhasib
 * <A> HREF= "mailto:rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 */
public class Request {
	
	private int sourceFloor; 
	private int destinationFloor; 
	private int timeEntered; 
	//debug variable decleration 
	private boolean debug=false; 
	/**
	 * Default constructor to create a request object 
	 */
	public Request(int floors)
	{
		this.destinationFloor=((int)(Math.random()*floors+1));
		this.setSourceFloor((int)(Math.random()*floors+1));	
	}
	/**
	 * Method to obtain the source floor of a particular request 
	 * @return
	 * 		the source floor of given request 
	 */
	public int getSourceFloor()
	{
		return sourceFloor; 
	}
	/**
	 * Method to obtain the destination floor of a particular request 
	 * @return
	 * 		the destination floor of given request 
	 */
	public int getDestinationFloor()
	{
		return destinationFloor; 
	}
	/**
	 * Method to obtain the time a particular request was entered 
	 * @return
	 * 		the source floor of given request 
	 */
	public int getTimeEntered()
	{
		return timeEntered; 
	}
	/**
	 * Method to set the source floor of a request 
	 * @param sourceFloor
	 * 		the source floor to be set 
	 * @postcondition
	 * 		the source floor of the corresponding request is set 
	 */
	public void setSourceFloor(int sourceFloor)
	{
		if(debug)
		{
			System.out.println("Source floor- "+sourceFloor);
		}
		this.sourceFloor=sourceFloor; 
	}
	/**
	 * Method to set the destination floor of a request 
	 * @param destinationFloor
	 * 		the destination floor to be set 
	 * @postcondition
	 * 		the destination floor of the corresponding request is set 
	 */
	public void setDestinationFloor(int destinationFloor)
	{
		if(debug)
		{
			System.out.println("destination floor "+destinationFloor);
		}
		this.destinationFloor=destinationFloor; 
	}
	/**
	 * Method to set the time a request was entered
	 * @param timeEntered
	 * 		the entered time to be set 
	 * @postcondition
	 * 		the time a request was entered is set 
	 */
	public void setTimeEntered(int timeEntered)
	{
		if(debug)
		{
			System.out.println("timeEntered- "+timeEntered);
		}
		this.timeEntered=timeEntered; 
	}
	
}
