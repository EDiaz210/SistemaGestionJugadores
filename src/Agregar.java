import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agregar {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton agregarButton;
    private JLabel agregado;
    public JPanel agregar;
    private JButton volverButton;

    public Agregar() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/sistemajugadores";
                String usuario = "root";
                String password = "123456";

                // Consulta SQL para insertar datos en la tabla "jugadores"
                String query = "INSERT INTO jugadores (id, nombre, posicion ,equipo, edad ) VALUES (?, ?, ?, ?, ?)";


                // Obtener datos de los campos de texto
                String id = textField1.getText().trim();
                String nombre = textField2.getText().trim();
                String posicion = textField3.getText().trim();
                String equipo = textField4.getText().trim();
                int edad = Integer.parseInt(textField5.getText().trim());

                try(Connection connection = DriverManager.getConnection(url, usuario, password)){
                    // Crear una consulta preparada para evitar inyección SQL
                    PreparedStatement cadenaPreparada = connection.prepareStatement(query);

                    // Configurar los parámetros de la consulta preparada
                    cadenaPreparada.setString(1,id);
                    cadenaPreparada.setString(2,nombre);
                    cadenaPreparada.setString(3,posicion);
                    cadenaPreparada.setString(4,equipo);
                    cadenaPreparada.setInt(5,edad);

                    // Ejecutar la consulta
                    cadenaPreparada.executeUpdate();

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Datos insertados con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }catch (SQLException e3){
                    // Manejo de errores en la inserción de datos
                    e3.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos... \nIngrese correctamente el ID", "Error", JOptionPane.ERROR_MESSAGE);
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
