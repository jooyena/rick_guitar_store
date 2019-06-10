import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RickSotreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField model;
	private JTextField builder;
	private JTextField numstring;
	private JTextField type;
	private JTextField downwood;
	private JTextField topwood;
	private JTextField price;
	private JTextField serialnumber;
	private JLabel builderLabel;
	private JLabel numstringLabel;
	private JLabel topwoodLabel;
	private JLabel modelLabel;
	private JLabel typeLabel;
	private JLabel downwoodLabel;
	private JLabel priceLabel;
	private JLabel serialnumberLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RickSotreGUI frame = new RickSotreGUI();
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
	public RickSotreGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		new start();

	}

	public class start {
		public start() {
			JPanel startPanel = new JPanel();
			startPanel.setBounds(14, 27, 715, 479);
			contentPane.add(startPanel);
			startPanel.setLayout(null);

			JButton SEARCH = new JButton("SEARCH");
			SEARCH.setBounds(127, 400, 91, 27);
			startPanel.add(SEARCH);

			JButton ADD = new JButton("ADD");
			ADD.setBounds(506, 400, 61, 27);
			startPanel.add(ADD);

			JLabel lblRickSotre = new JLabel("Rick's Guitar Store");
			lblRickSotre.setBounds(167, 79, 368, 59);
			startPanel.add(lblRickSotre);
			lblRickSotre.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 45));
		}
	}

	public void change(String paneName) {
		
		if (paneName.equals("ADD")) {
			MainPanel panel = new MainPanel();
			getContentPane().removeAll();
			getContentPane().add(panel);
			revalidate();
			repaint();
		}
		else {
			MainPanel panel = new MainPanel();
			panel.remove(priceLabel);
			panel.remove(price);
			panel.remove(serialnumberLabel);
			panel.remove(serialnumber);
			getContentPane().removeAll();
			getContentPane().add(panel);
		}
	}

	class MainPanel extends JPanel {

		public MainPanel() {

			MainPanel SearchPanel = new MainPanel();
			SearchPanel.setBounds(14, 138, 715, 368);
			contentPane.add(SearchPanel);
			SearchPanel.setLayout(null);

			model = new JTextField();
			model.setBounds(463, 29, 164, 24);
			SearchPanel.add(model);
			model.setColumns(10);

			builder = new JTextField();
			builder.setBounds(171, 29, 151, 24);
			SearchPanel.add(builder);
			builder.setColumns(10);

			numstring = new JTextField();
			numstring.setBounds(463, 106, 164, 24);
			SearchPanel.add(numstring);
			numstring.setColumns(10);

			type = new JTextField();
			type.setBounds(171, 106, 151, 24);
			SearchPanel.add(type);
			type.setColumns(10);

			downwood = new JTextField();
			downwood.setBounds(463, 178, 164, 24);
			SearchPanel.add(downwood);
			downwood.setColumns(10);

			topwood = new JTextField();
			topwood.setBounds(171, 178, 151, 24);
			SearchPanel.add(topwood);
			topwood.setColumns(10);

			JButton searchButton = new JButton("Search!");
			searchButton.setBounds(298, 329, 105, 27);
			SearchPanel.add(searchButton);

			builderLabel = new JLabel("builder");
			builderLabel.setBounds(73, 32, 62, 18);
			SearchPanel.add(builderLabel);

			numstringLabel = new JLabel("string number");
			numstringLabel.setBounds(363, 109, 100, 18);
			SearchPanel.add(numstringLabel);

			topwoodLabel = new JLabel("topWood");
			topwoodLabel.setBounds(73, 181, 62, 18);
			SearchPanel.add(topwoodLabel);

			modelLabel = new JLabel("model");
			modelLabel.setBounds(363, 32, 62, 18);
			SearchPanel.add(modelLabel);

			typeLabel = new JLabel("type");
			typeLabel.setBounds(73, 109, 62, 18);
			SearchPanel.add(typeLabel);

			downwoodLabel = new JLabel("downWood");
			downwoodLabel.setBounds(363, 181, 86, 18);
			SearchPanel.add(downwoodLabel);

			price = new JTextField();
			price.setColumns(10);
			price.setBounds(171, 257, 151, 24);
			SearchPanel.add(price);

			priceLabel = new JLabel("price");
			priceLabel.setBounds(73, 260, 84, 18);
			SearchPanel.add(priceLabel);

			serialnumber = new JTextField();
			serialnumber.setColumns(10);
			serialnumber.setBounds(463, 257, 164, 24);
			SearchPanel.add(serialnumber);

			serialnumberLabel = new JLabel("serial Number");
			serialnumberLabel.setBounds(363, 260, 175, 18);
			SearchPanel.add(serialnumberLabel);
		}

	}
}
