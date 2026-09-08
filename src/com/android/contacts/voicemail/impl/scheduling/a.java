package com.android.contacts.voicemail.impl.scheduling;

import android.content.Intent;
import android.os.Bundle;
import com.android.contacts.voicemail.impl.scheduling.e;

/* compiled from: MinimalIntervalPolicy.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public BaseTask f18173a;

    /* renamed from: b, reason: collision with root package name */
    public e.a f18174b;

    /* renamed from: c, reason: collision with root package name */
    public int f18175c;

    public a(int i10) {
        this.f18175c = i10;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void d(BaseTask baseTask, Bundle bundle) {
        this.f18173a = baseTask;
        this.f18174b = baseTask.getId();
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void onCompleted() {
        if (!this.f18173a.n()) {
            Intent h10 = BaseTask.h(this.f18173a.k(), BlockerTask.class, this.f18174b.f18185b);
            h10.putExtra("extra_task_id", this.f18174b.f18184a);
            h10.putExtra("extra_block_for_millis", this.f18175c);
            this.f18173a.k().sendBroadcast(h10);
        }
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void b() {
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void c() {
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.b
    public void e() {
    }
}
