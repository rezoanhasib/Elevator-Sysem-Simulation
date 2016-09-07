/**
 * The <CODE>BooleanSource</CODE> is a Java Application holds a method that checks if there is a new request  
 * @author rezoanhasib
 * <A> HREF="mailto: rezoan0308@gmail.com">(rezoan0308@gmail.com)</A>
 *
 */
public class BooleanSource {

	private double probability; 
	/**
	 * This method check if the entered probability is valid 
	 * @param inputProbability
	 * 		the user entered probability 
	 * @throws IllegalArgumentException
	 * 		Informs if the input probability is out of range 
	 */
	public BooleanSource(double inputProbability) throws IllegalArgumentException
	{
		if(inputProbability<0.0||inputProbability>1.0)
			throw new IllegalArgumentException("Given probability is out of range!!"); 
		probability=inputProbability; 
	}
	/**
	 * This method creates a request depending on the entered probability of a request
	 * @return
	 */
	public boolean arrived()
	{
		return (Math.random()<probability); 
	}
	

}
