package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: SpecificationComputer.kt */
/* loaded from: classes.dex */
final class ValidSpecification<T> extends SpecificationComputer<T> {

    /* renamed from: b, reason: collision with root package name */
    public final T f11920b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11921c;

    /* renamed from: d, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f11922d;

    /* renamed from: e, reason: collision with root package name */
    public final Logger f11923e;

    public ValidSpecification(T value, String tag, SpecificationComputer.VerificationMode verificationMode, Logger logger) {
        i.f(value, "value");
        i.f(tag, "tag");
        i.f(verificationMode, "verificationMode");
        i.f(logger, "logger");
        this.f11920b = value;
        this.f11921c = tag;
        this.f11922d = verificationMode;
        this.f11923e = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T a() {
        return this.f11920b;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer<T> c(String message, l<? super T, Boolean> condition) {
        i.f(message, "message");
        i.f(condition, "condition");
        if (!condition.invoke(this.f11920b).booleanValue()) {
            return new FailedSpecification(this.f11920b, this.f11921c, message, this.f11923e, this.f11922d);
        }
        return this;
    }
}
