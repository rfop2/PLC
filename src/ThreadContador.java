
public class ThreadContador extends Thread {
	private int cont;
	private int val_limite;
	
	public ThreadContador(int valorLimite) {
		this.val_limite=valorLimite;
		this.cont=0;
	}
	
	public void run() {
		for(int i=0; i<val_limite; i++) {
			cont++;
			System.out.println(cont);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new ThreadContador(5)).start();
		(new ThreadContador(10)).start();
		(new ThreadContador(20)).start();
	}

}
