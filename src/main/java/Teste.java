
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
    	
//    	Object[] options = {"Atualizar","Cancelar"};
//    	int valor = JOptionPane.showOptionDialog(null, "Esse processo n�o poder� ser desfeito!! \n"+"Deseja continuar?", "Aten��o!!",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, options, options[0]);
//    	System.out.println(valor);
    	Calendar c = Calendar.getInstance();
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	String dataFormatada = formatter.format(c.getTime());
    	System.out.println(dataFormatada);
    	
    	String dia = dataFormatada.substring(0,2);
    	String mes = dataFormatada.substring(3,5);
		String ano = dataFormatada.substring(8,10);
		
		System.out.println("VR"+Integer.parseInt(mes)+dia+ano+"OFT");
    }
}