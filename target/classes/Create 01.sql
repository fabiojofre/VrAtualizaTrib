create schema metaassessoria;

CREATE TABLE IF NOT EXISTS metaassessoria.prod
(		EAN varchar(14) NOT NULL,
		Codigo integer not null,
	    produtoDescricao varchar(70),
	    produtoDescricaoNota varchar(70),
	    produtoDescricaoFornecedor varchar(70),
	    produtoDiasValidade varchar(10),
	    embalagemUnitariaPesoBruto varchar(10),
	    embalagemUnitariaPesoLiquido varchar(10),
	    embalagemUnitariaAltura varchar(10),
	    embalagemUnitariaLargura varchar(10),
	    embalagemUnitariaProfundidade varchar(10),
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
	   
	   
	   
select 
	p.id,
	pa.codigobarras,
	p.descricaocompleta,
	(p.ncm1 ||''|| p.ncm2 ||''|| p.ncm3) as ncm_old,
	mp.tributarioncm as ncm_novo,
	cast(substring(mp.tributarioncm from 1 for 4)as integer)ncm1_novo,
	cast(substring(mp.tributarioncm from 5 for 2)as integer)ncm2_novo,
	cast(substring(mp.tributarioncm from 7 for 2)as integer)ncm3_novo,
	p.id_cest id_cest_old,
	(c.cest1 ||''||c.cest2||''||c.cest3)cest_old,
	mp.tributariocest cest_novo,
	(select id from cest where (cest.cest1||''||cest.cest2 ||''||cest.cest3) = 
	cast(substring(mp.tributariocest from 1 for 2)as integer)||''||
	cast(substring(mp.tributariocest from 3 for 3)as integer)||''||
	cast(substring(mp.tributariocest from 6 for 2)as integer)limit 1)id_cest_novo, 
	substring(mp.codigobeneficiofiscalicms from 1 for 8)cod_benificio_novo,
	mp.codigobeneficiofiscalpiscofins,
	mp.tribregradescricao,
	(select id from produtoaliquota where id_produto = 10672 and id_estado = 43) as id_trib,
	(select aliquota.descricao from produtoaliquota join aliquota on produtoaliquota.id_aliquotacredito = aliquota.id where id_produto = p.id and id_estado = 43) desc_tribcompra,
	(select aliquota.descricao from produtoaliquota join aliquota on produtoaliquota.id_aliquotadebito = aliquota.id where id_produto = p.id and id_estado = 43) desc_tribvenda,
	(select id from aliquota where aliquota.reduzido = mp.tribicmsreducao and porcentagem = mp.tribicmsaliq and situacaotributaria = cast(mp.tribicmscst as integer)limit 1) as id_tribvenda_novo,
	(select descricao from aliquota where aliquota.reduzido = mp.tribicmsreducao and porcentagem = mp.tribicmsaliq and situacaotributaria = cast(mp.tribicmscst as integer)limit 1) as desc_tribvenda_novo
	from metaassessoria.prod mp
join produtoautomacao pa on cast(mp.ean as numeric) = pa.codigobarras
join produto p on pa.id_produto = p.id 
left join cest c on p.id_cest = c.id 
where cast(mp.ean as numeric) = 7896259411956
 

select * from tiponaturezareceita t order by 2

select * from cfop c order by 1

select * from ncm where ncm1 =1806 and ncm2 = 90 and ncm3 = 00

select * from produto p order by 1 desc limit 1 
	   
select * from cest	where  cest1 = 17 and cest2 = 9 and cest3 =0

select ncm1,ncm2,ncm3 from produto where id = 10672
	   
	   
	   
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
	dataatualização =  ?,
WHERE
  metaassessoria.prod.EAN = ?;
  
  -- drop table  metaassessoria.log_prod;

 