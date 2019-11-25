package mx.com.mts.lab.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.com.mts.lab.app.entity.SessionEntity;

public interface SessionRepository extends CrudRepository<SessionEntity, Long>{
	
	List<SessionEntity> findByLastName(String lastName);
	SessionEntity findById(long id);

}
