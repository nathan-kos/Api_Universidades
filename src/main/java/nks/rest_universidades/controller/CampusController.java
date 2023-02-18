package nks.rest_universidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nks.rest_universidades.DTO.CampusDTO;
import nks.rest_universidades.model.Campus;
import nks.rest_universidades.repository.campusRepository;

@RestController
public class CampusController {
    
    @Autowired
    private campusRepository repository;

    @GetMapping(path = "/universidades/campus/listar")
    public List<Campus> listar(){
        return repository.findAll();
    }

    // @GetMapping(path = "/universidades/campus/universidade/{sigla}")
    // public List<CampusDTO> findCampusByuniversidade(@PathVariable String sigla){
    //     return repository.findCampusByUniversidade(sigla);
    // }


    @GetMapping(path = "/universidades/campus/universidade/{sigla}")
    public List<CampusDTO> campusPorUniversidade(@PathVariable("sigla") String sigla){
        return repository.findCampusByUniversidade(sigla);
    }
}
