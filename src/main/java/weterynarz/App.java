package weterynarz;

import weterynarz.Controller.ContextManager;

public class App {
	// --------------- v2.0 ----------------
	public static void main(String[] args) {
		ContextManager contextManager = ContextManager.getInstance();
		contextManager.run();
	}
	
}
