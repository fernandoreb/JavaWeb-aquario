package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entidade.Projeto;

public class ProjetoDAO extends HibernateDaoSupport {
	
	public List<Projeto> buscarTodos(){
		return getHibernateTemplate().loadAll(Projeto.class);
	}
	
	public Projeto buscarPorId(Long id){
		return getHibernateTemplate().get(Projeto.class, id);		
	}
	
	public void gravar(Projeto projeto){
		getHibernateTemplate().saveOrUpdate(projeto);
	}
	
	public void excluir(Projeto projeto){
		getHibernateTemplate().delete(projeto);
	}
	
		
}
