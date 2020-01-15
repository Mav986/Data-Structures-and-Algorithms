/**
 * FILE: 		Association.java
 * AUTHOR: 		Kalon Shannon-Innes
 * ID: 			18529687
 * UNIT: 		Data Structures and Algorithms
 * DATE: 		May 19, 2017 
 * SOURCE: 		Modified version of LocalAssociation.java I submitted for Prac01
 * REQUIRES:	Organization.java
 */
public class Association extends Organization
{
	private LinkedList<Club> clubs = new LinkedList<Club>();
	private LinkedList<Umpire> umps = new LinkedList<Umpire>();

	/**
	 * NAME: Default Constructor 
	 * IMPORTS: none
	 * EXPORTS: none
	 * PURPOSE: Create a default Association object
	 */
	public Association()
	{
		super();
	}

	/**
	 * NAME: Standard Constructor 
	 * IMPORTS: inName, inShort, inAddress, inContactName, inContactEmail (String)
	 * IMPORTS: inClubs (Club LinkedList)
	 * EXPORT: none
	 * PURPOSE: Create a customized Association object
	 */
	public Association(String inName, String inShort, String inAddress, String inContactName,
			String inContactEmail, LinkedList<Club> inClubs, LinkedList<Umpire> inUmpires)
	{
		super(inName, inShort, inAddress, inContactName, inContactEmail);
		setClubs(inClubs);
		setUmpires(inUmpires);
	}

	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inAssoc (Association)
	 * EXPORT: none
	 * PURPOSE: Create a copy of an Association object
	 */
	public Association(Association inAssoc)
	{
		super(inAssoc);
		setClubs(inAssoc.getClubs());
		setUmpires(inAssoc.getUmpires());
	}

	/**
	 * NAME: addClub 
	 * IMPORT: inClub (Club)
	 * EXPORT: none
	 * PURPOSE: Add a club to an association
	 */
	public void addChild(Organization inClub)
	{
		clubs.insertLast((Club)inClub);
	}
	
	/**
	 * NAME: setClub 
	 * IMPORT: inClubs (Club LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for the clubs class field
	 */
	public void setClubs(LinkedList<Club> inClubs)
	{
		for(Club club : inClubs)
		{
			clubs.insertLast(club);
		}
	}

	/**
	 * NAME: getClubs 
	 * IMPORT: none
	 * EXPORT: clubs (Club LinkedList)
	 * PURPOSE: Getter for the clubs class field
	 */
	public LinkedList<Club> getClubs()
	{
		return clubs;
	}
	
	/**
	 * NAME: addUmpire
	 * IMPORT: inUmpire (Umpire)
	 * EXPORT: none
	 * PURPOSE: Add an umpire to an association
	 */
	public void addUmpire(Umpire inUmpire)
	{
		umps.insertLast(inUmpire);
	}
	
	/**
	 * NAME: setUmpire
	 * IMPORT: inUmpires (Umpire LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for the umps class field
	 */
	public void setUmpires(LinkedList<Umpire> inUmpires)
	{
		for(Umpire ump : inUmpires)
		{
			umps.insertLast(ump);
		}
	}
	
	/**
	 * NAME: getUmpires
	 * IMPORT: none
	 * EXPORT: umps (Umpire LinkedList)
	 * PURPOSE: Getter for the umps class field
	 */
	public LinkedList<Umpire> getUmpires()
	{
		return umps;
	}
}
