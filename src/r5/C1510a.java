package r5;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AFArraysUtils.java */
/* renamed from: r5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1510a {
    public static List<Long> a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }
}
