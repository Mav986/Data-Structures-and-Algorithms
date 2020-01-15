/**
 * FILE: 	Organization.java
 * AUTHOR: 	Kalon J Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Modified version of Organization.java I submitted for Prac01
 */
public class Organization
{
	private String name;
	private String shortName;
	private String address;
	private String contactName;
	private String contactEmail;

	/**
	 * NAME: Default Constructor
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create default Organization object 
	 */
	public Organization()
	{
		setName("");
		setShort("");
		setAddress("");
		setContactName("");
		setContactEmail("");
	}

	/**
	 * NAME: Alternate Constructor
	 * IMPORTS: inName, inAddress, inContactName, inContactEmail (Strings)
	 * EXPORT: none
	 * PURPOSE: Create custom Organization object
	 */
	public Organization(String inName, String inShort, String inAddress, 
		String inContactName, String inContactEmail)
	{
		setName(inName);
		setShort(inShort);
		setAddress(inAddress);
		setContactName(inContactName);
		setContactEmail(inContactEmail);
	}

	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inOrg (Organization)
	 * EXPORT: none
	 * PURPOSE: Create copy of Organization object
	 */
	public Organization(Organization inOrg)
	{
		setName(inOrg.getName());
		setShort(inOrg.getShort());
		setAddress(inOrg.getAddress());
		setContactName(inOrg.getContactName());
		setContactEmail(inOrg.getContactEmail());
	}
	
	/**
	 * NAME: addChild
	 * IMPORT: inOrg (Organization)
	 * EXPORT: none
	 * PURPOSE: Allow a generic Organization object to add a child to a parent
	 */
	public void addChild(Organization inOrg)
	{
		this.addChild(inOrg);
	}

	/**
	 * NAME: setName
	 * IMPORTS: inName (String)
	 * EXPORT: none
	 * PURPOSE: Setter for name class field
	 */
	public void setName(String inName)
	{
		name = inName;
	}

	/**
	 * NAME: getName
	 * IMPORTS: none
	 * EXPORT: name (String)
	 * PURPOSE: Getter for name class field
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * NAME: setShort 
	 * IMPORT: inShort (String)
	 * EXPORT: none
	 * PURPOSE: Setter for shortName class field
	 */
	public void setShort(String inShort)
	{
		shortName = inShort;
	}

	/**
	 * NAME: getShort 
	 * IMPORT: none
	 * EXPORT: shortName (String)
	 * PURPOSE: Getter for shortName class field
	 */
	public String getShort()
	{
	    return shortName;
	}

	/**
	 * NAME: setAddress
	 * IMPORTS: inAddress (String)
	 * EXPORT: none
	 * PURPOSE: Setter for address class field
	 */
	public void setAddress(String inAddress)
	{
		address = inAddress;
	}

	/**
	 * NAME: getAddress
	 * IMPORTS: none
	 * EXPORT: address (String)
	 * PURPOSE: Getter for address class field
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * NAME: setContactName
	 * IMPORTS: inContactName (String)
	 * EXPORT: none
	 * PURPOSE: Setter for contactName class field
	 */
	public void setContactName(String inContactName)
	{
		contactName = inContactName;
	}

	/**
	 * NAME: getContactName
	 * IMPORTS: none
	 * EXPORT: contactName (String)
	 * PURPOSE: Getter for contactName class field
	 */
	public String getContactName()
	{
		return contactName;
	}

	/**
	 * NAME: setContactEmail
	 * IMPORTS: inContactEmail (String)
	 * EXPORT: none
	 * PURPOSE: Setter for contactEmail class field
	 */
	public void setContactEmail(String inContactEmail)
	{
		contactEmail = inContactEmail;
	}

	/**
	 * NAME: getContactEmail
	 * IMPORTS: none
	 * EXPORT: contactEmail (String)
	 * PURPOSE: Getter for contactEmail class field
	 */
	public String getContactEmail()
	{
		return contactEmail;
	}

	/**
	 * NAME: toString
	 * IMPORTS: none
	 * EXPORT: outString (String)
	 * PURPOSE: Convert an Organization object to a String
	 */
	public String toString()
	{
		String outString = "Name: " + this.getName() + "\nAddress: " + this.getAddress() + "\nContact Name: " + this.getContactName() 
		+ "\nContact Email: " + this.getContactEmail();
		
		return outString;
	}

	/**
	 * NAME: equals
	 * IMPORTS: inObj (Object)
	 * EXPORT: isEqual (Boolean)
	 * PURPOSE: Abstract equals method for implementation in subclasses
	 */
	public boolean equals(Object inObj)
	{
		boolean isEqual = false;
		Organization org;
		if(inObj instanceof Organization)
		{
			org = (Organization)inObj;
			if(this.getName().equals(org.getName()))
			{
				isEqual = true;
			}
		}
		
		return isEqual;
	}
}
