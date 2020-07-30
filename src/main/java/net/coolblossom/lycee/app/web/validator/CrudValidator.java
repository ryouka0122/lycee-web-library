package net.coolblossom.lycee.app.web.validator;

public interface CrudValidator<Entity> {

	void validateForInsert(Entity e);

	void validateForSelectById(Entity e);

	void validateForUpdate(Entity e);

	void validateForDelete(Entity e);

}
