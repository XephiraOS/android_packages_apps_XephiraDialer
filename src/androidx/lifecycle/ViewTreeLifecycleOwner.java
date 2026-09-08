package androidx.lifecycle;

import android.view.View;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: ViewTreeLifecycleOwner.kt */
/* loaded from: classes.dex */
public final class ViewTreeLifecycleOwner {
    public static final InterfaceC0492o a(View view) {
        kotlin.sequences.e d10;
        kotlin.sequences.e n10;
        Object k10;
        kotlin.jvm.internal.i.f(view, "<this>");
        d10 = SequencesKt__SequencesKt.d(view, new v9.l<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final View invoke(View currentView) {
                kotlin.jvm.internal.i.f(currentView, "currentView");
                Object parent = currentView.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        });
        n10 = SequencesKt___SequencesKt.n(d10, new v9.l<View, InterfaceC0492o>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InterfaceC0492o invoke(View viewParent) {
                kotlin.jvm.internal.i.f(viewParent, "viewParent");
                Object tag = viewParent.getTag(U.a.f3791a);
                if (tag instanceof InterfaceC0492o) {
                    return (InterfaceC0492o) tag;
                }
                return null;
            }
        });
        k10 = SequencesKt___SequencesKt.k(n10);
        return (InterfaceC0492o) k10;
    }

    public static final void b(View view, InterfaceC0492o interfaceC0492o) {
        kotlin.jvm.internal.i.f(view, "<this>");
        view.setTag(U.a.f3791a, interfaceC0492o);
    }
}
