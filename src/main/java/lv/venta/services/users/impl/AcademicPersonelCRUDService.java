package lv.venta.services.users.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.enums.Degree;
import lv.venta.models.Comments;
import lv.venta.models.Thesis;
import lv.venta.models.users.Academic_personel;
import lv.venta.models.users.Person;
import lv.venta.models.users.User;
import lv.venta.repos.users.IRepoAcademicPersonel;
import lv.venta.services.users.IAcademicPersonelCRUDService;


@Service
public class AcademicPersonelCRUDService implements IAcademicPersonelCRUDService{
	
	@Autowired
	IRepoAcademicPersonel personelRepo;

	@Override
	public List<Academic_personel> getAll() {
		
		return (List<Academic_personel>) personelRepo.findAll();
	}

	@Override
	public void addPersonelByUser(User user, Degree degree) throws Exception {
		
	try {	
		
		Academic_personel temp = new Academic_personel(
				user.getPerson().getPersonName(), 
				user.getPerson().getSurname(), 
				user.getPerson().getPersonalCode(), 
				user, degree);
		
	
		
			if(!getAll().contains(temp)) {
				
				personelRepo.save(temp);
				
			}
	}
	catch (Exception e) {
		
		throw new Exception("Error!");
	}
		
		
		
		
	}

	@Override
	public void deletePersonelById(long id) throws Exception {
		
	try {
		for(Academic_personel temp: getAll()) {
			if(temp.getPersonId() == id) {
				
				personelRepo.delete(temp);
				
			}
		}
		
	}
	catch (Exception e) {
		
		throw new Exception("Person is not personel!");
		
	}
		
		
	}

	@Override
	public List<Comments> findCommentsByAcademicPersonelId(long id) throws Exception {
		
	try {	
		
		List<Comments> commentsList = new ArrayList<>();
		
		for(Academic_personel personel: getAll()) {
			if(personel.getPersonId() == id) {
				commentsList.add((Comments) personel.getComments());
			}
			
		}
		
		return commentsList;
		
	}
	catch (Exception e) {
		throw new Exception("Id nav personāls vai neeksistē!");
	}
		
	}

	@Override
	public List<Thesis> findThesisByAcademicPersonelId(long id) throws Exception {
		
		List<Thesis> thesisList = new ArrayList<>();
	try {
		for(Academic_personel personel: getAll()) {
			if(personel.getPersonId() == id) {
				
				thesisList.add((Thesis) personel.getThesis());
			}
		}
		
		return thesisList;
		
	}
	catch (Exception e) {
		throw new Exception("Id nav personāls vai neeksistē!");
	}
	}

}


