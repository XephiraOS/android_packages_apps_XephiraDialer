package com.customize.contacts.util;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.X;
import com.android.contacts.ContactsApplication;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;

/* loaded from: classes3.dex */
public class SoftKeyboardUtil {

    /* renamed from: a, reason: collision with root package name */
    public static SoftKeyboardUtil f21942a;

    /* renamed from: b, reason: collision with root package name */
    public static InputMethodManager f21943b;

    public SoftKeyboardUtil(Context context) {
        f21943b = (InputMethodManager) context.getSystemService("input_method");
    }

    public static SoftKeyboardUtil a() {
        if (f21942a == null) {
            f21942a = new SoftKeyboardUtil(ContactsApplication.h().getApplicationContext());
        }
        return f21942a;
    }

    public void b(View view) {
        if (view != null) {
            try {
                InputMethodManager inputMethodManager = f21943b;
                if (inputMethodManager != null && inputMethodManager.isActive()) {
                    e("hideSoftKeyboard");
                    f21943b.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            } catch (Exception e10) {
                H7.b.b("SoftKeyboardUtil", "hideSoftInputFromWindow error." + e10);
            }
        }
    }

    public void c(View view, final Runnable runnable) {
        if (view == null) {
            e("view is null");
            return;
        }
        if (!d(view)) {
            e("softKeyboard is not visible");
            runnable.run();
            return;
        }
        try {
            InputMethodManager inputMethodManager = f21943b;
            if (inputMethodManager != null && inputMethodManager.isActive()) {
                e("hideSoftKeyboard");
                f21943b.hideSoftInputFromWindow(view.getWindowToken(), 0, new ResultReceiver(ThreadUtilsKt.a()) { // from class: com.customize.contacts.util.SoftKeyboardUtil.1
                    @Override // android.os.ResultReceiver
                    public void onReceiveResult(int i10, Bundle bundle) {
                        super.onReceiveResult(i10, bundle);
                        ThreadUtilsKt.c(runnable, 200L);
                    }
                });
            } else {
                runnable.run();
            }
        } catch (Exception e10) {
            runnable.run();
            H7.b.b("SoftKeyboardUtil", "hideSoftInputFromWindow error." + e10);
        }
    }

    public boolean d(View view) {
        return androidx.core.view.X.x(view.getRootWindowInsets()).r(X.k.a());
    }

    public final void e(String str) {
        if (H7.a.b()) {
            H7.b.b("SoftKeyboardUtil", str);
        }
    }

    public void f(View view) {
        String message;
        if (view != null) {
            try {
                e("showSoftKeyboard");
                f21943b.showSoftInput(view, 0, null);
            } catch (Exception e10) {
                if (e10.getMessage() == null) {
                    message = "";
                } else {
                    message = e10.getMessage();
                }
                H7.b.b("showSoftKeyboard error", message);
                H7.b.c("SoftKeyboardUtil", "Exception e: " + e10);
            }
        }
    }
}
