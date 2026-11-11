package cl.duoc.actividades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.actividades.exception.RecursoNoEncontradoException;
import cl.duoc.actividades.model.Actividad;
import cl.duoc.actividades.repository.ActividadRepository;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository repository;

    public List<Actividad> listar() { 
        return repository.findAll(); 
    }

    public Actividad buscar(Long id) {
        return repository.findById(id).orElseThrow(() ->
        new RecursoNoEncontradoException("Actividad no encontrada: " + id));
    }

    public Actividad guardar(Actividad actividad) {
        return repository.save(actividad);
    }

    public Actividad actualizar(Long id, Actividad datos) {
        Actividad actual = buscar(id);
        actual.setNombre(datos.getNombre());
        actual.setDescripcion(datos.getDescripcion());
        actual.setPrecio(datos.getPrecio());
        actual.setCupos(datos.getCupos());
        actual.setCategoria(datos.getCategoria());
        return repository.save(actual);
    }

    public void eliminar(Long id) {
        repository.delete(buscar(id));
    }

}
