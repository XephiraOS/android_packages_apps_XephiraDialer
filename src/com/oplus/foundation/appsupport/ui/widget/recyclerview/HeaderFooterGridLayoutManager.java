package com.oplus.foundation.appsupport.ui.widget.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.jvm.internal.i;
import x7.C1687d;

/* compiled from: HeaderFooterGridLayoutManager.kt */
/* loaded from: classes3.dex */
public final class HeaderFooterGridLayoutManager extends GridLayoutManager {

    /* renamed from: j, reason: collision with root package name */
    public C1687d f28257j;

    /* compiled from: HeaderFooterGridLayoutManager.kt */
    /* loaded from: classes3.dex */
    public static final class a extends GridLayoutManager.b {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int i10) {
            C1687d c1687d = HeaderFooterGridLayoutManager.this.f28257j;
            if (c1687d != null) {
                HeaderFooterGridLayoutManager headerFooterGridLayoutManager = HeaderFooterGridLayoutManager.this;
                if (!c1687d.y(i10) && !c1687d.x(i10)) {
                    return headerFooterGridLayoutManager.z(i10 - c1687d.t());
                }
                return headerFooterGridLayoutManager.o();
            }
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderFooterGridLayoutManager(Context context, int i10, C1687d c1687d) {
        super(context, i10);
        i.f(context, "context");
        this.f28257j = c1687d;
        A();
    }

    public final void A() {
        super.w(new a());
    }

    public final int z(int i10) {
        return 1;
    }
}
