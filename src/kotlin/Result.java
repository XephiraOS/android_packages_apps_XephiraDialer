package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: Result.kt */
/* loaded from: classes4.dex */
public final class Result<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f34166a = new a(null);
    private final Object value;

    /* compiled from: Result.kt */
    /* loaded from: classes4.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            i.f(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Failure) && i.b(this.exception, ((Failure) obj).exception)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        if (!(obj2 instanceof Result) || !i.b(obj, ((Result) obj2).i())) {
            return false;
        }
        return true;
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof Failure;
    }

    public static final boolean g(Object obj) {
        return !(obj instanceof Failure);
    }

    public static String h(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.value, obj);
    }

    public int hashCode() {
        return e(this.value);
    }

    public final /* synthetic */ Object i() {
        return this.value;
    }

    public String toString() {
        return h(this.value);
    }

    public static <T> Object b(Object obj) {
        return obj;
    }
}
