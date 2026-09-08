package p4;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper.java */
/* renamed from: p4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1440b {

    /* renamed from: a, reason: collision with root package name */
    public final View f36011a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36012b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f36013c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public C1440b(InterfaceC1439a interfaceC1439a) {
        this.f36011a = (View) interfaceC1439a;
    }

    public final void a() {
        ViewParent parent = this.f36011a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).j(this.f36011a);
        }
    }

    public int b() {
        return this.f36013c;
    }

    public boolean c() {
        return this.f36012b;
    }

    public void d(Bundle bundle) {
        this.f36012b = bundle.getBoolean("expanded", false);
        this.f36013c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f36012b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f36012b);
        bundle.putInt("expandedComponentIdHint", this.f36013c);
        return bundle;
    }

    public void f(int i10) {
        this.f36013c = i10;
    }
}
