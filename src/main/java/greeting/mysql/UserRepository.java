package greeting.mysql;

import org.springframework.data.repository.CrudRepository;

/**
 * This is the repository interface and will be automatically implemented by
 * Spring in a bean called <code>userRepository</code> that provides CRUD
 * operations again the <code>user</code> table. CRUD refers Create, Read,
 * Update, Delete.
 * 
 * @author Tran Xuan Hoang
 */
public interface UserRepository extends CrudRepository<User, Long> {

}