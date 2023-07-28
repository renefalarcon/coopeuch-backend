package cl.coopeuch.tecnico.controller;

import cl.coopeuch.tecnico.dto.TareaMensaje;
import cl.coopeuch.tecnico.dto.TareaMensajeList;
import cl.coopeuch.tecnico.dto.TareaRequest;
import cl.coopeuch.tecnico.dto.TareaResponse;
import cl.coopeuch.tecnico.service.TareaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TareaControllerTest {

    @InjectMocks
    TareaController tareaController;

    @Mock
    TareaService tareaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void obtenerTareas() {
        ResponseEntity<TareaMensajeList> result = tareaController.obtenerTareas();
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void agregarTarea() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        TareaRequest tareaRequest = new TareaRequest();
        tareaRequest.setIdTarea(1);
        tareaRequest.setDescripcion("prueba");
        tareaRequest.setVigente(true);
        ResponseEntity<TareaMensaje> result = tareaController.agregarTarea(tareaRequest);
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void borrarTarea() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        TareaRequest tareaRequest = new TareaRequest();
        tareaRequest.setIdTarea(1);
        ResponseEntity<TareaMensaje> result = tareaController.agregarTarea(tareaRequest);
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }
}