package S2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: NetworkResponse.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f3390a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3391b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f3392c;

    /* renamed from: d, reason: collision with root package name */
    public final List<c> f3393d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3394e;

    /* renamed from: f, reason: collision with root package name */
    public final long f3395f;

    @Deprecated
    public e(int i10, byte[] bArr, Map<String, String> map, boolean z10, long j10) {
        this(i10, bArr, map, a(map), z10, j10);
    }

    public static List<c> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new c(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> b(List<c> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (c cVar : list) {
            treeMap.put(cVar.a(), cVar.b());
        }
        return treeMap;
    }

    public e(int i10, byte[] bArr, boolean z10, long j10, List<c> list) {
        this(i10, bArr, b(list), list, z10, j10);
    }

    @Deprecated
    public e(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    public e(int i10, byte[] bArr, Map<String, String> map, List<c> list, boolean z10, long j10) {
        this.f3390a = i10;
        this.f3391b = bArr;
        this.f3392c = map;
        if (list == null) {
            this.f3393d = null;
        } else {
            this.f3393d = Collections.unmodifiableList(list);
        }
        this.f3394e = z10;
        this.f3395f = j10;
    }
}
