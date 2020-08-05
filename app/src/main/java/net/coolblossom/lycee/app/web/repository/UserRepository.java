package net.coolblossom.lycee.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.coolblossom.lycee.app.web.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
