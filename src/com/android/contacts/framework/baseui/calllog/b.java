package com.android.contacts.framework.baseui.calllog;

import Q0.d;
import android.database.Cursor;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallLogGroupHandler.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: l, reason: collision with root package name */
    public static final a f15771l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public boolean f15772a;

    /* renamed from: c, reason: collision with root package name */
    public int f15774c;

    /* renamed from: e, reason: collision with root package name */
    public long f15776e;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15781j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15782k;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15773b = true;

    /* renamed from: d, reason: collision with root package name */
    public SparseIntArray f15775d = new SparseIntArray();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<Q0.b> f15777f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap<String, Q0.b> f15778g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public final List<Integer> f15779h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final List<Q0.b> f15780i = new ArrayList();

    /* compiled from: CallLogGroupHandler.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CallLogGroupHandler.kt */
    /* renamed from: com.android.contacts.framework.baseui.calllog.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0164b extends j.b {
        public C0164b() {
        }

        @Override // androidx.recyclerview.widget.j.b
        public boolean a(int i10, int i11) {
            Object y10;
            Object y11;
            if (!b.this.q() || i11 != b.this.j() - 1) {
                y10 = CollectionsKt___CollectionsKt.y(g(), i10);
                y11 = CollectionsKt___CollectionsKt.y(f(), i11);
                return i.b(y10, y11);
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.j.b
        public boolean b(int i10, int i11) {
            Object y10;
            Object y11;
            y10 = CollectionsKt___CollectionsKt.y(g(), i10);
            y11 = CollectionsKt___CollectionsKt.y(f(), i11);
            if (y10 == y11) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.j.b
        public int d() {
            return f().size();
        }

        @Override // androidx.recyclerview.widget.j.b
        public int e() {
            return g().size();
        }

        public final List<Q0.b> f() {
            if (b.this.q()) {
                return b.this.o();
            }
            return b.this.g();
        }

        public final List<Q0.b> g() {
            if (b.this.q()) {
                return b.this.g();
            }
            return b.this.o();
        }
    }

    public final void b(int i10, int i11) {
        int size = this.f15775d.size() - 1;
        if (size >= 0 && i10 > this.f15775d.keyAt(size)) {
            this.f15775d.append(i10, i11);
        } else {
            this.f15775d.put(i10, i11);
        }
    }

    public final boolean c(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return false;
    }

    public final int d(int i10) {
        Q0.b bVar;
        int indexOf;
        Object y10;
        ArrayList<Q0.d> a10;
        Object x10;
        Object y11;
        ArrayList<Q0.d> a11;
        Object x11;
        int size = this.f15777f.size();
        int i11 = i10;
        while (true) {
            if (i11 < size) {
                y11 = CollectionsKt___CollectionsKt.y(this.f15777f, i11);
                Q0.b bVar2 = (Q0.b) y11;
                if (bVar2 != null && (a11 = bVar2.a()) != null) {
                    x11 = CollectionsKt___CollectionsKt.x(a11);
                    Q0.d dVar = (Q0.d) x11;
                    if (dVar != null && dVar.f()) {
                        bVar = this.f15777f.get(i11);
                        break;
                    }
                }
                i11++;
            } else {
                bVar = null;
                break;
            }
        }
        if (bVar == null) {
            while (true) {
                if (-1 >= i10) {
                    break;
                }
                y10 = CollectionsKt___CollectionsKt.y(this.f15777f, i10);
                Q0.b bVar3 = (Q0.b) y10;
                if (bVar3 != null && (a10 = bVar3.a()) != null) {
                    x10 = CollectionsKt___CollectionsKt.x(a10);
                    Q0.d dVar2 = (Q0.d) x10;
                    if (dVar2 != null && dVar2.f()) {
                        bVar = this.f15777f.get(i10);
                        break;
                    }
                }
                i10--;
            }
        }
        if (bVar == null || (indexOf = this.f15780i.indexOf(bVar)) == -1) {
            return 0;
        }
        return indexOf;
    }

    public final void e(Cursor cursor) {
        f(cursor, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.database.Cursor r19, int r20) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.calllog.b.f(android.database.Cursor, int):void");
    }

    public final ArrayList<Q0.b> g() {
        return this.f15777f;
    }

    public final HashMap<String, Q0.b> h() {
        return this.f15778g;
    }

    public final int i(int i10) {
        Object y10;
        ArrayList<Q0.d> a10;
        Object y11;
        ArrayList<Q0.d> a11;
        if (q()) {
            y11 = CollectionsKt___CollectionsKt.y(this.f15780i, i10);
            Q0.b bVar = (Q0.b) y11;
            if (bVar == null || (a11 = bVar.a()) == null) {
                return 0;
            }
            return a11.size();
        }
        y10 = CollectionsKt___CollectionsKt.y(this.f15777f, i10);
        Q0.b bVar2 = (Q0.b) y10;
        if (bVar2 == null || (a10 = bVar2.a()) == null) {
            return 0;
        }
        return a10.size();
    }

    public final int j() {
        if (q()) {
            return this.f15779h.size();
        }
        return this.f15774c;
    }

    public final int k(int i10) {
        Object y10;
        if (this.f15782k) {
            return i10;
        }
        if (q()) {
            y10 = CollectionsKt___CollectionsKt.y(this.f15779h, i10);
            Integer num = (Integer) y10;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        if (i10 >= 0 && i10 < this.f15775d.size()) {
            return this.f15775d.keyAt(i10);
        }
        return -1;
    }

    public final j.b l() {
        return new C0164b();
    }

    public final boolean m() {
        return this.f15781j;
    }

    public final long n() {
        return this.f15776e;
    }

    public final List<Q0.b> o() {
        return this.f15780i;
    }

    public final boolean p() {
        return this.f15782k;
    }

    public final boolean q() {
        if (this.f15781j && !this.f15782k) {
            return true;
        }
        return false;
    }

    public final Q0.b r(Cursor cursor) {
        return Q0.b.f3095g.a(cursor, 1, 9, 7, 16, 6);
    }

    public final void s() {
        this.f15774c = 0;
        this.f15776e = 0L;
        this.f15777f.clear();
        this.f15778g.clear();
        this.f15779h.clear();
        this.f15780i.clear();
        this.f15772a = false;
        this.f15773b = true;
        this.f15775d.clear();
    }

    public final void t(boolean z10) {
        this.f15781j = z10;
    }

    public final Q0.d u(Cursor cursor, int i10) {
        Integer num;
        d.a aVar = Q0.d.f3114f;
        if (i10 >= 0) {
            num = Integer.valueOf(i10);
        } else {
            num = null;
        }
        return aVar.a(cursor, 0, 2, 4, 15, num);
    }
}
