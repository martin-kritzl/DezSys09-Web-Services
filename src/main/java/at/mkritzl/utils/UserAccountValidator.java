package at.mkritzl.utils;

import at.mkritzl.data.UserAccount;

public class UserAccountValidator {

    public static boolean hasData(UserAccount account) {
        return account != null && account.getEmail() != null && account.getPassword() != null;
    }
}