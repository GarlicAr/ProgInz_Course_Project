package lv.venta.services.impl;



import org.springframework.stereotype.Service;

import lv.venta.services.IThesisCRUDService;

import java.util.List;


import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Comments;
import lv.venta.models.Thesis;
import lv.venta.models.users.Academic_personel;
import lv.venta.repos.IRepoComments;
import lv.venta.repos.IRepoThesis;
import lv.venta.services.IThesisCRUDService;
import lv.venta.services.users.impl.AcademicPersonelCRUDService;


@Service
public class ThesisCRUDService implements IThesisCRUDService {

    @Autowired
    private IRepoThesis thesisRepo;
    
	@Autowired
	CommentsCRUDService commentsService;
	
	@Autowired
	IRepoComments commentsRepo;
	


    @Override
    public ArrayList<Thesis> selectAllThesis() {
        return (ArrayList<Thesis>) thesisRepo.findAll();
    }
    
    
    @Override
    public void insertNewThesis(Thesis thesis) {
        for (Thesis temp : selectAllThesis()) {
            if (temp.getTitleLv().equals(thesis.getTitleLv()) &&
                temp.getTitleEn().equals(thesis.getTitleEn()) &&
                temp.getAim().equals(thesis.getAim()) &&
                temp.getTasks().equals(thesis.getTasks()) &&
                temp.getStudent().equals(thesis.getStudent()) &&
                temp.getPersonel().equals(thesis.getPersonel())) {
                throw new RuntimeException("Tēze jau eksistē");
            }
        }
        thesisRepo.save(thesis);
    }


    @Override
    public Thesis selectThesisById(long thesis_id) throws Exception {
        for (Thesis temp : selectAllThesis()) {
        	if(temp.getThesis_id() == thesis_id) {
        		return temp;
        	}
        }
        throw new Exception("Neparizes thesis_id");
    }

    public void deleteThesis(long thesis_id) {
        thesisRepo.deleteById(thesis_id);
    }
    



    @Override
    public void updateThesis(long id, Thesis inputThesis) throws Exception {
        Thesis temp = new Thesis();
        temp = selectThesisById(id);

        temp.setTitleLv(inputThesis.getTitleLv());
        temp.setTitleEn(inputThesis.getTitleEn());
        temp.setAim(inputThesis.getAim());
        temp.setTasks(inputThesis.getTasks());
        temp.setStatusFromSupervisor(inputThesis.isStatusFromSupervisor());
        temp.setStatus(inputThesis.getStatus());
        //temp.setComments(inputThesis.getComments());

        thesisRepo.save(temp);
    }
}
