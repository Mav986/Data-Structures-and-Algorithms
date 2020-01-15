
public class UnitTestPerson
{
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing Person.java ====\n");	
		
		/**
		 * ======== TESTING CONSTRUCTORS ========
		 */		
		Person o1 = new Person();
		Person o2 = new Person("name here","contact email here", "dob here");
		Person o3 = new Person(o2);

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
		o1.setName(o2.getName());
		o1.setContactEmail(o2.getContactEmail());
		o1.setDob(o2.getDob());
		setGetPass = o1.getName().equals(o2.getName()) && o1.getContactEmail().equals(o2.getContactEmail())
				&& o1.getDob().equals(o2.getDob());
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
