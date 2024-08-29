package visual;

import model.Estadio;
import utils.DBManager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class GestionEstadio extends JDialog {
	private final JPanel contentPanel = new JPanel();

	private JLabel lblDatosErroneos;
	private JLabel lblD;
	private JLabel lblNombre;
	private JLabel lblCapacidad;
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JTextField textFieldCapacidad;

	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnCancelar;
	private JButton btnGuardar;

	private JList<Estadio> list = new JList<Estadio>();
	private Model_Estadio modelo = new Model_Estadio();
	private JPanel panel;

	public GestionEstadio() {
		setResizable(false);
		setFont(new Font("SansSerif", Font.PLAIN, 18));
		setTitle("Gestión de estadios");
		setBounds(100, 100, 678, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(143, 182, 155));
		contentPanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 83, 71)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 16, 286, 364);
		contentPanel.add(scrollPane);
		scrollPane.setViewportView(list);
		list.setFont(new Font("SansSerif", Font.PLAIN, 18));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(modelo);

		textFieldID = new JTextField();
		textFieldID = new JTextField();
		textFieldID = new JTextField();

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int indice = list.getSelectedIndex();
				btnEliminar.setEnabled(indice > -1);
//				desactivar_habilitar(indice <= -1);
				if (indice > -1) {
					Estadio c = modelo.getEstadioAt(indice);

					textFieldID.setText(c.id+"");
					textFieldNombre.setText(c.nombre);
					textFieldCapacidad.setText(c.capacidad+"");

					btnNuevo.setEnabled(true);
					btnEditar.setEnabled(true);

				} else {
					btnEditar.setEnabled(false);
				}
			}
		});
		modelo.setlstEstadios(DBManager.read());

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(22, 406, 89, 29);
		btnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnAgregar.setVisible(true);
				desactivar_habilitar(true);
				list.setEnabled(false);
				textFieldID.requestFocusInWindow();
				btnEliminar.setEnabled(false);
				btnNuevo.setEnabled(false);
				btnEditar.setEnabled(false);
				btnGuardar.setVisible(true);
				btnCancelar.setVisible(true);
			}
		});
		contentPanel.add(btnNuevo);

		btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(126, 406, 89, 29);
		btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desactivar_habilitar(list.getSelectedIndex() > -1);
				list.setEnabled(false);
				textFieldID.requestFocusInWindow();
				btnEliminar.setEnabled(false);
				btnNuevo.setEnabled(false);
				btnEditar.setEnabled(false);
				btnGuardar.setVisible(true);
				btnCancelar.setVisible(true);
			}
		});
		contentPanel.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(223, 406, 105, 29);
		btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = list.getSelectedIndex();
					if (indice != -1) {
						if (JOptionPane.showConfirmDialog(null, "Est� seguro que desea eliminar este estadio?",
								"Confirmar", 0) == 0) {
							modelo.removeEstadio(list.getSelectedIndex());
							limpiar();
							desactivar_habilitar(false);
						}
					}
			}
		});
		contentPanel.add(btnEliminar);

		// #region JPanel con los datos del estadio
		panel = new JPanel();
		panel.setBackground(new Color(143, 182, 155));
		panel.setBounds(313, 20, 327, 189);
		contentPanel.add(panel);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Datos del estadio", TitledBorder.LEADING, TitledBorder.TOP, new Font("SansSerif", Font.PLAIN, 17), new Color(0, 0, 0)));
		panel.setLayout(null);

		lblD = new JLabel("ID");
		lblD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblD.setFont(new Font("SansSerif", Font.PLAIN, 18));
//		lblD.setBounds(51, 29, 64, 21);
		panel.add(lblD);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNombre.setBounds(40, 61, 75, 21);
		panel.add(lblNombre);

		lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCapacidad.setBounds(15, 99, 100, 21);
		panel.add(lblCapacidad);

		textFieldID = new JTextField();
		textFieldID.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldID.setBounds(130, 26, 184, 25);
		panel.add(textFieldID);
		textFieldID.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(130, 61, 117, 25);
		panel.add(textFieldNombre);

		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldCapacidad.setBounds(130, 96, 184, 25);
		panel.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);
