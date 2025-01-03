import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Opciones {
    public JPanel menu;
    private JButton agregarJugadorButton;
    private JButton vizualizarJugadoresButton;
    private JButton buscarJugadorButton;
    private JButton eliminarJugadorButton;

    // Constructor de la clase Opciones
    public Opciones() {
        // Acción para el botón "Visualizar Jugadores"
        vizualizarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva ventana (JFrame) para visualizar jugadores
                JFrame frame = new JFrame();
                frame.setTitle("Visualizar Jugadores"); // Título de la ventana
                frame.setSize(350, 200); // Tamaño de la ventana
                frame.setContentPane(new Ver().ver); // Establece el panel de contenido de la ventana
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
                frame.setVisible(true); // Hace visible la ventana
                // Cierra la ventana actual que contiene el botón
                ((JFrame)SwingUtilities.getWindowAncestor(vizualizarJugadoresButton)).dispose();
            }
        });

        // Acción para el botón "Agregar Jugador"
        agregarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva ventana (JFrame) para agregar un jugador
                JFrame frame = new JFrame();
                frame.setTitle("Agregar Jugador"); // Título de la ventana
                frame.setSize(350, 350); // Tamaño de la ventana
                frame.setContentPane(new Agregar().agregar); // Establece el panel de contenido de la ventana
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
                frame.setVisible(true); // Hace visible la ventana
                // Cierra la ventana actual que contiene el botón
                ((JFrame)SwingUtilities.getWindowAncestor(agregarJugadorButton)).dispose();
            }
        });

        // Acción para el botón "Eliminar Jugador"
        eliminarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva ventana (JFrame) para eliminar un jugador
                JFrame frame = new JFrame();
                frame.setTitle("Eliminar Jugadores"); // Título de la ventana
                frame.setSize(350, 200); // Tamaño de la ventana
                frame.setContentPane(new Eliminar().eliminar); // Establece el panel de contenido de la ventana
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
                frame.setVisible(true); // Hace visible la ventana
                // Cierra la ventana actual que contiene el botón
                ((JFrame)SwingUtilities.getWindowAncestor(eliminarJugadorButton)).dispose();
            }
        });

        // Acción para el botón "Buscar Jugador"
        buscarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva ventana (JFrame) para buscar un jugador
                JFrame frame = new JFrame();
                frame.setTitle("Buscar Jugador"); // Título de la ventana
                frame.setSize(350, 200); // Tamaño de la ventana
                frame.setContentPane(new Buscar().buscar); // Establece el panel de contenido de la ventana
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
                frame.setVisible(true); // Hace visible la ventana
                // Cierra la ventana actual que contiene el botón
                ((JFrame)SwingUtilities.getWindowAncestor(buscarJugadorButton)).dispose();
            }
        });
    }
}
