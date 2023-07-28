package cl.coopeuch.tecnico.service.impl;

import cl.coopeuch.tecnico.dto.TareaMensaje;
import cl.coopeuch.tecnico.dto.TareaMensajeList;
import cl.coopeuch.tecnico.dto.TareaRequest;
import cl.coopeuch.tecnico.dto.TareaResponse;
import cl.coopeuch.tecnico.entity.TareaEntity;
import cl.coopeuch.tecnico.repository.TareaRepository;
import cl.coopeuch.tecnico.service.TareaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TareaServiceImplTest {

    @Mock
    private TareaRepository tareaRepository;

    @InjectMocks
    private TareaServiceImpl tareaService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void listarTareas() {
        TareaMensajeList lista = this.tareaService.listarTareas();
        assertNotNull(lista);
    }

    @Test
    void agregarTarea() {
        TareaRequest tareaRequest = TareaRequest.builder().idTarea(1).descripcion("a").vigente(true).build();
        TareaEntity tareaEntity = new TareaEntity();
        tareaEntity.setIdTarea(1);
        tareaEntity.setDescripcion("PRUEBA");
        tareaEntity.setVigente(true);
        when(this.tareaRepository.findById(1)).thenReturn(Optional.ofNullable(tareaEntity));
        when(this.tareaRepository.save(Mockito.any(TareaEntity.class))).thenReturn(tareaEntity);
        TareaMensaje saveTarea = this.tareaService.agregarTarea(tareaRequest);
        Assertions.assertNotNull(saveTarea);
    }

    @Test
    void eliminarTarea() {
        TareaEntity tareaEntity = new TareaEntity();
        tareaEntity.setIdTarea(1);
        willDoNothing().given(tareaRepository).deleteById(1);
        when(this.tareaRepository.findById(1)).thenReturn(Optional.ofNullable(tareaEntity));
        TareaMensaje tareaMensaje = this.tareaService.eliminarTarea(1);
        Assertions.assertNotNull(tareaMensaje);
    }
}