//		GestionCandidato.soloLetras(textFieldNombre);

		// #endregion

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnAgregar.setVisible(false);
		btnAgregar.setBounds(15, 150, 95, 29);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textFieldID.getText());
				String nombre = textFieldNombre.getText();
				int capacidad = Integer.parseInt(textFieldCapacidad.getText());

				boolean proceder = true; // validarDatos(id, nombre, capacidad);

				if (proceder) {
					Estadio x = new Estadio(id, nombre, capacidad);
					modelo.addEstadio(x);
					desactivar_habilitar(false);
					list.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnEditar.setEnabled(true);
					btnNuevo.setEnabled(true);

					btnAgregar.setVisible(false);
					btnCancelar.setVisible(false);
				}
			}
		});
		panel.add(btnAgregar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnGuardar.setVisible(false);
		btnGuardar.setBounds(15, 150, 95, 29);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = list.getSelectedIndex();
				Estadio x;

				int id = Integer.parseInt(textFieldID.getText());
				String nombre = textFieldNombre.getText();
				int capacidad = Integer.parseInt(textFieldCapacidad.getText());

				boolean proceder = true; // validarDatos(id, nombre, capacidad);

				if (proceder) {
					x = new Estadio (id, nombre, capacidad);

					DBManager.update(Integer.parseInt(textFieldID.getText()), textFieldNombre.getText(), Integer.parseInt(textFieldCapacidad.getText())); // nuevo
					modelo.updateEstadio(indice, x);
					desactivar_habilitar(false);
					list.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnEditar.setEnabled(true);
					btnNuevo.setEnabled(true);

					btnGuardar.setVisible(false);
					btnCancelar.setVisible(false);
				}

			}
		});
		panel.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desactivar_habilitar(false);
				list.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnNuevo.setEnabled(true);
				btnAgregar.setVisible(false);
				btnGuardar.setVisible(false);
				btnCancelar.setVisible(false);
				lblD.setForeground(Color.BLACK);
				lblNombre.setForeground(Color.BLACK);
				lblCapacidad.setForeground(Color.BLACK);
				lblDatosErroneos.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnCancelar.setBounds(214, 150, 100, 29);
		panel.add(btnCancelar);

		btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(545, 406, 89, 29);
		btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPanel.add(btnSalir);

		lblDatosErroneos = new JLabel("Datos erroneos");
		lblDatosErroneos.setForeground(new Color(0,0,139));
		lblDatosErroneos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblDatosErroneos.setBounds(330, 207, 200, 50);
		lblDatosErroneos.setVisible(false);
		contentPanel.add(lblDatosErroneos);

//		desactivar_habilitar(false);
	}

	public void limpiar() {
		textFieldID.setText("");
		textFieldNombre.setText("");
		textFieldCapacidad.setText("");
	}

	public void desactivar_habilitar(boolean estado) {
		textFieldID.setEditable(estado);
		textFieldNombre.setEditable(estado);
		textFieldCapacidad.setEditable(estado);
	}

	// public boolean validarDatos(String n, String nombre, String capacidad) {
	// 	boolean correcto = true;
	// 	Votante temp = new Votante();

	// 	try { // nombre
	// 		lblD.setForeground(Color.BLACK);
	// 		temp.setNombre(n);
	// 	} catch (IllegalArgumentException e) {
	// 		correcto = false;
	// 		lblDatosErroneos.setVisible(true);
	// 		lblD.setForeground(new Color(0,0,139));
	// 	}

	// 	try { // nombre
	// 		lblNombre.setForeground(Color.BLACK);
	// 		temp.setCorreo(nombre);
	// 	} catch (IllegalArgumentException e) {
	// 		correcto = false;
	// 		lblDatosErroneos.setVisible(true);
	// 		lblNombre.setForeground(new Color(0,0,139));
	// 	}

	// 	try { // contrase�a
	// 		lblCapacidad.setForeground(Color.BLACK);
	// 		temp.setContrasenna(capacidad);
	// 	} catch (IllegalArgumentException e) {
	// 		correcto = false;
	// 		lblDatosErroneos.setVisible(true);
	// 		lblCapacidad.setForeground(new Color(0,0,139));
	// 	}

	// 	if (correcto) {
	// 		lblDatosErroneos.setVisible(false);
	// 	}
	// 	return correcto;
	// }
}