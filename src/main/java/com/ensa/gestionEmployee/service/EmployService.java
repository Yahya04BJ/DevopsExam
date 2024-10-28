package com.ensa.gestionEmployee.service;

import com.ensa.gestionEmployee.model.Employ;
import com.ensa.gestionEmployee.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployService {
    @Autowired
    private EmployRepository employrepository ;
    public Employ create(Employ employ){
        return employrepository.save(employ) ;
    }
    public Employ modifier(Long id , Employ employ ){
        return employrepository.findById(id)
                .map(nvemploy -> {
                    nvemploy.setEmail(employ.getEmail());
                    nvemploy.setNom(employ.getNom());
                    return employrepository.save(nvemploy);
                } )
                .orElseThrow(() ->new RuntimeException("employ non trouvé"));
    }
    public String delete(Long id ){
        employrepository.deleteById(id);
        return"employé supprimé" ;

    }

    public List<Employ> lire(){
        return employrepository.findAll() ;
    }
}