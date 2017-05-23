package util;


/**
 * Classe para criação de mensagens em geral.
 *
 * @author gabriel Borges
 */
public class MessageUtil {

	/* Securiry */
	public static final String FALHA_PERMISSAO = "Você não possui permissão para acessar este recurso";

	/* SCHEMA */
	
	public static final String FIP_SCHEMA = "MBRS_TEST";
	//public static final String FIP_SCHEMA = "MBRS";
	public static final String MBPU_SCHEMA = "MBPU";
	public static final String MBGT_SCHEMA = "MBGT";


	/* Exceptions */
	public static final String INCONFORMIDADE_GENERICA = "Houve um problema no servidor. Contate o administrador do sistema.";
	public static final String ERRO_INTERNO_PLATAFORMA = "Erro interno no servidor / plataforma de desenvolvimento. [%s]";
	public static final String SESSAO_EXPIROU = "Sessão Expirou.";


	/* Geral */
	public static final String CADASTRO_REALIZADA_SUCESSO = "Cadastro %s realizada com sucesso.";
	public static final String CONSULTA_REALIZADA_SUCESSO_S = "Consulta %s realizada com sucesso.";
	public static final String CONSULTA_REALIZADA_SUCESSO = "Consulta realizada com sucesso.";
	public static final String CONSULTA_REALIZADA_VAZIA = "Consulta Vazia.";
	public static final String CONSULTA_REALIZADA_ERRO = "Falha ao realizar consulta.";
	public static final String CONSULTA_REALIZADA_ERRO_S = "Falha na consulta %s ao realizar consulta.";
	public static final String CADASTRO_REALIZADO_ERRO = "Falha ao realizar cadastro.";
	public static final String CADASTRO_REALIZADO_ERRO_S = "Falha no %s  ao realizar cadastro.";
	public static final String PARAMETRO_INVALIDO = "Parametro %s não pode ser nulo.";


	/* ControllerUtil */
	public static final String USUARIO_CACHE_ERRO = "Nenhum usuário na cache.";


	/* Controllers */
	public static final String BAD_REQUEST_PARAM = "Bad Request! Parametro %s não pode ser nulo.";


	/* StartController */
	public static final String ID_EMPREENDEDOR_ERROR = "Empreendedor na tabela de prefeitura não foi setado.";

	/* PrefeituraController */
	public static final String PREFEITURA_COM_MAIS_DE_QUATRO_EMPREENDIMENTOS = "Prefeitura com mais de quatro empreendimentos vinculados.";

	/* Bean Validation */
	public static final String PESSOA_EMPREENDEDOR_ERROR = "Esta prefeitura não está cadastrada como empreendedor no Portal de Segurança";


