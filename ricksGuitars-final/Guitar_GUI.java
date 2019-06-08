//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JPanel;
//import javax.swing.JSplitPane;
//import javax.swing.JLabel;
//import java.awt.GridLayout;
//
//public class Guitar_GUI {
//
//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Guitar_GUI window = new Guitar_GUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Guitar_GUI() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 339, 529);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JPanel bottom_panel = new JPanel();
//		bottom_panel.setBounds(0, 306, 321, 164);
//		frame.getContentPane().add(bottom_panel);
//		bottom_panel.setLayout(new GridLayout(0, 2, 0, 0));
//		
//		JButton btnNewButton = new JButton("SEARCH");
//		bottom_panel.add(btnNewButton);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		
//		JButton btnAdd = new JButton("ADD");
//		btnAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		bottom_panel.add(btnAdd);
//		
//		JPanel top_panel = new JPanel();
//		top_panel.setBounds(0, 0, 321, 94);
//		frame.getContentPane().add(top_panel);
//		top_panel.setLayout(null);
//		
//		JLabel lblWelcom = new JLabel("WELCOM");
//		lblWelcom.setBounds(128, 5, 65, 18);
//		top_panel.add(lblWelcom);
//		
//		JLabel label = new JLabel("RICK's Guitar Store");
//		label.setBounds(103, 54, 140, 24);
//		top_panel.add(label);
//	}
//}
