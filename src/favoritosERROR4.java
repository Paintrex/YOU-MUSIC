import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase se representará cada vez que el usuario intente clickar sobre el botón "ACEPTAR" (para iniciar la busqueda de una lista de canciones favoritas) pero el campo esté vacío.
 * @author Álvaro Bernal Pedret
 */
public class favoritosERROR4 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					favoritosERROR4 frame = new favoritosERROR4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public favoritosERROR4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 188);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escribe el ID de tu amigo para ver su lista de canciones favoritas");
		lblNewLabel.setForeground(new Color(153, 204, 153));
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 524, 63);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAceptar.setBounds(221, 85, 103, 35);
		contentPane.add(btnAceptar);
		
		/**
		 * Evento .addMouseListener que permitirá al usuario cerrar dicho JFrame sin necesidad de tener que darle a la "x"
		 */
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			}
		});
	}

}
