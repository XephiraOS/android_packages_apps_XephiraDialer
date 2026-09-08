package kotlin.text;

import java.nio.charset.Charset;

/* compiled from: Charsets.kt */
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f34283a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f34284b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f34285c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f34286d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f34287e;

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f34288f;

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f34289g;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.i.e(forName, "forName(...)");
        f34284b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.i.e(forName2, "forName(...)");
        f34285c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.i.e(forName3, "forName(...)");
        f34286d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.i.e(forName4, "forName(...)");
        f34287e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.i.e(forName5, "forName(...)");
        f34288f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.i.e(forName6, "forName(...)");
        f34289g = forName6;
    }
}
