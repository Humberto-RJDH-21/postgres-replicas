package mx.com.mts.lab.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import mx.com.mts.lab.app.entity.SessionEntity;
import mx.com.mts.lab.app.model.SessionReponse;
import mx.com.mts.lab.app.service.SessionControlService;

@RestController
@RequestMapping("/printdo1")
public class SessionController {
	
	private final Logger logger = LoggerFactory.getLogger(SessionController.class);

	private final SessionControlService sessionControlService;
	
	public SessionController(SessionControlService sessionControlService) {
		this.sessionControlService = sessionControlService;
	}
	
	@GetMapping("/session/{name}")
	public SessionReponse doCheckSession(HttpSession session, @PathVariable String name) {
		logger.info("entrando a método doCheckSession");
		return new SessionReponse(name, new Date(), session.getId().toString());

	}
	
	@GetMapping("/users")
	public List<SessionEntity> getAllUsres() {
		List<SessionEntity> list = new ArrayList<>();
		sessionControlService.getAllUserSession()
		     .forEach(
				e -> list.add(new SessionEntity(e.getId(), e.getFirstName(), e.getLastName())
			  ));
		return list;

	}
	
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public SessionEntity addUser(@RequestBody SessionEntity entity) throws Exception {
		
		if(sessionControlService.saveSessionUser(entity)) {
			return entity;
		}
		
		throw new Exception("No se pudo crear el usuario");
		
	}
	
	
}
