package apriori.pk;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class Apriori 
{

	public static void main(String[] args) throws Exception
	{
		List<String> list=new ArrayList<String>();
		HashMap<String, Integer> hm=new HashMap<>();
		Scanner read=new Scanner(new File("tweets.txt"));
		int i=0;
		while(read.hasNext())
		{
			String str=read.nextLine();
			String split[]=str.split("\\s+");
			for (String s1:split)
			{
				list.add(s1);
			}
		}
		
		int k=0;
		for (i=0;i<list.size()-1;i++)
		{
			for (int j=0;j<list.size();j++)
			{
				if(list.get(i).equals(list.get(j)))
				{
					k++;
				}
								
			}
			hm.put(list.get(i), k);
			k=0;
		}
					
		read.close();
		int q=0;
		
		for (Entry<String, Integer> entry:hm.entrySet())
		{
			if (entry.getKey().startsWith("1")||entry.getKey().startsWith("2")){}
			else
			{
				if(entry.getValue()>=50)
				{
					System.out.print(entry.getKey()+"   ");
					System.out.println(entry.getValue());
					q++;
				}
			}
		}
		System.out.println("Frequent Items: "+q);
	}

}
