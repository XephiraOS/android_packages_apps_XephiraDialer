package U7;

import kotlin.Result;

/* compiled from: GsonHelper.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3872a = new b();

    public final <T> T a(String str, Class<T> cls) {
        T t10;
        try {
            Result.a aVar = Result.f34166a;
            t10 = (T) Result.b(new com.google.gson.d().j(str, cls));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            t10 = (T) Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(t10);
        if (d10 != null) {
            H7.b.c("GsonHelper", "fromJson exception " + d10);
        }
        if (Result.f(t10)) {
            return null;
        }
        return t10;
    }

    public final String b(Object obj) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(new com.google.gson.d().s(obj));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("GsonHelper", "toJson exception " + d10);
        }
        if (Result.f(b10)) {
            b10 = "";
        }
        return (String) b10;
    }
}
