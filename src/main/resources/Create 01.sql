create schema metaassessoria;

CREATE TABLE IF NOT EXISTS metaassessoria.prod
(		EAN varchar(14) NOT NULL,
		Codigo integer not null,
	    produtoDescricao varchar(70),
	    produtoDescricaoNota varchar(70),
	    produtoDescricaoFornecedor varchar(70),
	    produtoDiasValidade varchar(10),
	    embalagemUnitariaPesoBruto numeric(18,2),
	    embalagemUnitariaPesoLiquido numeric(18,2),
	    embalagemUnitariaAltura numeric(18,2),
	    embalagemUnitariaLargura numeric(18,2),
	    embalagemUnitariaProfundidade numeric(18,2),
	    embalagemUnitariaId integer,
	    embalagemUnitariaDescricao varchar(20),
	    embalagemUnitariaCapacidade varchar(20),
	    embalagemUnitariaUnidadeMedida varchar(20),
	    embalagemUnitariaUnidadeSigla varchar(20),
	    fabricanteId integer,
	    fabricanteNome varchar(70),
	    fabricanteMarcaid integer,
	    fabricanteMarcaDescricao varchar(70),
	    mercadologicaDepartamentoId integer,
	    mercadologicaDepartamentoNome varchar(70),
	    mercadologicaSecaoId integer,
	    mercadologicaSecaoNome varchar(70),
	    mercadologicaGrupoId integer,
	    mercadologicaGrupoNome varchar(70),
	    mercadologicaSubgrupoId integer,
	    mercadologicaSubgrupoNome varchar(70),
	    Ativo integer,
	    logEmbalagem varchar(50),
	    logDum14 varchar(15),
	    logAlturaCm numeric(18,2),
	    logLarguraCm numeric(18,2),
	    logProfundidadeCm numeric(18,2),
	    logPesoKg numeric(18,2),
	    QtdEmbal numeric(18,2),
	    LogQtdLastro numeric(18,2),
	    LogQtdCamadas numeric(18,2),
	    tributarioNcm varchar(10),
	    tributarioCest varchar(50),
	    tributarioFiguraFiscal varchar(80),
	    CodigoBeneficioFiscalIcms varchar(70),
	    CodigoBeneficioFiscalPisCofins varchar(500),
	    tribRegraDescricao varchar(50),
	    tribRegraUfOrigem varchar(50),
	    TribRegraPerfilOrigem varchar(50),
	    TribRegraCodPerfilOrigem varchar(50),
	    tribRegraUfDestino varchar(50),
	    TribRegraPerfilDestino varchar(50),
	    TribRegraCodPerfilDestino varchar(50),
	    tribRegraCfop varchar(50),
	    tribIcmsCst varchar(50),
	    tribIcmsAliq numeric(18,2),
	    tribIcmsReducao numeric(18,2),
	    tribIcmsStAliq numeric(18,2),
	    tribIcmsStPauta varchar(50),
	    tribIcmsStMva numeric(18,2),
	    tribFcpAliq numeric(18,2),
	    tribDifalAliq numeric(18,2),
	    tribRegraPisCst varchar(3),
	    tribRegraPisCstE varchar(3),
	    tribPisReducao varchar(20),
	    tribPisAliq varchar(20),
	    fisRegraCofinsCst varchar(50),
	    tribCofinsReducao varchar(20),
	    tribCofinAliq varchar(20),
	    fisRegraValidadeInicio varchar(10),
	    fisRegraValidadeFinal varchar(10),
	    id_produto integer,
	    dataatualizacao varchar(30),
	    resultadoConsulta varchar(60),
	    CONSTRAINT recebimento_pkey PRIMARY KEY (EAN));
	   
	   
	   CREATE TABLE IF NOT EXISTS metaassessoria.log_prod(ean varchar(13),dataconsulta date, CONSTRAINT log_prod_pkey PRIMARY KEY (ean));
	   
--drop table metaassessoria.prod;
	   
