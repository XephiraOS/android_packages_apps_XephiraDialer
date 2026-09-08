package com.android.contacts.framework.baseui.util;

import android.content.Context;

/* compiled from: ModeUtils.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f15946a = new m();

    public static final boolean a(Context context) {
        try {
            if (G0.c.d(context, 1, "children_mode_on", 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            H7.b.c("ModeUtils", "isChildrenModeOn: exception = " + e10.getMessage());
            return false;
        }
    }
}
