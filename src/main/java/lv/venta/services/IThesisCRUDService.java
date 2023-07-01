package lv.venta.services;
import java.util.ArrayList;
import java.util.List;

import lv.venta.models.Comments;
import lv.venta.models.Thesis;

public interface IThesisCRUDService {


    void insertNewThesis(Thesis thesis);
    
    Thesis selectThesisById(long id) throws Exception;
    
    void deleteThesis(long id) throws Exception;
    
    void updateThesis(long id, Thesis inputThesis) throws Exception;
    
    ArrayList<Thesis> selectAllThesis();
    

}