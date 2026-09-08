package androidx.window.core;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: SpecificationComputer.kt */
/* loaded from: classes.dex */
public abstract class SpecificationComputer<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f11915a = new Companion(null);

    /* compiled from: SpecificationComputer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ SpecificationComputer b(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i10, Object obj2) {
            if ((i10 & 2) != 0) {
                verificationMode = BuildConfig.f11894a.a();
            }
            if ((i10 & 4) != 0) {
                logger = AndroidLogger.f11889a;
            }
            return companion.a(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> a(T t10, String tag, VerificationMode verificationMode, Logger logger) {
            i.f(t10, "<this>");
            i.f(tag, "tag");
            i.f(verificationMode, "verificationMode");
            i.f(logger, "logger");
            return new ValidSpecification(t10, tag, verificationMode, logger);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: SpecificationComputer.kt */
    /* loaded from: classes.dex */
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T a();

    public final String b(Object value, String message) {
        i.f(value, "value");
        i.f(message, "message");
        return message + " value: " + value;
    }

    public abstract SpecificationComputer<T> c(String str, l<? super T, Boolean> lVar);
}
