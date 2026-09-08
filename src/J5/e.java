package J5;

import N5.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: PermissionTable.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f1597a;

    public e(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f1597a = copyOnWriteArrayList;
        copyOnWriteArrayList.clear();
        this.f1597a.addAll(h.c(str, ","));
    }

    public boolean a(String str) {
        if (this.f1597a.size() != 0) {
            return this.f1597a.contains(str);
        }
        return false;
    }
}
