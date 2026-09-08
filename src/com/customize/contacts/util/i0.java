package com.customize.contacts.util;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import com.customize.contacts.widget.TouchSearchView;

/* compiled from: StatusBarClickUtils.java */
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: b, reason: collision with root package name */
    public static View f22128b;

    /* renamed from: c, reason: collision with root package name */
    public static TouchSearchView f22129c;

    /* renamed from: d, reason: collision with root package name */
    public static f0 f22130d;

    /* renamed from: a, reason: collision with root package name */
    public f0 f22131a = null;

    public static void b() {
        f0 f0Var = f22130d;
        if (f0Var != null) {
            f0Var.g();
        }
        f22130d = null;
    }

    public static void d(Activity activity, ListView listView) {
        if (H7.a.b()) {
            H7.b.b("StatusBarClickUtils", "onStatusBarClicked");
        }
        if (listView == null) {
            return;
        }
        if (activity != null && !activity.hasWindowFocus()) {
            return;
        }
        View view = f22128b;
        if (view != null && view.getVisibility() == 0) {
            return;
        }
        TouchSearchView touchSearchView = f22129c;
        if (touchSearchView != null) {
            touchSearchView.r();
        }
        if (f22130d == null) {
            f22130d = new f0(listView, 10, 600);
        }
        f22130d.e();
    }

    public static void e(View view) {
        f22128b = view;
    }

    public static void f(TouchSearchView touchSearchView) {
        f22129c = touchSearchView;
    }

    public void a() {
        f0 f0Var = this.f22131a;
        if (f0Var != null) {
            f0Var.g();
        }
        this.f22131a = null;
    }

    public void c(ListView listView) {
        if (this.f22131a == null) {
            this.f22131a = new f0(listView, 10, 600);
        }
        this.f22131a.e();
    }
}
