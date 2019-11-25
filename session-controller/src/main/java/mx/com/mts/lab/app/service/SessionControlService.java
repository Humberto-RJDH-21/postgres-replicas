package mx.com.mts.lab.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mts.lab.app.entity.SessionEntity;
import mx.com.mts.lab.app.repository.SessionRepository;

@Service
public class SessionControlService {

	@Autowired
	private SessionRepository sessionRepository;
	
	public Iterable<SessionEntity> getAllUserSession() {
		return sessionRepository.findAll();
	}
	
	public boolean saveSessionUser(SessionEntity entity) {
		sessionRepository.save(entity);
		return true;
	}
	
}
