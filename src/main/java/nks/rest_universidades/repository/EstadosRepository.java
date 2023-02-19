package nks.rest_universidades.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nks.rest_universidades.model.Estados;
import nks.rest_universidades.DTO.CurEstDTO;

public interface EstadosRepository extends JpaRepository<Estados, Integer> {

    @Query(value = "select curso.nome as curso, estados.sigla as estado from curso join campus_curso on campus_curso.curso_id = curso.id join campus on campus.id = campus_curso.campus_id join universidades on campus.campus_universidade_id = universidades.id join estados_universidades on universidades.id = estados_universidades.universidade_id join estados on estados.id = estados_universidades.estados_id where curso.nome = ?1", nativeQuery = true)
    public List<CurEstDTO> estadoPorCurso(String curso);

}