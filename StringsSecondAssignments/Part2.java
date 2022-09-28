
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int howMany(String stringa, String stringb)
    {
		int count = 0;
		int exist = stringb.indexOf(stringa, 0);
		while (exist != -1)
		{
		    count++;
		    exist = stringb.indexOf(stringa, exist + stringa.length());
		}
		return count;
}

public void test()
    {
		//String stringa = "GAA";
		//String stringb = "ATGAACGAATTGAATC";
		
		String stringa = "AA";
		String stringb = "ATAAAA";
		
		System.out.println("count: " + howMany(stringa, stringb));
}

}
