package U6;

import android.widget.AbsListView;
import com.color.inner.widget.AbsListViewWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* compiled from: AbsListViewNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class b {

    /* compiled from: AbsListViewNativeOplusCompat.java */
    /* loaded from: classes3.dex */
    public static class a {
        private static RefMethod<Void> colorStartSpringback;
        private static RefMethod<Void> setOppoFlingMode;

        static {
            RefClass.load((Class<?>) a.class, (Class<?>) AbsListViewWrapper.class);
        }
    }

    public static void a(AbsListView absListView, int i10) {
        a.setOppoFlingMode.call(null, absListView, Integer.valueOf(i10));
    }

    public static void b(AbsListView absListView, int i10) {
        AbsListViewWrapper.setOplusFlingMode(absListView, i10);
    }
}
