package at.mkritzl.dezsys09.persistent;

import at.mkritzl.dezsys09.data.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccount, String> {
}
