import java.util.Scanner;

public class Sistema {

    private Scanner sc;

    private Producto p1;
    private Producto p2;
    private Producto p3;
    private Producto[] inventario = new Producto[3];

    //Constructor
    public Sistema() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Getter especial para leer "inventario"
     *
     * @return
     */
    public Producto[] getInventario() {
        return inventario;
    }

    /**
     * Metodo para registrar productos de forma individual al arreglo de inventario
     *
     * @param contador revisa cuantos productos ya fueron creados
     */
    public void asignarProductoIndividual(int contador) {
        this.inventario[contador] = crearProducto();
    }

    /**
     * Metodo para crear un objeto tipo producto nuevo
     *
     * @return Producto nuevo producto
     */
    public Producto crearProducto() {
        System.out.println("Ingreso de datos del producto: ");
        System.out.print("Nombre: ");
        String nombre = sc.next();

        System.out.print("Precio Unitario: ");
        double precioUni = sc.nextDouble();

        Producto prod = new Producto(nombre, precioUni);

        return prod;
    }

    /**
     * Metodo para vender un producto
     *
     */
    public void venderProducto() {
        System.out.println("Seleccione el producto a vender: ");

        //Impresion de los productos disponibles segun el arreglo
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                System.out.println((i + 1) + ". " + inventario[i].getNombre());
            }
        }

        System.out.println(">>> ");
        int opc = sc.nextInt();
        int index = opc - 1;   //Formato de indice ya que empieza en 0

        if (index >= 0 && index < inventario.length) {
            if (inventario[index] != null) {
                System.out.print("Ingrese la cantidad de " + inventario[index].getNombre() + ": ");
                int cantidad = sc.nextInt();
                inventario[index].setCantidad(cantidad);
            } else {
                System.out.println("El producto seleccionado no existe");
            }

        } else {
            System.out.println("Opcion ingresada no valida.");
        }

    }

    /**
     * Metodo para emitir facturacion de los 3 productos
     */
    public void emitirFactura() {
        //Establecer los atributos de facturacion
        Factura fac = new Factura(this.inventario);
        fac.setSubtotal(fac.calcularSubTotal());
        fac.setIva(fac.calcularIVA());
        fac.setTotal(fac.calcularTotal());

        //Impresion de los datos del producto dentro del arreglo inventario[]
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                System.out.println(inventario[i]);
            }
        }

        //Impresion de los valores de facturacion
        System.out.println("Subtotal: " + fac.getSubtotal());
        System.out.println("IVA: " + fac.getIva());
        System.out.println("Total de la Venta: " + fac.getTotal());

    }

    /**
     * Metodo static para crear menu en la clase Main
     *
     * @return int opcion elegida
     */
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opc;

        System.out.println("---- Menu Principal ----");
        System.out.println("1) Crear Producto");
        System.out.println("2) Vender Producto");
        System.out.println("3) Emitir Factura");
        System.out.println("4) Salir");
        System.out.print(">>> ");
        opc = sc.nextInt();

        return opc;
    }

}
