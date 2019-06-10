import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TEst extends JFrame {
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
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label;
	private JLabel serialnumberLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEst frame = new TEst();
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
	public TEst() {
		JPanel SearchPanel = new JPanel();
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
		searchButton.setBounds(299, 317, 105, 27);
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
