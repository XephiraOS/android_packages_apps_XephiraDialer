package com.oplus.contacts.config.defaultdialer;

import C7.e;
import H7.b;
import android.app.Activity;
import android.content.Intent;
import com.android.contacts.framework.api.setdefault.SetDefaultApi;
import com.oplus.contacts.config.defaultdialer.actvity.SetDefaultDialerActivity;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: SetDefaultImpl.kt */
/* loaded from: classes3.dex */
public final class SetDefaultImpl implements SetDefaultApi {

    /* renamed from: e, reason: collision with root package name */
    public static final a f27800e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final d<SetDefaultImpl> f27801f;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f27802b;

    /* renamed from: c, reason: collision with root package name */
    public long f27803c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<SetDefaultDialerActivity> f27804d;

    /* compiled from: SetDefaultImpl.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final SetDefaultImpl a() {
            return (SetDefaultImpl) SetDefaultImpl.f27801f.getValue();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        d<SetDefaultImpl> b10;
        b10 = kotlin.a.b(new InterfaceC1637a<SetDefaultImpl>() { // from class: com.oplus.contacts.config.defaultdialer.SetDefaultImpl$Companion$instance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SetDefaultImpl invoke() {
                return new SetDefaultImpl();
            }
        });
        f27801f = b10;
    }

    @Override // com.android.contacts.framework.api.setdefault.SetDefaultApi
    public boolean a(Activity activity) {
        SetDefaultDialerActivity setDefaultDialerActivity;
        i.f(activity, "activity");
        if (!d(activity)) {
            b.e("SetDefaultImpl", "needStartSetDefault isDialerRoleAvailable false");
            return false;
        }
        String a10 = P7.d.a(activity);
        if (!i.b(activity.getPackageName(), a10)) {
            Intent intent = activity.getIntent();
            if (!intent.getBooleanExtra("has_checked", false)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f27803c) > 500) {
                    WeakReference<SetDefaultDialerActivity> weakReference = this.f27804d;
                    if (weakReference != null && (setDefaultDialerActivity = weakReference.get()) != null && !setDefaultDialerActivity.isFinishing()) {
                        setDefaultDialerActivity.finish();
                    }
                    Intent intent2 = new Intent(activity, (Class<?>) SetDefaultDialerActivity.class);
                    intent.putExtra("has_checked", true);
                    intent2.putExtra("previous_intent", intent);
                    intent2.setFlags(268468224);
                    R7.b.f(activity, intent2, 0, null, 6, null);
                    e.b(activity);
                    this.f27803c = currentTimeMillis;
                    b.e("SetDefaultImpl", "needStartSetDefault start activity");
                }
                b.e("SetDefaultImpl", "needStartSetDefault return true");
                return true;
            }
        } else {
            b.e("SetDefaultImpl", "needStartSetDefault defaultDialerPackage: " + a10);
        }
        return false;
    }

    @Override // com.android.contacts.framework.api.setdefault.SetDefaultApi
    public void b(Activity activity) {
        i.f(activity, "activity");
        if (!d(activity)) {
            b.e("SetDefaultImpl", "checkDefaultDialer isDialerRoleAvailable false");
            return;
        }
        String a10 = P7.d.a(activity);
        if (!i.b(activity.getPackageName(), a10)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f27803c) > 500) {
                C0.b.f319a.a(activity);
                Intent intent = new Intent(activity, (Class<?>) SetDefaultDialerActivity.class);
                intent.setFlags(268468224);
                R7.b.f(activity, intent, 0, null, 6, null);
                this.f27803c = currentTimeMillis;
                b.e("SetDefaultImpl", "checkDefaultDialer start activity");
            }
            b.e("SetDefaultImpl", "checkDefaultDialer finish activity");
            return;
        }
        b.e("SetDefaultImpl", "checkDefaultDialer defaultDialerPackage: " + a10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r3.isRoleAvailable("android.app.role.DIALER") == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.Boolean r0 = r2.f27802b
            r1 = 0
            if (r0 != 0) goto L20
            java.lang.Class<android.app.role.RoleManager> r0 = android.app.role.RoleManager.class
            java.lang.Object r3 = r3.getSystemService(r0)
            android.app.role.RoleManager r3 = (android.app.role.RoleManager) r3
            if (r3 == 0) goto L19
            java.lang.String r0 = "android.app.role.DIALER"
            boolean r3 = r3.isRoleAvailable(r0)
            r0 = 1
            if (r3 != r0) goto L19
            goto L1a
        L19:
            r0 = r1
        L1a:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            r2.f27802b = r3
        L20:
            java.lang.Boolean r2 = r2.f27802b
            if (r2 == 0) goto L28
            boolean r1 = r2.booleanValue()
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.config.defaultdialer.SetDefaultImpl.d(android.content.Context):boolean");
    }

    public final void e(SetDefaultDialerActivity activity) {
        i.f(activity, "activity");
        this.f27804d = new WeakReference<>(activity);
    }

    public final void f(Activity activity) {
        i.f(activity, "activity");
        Intent intent = (Intent) activity.getIntent().getParcelableExtra("previous_intent", Intent.class);
        if (intent != null) {
            R7.b.f(activity, intent, 0, null, 6, null);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.DIAL");
        intent2.setPackage(activity.getPackageName());
        R7.b.f(activity, intent2, 0, null, 6, null);
    }
}
