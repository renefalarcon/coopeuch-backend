package cl.coopeuch.tecnico.service.impl;

import cl.coopeuch.tecnico.dto.TareaMensaje;
import cl.coopeuch.tecnico.dto.TareaMensajeList;
import cl.coopeuch.tecnico.dto.TareaRequest;
import cl.coopeuch.tecnico.dto.TareaResponse;
import cl.coopeuch.tecnico.entity.TareaEntity;
import cl.coopeuch.tecnico.exception.BaseController;
import cl.coopeuch.tecnico.exception.ModeloNotFoundException;
import cl.coopeuch.tecnico.repository.TareaRepository;
import cl.coopeuch.tecnico.service.TareaService;
import cl.coopeuch.tecnico.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public TareaMensajeList listarTareas() {
        try {
            List<TareaEntity> list;
            List<TareaResponse> aa = new ArrayList<>();
            list = tareaRepository.findAll();
            if (list.size()>0) {
                aa = list.stream().map(xx ->{
                    return TareaResponse.builder()
                            .idTarea(xx.getIdTarea())
                            .descripcion(xx.getDescripcion())
                            .vigente(xx.getVigente()).build();
                }).collect(Collectors.toList());
                return TareaMensajeList.builder().listaRetorno(aa).codigo(Utils.codOK).mensaje(Utils.ListaTareaOk).build();
            } else {
                return TareaMensajeList.builder().listaRetorno(null).codigo(Utils.codNOK).mensaje(Utils.ListaTareaVacia).build();
            }
        } catch( Exception e) {
            log.error(Utils.error,e.getMessage());
            throw new ModeloNotFoundException(Utils.RESOURCENOTFOUND,e);
        }


    }

    @Override
    public TareaMensaje agregarTarea(TareaRequest tareaRequest) {
        try {
            Optional tareaEntity = null;
            tareaEntity = tareaRepository.findById(tareaRequest.getIdTarea());
            if(!tareaEntity.isPresent()) {
            return guardarTarea(tareaRequest);
            } else {
            return modificarTarea(tareaRequest);
            }
        } catch (Exception e) {
            log.error(Utils.error,e.getMessage());
            throw new ModeloNotFoundException(Utils.RESOURCENOTFOUND,e);
        }
    }

    @Override
    public TareaMensaje eliminarTarea(Integer idTarea) {
        try {
            Optional<TareaEntity> tareaEntity = null;
            tareaEntity = tareaRepository.findById(idTarea);
            if(tareaEntity.isPresent()) {
                tareaRepository.deleteById(tareaEntity.get().getIdTarea());
                return TareaMensaje.builder().codigo(Utils.codOK).mensaje(Utils.TareaEliminada).build();
            } else {
                return TareaMensaje.builder().codigo(Utils.codNOK).mensaje(Utils.TareaNoEliminada).build();
            }
        } catch (Exception e) {
            log.error(Utils.error,e.getMessage());
            throw new ModeloNotFoundException(Utils.RESOURCENOTFOUND,e);
        }

    }

    private TareaMensaje guardarTarea(TareaRequest tareaRequest) {
        try {
           TareaEntity tareaEntity = new TareaEntity();
           tareaEntity.setIdTarea(tareaRequest.getIdTarea());
           tareaEntity.setDescripcion(tareaRequest.getDescripcion());
           tareaEntity.setVigente(tareaRequest.getVigente());
           tareaRepository.save(tareaEntity);
           return TareaMensaje.builder().codigo(Utils.codOK).mensaje(Utils.TareaAgregada).build();
        } catch(Exception e) {
            log.error(Utils.error,e.getMessage());
            throw new ModeloNotFoundException(Utils.RESOURCENOTFOUND,e);
        }
    }

    private TareaMensaje modificarTarea(TareaRequest tareaRequest) {
        try {
            TareaEntity tareaEntity = new TareaEntity();
            tareaEntity.setDescripcion(tareaRequest.getDescripcion());
            tareaEntity.setVigente(tareaRequest.getVigente());
            tareaEntity.setIdTarea(tareaRequest.getIdTarea());
            tareaRepository.save(tareaEntity);
            return TareaMensaje.builder().codigo(Utils.codOK).mensaje(Utils.TareaModificada).build();
        } catch (Exception e) {
            log.error(Utils.error,e.getMessage());
            throw new ModeloNotFoundException(Utils.RESOURCENOTFOUND,e);
        }
    }
}
