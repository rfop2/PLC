
public class TesteJoin extends Thread {
	public void run() {
		System.out.println("hi from a thread");
	}
	public static void main(String[] args) {
	Thread t = new TesteJoin();
	t.start();
	try {
		t.join();
	} catch (InterruptedException ie) {
		System.out.println("n deu certo");
	}
	System.out.println("hi from the main thread");
	
	}
}
