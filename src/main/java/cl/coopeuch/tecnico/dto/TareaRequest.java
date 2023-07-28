package cl.coopeuch.tecnico.dto;

import cl.coopeuch.tecnico.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaRequest {
    @NotNull(message = Utils.noNulo)
    private Integer idTarea;
    @NotBlank(message = Utils.noBlanco)
    private String descripcion;
    @NotNull(message = Utils.esBolean)
    private Boolean vigente;

}
