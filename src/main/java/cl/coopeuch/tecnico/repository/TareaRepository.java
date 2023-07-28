package cl.coopeuch.tecnico.repository;

import cl.coopeuch.tecnico.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<TareaEntity,Integer> {


}
