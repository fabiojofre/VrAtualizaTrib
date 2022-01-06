package br.com.vrrecife.dominio;

public class Produto {

	private int Codigo;
	private String EAN;
	private String produtoDescricao;
	private String produtoDescricaoNota;
	private String produtoDescricaoFornecedor;
	private String produtoDiasValidade;
	private double embalagemUnitariaPesoBruto;
	private double embalagemUnitariaPesoLiquido;
	private double embalagemUnitariaAltura;
	private double embalagemUnitariaLargura;
	private double embalagemUnitariaProfundidade;
	private int embalagemUnitariaId;
	private String embalagemUnitariaDescricao;
	private String embalagemUnitariaCapacidade;
	private String embalagemUnitariaUnidadeMedida;
	private String embalagemUnitariaUnidadeSigla;
	private int fabricanteId;
	private String fabricanteNome;
	private int fabricanteMarcaid;
	private String fabricanteMarcaDescricao;
	private int mercadologicaDepartamentoId;
	private String mercadologicaDepartamentoNome;
	private int mercadologicaSecaoId;
	private String mercadologicaSecaoNome;
	private int mercadologicaGrupoId;
	private String mercadologicaGrupoNome;
	private int mercadologicaSubgrupoId;
	private String mercadologicaSubgrupoNome;
	private int Ativo;
	// dados Logísticos
	private String logEmbalagem;
	private String logDum14;
	private double logAlturaCm;
	private double logLarguraCm;
	private double logProfundidadeCm;
	private double logPesoKg;
	private double QtdEmbal;
	private double LogQtdLastro;
	private double LogQtdCamadas;
	// dados tributários
	private String tributarioNcm;
	private String tributarioCest;
	private String tributarioFiguraFiscal;
	private String CodigoBeneficioFiscalIcms;
	private String CodigoBeneficioFiscalPisCofins;
	// regras tributárias
	private String tribRegraDescricao;
	private String tribRegraUfOrigem;
	private String TribRegraPerfilOrigem;
	private String TribRegraCodPerfilOrigem;
	private String tribRegraUfDestino;
	private String TribRegraPerfilDestino;
	private String TribRegraCodPerfilDestino;
	private String tribRegraCfop;
	private String tribIcmsCst;
	private double tribIcmsAliq;
	private double tribIcmsReducao;
	private double tribIcmsStAliq;
	private String tribIcmsStPauta;
	private double tribIcmsStMva;
	private double tribFcpAliq;
	private double tribDifalAliq;
	private String tribRegraPisCst;
	private String tribRegraPisCstE;
	private String tribPisReducao;
	private String tribPisAliq;
	private String fisRegraCofinsCst;
	private String tribCofinsReducao;
	private String tribCofinAliq;
	private String fisRegraValidadeInicio;
	private String fisRegraValidadeFinal;
	private int id_produto;
	private String dataatualizacao;
	private String resultadoConsulta;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public String getProdutoDescricaoNota() {
		return produtoDescricaoNota;
	}

	public void setProdutoDescricaoNota(String produtoDescricaoNota) {
		this.produtoDescricaoNota = produtoDescricaoNota;
	}

	public String getProdutoDescricaoFornecedor() {
		return produtoDescricaoFornecedor;
	}

	public void setProdutoDescricaoFornecedor(String produtoDescricaoFornecedor) {
		this.produtoDescricaoFornecedor = produtoDescricaoFornecedor;
	}

	public String getProdutoDiasValidade() {
		return produtoDiasValidade;
	}

	public void setProdutoDiasValidade(String produtoDiasValidade) {
		this.produtoDiasValidade = produtoDiasValidade;
	}

	public double getEmbalagemUnitariaPesoBruto() {
		return embalagemUnitariaPesoBruto;
	}

	public void setEmbalagemUnitariaPesoBruto(double embalagemUnitariaPesoBruto) {
		this.embalagemUnitariaPesoBruto = embalagemUnitariaPesoBruto;
	}

