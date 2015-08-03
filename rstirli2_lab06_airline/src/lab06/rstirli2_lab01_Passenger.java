package lab06;


public class rstirli2_lab01_Passenger implements Comparable<rstirli2_lab01_Passenger>{
	
	private String name="unknown";
	private String id=null;
	
	public rstirli2_lab01_Passenger(String n, String num)
	{
		name=n;
		id=num;
	}
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return id;
	}

	public int compareTo(rstirli2_lab01_Passenger comp) {
		if (this.name.equals(comp.name))
		{
			if (Integer.parseInt(this.id)>Integer.parseInt(comp.id))
			{
				return -1;
			}
			else if (Integer.parseInt(this.id)<Integer.parseInt(comp.id))
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		else //compare strings
		{
			int k=0;
			boolean again = true;
			while(again)
			{
				if (this.name.toLowerCase().charAt(k)>comp.name.toLowerCase().charAt(k))
				{
					again = false;
					return 1;
				}
				
				else if (this.name.toLowerCase().charAt(k)<comp.name.toLowerCase().charAt(k))
				{
					again = false;
					return -1;
				}
				
				else
				{
					k++;
				}
			}
			
			return 0;
		}
	}
	
	

	
}
