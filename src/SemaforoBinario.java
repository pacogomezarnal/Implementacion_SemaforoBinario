
public class SemaforoBinario {
	
	//Single-ton
	private static SemaforoBinario semaforo;
	//Implementacion semaforo binario
	private static int recurso = 1;

	//Single-ton
	private SemaforoBinario() {
		
	}
    public final static SemaforoBinario getInstance(){
        if(semaforo == null){
        	semaforo = new SemaforoBinario();
        }
        return semaforo;
    }
    //Protocolo de salida
    public synchronized void incrementa(){
        while(estaDisponible()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        recurso += 1;

        reporte();

        this.notifyAll();
    }
    //Protocolo de entrada
    public synchronized void decrementa(){
        while(!estaDisponible()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        recurso -= 1;

        reporte();

        this.notifyAll();
    }
    
    public synchronized final static boolean estaDisponible(){
        return recurso == 1 ? true : false;
    }
    
    public synchronized final static void reporte(){
        System.out.println("Valor del recurso: " + recurso);
    }


}