	public double getEmbalagemUnitariaPesoLiquido() {
		return embalagemUnitariaPesoLiquido;
	}

	public void setEmbalagemUnitariaPesoLiquido(double embalagemUnitariaPesoLiquido) {
		this.embalagemUnitariaPesoLiquido = embalagemUnitariaPesoLiquido;
	}

	public double getEmbalagemUnitariaAltura() {
		return embalagemUnitariaAltura;
	}

	public void setEmbalagemUnitariaAltura(double embalagemUnitariaAltura) {
		this.embalagemUnitariaAltura = embalagemUnitariaAltura;
	}

	public double getEmbalagemUnitariaLargura() {
		return embalagemUnitariaLargura;
	}

	public void setEmbalagemUnitariaLargura(double embalagemUnitariaLargura) {
		this.embalagemUnitariaLargura = embalagemUnitariaLargura;
	}

	public double getEmbalagemUnitariaProfundidade() {
		return embalagemUnitariaProfundidade;
	}

	public void setEmbalagemUnitariaProfundidade(double embalagemUnitariaProfundidade) {
		this.embalagemUnitariaProfundidade = embalagemUnitariaProfundidade;
	}

	public int getEmbalagemUnitariaId() {
		return embalagemUnitariaId;
	}

	public void setEmbalagemUnitariaId(int embalagemUnitariaId) {
		this.embalagemUnitariaId = embalagemUnitariaId;
	}

	public String getEmbalagemUnitariaDescricao() {
		return embalagemUnitariaDescricao;
	}

	public void setEmbalagemUnitariaDescricao(String embalagemUnitariaDescricao) {
		this.embalagemUnitariaDescricao = embalagemUnitariaDescricao;
	}

	public String getEmbalagemUnitariaCapacidade() {
		return embalagemUnitariaCapacidade;
	}

	public void setEmbalagemUnitariaCapacidade(String embalagemUnitariaCapacidade) {
		this.embalagemUnitariaCapacidade = embalagemUnitariaCapacidade;
	}

	public String getEmbalagemUnitariaUnidadeMedida() {
		return embalagemUnitariaUnidadeMedida;
	}

	public void setEmbalagemUnitariaUnidadeMedida(String embalagemUnitariaUnidadeMedida) {
		this.embalagemUnitariaUnidadeMedida = embalagemUnitariaUnidadeMedida;
	}

	public String getEmbalagemUnitariaUnidadeSigla() {
		return embalagemUnitariaUnidadeSigla;
	}

	public void setEmbalagemUnitariaUnidadeSigla(String embalagemUnitariaUnidadeSigla) {
		this.embalagemUnitariaUnidadeSigla = embalagemUnitariaUnidadeSigla;
	}

	public int getFabricanteId() {
		return fabricanteId;
	}

	public void setFabricanteId(int fabricanteId) {
		this.fabricanteId = fabricanteId;
	}

	public String getFabricanteNome() {
		return fabricanteNome;
	}

	public void setFabricanteNome(String fabricanteNome) {
		this.fabricanteNome = fabricanteNome;
	}

	public int getFabricanteMarcaid() {
		return fabricanteMarcaid;
	}

	public void setFabricanteMarcaid(int fabricanteMarcaid) {
		this.fabricanteMarcaid = fabricanteMarcaid;
	}

	public String getFabricanteMarcaDescricao() {
		return fabricanteMarcaDescricao;
	}

	public void setFabricanteMarcaDescricao(String fabricanteMarcaDescricao) {
		this.fabricanteMarcaDescricao = fabricanteMarcaDescricao;
	}

	public int getMercadologicaDepartamentoId() {
		return mercadologicaDepartamentoId;
	}

	public void setMercadologicaDepartamentoId(int mercadologicaDepartamentoId) {
		this.mercadologicaDepartamentoId = mercadologicaDepartamentoId;
	}

	public String getMercadologicaDepartamentoNome() {
		return mercadologicaDepartamentoNome;
	}

