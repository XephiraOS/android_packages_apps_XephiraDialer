package com.oplus.epona;

import android.content.Context;

/* compiled from: PermissionCheck.java */
/* loaded from: classes3.dex */
public class g implements e {
    @Override // com.oplus.epona.e
    public boolean a(Context context) {
        if (context == null || context.checkCallingPermission("com.oplus.permission.safe.SECURITY") != 0) {
            return false;
        }
        return true;
    }
}
