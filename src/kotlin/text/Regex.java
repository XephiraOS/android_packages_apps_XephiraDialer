package kotlin.text;

import java.io.Serializable;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: Regex.kt */
/* loaded from: classes4.dex */
public final class Regex implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f34280a = new a(null);
    private Set<Object> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: classes4.dex */
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f34281a = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        /* loaded from: classes4.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public Serialized(String pattern, int i10) {
            kotlin.jvm.internal.i.f(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.i.e(compile, "compile(...)");
            return new Regex(compile);
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public Regex(Pattern nativePattern) {
        kotlin.jvm.internal.i.f(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.i.e(pattern, "pattern(...)");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean a(CharSequence input) {
        kotlin.jvm.internal.i.f(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String b(CharSequence input, String replacement) {
        kotlin.jvm.internal.i.f(input, "input");
        kotlin.jvm.internal.i.f(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.i.e(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final String c(CharSequence input, String replacement) {
        kotlin.jvm.internal.i.f(input, "input");
        kotlin.jvm.internal.i.f(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.i.e(replaceFirst, "replaceFirst(...)");
        return replaceFirst;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.i.e(pattern, "toString(...)");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.i.f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.i.e(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }
}