INSERT INTO  metaassessoria.prod(EAN, Codigo, produtoDescricao, 
				produtoDescricaoNota, produtoDescricaoFornecedor, 
				produtoDiasValidade,	embalagemUnitariaPesoBruto,
				embalagemUnitariaPesoLiquido, embalagemUnitariaAltura,
				embalagemUnitariaLargura, embalagemUnitariaProfundidade,
				embalagemUnitariaId,	embalagemUnitariaDescricao,
				embalagemUnitariaCapacidade, embalagemUnitariaUnidadeMedida,
				embalagemUnitariaUnidadeSigla, fabricanteId,
				fabricanteNome,	fabricanteMarcaid, fabricanteMarcaDescricao,
				mercadologicaDepartamentoId, mercadologicaDepartamentoNome,
				mercadologicaSecaoId, mercadologicaSecaoNome,
				mercadologicaGrupoId, mercadologicaGrupoNome, 
				mercadologicaSubgrupoId,	mercadologicaSubgrupoNome,
				Ativo, logEmbalagem, logDum14, logAlturaCm,
				logLarguraCm, logProfundidadeCm, logPesoKg,	QtdEmbal,
				LogQtdLastro, LogQtdCamadas, tributarioNcm,	tributarioCest,
				tributarioFiguraFiscal,	CodigoBeneficioFiscalIcms,
				CodigoBeneficioFiscalPisCofins,	tribRegraDescricao,
				tribRegraUfOrigem, TribRegraPerfilOrigem, TribRegraCodPerfilOrigem,
				tribRegraUfDestino,	TribRegraPerfilDestino,	TribRegraCodPerfilDestino,
				tribRegraCfop, tribIcmsCst, tribIcmsAliq,tribIcmsReducao,
				tribIcmsStAliq,	tribIcmsStPauta, tribIcmsStMva, tribFcpAliq,
				tribDifalAliq, tribRegraPisCst, tribRegraPisCstE,
				tribPisReducao, tribPisAliq, fisRegraCofinsCst,	tribCofinsReducao,
				tribCofinAliq, fisRegraValidadeInicio, fisRegraValidadeFinal,
				id_produto, dataatualizacao,resultadoConsulta)
  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 
  		  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
  		  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
ON CONFLICT (EAN)
DO UPDATE SET
  	Codigo =  ?,	
	produtoDescricao =  ?,
	produtoDescricaoNota =  ?,
	produtoDescricaoFornecedor =  ?,
	produtoDiasValidade =  ?,
	embalagemUnitariaPesoBruto =  ?,
	embalagemUnitariaPesoLiquido =  ?,
	embalagemUnitariaAltura =  ?,
	embalagemUnitariaLargura =  ?,
	embalagemUnitariaProfundidade =  ?,
	embalagemUnitaria =  ?,
	embalagemUnitariaDescricao =  ?,
	embalagemUnitariaCapacidade =  ?,
	embalagemUnitariaUnidadeMedida =  ?,
	embalagemUnitariaUnidadeSigla =  ?,
	fabricanteId =  ?,
	fabricanteNome =  ?,
	fabricanteMarcaid =  ?,
	fabricanteMarcaDescricao =  ?,
	mercadologicaDepartamentoId =  ?,
	mercadologicaDepartamentoNome =  ?,
	mercadologicaSecaoId =  ?,
	mercadologicaSecaoNome =  ?,
	mercadologicaGrupoId =  ?,
	mercadologicaGrupoNome =  ?,
	mercadologicaSubgrupoId =  ?,
	mercadologicaSubgrupoNome =  ?,
	Ativo =  ?,
	logEmbalagem =  ?,
	logDum14 =  ?,
	logAlturaCm =  ?,
	logLarguraCm =  ?,
	logProfundidadeCm =  ?,
	logPesoKg =  ?,
	QtdEmbal =  ?,
	LogQtdLastro =  ?,
	LogQtdCamadas =  ?,
	tributarioNcm =  ?,
	tributarioCest =  ?,
	tributarioFiguraFiscal =  ?,
	CodigoBeneficioFiscalIcms =  ?,
	CodigoBeneficioFiscalPisCofins =  ?,
	tribRegraDescricao =  ?,
	tribRegraUfOrigem =  ?,
	TribRegraPerfilOrigem =  ?,
	TribRegraCodPerfilOrigem =  ?,
	tribRegraUfDestino =  ?,
	TribRegraPerfilDestino =  ?,
	TribRegraCodPerfilDestino =  ?,
	tribRegraCfop =  ?,
	ptribIcmsCst =  ?,
	tribIcmsAliq =  ?,
	tribIcmsReducao =  ?,
	tribIcmsStAliq =  ?,
	tribIcmsStPauta =  ?,
	tribIcmsStMva =  ?,
	tribFcpAliq =  ?,
	tribDifalAliq =  ?,
	tribRegraPisCst =  ?,
	tribRegraPisCstE =  ?,
	tribPisReducao =  ?,
	tribPisAliq =  ?,
	fisRegraCofinsCst =  ?,
	tribCofinsReducao =  ?,
	tribCofinAliq =  ?,
	fisRegraValidadeInicio =  ?,
	fisRegraValidadeFinal =  ?,
	id_produto =  ?,
	dataatualiza��o =  ?,
WHERE
  metaassessoria.prod.EAN = ?;
  
  -- drop table  metaassessoria.log_prod;

 