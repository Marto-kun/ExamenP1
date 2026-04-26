
public class Main {
    public static void main(String[] args) {

        Sistema sis = new Sistema();
        int opc;
        int prodCreados = 0;


        opc = Sistema.menu();
        do {
            switch (opc) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("Emitiendo Factura...");
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida, intentelo de nuevo.");
                    break;

            }
        } while (opc != 4);


    }
}