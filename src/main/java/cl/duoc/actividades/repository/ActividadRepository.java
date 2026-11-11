package cl.duoc.actividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.actividades.model.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}