	public void setMercadologicaDepartamentoNome(String mercadologicaDepartamentoNome) {
		this.mercadologicaDepartamentoNome = mercadologicaDepartamentoNome;
	}

	public int getMercadologicaSecaoId() {
		return mercadologicaSecaoId;
	}

	public void setMercadologicaSecaoId(int mercadologicaSecaoId) {
		this.mercadologicaSecaoId = mercadologicaSecaoId;
	}

	public String getMercadologicaSecaoNome() {
		return mercadologicaSecaoNome;
	}

	public void setMercadologicaSecaoNome(String mercadologicaSecaoNome) {
		this.mercadologicaSecaoNome = mercadologicaSecaoNome;
	}

	public int getMercadologicaGrupoId() {
		return mercadologicaGrupoId;
	}

	public void setMercadologicaGrupoId(int mercadologicaGrupoId) {
		this.mercadologicaGrupoId = mercadologicaGrupoId;
	}

	public String getMercadologicaGrupoNome() {
		return mercadologicaGrupoNome;
	}

	public void setMercadologicaGrupoNome(String mercadologicaGrupoNome) {
		this.mercadologicaGrupoNome = mercadologicaGrupoNome;
	}

	public int getMercadologicaSubgrupoId() {
		return mercadologicaSubgrupoId;
	}

	public void setMercadologicaSubgrupoId(int mercadologicaSubgrupoId) {
		this.mercadologicaSubgrupoId = mercadologicaSubgrupoId;
	}

	public String getMercadologicaSubgrupoNome() {
		return mercadologicaSubgrupoNome;
	}

	public void setMercadologicaSubgrupoNome(String mercadologicaSubgrupoNome) {
		this.mercadologicaSubgrupoNome = mercadologicaSubgrupoNome;
	}

	public int getAtivo() {
		return Ativo;
	}

	public void setAtivo(int ativo) {
		Ativo = ativo;
	}

	public String getLogEmbalagem() {
		return logEmbalagem;
	}

	public void setLogEmbalagem(String logEmbalagem) {
		this.logEmbalagem = logEmbalagem;
	}

	public String getLogDum14() {
		return logDum14;
	}

	public void setLogDum14(String logDum14) {
		this.logDum14 = logDum14;
	}

	public double getLogAlturaCm() {
		return logAlturaCm;
	}

	public void setLogAlturaCm(double logAlturaCm) {
		this.logAlturaCm = logAlturaCm;
	}

	public double getLogLarguraCm() {
		return logLarguraCm;
	}

	public void setLogLarguraCm(double logLarguraCm) {
		this.logLarguraCm = logLarguraCm;
	}

	public double getLogProfundidadeCm() {
		return logProfundidadeCm;
	}

	public void setLogProfundidadeCm(double logProfundidadeCm) {
		this.logProfundidadeCm = logProfundidadeCm;
	}

	public double getLogPesoKg() {
		return logPesoKg;
	}

	public void setLogPesoKg(double logPesoKg) {
		this.logPesoKg = logPesoKg;
	}

	public double getQtdEmbal() {
		return QtdEmbal;
	}

	public void setQtdEmbal(double qtdEmbal) {
		QtdEmbal = qtdEmbal;
	}

	public double getLogQtdLastro() {
		return LogQtdLastro;
	}

	public void setLogQtdLastro(double logQtdLastro) {
		LogQtdLastro = logQtdLastro;
	}

	public double getLogQtdCamadas() {
		return LogQtdCamadas;
	}

	public void setLogQtdCamadas(double logQtdCamadas) {
		LogQtdCamadas = logQtdCamadas;
	}

	public String getTributarioNcm() {
		return tributarioNcm;
	}

	public void setTributarioNcm(String tributarioNcm) {
		this.tributarioNcm = tributarioNcm;
	}

	public String getTributarioCest() {
		return tributarioCest;
	}

	public void setTributarioCest(String tributarioCest) {
		this.tributarioCest = tributarioCest;
	}

	public String getTributarioFiguraFiscal() {
		return tributarioFiguraFiscal;
	}

