package cl.coopeuch.tecnico.service.impl;

import cl.coopeuch.tecnico.entity.TareaEntity;
import cl.coopeuch.tecnico.repository.TareaRepository;
import cl.coopeuch.tecnico.service.TareaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TareaServiceImplTest {

    @Mock
    private TareaRepository tareaRepository;

    @InjectMocks
    private TareaService tareaService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void listarTareas() {



    }

    @Test
    void agregarTarea() {
    }

    @Test
    void eliminarTarea() {
    }
}