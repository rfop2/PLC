import java.sql.Time;

public class Teste extends Thread{
	int inicio,fim;
	public void run() {
		for(int i=this.inicio; i<this.fim; i++) {
			System.out.println("" + i);
		}
		
	}
	public Teste(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Teste(1,100)).start();
		(new Teste(101,200)).start();
		(new Teste(201,300)).start();
		(new Teste(301,400)).start();
		(new Teste(401,500)).start();
		(new Teste(501,600)).start();
		(new Teste(601,700)).start();
	}
}
