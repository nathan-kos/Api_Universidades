package nks.rest_universidades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nks.rest_universidades.DTO.CurUniDTO;
import nks.rest_universidades.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
    @Query(value = "select curso.nome as curso, universidades.nome as universidade from curso join campus_curso on campus_curso.curso_id = curso.id join campus on campus.id = campus_curso.campus_id join universidades on campus.campus_universidade_id = universidades.id where universidades.sigla = ?1", nativeQuery = true)
    public List<CurUniDTO> CursoPorUniversidade(String sigla);

}
