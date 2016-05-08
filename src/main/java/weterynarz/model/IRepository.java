package weterynarz.model;

public interface IRepository {
	
	public void add(Item item);
	public void remove(Item item);
	public void printAll();
}
