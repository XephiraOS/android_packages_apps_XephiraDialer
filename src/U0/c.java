package U0;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;

/* compiled from: AutoConfigAlertDialogFragment.kt */
/* loaded from: classes.dex */
public abstract class c extends DialogInterfaceOnCancelListenerC0472c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3803a = new a(null);

    /* compiled from: AutoConfigAlertDialogFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public abstract Dialog c1(Bundle bundle);

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Dialog dialog;
        Window window;
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        if (context != null && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
            window.setGravity(com.oplus.foundation.util.ui.b.c(context, newConfig));
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public final Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog c12 = c1(bundle);
        Context context = getContext();
        if (context != null && (window = c12.getWindow()) != null) {
            window.setGravity(com.oplus.foundation.util.ui.b.c(context, context.getResources().getConfiguration()));
        }
        return c12;
    }
}
