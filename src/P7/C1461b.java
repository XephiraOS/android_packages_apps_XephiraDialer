package p7;

import android.database.Cursor;
import java.util.Set;
import kotlin.collections.K;
import kotlin.jvm.internal.f;

/* compiled from: CursorSelectedDataUiState.kt */
/* renamed from: p7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1461b<E> extends C1463d<E> {

    /* renamed from: g, reason: collision with root package name */
    public final Cursor f36085g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f36086h;

    /* renamed from: i, reason: collision with root package name */
    public final Set<E> f36087i;

    /* renamed from: j, reason: collision with root package name */
    public final Set<E> f36088j;

    /* renamed from: k, reason: collision with root package name */
    public final int f36089k;

    public C1461b() {
        this(null, false, null, null, 15, null);
    }

    @Override // p7.C1463d
    public int b() {
        return this.f36089k;
    }

    public final Cursor f() {
        return this.f36085g;
    }

    public /* synthetic */ C1461b(Cursor cursor, boolean z10, Set set, Set set2, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : cursor, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? K.b() : set, (i10 & 8) != 0 ? K.b() : set2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1461b(android.database.Cursor r10, boolean r11, java.util.Set<? extends E> r12, java.util.Set<? extends E> r13) {
        /*
            r9 = this;
            java.lang.String r0 = "notSelectedItemsInMarkAll"
            kotlin.jvm.internal.i.f(r12, r0)
            java.lang.String r0 = "selectedItems"
            kotlin.jvm.internal.i.f(r13, r0)
            java.util.List r2 = kotlin.collections.m.h()
            r7 = 16
            r8 = 0
            r6 = 0
            r1 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.f36085g = r10
            r9.f36086h = r11
            r9.f36087i = r12
            r9.f36088j = r13
            int r10 = com.oplus.foundation.util.io.b.a(r10)
            r9.f36089k = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.C1461b.<init>(android.database.Cursor, boolean, java.util.Set, java.util.Set):void");
    }
}
