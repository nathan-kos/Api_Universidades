package nks.rest_universidades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import nks.rest_universidades.model.Estados;
//import nks.rest_universidades.model.Universidade;
import nks.rest_universidades.model.Universidade;

public interface EstadosRespository extends JpaRepository<Estados, Integer> {

    @Query(value = "select universidades.nome as universidades, estados.nome as estado from estados join estados_universidade on estados_universidade.estados_id = estados.id join universidades on universidades.id = estados_universidade.universidade_id where estados.sigla = ?1", nativeQuery = true)
    public List<Universidade[]> findUniversidadesByEstado(String sigla);

    @Query(value = "select universidades.id as id, universidades.nome as universidades, universidades.sigla as sigla, universidades.site as link  from estados join estados_universidade on estados_universidade.estados_id = estados.id join universidades on universidades.id = estados_universidade.universidade_id where estados.sigla = ?1", nativeQuery = true)
    public List<Universidade> findUniversidadesByEstadoteste(String sigla);

    @Query(value = "select universidades.nome as universidade, estados.nome as estados from universidades join estados_universidade on estados_universidade.universidade_id = universidades.id join estados on estados_universidade.estados_id = estados.id where estados.sigla = ?1", nativeQuery = true)
    public List<Universidade> findUniversidadesByEstadoteste2(String sigla);

}
