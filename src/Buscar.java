import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar {
    private JTextField textField1;
    private JButton buscarButton;
    public JPanel buscar;
    private JLabel jugador;
    private JLabel encabezado;
    private JButton volverButton;

    public Buscar() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/sistemajugadores";
                String usuario = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {

                    // Consulta SQL para buscar jugadores por nombre
                    String query = "SELECT * FROM jugadores WHERE nombre = '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);// Ejecutar la consulta

                    // Mostrar los resultados si hay coincidencias
                    while (resultSet.next()) {

                        encabezado.setText(" ID | Nombre | Posicion | Equipo | Edad ");// Encabezado de los datos
                        jugador.setText(resultSet.getString("id")+ " | " + resultSet.getString("nombre")+" | " + resultSet.getString("posicion")+ " | "+ resultSet.getString("equipo")+" | " + resultSet.getString("edad"));
                    }

                } catch (SQLException ex) {
                    // Manejo de errores en la conexión o consulta
                   ex.printStackTrace();
                }

            }

        });


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
    }
}
