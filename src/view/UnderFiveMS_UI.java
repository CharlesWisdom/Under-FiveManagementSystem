package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class UnderFiveMS_UI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// ... parent-NameField, child-NameField, emailField, phoneField, addressField
	
	private JTextField idField = new JTextField(10);
	private JTextField pNameField = new JTextField(40);
	private JTextField cNameField = new JTextField(40);
	private JTextField emailField = new JTextField(30);
	private JTextField phoneField = new JTextField(30);
	private JTextField addressField = new JTextField(100);





	private JButton createButton = new JButton("New");
//	private JButton updateButton = new JButton("Edit");
//	private JButton deleteButton = new JButton("Delete");
//	private JButton firstButton = new JButton("<<");
//	private JButton prevButton = new JButton("<");
//	private JButton nextButton = new JButton(">");
	private JButton lastButton = new JButton(">>");

	// ... updateButton, deleteButton, firstButton, prevButton, nextButton,
	// ...lastButton
	private PatientBean bean = new PatientBean();

	public UnderFiveMS_UI() {
		setBorder((Border) new TitledBorder(new EtchedBorder(), "Patient Details"));
		setLayout(new BorderLayout(5, 5));
		add(initFields(), BorderLayout.NORTH);
		add(initButtons(), BorderLayout.CENTER);
		setFieldData(bean.moveFirst());
	}

	private JPanel initButtons() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		panel.add(createButton);
		createButton.addActionListener((ActionListener) new ButtonHandler());
		// ...
		panel.add(lastButton);
		lastButton.addActionListener(new ButtonHandler());
		return panel;
	}

	private JPanel initFields() {
		JPanel panel = new JPanel();
		//panel.setLayout(new MigLayout());
		panel.add(new JLabel("ID"), "align label");
		panel.add(idField, "wrap");
		idField.setEnabled(false);
		panel.add(new JLabel("Parent's Name"), "align label");
		panel.add(pNameField, "wrap");
		// ...
		panel.add(new JLabel("Phone"), "align label");
		panel.add(phoneField, "wrap");
		return panel;
	}

	private Patient getFieldData() {
		Patient p = new Patient();
		//p.setPatientID(Integer.parseInt(idField.getText()));
		p.setParent_fullname(pNameField.getText());
		p.setChild_fullname(cNameField.getText());
		p.setEmail(emailField.getText());
		p.setPhone(phoneField.getText());
		p.setAddress(addressField.getText());
		return p;
	}

	private void setFieldData(Patient p) {
		//idField.setText(String.valueOf(p.getPatientId()));
		pNameField.setText(p.getParent_fullname());
		cNameField.setText(p.getChild_fullname());
		emailField.setText(p.getEmail());
		phoneField.setText(p.getPhone());
		addressField.setText(p.getAddress());

	}

	private boolean isEmptyFieldData() {
		return (pNameField.getText().trim().isEmpty() && cNameField.getText().trim().isEmpty()
				&& addressField.getText().trim().isEmpty() && emailField.getText().trim().isEmpty()
				&& phoneField.getText().trim().isEmpty());
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
				//p.setPatientId(new Random().nextInt(Integer.MAX_VALUE) + 1);
				p.setParent_fullname("");
				p.setChild_fullname("");
				p.setAddress("");
				p.setEmail("");
				p.setPhone("");
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
						"Patient with ID:" + String.valueOf(p.getPatientID() + " is deleted successfully"));
				break;
			case "First":
				setFieldData(bean.moveFirst());
				break;
			case "Previous":
				setFieldData(bean.movePrevious());
				break;
			case "Next":
				setFieldData(bean.moveNext());
				break;
			case "Last":
				setFieldData(bean.moveLast());
				break;
			default:
				JOptionPane.showMessageDialog(null, "invalid command");
			}
		}


	}

}









