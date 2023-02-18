package nks.rest_universidades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nks.rest_universidades.DTO.CampusDTO;
import nks.rest_universidades.model.Campus;

public interface campusRepository extends JpaRepository<Campus, Integer>{
    
    @Query (value = "select campus.cidade as localização, campus.site as site, universidades.nome as universidade from campus join universidades on universidades.id = campus.campus_universidade_id where universidades.sigla = ?1" , nativeQuery = true)
    public List<CampusDTO> findCampusByUniversidade(String sigla);

}
