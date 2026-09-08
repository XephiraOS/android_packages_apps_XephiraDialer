package androidx.transition;

import android.view.ViewGroup;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class G {

    /* compiled from: ViewGroupUtils.java */
    /* loaded from: classes.dex */
    public static class a {
        public static int a(ViewGroup viewGroup, int i10) {
            return viewGroup.getChildDrawingOrder(i10);
        }

        public static void b(ViewGroup viewGroup, boolean z10) {
            viewGroup.suppressLayout(z10);
        }
    }

    public static int a(ViewGroup viewGroup, int i10) {
        return a.a(viewGroup, i10);
    }

    public static void b(ViewGroup viewGroup, boolean z10) {
        a.b(viewGroup, z10);
    }
}
