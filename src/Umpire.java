/**
 * FILE: 		Umpire.java
 * AUTHOR: 		Kalon Shannon-Innes
 * ID: 			18529687
 * UNIT: 		Data Structures and Algorithms
 * DATE: 		May 19, 2017 
 * SOURCE: 		Version 1.0
 * REQUIRES: 	Person.java
 */
public class Umpire extends Person
{
    private String accreditation;
    
	/**
	 * NAME: Default Constructor 
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create a default Umpire object
	 */
	public Umpire()
	{
		super();
		setAccreditation("");
	}
    
    /**
     * NAME: Standard Constructor 
     * IMPORT: inName, inContactEmail, inDob, inAccreditation (String)
     * EXPORT: none
     * PURPOSE: Create a custom Umpire object
     */
    public Umpire(String inName, String inContactEmail, String inDob, String inAccreditation)
    {
    	super(inName, inContactEmail, inDob);
    	setAccreditation(inAccreditation);
    }
    
    /**
     * NAME: Copy Constructor 
     * IMPORT: inUmpire (Umpire)
     * EXPORT: none
     * PURPOSE: Create a copy of an Umpire object
     */
    public Umpire(Umpire inUmpire)
    {
    	super(inUmpire);
    	setAccreditation(inUmpire.getAccreditation());
    }
    
    /**
     * NAME: setAccreditation
     * IMPORT: inAccreditation (String)
     * EXPORT: none
     * PURPOSE: Setter for accreditation class field
     */
    public void setAccreditation(String inAccreditation)
    {
    	accreditation = inAccreditation;
    }
    
    /**
     * NAME: getAccreditation 
     * IMPORT: none
     * EXPORT: accreditation (String)
     * PURPOSE: Getter for accreditation class field
     */
    public String getAccreditation()
    {
    	return accreditation;
    }
    
    /**
     * NAME: toString 
     * IMPORT: none
     * EXPORT: outString (String)
     * PURPOSE: Convert an Umpire object to a String
     */
    public String toString()
    {
    	String outString = super.toString() + "\nAccreditation Level: " + this.getAccreditation();
    	
    	return outString;
    }
}
