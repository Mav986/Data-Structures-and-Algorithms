/**
 * FILE: 		National.java
 * AUTHOR: 		Kalon Shannon-Innes
 * ID: 			18529687
 * UNIT: 		Data Structures and Algorithms
 * DATE: 		May 19, 2017 
 * SOURCE: 		Modified version of NationalBody.java I submitted for Prac01
 * REQUIRES:	Organization.java
 */
public class National extends Organization
{
	private LinkedList<State> states = new LinkedList<State>();

	/**
	 * NAME: Default Constructor 
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create a default National object
	 */
	public National()
	{
		super();
	}

	/**
	 * NAME: Alternate Constructor
	 * IMPORT: inName, inAddress, inContactName, inContactEmail (String)
	 * IMPORT: inStates (State LinkedList)
	 * EXPORT: address of new National object
	 * PURPOSE: Create a custom National object
	 */ 
	public National(String inName, String inShort, String inAddress, String inContactName, 
		    String inContactEmail, LinkedList<State> inStates)
	{
		super(inName, inShort, inAddress, inContactName, inContactEmail);
		setStates(inStates);
	}

	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inNat (National)
	 * EXPORT: address of new copy of National object
	 * PURPOSE: Create a copy of a National object
	 */
	public National(National inNat)
	{
		super(inNat);
		setStates(inNat.getStates());
	}

	/**
	 * NAME: addState 
	 * IMPORT: inState (State)
	 * EXPORT: none
	 * PURPOSE: Add a state to a national object
	 */
	public void addChild(Organization inState)
	{
		states.insertLast((State)inState);
	}
	
	/**
	 * NAME: setStates
	 * IMPORT: inStates (States LinkedList)
	 * EXPORT: none
	 * PURPOSE: Setter for states class field
	 */
	public void setStates(LinkedList<State> inStates)
	{
		for(State s : inStates)
		{
			states.insertLast(new State(s));
		}
	}

	/**
	 * NAME: getStates
	 * IMPORT: none
	 * EXPORT: states (State LinkedList)
	 * PURPOSE: Getter for states class field
	 */
	public LinkedList<State> getStates()
	{
		return states;
	}
}
