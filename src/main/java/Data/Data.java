package Data;

import java.util.HashMap;

import weterynarz.Model.Doctor;

public class Data {
	
	/*
	 * @param String - unique doctor's email
	 * @param Doctor - doctor's object
	 */
	public HashMap<String,Doctor> doctors = new HashMap<String,Doctor>();
	
	private static Data _data;
	
	
	//important!
	private Data(){};
	
	public static Data getInstance()
	{
		if(_data == null)
		{
			_data = new Data();
		}
		
		return _data;
	}
	
	
}
