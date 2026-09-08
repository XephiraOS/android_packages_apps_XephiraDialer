package io.grpc;

import io.grpc.Context;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ThreadLocalContextStorage.java */
/* loaded from: classes4.dex */
public final class H extends Context.f {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f32304a = Logger.getLogger(H.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Context> f32305b = new ThreadLocal<>();

    @Override // io.grpc.Context.f
    public Context a() {
        Context context = f32305b.get();
        if (context == null) {
            return Context.f32275e;
        }
        return context;
    }

    @Override // io.grpc.Context.f
    public void b(Context context, Context context2) {
        if (a() != context) {
            f32304a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (context2 != Context.f32275e) {
            f32305b.set(context2);
        } else {
            f32305b.set(null);
        }
    }

    @Override // io.grpc.Context.f
    public Context c(Context context) {
        Context a10 = a();
        f32305b.set(context);
        return a10;
    }
}
