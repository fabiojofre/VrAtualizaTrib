package br.com.vrrecife.repository;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.vrrecife.dominio.ProdutoRetorno;
import conexao.ConexaoServidor;
import vrrecifeframework.classes.VrProperties;

public class ProdutoAtualiza {
	ConexaoServidor con = new ConexaoServidor();
	ProdutoRetornoDAO pr =  new ProdutoRetornoDAO();
	ProdutoRetorno	p = new ProdutoRetorno();
	
	String db_ip =  VrProperties.getString("database.ip");
	int db_porta = VrProperties.getInt("database.porta");
	String db_nome = VrProperties.getString("database.nome");
	String db_usuario = VrProperties.getString("database.usuario");
	String db_senha = VrProperties.getString("database.senha");
	
	
	public void atualizaNcm(ProdutoRetorno p) {
		
		try {
			
			String sql ="update produto set ncm1 = ?, ncm2 = ?, ncm3 = ? where id = ?";
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			PreparedStatement stmt = con.prepareStatement(sql);
			
		
			stmt.setInt(1, p.getNcm1_novo());
			stmt.setInt(2, p.getNcm2_novo());
			stmt.setInt(3, p.getNcm3_novo());
			stmt.setInt(4, p.getId());
			
			int rowsInserted = stmt.executeUpdate();
			 
			 if (rowsInserted > 0) {
			     System.out.println("A new user was inserted successfully!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void atualizaCest(ProdutoRetorno p) {
	
		try {
			
			String sql ="update produto set id_cest = ? where id= ?";
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			PreparedStatement stmt = con.prepareStatement(sql);
				
		
			stmt.setInt(1, p.getId_cest_novo());
			stmt.setInt(2, p.getId());
			
			int rowsInserted = stmt.executeUpdate();
			 
			 if (rowsInserted > 0) {
			     System.out.println("A new user was inserted successfully!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void atualizaPisCofins(ProdutoRetorno p) {
		
		try {
			
			String sql ="update produto set id_tipopiscofins = ?, id_tipopiscofinscredito = ? where id = ?";
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			PreparedStatement stmt = con.prepareStatement(sql);
				
		
			stmt.setInt(1, p.getId_pis_debito_novo());
			stmt.setInt(2, p.getId_pis_credito_novo());
			stmt.setInt(3, p.getId());
			
			int rowsInserted = stmt.executeUpdate();
			 
			 if (rowsInserted > 0) {
			     System.out.println("A new user was inserted successfully!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void atualizaTribVenda(ProdutoRetorno p){
		
		try {
			
			String sql ="update produtoaliquota set id_aliquotadebito =?, id_aliquotaconsumidor = ? where id =?";
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			PreparedStatement stmt = con.prepareStatement(sql);
				
		
			stmt.setInt(1, p.getId_tribvenda_novo());
			stmt.setInt(2, p.getId_tribvenda_novo());
			stmt.setInt(3, p.getId_produtoaliquota());
			
			int rowsInserted = stmt.executeUpdate();
			 
			 if (rowsInserted > 0) {
			     System.out.println("A new user was inserted successfully!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void atualizaBeneficio(ProdutoRetorno p){
		
		try {
			
			String sql ="update produtoaliquotabeneficio set id_aliquota =?, id_beneficio = ? where id_produtoaliquota = ?";
			con.abrirConexao(db_ip, db_porta, db_nome, db_usuario, db_senha);
			PreparedStatement stmt = con.prepareStatement(sql);
				
		
			stmt.setInt(1, p.getId_tribvenda_novo());
			stmt.setInt(2, p.getId_beneficio_novo());
			stmt.setInt(3, p.getId_produtoaliquota());
			
			int rowsInserted = stmt.executeUpdate();
			 
			 if (rowsInserted > 0) {
			     System.out.println("A new user was inserted successfully!");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
