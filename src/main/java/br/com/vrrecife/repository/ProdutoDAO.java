package br.com.vrrecife.repository;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.vrrecife.dominio.Produto;
import br.com.vrrecife.servico.Servico;
import conexao.ConexaoServidor;
import vrrecifeframework.classes.VrProperties;
public class ProdutoDAO {
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date hoje = Calendar.getInstance().getTime(); 
	
	Produto p = new Produto();
	
	
	ConexaoServidor con = new ConexaoServidor();
	Servico s =new Servico();

	String db_ip =  VrProperties.getString("database.ip");
	int db_porta = VrProperties.getInt("database.porta");
	String db_nome = VrProperties.getString("database.nome");
	String db_usuario = VrProperties.getString("database.usuario");
	String db_senha = VrProperties.getString("database.senha");
	
	String token = VrProperties.getString("meta.token");
	String usuario = VrProperties.getString("meta.usuario");
	String anbiente = VrProperties.getString("meta.ambierte");
	String cnpj = VrProperties.getString("meta.cnpj");
	
	public String retornaStatus(String ean) {
		p = s.consultarProduto(cnpj, usuario, ean, anbiente,token);
		return p.getStatusWeb();
	}
	
	
	public void salvar(String ean) {
	
		try {
			
			p = s.consultarProduto(cnpj, usuario, ean, anbiente,token);
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			String sql = "INSERT INTO  metaassessoria.prod(EAN, Codigo, produtoDescricao, \r\n"
					+ "				produtoDescricaoNota, produtoDescricaoFornecedor, \r\n"
					+ "				produtoDiasValidade,	embalagemUnitariaPesoBruto,\r\n"
					+ "				embalagemUnitariaPesoLiquido, embalagemUnitariaAltura,\r\n"
					+ "				embalagemUnitariaLargura, embalagemUnitariaProfundidade,\r\n"
					+ "				embalagemUnitariaId,	embalagemUnitariaDescricao,\r\n"
					+ "				embalagemUnitariaCapacidade, embalagemUnitariaUnidadeMedida,\r\n"
					+ "				embalagemUnitariaUnidadeSigla, fabricanteId,\r\n"
					+ "				fabricanteNome,	fabricanteMarcaid, fabricanteMarcaDescricao,\r\n"
					+ "				mercadologicaDepartamentoId, mercadologicaDepartamentoNome,\r\n"
					+ "				mercadologicaSecaoId, mercadologicaSecaoNome,\r\n"
					+ "				mercadologicaGrupoId, mercadologicaGrupoNome, \r\n"
					+ "				mercadologicaSubgrupoId,	mercadologicaSubgrupoNome,\r\n"
					+ "				Ativo, logEmbalagem, logDum14, logAlturaCm,\r\n"
					+ "				logLarguraCm, logProfundidadeCm, logPesoKg,	QtdEmbal,\r\n"
					+ "				LogQtdLastro, LogQtdCamadas, tributarioNcm,	tributarioCest,\r\n"
					+ "				tributarioFiguraFiscal,	CodigoBeneficioFiscalIcms,\r\n"
					+ "				CodigoBeneficioFiscalPisCofins,	tribRegraDescricao,\r\n"
					+ "				tribRegraUfOrigem, TribRegraPerfilOrigem, TribRegraCodPerfilOrigem,\r\n"
					+ "				tribRegraUfDestino,	TribRegraPerfilDestino,	TribRegraCodPerfilDestino,\r\n"
					+ "				tribRegraCfop, tribIcmsCst, tribIcmsAliq,tribIcmsReducao,\r\n"
					+ "				tribIcmsStAliq,	tribIcmsStPauta, tribIcmsStMva, tribFcpAliq,\r\n"
					+ "				tribDifalAliq, tribRegraPisCst, tribRegraPisCstE,\r\n"
					+ "				tribPisReducao, tribPisAliq, fisRegraCofinsCst,	tribCofinsReducao,\r\n"
					+ "				tribCofinAliq, fisRegraValidadeInicio, fisRegraValidadeFinal,\r\n"
					+ "				id_produto, dataatualizacao,resultadoConsulta)\r\n"
					+ "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, \r\n"
					+ "  		  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,\r\n"
					+ "  		  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\r\n"
					+ "ON CONFLICT (EAN)\r\n"
					+ "DO UPDATE SET\r\n"
					+ " Codigo =  ?,	\r\n"
					+ "	produtoDescricao =  ?,\r\n"
					+ "	produtoDescricaoNota =  ?,\r\n"
					+ "	produtoDescricaoFornecedor =  ?,\r\n"
					+ "	produtoDiasValidade =  ?,\r\n"
					+ "	embalagemUnitariaPesoBruto =  ?,\r\n"
					+ "	embalagemUnitariaPesoLiquido =  ?,\r\n"
					+ "	embalagemUnitariaAltura =  ?,\r\n"
					+ "	embalagemUnitariaLargura =  ?,\r\n"
					+ "	embalagemUnitariaProfundidade =  ?,\r\n"
					+ "	embalagemUnitariaId =  ?,\r\n"
					+ "	embalagemUnitariaDescricao =  ?,\r\n"
					+ "	embalagemUnitariaCapacidade =  ?,\r\n"
					+ "	embalagemUnitariaUnidadeMedida =  ?,\r\n"
					+ "	embalagemUnitariaUnidadeSigla =  ?,\r\n"
					+ "	fabricanteId =  ?,\r\n"
					+ "	fabricanteNome =  ?,\r\n"
					+ "	fabricanteMarcaid =  ?,\r\n"
					+ "	fabricanteMarcaDescricao =  ?,\r\n"
					+ "	mercadologicaDepartamentoId =  ?,\r\n"
					+ "	mercadologicaDepartamentoNome =  ?,\r\n"
					+ "	mercadologicaSecaoId =  ?,\r\n"
					+ "	mercadologicaSecaoNome =  ?,\r\n"
					+ "	mercadologicaGrupoId =  ?,\r\n"
					+ "	mercadologicaGrupoNome =  ?,\r\n"
					+ "	mercadologicaSubgrupoId =  ?,\r\n"
					+ "	mercadologicaSubgrupoNome =  ?,\r\n"
					+ "	Ativo =  ?,\r\n"
					+ "	logEmbalagem =  ?,\r\n"
					+ "	logDum14 =  ?,\r\n"
					+ "	logAlturaCm =  ?,\r\n"
					+ "	logLarguraCm =  ?,\r\n"
					+ "	logProfundidadeCm =  ?,\r\n"
					+ "	logPesoKg =  ?,\r\n"
					+ "	QtdEmbal =  ?,\r\n"
					+ "	LogQtdLastro =  ?,\r\n"
					+ "	LogQtdCamadas =  ?,\r\n"
					+ "	tributarioNcm =  ?,\r\n"
					+ "	tributarioCest =  ?,\r\n"
					+ "	tributarioFiguraFiscal =  ?,\r\n"
					+ "	CodigoBeneficioFiscalIcms =  ?,\r\n"
					+ "	CodigoBeneficioFiscalPisCofins =  ?,\r\n"
					+ "	tribRegraDescricao =  ?,\r\n"
					+ "	tribRegraUfOrigem =  ?,\r\n"
					+ "	TribRegraPerfilOrigem =  ?,\r\n"
					+ "	TribRegraCodPerfilOrigem =  ?,\r\n"
					+ "	tribRegraUfDestino =  ?,\r\n"
					+ "	TribRegraPerfilDestino =  ?,\r\n"
					+ "	TribRegraCodPerfilDestino =  ?,\r\n"
					+ "	tribRegraCfop =  ?,\r\n"
					+ "	tribIcmsCst =  ?,\r\n"
					+ "	tribIcmsAliq =  ?,\r\n"
					+ "	tribIcmsReducao =  ?,\r\n"
					+ "	tribIcmsStAliq =  ?,\r\n"
					+ "	tribIcmsStPauta =  ?,\r\n"
					+ "	tribIcmsStMva =  ?,\r\n"
					+ "	tribFcpAliq =  ?,\r\n"
					+ "	tribDifalAliq =  ?,\r\n"
					+ "	tribRegraPisCst =  ?,\r\n"
					+ "	tribRegraPisCstE =  ?,\r\n"
					+ "	tribPisReducao =  ?,\r\n"
					+ "	tribPisAliq =  ?,\r\n"
					+ "	fisRegraCofinsCst =  ?,\r\n"
					+ "	tribCofinsReducao =  ?,\r\n"
					+ "	tribCofinAliq =  ?,\r\n"
					+ "	fisRegraValidadeInicio =  ?,\r\n"
					+ "	fisRegraValidadeFinal =  ?,\r\n"
					+ "	id_produto =  ?,\r\n"
					+ "	dataatualizacao =  ?,\r\n"
					+ "resultadoConsulta = ?"
					+ "WHERE\r\n"
					+ "  metaassessoria.prod.EAN = ?;";
			
			 PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getEAN());
			stmt.setInt(2, p.getCodigo());
			stmt.setString(3, p.getProdutoDescricao());
			stmt.setString(4, p.getProdutoDescricaoNota());
			stmt.setString(5, p.getProdutoDescricaoFornecedor());
			stmt.setString(6, p.getProdutoDiasValidade());
			stmt.setString(7, p.getEmbalagemUnitariaPesoBruto());
			stmt.setString(8, p.getEmbalagemUnitariaPesoLiquido());
			stmt.setString(9, p.getEmbalagemUnitariaAltura());
			stmt.setString(10, p.getEmbalagemUnitariaLargura());
			stmt.setString(11, p.getEmbalagemUnitariaProfundidade());
			stmt.setInt(12, p.getEmbalagemUnitariaId());
			stmt.setString(13, p.getEmbalagemUnitariaDescricao());
			stmt.setString(14, p.getEmbalagemUnitariaCapacidade());
			stmt.setString(15, p.getEmbalagemUnitariaUnidadeMedida());
			stmt.setString(16, p.getEmbalagemUnitariaUnidadeSigla());
			stmt.setInt(17, p.getFabricanteId());
			stmt.setString(18, p.getFabricanteNome());
			stmt.setInt(19, p.getFabricanteMarcaid());
			stmt.setString(20, p.getFabricanteMarcaDescricao());
			stmt.setInt(21, p.getMercadologicaDepartamentoId());
			stmt.setString(22, p.getMercadologicaDepartamentoNome());
			stmt.setInt(23, p.getMercadologicaSecaoId());
			stmt.setString(24, p.getMercadologicaSecaoNome());
			stmt.setInt(25, p.getMercadologicaGrupoId());
			stmt.setString(26, p.getMercadologicaGrupoNome());
			stmt.setInt(27, p.getMercadologicaSubgrupoId());
			stmt.setString(28, p.getMercadologicaSubgrupoNome());
			stmt.setInt(29, p.getAtivo());
			stmt.setString(30, p.getLogEmbalagem());
			stmt.setString(31, p.getLogDum14());
			stmt.setDouble(32, p.getLogAlturaCm());
			stmt.setDouble(33, p.getLogLarguraCm());
			stmt.setDouble(34, p.getLogProfundidadeCm());
			stmt.setDouble(35, p.getLogPesoKg());
			stmt.setDouble(36, p.getQtdEmbal());
			stmt.setDouble(37, p.getLogQtdLastro());
			stmt.setDouble(38, p.getLogQtdCamadas());
			stmt.setString(39, p.getTributarioNcm());
			stmt.setString(40, p.getTributarioCest());
			stmt.setString(41, p.getTributarioFiguraFiscal());
			stmt.setString(42, p.getCodigoBeneficioFiscalIcms());
			stmt.setString(43, p.getCodigoBeneficioFiscalPisCofins());
			stmt.setString(44, p.getTribRegraDescricao());
			stmt.setString(45, p.getTribRegraUfOrigem());
			stmt.setString(46, p.getTribRegraPerfilOrigem());
			stmt.setString(47, p.getTribRegraCodPerfilOrigem());
			stmt.setString(48, p.getTribRegraUfDestino());
			stmt.setString(49, p.getTribRegraPerfilDestino());
			stmt.setString(50, p.getTribRegraCodPerfilDestino());
			stmt.setString(51, p.getTribRegraCfop());
			stmt.setString(52, p.getTribIcmsCst());
			stmt.setDouble(53, p.getTribIcmsAliq());
			stmt.setDouble(54, p.getTribIcmsReducao());
			stmt.setDouble(55, p.getTribIcmsStAliq());
			stmt.setString(56, p.getTribIcmsStPauta());
			stmt.setDouble(57, p.getTribIcmsStMva());
			stmt.setDouble(58, p.getTribFcpAliq());
			stmt.setDouble(59, p.getTribDifalAliq());
			stmt.setString(60, p.getTribRegraPisCst());
			stmt.setString(61, p.getTribRegraPisCstE());
			stmt.setString(62, p.getTribPisReducao());
			stmt.setString(63, p.getTribPisAliq());
			stmt.setString(64, p.getFisRegraCofinsCst());
			stmt.setString(65, p.getTribCofinsReducao());
			stmt.setString(66, p.getTribCofinAliq());
			stmt.setString(67, p.getFisRegraValidadeInicio());
			stmt.setString(68, p.getFisRegraValidadeFinal());
			stmt.setInt(69, p.getId_produto());
			stmt.setString(70, df.format(hoje));
			stmt.setString(71, p.getResultadoConsulta());
			
			// update
			stmt.setInt(72, p.getCodigo());
			stmt.setString(73, p.getProdutoDescricao());
			stmt.setString(74, p.getProdutoDescricaoNota());
			stmt.setString(75, p.getProdutoDescricaoFornecedor());
			stmt.setString(76, p.getProdutoDiasValidade());
			stmt.setString(77, p.getEmbalagemUnitariaPesoBruto());
			stmt.setString(78, p.getEmbalagemUnitariaPesoLiquido());
			stmt.setString(79, p.getEmbalagemUnitariaAltura());
			stmt.setString(80, p.getEmbalagemUnitariaLargura());
			stmt.setString(81, p.getEmbalagemUnitariaProfundidade());
			stmt.setInt(82, p.getEmbalagemUnitariaId());
			stmt.setString(83, p.getEmbalagemUnitariaDescricao());
			stmt.setString(84, p.getEmbalagemUnitariaCapacidade());
			stmt.setString(85, p.getEmbalagemUnitariaUnidadeMedida());
			stmt.setString(86, p.getEmbalagemUnitariaUnidadeSigla());
			stmt.setInt(87, p.getFabricanteId());
			stmt.setString(88, p.getFabricanteNome());
			stmt.setInt(89, p.getFabricanteMarcaid());
			stmt.setString(90, p.getFabricanteMarcaDescricao());
			stmt.setInt(91, p.getMercadologicaDepartamentoId());
			stmt.setString(92, p.getMercadologicaDepartamentoNome());
			stmt.setInt(93, p.getMercadologicaSecaoId());
			stmt.setString(94, p.getMercadologicaSecaoNome());
			stmt.setInt(95, p.getMercadologicaGrupoId());
			stmt.setString(96, p.getMercadologicaGrupoNome());
			stmt.setInt(97, p.getMercadologicaSubgrupoId());
			stmt.setString(98, p.getMercadologicaSubgrupoNome());
			stmt.setInt(99, p.getAtivo());
			stmt.setString(100, p.getLogEmbalagem());
			stmt.setString(101, p.getLogDum14());
			stmt.setDouble(102, p.getLogAlturaCm());
			stmt.setDouble(103, p.getLogLarguraCm());
			stmt.setDouble(104, p.getLogProfundidadeCm());
			stmt.setDouble(105, p.getLogPesoKg());
			stmt.setDouble(106, p.getQtdEmbal());
			stmt.setDouble(107, p.getLogQtdLastro());
			stmt.setDouble(108, p.getLogQtdCamadas());
			stmt.setString(109, p.getTributarioNcm());
			stmt.setString(110, p.getTributarioCest());
			stmt.setString(111, p.getTributarioFiguraFiscal());
			stmt.setString(112, p.getCodigoBeneficioFiscalIcms());
			stmt.setString(113, p.getCodigoBeneficioFiscalPisCofins());
			stmt.setString(114, p.getTribRegraDescricao());
			stmt.setString(115, p.getTribRegraUfOrigem());
			stmt.setString(116, p.getTribRegraPerfilOrigem());
			stmt.setString(117, p.getTribRegraCodPerfilOrigem());
			stmt.setString(118, p.getTribRegraUfDestino());
			stmt.setString(119, p.getTribRegraPerfilDestino());
			stmt.setString(120, p.getTribRegraCodPerfilDestino());
			stmt.setString(121, p.getTribRegraCfop());
			stmt.setString(122, p.getTribIcmsCst());
			stmt.setDouble(123, p.getTribIcmsAliq());
			stmt.setDouble(124, p.getTribIcmsReducao());
			stmt.setDouble(125, p.getTribIcmsStAliq());
			stmt.setString(126, p.getTribIcmsStPauta());
			stmt.setDouble(127, p.getTribIcmsStMva());
			stmt.setDouble(128, p.getTribFcpAliq());
			stmt.setDouble(129, p.getTribDifalAliq());
			stmt.setString(130, p.getTribRegraPisCst());
			stmt.setString(131, p.getTribRegraPisCstE());
			stmt.setString(132, p.getTribPisReducao());
			stmt.setString(133, p.getTribPisAliq());
			stmt.setString(134, p.getFisRegraCofinsCst());
			stmt.setString(135, p.getTribCofinsReducao());
			stmt.setString(136, p.getTribCofinAliq());
			stmt.setString(137, p.getFisRegraValidadeInicio());
			stmt.setString(138, p.getFisRegraValidadeFinal());
			stmt.setInt(139, p.getId_produto());
			stmt.setString(140, df.format(hoje));
			stmt.setString(141, p.getResultadoConsulta());
			stmt.setString(142, p.getEAN());
			  
			 int rowsInserted = stmt.executeUpdate();
			 
			 if (rowsInserted > 0) {
			     System.out.println("A new user was inserted successfully!");
			 }
			
		}catch (Exception e) {
			e.printStackTrace();
				
		}
	}

}
