package com.android.contacts.voicemail.impl.scheduling;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.c;

/* compiled from: RetryPolicy.java */
/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final int f18178a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18179b;

    /* renamed from: c, reason: collision with root package name */
    public BaseTask f18180c;

    /* renamed from: d, reason: collision with root package name */
    public int f18181d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f18182e;

    /* renamed from: f, reason: collision with root package name */
    public c.a f18183f;

    public d(int i10, int i11) {
        this.f18178a = i10;
        this.f18179b = i11;
    }

    public c.b a() {
        return this.f18183f;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void b() {
        this.f18182e = true;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void d(BaseTask baseTask, Bundle bundle) {
        this.f18180c = baseTask;
        int i10 = bundle.getInt("extra_retry_count", 0);
        this.f18181d = i10;
        if (i10 > 0) {
            H7.b.e("RetryPolicy", "retry #" + this.f18181d + " for " + this.f18180c + " queued, executing in " + this.f18179b);
            BaseTask baseTask2 = this.f18180c;
            baseTask2.p(baseTask2.m() + ((long) this.f18179b));
        }
        PhoneAccountHandle l10 = baseTask.l();
        if (l10 == null) {
            H7.b.c("RetryPolicy", "null phone account for phoneAccountHandle " + baseTask.l());
        }
        this.f18183f = com.android.contacts.voicemail.impl.c.a(baseTask.k(), l10);
    }

    public final boolean f() {
        if (this.f18181d < this.f18178a) {
            return true;
        }
        return false;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void onCompleted() {
        if (this.f18182e && f()) {
            H7.b.e("RetryPolicy", "discarding deferred status: " + this.f18183f.c());
            Intent i10 = this.f18180c.i();
            i10.putExtra("extra_retry_count", this.f18181d + 1);
            this.f18180c.k().sendBroadcast(i10);
            return;
        }
        if (!this.f18182e) {
            H7.b.e("RetryPolicy", this.f18180c + " completed successfully");
        }
        if (!f()) {
            H7.b.e("RetryPolicy", "Retry limit for " + this.f18180c + " reached");
        }
        H7.b.e("RetryPolicy", "committing deferred status: " + this.f18183f.c());
        this.f18183f.i();
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void c() {
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void e() {
    }
}
