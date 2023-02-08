package nks.rest_universidades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nks.rest_universidades.model.Universidade;

public interface UniversidadeRepository extends JpaRepository<Universidade, Integer> {
    
    @Query(value = ("select universidades.nome as universidade, estados.nome as estados from universidades join estados_universidade on estados_universidade.universidade_id = universidades.id join estados on estados_universidade.estados_id = estados.id where estados.sigla = ?1"), nativeQuery = true)
    public List<Universidade> findUniversidadesByEstado(String sigla);
}
