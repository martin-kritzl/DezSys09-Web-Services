package at.mkritzl.dezsys09.persistent;

import at.mkritzl.dezsys09.data.UserAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Dieses Repository wird verwendet um die UserAccounts der Datenbank verwenden zu können.
 *
 * @author Martin Kritzl
 * @version 20160331
 */
public interface UserRepository extends CrudRepository<UserAccount, String> {
}
