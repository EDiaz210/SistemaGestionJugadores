import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JLabel validacion;
    public JPanel logIn;

    public login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/sistemajugadores";
                String usuario = "root";
                String password = "123456";


                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    Statement statement = connection.createStatement();
                    // Consulta SQL para verificar las credenciales
                    String query = "SELECT * FROM usuarios WHERE usuario = '" + textField1.getText() + "' AND contraseña = '" + new String(passwordField1.getPassword()) + "'";
                    ResultSet resultSet = statement.executeQuery(query);


                    // Validar que los datos ingresados coincidan con los de la base de datos
                    if(resultSet.next()) { // Mueve el cursor a la primera fila si hay resultados
                        // Validar que los datos ingresados coincidan con los de la base de datos
                        if(textField1.getText().equals(resultSet.getString("usuario")) && new String(passwordField1.getPassword()).equals(resultSet.getString("contraseña"))) {
                            JFrame frame = new JFrame();
                            frame.setTitle("Login");
                            frame.setSize(350, 200);
                            frame.setContentPane(new Opciones().menu);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setVisible(true);
                            // Cerrar la ventana actual
                            ((JFrame) SwingUtilities.getWindowAncestor(button1)).dispose();
                        }
                    }else {
                        validacion.setText("Digite correctamente las credenciales");
                    }
                } catch (SQLException ex) {
                    // Manejo de errores en la conexión o consulta SQL
                    ex.printStackTrace(); // es una excepcion que ayuda a encontrar de forma precisa y mas rapida el error
                }


            }
        });
    }
}
