package br.udesc.ceavi.designpatterns.projetopratico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import br.udesc.ceavi.designpatterns.projetopratico.views.customer.*;

public class Client {

	private JFrame frmPrincipal;
	private CustomerView frmCostumer;

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					Client window = new Client();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Client() {

		initialize();
	}

	private void initialize() {

		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Design Patterns Movie Rental");
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.setSize(1366, 768);
		frmPrincipal.setLocationRelativeTo(null);
		frmPrincipal.setResizable(false);

		try {
			frmCostumer = new CustomerView();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		UIManager.put("ComboBox.background", new ColorUIResource(Color.WHITE));
		UIManager.put("ComboBox.listBackground", new ColorUIResource(Color.WHITE));

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastrar");
		menuBar.add(mnCadastros);

		JMenuItem mntmCadastrarClientes = new JMenuItem("Cliente");
		mntmCadastrarClientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				new AddCustomerView(frmPrincipal, true).setVisible(true);
			}
		});

		JMenuItem mntmCadastrarProdutos = new JMenuItem("Produto");
		mntmCadastrarProdutos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				JOptionPane.showMessageDialog(frmPrincipal, "Produtos");
			}
		});

		mnCadastros.add(mntmCadastrarClientes);
		mnCadastros.add(mntmCadastrarProdutos);

		JMenu mnListagem = new JMenu("Listar");
		menuBar.add(mnListagem);

		JMenuItem mntmListarClientes = new JMenuItem("Cliente");
		mntmListarClientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				frmCostumer.setVisible(true);
			}
		});

		mnListagem.add(mntmListarClientes);
	}
}
