package lv.venta.services.impl;


import org.springframework.stereotype.Service;

import lv.venta.services.IThesisCRUDService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Thesis;
import lv.venta.repos.IRepoThesis;
import lv.venta.services.IThesisCRUDService;


@Service
public class ThesisCRUDService implements IThesisCRUDService{

	@Autowired
	IRepoThesis thesisRepo;
	
	@Override
	public List<Thesis> getAll() {
		return (List<Thesis>) thesisRepo.findAll();
	}

}
