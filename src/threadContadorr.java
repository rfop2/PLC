import java.util.Scanner;

public class threadContadorr extends Thread{
	private int limite;
	
	public  threadContadorr(int limite) {
		this.limite = limite;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	public void run() {
		for(int i=0; i<limite; i++) {
			if(ehPrimo(i)) {
				System.out.println("" + i);
			}
		}
	}
	
	private boolean ehPrimo(int i) {
		int div=0;
		for(int cont=1; cont<=i; cont++) {
			if(i % cont == 0) {
				div++;
			}
		}
		if(div == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int inicio = 0;
		int n = in.nextInt();
		int qntsThreads = in.nextInt();
		Thread[] threads = new Thread[qntsThreads];
		int intervalo = n/qntsThreads;
		int ini = 2;
		int fim = intervalo;
		
		
		for(int i=0; i<qntsThreads; i++) {
			Thread t = new threadContadorr(intervalo);
			threads[i] = t;
			t.start();
			t.join();
			
			
		}
		System.out.println("acabou");
		
	}

}
