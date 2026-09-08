package androidx.fragment.app;

import android.view.View;
import androidx.transition.C0502e;
import java.util.ArrayList;
import p.C1415a;

/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    public static final E f9890a = new D();

    /* renamed from: b, reason: collision with root package name */
    public static final E f9891b = b();

    public static void a(Fragment fragment, Fragment fragment2, boolean z10, C1415a<String, View> c1415a, boolean z11) {
        if (z10) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static E b() {
        try {
            return (E) C0502e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(C1415a<String, String> c1415a, C1415a<String, View> c1415a2) {
        for (int size = c1415a.size() - 1; size >= 0; size--) {
            if (!c1415a2.containsKey(c1415a.l(size))) {
                c1415a.j(size);
            }
        }
    }

    public static void d(ArrayList<View> arrayList, int i10) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i10);
        }
    }
}