	/* PgirsController */
	public static final String PGIRS_CADASTRADO_SUCESSO = "PGIRS criado com sucesso.";
	public static final String PGIRS_CADASTRAR_FALHA = "Falha ao criar PGIRS.";
	public static final String PGIRS_CONSULTA_SUCESSO = "PGIRS consultado com sucesso.";
	public static final String FALHA_ATUALIZAR_ETAPA = "Falha ao atualizar etapa do PGIRS";
	public static final String PGIRS_PASSO1_SUCESSO = "Passo 1 concluído com sucesso.";
	public static final String PGIRS_PASSO2_SUCESSO = "Passo 2 concluído com sucesso.";
	public static final String PGIRS_PASSO3_SUCESSO = "Passo 3 concluído com sucesso.";
	public static final String PGIRS_PASSO4_SUCESSO = "Passo 4 concluído com sucesso.";
	public static final String PGIRS_PASSO5_SUCESSO = "Passo 5 concluído com sucesso.";
	public static final String PGIRS_PASSO6_SUCESSO = "Passo 6 concluído com sucesso.";
	public static final String PGIRS_PASSO7_SUCESSO = "Passo 7 concluído com sucesso.";
	public static final String PGIRS_PASSO7_ERRO = "Falha ao salvar passo 7, verifique os dados informados";
	public static final String PGIRS_PASSO6_ERRO = "Falha ao salvar passo 6, verifique os dados informados";
	public static final String GET_CONSORCIO_PASSO6_ERRO = "Falha ao recuperar consórcio do passo 6.";
	public static final String PGIRS_NAO_ENCONTRADO = "PGIRS não encontrado.";
	public static final String PREFEITURA_POSSUI_PGIRS_ANO_ATUAL = "A prefeitura em questão já possui PGIRS cadastrado para o ano base atual.";
	public static final String GERADOR_CADASTRADO_SUCESSO = "Gerador cadastrado com sucesso";
	public static final String GERADOR_CADASTRO_ERRO = "Falha ao cadastrar gerador.";
	public static final String GERADOR_EXLUIDO_SUCESSO = "Gerador excluído com sucesso";
	public static final String GERADOR_EXLUIDO_ERROR = "Falha ao excluir o gerador.";
	public static final String TABELA_CARACTERISTICA_FAVORAVEl_VAZIA = "FATAL ERROR - Tabela bas_caracteristica_favoravel não pode estar vazia.";
	public static final String ATO_NAO_ENCONTRADO = "Ato do município não encontrado.";
	public static final String PLANO_NAO_ENCONTRADO = "Plano do PGIRS não encontrado.";
	public static final String LISTAR_NEGOCIO_EMPREGO_RENDA_FALHA = "Falha ao listar ações de negócio, emprego e renda.";
	public static final String CADASTRO_NEGOCIO_EMPREGO_RENDA_SUCESSO = "Ação de negócio, emprego e renda cadastrado com sucesso.";
	public static final String CADASTRAR_NEGOCIO_EMPREGO_RENDA_FALHA = "Falha ao cadastrar ações de negócio, emprego e renda.";
	public static final String EXCLUIR_NEGOCIO_EMPREGO_RENDA_FALHA = "Falha ao excluir ações de negócio, emprego e renda.";
	public static final String EXCLUIR_NEGOCIO_EMPREGO_RENDA_SUCESSO = "Ação de negócio, emprego e renda excluído com sucesso.";
	public static final String LISTAR_ORGANIZACOES_CATADORES_ERRO = "Falha ao listar organizacões de catadores.";
	public static final String SALVAR_ORGANIZACAO_CATADORES_SUCESSO = "Organização de catadores cadastrado com sucesso.";
	public static final String SALVAR_ORGANIZACAO_CATADORES_ERRO = "Falha ao salvar organizacão de catadores.";
	public static final String EXCLUIR_ORGANIZACAO_CATADORES_SUCESSO = "Organização de catadores excluída com sucesso.";
	public static final String EXCLUIR_ORGANIZACAO_CATADORES_ERRO = "Falha ao excluir organizacão de catadores.";
	public static final String PGIRS_PASSO8_SUCESSO = "Passo 8 concluído com sucesso.";
	public static final String PGIRS_PASSO8_ERRO = "Falha ao salvar passo 8, verifique os dados informados";
	public static final String PGIRS_PASSO10_SUCESSO = "Passo 10 concluído com sucesso.";
	public static final String PGIRS_PASSO10_ERRO = "Falha ao salvar passo 10, verifique os dados informados";
	public static final String PGIRS_PASSO9_SUCESSO = "Passo 9 concluído com sucesso.";
	public static final String PGIRS_PASSO9_ERRO = "Falha ao salvar passo 9, verifique os dados informados";
	public static final String LISTAR_METAS_PGIRS_FALHA = "Falha ao listar metas.";
	public static final String FALHA_CADASTRAR_META = "Falha ao cadastrar meta.";
	public static final String CADASTRAR_META_SUCESSO = "Meta cadastrada com sucesso.";
	public static final String EXCLUIR_META_SUCESSO = "Meta excluída com sucesso.";
	public static final String FALHA_EXCLUIR_META = "Falha ao excluir meta.";
	public static final String CADASTRAR_PARTICIPACAO_PODER_PUBLICO_SUCESSO = "Participação do poder público cadastrado com sucesso.";
	public static final String FALHA_CADASTRAR_PARTICIPACAO_PODER_PUBLICO = "Falha ao cadastrar Participação do poder público.";
	public static final String LISTAR_PARTICIPACAO_PODER_PUBLICO_FALHA = "Falha ao listar Participação do poder público.";
	public static final String EXCLUIR_PARTICIPACAO_PODER_PUBLICO_SUCESSO = "Participação do poder público excluída com sucesso.";
	public static final String FALHA_EXCLUIR_PARTICIPACAO_PODER_PUBLICO = "Falha ao excluir Participação do poder público.";
	public static final String FALHA_CADASTRAR_CONTROLE_FISCALIZACAO = "Falha ao cadastrar Controle de Fiscalizacao.";
	public static final String CADASTRAR_CONTROLE_FISCALIZACAO_SUCESSO = "Controle de Fiscalização cadastrado com sucesso.";
	public static final String FALHA_CONSULTAR_PASSO9 = "Falha ao consultar dados de Custo de Prestação de Serviço do PGIRS.";
	public static final String EXCLUIR_CONTROLE_FISCALIZACAO_SUCESSO = "Controle de Fiscalização excluído com sucesso.";
	public static final String FALHA_EXCLUIR_CONTROLE_FISCALIZACAO = "Falha ao excluir Controle de Fiscalizacao.";
	public static final String CADASTRAR_AREA_INADEQUADA_SUCESSO = "Área Inadequada cadastrado com sucesso.";
	public static final String FALHA_CADASTRAR_AREA_INADEQUADA = "Falha ao cadastrar Área Inadequada.";
	public static final String EXCLUIR_AREA_INADEQUADA_SUCESSO = "Área Inadequada excluído com sucesso.";
	public static final String FALHA_EXCLUIR_AREA_INADEQUADA = "Falha ao excluir Área Inadequada.";
	public static final String CADASTRAR_RESPONSAVEL_IMPLANTACAO_SUCESSO = "Responsável Implantação cadastrado com sucesso.";
	public static final String FALHA_CADASTRAR_RESPONSAVEL_IMPLANTACAO = "Falha ao cadastrar Responsável Implantação.";
	public static final String EXCLUIR_RESPONSAVEL_IMPLANTACAO_SUCESSO = "Responsável Implantação excluído com sucesso.";
	public static final String FALHA_EXCLUIR_RESPONSAVEL_IMPLANTACAO = "Falha ao excluir Responsável Implantação.";
	public static final String FINALIZAR_PGIRS_FALHA = "Falha ao finalizar PGIRS.";
	public static final String FINALIZAR_PGIRS_SUCESSO = "PGIRS finalizado com sucesso.";


