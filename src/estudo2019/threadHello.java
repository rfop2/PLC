package estudo2019;

public class threadHello extends Thread {
	public void run() {
		System.out.println("Olá da thread");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new threadHello();
		(new threadHello()).start();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