	public void setTributarioFiguraFiscal(String tributarioFiguraFiscal) {
		this.tributarioFiguraFiscal = tributarioFiguraFiscal;
	}

	public String getCodigoBeneficioFiscalIcms() {
		return CodigoBeneficioFiscalIcms;
	}

	public void setCodigoBeneficioFiscalIcms(String codigoBeneficioFiscalIcms) {
		CodigoBeneficioFiscalIcms = codigoBeneficioFiscalIcms;
	}

	public String getCodigoBeneficioFiscalPisCofins() {
		return CodigoBeneficioFiscalPisCofins;
	}

	public void setCodigoBeneficioFiscalPisCofins(String codigoBeneficioFiscalPisCofins) {
		CodigoBeneficioFiscalPisCofins = codigoBeneficioFiscalPisCofins;
	}

	public String getTribRegraDescricao() {
		return tribRegraDescricao;
	}

	public void setTribRegraDescricao(String tribRegraDescricao) {
		this.tribRegraDescricao = tribRegraDescricao;
	}

	public String getTribRegraUfOrigem() {
		return tribRegraUfOrigem;
	}

	public void setTribRegraUfOrigem(String tribRegraUfOrigem) {
		this.tribRegraUfOrigem = tribRegraUfOrigem;
	}

	public String getTribRegraPerfilOrigem() {
		return TribRegraPerfilOrigem;
	}

	public void setTribRegraPerfilOrigem(String tribRegraPerfilOrigem) {
		TribRegraPerfilOrigem = tribRegraPerfilOrigem;
	}

	public String getTribRegraCodPerfilOrigem() {
		return TribRegraCodPerfilOrigem;
	}

	public void setTribRegraCodPerfilOrigem(String tribRegraCodPerfilOrigem) {
		TribRegraCodPerfilOrigem = tribRegraCodPerfilOrigem;
	}

	public String getTribRegraUfDestino() {
		return tribRegraUfDestino;
	}

	public void setTribRegraUfDestino(String tribRegraUfDestino) {
		this.tribRegraUfDestino = tribRegraUfDestino;
	}

	public String getTribRegraPerfilDestino() {
		return TribRegraPerfilDestino;
	}

	public void setTribRegraPerfilDestino(String tribRegraPerfilDestino) {
		TribRegraPerfilDestino = tribRegraPerfilDestino;
	}

	public String getTribRegraCodPerfilDestino() {
		return TribRegraCodPerfilDestino;
	}

	public void setTribRegraCodPerfilDestino(String tribRegraCodPerfilDestino) {
		TribRegraCodPerfilDestino = tribRegraCodPerfilDestino;
	}

	public String getTribRegraCfop() {
		return tribRegraCfop;
	}

	public void setTribRegraCfop(String tribRegraCfop) {
		this.tribRegraCfop = tribRegraCfop;
	}

	public String getTribIcmsCst() {
		return tribIcmsCst;
	}

	public void setTribIcmsCst(String tribIcmsCst) {
		this.tribIcmsCst = tribIcmsCst;
	}

	public double getTribIcmsAliq() {
		return tribIcmsAliq;
	}

	public void setTribIcmsAliq(double tribIcmsAliq) {
		this.tribIcmsAliq = tribIcmsAliq;
	}

	public double getTribIcmsReducao() {
		return tribIcmsReducao;
	}

	public void setTribIcmsReducao(double tribIcmsReducao) {
		this.tribIcmsReducao = tribIcmsReducao;
	}

	public double getTribIcmsStAliq() {
		return tribIcmsStAliq;
	}

	public void setTribIcmsStAliq(double tribIcmsStAliq) {
		this.tribIcmsStAliq = tribIcmsStAliq;
	}

	public String getTribIcmsStPauta() {
		return tribIcmsStPauta;
	}

	public void setTribIcmsStPauta(String tribIcmsStPauta) {
		this.tribIcmsStPauta = tribIcmsStPauta;
	}

