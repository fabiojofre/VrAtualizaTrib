
import javax.swing.JOptionPane;

import br.com.vrrecife.dominio.Produto;
import br.com.vrrecife.servico.Servico;


/**
 *
 * @author fabio
 */
public class Teste {
    public static void main(String args[]){
//    	Servico s =new Servico();
//    	Produto p = new Produto();
//    	p = s.consultarProduto("04524935000128", "OperadorXx", "7896894900013", "H", "0202-0222-2202");
//    	p.toString();
//    	ProdutoDAO pd = new ProdutoDAO();
//    	pd.salvar("7896259411956");
    	
//    	ProdutoRetornoDAO pr = new ProdutoRetornoDAO();
//    	System.out.println(pr.retornar("7896894900013").toString());
//    	ProdutoAtualiza pa = new ProdutoAtualiza();
//    	pa.ataluzaBeneficio();
    	
    	Object[] options = {"Atualizar","Cancelar"};
    	int valor = JOptionPane.showOptionDialog(null, "Esse processo não poderá ser desfeito!! \n"+"Deseja continuar?", "Atenção!!",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, options, options[0]);
    	System.out.println(valor);
    }
}