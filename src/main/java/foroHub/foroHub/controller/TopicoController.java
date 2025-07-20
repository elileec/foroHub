package foroHub.foroHub.controller;

import foroHub.foroHub.topico.DatosRegistroTopico;
import jakarta.servlet.ServletOutputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopico json) {
        System.out.println(json);

    }
}
