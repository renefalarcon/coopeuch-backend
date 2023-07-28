package cl.coopeuch.tecnico.controller;

import cl.coopeuch.tecnico.dto.TareaMensaje;
import cl.coopeuch.tecnico.dto.TareaMensajeList;
import cl.coopeuch.tecnico.dto.TareaRequest;
import cl.coopeuch.tecnico.dto.TareaResponse;
import cl.coopeuch.tecnico.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/tarea")
@Validated
public class TareaController {

    @Autowired
    TareaService tareaService;

    @GetMapping()
    public ResponseEntity<TareaMensajeList> obtenerTareas() {
        TareaMensajeList lista = tareaService.listarTareas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TareaMensaje> agregarTarea(@Valid @RequestBody TareaRequest tareaRequest) {
        TareaMensaje tarea = tareaService.agregarTarea(tareaRequest);
        return new ResponseEntity<>(tarea, HttpStatus.OK);
    }

    @DeleteMapping("/{idTarea}")
    public ResponseEntity<TareaMensaje> borrarTarea(@PathVariable Integer idTarea) {
        TareaMensaje tarea = tareaService.eliminarTarea(idTarea);
        return new ResponseEntity<>(tarea, HttpStatus.OK);
    }
}
