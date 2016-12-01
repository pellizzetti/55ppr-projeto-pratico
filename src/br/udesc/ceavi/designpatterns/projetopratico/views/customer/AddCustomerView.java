package br.udesc.ceavi.designpatterns.projetopratico.views.customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.udesc.ceavi.designpatterns.projetopratico.controllers.CustomerController;
import br.udesc.ceavi.designpatterns.projetopratico.models.customer.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddCustomerView extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel panContent = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private CustomerController controller;
	
	public AddCustomerView(Frame parent, boolean modal) {
        super(parent, modal);
        initialize();
    }

	private void initialize() {
		setBounds(100, 100, 424, 118);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		controller = CustomerController.getInstance();
		
		getContentPane().setLayout(new BorderLayout());
		panContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panContent, BorderLayout.CENTER);
		panContent.setLayout(null);
		{
			JLabel lblFirstName = new JLabel("Nome:");
			lblFirstName.setBounds(10, 16, 38, 14);
			panContent.add(lblFirstName);
		}
		{
			txtFirstName = new JTextField();
			txtFirstName.setBounds(58, 11, 115, 25);
			txtFirstName.setColumns(10);
			panContent.add(txtFirstName);
		}
		{
			JLabel lblLastName = new JLabel("Sobrenome:");
			lblLastName.setBounds(194, 16, 75, 14);
			panContent.add(lblLastName);
		}
		{
			txtLastName = new JTextField();
			txtLastName.setBounds(269, 11, 115, 25);
			txtLastName.setColumns(10);
			panContent.add(txtLastName);
		}
		{
			JPanel panButtons = new JPanel();
			panButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panButtons, BorderLayout.SOUTH);
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				panButtons.add(btnCancel);
			}
			{
				JButton btnSave = new JButton("Gravar");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Customer aCustomer = new Customer(getFirstName(), getLastName());
						
						try {
							controller.insert(aCustomer);
							
							txtFirstName.setText("");
							txtLastName.setText("");
							
							JOptionPane.showMessageDialog(null, aCustomer.getFirstName() + " salvo com sucesso!");
							
							CustomerView.refreshTable();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				btnSave.setActionCommand("OK");
				panButtons.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
		}
	}
	
	public void reload() {
		
	}
	
	private String getFirstName() {
		return txtFirstName.getText();
	}
	
	private String getLastName() {
		return txtLastName.getText();
	}
}
