package com.customize.contacts.activities;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ContactsTabActivityFragmentManager.kt */
/* loaded from: classes3.dex */
public final class L {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20400b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List<b> f20401a;

    /* compiled from: ContactsTabActivityFragmentManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ContactsTabActivityFragmentManager.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f20402a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f20403b;

        /* renamed from: c, reason: collision with root package name */
        public com.customize.contacts.delayload.b f20404c;

        public b(int i10, boolean z10, com.customize.contacts.delayload.b fragmentAdapter) {
            kotlin.jvm.internal.i.f(fragmentAdapter, "fragmentAdapter");
            this.f20402a = i10;
            this.f20403b = z10;
            this.f20404c = fragmentAdapter;
        }

        public final Fragment a() {
            Fragment a10 = this.f20404c.a();
            kotlin.jvm.internal.i.e(a10, "fragmentAdapter.fragment");
            return a10;
        }

        public final com.customize.contacts.delayload.b b() {
            return this.f20404c;
        }

        public final int c() {
            return this.f20402a;
        }

        public final boolean d() {
            return this.f20403b;
        }

        public final void e(com.customize.contacts.delayload.b bVar) {
            kotlin.jvm.internal.i.f(bVar, "<set-?>");
            this.f20404c = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f20402a == bVar.f20402a && this.f20403b == bVar.f20403b && kotlin.jvm.internal.i.b(this.f20404c, bVar.f20404c)) {
                return true;
            }
            return false;
        }

        public final void f(boolean z10) {
            this.f20403b = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Integer.hashCode(this.f20402a) * 31;
            boolean z10 = this.f20403b;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return ((hashCode + i10) * 31) + this.f20404c.hashCode();
        }

        public String toString() {
            return "FragmentInfo(tabIndex=" + this.f20402a + ", visible=" + this.f20403b + ", fragmentAdapter=" + this.f20404c + ")";
        }
    }

    public L() {
        ArrayList arrayList = new ArrayList();
        this.f20401a = arrayList;
        arrayList.add(new b(0, false, new com.customize.contacts.delayload.b()));
        arrayList.add(new b(1, false, new com.customize.contacts.delayload.b()));
        arrayList.add(new b(2, false, new com.customize.contacts.delayload.b()));
        arrayList.add(new b(3, false, new com.customize.contacts.delayload.b()));
    }

    public final List<b> a() {
        return this.f20401a;
    }

    public final Fragment b(int i10) {
        Fragment fragment;
        com.customize.contacts.delayload.b b10;
        b d10 = d(i10);
        if (d10 != null && (b10 = d10.b()) != null) {
            fragment = b10.a();
        } else {
            fragment = null;
        }
        if (fragment == null) {
            H7.b.i("ContactsTabActivityFragmentManager", "can not found fragment for " + i10 + ", visibleCount:" + h());
            return new com.customize.contacts.delayload.a();
        }
        return fragment;
    }

    public final b c(int i10) {
        Object obj;
        Iterator<T> it = a().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((b) obj).c() == i10) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (b) obj;
    }

    public final b d(int i10) {
        int i11 = 0;
        for (b bVar : a()) {
            if (bVar.d() && (i11 = i11 + 1) >= i10 + 1) {
                return bVar;
            }
        }
        H7.b.i("ContactsTabActivityFragmentManager", "getFragmentInfoByPagerIndex error for pagerIndex:" + i10 + ", visibleCount:" + h());
        return null;
    }

    public final int e(Object obj) {
        kotlin.jvm.internal.i.f(obj, "obj");
        if (!(obj instanceof Fragment)) {
            H7.b.i("ContactsTabActivityFragmentManager", "obj not a fragment:" + obj);
            return -1;
        }
        int i10 = -1;
        for (b bVar : a()) {
            if (bVar.d()) {
                i10++;
                if (kotlin.jvm.internal.i.b(bVar.a(), obj)) {
                    return i10;
                }
            }
        }
        H7.b.i("ContactsTabActivityFragmentManager", "getPageIndexByFragment error for obj:" + obj);
        return -1;
    }

    public final int f(int i10) {
        int i11 = -1;
        for (b bVar : a()) {
            if (bVar.d()) {
                i11++;
                if (i10 == bVar.c()) {
                    return i11;
                }
            }
        }
        H7.b.i("ContactsTabActivityFragmentManager", "getPageIndexByTabIndex error for tabIndex:" + i10 + ", visibleCount:" + h());
        return -1;
    }

    public final int g(int i10) {
        b d10 = d(i10);
        if (d10 != null) {
            return d10.c();
        }
        H7.b.i("ContactsTabActivityFragmentManager", "getTabIndexByPageIndex error for pageIndex:" + i10 + ", visibleCount:" + h());
        return -1;
    }

    public final int h() {
        List<b> a10 = a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a10) {
            if (((b) obj).d()) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }
}
