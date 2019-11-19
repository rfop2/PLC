
public class tempoThread extends Thread {
	int inicio,fim,n;
	public tempoThread(int n, int inicio, int fim) {
		this.n=n;
		this.inicio=inicio;
		this.fim=fim;
	}
	public void run() {
		System.out.println("a thread" + " " + n + " " + "comecou");
		for(int i=this.inicio; i<this.fim; i++) {
			
		}
		System.out.println("a thread" + " " + n + " " + "terminou");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(new tempoThread(1,1,100)).start(); 
		// por Array de thread
		Thread[] lt = {(new tempoThread(1,1,100)),(new tempoThread(2,101,200)),(new tempoThread(3,201,300))};
		
		for(Thread t: lt) {
			t.start();
		}
		for(Thread t: lt) {
			try {
				t.join();
			} catch(InterruptedException e) {
				System.out.println("n deu certo");
			}
		}
		System.out.println("Todas as threads acabaram");
	}

}
