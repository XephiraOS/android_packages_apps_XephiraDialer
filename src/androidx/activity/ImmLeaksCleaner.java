package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements InterfaceC0489l {

    /* renamed from: b, reason: collision with root package name */
    public static int f7073b;

    /* renamed from: c, reason: collision with root package name */
    public static Field f7074c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f7075d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f7076e;

    /* renamed from: a, reason: collision with root package name */
    public Activity f7077a;

    public static void a() {
        try {
            f7073b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f7075d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f7076e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f7074c = declaredField3;
            declaredField3.setAccessible(true);
            f7073b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f7073b == 0) {
            a();
        }
        if (f7073b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f7077a.getSystemService("input_method");
            try {
                Object obj = f7074c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f7075d.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f7076e.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
