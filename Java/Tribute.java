//Miriam Wetstein

public class Tribute
{
	private String name;
	private char gender;
	private int district;
	public Tribute(String name, char gender, int district)
	{
		this.name=name;
		this.gender=gender;
		this.district=district;
	
	}
	public Tribute getTribute()
	{
		return this;
	}
	public String getName()
	{
		return this.name;
	}
	public char getGender()
	{
		 
		return this.gender;
	}
	public int getDistrict()
	{
	
		return this.district;
	}
	
}