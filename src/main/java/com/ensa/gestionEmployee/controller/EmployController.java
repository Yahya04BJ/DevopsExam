package com.ensa.gestionEmployee.controller;

import com.ensa.gestionEmployee.model.Employ;
import com.ensa.gestionEmployee.repository.EmployRepository;
import com.ensa.gestionEmployee.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/employ")
public class EmployController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable Long id, Locale locale) {
        // Exemple de logique pour trouver l'employé
        boolean employeeFound = false; // Remplacez par la logique réelle

        if (!employeeFound) {
            String errorMessage = messageSource.getMessage("employee.not_found", null, locale);
            return ResponseEntity.status(404).body(errorMessage);
        }

        String successMessage = messageSource.getMessage("employee.added", null, locale);
        return ResponseEntity.ok(successMessage);
    }
    @Autowired
    private EmployService employservice ;
    @GetMapping
    public List<Employ> lire(){
        return employservice.lire() ;

    }
    @PostMapping("/create")
    public Employ create(@RequestBody Employ employ){
        return employservice.create(employ) ;
    }
    @PutMapping("update/{id}")
    public Employ update(@PathVariable Long id , @RequestBody Employ employ){
        return employservice.modifier(id,employ) ;
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id ){
        return employservice.delete(id) ;
    }
}
