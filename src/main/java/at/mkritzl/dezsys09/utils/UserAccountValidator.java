package at.mkritzl.dezsys09.utils;

import at.mkritzl.dezsys09.data.UserAccount;

public class UserAccountValidator {

    public static boolean hasData(UserAccount account) {
        return account != null && account.getEmail() != null && account.getPassword() != null;
    }
}