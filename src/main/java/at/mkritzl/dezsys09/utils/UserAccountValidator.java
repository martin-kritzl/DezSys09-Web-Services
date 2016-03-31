package at.mkritzl.dezsys09.utils;

import at.mkritzl.dezsys09.data.UserAccount;

/**
 * Ueberpruft bestimmte Eigenschaften des UserAccounts auf ihre Korrektheit.
 */
public class UserAccountValidator {

    /**
     * Ueberprueft ob sowohl E-Mail als auch Passwort des Accounts vorhanden sind.
     *
     * @param account Zu ueberpruefender Account
     * @return Ob alle Angaben vorhanden sind
     */
    public static boolean hasData(UserAccount account) {
        return account != null && account.getEmail() != null && account.getPassword() != null;
    }
}