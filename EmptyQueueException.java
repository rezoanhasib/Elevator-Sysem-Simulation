/**
 * The <CODE>EmptyQueueException</CODE> is a Java Applicaton that extends Exception if the corresponding queue is empty
 * @author rezoanhasib
 * <A> HREF= "mailto:rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 */
public class EmptyQueueException extends Exception {
		/**
		 * This method contains the print message for this kind of exception 
		 */
		public EmptyQueueException()
		{
			super("Queue is empty at this time!!Please try later."); 
		}
}
