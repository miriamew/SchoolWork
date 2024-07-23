//Miriam Wetstein



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HungerGames 
{
	public static void main(String[] args)
	{
	
	Tribute deceased; // name of deceased tribute
	ArrayList<Tribute> tributes = new ArrayList<>();
	HashMap<String, Tribute> tributeMap = new HashMap<>();
	
	tributes.add(new Tribute("Cato", 'm', 2));
	tributes.add(new Tribute("Katniss", 'f', 12));
	tributes.add(new Tribute("Peeta", 'm', 12));
	tributes.add(new Tribute("Rue", 'f', 11));
	tributes.add(new Tribute("Finnick", 'm', 4));
	
	
	Collections.shuffle(tributes);
	
	
	for (Tribute t: tributes)

	{
		
		tributeMap.put(t.getName(), t);
	}
	
	for (int i=0; i<(tributes.size()-1) ; i++)
	{
		deceased=tributes.get(i);
		tributeMap.remove(deceased.getName());
		System.out.print("\n"+deceased.getName()+ ", "+deceased.getGender()+", from district "+deceased.getDistrict()+", is out of the game");
		
	}
	System.out.print("\n" + tributeMap.keySet());
	
	} // end main
} // end HungerGames
	