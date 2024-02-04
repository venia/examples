package repository;

import model.WebsiteUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<WebsiteUser, Long> {
    List<WebsiteUser> findByName(@Param("name") String name);
}
