import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.vrrecife.dominio.ProdutoRetorno;
import br.com.vrrecife.repository.ProdutoAtualiza;
import br.com.vrrecife.repository.ProdutoDAO;
import br.com.vrrecife.repository.ProdutoRetornoDAO;
import br.com.vrrecife.servico.Servico;
import br.com.vrrecife.util.RecebeSoNumeros;
import vrrecifeframework.classes.VrProperties;


public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	Principal frame;
	private JTextField tf_barras;
	ProdutoRetorno pr = new ProdutoRetorno(); 
	String ean;

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

	JButton btAtualizar = new JButton("Atualizar");

	// variaveis para o timer
	Timer timer;
	boolean atividade = false;
	// variavel properties
	VrProperties vr = new VrProperties();
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
	private JLabel lbDesc;
	

	/**
	 * Create the frame.
	 */
	public Principal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/vrrecifeframework/img/icone.png")));
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
		
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoAtualiza pa = new ProdutoAtualiza();
				ProdutoRetornoDAO pdao = new ProdutoRetornoDAO(); 
				Object[] options = {"Atualizar","Cancelar"};
		    	int valor = JOptionPane.showOptionDialog(null, 	"Todos os itens em vermelho serão atualizados. \n"+
		    										"Esse processo não poderá ser desfeito!! \n"+
		    										"Deseja continuar?", "Atenção!!",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, options, options[0]);
		    	if(valor == 0) {
				if(!ncm_novo.getText().equals(ncm_old.getText())) {
					pa.atualizaNcm(pr);
				}
				if(!cest_novo.getText().equals(cest_old.getText())) {
					pa.atualizaCest(pr);
				}
				if(!pis_novo.getText().equals(pis_old.getText())) {
				pa.atualizaPisCofins(pr);
				}
				if(!icms_novo.getText().equals(icms_old.getText())&& !icms_novo.getText().equals("")) {
				pa.atualizaTribVenda(pr);
				pdao.retornar(ean);
				}
				if(!beneficio_novo.getText().equals(beneficio_old.getText())) {
				pa.atualizaBeneficio(pr);
				}
				JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso!!");
				btAtualizar.setEnabled(false);
				
		    	}
			}
		});
		
	

		btAtualizar.setEnabled(true);
		btAtualizar.setBounds(419, 336, 89, 23);
		desktopPane.add(btAtualizar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Config con = new Config();
				con.setLocationRelativeTo(null);
				con.setVisible(true);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/vrrecifeframework/img/config.png")));
		btnNewButton.setBounds(503, 0, 46, 54);
		desktopPane.add(btnNewButton);
		
		tf_barras = new JTextField();
		tf_barras.setFocusTraversalKeysEnabled(false);
		tf_barras.setFocusCycleRoot(true);
		
		tf_barras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 ean = tf_barras.getText();
				if (e.getKeyCode() ==KeyEvent.VK_ENTER) {
					if(tf_barras.getText().length() >= 8 && tf_barras.getText().length() <= 13) {
					ProdutoDAO pd = new ProdutoDAO();
					pd.salvar(ean);
					ProdutoRetornoDAO pdao = new ProdutoRetornoDAO(); 
					pr = pdao.retornar(ean);
					
					if(!pr.getNcm_novo().equals(pr.getNcm_old())) {
						ncm_novo.setForeground(Color.red);
					}
					if(!pr.getCest_novo().equals(pr.getCest_old())) {
						cest_novo.setForeground(Color.red);
					}
					if(!pr.getDesc_tribvenda_novo().equals(pr.getDesc_tribvenda())) {
						icms_novo.setForeground(Color.red);
					}
					if(!pr.getDescricao_pis_novo().equals(pr.getDescricao_pis_old())) {
						pis_novo.setForeground(Color.red);
					}
					if(!pr.getCodigo_beneficio_novo().equals(pr.getCodigo_beneficio_old())) {
						beneficio_novo.setForeground(Color.red);
					}
					
					lbDesc.setText(pr.getId()+" - "+pr.getDescricaocompleta());
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
					if(icms_novo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Aliquota não encontrada, favor entra em /n"+
								"contato com o Suporte VR para cadastrar a aliquaota "+pr.getTrib_a_cadastrar());
						btAtualizar.setEnabled(false);
					}else 
						btAtualizar.setEnabled(true);
					tf_barras.setText("");

				}else
					JOptionPane.showMessageDialog(null, "Ean digitado não é válido!","Atenção!",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
	
		tf_barras.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_barras.requestFocus();
		tf_barras.setDocument(new RecebeSoNumeros());
		tf_barras.setToolTipText("Digite o código de barras ao qual deseja consultar.");
		tf_barras.setBounds(21, 61, 152, 28);
		desktopPane.add(tf_barras);
		tf_barras.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ean.");
		lblNewLabel_1.setBounds(21, 40, 46, 14);
		desktopPane.add(lblNewLabel_1);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(27, 185, 77, 129);
		desktopPane.add(panel1);
		panel1.setLayout(new GridLayout(5, 1, 2, 0));
		
		btAtualizar.setEnabled(false); 
		
		txtNcm = new JTextField();
		txtNcm.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNcm.setText("NCM:");
		txtNcm.setColumns(10);
		txtNcm.setEditable(false);
		panel1.add(txtNcm);
		
		txtCest = new JTextField();
		txtCest.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCest.setText("Cest:");
		txtCest.setColumns(10);
		txtCest.setEditable(false);
		panel1.add(txtCest);
		
		txtPiscofins = new JTextField();
		txtPiscofins.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPiscofins.setText("Pis/Cofins:");
		txtPiscofins.setColumns(10);
		txtPiscofins.setEditable(false);
		panel1.add(txtPiscofins);
		
		txtIcms = new JTextField();
		txtIcms.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIcms.setText("ICMS:");
		txtIcms.setColumns(1);
		txtIcms.setEditable(false);
		panel1.add(txtIcms);
		
		txtBenefcio = new JTextField();
		txtBenefcio.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBenefcio.setText("Benef\u00EDcio:");
		txtBenefcio.setColumns(1);
		txtBenefcio.setEditable(false);
		panel1.add(txtBenefcio);
		
		panel1_1 = new JPanel();
		panel1_1.setBounds(114, 185, 206, 129);
		desktopPane.add(panel1_1);
		panel1_1.setLayout(new GridLayout(5, 1, 2, 0));
		
		ncm_old = new JTextField();
		ncm_old.setColumns(10);
		ncm_old.setEditable(false);
		panel1_1.add(ncm_old);
		
		cest_old = new JTextField();
		cest_old.setColumns(10);
		cest_old.setEditable(false);
		panel1_1.add(cest_old);
		
		pis_old = new JTextField();
		pis_old.setColumns(10);
		pis_old.setEditable(false);
		panel1_1.add(pis_old);
		
		icms_old = new JTextField();
		icms_old.setColumns(1);
		icms_old.setEditable(false);
		panel1_1.add(icms_old);
		
		beneficio_old = new JTextField();
		beneficio_old.setColumns(1);
		beneficio_old.setEditable(false);
		panel1_1.add(beneficio_old);
		
		panel1_2 = new JPanel();
		panel1_2.setBounds(330, 185, 178, 129);
		panel1_2.setLayout(new GridLayout(5, 1, 2, 0));
		desktopPane.add(panel1_2);
		
		ncm_novo = new JTextField();
		ncm_novo.setColumns(10);
		ncm_novo.setEditable(false);
		panel1_2.add(ncm_novo);
		
		cest_novo = new JTextField();
		cest_novo.setColumns(10);
		cest_novo.setEditable(false);
		panel1_2.add(cest_novo);
		
		pis_novo = new JTextField();
		pis_novo.setColumns(10);
		pis_novo.setEditable(false);
		panel1_2.add(pis_novo);
		
		icms_novo = new JTextField();
		icms_novo.setColumns(1);
		icms_novo.setEditable(false);
		panel1_2.add(icms_novo);
		
		beneficio_novo = new JTextField();
		beneficio_novo.setColumns(1);
		beneficio_novo.setEditable(false);
		panel1_2.add(beneficio_novo);
		
		lblNewLabel_2 = new JLabel("Antigo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(125, 155, 77, 23);
		desktopPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Novo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(342, 155, 77, 23);
		desktopPane.add(lblNewLabel_3);
		
		lbDesc = new JLabel("");
		lbDesc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDesc.setBounds(27, 116, 481, 28);
		desktopPane.add(lbDesc);
		
	}

}
