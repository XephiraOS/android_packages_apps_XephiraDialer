package kotlin.text;

/* compiled from: Appendable.kt */
/* loaded from: classes4.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Appendable appendable, T t10, v9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.i.f(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.invoke(t10));
            return;
        }
        if (t10 == 0 || (t10 instanceof CharSequence)) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }
}
