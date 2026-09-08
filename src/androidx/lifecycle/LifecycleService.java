package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: LifecycleService.kt */
/* loaded from: classes.dex */
public class LifecycleService extends Service implements InterfaceC0492o {

    /* renamed from: a, reason: collision with root package name */
    public final G f10291a = new G(this);

    @Override // androidx.lifecycle.InterfaceC0492o
    public Lifecycle getLifecycle() {
        return this.f10291a.a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        this.f10291a.b();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f10291a.c();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f10291a.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        this.f10291a.e();
        super.onStart(intent, i10);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
