
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.vrrecife.dominio.Produto;
import br.com.vrrecife.repository.ProdutoDAO;

import com.google.gson.Gson;

import br.com.vrrecife.servico.Servico;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 *
 * @author fabio
 */
public class Teste {
    public static void main(String args[]){
//              try {   
//            	  
//            	 
//     OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
//    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
//				  .addFormDataPart("cnpj","04524935000128")
//				  .addFormDataPart("usuario","OperadorXx")
//				  .addFormDataPart("ean","7896404603359")
//				  .build();
//    Request request = new Request.Builder()
//				  .url("http://metaassessoria2.ddns.net:23145")
//				  .method("POST", body)
//				  .addHeader("token", "0202-0222-2202")
//				  .addHeader("ambiente", "H")
//				  .addHeader("Content-Type", "application/x-www-form-urlencoded")
//				  .build();
//  
//            Response response = client.newCall(request).execute();
//            Gson gson = new Gson();
//                   System.out.println(response.body().source().readUtf8());
//              
//        } catch (IOException ex) {
//            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
     
        	Produto p = Servico.consultarProduto("04524935000128", "OperadorXx", "7896306617492", "H", "0202-0222-2202");
        //System.out.println(p.toString());
     
//    	ProdutoDAO pd = new ProdutoDAO();
//    	pd.salvar();
    }
}