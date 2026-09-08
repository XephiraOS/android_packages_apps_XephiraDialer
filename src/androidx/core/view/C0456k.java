package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* compiled from: KeyEventDispatcher.java */
/* renamed from: androidx.core.view.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0456k {

    /* compiled from: KeyEventDispatcher.java */
    /* renamed from: androidx.core.view.k$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return K.g(view, keyEvent);
    }

    public static boolean b(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return aVar.superDispatchKeyEvent(keyEvent);
    }
}
