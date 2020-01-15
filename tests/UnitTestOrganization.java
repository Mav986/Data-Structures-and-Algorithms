
public class UnitTestOrganization
{
	public static void main(String[] args)
	{
		System.out.print("======== TESTING CONSTRUCTORS ========\n\n");
		
		TestOrg t1 = new TestOrg();
		TestOrg t2 = new TestOrg("name here", "short name here", "address here", "contact name here", "contact email here");
		TestOrg t3 = new TestOrg(t2);
		
		System.out.print("Default: ");
		if(t1.getName().equals(""))
		{
			System.out.print("      pass\n");
		}
		else
		{
			System.out.print("      fail\n");
		}
		
		System.out.print("Standard: ");
		if(t2.getName().equals("name here"))
		{
			System.out.print("     pass\n");
		}
		else
		{
			System.out.print("     fail\n");
		}
		
		System.out.print("Copy: ");
		if(t3.getName().equals("name here"))
		{
			System.out.print("         pass\n\n");
		}
		else
		{
			System.out.print("         fail\n\n");
		}	
		
		System.out.print("======== TESTING EQUALS ========\n\n");
		
		System.out.print("Equal: ");
		if(t3.equals(t2))
		{
			System.out.print("        pass\n");
		}
		else
		{
			System.out.print("        fail\n");
		}
		
		System.out.print("Not equal: ");
		if(!t1.equals(t2))
		{
			System.out.print("    pass\n");
		}
		else
		{
			System.out.print("    fail\n");
		}
		
		System.out.print("======== TESTING SETTERS/GETTERS ========\n\n");
		
		System.out.print("Name: ");
		t1.setName(t2.getName());
		if(t1.getName().equals(t2.getName()))
		{
			System.out.print("         pass\n");
		}
		else
		{
			System.out.print("         fail\n");
		}
		
		System.out.print("Short name: ");
		t1.setShort(t2.getShort());
		if(t1.getShort().equals(t2.getShort()))
		{
			System.out.print("   pass\n");
		}
		else
		{
			System.out.print("   fail\n");
		}
		
		System.out.print("Address: ");
		t1.setAddress(t2.getAddress());
		if(t1.getAddress().equals(t2.getAddress()))
		{
			System.out.print("      pass\n");
		}
		else
		{
			System.out.print("      fail\n");
		}
		
		System.out.print("Contact name: ");
		t1.setContactName(t2.getContactName());
		if(t1.getContactName().equals(t2.getContactName()))
		{
			System.out.print(" pass\n");
		}
		else
		{
			System.out.print(" fail\n");
		}
		
		System.out.print("Contact email: ");
		t1.setContactEmail(t2.getContactEmail());
		if(t1.getContactEmail().equals(t2.getContactEmail()))
		{
			System.out.print("pass\n\n");
		}
		else
		{
			System.out.print("fail\n\n");
		}
		
		System.out.print("======== TESTING TOSTRING ========\n\n");
		
		String t2ManString = "Name: name here" + "\nAddress: address here" 
								+ "\nContact Name: contact name here" + "\nContact Email: contact email here";
		String t2ToString = t2.toString();
		
		System.out.print("ToString: ");
		if(t2ManString.equals(t2ToString))
		{
			System.out.print("     pass\n\n");
		}
		else
		{
			System.out.print("     fail\n\n");
		}
	}
	
	public static class TestOrg extends Organization
	{
		public TestOrg()
		{
			super();
		}
		
		public TestOrg(String name, String inShort, String address, String contactName, String contactEmail)
		{
			super(name, inShort, address, contactName, contactEmail);
		}
		
		public TestOrg(TestOrg testOrg)
		{
			super(testOrg);
		}
		
		public boolean equals(Object inObj)
		{
			Boolean equals = false;
			TestOrg testOrg;
			if(inObj instanceof TestOrg)
			{
				testOrg = (TestOrg)inObj;
				if(testOrg.getName().equals(this.getName()))
				{
					equals = true;
				}
			}
			
			return equals;
		}
	}
}
