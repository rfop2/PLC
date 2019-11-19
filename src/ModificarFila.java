class No{
		int numero;
		No proximo;
		
		public int getNumero() {
			return this.numero;
		}
		public void setNumero(int novoNumero) {
			this.numero=novoNumero;
		}
		public No getProximo() {
			return this.proximo;
		}
		public void setProximo(No novoProximo) {
			this.proximo=novoProximo;
		}
	}
	
class Fila{
		No inicio;
		No fim;
		public Fila() {
			this.inicio=null;
			this.fim=null;
		}
		public boolean filaVazia(Fila f) {
			if(f == null) {
				return true;
			} else {
				return (f.inicio == null);
			}
		}
		public void inserir(Fila f, int valor) {
			No novo = new No();
			novo.numero = valor;
			novo.proximo = null;
			
			if(filaVazia(f)) {
				f.inicio = novo;
			} else {
				f.fim.proximo=novo; 
			}
			f.fim=novo;
		}
		public void remover(Fila f) {
			No aux;
			if(filaVazia(f)) {
				System.out.println("fila vazia");
			} 
			aux = f.inicio;
			f.inicio = aux.proximo;
			if(f.inicio == null) {
				f.fim = null;
			}
		}
		public void imprime(Fila f,String thread) {
			if(filaVazia(f)) {
				System.out.println("fila vazia");
			}
			for(No var=f.inicio; var != null; var = var.getProximo()) {
				System.out.println("" + var.numero + " " + thread);
			}
		}	
	}

public class ModificarFila extends Thread{
	public Fila f;
	public String nomeThread;
	public ModificarFila(Fila f1, String nomeThread) {
		this.f = f1;
		this.nomeThread = nomeThread;
	}

	public void run() {
		f.inserir(f, 5);
		f.inserir(f, 10);
		f.inserir(f, 28);
		f.imprime(f,nomeThread);
		f.remover(f);
		f.imprime(f,nomeThread);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fila f1 = new Fila();
		ModificarFila t1 = (new ModificarFila(f1,"thread 1"));
		ModificarFila t2 = (new ModificarFila(f1,"thread 2"));
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
