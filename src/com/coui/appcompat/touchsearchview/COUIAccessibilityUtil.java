package com.coui.appcompat.touchsearchview;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class COUIAccessibilityUtil {
    public static final char ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR = ':';
    private static final String TALKBACK_PACKAGE = "com.google.android.marvin.talkback";
    static final TextUtils.SimpleStringSplitter sStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

    public static Set<ComponentName> getEnabledServicesFromSettings(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        TextUtils.SimpleStringSplitter simpleStringSplitter = sStringColonSplitter;
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(simpleStringSplitter.next());
            if (unflattenFromString != null) {
                hashSet.add(unflattenFromString);
            }
        }
        return hashSet;
    }

    private static boolean isAccessibilityEnabled(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        return true;
    }

    public static boolean isTalkbackEnabled(Context context) {
        if (isTalkbackServiceRunning(context) && isAccessibilityEnabled(context)) {
            return true;
        }
        return false;
    }

    private static boolean isTalkbackServiceRunning(Context context) {
        Set<ComponentName> enabledServicesFromSettings = getEnabledServicesFromSettings(context);
        if (enabledServicesFromSettings != null && !enabledServicesFromSettings.isEmpty()) {
            Iterator<ComponentName> it = enabledServicesFromSettings.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getPackageName(), TALKBACK_PACKAGE)) {
                    return true;
                }
            }
        }
        return false;
    }
}
