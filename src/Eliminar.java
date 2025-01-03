import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Eliminar {
    private JTextField textField1;
    private JButton eliminarButton;
    public JPanel eliminar;
    private JButton volverButton;

    public Eliminar() {

        // Acción del botón "Volver"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar la ventana del menú anterior
                JFrame frame = new JFrame();
                frame.setTitle("Login");
                frame.setSize(350,200);
                frame.setContentPane(new Opciones().menu);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                // Cerrar la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/sistemajugadores";
                String usuario = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    System.out.println("Conectado a la base de datos");

                    // Consulta SQL para eliminar jugadores por nombre
                    String query = "DELETE  FROM jugadores WHERE nombre = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();


                    // Ejecuta la consulta de eliminación y obtiene el número de filas afectadas
                    int filasAfectadas = statement.executeUpdate(query);
                    // Si la eliminación afectó alguna fila, muestra un mensaje de éxit
                    if (filasAfectadas > 0) {
                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Jugador elimnado con exito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    // Manejo de errores en la inserción de datos
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos... \nIngrese correctamente el ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
