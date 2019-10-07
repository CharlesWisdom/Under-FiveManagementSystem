package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.Patient;
import model.PatientBean;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

public class UnderFiveMS_UI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JTextField idField = new JTextField(40);
	//private final JLabel lblID = new JLabel("PatientID");
	private JTextField pNameField = new JTextField(40);
	private JTextField cNameField = new JTextField(40);
	private JTextField emailField = new JTextField(30);
	private JTextField phoneField = new JTextField(30);
	private JTextField addressField = new JTextField(100);
	private final JLabel lblHeight = new JLabel("Height");
	private final JTextField heightField = new JTextField(40);
	private final JLabel lblWeight = new JLabel("Weight");
	private final JTextField weightField = new JTextField(40);
	private final JLabel lblVaccinations = new JLabel("Vaccinations");
	private final JTextArea txtVaccinations = new JTextArea();




	private JButton createButton = new JButton("New");
	private JButton updateButton = new JButton("Update");
	private JButton deleteButton = new JButton("Delete");
	private JButton firstButton = new JButton("<<");
	private JButton prevButton = new JButton("<");
	private JButton nextButton = new JButton(">");
	private JButton lastButton = new JButton(">>");

	// ... updateButton, deleteButton, firstButton, prevButton, nextButton,
	// ...lastButton
	private PatientBean bean = new PatientBean();
	private final JTextField patientIDField = new JTextField(40);
	private final JLabel lblPatientId = new JLabel("Patient ID :");


	public UnderFiveMS_UI() {
		setBorder((Border) new TitledBorder(new EtchedBorder(), "Patient Details"));
		setLayout(null);
		add(initFields());
		add(initButtons());
		setFieldData(bean.moveFirst());
	}

	private JPanel initButtons() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(10, 265, 770, 58);
		panel.setLayout(null);
		createButton.setBounds(10, 11, 115, 33);
		createButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(createButton);
		createButton.addActionListener((ActionListener) new ButtonHandler());
		updateButton.setBounds(130, 11, 115, 33);
		
		updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(updateButton);
		updateButton.addActionListener((ActionListener) new ButtonHandler());
		deleteButton.setBounds(249, 11, 115, 33);
		
		deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(deleteButton);
		deleteButton.addActionListener((ActionListener) new ButtonHandler());
		firstButton.setBounds(520, 11, 53, 33);
		
		firstButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(firstButton);
		firstButton.addActionListener((ActionListener) new ButtonHandler());
		prevButton.setBounds(584, 11, 53, 33);
		
		prevButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(prevButton);
		prevButton.addActionListener((ActionListener) new ButtonHandler());
		nextButton.setBounds(644, 11, 53, 33);
		
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(nextButton);
		nextButton.addActionListener((ActionListener) new ButtonHandler());
		lastButton.setBounds(707, 11, 53, 33);
		
		lastButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		// ...
		panel.add(lastButton);
		lastButton.addActionListener(new ButtonHandler());
		return panel;
	}

	private JPanel initFields() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(10, 16, 770, 241);
		panel.setLayout(null);
		JLabel label_1 = new JLabel("Parent's Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(5, 59, 109, 25);
		panel.add(label_1);
		pNameField.setBounds(119, 59, 247, 28);
		panel.add(pNameField);
		// ...
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(5, 99, 104, 23);
		panel.add(label_2);
		emailField.setBounds(119, 98, 247, 28);
		panel.add(emailField);
		
		JLabel label_3 = new JLabel("Phone");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(5, 140, 99, 25);
		panel.add(label_3);
		phoneField.setBounds(119, 137, 247, 28);
		panel.add(phoneField);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(5, 176, 94, 25);
		panel.add(label_4);
		addressField.setBounds(119, 176, 247, 49);
		panel.add(addressField);
		
		JLabel label_5 = new JLabel("Name of Child");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(403, 12, 104, 28);
		panel.add(label_5);
		cNameField.setBounds(517, 14, 247, 28);
		panel.add(cNameField);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeight.setBounds(403, 51, 104, 28);
		
		panel.add(lblHeight);
		//heightField.setText("John Mutale");
		heightField.setBounds(517, 53, 247, 28);
		
		panel.add(heightField);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(403, 92, 104, 28);
		
		panel.add(lblWeight);
		//weightField.setText("John Mutale");
		weightField.setBounds(517, 94, 247, 28);
		
		panel.add(weightField);
		lblVaccinations.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVaccinations.setBounds(403, 128, 104, 28);
		
		panel.add(lblVaccinations);
		txtVaccinations.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVaccinations.setBounds(517, 133, 247, 92);
		
		panel.add(txtVaccinations);
		patientIDField.setText("James Mutale");
		patientIDField.setBounds(119, 11, 247, 28);
		
		panel.add(patientIDField);
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientId.setBounds(5, 14, 79, 25);
		
		panel.add(lblPatientId);
		
//		panel.add(idField);
//		idField.setBounds(517, 133, 247, 92);
//		panel.add(lblID);
//		lblID.setBounds(517, 133, 247, 92);
		
		
		return panel;
	}

	private Patient getFieldData() {
		Patient p = new Patient();
		p.setPatientID(Integer.parseInt(patientIDField.getText()));
		p.setParent_fullname(pNameField.getText());
		p.setChild_fullname(cNameField.getText());
		p.setEmail(emailField.getText());
		p.setPhone(phoneField.getText());
		p.setAddress(addressField.getText());
		p.setWeight(weightField.getText());
		p.setHeight(heightField.getText());
		p.setVaccinations(txtVaccinations.getText());
		
		return p;
	}

	private void setFieldData(Patient p) {
		patientIDField.setText(String.valueOf(p.getPatientID()));
		pNameField.setText(p.getParent_fullname());
		cNameField.setText(p.getChild_fullname());
		emailField.setText(p.getEmail());
		phoneField.setText(p.getPhone());
		addressField.setText(p.getAddress());
		weightField.setText(p.getWeight());
		heightField.setText(p.getHeight());
		txtVaccinations.setText(p.getVaccinations());

	}

	private boolean isEmptyFieldData() {
		return (pNameField.getText().trim().isEmpty() 
				&& cNameField.getText().trim().isEmpty()
				&& addressField.getText().trim().isEmpty()
				&& emailField.getText().trim().isEmpty()
				&& phoneField.getText().trim().isEmpty()
				&& weightField.getText().trim().isEmpty()
				&& heightField.getText().trim().isEmpty()
				&& txtVaccinations.getText().trim().isEmpty());
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Patient p = getFieldData();
			switch (e.getActionCommand()) {
			case "Save":
				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot create an empty record");
					return;
				}
				if (bean.create(p) != null)
					JOptionPane.showMessageDialog(null, "New Patient created successfully.");
				createButton.setText("New...");
				break;
			case "New":
				p.setPatientID(new Random().nextInt(Integer.MAX_VALUE) + 1);
				p.setParent_fullname("");
				p.setChild_fullname("");
				p.setAddress("");
				p.setEmail("");
				p.setPhone("");
				p.setWeight("");
				p.setHeight("");
				p.setVaccinations("");
				
				setFieldData(p);
				createButton.setText("Save");
				break;
			case "Update":
				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot update an empty record");
					return;
				}
				if (bean.update(p) != null)
					JOptionPane.showMessageDialog(null,
							"Patient with ID:" + String.valueOf(p.getPatientID() + " is updated successfully"));
				break;
			case "Delete":
				if (isEmptyFieldData()) {
					JOptionPane.showMessageDialog(null, "Cannot delete an empty record");
					return;
				}
				p = bean.getCurrent();
				bean.delete();
				JOptionPane.showMessageDialog(null,
						"Patient with ID:" + String.valueOf(p.getChild_fullname() + " is deleted successfully"));
				break;
			case "<<":
				setFieldData(bean.moveFirst());
				break;
			case "<":
				setFieldData(bean.movePrevious());
				break;
			case ">":
				setFieldData(bean.moveNext());
				break;
			case ">>":
				setFieldData(bean.moveLast());
				break;
			default:
				JOptionPane.showMessageDialog(null, "invalid command");
			}
		}


	}

}









