package br.com.vrrecife.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.vrrecife.dominio.ProdutoRetorno;
import conexao.ConexaoServidor;

public class ProdutoRetornoDAO {

	private String sql = "select * from METAASSESORIAPROD where METAASSESORIAPROD.CODIGOBARRAS = ? ";
	
	ConexaoServidor con = new ConexaoServidor();
	
	PreparedStatement stmt = null;
	ProdutoRetorno pr = new ProdutoRetorno();
	
	public ProdutoRetorno retornar(String ean) {
		try {
			
			con.abrirConexao("localhost", 8745, "schweikardt", "postgres", "VrPost@Server");
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ean);
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()){
				
			
			pr.setId(rs.getInt("id"));
			pr.setEan(rs.getString("codigobarras"));
			pr.setDescricaocompleta(rs.getString("descricaocompleta"));
			pr.setNcm_old(rs.getString("ncm_old"));
			pr.setNcm_novo(rs.getString("ncm_novo"));
			pr.setNcm1_novo(rs.getInt("ncm1_novo"));
			pr.setNcm2_novo(rs.getInt("ncm2_novo"));
			pr.setNcm3_novo(rs.getInt("ncm3_novo"));
			pr.setId_cest_old(rs.getInt("id_cest_old"));
			pr.setCest_old(rs.getString("cest_old"));
			pr.setId_cest_novo(rs.getInt("id_cest_novo"));
			pr.setCest_novo(rs.getString("cest_novo"));
			pr.setId_beneficio_novo(rs.getInt("id_beneficio_novo"));
			pr.setCodigo_beneficio_novo(rs.getString("codigo_beneficio_novo"));
			pr.setId_produto_aliquota_beneficio(rs.getInt("id_produto_aliquota_beneficio"));
			pr.setId_beneficio_old(rs.getInt("id_beneficio_old"));
			pr.setCodigo_beneficio_old(rs.getString("codigo_beneficio_old"));
			pr.setId_produtoaliquota(rs.getInt("id_produtoaliquota"));
			pr.setId_tribvenda(rs.getInt("id_tribvenda"));
			pr.setDesc_tribvenda(rs.getString("desc_tribvenda"));
			pr.setId_tribvenda_novo(rs.getInt("id_tribvenda_novo"));
			pr.setDesc_tribvenda_novo(rs.getString("desc_tribvenda_novo"));
			pr.setTrib_a_cadastrar(rs.getString("trib_a_cadastrar"));
			pr.setPiscofinsdebito_novo(rs.getInt("piscofinsdebito_novo"));
			pr.setId_pis_debito_novo(rs.getInt("id_pis_debito_novo"));
			pr.setPiscofinscredito_novo(rs.getInt("piscofinscredito_novo"));
			pr.setId_pis_credito_novo(rs.getInt("id_pis_credito_novo"));
			pr.setPis_debito_old(rs.getInt("pis_debito_old"));
			pr.setPis_credito_old(rs.getInt("pis_credito_old"));
			pr.setDescricao_pis_novo(rs.getString("descricao_pis_novo"));
			pr.setDescricao_pis_old(rs.getString("descricao_pis_old"));
			}
			if(pr.getId()== 0) {
				JOptionPane.showMessageDialog(null, "Produto não encontrado no VR");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	
	return pr;
	
	}	
	
}
