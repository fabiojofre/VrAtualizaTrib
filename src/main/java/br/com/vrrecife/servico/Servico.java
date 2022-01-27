package br.com.vrrecife.servico;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import br.com.vrrecife.dominio.Produto;
import br.com.vrrecife.util.Util;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Servico {
	static String webService = "http://metaassessoria2.ddns.net:23145";
	public static String codSucesso;
	

	
	public static Produto consultarProduto(String cnpj, String usuario,String ean,String ambiente, String token) {
		
		Produto p = null;
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		//MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		
		
			
			RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
					  .addFormDataPart("cnpj",cnpj)
					  .addFormDataPart("usuario",usuario)
					  .addFormDataPart("ean",ean)
					  .build();
			Request request = new Request.Builder()
					  .url(webService)
					  .method("POST", body)
					  .addHeader("token", token)
					  .addHeader("ambiente", ambiente)
					  .addHeader("Content-Type", "application/x-www-form-urlencoded")
					  .build();
			
			try {
			Response response = client.newCall(request).execute();
			
			 JSONObject jsonObject = new JSONObject(response.body().source().readUtf8());
			 String jsonEmString = jsonObject.toString(4);
			 
			 JSONObject produtos = new JSONObject(jsonEmString);
			 
			codSucesso =  response.message();
			
				
			
			 
			  p = new Produto();
			 
			 		p.setCodigo(Util.retornaProduto(produtos).getInt("Codigo")); 
					p.setEAN(Util.retornaProduto(produtos).getString("EAN")); 
					p.setProdutoDescricao(Util.retornaProduto(produtos).getString("produtoDescricao")); 
					p.setProdutoDescricaoNota(Util.retornaProduto(produtos).getString("produtoDescricaoNota"));
					p.setProdutoDescricaoFornecedor(Util.retornaProduto(produtos).getString("produtoDescricaoFornecedor"));
					p.setProdutoDiasValidade(Util.retornaProduto(produtos).getString("produtoDiasValidade")); 
					p.setEmbalagemUnitariaPesoBruto(Util.retornaProduto(produtos).getString("embalagemUnitariaPesoBruto")); 
					p.setEmbalagemUnitariaPesoLiquido(Util.retornaProduto(produtos).getString("embalagemUnitariaPesoLiquido")); 
					p.setEmbalagemUnitariaAltura(Util.retornaProduto(produtos).getString("embalagemUnitariaAltura")); 
					p.setEmbalagemUnitariaLargura(Util.retornaProduto(produtos).getString("embalagemUnitariaLargura")); 
					p.setEmbalagemUnitariaProfundidade(Util.retornaProduto(produtos).getString("embalagemUnitariaProfundidade")); 
					p.setEmbalagemUnitariaId(Util.retornaProduto(produtos).getInt("embalagemUnitariaId")); 
					p.setEmbalagemUnitariaDescricao(Util.retornaProduto(produtos).getString("embalagemUnitariaDescricao")); 
					p.setEmbalagemUnitariaCapacidade(Util.retornaProduto(produtos).getString("embalagemUnitariaCapacidade")); 
					p.setEmbalagemUnitariaUnidadeMedida(Util.retornaProduto(produtos).getString("embalagemUnitariaUnidadeMedida")); 
					p.setEmbalagemUnitariaUnidadeMedida(Util.retornaProduto(produtos).getString("embalagemUnitariaUnidadeSigla")); 
					p.setFabricanteId(Util.retornaProduto(produtos).getInt("fabricanteId")); 
					p.setFabricanteNome(Util.retornaProduto(produtos).getString("fabricanteNome")); 
					p.setFabricanteId(Util.retornaProduto(produtos).getInt("fabricanteMarcaid")); 
					p.setFabricanteMarcaDescricao(Util.retornaProduto(produtos).getString("fabricanteMarcaDescricao")); 
					p.setMercadologicaDepartamentoId(Util.retornaProduto(produtos).getInt("mercadologicaDepartamentoId")); 
					p.setMercadologicaDepartamentoNome(Util.retornaProduto(produtos).getString("mercadologicaDepartamentoNome")); 
					p.setMercadologicaSecaoId(Util.retornaProduto(produtos).getInt("mercadologicaSecaoId")); 
					p.setMercadologicaSecaoNome(Util.retornaProduto(produtos).getString("mercadologicaSecaoNome")); 
					p.setMercadologicaGrupoId(Util.retornaProduto(produtos).getInt("mercadologicaGrupoId")); 
					p.setMercadologicaGrupoNome(Util.retornaProduto(produtos).getString("mercadologicaGrupoNome")); 
					p.setMercadologicaSubgrupoId(Util.retornaProduto(produtos).getInt("mercadologicaSubgrupoId")); 
					p.setMercadologicaSubgrupoNome(Util.retornaProduto(produtos).getString("mercadologicaSubgrupoNome")); 
					p.setAtivo(Util.retornaProduto(produtos).getInt("Ativo")); 
					p.setLogEmbalagem(Util.retornaDadosLogisticos(produtos).getString("logEmbalagem")); 
					p.setLogDum14(Util.retornaDadosLogisticos(produtos).getString("logDum14")); 
					p.setLogAlturaCm(Util.retornaDadosLogisticos(produtos).getDouble("logAlturaCm")); 
					p.setLogLarguraCm(Util.retornaDadosLogisticos(produtos).getDouble("logLarguraCm")); 
					p.setLogProfundidadeCm(Util.retornaDadosLogisticos(produtos).getDouble("logProfundidadeCm")); 
					p.setLogPesoKg(Util.retornaDadosLogisticos(produtos).getDouble("logPesoKg")); 
					p.setQtdEmbal(Util.retornaDadosLogisticos(produtos).getDouble("QtdEmbal")); 
					p.setLogQtdLastro(Util.retornaDadosLogisticos(produtos).getDouble("LogQtdLastro")); 
					p.setLogQtdCamadas(Util.retornaDadosLogisticos(produtos).getDouble("LogQtdCamadas")); 
					p.setTributarioNcm(Util.retornaDadosTributarios(produtos).getString("tributarioNcm")); 
					p.setTributarioCest(Util.retornaDadosTributarios(produtos).getString("tributarioCest")); 
					p.setTributarioFiguraFiscal(Util.retornaDadosTributarios(produtos).getString("tributarioFiguraFiscal")); 
					p.setCodigoBeneficioFiscalIcms(Util.retornaDadosTributarios(produtos).getString("CodigoBeneficioFiscalIcms")); 
					p.setCodigoBeneficioFiscalPisCofins(Util.retornaDadosTributarios(produtos).getString("CodigoBeneficioFiscalPisCofins")); 
					p.setTribRegraDescricao(Util.retornaRegrasTributarias(produtos).getString("tribRegraDescricao")); 
					p.setTribRegraUfOrigem(Util.retornaRegrasTributarias(produtos).getString("tribRegraUfOrigem")); 
					p.setTribRegraPerfilOrigem(Util.retornaRegrasTributarias(produtos).getString("TribRegraPerfilOrigem")); 
					p.setTribRegraCodPerfilOrigem(Util.retornaRegrasTributarias(produtos).getString("TribRegraCodPerfilOrigem")); 
					p.setTribRegraUfDestino(Util.retornaRegrasTributarias(produtos).getString("tribRegraUfDestino")); 
					p.setTribRegraCodPerfilDestino(Util.retornaRegrasTributarias(produtos).getString("TribRegraPerfilDestino")); 
					p.setTribRegraCodPerfilDestino(Util.retornaRegrasTributarias(produtos).getString("TribRegraCodPerfilDestino")); 					
					p.setTribRegraCfop(Util.retornaRegrasTributarias(produtos).getString("tribRegraCfop")); 
					p.setTribIcmsCst(Util.retornaRegrasTributarias(produtos).getString("tribIcmsCst")); 
					p.setTribIcmsAliq(Util.retornaRegrasTributarias(produtos).getDouble("tribIcmsAliq")); 
					p.setTribIcmsReducao(Util.retornaRegrasTributarias(produtos).getDouble("tribIcmsReducao")); 
					p.setTribIcmsStAliq(Util.retornaRegrasTributarias(produtos).getDouble("tribIcmsStAliq")); 
					p.setTribIcmsStPauta(Util.retornaRegrasTributarias(produtos).getString("tribIcmsStPauta")); 
					p.setTribIcmsStMva(Util.retornaRegrasTributarias(produtos).getDouble("tribIcmsStMva")); 
					p.setTribFcpAliq(Util.retornaRegrasTributarias(produtos).getDouble("tribFcpAliq")); 
					p.setTribDifalAliq(Util.retornaRegrasTributarias(produtos).getDouble("tribDifalAliq")); 
					p.setTribRegraPisCst(Util.retornaRegrasTributarias(produtos).getString("tribRegraPisCst")); 
					p.setTribRegraPisCstE(Util.retornaRegrasTributariasE(produtos).getString("tribRegraPisCst")); 
					p.setTribPisReducao(Util.retornaRegrasTributarias(produtos).getString("tribPisReducao")); 
					p.setTribPisAliq(Util.retornaRegrasTributarias(produtos).getString("tribPisAliq")); 
					p.setFisRegraCofinsCst(Util.retornaRegrasTributarias(produtos).getString("fisRegraCofinsCst")); 
					p.setTribCofinsReducao(Util.retornaRegrasTributarias(produtos).getString("tribCofinsReducao")); 
					p.setTribCofinAliq(Util.retornaRegrasTributarias(produtos).getString("tribCofinAliq")); 
					p.setFisRegraValidadeInicio(Util.retornaRegrasTributarias(produtos).getString("fisRegraValidadeInicio")); 
					p.setFisRegraValidadeFinal(Util.retornaRegrasTributarias(produtos).getString("fisRegraValidadeFinal"));	
					p.setId_produto(0);
					p.setResultadoConsulta(produtos.getString("resultadoConsulta"));
					p.setStatusWeb(codSucesso);
					
			// System.out.println(p.toString());
			 
			 System.out.println(Util.retornaProduto(produtos));
			 System.out.println(Util.retornaDadosLogisticos(produtos));
			 System.out.println(Util.retornaDadosTributarios(produtos));
			 System.out.println(Util.retornaRegrasTributarias(produtos));
			 System.out.println(Util.retornaRegrasTributariasE(produtos));
			// String temp = produtos.getJSONArray("dadosLogisticos").get(0);
			//System.out.println(codSucesso);
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Webservice Temporariamente dora do ar! \n"+ "Tente novamente mais tarde!");
		}
			return p;
	}
	
}
