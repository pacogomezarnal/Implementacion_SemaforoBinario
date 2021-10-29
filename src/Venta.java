
public class Venta implements Runnable{
	private static SemaforoBinario semaforo = null;

	public Venta(SemaforoBinario s) {
    	semaforo = s;
	}
	
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Decrementando...");
            semaforo.decrementa();
        }
    }
}
