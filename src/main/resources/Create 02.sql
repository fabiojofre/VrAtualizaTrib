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
	   
--	drop view METAASSESORIAPROD;
	   
create or replace view METAASSESORIAPROD as 	   
select 
	p.id,
	cast(pa.codigobarras as text)codigobarras,
	p.descricaocompleta,
	lpad(cast(p.ncm1 as text),4,'0') ||lpad(cast(p.ncm2 as text),2,'0')|| lpad(cast(p.ncm3 as text),2,'0') as ncm_old,
	mp.tributarioncm as ncm_novo,
	cast(substring(mp.tributarioncm from 1 for 4)as integer)ncm1_novo,
	cast(substring(mp.tributarioncm from 5 for 2)as integer)ncm2_novo,
	cast(substring(mp.tributarioncm from 7 for 2)as integer)ncm3_novo,
	p.id_cest id_cest_old,
	lpad(cast(c.cest1 as text),2,'0')||lpad(cast(c.cest2 as text),3,'0')||lpad(cast(c.cest3 as text),2,'0')cest_old,
	(select id  from cest c where mp.tributariocest= lpad(cast(c.cest1 as text),2,'0')||lpad(cast(c.cest2 as text),3,'0')||lpad(cast(c.cest3 as text),2,'0'))id_cest_novo, 
	mp.tributariocest cest_novo,
	(select id from codigobeneficiocst c where c.codigo = substring(mp.codigobeneficiofiscalicms from 1 for 8))id_beneficio_novo,
	case mp.codigobeneficiofiscalicms when ' N/A-NAO APLICAVEL' then ''
	else substring(mp.codigobeneficiofiscalicms from 1 for 8) end codigo_beneficio_novo,
	(select pab.id from produtoaliquotabeneficio pab left join codigobeneficiocst c on pab.id_beneficio = c.id  where  pab.id_produtoaliquota  = (select id from produtoaliquota where id_produto = p.id and id_estado =43))id_produto_aliquota_beneficio,
	(select pab.id_beneficio from produtoaliquotabeneficio pab left join codigobeneficiocst c on pab.id_beneficio = c.id  where  pab.id_produtoaliquota  = (select id from produtoaliquota where id_produto = p.id and id_estado =43))id_beneficio_old,
	(select c.codigo from produtoaliquotabeneficio pab left join codigobeneficiocst c on pab.id_beneficio = c.id  where  pab.id_produtoaliquota  = (select id from produtoaliquota where id_produto = p.id and id_estado =43))codigo_beneficio_old,
	(select id from produtoaliquota where id_produto = p.id and id_estado = 43) as id_produtoaliquota,
	(select aliquota.id from produtoaliquota left join aliquota on produtoaliquota.id_aliquotadebito = aliquota.id where id_produto = p.id and id_estado = 43) id_tribvenda,
	(select aliquota.descricao from produtoaliquota left join aliquota on produtoaliquota.id_aliquotadebito = aliquota.id where id_produto = p.id and id_estado = 43) desc_tribvenda,
	(select id from aliquota where aliquota.reduzido = mp.tribicmsreducao and porcentagem = mp.tribicmsaliq and situacaotributaria = cast(mp.tribicmscst as integer)limit 1) as id_tribvenda_novo,
	(select descricao from aliquota where aliquota.reduzido = mp.tribicmsreducao and porcentagem = mp.tribicmsaliq and situacaotributaria = cast(mp.tribicmscst as integer)limit 1) as desc_tribvenda_novo,
	mp.tribicmscst ||' -  icms:'||mp.tribicmsaliq ||'% - Reducao:'||mp.tribicmsreducao ||' - FCP:'||mp.tribfcpaliq trib_a_cadastrar,
	cast(mp.tribregrapiscst as integer) piscofinsdebito_novo,
	tpc.id id_pis_debito_novo,
	cast(mp.tribregrapiscste as integer) piscofinscredito_novo,
	tpce.id id_pis_credito_novo,
	tpc.descricao ||' / '||tpce.descricao descricao_pis_novo,
	tv.cst pis_debito_old,
	t.cst pis_credito_old,
	tv.descricao ||' / '||t.descricao descricao_pis_old 
	from metaassessoria.prod mp
join produtoautomacao pa on cast(mp.ean as numeric) = pa.codigobarras
left join produto p on pa.id_produto = p.id 
left join tipopiscofins tpc on cast(mp.tribregrapiscst as integer) = tpc.cst 
left join tipopiscofins tpce on cast(mp.tribregrapiscste as integer) = tpce.cst 
join tipopiscofins tv on p.id_tipopiscofins = tv.id
join tipopiscofins t on p.id_tipopiscofinscredito = t.id
left join cest c on p.id_cest = c.id;



select * from METAASSESORIAPROD where METAASSESORIAPROD.CODIGOBARRAS = '78933149'


select id_tipopiscofins, id_tipopiscofinscredito from produto where id =19978
update produto set ncm1 = ?, ncm2 = ? ncm3 = ? where id = ?

select id_ces from produto p 

update produto set id_cest = ? where id= ?

update produto set id_tipopiscofins = ?, id_tipopiscofinscredito = ? where id = ?

select * from produtoaliquota  where id = 22772

update produtoaliquota set id_aliquotadebito =?, id_aliquotaconsumidor = ? where id =?

select * from produtoaliquotabeneficio p where id_produtoaliquota = 22776

update produtoaliquotabeneficio set id id_aliquota =?, id_beneficio = ? where id_produtoaliquota = ?

select * from metaassessoria.prod p 

insert into produtoaliquotabeneficio(id_produtoaliquota, id_aliquota,id_beneficio)values(22776,36,394)

select * from produtoaliquotabeneficio where id>=31004
