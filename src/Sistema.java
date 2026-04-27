import javax.swing.*;
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
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del producto: ");
        String precioStr = JOptionPane.showInputDialog(null, "Ingrese el precio unitario: ");

        double precioUni = Double.parseDouble(precioStr);  //Parseo de String a Double precio

        Producto prod = new Producto(nombre, precioUni);

        return prod;
    }

    /**
     * Metodo para vender un producto
     *
     */
    public void venderProducto() {
        String menuVenta = "Seleccione el producto a vender: \n";

        //Impresion de los productos disponibles segun el arreglo
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                menuVenta += (i + 1) + ". " + inventario[i].getNombre() + "\n";
            }
        }

        String opcEntrada = JOptionPane.showInputDialog(null, menuVenta);
        int opc = Integer.parseInt(opcEntrada);
        int index = opc - 1;   //Formato de indice ya que empieza en 0

        if (index >= 0 && index < inventario.length) {
            if (inventario[index] != null) {

                String cantidadStr = JOptionPane.showInputDialog(null,
                        "\nIngrese la cantidad de "
                                + inventario[index].getNombre() + ": ");

                int cantidad = Integer.parseInt(cantidadStr);
                inventario[index].setCantidad(cantidad);
                JOptionPane.showMessageDialog(null, "Cantidad asignada con éxito.");

            } else {
                JOptionPane.showMessageDialog(null, "El producto seleccionado no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Opcion invalida");
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

        String impFactura = "---- Detalle ----\n"; //Se define la variable que se va a mostrar en pantalla


        //Impresion de los datos del producto dentro del arreglo inventario[]
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null) {
                impFactura += inventario[i] + "\n";
            }
        }


        //Mostrar los valores de facturacion en ventana emergente
        impFactura += "----------------------------\n";
        impFactura += "Subtotal: " + fac.getSubtotal() + "\n";
        impFactura += "IVA: " + fac.getIva() + "\n";
        impFactura += "Total de la Venta: " + fac.getTotal() + "\n";

        JOptionPane.showMessageDialog(null, impFactura);

    }

    /**
     * Metodo static para crear menu en la clase Main
     *
     * @return int opcion elegida
     */
    public static int menu() {
        String menu = "---- Menu Principal ----\n" +
                "1) Crear Producto\n" +
                "2) Vender producto\n" +
                "3) Emitir Factura\n" +
                "4) Salir\n\n" +
                "Seleccione una opcion";

        String entrada = JOptionPane.showInputDialog(null, menu);
        int opc;
        if (entrada == null) {
            opc = 4;
        } else {
            opc = Integer.parseInt(entrada);
        }

        return opc;
    }

}
