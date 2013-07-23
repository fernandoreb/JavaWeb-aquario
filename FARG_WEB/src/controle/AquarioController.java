package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import util.BeanFactory;
import util.TextosTela;

import dao.AquarioDAO;

import entidade.Aquario;


@ManagedBean(name="aquarioController")
@SessionScoped
public class AquarioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aquario Aquario = new Aquario();
	private List<Aquario> listaAquarioInfo = new ArrayList<Aquario>();	
	private List<Aquario> listaAquarioDetalhe = new ArrayList<Aquario>();	
	private AquarioDAO AquarioDAO = (AquarioDAO) BeanFactory.getBean("aquarioDAO", AquarioDAO.class);
	private Aquario selecionado;
	
	public Aquario getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Aquario selecionado) {
		//System.out.println(selecionado);
		this.selecionado = selecionado;
		
	}
	
	public String detalhes(){
		
		if(selecionado == null)
			return "";
		
		atualizarTelaDetalhe();
		
		return "/logado/aquarioDetalhe.jsf";
	}
	
	public String voltar(){
		
		return "/logado/aquarioAtual.jsf";
	}

	public AquarioController(){
		atualizarTela();
	}

	/**
	 * Limpa os campos input e atualiza a lista de usuários cadastrados
	 */
	private void atualizarTela() {
		Aquario = new Aquario();
		//listaAquarioInfo = AquarioDAO.buscarTodos();
		listaAquarioInfo = AquarioDAO.buscarTodosResumido();
	}
	
	private void atualizarTelaDetalhe() {
		Aquario = new Aquario();
		//listaAquarioDetalhe = AquarioDAO.buscarTodos();
		listaAquarioDetalhe = AquarioDAO.buscaData(selecionado);
	}

	/**
	 * Grava novo registro ou atualiza um registro
	 */
	public void gravar(){
		AquarioDAO.gravar(getAquario());
		atualizarTela();
	}
	
	/**
	 * Exclui um registro da tabela Aquario
	 */
	public void excluir(){
		AquarioDAO.excluir(getAquario());
		atualizarTela();
	}
	
	public List<Aquario> getListaAquarioInfo() {
		return listaAquarioInfo;
	}
	
	public List<Aquario> getListaAquarioDetalhe() {
		return listaAquarioDetalhe;
	}
		 
	public void setListaAquarioInfo(List<Aquario> listaAquario) {
		this.listaAquarioInfo = listaAquario;
	}
	
	public void setListaAquarioDetalhe(List<Aquario> listaAquario) {
		this.listaAquarioDetalhe = listaAquario;
	}
		 
	public Aquario getAquario() {
		return Aquario;
	}
		 
	public void setAquario(Aquario Aquario) {
		this.Aquario = Aquario;
	}
	
	public String getPainelCadastroTitulo()
	{	
		return TextosTela.getTextItem(TextosTela.CADASTRO_AQUARIO_DADOS);
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
		return TextosTela.getTextItem(TextosTela.LISTA_AQUARIO);
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
	
	public String getPainelConsultaData()
	{
		return TextosTela.getTextItem(TextosTela.DATA);
	}
	
	public String getPainelConsultaHora()
	{
		return TextosTela.getTextItem(TextosTela.HORA);
	}
	
	public String getPainelConsultaTempAgua()
	{
		return TextosTela.getTextItem(TextosTela.TEMP_AGUA);
	}
	
	public String getPainelConsultaTempAmb()
	{
		return TextosTela.getTextItem(TextosTela.TEMP_AMB);
	}
	
	public String getPainelConsultaTempTampa()
	{
		return TextosTela.getTextItem(TextosTela.TEMP_TAMPA);
	}
	
	public String getPainelConsultaNivelSump()
	{
		return TextosTela.getTextItem(TextosTela.NIVEL_SUMP);
	}
	
	public String getPainelConsultaNivelRepo()
	{
		return TextosTela.getTextItem(TextosTela.NIVEL_REPO);
	}
	
	public String getPainelConsultaLuz()
	{
		return TextosTela.getTextItem(TextosTela.LUZ);
	}
	
	
}
