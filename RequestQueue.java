import java.util.ArrayList;
import java.util.Vector;

/**
 * The <CODE>RequestQueue</CODE> is a Java Application that generates a Queue of request objects 
 * @author rezoanhasib
 * <A> HREF="mailto: rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 *
 */
public class RequestQueue extends ArrayList<Request> implements Cloneable
{
	/*
	private final int max=200; 
	private int frontQueue; 
	private int rearQueue; 
	private ArrayList<Request> queue; 
	private Request tempRequest; 
	*/
	private Request tempRequest; 

	//debug variable decleration 
	private boolean debug=false; 
	
	/**
	 * The default constructor to create a queue of request with no item present 
	 */
	public RequestQueue() 
	{	
		/*
		frontQueue=-1; 
		rearQueue=-1; 
		queue=new ArrayList<Request>(); 
		*/
		super(); 
	}
	/**
	 * Method to add a request object to the queue in the rear
	 * @param addRequest
	 * 		the request to be added in the queue
	 * @postcondition
	 * 		the new request is added to the queue in the rear 
	 */
	public void enqueue(Request addRequest)
	{
		if(debug)
		{
			System.out.println("Queue is printed below: ");
			for(int a=0;a<super.size();a++)
			{
				System.out.println(((Request) super.get(a)).getSourceFloor()+" "+((Request) super.get(a)).getDestinationFloor()+" "+((Request)super.get(a)).getTimeEntered()); 
			}
		}
		super.add((Request)addRequest); 
		
		if(debug)
		{
			System.out.println("Queue is printed below: ");
			for(int a=0;a<super.size();a++)
			{
				System.out.println(((Request) super.get(a)).getSourceFloor()+" "+((Request) super.get(a)).getDestinationFloor()+" "+((Request)super.get(a)).getTimeEntered()); 
			}
		}
	}
	/**
	 * Method to delete a request object from the queue from the front
	 * @throws EmptyQueueException
	 * 		informs if the 	queue is empty and no value can be returned
	 * @postcondition
	 * 		the rear request is deleted from the queue 
	 */
	public Request dequeue() throws EmptyQueueException 
	{
		if(debug)
		{
			System.out.println("Queue is printed below: ");
			for(int a=0;a<super.size();a++)
			{
				System.out.println(((Request) super.get(a)).getSourceFloor()+" "+((Request) super.get(a)).getDestinationFloor()+" "+((Request)super.get(a)).getTimeEntered()); 
			}
		}
		if(super.isEmpty())
			throw new EmptyQueueException(); 
		tempRequest=(Request) super.get(0); 
		super.remove(0); 
		
		if(debug)
		{
			System.out.println("Queue is printed below: ");
			for(int a=0;a<super.size();a++)
			{
				System.out.println(((Request) super.get(a)).getSourceFloor()+" "+((Request) super.get(a)).getDestinationFloor()+" "+((Request)super.get(a)).getTimeEntered()); 
			}
		}
		
		return tempRequest; 
	}
	/**
	 * Method to obtain the size of a queue
	 * @return
	 * 		the size of selected queue
	 */
	public int size()
	{
		return super.size(); 
	}
	/**
	 * Method to determine if a queue is empty 
	 * @return
	 * 		True-if the queue is empty, false otherwise
	 * 
	 */
	public boolean isEmpty()
	{
		return(super.isEmpty()); 
	}

}