	/* Lista Generica */
	public static final String LISTA_CONSULTADA_SUCESSO = "Lista de %s retornada com sucesso.";


	/* GestaoVinculoController */
	public static final String CNPJ_PREFEITURA_ERRO = "O CNPJ informado não é de uma prefeitura.";
	public static final String CNPJ_PREFEITURA_SUCESSO = "O CNPJ informado é de uma prefeitura.";
	public static final String PREFEITO_FIP = "Você já está vinculado como prefeito no sistema e não poderar se vincular de novo.";
	public static final String PREFEITO_PREFEITURA_ERRO = "Você não é prefeito desta prefeitura portanto não pode vincular-se a ela.";
	public static final String VINCULAR_PREFEITO_PREFEITURA_ERRO = "Erro ao vincular prefeito a prefeitura.";
	public static final String VINCULAR_PREFEITO_PREFEITURA_SUCESSO = "Prefeito vinculado a prefeitura com sucesso.";
	public static final String CASDASTRO_PREFEITURA_MBPU_ERRO = "Prefeitura informada deve se cadastrar no portal de segurança da PRODEMGE antes de se vincular ao sistema.";
	public static final String DESVINCULAR_REPRESENTANTE_ERRO = "No momento o representante não pode ser desvinculado, tente mais tarde.";
	public static final String DESVINCULAR_REPRESENTANTE_SUCESSO = "Representante foi desvinculado com sucesso.";
	public static final String CPF_MBPU_ERRO = "O CPF informado, não é um CPF de uma pessoa.";
	public static final String ADD_REPRESENTANTES_SUCESSO = "Representante adicionado com sucesso.";
	public static final String ADD_REPRESENTANTES_ERRO = "Falha ao adicionar representante.";
	public static final String MODULOS_VINCULACAO_WARNING = "Todos os Módulos já foram vinculados.";


	/* Responsável Técnico */
	public static final String RESPONSAVEL_TECNICO_NULO = "Responsável técnico não pode ser nulo.";
	public static final String FALHA_CADASTRAR_RESPONSAVEL_TECNICO = "Falha ao cadastrar responsável técnico.";


	/* Diagnóstico */
	public static final String DIAGNOSTICO_CADASTRADO_SUCESSO = "Tipo  de Resíduo cadastrado com sucesso.";
	public static final String DIAGNOSTICO_EXCLUIDO_SUCESSO = "Diagnóstico(s) excluído(s) com sucesso.";
	public static final String DIANOSTICO_FALHA_LISTAR = "Falha ao consultar diagnosticos.";

	/* Porte cidade */
	public static final String PORTE_CADASTRADO_SUCESSO = "Porte da cidade cadastrado com sucesso.";
	public static final String PORTE_CADASTRADO_ERRO = "Falha ao cadastrar porte da cidade.";


