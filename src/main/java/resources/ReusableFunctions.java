package resources;


//Function to see if message have success word
public class ReusableFunctions {
	
	 public String validation(String[] funcstr)
		{
		String actual = null;
		for (String sri : funcstr)
		{ if (sri.equalsIgnoreCase("successfully!"))
		{
			actual = sri;	
			break;
		}}
		return actual;
		}
	 
	 
}
