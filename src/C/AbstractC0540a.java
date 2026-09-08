package c;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.i;

/* compiled from: ActivityResultContract.kt */
/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0540a<I, O> {

    /* compiled from: ActivityResultContract.kt */
    /* renamed from: c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0147a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f12676a;

        public C0147a(T t10) {
            this.f12676a = t10;
        }

        public final T a() {
            return this.f12676a;
        }
    }

    public abstract Intent a(Context context, I i10);

    public C0147a<O> b(Context context, I i10) {
        i.f(context, "context");
        return null;
    }

    public abstract O c(int i10, Intent intent);
}
