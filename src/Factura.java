public class Factura {

    private Producto p1;
    private Producto p2;
    private Producto p3;
    private double subtotal;
    private double iva;
    private double total;

    public Factura(Producto p1, Producto p2, Producto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * Metodo para calcular el subtotal de toda la venta
     *
     * @return double subtotal de la venta
     */
    public double calcularSubTotal() {
        this.subtotal = 0;
        if (p1 != null) {
            subtotal += p1.getPrecioSubtotal();
        }

        if (p2 != null) {
            subtotal += p2.getPrecioSubtotal();
        }

        if (p3 != null) {
            subtotal += p3.getPrecioSubtotal();
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

    public Producto getP1() {
        return p1;
    }

    public void setP1(Producto p1) {
        this.p1 = p1;
    }

    public Producto getP2() {
        return p2;
    }

    public void setP2(Producto p2) {
        this.p2 = p2;
    }

    public Producto getP3() {
        return p3;
    }

    public void setP3(Producto p3) {
        this.p3 = p3;
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
