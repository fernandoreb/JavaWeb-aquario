package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.BeanFactory;
import util.TextosTela;

import dao.ProjetoDAO;

import entidade.Projeto;


@ManagedBean(name="projetosController")
@ViewScoped
public class ProjetosController {

	private Projeto projeto = new Projeto();
	private List<Projeto> listaProjeto = new ArrayList<Projeto>();	
	private ProjetoDAO projetoDAO = (ProjetoDAO) BeanFactory.getBean("projetoDAO", ProjetoDAO.class);
	
	public ProjetosController(){
		atualizarTela();
	}

	/**
	 * Limpa os campos input e atualiza a lista de usuários cadastrados
	 */
	private void atualizarTela() {
		projeto = new Projeto();
		listaProjeto = projetoDAO.buscarTodos();
	}

	/**
	 * Grava novo registro ou atualiza um registro
	 */
	public void gravar(){
		projetoDAO.gravar(getProjeto());
		atualizarTela();
	}
	
	/**
	 * Exclui um registro da tabela projeto
	 */
	public void excluir(){
		projetoDAO.excluir(getProjeto());
		atualizarTela();
	}
	
	public List<Projeto> getListaProjetos() {
		return listaProjeto;
	}
		 
	public void setListaProjetos(List<Projeto> listaProjeto) {
		this.listaProjeto = listaProjeto;
	}
		 
	public Projeto getProjeto() {
		return projeto;
	}
		 
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public String getPainelCadastroTitulo()
	{	
		return TextosTela.getTextItem(TextosTela.CADASTRO_NOVO_PROJETO);
	}
	
	public String getPainelCadastroNome()
	{	
		return TextosTela.getTextItem(TextosTela.NOME);
	}
	
	public String getPainelCadastroDescricao()
	{	
		return TextosTela.getTextItem(TextosTela.DESCRICAO);
	}
	
	public String getPainelCadastroLimpar()
	{	
		return TextosTela.getTextItem(TextosTela.LIMPAR);
	}
	
	public String getPainelCadastroGravar()
	{	
		return TextosTela.getTextItem(TextosTela.GRAVAR);
	}
	
	public String getPainelConsultaTitulo()
	{
		return TextosTela.getTextItem(TextosTela.LISTA_PROJETOS_CADASTRADOS);
	}
	
	public String getPainelConsultaNenhumReg()
	{
		return TextosTela.getTextItem(TextosTela.NENHUM_REGISTRO);
	}
	
	public String getPainelConsultaPrimeira()
	{
		return TextosTela.getTextItem(TextosTela.PRIMEIRA);
	}
	
	public String getPainelConsultaAnterior()
	{
		return TextosTela.getTextItem(TextosTela.ANTERIOR);
	}
	
	public String getPainelConsultaProxima()
	{
		return TextosTela.getTextItem(TextosTela.PROXIMA);
	}
	
	public String getPainelConsultaUltima()
	{
		return TextosTela.getTextItem(TextosTela.ULTIMA);
	}
	
	public String getPainelConsultaID()
	{
		return TextosTela.getTextItem(TextosTela.ID);
	}
	
	public String getPainelConsultaAlterar()
	{
		return TextosTela.getTextItem(TextosTela.ALTERAR);
	}
	
	public String getPainelConsultaExcluir()
	{
		return TextosTela.getTextItem(TextosTela.EXCLUIR);
	}
}
