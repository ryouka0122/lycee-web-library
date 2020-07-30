package net.coolblossom.lycee.app.web.domain;

import lombok.AllArgsConstructor;
import net.coolblossom.lycee.app.web.service.CrudService;
import net.coolblossom.lycee.app.web.validator.CrudValidator;

@AllArgsConstructor
public class CrudModel<Entity> {

	private CrudValidator<Entity> crudValidator;

	private CrudService<Entity> crudService;


	void insert(Entity e) {
		crudValidator.validateForInsert(e);
		crudService.insert(e);
	}

	Entity selectById(Entity e) {
		crudValidator.validateForSelectById(e);
		return crudService.selectById(e);
	}

	void update(Entity e) {
		crudValidator.validateForUpdate(e);
		crudService.update(e);
	}

	void delete(Entity e) {
		crudValidator.validateForDelete(e);
		crudService.delete(e);
	}


}
