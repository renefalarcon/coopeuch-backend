package cl.coopeuch.tecnico.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="TAREA")
@Data
public class TareaEntity {

    @Id
    @Column(name ="ID_TAREA")
    private Integer idTarea;
    @Column(name ="DESCRIPCION")
    private String descripcion;
    @CreationTimestamp
    @Column(name="FECHA_CREACION")
    Date fechaCreacion;
    @Column(name="VIGENTE")
    private Boolean vigente;
}
