package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Thesis;

public interface IThesisCRUDService {

	void insertNewThesis(Thesis thesis) throws Exception;
	
	Thesis selectThesisById(long id) throws Exception;
	
	void deleteThesis(long id) throws Exception;
	
	void updateThesis(Thesis updatedThesis) throws Exception;
	
	ArrayList<Thesis> selectAllThesis();
}
