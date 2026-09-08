package O4;

import java.util.regex.Pattern;

/* compiled from: MultiFileModeFileNameProvider.java */
/* loaded from: classes3.dex */
public final class j implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f2727b = Pattern.compile("^[\\p{L}\\p{N}]+$");

    /* renamed from: a, reason: collision with root package name */
    public final String f2728a;

    public j(String str) {
        this.f2728a = str + "_";
    }

    @Override // O4.l
    public String a(Object obj) {
        String obj2 = obj.toString();
        if (f2727b.matcher(obj2).matches()) {
            return this.f2728a + obj;
        }
        throw new IllegalArgumentException("Invalid key: " + obj2);
    }
}
