
import br.com.vrrecife.repository.ProdutoDAO;
import br.com.vrrecife.repository.ProdutoRetornoDAO;


/**
 *
 * @author fabio
 */
public class Teste {
    public static void main(String args[]){
          
    	ProdutoDAO pd = new ProdutoDAO();
    	pd.salvar("7896894900013");
    	
    	ProdutoRetornoDAO pr = new ProdutoRetornoDAO();
    	System.out.println(pr.retornar("7896894900013").toString());
//    	ProdutoAtualiza pa = new ProdutoAtualiza();
//    	pa.ataluzaBeneficio();
    	
    }
}