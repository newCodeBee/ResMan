package ResMan.RegressionE2E;

public class test {
	public static void main(String[] args) {
		String s = "Credit Builder posted successfully! Print or Email Receipt";
		String sr[] = s.split(" ");
		System.out.println(sr.length);
		String actual;
		for (String sri : sr)
		{ if (sri.equalsIgnoreCase("successfully!"))
		{
			actual = sri;
			System.out.println(actual);
			break;
		}
			
		}
	}
}
