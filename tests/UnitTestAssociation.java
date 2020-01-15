public class UnitTestAssociation
{
	public static void main(String[] args)
	{
		LinkedList<Club> c1 = new LinkedList<Club>();
		LinkedList<Umpire> u1 = new LinkedList<Umpire>();
		Club club = new Club();
		Umpire ump = new Umpire();
		c1.insertLast(club);
		u1.insertLast(ump);
		
		System.out.print("======== TESTING CONSTRUCTORS ========\n\n");
		Association a1 = new Association();
		Association a2 = new Association("name here", "short name here", 
				"address here", "contact name here", "contact email here", c1, u1);
		Association a3 = new Association(a2);
		
		System.out.print("Default: ");
		if(a1.getName().equals(""))
		{
			System.out.print("      pass\n");
		}
		else
		{
			System.out.print("      fail\n");
		}
		
		System.out.print("Standard: ");
		if(a2.getName().equals("name here"))
		{
			System.out.print("     pass\n");
		}
		else
		{
			System.out.print("     fail\n");
		}
		
		System.out.print("Copy: ");
		if(a3.getName().equals("name here"))
		{
			System.out.print("         pass\n\n");
		}
		else
		{
			System.out.print("         fail\n\n");
		}
		
		System.out.print("======== TESTING ADDERS ========\n\n");
		
		System.out.print("Club: ");
		a1.addChild(club);
		Boolean clubAddEqual = false;
		for(Club ca : a2.getClubs())
		{
			for(Club cb : a1.getClubs())
			{
				if(ca.equals(cb))
				{
					clubAddEqual = true;
				}
			}
		}
		if(clubAddEqual)
		{
			System.out.print("         pass\n");
		}
		else
		{
			System.out.print("         fail\n");
		}
		
		System.out.print("Umpires: ");
		a1.addUmpire(ump);
		Boolean umpAddEqual = false;
		for(Umpire ua : a2.getUmpires())
		{
			for(Umpire ub : a1.getUmpires())
			{
				if(ua.equals(ub))
				{
					umpAddEqual = true;
				}
			}
		}
		if(umpAddEqual)
		{
			System.out.print("      pass\n\n");
		}
		else
		{
			System.out.print("      fail\n\n");
		}
		
		System.out.print("======== TESTING EQUALS ========\n\n");
		
		System.out.print("Equal: ");
		if(a3.equals(a2))
		{
			System.out.print("        pass\n");
		}
		else
		{
			System.out.print("        fail\n");
		}
		
		System.out.print("Not equal: ");
		if(!a1.equals(a2))
		{
			System.out.print("    pass\n\n");
		}
		else
		{
			System.out.print("    fail\n\n");
		}
		
		System.out.print("======== TESTING SETTERS/GETTERS ========\n\n");
		
		System.out.print("Clubs: ");
		a1.setClubs(a2.getClubs());
		Boolean clubSetEqual = false;
		for(Club ca : a2.getClubs())
		{
			for(Club cb : a1.getClubs())
			{
				if(ca.equals(cb))
				{
					clubSetEqual = true;
				}
			}
		}
		if(clubSetEqual)
		{
			System.out.print("        pass\n");
		}
		else
		{
			System.out.print("        fail\n");
		}
		
		System.out.print("Umpires: ");
		a1.setUmpires(a2.getUmpires());
		Boolean umpSetEqual = false;
		for(Umpire ua : a2.getUmpires())
		{
			for(Umpire ub : a1.getUmpires())
			{
				if(ua.equals(ub))
				{
					umpSetEqual = true;
				}
			}
		}
		if(umpSetEqual)
		{
			System.out.print("      pass\n");
		}
		else
		{
			System.out.print("      fail\n");
		}		
	}
}
