
public class threadSimples extends Thread {
	public void run() {
		for(int i = 0; i<50; i++) {
			System.out.println("dale " + this.getName());
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t = new threadSimples();
		t.setName("Primeira thread");
		t.start();
		t.join();
		Thread t2 = new threadSimples();
		t2.setName("Segunda thread");
		t2.start();
		t2.join();
		System.out.println("acabou aqui");
	}

}
