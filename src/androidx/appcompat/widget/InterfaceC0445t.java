package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* compiled from: DecorToolbar.java */
/* renamed from: androidx.appcompat.widget.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0445t {
    void a(Menu menu, MenuPresenter.Callback callback);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(D d10);

    boolean j();

    void k(int i10);

    Menu l();

    void m(int i10);

    int n();

    androidx.core.view.Q o(int i10, long j10);

    void p(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    ViewGroup q();

    void r(boolean z10);

    int s();

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i10);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u();

    void v(boolean z10);
}
