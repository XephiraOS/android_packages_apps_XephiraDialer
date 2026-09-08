package androidx.core.view;

import android.content.Context;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public final PointerIcon f9426a;

    /* compiled from: PointerIconCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static PointerIcon a(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }
    }

    public C(PointerIcon pointerIcon) {
        this.f9426a = pointerIcon;
    }

    public static C b(Context context, int i10) {
        return new C(a.a(context, i10));
    }

    public Object a() {
        return this.f9426a;
    }
}
