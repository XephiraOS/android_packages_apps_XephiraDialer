package com.google.i18n.phonenumbers.internal;

import com.heytap.accessory.constant.FastPairConstants;
import java.util.List;

/* compiled from: GeoEntityUtility.java */
/* loaded from: classes3.dex */
public final class a {
    public static boolean a(int i10) {
        List<String> list = L4.a.a().get(Integer.valueOf(i10));
        if (list != null && !list.contains(FastPairConstants.STATUS_CONNECT_RESULT_FAIL)) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        return !str.equals(FastPairConstants.STATUS_CONNECT_RESULT_FAIL);
    }
}
