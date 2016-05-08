package weterynarz.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Repository implements IRepository {
	protected ArrayList<Item> items = new ArrayList<Item>();
	
	public void add(Item item)
	{
		items.add(item);
	}

	public void remove(Item item) 
	{
		items.remove(item);
	}
	
	public void printAll()
	{
		Iterator<Item> i = items.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next().toString());
		}
	}
}
