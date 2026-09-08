package V3;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewTopMarginSetter.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public List<WeakReference<View>> f4006a;

    public static void d(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i10;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public c a(View view) {
        b();
        this.f4006a.add(new WeakReference<>(view));
        return this;
    }

    public final void b() {
        if (this.f4006a == null) {
            this.f4006a = new ArrayList();
        }
    }

    public void c(int i10) {
        List<WeakReference<View>> list = this.f4006a;
        if (list != null && !list.isEmpty()) {
            for (WeakReference<View> weakReference : this.f4006a) {
                if (weakReference != null && weakReference.get() != null) {
                    d(weakReference.get(), i10);
                }
            }
        }
    }
}
