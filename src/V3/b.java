package V3;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewHeightSetter.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public View f4005a;

    public b(View view) {
        this.f4005a = view;
    }

    public int a() {
        View view = this.f4005a;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public void b(int i10) {
        View view = this.f4005a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i10;
            this.f4005a.setLayoutParams(layoutParams);
        }
    }
}
