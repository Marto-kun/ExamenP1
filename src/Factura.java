public class Factura {


    private Producto[] arregloFactura;
    private double subtotal;
    private double iva;
    private double total;

    public Factura(Producto[] inventarioRecibido) {
        this.arregloFactura = inventarioRecibido;
    }


    /**
     * Metodo para calcular el subtotal de toda la venta sobre el arreglo
     *
     * @return double subtotal de la venta
     */
    public double calcularSubTotal() {
        this.subtotal = 0;

        //Iteraciones para calcular el subtotal sobre el arreglo
        for (int i = 0; i < arregloFactura.length; i++) {
            Producto p = arregloFactura[i];
            if (p != null) {
                this.subtotal += p.getPrecioSubtotal();
            }
        }

        return subtotal;
    }

    /**
     * Metodo para calcular el IVA sobre el subtotal de la venta
     *
     * @return double IVA
     */
    public double calcularIVA() {
        iva = calcularSubTotal() * 0.15;
        return iva;
    }

    /**
     * Metodo para calcular el total de la venta
     *
     * @return double
     */
    public double calcularTotal() {
        total = calcularSubTotal() + calcularIVA();
        return total;
    }


    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
