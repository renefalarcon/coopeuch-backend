package cl.coopeuch.tecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaResponse {

    private Integer idTarea;
    private String descripcion;
    private Boolean vigente;
    private String fechaCreacion;

}
