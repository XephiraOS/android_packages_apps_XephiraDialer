package C9;

/* compiled from: KClasses.kt */
/* loaded from: classes4.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(c<T> cVar, Object obj) {
        kotlin.jvm.internal.i.f(cVar, "<this>");
        if (cVar.e(obj)) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.b());
    }
}
