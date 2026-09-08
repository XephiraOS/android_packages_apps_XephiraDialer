package com.heytap.addon.app;

import android.app.OplusActivityManager;
import android.app.OppoActivityManager;
import java.util.List;

/* compiled from: OplusActivityManager.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public OplusActivityManager f25355a;

    /* renamed from: b, reason: collision with root package name */
    public OppoActivityManager f25356b;

    public a() {
        if (A5.a.b()) {
            this.f25355a = new OplusActivityManager();
        } else {
            this.f25356b = new OppoActivityManager();
        }
    }

    public void a(String str, List<String> list) {
        if (A5.a.b()) {
            this.f25355a.addBackgroundRestrictedInfo(str, list);
        } else {
            this.f25356b.addBackgroundRestrictedInfo(str, list);
        }
    }
}
