import java.util.Scanner;

public class Sistema {

    private Scanner sc;

    private Producto p1;
    private Producto p2;
    private Producto p3;

    //Constructor
    public Sistema() {
        this.sc = new Scanner(System.in);
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
        if (p1 != null) {
            System.out.println("1. " + p1.getNombre());
        }

        if (p2 != null) {
            System.out.println("2. " + p2.getNombre());
        }

        if (p3 != null) {
            System.out.println("3. " + p3.getNombre());
        }

        int opc = sc.nextInt();
        int cantidad;

        if (opc == 1) {
            System.out.println("Ingrese la cantidad del producto: ");
            cantidad = sc.nextInt();
            p1.setCantidad(cantidad);
        }

        if (opc == 2) {
            System.out.println("Ingrese la cantidad del producto: ");
            cantidad = sc.nextInt();
            p2.setCantidad(cantidad);
        }

        if (opc == 3) {
            System.out.println("Ingrese la cantidad del producto: ");
            cantidad = sc.nextInt();
            p3.setCantidad(cantidad);
        }

    }

    public void emitirFactura() {
        Factura fac = new Factura(p1, p2, p3);
        fac.calcularSubTotal();
        fac.calcularIVA();
        fac.calcularTotal();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(fac.getSubtotal());
        System.out.println(fac.getIva());
        System.out.println(fac.getTotal());

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
        System.out.println(">>> ");
        opc = sc.nextInt();

        return opc;
    }

}
