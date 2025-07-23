package foroHub.foroHub.usuario;
//esta clase que hace el login en la aplicación
//agregan anotación para spring la pueda comprender y cargar

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //identifica que esta clase es un servicio
public class AutenticacionService implements UserDetailsService {

    //repository busca un usuario con username
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
