package br.udesc.ceavi.designpatterns.projetopratico.views.product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductView extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel panContent = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	
	public AddProductView(Frame parent, boolean modal) {
        super(parent, modal);
        initialize();
    }

	private void initialize() {
		setBounds(100, 100, 424, 205);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
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
				btnSave.setActionCommand("OK");
				panButtons.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
		}
	}

}
