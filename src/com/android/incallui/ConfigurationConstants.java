package com.android.incallui;

/* compiled from: ConfigurationConstants.kt */
/* loaded from: classes.dex */
public final class ConfigurationConstants {
    private static final String BLACKLIST_AUTHORITY = "com.oplus.provider.BlackListProvider";
    private static final String BLACKLIST_AUTHORITY_STORE = "com.oplus.dialer.black_list";
    private static final String BLACKLIST_PACKAGE_NAME = "com.oplus.blacklistapp";
    private static final String BLACKLIST_PACKAGE_NAME_STORE = "com.oplus.dialer";
    private static final String CONTACTS_PACKAGE_NAME = "com.android.contacts";
    private static final String CONTACTS_PACKAGE_NAME_STORE = "com.oplus.dialer";
    private static final String INQUIRENOAREA_AUTHORITY = "content://inquirenoarea/phoneno";
    private static final String INQUIRENOAREA_AUTHORITY_STORE = "content://com.oplus.dialer.inquirenoarea/phoneno";
    public static final ConfigurationConstants INSTANCE = new ConfigurationConstants();

    private ConfigurationConstants() {
    }

    public static final String getBlackListAuthority() {
        return BLACKLIST_AUTHORITY_STORE;
    }

    public static final String getBlackListPackageName() {
        return "com.oplus.dialer";
    }

    public static final String getContactsPackageName() {
        return "com.oplus.dialer";
    }

    public static final String getInquirenoareaAuthority() {
        return INQUIRENOAREA_AUTHORITY_STORE;
    }
}
