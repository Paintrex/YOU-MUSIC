import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase se representará cada vez que el usuario intente buscar la lista de canciones favoritas de una ID no existente
 * @author Álvaro Bernal Pedret
 */
public class favoritosERROR3 extends JFrame {

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
					favoritosERROR3 frame = new favoritosERROR3();
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
	public favoritosERROR3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 188);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdIncorrecto = new JLabel("ID INCORRECTO");
		lblIdIncorrecto.setForeground(new Color(153, 204, 153));
		lblIdIncorrecto.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblIdIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdIncorrecto.setBounds(10, 11, 524, 64);
		contentPane.add(lblIdIncorrecto);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAceptar.setBounds(220, 86, 103, 37);
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
