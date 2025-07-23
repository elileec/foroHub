package foroHub.foroHub.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") //identificar el usuario por id

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera el id de forma automática
    private Long id;
    private String login;
    private String contrasena;
}
