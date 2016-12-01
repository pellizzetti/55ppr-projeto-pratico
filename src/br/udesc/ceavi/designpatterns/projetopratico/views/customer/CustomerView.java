package br.udesc.ceavi.designpatterns.projetopratico.views.customer;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class CustomerView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private static CustomerTable table;

	public CustomerView() throws SQLException {
		initialize();
	}

	private void initialize() throws SQLException {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new CustomerTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 11, 424, 211);
		
		contentPane.add(scrollPane);

		refreshTable();
	}
	
	public static void refreshTable() throws SQLException {
		table.reload();
    }
}
