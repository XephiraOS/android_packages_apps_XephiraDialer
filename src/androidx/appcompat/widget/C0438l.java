package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: AppCompatPopupWindow.java */
/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0438l extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f7874b = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7875a;

    public C0438l(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    public final void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        K w10 = K.w(context, attributeSet, e.j.f30458i2, i10, i11);
        int i12 = e.j.f30468k2;
        if (w10.s(i12)) {
            b(w10.a(i12, false));
        }
        setBackgroundDrawable(w10.g(e.j.f30463j2));
        w10.y();
    }

    public final void b(boolean z10) {
        if (f7874b) {
            this.f7875a = z10;
        } else {
            androidx.core.widget.j.a(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (f7874b && this.f7875a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f7874b && this.f7875a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f7874b && this.f7875a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
