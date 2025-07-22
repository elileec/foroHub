package foroHub.foroHub.controller;

import foroHub.foroHub.topico.*;
import jakarta.servlet.ServletOutputStream;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    //generar validaciones con @Valid
    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos) {

        repository.save(new Topico(datos));

    }



    //metodo para listar todos los topicos
    @GetMapping
    public List<Topico> listar(){
        return repository.findAll();
    }

    //metodo para mostrar un topico

    @GetMapping("/{id}")
    public ResponseEntity mostrarTopico(@PathVariable Long id){
        var detalletopico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(detalletopico));
    }



    //metodo actualizacion de datos en tabla topicos
    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizarTopico datos) {
        var topico = repository.getReferenceById(datos.id());
        topico.actualizaInformacion(datos);


    }
    //metodo que elimina topico de la tabla topicos
    @Transactional
    @DeleteMapping("/{id}")

    public void eliminar(@PathVariable Long id){
        repository.deleteById(id);
    }


}