	/* Área Favorável */
	public static final String AREA_FAVORAVEL_CADASTRADA_SUCESSO = "Área favorável cadastrada com sucesso.";
	public static final String AREA_FAVORAVEL_CADASTRAR_ERRO = "Erro ao cadastrar Área favorável.";
	public static final String AREA_FAVORAVEL_EXCLUIDA_SUCESSO = "Área favorável excluída com sucesso.";
	public static final String AREA_FAVORAVEL_EXCLUIDA_ERRO = "Falha ao excluir Área favorável.";

	/* Prefeitura */
	public static final String USUARIO_PREFEITURA_ERRO = "ERRO FATAL - Não existem prefeituras vinculadas ao usuário logado.";

	/* TipoResiduoController */
	public static final String TABELA_TIPO_RESIDUO_VAZIA = "FATAL ERROR - Tabela bas_tipo_residuo não pode estar vazia.";

	/* MunicipioController */
	public static final String TABELA_MUNICIPIO_SIMPLIFICADO_VAZIA = "FATAL ERROR - Tabela tx_municipio_simplificado não pode estar vazia.";


	/* Indicador Desempenho Passo 7 */
	public static final String INDICADOR_DESEMPENHO_CADASTRADO_SUCESSO = "Indicador Desempenho cadastrado com sucesso.";
	public static final String INDICADOR_DESEMPENHO_CADASTRADO_ERRO = "Erro ao cadastrar Indicador Desempenho.";
	public static final String INDICADOR_DESEMPENHO_EXCLUIDO_SUCESSO = "Indicador Desempenho excluída com sucesso.";
	public static final String INDICADOR_DESEMPENHO_EXCLUIDO_ERRO = "Falha ao excluir Indicador Desempenho.";
	public static final String PROGRAMA_EDUCACIONAL_CADASTRADO_SUCESSO = "Programa Educacional cadastrado com sucesso.";
	public static final String PROGRAMA_EDUCACIONAL_CADASTRADO_ERRO = "Erro ao cadastrar Programa Educacional.";
	public static final String PROGRAMA_EDUCACIONAL_EXCLUIDO_SUCESSO = "Programa Educacional excluída com sucesso.";
	public static final String PROGRAMA_EDUCACIONAL_EXCLUIDO_ERRO = "Falha ao excluir Programa Educacional.";

	//#######################################################################################################################################

	/* ColetaSeletivaModel */
	public static final String PREFEITURA_POSSUI_COLETA_ANO_ATUAL = "Prefeitura já possui Coleta Seletiva para o ano base atual";
	public static final String COLETA_CADASTRAR_FALHA = "Falha ao criar Coleta Seletiva.";
	public static final String COLETA_CADASTRADA_SUCESSO = "Coleta Seletiva criada com sucesso.";


	/* ColetaSeletiva - PassoUmController */
	public static final String CADASTRAR_GESTOR_SUCESSO = "Gestor cadastrado com sucesso.";
	public static final String CADASTRAR_GESTOR_ERRO = "Falha ao cadastradar gestor.";
	public static final String CADASTRAR_PASSO_UM_SUCESSO = "Passo um cadastrado com sucesso.";
	public static final String CADASTRAR_PASSO_UM_FALHA = "Falha ao cadastrar passo um.";
	public static final String EXCLUIR_GESTOR = "Gestor excluído com sucesso.";
	public static final String FALHA_EXCLUIR_GESTOR = "Falha ao excluir gestor.";
	public static final String CADASTRAR_RESPONSAVEL_SUCESSO = "Responsável cadastrado com sucesso.";
	public static final String CADASTRAR_RESPONSAVEL_ERRO = "Falha ao cadastradar responsável.";
	public static final String EXCLUIR_RESPONSAVEL = "Responsável excluído com sucesso.";
	public static final String FALHA_EXCLUIR_RESPONSAVEL = "Falha ao excluir responsável.";


	/* ColetaSeletiva - PassoDoisController */
	public static final String CADASTRAR_PASSO_DOIS_SUCESSO = "Passo dois cadastrado com sucesso.";
	public static final String CADASTRAR_PASSO_DOIS_FALHA = "Falha ao cadastrar passo dois.";

