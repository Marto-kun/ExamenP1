import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    //Atributos de ventana:
    private Sistema sis;
    private int prodCreados;

    //Componentes de la ventana:
    private JButton btnCrear;
    private JButton btnVender;
    private JButton btnFacturar;
    private JButton btnSalir;
    private JLabel lblTitulo;

    public VentanaPrincipal(Sistema sisExterno) {
        this.sis = sisExterno;
        this.prodCreados = 0;

        //Construccion de la ventana:
        this.setTitle("Facturacion de Productos");
        this.setSize(450, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(5, 1, 10, 10));     //Layout de botones

        //Creacion de componentes
        this.lblTitulo = new JLabel("Panel de Control", SwingConstants.CENTER);
        this.btnCrear = new JButton("1. Crear Producto");
        this.btnVender = new JButton("2. Vender Producto");
        this.btnFacturar = new JButton("3. Emitir Factura");
        this.btnSalir = new JButton("4. Salir");

        //Agregar componentes a la ventana
        this.add(lblTitulo);
        this.add(btnCrear);
        this.add(btnVender);
        this.add(btnFacturar);
        this.add(btnSalir);

        //Acciones de los botones:

        //Crear:
        btnCrear.addActionListener(new ActionListener() {
            @Override   //Sobreescribir el actionPerformed
            public void actionPerformed(ActionEvent e) {
                if (prodCreados < 3) {
                    sis.asignarProductoIndividual(prodCreados);
                    prodCreados++;
                    JOptionPane.showMessageDialog(null,
                            "Producto Registrado (" + prodCreados + "/3)");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Ya se crearon los 3 productos. Intente otra opcion");
                }
            }
        });

        //Vender:
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prodCreados > 0) {
                    sis.venderProducto();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Debe crear un producto primero");
                }
            }
        });

        //Facturar
        btnFacturar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prodCreados == 3) {
                    sis.emitirFactura();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Debe registrar todos los productos primero");
                }
            }
        });

        //Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}
