/**
 * The <CODE>FullQueueException</CODE> is a Java Applicaton that extends Exception if the corresponding queue is full
 * @author rezoanhasib
 * <A> HREF= "mailto:rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 */
public class FullQueueException extends Exception {
	/**
	 * This method contains the print message for this kind of exception 
	 */
	public FullQueueException()
	{
		super("Queue is full at this time!!Please try later. "); 
	}
}
