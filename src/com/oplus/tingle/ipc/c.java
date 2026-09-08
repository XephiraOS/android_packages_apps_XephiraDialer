package com.oplus.tingle.ipc;

import android.app.Application;
import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Slave.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static List<Object> f29032a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static Application f29033b;

    public static void a(Context context) {
        if (context instanceof Application) {
            f29033b = (Application) context;
        } else {
            f29033b = (Application) context.getApplicationContext();
        }
        b();
    }

    public static void b() {
        f29032a.add(new G8.a());
        f29032a.add(new J8.a());
        f29032a.add(new G8.b());
        f29032a.add(new K8.a());
        f29032a.add(new I8.a());
        f29032a.add(new H8.a());
    }
}
