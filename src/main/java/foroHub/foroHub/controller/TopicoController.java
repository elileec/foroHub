package foroHub.foroHub.controller;

import foroHub.foroHub.topico.DatosActualizarTopico;
import foroHub.foroHub.topico.DatosRegistroTopico;
import foroHub.foroHub.topico.Topico;
import foroHub.foroHub.topico.TopicoRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Topico> listar(){
        return repository.findAll();
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
