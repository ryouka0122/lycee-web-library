package net.coolblossom.lycee.app.web.service;

import java.util.List;
import java.util.Map;

public interface CrudService<Entity> {

	void insert(Entity e);

	Entity selectById(Entity e);

	List<Entity> select(Map<String, Object> conditions);

	void update(Entity e);

	void delete(Entity e);

}
