package foroHub.foroHub.topico;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico detalletopico){
        this(
                detalletopico.getId(),
                detalletopico.getTitulo(),
                detalletopico.getMensaje(),
                detalletopico.getFechaCreacion(),
                detalletopico.getStatus(),
                detalletopico.getAutor(),
                detalletopico.getCurso()
        );

    }
}
