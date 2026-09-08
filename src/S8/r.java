package S8;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewWidthSetter.java */
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public View f3607a;

    public r(View view) {
        this.f3607a = view;
    }

    public void a(int i10) {
        View view = this.f3607a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i10;
            this.f3607a.setLayoutParams(layoutParams);
        }
    }
}
