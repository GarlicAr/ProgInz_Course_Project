package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Thesis;
import lv.venta.repos.IRepoThesis;
import lv.venta.services.IThesisCRUDService;

@Service
public class ThesisCRUDService implements IThesisCRUDService {

    @Autowired
    private IRepoThesis thesisRepo;

    @Override
    public ArrayList<Thesis> selectAllThesis() {
        return (ArrayList<Thesis>) thesisRepo.findAll();
    }
    
    
    @Override
    public void insertNewThesis(Thesis thesis) throws Exception {
        for (Thesis temp : selectAllThesis()) {
            if (temp.getTitleLv().equals(thesis.getTitleLv()) &&
                temp.getTitleEn().equals(thesis.getTitleEn()) &&
                temp.getAim().equals(thesis.getAim()) &&
                temp.getTasks().equals(thesis.getTasks()) &&
                temp.getStudent().equals(thesis.getStudent()) &&
                temp.getPersonel().equals(thesis.getPersonel())) {

                thesisRepo.save(temp);
                return;
            }
        }

        Thesis newThesis = new Thesis(thesis.getTitleLv(), thesis.getTitleEn(), thesis.getAim(), thesis.getTasks(),
            thesis.getStudent(), thesis.getPersonel());

        thesisRepo.save(newThesis);
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

    @Override
    public void deleteThesis(long thesis_id) throws Exception {
    	boolean isFound = false;
    	for(Thesis temp : selectAllThesis()) {
    		if(temp.getThesis_id() == thesis_id) {
    		 selectAllThesis().remove(temp);
    		 isFound = true;
    		 break;
    		}
    	}
    	if(!isFound) {		
			throw new Exception("Nepareizs thesis_id");
		}
    }

    @Override
    public void updateThesis(Thesis inputThesis) throws Exception {
        Thesis thesis = thesisRepo.findById(inputThesis.getThesis_id())
                .orElseThrow(() -> new Exception("No Thesis found with this ID"));

        thesis.setTitleLv(inputThesis.getTitleLv());
        thesis.setTitleEn(inputThesis.getTitleEn());
        thesis.setAim(inputThesis.getAim());
        thesis.setTasks(inputThesis.getTasks());
        // assuming status from supervisor can be updated
        thesis.setStatusFromSupervisor(inputThesis.isStatusFromSupervisor());
        // assuming reviewers can be updated
        thesis.setReviewers(inputThesis.getReviewers());
        // assuming comments can be updated
        thesis.setComments(inputThesis.getComments());

        thesisRepo.save(thesis);
    }


}
