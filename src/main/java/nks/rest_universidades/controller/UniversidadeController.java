package nks.rest_universidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nks.rest_universidades.DTO.CurUniDTO;
import nks.rest_universidades.DTO.UniEstDTO;
import nks.rest_universidades.model.Universidade;
import nks.rest_universidades.repository.UniversidadeRepository;

@RestController
public class UniversidadeController {
    
    @Autowired
    private UniversidadeRepository repository;

    @GetMapping(path = "/universidades/universidade/listar")
    public List<Universidade> findAll() {
        return repository.findAll();
    }


    @GetMapping(path = "/universidades/universidade/estado/{sigla}")
    public List<UniEstDTO> ConsultarUniversidadesPorEstado(@PathVariable String sigla){
        return repository.findUniversidadesByEstado(sigla);
    }

    @GetMapping(path = "/universidades/universidade/curso/{curso}")
    public List<CurUniDTO> universidadePorCurso(@PathVariable("curso") String curso){
        return repository.UniversidadePorCurso(curso);
    }
}
