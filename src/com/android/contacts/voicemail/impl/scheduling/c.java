package com.android.contacts.voicemail.impl.scheduling;

import android.os.Bundle;

/* compiled from: PostponePolicy.java */
/* loaded from: classes.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final int f18176a;

    /* renamed from: b, reason: collision with root package name */
    public BaseTask f18177b;

    public c(int i10) {
        this.f18176a = i10;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void d(BaseTask baseTask, Bundle bundle) {
        this.f18177b = baseTask;
        baseTask.p(baseTask.m() + this.f18176a);
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void e() {
        if (this.f18177b.o()) {
            return;
        }
        H7.b.e("PostponePolicy", "postponing " + this.f18177b);
        BaseTask baseTask = this.f18177b;
        baseTask.p(baseTask.m() + ((long) this.f18176a));
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void b() {
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void c() {
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void onCompleted() {
    }
}
