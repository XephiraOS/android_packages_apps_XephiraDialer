package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: SpecificationComputer.kt */
/* loaded from: classes.dex */
final class FailedSpecification<T> extends SpecificationComputer<T> {

    /* renamed from: b, reason: collision with root package name */
    public final T f11902b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11903c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11904d;

    /* renamed from: e, reason: collision with root package name */
    public final Logger f11905e;

    /* renamed from: f, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f11906f;

    /* renamed from: g, reason: collision with root package name */
    public final WindowStrictModeException f11907g;

    /* compiled from: SpecificationComputer.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11908a;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            f11908a = iArr;
        }
    }

    public FailedSpecification(T value, String tag, String message, Logger logger, SpecificationComputer.VerificationMode verificationMode) {
        List v10;
        i.f(value, "value");
        i.f(tag, "tag");
        i.f(message, "message");
        i.f(logger, "logger");
        i.f(verificationMode, "verificationMode");
        this.f11902b = value;
        this.f11903c = tag;
        this.f11904d = message;
        this.f11905e = logger;
        this.f11906f = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(b(value, message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        i.e(stackTrace, "stackTrace");
        v10 = C1229j.v(stackTrace, 2);
        Object[] array = v10.toArray(new StackTraceElement[0]);
        if (array != null) {
            windowStrictModeException.setStackTrace((StackTraceElement[]) array);
            this.f11907g = windowStrictModeException;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // androidx.window.core.SpecificationComputer
    public T a() {
        int i10 = WhenMappings.f11908a[this.f11906f.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return null;
            }
            this.f11905e.a(this.f11903c, b(this.f11902b, this.f11904d));
            return null;
        }
        throw this.f11907g;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer<T> c(String message, l<? super T, Boolean> condition) {
        i.f(message, "message");
        i.f(condition, "condition");
        return this;
    }
}
