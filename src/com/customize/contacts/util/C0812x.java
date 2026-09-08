package com.customize.contacts.util;

import com.android.contacts.framework.baseui.sim.SimContactInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CopyToSimResult.java */
/* renamed from: com.customize.contacts.util.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0812x {

    /* renamed from: a, reason: collision with root package name */
    public boolean f22187a = false;

    /* renamed from: b, reason: collision with root package name */
    public List<Long> f22188b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public List<SimContactInfo> f22189c = new ArrayList();

    public void a(long j10, SimContactInfo simContactInfo) {
        this.f22188b.add(Long.valueOf(j10));
        this.f22189c.add(simContactInfo);
    }

    public void b(boolean z10) {
        this.f22187a = z10;
    }

    public String toString() {
        return "CopyToSimResult{success=" + this.f22187a + ", simIndexes=" + this.f22188b + ", dividedSimContacts=" + this.f22189c + '}';
    }
}
