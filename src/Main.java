
public class Main {
    public static void main(String[] args) {

        Sistema sis = new Sistema();
        int opc;
        int prodCreados = 0;


        do {
            opc = Sistema.menu();
            switch (opc) {
                case 1:
                    if (prodCreados >= 3){
                        System.out.println("Ya se crearon todos los productos posibles, intente con otra opcion.");
                        break;
                    }

                    sis.asignarProductoIndividual(prodCreados);
                    prodCreados++;
                    System.out.println("Producto registrado con exito (" + prodCreados + "/3)");
                    break;

                case 2:
                    if(prodCreados == 0){
                        System.out.println("No existen productos, intente crear uno primero.");
                        break;
                    }
                    sis.venderProducto();
                    break;

                case 3:
                    if(prodCreados == 0){
                        System.out.println("No existen productos, intente crear uno primero.");
                        break;
                    }
                    System.out.println("Emitiendo Factura...");
                    sis.emitirFactura();
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