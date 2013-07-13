package webservices;

import util.BeanFactory;
import dao.AquarioDAO;
import entidade.Aquario;

public class ManutencaoAquario {
	
	private AquarioDAO aquarioDAO; 

	public String AtualizaAquario(String dataMedicao, String horaMedicao, 
								  int luzLigada, int nivelRepo, int nivelSump,
								  float tempAgua, float tempAmb, float tempTampa){
		aquarioDAO = (AquarioDAO) BeanFactory.getBean("aquarioDAO", AquarioDAO.class);
		
		Aquario aquario = new Aquario();
		//aquario.setId(new Long(3));
		aquario.setDataMedicao(dataMedicao);
		aquario.setHoraMedicao(horaMedicao);
		aquario.setLuzLigada(luzLigada);
		aquario.setNivelRepo(nivelRepo);
		aquario.setNivelSump(nivelSump);
		aquario.setTempAgua(tempAgua);
		aquario.setTempAmb(tempAmb);
		aquario.setTempTampa(tempTampa);
		
		aquarioDAO.gravar(aquario);
		
		return "Sucesso";
	}
}
