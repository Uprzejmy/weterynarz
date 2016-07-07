package weterynarz.Model;

public interface IRepository<T> {
	void add(T item);
	void remove(T item);
	T findById(int id);
}