	/* ColetaSeletiva - PassoTresController */
	public static final String CADASTRAR_PASSO_TRES_SUCESSO = "Passo três cadastrado com sucesso.";
	public static final String CADASTRAR_PASSO_TRES_FALHA = "Falha ao cadastrar passo três.";
	public static final String CADASTRAR_CATADOR_SUCESSO = "Organização de catadores cadastrada com sucesso";
	public static final String CADASTRAR_CATADOR_ERRO = "Falha ao cadastradar catador.";
	public static final String EXCLUIR_CATADOR_SUCESSO = "Catador excluído com sucesso.";
	public static final String FALHA_EXCLUIR_CATADOR = "Falha ao excluir catador.";
	public static final String CADASTRAR_ACAO_SUCESSO = "Ação cadastrada com sucesso.";
	public static final String CADASTRAR_ACAO_ERRO = "Falha ao cadastradar ação.";
	public static final String EXCLUIR_ACAO_SUCESSO = "Ação excluída com sucesso.";
	public static final String FALHA_EXCLUIR_ACAO = "Falha ao excluir ação.";


	/* ColetaSeletiva - PassoQuatroController */
	public static final String CADASTRAR_PASSO_QUATRO_SUCESSO = "Passo quatro cadastrado com sucesso.";
	public static final String CADASTRAR_PASSO_QUATRO_FALHA = "Falha ao cadastrar passo quatro.";

	/* ColetaSeletiva - PassoCincoController */
	public static final String CADASTRAR_INDICADOR_SUCESSO = "Indicador cadastrado com sucesso.";
	public static final String CADASTRAR_INDICADOR_ERRO = "Falha ao cadastradar indicador.";
	public static final String CADASTRAR_PASSO_CINCO_SUCESSO = "Passo cinco cadastrado com sucesso.";
	public static final String CADASTRAR_PASSO_CINCO_FALHA = "Falha ao cadastrar passo cinco.";
	public static final String EXCLUIR_INDICADOR_SUCESSO = "Indicador excluído com sucesso.";
	public static final String FALHA_EXCLUIR_INDICADOR = "Falha ao excluir indicador.";

	/* ColetaSeletiva - PassoSeisController */
	public static final String CADASTRAR_PASSO_SEIS_SUCESSO = "Passo seis cadastrado com sucesso.";
	public static final String CADASTRAR_PASSO_SEIS_FALHA = "Falha ao cadastrar passo seis.";

	/* ICMS Ecologico */
	public static final String FINALIZAR_ICMS_FALHA = "Falha ao finalizar ICMS.";
	public static final String FINALIZAR_ICMS_SUCESSO = "ICMS finalizado com sucesso.";

	/* AreaEncerrada  */
	public static final String AREA_CADASTRADA_SUCESSO = "Area Encerrada criada com sucesso.";
	public static final String GET_AREA_CADASTRADA_ERRO = "Erro ao retornar a Área Encerrada.";

	public static final String AREA_ENCERRADA_ERRO_FINALIZAR = "Falha ao finalizar Área Encerrada.";
	public static final String AREA_ENCERRADA_SUCESSO_FINALIZAR = "Área Encerrada finalizada com sucesso.";

	/*Informaçao Adicional*/
	public static final String CADASTRO_INFORMACAO_ADICIONAL_SUCESSO = "Informação adicional cadastrada com sucesso.";
	public static final String CADASTRO_INFORMACAO_ADICIONAL_ERRO = "Falha ao cadastrar informação adicional.";
	public static final String EXCLUIR_INFORMACAO_ADICIONAL_SUCESSO = "Informação adicional removida com sucesso.";
	public static final String EXCLUIR_INFORMACAO_ADICIONAL_ERRO = "Falha ao excluir informação adicional.";

	/* EteController */
	public static final String ETE_CADASTRO_SUCESSO =  "ETE cadastrada com sucesso.";
	public static final String PASSO1_ETE_CADASTRO_SUCESSO =  "As alterações da ETE foram salvas com sucesso.";
	public static final String ETE_CADASTRO_FALHA =  "Falha ao cadastradar ETE.";

	/* AutoMonitoramento */
	public static final String AUTO_MONITORAMENTO_EXCLUIDO_SUCESSO = "Ponto monitorado excluído com sucesso.";
	public static final String AUTO_MONITORAMENTO_EXCLUIDO_ERRO = "Falha ao excluir ponto monitorado.";
	public static final String PONTO_MONITORAMENTO_SALVAR_SUCESSO = "Ponto(s) de monitoramentos salvos com sucesso!";
	public static final String PONTO_MONITORAMENTO_SALVAR_ERRO = "Erro ao salvar ponto(s) de monitoramento(s)!";

	/* Gerenciamento de arquivos */
	public static final String ARQUIVO_ERRO_DOWNLOAD = "Não foi possível efetuar o download do arquivo!";

}
