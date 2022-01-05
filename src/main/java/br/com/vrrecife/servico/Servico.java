package br.com.vrrecife.servico;

import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

import br.com.vrrecife.dominio.Produto;
import br.com.vrrecife.util.Util;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Servico {
	static String webService = "http://metaassessoria2.ddns.net:23145";
	static int codSucesso = 000;
	

	
	public static Produto consultarProduto(String cnpj, String usuario,String ean,String ambiente, String token) {
		Date hoje = Calendar.getInstance().getTime();
		Produto p = null;
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		
		
			
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
			String log = "{\"logDum14\":\"\",\"QtdEmbal\":\"0\",\"logProfundidadeCm\":\"0\",\"logAlturaCm\":\"0\",\"logLarguraCm\":\"0\",\"logEmbalagem\":\"\",\"logPesoKg\":\"0\",\"LogQtdCamadas\":\"0\",\"LogQtdLastro\":\"0\"}";
			 Response response = client.newCall(request).execute();
			
			 JSONObject jsonObject = new JSONObject(response.body().source().readUtf8());
			 String jsonEmString = jsonObject.toString(4);
			 
			 JSONObject produtos = new JSONObject(jsonEmString);
			 
			 
			 JSONObject produto = produtos.getJSONObject("produto");
////			 Extrai apenas o array do bloco dados logísticos do JSon se não estiver nulo  
//			 JSONObject arrDadosLogisticos;
//			 if(produtos.getJSONArray("dadosLogisticos").length()==0) {
//				 arrDadosLogisticos = new JSONObject(log); //se tiver nulo tem um json pronto pra substituir
//			 }else
//			 arrDadosLogisticos = (JSONObject) produtos.getJSONArray("dadosLogisticos").get(0); 
////			 Extrai apenas o array do bloco dados tributários do JSon 		
//			 JSONObject arrDadosTributarios = (JSONObject) produtos.getJSONArray("dadosTributarios").get(0); 
////			 Extrai apenas o array do bloco regras tributarias do JSon  
//			 JSONObject arrRegrasTributarias = (JSONObject) produtos.getJSONArray("regrasTributarias").get(0); 
//			 JSONObject arrRegrasTributariasE = (JSONObject) produtos.getJSONArray("regrasTributarias").get(1);
//			 //retorno da consulta
//			 
//			 
//			  p = new Produto();
//			 
//			 		p.setCodigo(produto.getInt("Codigo")); 
//					p.setEAN(produto.getString("EAN")); 
//					p.setProdutoDescricao(produto.getString("produtoDescricao")); 
//					p.setProdutoDescricaoNota(produto.getString("produtoDescricaoNota"));
//					p.setProdutoDescricaoFornecedor(produto.getString("produtoDescricaoFornecedor"));
//					p.setProdutoDiasValidade(produto.getInt("produtoDiasValidade")); 
//					p.setEmbalagemUnitariaPesoBruto(produto.getDouble("embalagemUnitariaPesoBruto")); 
//					p.setEmbalagemUnitariaPesoLiquido(produto.getDouble("embalagemUnitariaPesoLiquido")); 
//					p.setEmbalagemUnitariaAltura(produto.getDouble("embalagemUnitariaAltura")); 
//					p.setEmbalagemUnitariaLargura(produto.getDouble("embalagemUnitariaLargura")); 
//					p.setEmbalagemUnitariaProfundidade(produto.getDouble("embalagemUnitariaProfundidade")); 
//					p.setEmbalagemUnitariaId(produto.getInt("embalagemUnitariaId")); 
//					p.setEmbalagemUnitariaDescricao(produto.getString("embalagemUnitariaDescricao")); 
//					p.setEmbalagemUnitariaCapacidade(produto.getString("embalagemUnitariaCapacidade")); 
//					p.setEmbalagemUnitariaUnidadeMedida(produto.getString("embalagemUnitariaUnidadeMedida")); 
//					p.setEmbalagemUnitariaUnidadeMedida(produto.getString("embalagemUnitariaUnidadeSigla")); 
//					p.setFabricanteId(produto.getInt("fabricanteId")); 
//					p.setFabricanteNome(produto.getString("fabricanteNome")); 
//					p.setFabricanteId(produto.getInt("fabricanteMarcaid")); 
//					p.setFabricanteMarcaDescricao(produto.getString("fabricanteMarcaDescricao")); 
//					p.setMercadologicaDepartamentoId(produto.getInt("mercadologicaDepartamentoId")); 
//					p.setMercadologicaDepartamentoNome(produto.getString("mercadologicaDepartamentoNome")); 
//					p.setMercadologicaSecaoId(produto.getInt("mercadologicaSecaoId")); 
//					p.setMercadologicaSecaoNome(produto.getString("mercadologicaSecaoNome")); 
//					p.setMercadologicaGrupoId(produto.getInt("mercadologicaGrupoId")); 
//					p.setMercadologicaGrupoNome(produto.getString("mercadologicaGrupoNome")); 
//					p.setMercadologicaSubgrupoId(produto.getInt("mercadologicaSubgrupoId")); 
//					p.setMercadologicaSubgrupoNome(produto.getString("mercadologicaSubgrupoNome")); 
//					p.setAtivo(produto.getInt("Ativo")); 
//					p.setLogEmbalagem(arrDadosLogisticos.getString("logEmbalagem")); 
//					p.setLogDum14(arrDadosLogisticos.getString("logDum14")); 
//					p.setLogAlturaCm(arrDadosLogisticos.getDouble("logAlturaCm")); 
//					p.setLogLarguraCm(arrDadosLogisticos.getDouble("logLarguraCm")); 
//					p.setLogProfundidadeCm(arrDadosLogisticos.getDouble("logProfundidadeCm")); 
//					p.setLogPesoKg(arrDadosLogisticos.getDouble("logPesoKg")); 
//					p.setQtdEmbal(arrDadosLogisticos.getDouble("QtdEmbal")); 
//					p.setLogQtdLastro(arrDadosLogisticos.getDouble("LogQtdLastro")); 
//					p.setLogQtdCamadas(arrDadosLogisticos.getDouble("LogQtdCamadas")); 
//					p.setTributarioNcm(arrDadosTributarios.getString("tributarioNcm")); 
//					p.setTributarioCest(arrDadosTributarios.getString("tributarioCest")); 
//					p.setTributarioFiguraFiscal(arrDadosTributarios.getString("tributarioFiguraFiscal")); 
//					p.setCodigoBeneficioFiscalIcms(arrDadosTributarios.getString("CodigoBeneficioFiscalIcms")); 
//					p.setCodigoBeneficioFiscalPisCofins(arrDadosTributarios.getString("CodigoBeneficioFiscalPisCofins")); 
//					p.setTribRegraDescricao(arrRegrasTributarias.getString("tribRegraDescricao")); 
//					p.setTribRegraUfOrigem(arrRegrasTributarias.getString("tribRegraUfOrigem")); 
//					p.setTribRegraPerfilOrigem(arrRegrasTributarias.getString("TribRegraPerfilOrigem")); 
//					p.setTribRegraCodPerfilOrigem(arrRegrasTributarias.getString("TribRegraCodPerfilOrigem")); 
//					p.setTribRegraUfDestino(arrRegrasTributarias.getString("tribRegraUfDestino")); 
//					p.setTribRegraCodPerfilDestino(arrRegrasTributarias.getString("TribRegraPerfilDestino")); 
//					p.setTribRegraCodPerfilDestino(arrRegrasTributarias.getString("TribRegraCodPerfilDestino")); 					
//					p.setTribRegraCfop(arrRegrasTributarias.getString("tribRegraCfop")); 
//					p.setTribIcmsCst(arrRegrasTributarias.getString("tribIcmsCst")); 
//					p.setTribIcmsAliq(arrRegrasTributarias.getDouble("tribIcmsAliq")); 
//					p.setTribIcmsReducao(arrRegrasTributarias.getDouble("tribIcmsReducao")); 
//					p.setTribIcmsStAliq(arrRegrasTributarias.getDouble("tribIcmsStAliq")); 
//					p.setTribIcmsStPauta(arrRegrasTributarias.getString("tribIcmsStPauta")); 
//					p.setTribIcmsStMva(arrRegrasTributarias.getDouble("tribIcmsStMva")); 
//					p.setTribFcpAliq(arrRegrasTributarias.getDouble("tribFcpAliq")); 
//					p.setTribDifalAliq(arrRegrasTributarias.getDouble("tribDifalAliq")); 
//					p.setTribRegraPisCst(arrRegrasTributarias.getString("tribRegraPisCst")); 
//					p.setTribRegraPisCstE(arrRegrasTributariasE.getString("tribRegraPisCst")); 
//					p.setTribPisReducao(arrRegrasTributarias.getString("tribPisReducao")); 
//					p.setTribPisAliq(arrRegrasTributarias.getString("tribPisAliq")); 
//					p.setFisRegraCofinsCst(arrRegrasTributarias.getString("fisRegraCofinsCst")); 
//					p.setTribCofinsReducao(arrRegrasTributarias.getString("tribCofinsReducao")); 
//					p.setTribCofinAliq(arrRegrasTributarias.getString("tribCofinAliq")); 
//					p.setFisRegraValidadeInicio(arrRegrasTributarias.getString("fisRegraValidadeInicio")); 
//					p.setFisRegraValidadeFinal(arrRegrasTributarias.getString("fisRegraValidadeFinal"));	
//					p.setId_produto(0);
//					p.setResultadoConsulta(produtos.getString("resultadoConsulta"));
					
			// System.out.println(p.toString());
			 
			 System.out.println(Util.retornaProduto(produtos));
			 System.out.println(Util.retornaDadosLogisticos(produtos));
			 System.out.println(Util.retornaDadosTributarios(produtos));
			 System.out.println(Util.retornaRegrasTributarias(produtos));
			// String temp = produtos.getJSONArray("dadosLogisticos").get(0);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			return p;
	}
		
	
}
