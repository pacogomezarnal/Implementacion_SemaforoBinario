
public class Main {

	public static void main(String[] args) {
        Thread Comprador = new Thread(new Compra(SemaforoBinario.getInstance()));
        Thread Vendedor = new Thread(new Venta(SemaforoBinario.getInstance()));

        Comprador.start();
        Vendedor.start();

	}

}
