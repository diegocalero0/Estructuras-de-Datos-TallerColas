package Mercado;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaMercado extends JFrame implements ActionListener{

	private JButton btn_aceptar;
	private JLabel lbl_cantCarritos;
	private JLabel lbl_cantEspera;
	private JLabel lbl_generarClientes;
	private JLabel lbl_caja1;
	private JLabel lbl_caja2;
	private JLabel lbl_caja3;
	private JLabel lbl_infcaja1;
	private JLabel lbl_infcaja2;
	private JLabel lbl_infcaja3;
	private JLabel lbl_ncaja1;
	private JLabel lbl_ncaja2;
	private JLabel lbl_ncaja3;
	private JTextField txt_generar;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private int n1;
	private int n2;
	private int n3;
	
	private Mercado mercado;
	private Thread hilo;
	public VentanaMercado() {
		this.setSize(500,340);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		
		
		n1=0;
		n2=0;
		n3=0;
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		lbl_cantCarritos = new JLabel("Cantidad de carritos: 25");
		lbl_cantEspera = new JLabel("En espera: 0");
		lbl_generarClientes = new JLabel("Generar clientes:");
		lbl_caja1 = new JLabel("CAJA 1:");
		lbl_caja2 = new JLabel("CAJA 2:");
		lbl_caja3 = new JLabel("CAJA 3:");
		lbl_ncaja1 = new JLabel(n1+"");
		lbl_ncaja2 = new JLabel(n2+"");
		lbl_ncaja3 = new JLabel(n3+"");
		lbl_infcaja1 = new JLabel("CAJA 1 Atendiendo a: ");
		lbl_infcaja2 = new JLabel("CAJA 2 Atendiendo a: ");
		lbl_infcaja3 = new JLabel("CAJA 3 Atendiendo a: ");
		txt_generar = new JTextField();
		btn_aceptar = new JButton("Generar");
		
		panel1.setBounds(0, 0, 250, 220);
		panel2.setBounds(250, 0, 250, 220);
		panel3.setBounds(0,220 , 500, 110);
		panel2.setBackground(new Color(224,224,224));
		panel3.setBackground(Color.lightGray);
		
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		//Agregamos componentes al panel 1
		panel1.add(lbl_cantCarritos);
		panel1.add(lbl_cantEspera);
		panel1.add(lbl_generarClientes);
		panel1.add(txt_generar);
		panel1.add(btn_aceptar);
		
		lbl_cantCarritos.setBounds(10, 50, 200, 20);
		lbl_cantEspera.setBounds(10, 80, 200, 20);
		lbl_generarClientes.setBounds(10, 110, 200, 20);
		txt_generar.setBounds(120, 110, 30, 20);
		btn_aceptar.setBounds(10, 135,140,20 );
		btn_aceptar.addActionListener(this);
		
		//Agregamos componentes al panel 2
		
		Font fuente = new Font(null, Font.BOLD, 20);
		
		panel2.add(lbl_caja1);
		panel2.add(lbl_caja2);
		panel2.add(lbl_caja3);
		panel2.add(lbl_ncaja1);
		panel2.add(lbl_ncaja2);
		panel2.add(lbl_ncaja3);
		
		int pos=25;
		int pos2=20;
		lbl_caja1.setFont(fuente);
		lbl_ncaja1.setFont(fuente);
		lbl_caja1.setBounds(20+pos2, 20+pos, 200,30);
		lbl_ncaja1.setBounds(110+pos2,20+pos,200,30);
		
		lbl_caja2.setFont(fuente);
		lbl_ncaja2.setFont(fuente);
		lbl_caja2.setBounds(20+pos2, 60+pos, 200,30);
		lbl_ncaja2.setBounds(110+pos2,60+pos,200,30);
		
		lbl_caja3.setFont(fuente);
		lbl_ncaja3.setFont(fuente);
		lbl_caja3.setBounds(20+pos2, 100+pos, 200,30);
		lbl_ncaja3.setBounds(110+pos2,100+pos,200,30);
		
		
		//Agregamos componentes al panel 3
		panel3.add(lbl_infcaja1);
		panel3.add(lbl_infcaja2);
		panel3.add(lbl_infcaja3);
		
		lbl_infcaja1.setBounds(10, 5, 600, 30);
		lbl_infcaja2.setBounds(10, 25, 600, 30);
		lbl_infcaja3.setBounds(10, 45, 600, 30);
		
		mercado = new Mercado(this);
		mercado.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_aceptar){
			try{
				mercado.setToAdd(Integer.parseInt(txt_generar.getText()));
				lbl_cantCarritos.setText("Cantidad de carritos: "+mercado.getCarritos());
				txt_generar.setText("");
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
			}
			
		}
		
	}

	/**
	 * @return the lbl_cantCarritos
	 */
	public JLabel getLbl_cantCarritos() {
		return lbl_cantCarritos;
	}

	/**
	 * @param lbl_cantCarritos the lbl_cantCarritos to set
	 */
	public void setLbl_cantCarritos(JLabel lbl_cantCarritos) {
		this.lbl_cantCarritos = lbl_cantCarritos;
	}

	/**
	 * @return the lbl_cantEspera
	 */
	public JLabel getLbl_cantEspera() {
		return lbl_cantEspera;
	}

	/**
	 * @param lbl_cantEspera the lbl_cantEspera to set
	 */
	public void setLbl_cantEspera(JLabel lbl_cantEspera) {
		this.lbl_cantEspera = lbl_cantEspera;
	}

	/**
	 * @return the lbl_generarClientes
	 */
	public JLabel getLbl_generarClientes() {
		return lbl_generarClientes;
	}

	/**
	 * @param lbl_generarClientes the lbl_generarClientes to set
	 */
	public void setLbl_generarClientes(JLabel lbl_generarClientes) {
		this.lbl_generarClientes = lbl_generarClientes;
	}

	/**
	 * @return the lbl_caja1
	 */
	public JLabel getLbl_caja1() {
		return lbl_caja1;
	}

	/**
	 * @param lbl_caja1 the lbl_caja1 to set
	 */
	public void setLbl_caja1(JLabel lbl_caja1) {
		this.lbl_caja1 = lbl_caja1;
	}

	/**
	 * @return the lbl_caja2
	 */
	public JLabel getLbl_caja2() {
		return lbl_caja2;
	}

	/**
	 * @param lbl_caja2 the lbl_caja2 to set
	 */
	public void setLbl_caja2(JLabel lbl_caja2) {
		this.lbl_caja2 = lbl_caja2;
	}

	/**
	 * @return the lbl_caja3
	 */
	public JLabel getLbl_caja3() {
		return lbl_caja3;
	}

	/**
	 * @param lbl_caja3 the lbl_caja3 to set
	 */
	public void setLbl_caja3(JLabel lbl_caja3) {
		this.lbl_caja3 = lbl_caja3;
	}

	/**
	 * @return the lbl_infcaja1
	 */
	public JLabel getLbl_infcaja1() {
		return lbl_infcaja1;
	}

	/**
	 * @param lbl_infcaja1 the lbl_infcaja1 to set
	 */
	public void setLbl_infcaja1(JLabel lbl_infcaja1) {
		this.lbl_infcaja1 = lbl_infcaja1;
	}

	/**
	 * @return the lbl_infcaja2
	 */
	public JLabel getLbl_infcaja2() {
		return lbl_infcaja2;
	}

	/**
	 * @param lbl_infcaja2 the lbl_infcaja2 to set
	 */
	public void setLbl_infcaja2(JLabel lbl_infcaja2) {
		this.lbl_infcaja2 = lbl_infcaja2;
	}

	/**
	 * @return the lbl_infcaja3
	 */
	public JLabel getLbl_infcaja3() {
		return lbl_infcaja3;
	}

	/**
	 * @param lbl_infcaja3 the lbl_infcaja3 to set
	 */
	public void setLbl_infcaja3(JLabel lbl_infcaja3) {
		this.lbl_infcaja3 = lbl_infcaja3;
	}

	/**
	 * @return the lbl_ncaja1
	 */
	public JLabel getLbl_ncaja1() {
		return lbl_ncaja1;
	}

	/**
	 * @param lbl_ncaja1 the lbl_ncaja1 to set
	 */
	public void setLbl_ncaja1(JLabel lbl_ncaja1) {
		this.lbl_ncaja1 = lbl_ncaja1;
	}

	/**
	 * @return the lbl_ncaja2
	 */
	public JLabel getLbl_ncaja2() {
		return lbl_ncaja2;
	}

	/**
	 * @param lbl_ncaja2 the lbl_ncaja2 to set
	 */
	public void setLbl_ncaja2(JLabel lbl_ncaja2) {
		this.lbl_ncaja2 = lbl_ncaja2;
	}

	/**
	 * @return the lbl_ncaja3
	 */
	public JLabel getLbl_ncaja3() {
		return lbl_ncaja3;
	}

	/**
	 * @param lbl_ncaja3 the lbl_ncaja3 to set
	 */
	public void setLbl_ncaja3(JLabel lbl_ncaja3) {
		this.lbl_ncaja3 = lbl_ncaja3;
	}
	
	

}
