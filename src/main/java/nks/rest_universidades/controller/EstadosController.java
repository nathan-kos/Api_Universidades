package nks.rest_universidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nks.rest_universidades.DTO.CurEstDTO;
import nks.rest_universidades.model.Estados;
//import nks.rest_universidades.model.Universidade;
import nks.rest_universidades.repository.EstadosRepository;

@RestController
public class EstadosController {
    
    @Autowired
    private EstadosRepository repository;

    @GetMapping(path = "/universidades/estados/listar")
    public List<Estados> ConsultarEstados(){
        return repository.findAll();
    }

    @GetMapping(path = "/universidades/estado/curso/{curso}")
    public List<CurEstDTO> estadosPorCurso(@PathVariable("curso") String curso){
        return repository.estadoPorCurso(curso);
    }
}
