import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vrrecifeframework.classes.VrProperties;

public class Config extends JFrame {

	VrProperties vr = new VrProperties();
	private JPanel contentPane;
	private JPasswordField tf_senhaDb;
	private JTextField tf_nomeDb;
	private JTextField tf_ip;
	private JTextField tf_porta;
	private JTextField tf_userDb;
	private JTextField tf_usuario;
	private JTextField tf_cnpj;
	private JTextField tf_token;
	private JTextField tf_ambiente;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Config frame = new Config();
//					frame.setVisible(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Config() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Config.class.getResource("/vrrecifeframework/img/config.png")));
		setTitle("Configura\u00E7\u00F5es");
		setResizable(false);
		setVisible(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Nome DB:");
		lblNewLabel.setBounds(10, 21, 55, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblIp = new JLabel("IP: ");
		lblIp.setBounds(10, 42, 55, 14);
		desktopPane.add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(10, 63, 55, 14);
		desktopPane.add(lblPorta);
		
		JLabel lblUser = new JLabel("User DB:");
		lblUser.setBounds(10, 84, 55, 14);
		desktopPane.add(lblUser);
		
		JLabel lblSenhaDb = new JLabel("Senha DB:");
		lblSenhaDb.setBounds(10, 105, 55, 14);
		desktopPane.add(lblSenhaDb);
		
		tf_nomeDb = new JTextField();
		tf_nomeDb.setBounds(75, 18, 95, 20);
		desktopPane.add(tf_nomeDb);
		tf_nomeDb.setColumns(10);
		tf_nomeDb.setText(VrProperties.getString("database.nome"));
		
		tf_ip = new JTextField();
		tf_ip.setColumns(10);
		tf_ip.setBounds(75, 39, 95, 20);
		desktopPane.add(tf_ip);
		tf_ip.setText(VrProperties.getString("database.ip"));
		
		tf_porta = new JTextField();
		tf_porta.setColumns(10);
		tf_porta.setBounds(75, 60, 95, 20);
		desktopPane.add(tf_porta);
		tf_porta.setText(VrProperties.getString("database.porta"));
		
		tf_userDb = new JTextField();
		tf_userDb.setColumns(10);
		tf_userDb.setBounds(75, 81, 95, 20);
		desktopPane.add(tf_userDb);
		tf_userDb.setText(VrProperties.getString("database.usuario"));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(193, 24, 55, 14);
		desktopPane.add(lblUsuario);
		
		tf_usuario = new JTextField();
		tf_usuario.setColumns(10);
		tf_usuario.setBounds(258, 21, 131, 20);
		desktopPane.add(tf_usuario);
		tf_usuario.setText(VrProperties.getString("meta.usuario"));
		
		tf_cnpj = new JTextField();
		tf_cnpj.setColumns(10);
		tf_cnpj.setBounds(258, 42, 131, 20);
		desktopPane.add(tf_cnpj);
		tf_cnpj.setText(VrProperties.getString("meta.cnpj"));
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(193, 45, 55, 14);
		desktopPane.add(lblCnpj);
		
		JLabel lblSenha = new JLabel("Token");
		lblSenha.setBounds(193, 66, 55, 14);
		desktopPane.add(lblSenha);
		
		tf_token = new JTextField();
		tf_token.setColumns(10);
		tf_token.setBounds(258, 63, 131, 20);
		desktopPane.add(tf_token);
		tf_token.setText(VrProperties.getString("meta.token"));
		
		JLabel lblMinutos = new JLabel("Ambiente");
		lblMinutos.setBounds(193, 81, 86, 14);
		desktopPane.add(lblMinutos);
		
		tf_ambiente = new JTextField();
		tf_ambiente.setColumns(10);
		tf_ambiente.setBounds(193, 99, 42, 20);
		desktopPane.add(tf_ambiente);
		tf_ambiente.setText(VrProperties.getString("meta.ambierte"));
		
		tf_senhaDb = new JPasswordField();
		tf_senhaDb.setEchoChar('*');
		tf_senhaDb.setBounds(75, 102, 95, 18);
		desktopPane.add(tf_senhaDb);
		tf_senhaDb.setText(VrProperties.getString("database.senha"));
		
		Button btGravar = new Button("Gravar");
		btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VrProperties.setProperty("database.nome", tf_nomeDb.getText());
				VrProperties.setProperty("database.ip", tf_ip.getText());
				VrProperties.setProperty("database.porta", tf_porta.getText());
				VrProperties.setProperty("database.usuario", tf_userDb.getText());
				VrProperties.setProperty("database.senha", tf_senhaDb.getPassword().toString());
				VrProperties.setProperty("meta.ambierte", tf_ambiente.getText());
				VrProperties.setProperty("meta.token", tf_token.getText());
				VrProperties.setProperty("meta.cnpj", tf_cnpj.getText());
				VrProperties.setProperty("meta.usuario", tf_usuario.getText());
				
				JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
				
				setVisible(false);
				
				
			}
		});
		btGravar.setBounds(319, 137, 70, 22);
		desktopPane.add(btGravar);
	}
}
