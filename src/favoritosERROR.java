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
 * Esta clase se representará cada vez que el usuario intente clickar el botón "Añadir a favoritos" sin haber buscado una canción previamente
 * @author Álvaro Bernal Pedret
 */
public class favoritosERROR extends JFrame {

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
					favoritosERROR frame = new favoritosERROR();
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
	public favoritosERROR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 189);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busque la canci\u00F3n previamente antes de a\u00F1adirla a favoritos");
		lblNewLabel.setForeground(new Color(153, 204, 153));
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 524, 85);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAceptar.setBounds(218, 107, 114, 33);
		contentPane.add(btnAceptar);
		
		/**
		 * Evento .addMouseListener que permitirá al usuario cerrar dicho JFrame sin necesidad de tener que darle a la "x"
		 */
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				dispose();
				
			}
		});
	}
}
