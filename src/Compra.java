
public class Compra  implements Runnable{
    private static SemaforoBinario semaforo = null;

    public Compra(SemaforoBinario s) {
    	semaforo = s;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Incrementando...");
            semaforo.incrementa();
        }
    }


}
