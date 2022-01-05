package br.com.vrrecife.util;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.vrrecife.dominio.Produto;

public class Util {
	 	 
	 
	 public static JSONObject retornaProduto(JSONObject json) {
//		 Extrai apenas o bloco produto do JSon
		 JSONObject produto = json.getJSONObject("produto");	
		 return produto;
	 }
	 public static JSONObject retornaDadosLogisticos(JSONObject json) {
		 String log = "{\"logDum14\":\"\",\"QtdEmbal\":\"0\",\"logProfundidadeCm\":\"0\",\"logAlturaCm\":\"0\",\"logLarguraCm\":\"0\",\"logEmbalagem\":\"\",\"logPesoKg\":\"0\",\"LogQtdCamadas\":\"0\",\"LogQtdLastro\":\"0\"}";			 
		 JSONObject obj = null;
		 JSONArray arrDadosLogisticos = json.getJSONArray("dadosLogisticos");
		 
		 if(arrDadosLogisticos.length() == 0) {
			 obj = new JSONObject(log);
		 }else
			 obj = json.getJSONArray("dadosLogisticos").getJSONObject(0); 
		return  obj;
	 }
	 public static JSONObject retornaDadosTributarios(JSONObject json) {
//		 Extrai apenas o array do bloco dados tributários do JSon 		
		 JSONObject dados =  json.getJSONArray("dadosTributarios").getJSONObject(0); 
		 return dados;
	 }
	 
	 public static JSONObject retornaRegrasTributarias(JSONObject json) {
		
		 JSONObject dados = null;
		 
		 for(int i =0;i<json.getJSONArray("regrasTributarias").length();i++) {
			 JSONObject j = json.getJSONArray("regrasTributarias").getJSONObject(i);
			 if(j.getString("tribRegraCfop").substring(0, 1).equals("5")&& j.getString("TribRegraPerfilDestino").substring(0, 1).equals("CONSUMIDOR NAO CONTRIBUINTE")) {
				 dados = j;
			 }else
				 dados = json.getJSONArray("regrasTributarias").getJSONObject(i);
		 }

		 return dados;
	 }
	 
}
