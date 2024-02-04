package com.aquila.spring.datarest.repository;

import com.aquila.spring.datarest.model.WebsiteUser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@ComponentScan
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<WebsiteUser, Long> {
    List<WebsiteUser> findByName(@Param("name") String name);
}
