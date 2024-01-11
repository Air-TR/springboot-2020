package com.tr.springboot.kit.windows;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Windows 注册表 Kit
 *  HKLM：HKEY_LOCAL_MACHINE
 *  HKCU：HKEY_CURRENT_USER
 *
 * @Author: TR
 */
public class WindowsRegistryKit {

    private static Preferences systemPref = Preferences.systemRoot();
    private static Preferences userPref = Preferences.userRoot();

    public static void writeHKLM(String key, String content) {
        systemPref.put(key, content);
    }

    public static String readHKLM(String key) {
        return systemPref.get(key, null);
    }

    public static void removeHKLM(String key) {
        systemPref.remove(key);
    }

    public static void clearHKLM() throws BackingStoreException {
        systemPref.clear();
    }

    public static void writeHKCU(String key, String content) {
        userPref.put(key, content);
    }

    public static String readHKCU(String key) {
        return userPref.get(key, null);
    }

    public static void removeHKCU(String key) {
        userPref.remove(key);
    }

    public static void clearHKCU() throws BackingStoreException {
        userPref.clear();
    }

}
