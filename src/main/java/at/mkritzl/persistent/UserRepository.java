package at.mkritzl.persistent;

import at.mkritzl.data.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccount, String> {
}
