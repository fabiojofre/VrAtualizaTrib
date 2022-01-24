import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.vrrecife.dominio.ProdutoRetorno;
import br.com.vrrecife.repository.ProdutoRetornoDAO;
import br.com.vrrecife.util.RecebeSoNumeros;
import vrrecifeframework.classes.VrProperties;
import java.awt.GridLayout;


public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	Principal frame;
	private JTextField tf_barras;
	ProdutoRetorno pr = new ProdutoRetorno(); 
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.requestFocus();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JButton btnIniciar = new JButton("Iniciar");

	// variaveis para o timer
	Timer timer;
	boolean atividade = false;
	// variavel properties
	VrProperties vr = new VrProperties();
	int minutos;
	private JTextField txtNcm;
	private JTextField txtCest;
	private JTextField txtPiscofins;
	private JTextField txtBenefcio;
	private JPanel panel1_1;
	private JTextField ncm_old;
	private JTextField cest_old;
	private JTextField pis_old;
	private JTextField beneficio_old;
	private JPanel panel1_2;
	private JTextField ncm_novo;
	private JTextField cest_novo;
	private JTextField pis_novo;
	private JTextField beneficio_novo;
	private JTextField txtIcms;
	private JTextField icms_old;
	private JTextField icms_novo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	

	/**
	 * Create the frame.
	 */
	public Principal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/vrrecifeframework/img/icone.png")));
		minutos = Integer.parseInt(VrProperties.getString("redecen.minutos_consulta"));
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Atualiza Trib");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 565, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Consulta Produtos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(114, 0, 178, 28);
		desktopPane.add(lblNewLabel);
		
	

		btnIniciar.setEnabled(true);
		btnIniciar.setBounds(385, 90, 89, 23);
		desktopPane.add(btnIniciar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Config con = new Config();
				con.setLocationRelativeTo(null);
				con.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/vrrecifeframework/img/config.png")));
		btnNewButton.setBounds(443, 0, 65, 50);
		desktopPane.add(btnNewButton);
		
		tf_barras = new JTextField();
		tf_barras.setFocusTraversalKeysEnabled(false);
		tf_barras.setFocusCycleRoot(true);
		tf_barras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String ean = tf_barras.getText();
				if (e.getKeyCode() ==KeyEvent.VK_ENTER) {
					ProdutoRetornoDAO pdao = new ProdutoRetornoDAO(); 
					pr = pdao.retornar(ean);
					ncm_old.setText(pr.getNcm_old());
					ncm_novo.setText(pr.getNcm_novo());
					cest_old.setText(pr.getCest_old());
					cest_novo.setText(pr.getCest_novo());
					pis_old.setText(pr.getDescricao_pis_old());
					pis_novo.setText(pr.getDescricao_pis_novo());
					icms_old.setText(pr.getDesc_tribvenda());
					icms_novo.setText(pr.getDesc_tribvenda_novo());
					beneficio_old.setText(pr.getCodigo_beneficio_old());
					beneficio_novo.setText(pr.getCodigo_beneficio_novo());
					
					JOptionPane.showMessageDialog(null, ean);
					tf_barras.setText("");
				}
			}
		});
		
	
		tf_barras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_barras.requestFocus();
		tf_barras.setDocument(new RecebeSoNumeros());
		tf_barras.setToolTipText("Digite o código de barras ao qual deseja consultar.");
		tf_barras.setBounds(21, 61, 146, 20);
		desktopPane.add(tf_barras);
		tf_barras.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ean.");
		lblNewLabel_1.setBounds(21, 40, 46, 14);
		desktopPane.add(lblNewLabel_1);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(27, 185, 77, 129);
		desktopPane.add(panel1);
		panel1.setLayout(new GridLayout(5, 1, 2, 0));
		
		txtNcm = new JTextField();
		txtNcm.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNcm.setText("NCM:");
		panel1.add(txtNcm);
		txtNcm.setColumns(10);
		
		txtCest = new JTextField();
		txtCest.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCest.setText("Cest:");
		txtCest.setColumns(10);
		panel1.add(txtCest);
		
		txtPiscofins = new JTextField();
		txtPiscofins.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPiscofins.setText("Pis/Cofins:");
		txtPiscofins.setColumns(10);
		panel1.add(txtPiscofins);
		
		txtIcms = new JTextField();
		txtIcms.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIcms.setText("ICMS:");
		txtIcms.setColumns(1);
		panel1.add(txtIcms);
		
		txtBenefcio = new JTextField();
		txtBenefcio.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBenefcio.setText("Benef\u00EDcio:");
		txtBenefcio.setColumns(1);
		panel1.add(txtBenefcio);
		
		panel1_1 = new JPanel();
		panel1_1.setBounds(114, 185, 206, 129);
		desktopPane.add(panel1_1);
		panel1_1.setLayout(new GridLayout(5, 1, 2, 0));
		
		ncm_old = new JTextField();
		ncm_old.setColumns(10);
		panel1_1.add(ncm_old);
		
		cest_old = new JTextField();
		cest_old.setColumns(10);
		panel1_1.add(cest_old);
		
		pis_old = new JTextField();
		pis_old.setColumns(10);
		panel1_1.add(pis_old);
		
		icms_old = new JTextField();
		icms_old.setColumns(1);
		panel1_1.add(icms_old);
		
		beneficio_old = new JTextField();
		beneficio_old.setColumns(1);
		panel1_1.add(beneficio_old);
		
		panel1_2 = new JPanel();
		panel1_2.setBounds(330, 185, 178, 129);
		desktopPane.add(panel1_2);
		panel1_2.setLayout(new GridLayout(5, 1, 2, 0));
		
		ncm_novo = new JTextField();
		ncm_novo.setColumns(10);
		panel1_2.add(ncm_novo);
		
		cest_novo = new JTextField();
		cest_novo.setColumns(10);
		panel1_2.add(cest_novo);
		
		pis_novo = new JTextField();
		pis_novo.setColumns(10);
		panel1_2.add(pis_novo);
		
		icms_novo = new JTextField();
		icms_novo.setColumns(1);
		panel1_2.add(icms_novo);
		
		beneficio_novo = new JTextField();
		beneficio_novo.setColumns(1);
		panel1_2.add(beneficio_novo);
		
		lblNewLabel_2 = new JLabel("Antigo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(125, 155, 77, 23);
		desktopPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Novo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(342, 155, 77, 23);
		desktopPane.add(lblNewLabel_3);
		
	}

	// metodo que controla o timer
	public void controle(int minutos) {
		timer = new Timer();
		timer.schedule(new controleTask(), 0, minutos * 1000);
	}

	// Classe de controle de ações do timer
	class controleTask extends TimerTask {
		public void run() {
			if (atividade == true) {
				//lbStatus_1.setText("Executando!!!!!");
//				 RecebimentoDAO dao = new RecebimentoDAO();
//				 try {
//					dao.executaRecebimento();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("Time's up!");
//				lbStatus_1.setText("");
			} else

				timer.cancel(); // Terminate the timer thread
		}
	}
}
