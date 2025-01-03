import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ver {
    private JButton mostrarJugadoresButton;
    public JPanel ver;
    private JTable table2;
    private JButton volverButton;

    public Ver() {

        mostrarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/sistemajugadores";
                String usuario = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM jugadores";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Crear un modelo para la tabla
                    DefaultTableModel tableModel = new DefaultTableModel();

                    // Agregar las columnas
                    tableModel.addColumn("ID");
                    tableModel.addColumn("Nombre Completo");
                    tableModel.addColumn("Posición");
                    tableModel.addColumn("Equipo");
                    tableModel.addColumn("Edad");

                    // Llenar el modelo de la tabla con los datos del ResultSet
                    while (resultSet.next()) {
                        Object[] row = {
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("posicion"),
                                resultSet.getString("equipo"),
                                resultSet.getInt("edad")
                        };
                        tableModel.addRow(row);
                    }

                    // Establecer el modelo de la tabla
                    table2.setModel(tableModel);

                } catch (SQLException ex) {
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
