package com.oplus.epona;

import com.oplus.os.OplusBuild;

/* compiled from: VersionUtils.java */
/* loaded from: classes3.dex */
public class k {
    public static boolean a() {
        try {
            if (OplusBuild.getOplusOSVERSION() < 22) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
