package util;

import java.util.HashMap;

public class TextosTela {
	
	private static int count = 0;
	public static final int INICIO = count++;
	public static final int PAG_INICIAL = count++;
	public static final int PROJETOS = count++;
	public static final int AGENDA = count++;
	public static final int CADASTRO_PROJETOS = count++;
	public static final int RELATORIOS = count++;
	public static final int AQUARIO = count++;
	public static final int SITUACAO_ATUAL = count++;
	public static final int FARG_FERNANDO_AUGUSTO = count++;
	public static final int CADASTRO_NOVO_PROJETO = count++;
	public static final int CADASTRO_AQUARIO_DADOS = count++;
	public static final int NOME = count++;
	public static final int DESCRICAO = count++;
	public static final int GRAVAR = count++;
	public static final int LIMPAR = count++;
	public static final int LISTA_PROJETOS_CADASTRADOS = count++;
	public static final int LISTA_AQUARIO = count++;
	public static final int ID = count++;
	public static final int ALTERAR = count++;
	public static final int EXCLUIR = count++;
	public static final int NENHUM_REGISTRO = count++;
	public static final int PRIMEIRA = count++;
	public static final int ANTERIOR = count++;
	public static final int PROXIMA = count++;
	public static final int ULTIMA = count++;
	public static final int TEMP_TAMPA = count++;
	public static final int TEMP_AMB = count++;
	public static final int TEMP_AGUA = count++;
	public static final int DATA = count++;
	public static final int HORA = count++;
	public static final int NIVEL_SUMP = count++;
	public static final int NIVEL_REPO = count++;
	public static final int LUZ = count++;
	
	private static HashMap<Integer,String> textosTela;
		
	public static String getTextItem(int i)
	{
		String temp = null;
		
		if(textosTela == null)
			init();
		
		temp = textosTela.get(new Integer(i));
		
		return temp;
	}
	
	private static void init()
	{
		textosTela = new HashMap<Integer, String>();
		
				
		textosTela.put(INICIO, "Início");
		textosTela.put(PAG_INICIAL, "Página inicial");
		textosTela.put(PROJETOS, "Projetos");
		textosTela.put(AGENDA, "Agenda");
		textosTela.put(CADASTRO_PROJETOS, "Cadastro de projetos");
		textosTela.put(RELATORIOS, "Relatórios");
		textosTela.put(AQUARIO, "Aquário");
		textosTela.put(SITUACAO_ATUAL, "Situação Atual");
		textosTela.put(FARG_FERNANDO_AUGUSTO, "FARG - Fernando Augusto R. Guimarães");
		textosTela.put(CADASTRO_NOVO_PROJETO,"Cadastro de novos projetos");
		textosTela.put(CADASTRO_AQUARIO_DADOS,"Cadastro Manual Dados Aquário");
		textosTela.put(NOME,"Nome");
		textosTela.put(DESCRICAO,"Descrição");
		textosTela.put(GRAVAR,"Gravar");
		textosTela.put(LIMPAR,"Limpar");
		textosTela.put(LISTA_PROJETOS_CADASTRADOS,"Lista de projetos cadastrados");
		textosTela.put(LISTA_AQUARIO,"Lista de parâmetros do aquário");
		textosTela.put(ID,"Id");
		textosTela.put(ALTERAR,"Alterar");
		textosTela.put(EXCLUIR,"Excluir");
		textosTela.put(NENHUM_REGISTRO,"Nenhum registro foi encontrado");
		textosTela.put(PRIMEIRA,"Primeira");
		textosTela.put(ANTERIOR,"Anterior");
		textosTela.put(PROXIMA,"Próxima");
		textosTela.put(ULTIMA,"Última");
		
		textosTela.put(TEMP_TAMPA,"Tampa");
		textosTela.put(TEMP_AMB,"Amb.");
		textosTela.put(TEMP_AGUA,"Água");
		textosTela.put(DATA,"Data");
		textosTela.put(HORA,"Hora");
		textosTela.put(NIVEL_SUMP,"Niv.Sump");
		textosTela.put(NIVEL_REPO,"Niv.Repo");
		textosTela.put(LUZ,"Luz");
		
	}
	
	

}
