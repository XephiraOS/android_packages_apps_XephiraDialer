package n8;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import q8.h;

/* compiled from: PermissionTable.java */
/* renamed from: n8.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1379d {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f35643a;

    public C1379d(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f35643a = copyOnWriteArrayList;
        copyOnWriteArrayList.clear();
        this.f35643a.addAll(h.c(str, ","));
    }

    public boolean a(String str) {
        if (this.f35643a.size() != 0) {
            return this.f35643a.contains(str);
        }
        return false;
    }
}
