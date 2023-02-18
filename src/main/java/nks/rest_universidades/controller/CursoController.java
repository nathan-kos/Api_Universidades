package nks.rest_universidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nks.rest_universidades.DTO.CurCidDTO;
import nks.rest_universidades.DTO.CurEstDTO;
import nks.rest_universidades.DTO.CurUniDTO;
import nks.rest_universidades.model.Curso;
import nks.rest_universidades.repository.CursoRepository;

@RestController
public class CursoController {
    
    @Autowired
    private CursoRepository repository;

    @GetMapping(path = "/universidades/curso/listar")
    public List<Curso> listarCursos(){
        return repository.findAll();
    }

    @GetMapping(path = "/universidades/curso/universidade/{sigla}")
    public List<CurUniDTO> cursoPorUniversidade(@PathVariable("sigla") String sigla ){
      return repository.CursoPorUniversidade(sigla);  
    }

    @GetMapping(path = "/universidades/curso/campus/{cidade}")
    public List<CurCidDTO> cursoPorCampus(@PathVariable("cidade") String cidade){
        return repository.CursoPorCidade(cidade);
    }

    @GetMapping(path = "/universidades/curso/estado/{sigla}")
    public List<CurEstDTO> cursoPorEstado(@PathVariable("sigla") String sigla){
        return repository.cursoPorEstado(sigla);
    }

}
