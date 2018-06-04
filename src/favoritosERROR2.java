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
 * Esta clase se representará cada vez que el usuario intente añadir a su lisa de favoritos la misma canción por segunda vez
 * @author Álvaro Bernal Pedret
 */
public class favoritosERROR2 extends JFrame {

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
					favoritosERROR2 frame = new favoritosERROR2();
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
	public favoritosERROR2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 188);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Esta canci\u00F3n ya existe en su lista de favoritos");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 524, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton.setBounds(221, 106, 97, 33);
		contentPane.add(btnNewButton);
		
		/**
		 * Evento .addMouseListener que permitirá al usuario cerrar dicho JFrame sin necesidad de tener que darle a la "x"
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			}
		});
	}

}
