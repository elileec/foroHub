package foroHub.foroHub.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String fechaCreacion,
        @NotBlank String status,
        @NotBlank String autor,
        @NotBlank String curso)
{

}
