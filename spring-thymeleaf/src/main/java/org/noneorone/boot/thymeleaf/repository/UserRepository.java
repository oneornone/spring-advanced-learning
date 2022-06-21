package org.noneorone.boot.thymeleaf.repository;

import org.noneorone.boot.thymeleaf.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
