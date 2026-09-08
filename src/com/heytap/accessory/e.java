package com.heytap.accessory;

import android.content.Context;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.utils.ResourceParserException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import n5.C1371a;
import r5.i;

/* compiled from: RegistrationTask.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    public static final String f25269e = "b";

    /* renamed from: a, reason: collision with root package name */
    public final Context f25270a;

    /* renamed from: b, reason: collision with root package name */
    public b f25271b;

    /* renamed from: c, reason: collision with root package name */
    public FutureTask<Void> f25272c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25273d;

    public e(Context context) {
        if (context != null) {
            this.f25270a = context;
            return;
        }
        throw new IllegalArgumentException("Invalid context:" + ((Object) null));
    }

    public synchronized Future<Void> c(ServiceProfile serviceProfile) {
        FutureTask<Void> futureTask;
        if (this.f25271b == null && this.f25272c == null) {
            this.f25271b = new b(serviceProfile);
            futureTask = new FutureTask<>(this.f25271b);
            this.f25272c = futureTask;
        } else {
            throw new IllegalStateException("RegistrationTask instance cannot be reused");
        }
        return futureTask;
    }

    public synchronized Future<Void> e() {
        FutureTask<Void> futureTask;
        if (this.f25271b == null && this.f25272c == null) {
            this.f25271b = new b();
            futureTask = new FutureTask<>(this.f25271b);
            this.f25272c = futureTask;
        } else {
            throw new IllegalStateException("RegistrationTask instance cannot be reused");
        }
        return futureTask;
    }

    public synchronized void f() {
        if (this.f25271b != null && this.f25272c != null) {
            if (!this.f25273d) {
                new Thread(this.f25272c, "RegistrationThread").start();
                this.f25273d = true;
            } else {
                C1371a.d(f25269e, "Registration task has already started");
                throw new IllegalStateException("Registration task is already running!");
            }
        } else {
            throw new IllegalStateException("Prepare not called");
        }
    }

    /* compiled from: RegistrationTask.java */
    /* loaded from: classes3.dex */
    public class b implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public ServiceProfile f25274a;

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            BaseAdapter defaultAdapter = BaseAdapter.getDefaultAdapter(e.this.f25270a);
            defaultAdapter.bindToFramework();
            ServiceProfile serviceProfile = this.f25274a;
            if (serviceProfile == null) {
                try {
                    byte[][] e10 = i.c(e.this.f25270a).e(e.this.f25270a.getPackageName());
                    if (e10 == null) {
                        C1371a.d(e.f25269e, "xmlArray is null");
                        return null;
                    }
                    C1371a.g(e.f25269e, "xmlArray.length=" + e10.length);
                    boolean z10 = false;
                    for (int i10 = 0; i10 < e10.length; i10++) {
                        try {
                            try {
                                defaultAdapter.registerServices(e10[i10]);
                                C1371a.g(e.f25269e, "Services Registered successfully!");
                                if (i10 == e10.length - 1) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                synchronized (e.this) {
                                    if (z10) {
                                        try {
                                            e.this.f25273d = false;
                                        } finally {
                                        }
                                    }
                                }
                            } catch (GeneralException e11) {
                                C1371a.e(e.f25269e, "Registration failed!", e11);
                                throw e11;
                            }
                        } catch (Throwable th) {
                            synchronized (e.this) {
                                if (z10) {
                                    try {
                                        e.this.f25273d = false;
                                    } finally {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (ResourceParserException e12) {
                    C1371a.f(e.f25269e, e12);
                    throw new Exception(e12);
                }
            } else {
                try {
                    defaultAdapter.registerServices(ServiceProfile.createBundle(serviceProfile));
                    C1371a.g(e.f25269e, "registerServiceProfile Registered successfully!");
                } catch (GeneralException e13) {
                    C1371a.e(e.f25269e, "registerServiceProfile Registration failed!", e13);
                    throw e13;
                }
            }
            return null;
        }

        public b(ServiceProfile serviceProfile) {
            this.f25274a = serviceProfile;
        }

        public b() {
        }
    }
}
