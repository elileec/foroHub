package foroHub.foroHub.controller;

import foroHub.foroHub.infra.security.DatoSTokenJWT;
import foroHub.foroHub.infra.security.TokenService;
import foroHub.foroHub.usuario.DatosAutenficacion;
import foroHub.foroHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenficacion datos){

        var  authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena()); //springsecurity sabe los datos del usuario que ingresa
        var autenticacion = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatoSTokenJWT(tokenJWT));
    }
}
