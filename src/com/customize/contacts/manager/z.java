package com.customize.contacts.manager;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OnActivityResultManager.java */
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f21635a;

    /* renamed from: b, reason: collision with root package name */
    public List<a> f21636b;

    /* compiled from: OnActivityResultManager.java */
    /* loaded from: classes3.dex */
    public interface a {
        boolean d(int i10, int i11, Intent intent);
    }

    public z(Activity activity) {
        this.f21635a = activity;
    }

    public Activity a() {
        return this.f21635a;
    }

    public void b(int i10, int i11, Intent intent) {
        List<a> list = this.f21636b;
        if (list == null) {
            H7.b.i("ActivityResultManager", "OnActivityResult(), you must invoke onCreate frist!");
            return;
        }
        try {
            for (a aVar : list) {
                if (H7.a.b()) {
                    H7.b.b("ActivityResultManager", "requestCode = " + i10);
                }
                if (aVar != null) {
                    aVar.d(i10, i11, intent);
                }
            }
        } catch (Exception e10) {
            H7.b.c("ActivityResultManager", "" + e10);
        }
    }

    public void c() {
        this.f21636b = new ArrayList();
    }

    public void d() {
        List<a> list = this.f21636b;
        if (list != null) {
            list.clear();
            this.f21636b = null;
        }
    }

    public void e(a aVar) {
        synchronized (this) {
            try {
                if (this.f21636b == null) {
                    this.f21636b = new ArrayList();
                }
                if (!this.f21636b.contains(aVar)) {
                    this.f21636b.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(a aVar) {
        synchronized (this) {
            try {
                List<a> list = this.f21636b;
                if (list != null) {
                    list.remove(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