	public double getTribIcmsStMva() {
		return tribIcmsStMva;
	}

	public void setTribIcmsStMva(double tribIcmsStMva) {
		this.tribIcmsStMva = tribIcmsStMva;
	}

	public double getTribFcpAliq() {
		return tribFcpAliq;
	}

	public void setTribFcpAliq(double tribFcpAliq) {
		this.tribFcpAliq = tribFcpAliq;
	}

	public double getTribDifalAliq() {
		return tribDifalAliq;
	}

	public void setTribDifalAliq(double tribDifalAliq) {
		this.tribDifalAliq = tribDifalAliq;
	}

	public String getTribRegraPisCst() {
		return tribRegraPisCst;
	}

	public void setTribRegraPisCst(String tribRegraPisCst) {
		this.tribRegraPisCst = tribRegraPisCst;
	}

	public String getTribRegraPisCstE() {
		return tribRegraPisCstE;
	}

	public void setTribRegraPisCstE(String tribRegraPisCstE) {
		this.tribRegraPisCstE = tribRegraPisCstE;
	}

	public String getTribPisReducao() {
		return tribPisReducao;
	}

	public void setTribPisReducao(String tribPisReducao) {
		this.tribPisReducao = tribPisReducao;
	}

	public String getTribPisAliq() {
		return tribPisAliq;
	}

	public void setTribPisAliq(String tribPisAliq) {
		this.tribPisAliq = tribPisAliq;
	}

	public String getFisRegraCofinsCst() {
		return fisRegraCofinsCst;
	}

	public void setFisRegraCofinsCst(String fisRegraCofinsCst) {
		this.fisRegraCofinsCst = fisRegraCofinsCst;
	}

	public String getTribCofinsReducao() {
		return tribCofinsReducao;
	}

	public void setTribCofinsReducao(String tribCofinsReducao) {
		this.tribCofinsReducao = tribCofinsReducao;
	}

	public String getTribCofinAliq() {
		return tribCofinAliq;
	}

	public void setTribCofinAliq(String tribCofinAliq) {
		this.tribCofinAliq = tribCofinAliq;
	}

	public String getFisRegraValidadeInicio() {
		return fisRegraValidadeInicio;
	}

	public void setFisRegraValidadeInicio(String fisRegraValidadeInicio) {
		this.fisRegraValidadeInicio = fisRegraValidadeInicio.substring(0, 10);
	}

	public String getFisRegraValidadeFinal() {
		return fisRegraValidadeFinal;
	}

