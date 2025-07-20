package foroHub.foroHub.controller;

import foroHub.foroHub.topico.DatosRegistroTopico;
import foroHub.foroHub.topico.Topico;
import foroHub.foroHub.topico.TopicoRepository;
import jakarta.servlet.ServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopico datos) {
        repository.save(new Topico(datos));

    }
}
