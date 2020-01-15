
public class UnitTestUmpire
{
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing Umpire.java ====\n");	
		
		/**
		 * ======== TESTING CONSTRUCTORS ========
		 */		
		Umpire o1 = new Umpire();
		Umpire o2 = new Umpire("name here","contact email here", "dob here", "accred here");
		Umpire o3 = new Umpire(o2);

		System.out.print("constructors: ");
		boolean consPass = o1.getName().equals("") && o2.getName().equals("name here") && o3.getName().equals("name here");
		if(consPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		/**
		 * ======== TESTING EQUALS ========
		 */
		System.out.print("equals: ");
		boolean equalsPass = o2.equals(o3);
		if(equalsPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		/**
		 * ======== TESTING SETTERS/GETTERS ========
		 */
		System.out.print("set/get: ");
		boolean setGetPass;
		o1.setAccreditation(o2.getAccreditation());
		setGetPass = o1.getAccreditation().equals(o2.getAccreditation());
		if(setGetPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
}
