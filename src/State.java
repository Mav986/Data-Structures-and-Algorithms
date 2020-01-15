/**
 * FILE: 		State.java
 * AUTHOR: 		Kalon Shannon-Innes
 * ID: 			18529687
 * UNIT: 		Data Structures and Algorithms
 * DATE: 		May 19, 2017 
 * SOURCE: 		Modified version of StateBody.java I submitted for Prac01
 * REQUIRES:	Organization.java
 */
public class State extends Organization
{
	private LinkedList<Association> associations = new LinkedList<Association>();

	/**
	 * NAME: Default Constructor 
	 * IMPORT: None
	 * EXPORT: none
	 * PURPOSE: Create a default State object
	 */
	public State()
	{
		super();
	}

	/**
	 * NAME: Standard Constructor 
	 * IMPORT: inName, inAddress, inContactName, inContactEmail (String)
	 * IMPORT: inAssociations (Association LinkedList)
	 * EXPORT: none
	 * PURPOSE: 
	 */
	public State(String inName, String inShort, String inAddress, String inContactName,
			String inContactEmail, LinkedList<Association> inAssociations)
	{
		super(inName, inShort, inAddress, inContactName, inContactEmail);
		setAssociations(inAssociations);
	}

	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inStates (State LinkedList)
	 * EXPORT: none
	 * PURPOSE: Create a copy of a State object
	 */
	public State(State inState)
	{
		super(inState);
		setAssociations(inState.getAssociations());
	}

	/**
	 * NAME: addAssociations 
	 * IMPORT: inAssociations (Association)
	 * EXPORT: None
	 * PURPOSE: Add an association to a state
	 */
	public void addChild(Organization inAssociation)
	{
		associations.insertLast((Association)inAssociation);
	}
	
	/**
	 * NAME: setAssociations 
	 * IMPORT: inAssociations (Association LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for associations class field
	 */
	public void setAssociations(LinkedList<Association> inAssociations)
	{
		for(Association a : inAssociations)
		{
			associations.insertLast(new Association(a));
		}
	}

	/**
	 * NAME: getAssociations 
	 * IMPORT: none
	 * EXPORT: associations (Association LinkedList)
	 * PURPOSE: Getter for associations class field
	 */
	public LinkedList<Association> getAssociations()
	{
		return associations;
	}
}
