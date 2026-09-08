package U6;

import S6.c;
import android.widget.AbsListView;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.widget.AbsListViewWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import com.oplus.utils.reflect.RefObject;

/* compiled from: AbsListViewNative.java */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: AbsListViewNative.java */
    /* renamed from: U6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0072a {
        private static RefMethod<Integer> getTouchMode;
        private static RefMethod<Void> oplusStartSpringback;
        private static RefMethod<Void> setOplusFlingMode;

        static {
            RefClass.load((Class<?>) C0072a.class, "android.widget.IAbsListviewExt");
        }
    }

    /* compiled from: AbsListViewNative.java */
    /* loaded from: classes3.dex */
    public static class b {
        private static RefMethod<Integer> getTouchMode;
        private static RefObject<Object> mAbsListviewExt;

        static {
            RefClass.load((Class<?>) b.class, (Class<?>) AbsListView.class);
        }
    }

    @Deprecated
    public static void a(AbsListView absListView, int i10) {
        if (c.n()) {
            C0072a.setOplusFlingMode.call(b.mAbsListviewExt.get(absListView), Integer.valueOf(i10));
        } else {
            if (c.m()) {
                if (c.j()) {
                    AbsListViewWrapper.setOplusFlingMode(absListView, i10);
                    return;
                } else {
                    c(absListView, i10);
                    return;
                }
            }
            if (c.l()) {
                b(absListView, i10);
                return;
            }
            throw new UnSupportedApiVersionException("not supported before Q");
        }
    }

    public static void b(AbsListView absListView, int i10) {
        U6.b.a(absListView, i10);
    }

    public static void c(AbsListView absListView, int i10) {
        U6.b.b(absListView, i10);
    }
}
