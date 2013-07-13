package controle;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

import util.TextosTela;

@ManagedBean(name="principalController")
@SessionScoped
public class PrincipalController implements ActionListener, Serializable, Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String idINICIO = "inicio";
	private final String idHORARIO = "horarios";
	private final String idPROJETOS = "projetos";
	private final String idRELATORIOS = "relatorios";
	private final String idAQUA_ATU = "aquaAtual";
	private final String idAQUA_REL = "aquaRel";
	private final String idSAIR = "sair";
	
	private final String pagHORARIO = "logado/horarios.jsf";
	private final String pagINICIO = "logado/inicio.jsf";
	private final String pagCONSTRUCAO = "logado/construcao.jsf";
	private final String pagPROJETOS = "logado/projetos.jsf";
	private final String pagAQUA_ATU = "logado/aquarioAtual.jsf";
	private final String pagSAIR = "logado/desejasair.jsf";
	
	private String pagina;
	
	private MenuModel menuModel;
	
	private String user;
	private String pass;
	
	public void setUser(String user){
		this.user = user;
	}
	
	public String getUser(){
		return user;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}
	
	public String getPass(){
		return pass;
	}
	
	public PrincipalController(){
		pagina = pagINICIO;
		initialized = false;
	}
	
	public String getTitulo()
	{
		return TextosTela.getTextItem(TextosTela.FARG_FERNANDO_AUGUSTO);
	}

	public String getPagina()
	{
		return pagina;
	}
	
	public String getData()
	{
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data = new Date();
		
		String now = format.format(data);
		
		return now;
	}
	
	//Monta os itens de menu
	public MenuModel getMenuModel()
	{
		Submenu submenu = null;
		MenuItem item = null;
		menuModel = new DefaultMenuModel();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		HttpServletRequest r = (HttpServletRequest)fc.getExternalContext().getRequest();
		if(!r.isRequestedSessionIdValid()){
			return menuModel;
		}
		if (!r.isUserInRole("member")){
			return menuModel;
		}
		
		/*submenu = new Submenu();
		submenu.setLabel(TextosTela.getTextItem(TextosTela.INICIO));

		item = new MenuItem();
		item.setValue(TextosTela.getTextItem(TextosTela.PAG_INICIAL));
		item.addActionListener(this);
		item.setId(idINICIO);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);

		menuModel.addSubmenu(submenu);
		
		submenu = new Submenu();
		submenu.setLabel(TextosTela.getTextItem(TextosTela.PROJETOS));
		
		item = new MenuItem();
		item.setValue(TextosTela.getTextItem(TextosTela.AGENDA));
		item.addActionListener(this);
		item.setId(idHORARIO);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue(TextosTela.getTextItem(TextosTela.CADASTRO_PROJETOS));
		item.addActionListener(this);
		item.setId(idPROJETOS);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue(TextosTela.getTextItem(TextosTela.RELATORIOS));
		item.addActionListener(this);
		item.setId(idRELATORIOS);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);

		menuModel.addSubmenu(submenu);*/
		
		submenu = new Submenu();
		submenu.setLabel(TextosTela.getTextItem(TextosTela.AQUARIO));
		
		item = new MenuItem();
		item.setValue(TextosTela.getTextItem(TextosTela.SITUACAO_ATUAL));
		item.addActionListener(this);
		item.setId(idAQUA_ATU);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue(TextosTela.getTextItem(TextosTela.RELATORIOS));
		item.addActionListener(this);
		item.setId(idAQUA_REL);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue("Sair");
		item.addActionListener(this);
		item.setId(idSAIR);
		item.setUpdate("painelGridFrame");
		submenu.getChildren().add(item);
		
		menuModel.addSubmenu(submenu);
		
		return menuModel;
	}

	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		
		String id = arg0.getComponent().getId();
	
		pagina = pagCONSTRUCAO;
		
		if(id.equals(idHORARIO))
			pagina = pagHORARIO;
		
		if(id.equals(idINICIO))
			pagina = pagINICIO;
		
		if(id.equals(idPROJETOS))
			pagina = pagPROJETOS;
		
		if(id.equals(idAQUA_ATU))
			pagina = pagAQUA_ATU;
		
		if(id.equals(idSAIR))
			pagina = pagSAIR;
		
	}
	
	public String sair(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try{
			HttpServletRequest r = (HttpServletRequest)fc.getExternalContext().getRequest();
			r.logout();
		}catch(ServletException e){
			e.printStackTrace();
		}
		
		increment();
		return "/logado/inicio.jsf?faces-redirect=true";
	}
	
	public String cancelar(){
		return "/logado/inicio.jsf?faces-redirect=true";
	}
	
	public String login(){
		/*{  
	        FacesContext context = FacesContext.getCurrentInstance();  
	        Application application = context.getApplication();  
	        ViewHandler viewHandler = application.getViewHandler();  
	        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());  
	        context.setViewRoot(viewRoot);  
	        context.renderResponse();  
	    }*/
		
		if(user.equals("")||pass.equals(""))
			return "/login_erro.jsf?faces-redirect=true";
		
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			HttpServletRequest r = (HttpServletRequest)fc.getExternalContext().getRequest();
			r.login(user, pass);
			
		}catch(ServletException e){
			e.printStackTrace();
			return "/login_erro.jsf?faces-redirect=true";
		}
		
		increment();
		return "/logado/inicio.jsf?faces-redirect=true";
	}
	
	private int count;
	private boolean initialized; 
	private Thread t;
	
	public void increment(){
		
		if(!initialized)
		{
			initialized = true;
			t = new Thread(this);
			t.start();
		}
		
		
	}
	
	public int getCount() {
		return count;
	}
		public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		
		while(count < 2)
		{
			count++;
			System.out.println("Teste"+count);
			PushContext pushContext = PushContextFactory.getDefault().getPushContext();
			pushContext.push("/counter", String.valueOf(0));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		count = 0;
		initialized = false;
	}

}
