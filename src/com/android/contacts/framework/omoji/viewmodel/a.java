package com.android.contacts.framework.omoji.viewmodel;

import e1.C0964a;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: OmojiData.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16310a;

    /* renamed from: b, reason: collision with root package name */
    public List<C0964a.C0293a> f16311b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public final List<C0964a.C0293a> a() {
        return this.f16311b;
    }

    public final boolean b() {
        return this.f16310a;
    }

    public final void c(boolean z10) {
        this.f16310a = z10;
    }

    public final void d(List<C0964a.C0293a> list) {
        this.f16311b = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f16310a == aVar.f16310a && i.b(this.f16311b, aVar.f16311b)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        int hashCode;
        boolean z10 = this.f16310a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        List<C0964a.C0293a> list = this.f16311b;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return i10 + hashCode;
    }

    public String toString() {
        return "OmojiData(isFull=" + this.f16310a + ", omojiList=" + this.f16311b + ")";
    }

    public a(boolean z10, List<C0964a.C0293a> list) {
        this.f16310a = z10;
        this.f16311b = list;
    }

    public /* synthetic */ a(boolean z10, List list, int i10, f fVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : list);
    }
}
