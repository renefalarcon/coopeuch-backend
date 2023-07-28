package cl.coopeuch.tecnico.service;

import cl.coopeuch.tecnico.dto.TareaMensaje;
import cl.coopeuch.tecnico.dto.TareaMensajeList;
import cl.coopeuch.tecnico.dto.TareaRequest;

public interface TareaService {

    TareaMensajeList listarTareas();
    TareaMensaje agregarTarea(TareaRequest tareaRequest);

    TareaMensaje eliminarTarea(Integer idTarea);
}
