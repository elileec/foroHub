package foroHub.foroHub.topico;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso) {
}