	public void setFisRegraValidadeFinal(String fisRegraValidadeFinal) {
		this.fisRegraValidadeFinal = fisRegraValidadeFinal.substring(0, 10);
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getDataatualizacao() {
		return dataatualizacao;
	}

	public void setDataatualizacao(String dataatualizacao) {
		this.dataatualizacao = dataatualizacao;
	}

	public String getResultadoConsulta() {
		return resultadoConsulta;
	}

	public void setResultadoConsulta(String resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}

	@Override
	public String toString() {
		return "Produto [Codigo=" + Codigo + ", EAN=" + EAN + ", produtoDescricao=" + produtoDescricao
				+ ", produtoDescricaoNota=" + produtoDescricaoNota + ", produtoDescricaoFornecedor="
				+ produtoDescricaoFornecedor + ", produtoDiasValidade=" + produtoDiasValidade
				+ ", embalagemUnitariaPesoBruto=" + embalagemUnitariaPesoBruto + ", embalagemUnitariaPesoLiquido="
				+ embalagemUnitariaPesoLiquido + ", embalagemUnitariaAltura=" + embalagemUnitariaAltura
				+ ", embalagemUnitariaLargura=" + embalagemUnitariaLargura + ", embalagemUnitariaProfundidade="
				+ embalagemUnitariaProfundidade + ", embalagemUnitariaId=" + embalagemUnitariaId
				+ ", embalagemUnitariaDescricao=" + embalagemUnitariaDescricao + ", embalagemUnitariaCapacidade="
				+ embalagemUnitariaCapacidade + ", embalagemUnitariaUnidadeMedida=" + embalagemUnitariaUnidadeMedida
				+ ", embalagemUnitariaUnidadeSigla=" + embalagemUnitariaUnidadeSigla + ", fabricanteId=" + fabricanteId
				+ ", fabricanteNome=" + fabricanteNome + ", fabricanteMarcaid=" + fabricanteMarcaid
				+ ", fabricanteMarcaDescricao=" + fabricanteMarcaDescricao + ", mercadologicaDepartamentoId="
				+ mercadologicaDepartamentoId + ", mercadologicaDepartamentoNome=" + mercadologicaDepartamentoNome
				+ ", mercadologicaSecaoId=" + mercadologicaSecaoId + ", mercadologicaSecaoNome="
				+ mercadologicaSecaoNome + ", mercadologicaGrupoId=" + mercadologicaGrupoId
				+ ", mercadologicaGrupoNome=" + mercadologicaGrupoNome + ", mercadologicaSubgrupoId="
				+ mercadologicaSubgrupoId + ", mercadologicaSubgrupoNome=" + mercadologicaSubgrupoNome + ", Ativo="
				+ Ativo + ", logEmbalagem=" + logEmbalagem + ", logDum14=" + logDum14 + ", logAlturaCm=" + logAlturaCm
				+ ", logLarguraCm=" + logLarguraCm + ", logProfundidadeCm=" + logProfundidadeCm + ", logPesoKg="
				+ logPesoKg + ", QtdEmbal=" + QtdEmbal + ", LogQtdLastro=" + LogQtdLastro + ", LogQtdCamadas="
				+ LogQtdCamadas + ", tributarioNcm=" + tributarioNcm + ", tributarioCest=" + tributarioCest
				+ ", tributarioFiguraFiscal=" + tributarioFiguraFiscal + ", CodigoBeneficioFiscalIcms="
				+ CodigoBeneficioFiscalIcms + ", CodigoBeneficioFiscalPisCofins=" + CodigoBeneficioFiscalPisCofins
				+ ", tribRegraDescricao=" + tribRegraDescricao + ", tribRegraUfOrigem=" + tribRegraUfOrigem
				+ ", TribRegraPerfilOrigem=" + TribRegraPerfilOrigem + ", TribRegraCodPerfilOrigem="
				+ TribRegraCodPerfilOrigem + ", tribRegraUfDestino=" + tribRegraUfDestino + ", TribRegraPerfilDestino="
				+ TribRegraPerfilDestino + ", TribRegraCodPerfilDestino=" + TribRegraCodPerfilDestino
				+ ", tribRegraCfop=" + tribRegraCfop + ", tribIcmsCst=" + tribIcmsCst + ", tribIcmsAliq=" + tribIcmsAliq
				+ ", tribIcmsReducao=" + tribIcmsReducao + ", tribIcmsStAliq=" + tribIcmsStAliq + ", tribIcmsStPauta="
				+ tribIcmsStPauta + ", tribIcmsStMva=" + tribIcmsStMva + ", tribFcpAliq=" + tribFcpAliq
				+ ", tribDifalAliq=" + tribDifalAliq + ", tribRegraPisCst=" + tribRegraPisCst + ", tribRegraPisCstE="
				+ tribRegraPisCstE + ", tribPisReducao=" + tribPisReducao + ", tribPisAliq=" + tribPisAliq
				+ ", fisRegraCofinsCst=" + fisRegraCofinsCst + ", tribCofinsReducao=" + tribCofinsReducao
				+ ", tribCofinAliq=" + tribCofinAliq + ", fisRegraValidadeInicio=" + fisRegraValidadeInicio
				+ ", fisRegraValidadeFinal=" + fisRegraValidadeFinal + ", id_produto=" + id_produto
				+ ", dataatualizacao=" + dataatualizacao + ", resultadoConsulta=" + resultadoConsulta + "]";
	}


}
