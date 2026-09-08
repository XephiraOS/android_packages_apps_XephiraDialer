package com.android.contacts.voicemail.impl.scheduling;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.scheduling.e;
import com.android.contacts.voicemail.proguard.UsedByReflection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t1.C1580a;

@UsedByReflection
/* loaded from: classes.dex */
public abstract class BaseTask implements e {

    /* renamed from: i, reason: collision with root package name */
    public static Clock f18143i = new Clock();

    /* renamed from: a, reason: collision with root package name */
    public Bundle f18144a;

    /* renamed from: b, reason: collision with root package name */
    public Context f18145b;

    /* renamed from: c, reason: collision with root package name */
    public int f18146c;

    /* renamed from: d, reason: collision with root package name */
    public PhoneAccountHandle f18147d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f18148e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f18149f;

    /* renamed from: g, reason: collision with root package name */
    public final List<b> f18150g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public long f18151h = m();

    /* loaded from: classes.dex */
    public static class Clock {
        public long a() {
            return SystemClock.elapsedRealtime();
        }
    }

    public BaseTask(int i10) {
        this.f18146c = i10;
    }

    public static Intent h(Context context, Class<? extends BaseTask> cls, PhoneAccountHandle phoneAccountHandle) {
        Intent a10 = g.a(context, cls);
        a10.putExtra("extra_phone_account_handle", phoneAccountHandle);
        return a10;
    }

    public static void setClockForTesting(Clock clock) {
        f18143i = clock;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void b(e eVar) {
        Iterator<b> it = this.f18150g.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void c() {
        Iterator<b> it = this.f18150g.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f18148e = true;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public long d() {
        return this.f18151h - m();
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void e(Context context, Bundle bundle) {
        this.f18145b = context;
        this.f18144a = bundle;
        this.f18147d = (PhoneAccountHandle) bundle.getParcelable("extra_phone_account_handle");
        Iterator<b> it = this.f18150g.iterator();
        while (it.hasNext()) {
            it.next().d(this, bundle);
        }
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public Bundle f() {
        this.f18144a.putLong("extra_execution_time", this.f18151h);
        return this.f18144a;
    }

    public BaseTask g(b bVar) {
        C1580a.c();
        this.f18150g.add(bVar);
        return this;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public e.a getId() {
        return new e.a(this.f18146c, this.f18147d);
    }

    public Intent i() {
        return h(k(), getClass(), this.f18147d);
    }

    public void j() {
        C1580a.d();
        this.f18149f = true;
    }

    public Context k() {
        return this.f18145b;
    }

    public PhoneAccountHandle l() {
        return this.f18147d;
    }

    public long m() {
        return f18143i.a();
    }

    public boolean n() {
        C1580a.c();
        return this.f18149f;
    }

    public boolean o() {
        C1580a.c();
        return this.f18148e;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void onCompleted() {
        if (this.f18149f) {
            Iterator<b> it = this.f18150g.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        Iterator<b> it2 = this.f18150g.iterator();
        while (it2.hasNext()) {
            it2.next().onCompleted();
        }
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void onRestore(Bundle bundle) {
        if (this.f18144a.containsKey("extra_execution_time")) {
            this.f18151h = bundle.getLong("extra_execution_time");
        }
    }

    public void p(long j10) {
        C1580a.c();
        this.f18151h = j10;
    }

    public void q(int i10) {
        C1580a.c();
        this.f18146c = i10;
    }
}
