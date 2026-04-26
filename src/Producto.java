public class Producto {

    //Atributos de la clase:
    private String nombre;
    private int cantidad;
    private double precioUni;
    private double precioSubtotal;

    //Constructor vacío
    public Producto() {

    }

    //Constructor con parametros
    public Producto(String nombre, double precioUni) {
        this.nombre = nombre;
        this.precioUni = precioUni;
    }

    /**
     * Sobreescritura del toString para mostrar datos del producto
     *
     * @return String datos del producto
     */
    @Override
    public String toString() {
        return "Nombre: " + getNombre() +
                " / Cantidad: " + getCantidad() +
                " / Precio Unitario: " + getPrecioUni() +
                " / Total: " + getPrecioSubtotal();
    }

    /**
     * Getter especial para calcular el subtotal de la venta de ese objeto
     *
     * @return double subtotal de la venta por producto
     */
    public double getPrecioSubtotal() {
        //Calculo subtotal
        precioSubtotal = this.cantidad * this.precioUni;

        //Calculo del descuento por mayorista
        if (this.cantidad >= 6) {
            precioSubtotal *= 0.85;
        }

        return precioSubtotal;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(double precioUni) {
        this.precioUni = precioUni;
    }

    public void setPrecioSubtotal(double precioSubtotal) {
        this.precioSubtotal = precioSubtotal;
    }
}
