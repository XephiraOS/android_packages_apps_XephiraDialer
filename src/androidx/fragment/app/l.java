package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class l<E> extends i {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f10173a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f10174b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f10175c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10176d;

    /* renamed from: e, reason: collision with root package name */
    public final FragmentManager f10177e;

    public l(Context context, Handler handler, int i10) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i10);
    }

    @Override // androidx.fragment.app.i
    public View c(int i10) {
        return null;
    }

    @Override // androidx.fragment.app.i
    public boolean d() {
        return true;
    }

    public Activity e() {
        return this.f10173a;
    }

    public Context f() {
        return this.f10174b;
    }

    public Handler g() {
        return this.f10175c;
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f10174b);
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.content.b.k(this.f10174b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void n(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.app.a.v(this.f10173a, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public l(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public l(Activity activity, Context context, Handler handler, int i10) {
        this.f10177e = new u();
        this.f10173a = activity;
        this.f10174b = (Context) I.h.f(context, "context == null");
        this.f10175c = (Handler) I.h.f(handler, "handler == null");
        this.f10176d = i10;
    }

    public void o() {
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i10) {
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
