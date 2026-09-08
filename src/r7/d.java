package R7;

import android.content.SharedPreferences;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SharedPreferencesExt.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final void a(SharedPreferences.Editor editor) {
        Object b10;
        if (editor == null) {
            return;
        }
        try {
            Result.a aVar = Result.f34166a;
            editor.apply();
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "Editor.applySafely error, " + d10);
        }
    }

    public static final SharedPreferences.Editor b(SharedPreferences sharedPreferences) {
        Object b10;
        Object obj = null;
        if (sharedPreferences == null) {
            return null;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(sharedPreferences.edit());
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "SharedPreferences.editSafely error, " + d10);
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (SharedPreferences.Editor) obj;
    }

    public static final boolean c(SharedPreferences sharedPreferences, String key, boolean z10) {
        Object b10;
        i.f(key, "key");
        if (sharedPreferences == null) {
            return z10;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(Boolean.valueOf(sharedPreferences.getBoolean(key, z10)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "SharedPreferences.getBooleanSafely error, " + d10);
        }
        Boolean valueOf = Boolean.valueOf(z10);
        if (Result.f(b10)) {
            b10 = valueOf;
        }
        return ((Boolean) b10).booleanValue();
    }

    public static /* synthetic */ boolean d(SharedPreferences sharedPreferences, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c(sharedPreferences, str, z10);
    }

    public static final int e(SharedPreferences sharedPreferences, String key, int i10) {
        Object b10;
        i.f(key, "key");
        if (sharedPreferences == null) {
            return i10;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(Integer.valueOf(sharedPreferences.getInt(key, i10)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "SharedPreferences.getBooleanSafely error, " + d10);
        }
        Integer valueOf = Integer.valueOf(i10);
        if (Result.f(b10)) {
            b10 = valueOf;
        }
        return ((Number) b10).intValue();
    }

    public static final long f(SharedPreferences sharedPreferences, String key, long j10) {
        Object b10;
        i.f(key, "key");
        if (sharedPreferences == null) {
            return j10;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(Long.valueOf(sharedPreferences.getLong(key, j10)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "SharedPreferences.getLongSafely error, " + d10);
        }
        Long valueOf = Long.valueOf(j10);
        if (Result.f(b10)) {
            b10 = valueOf;
        }
        return ((Number) b10).longValue();
    }

    public static /* synthetic */ long g(SharedPreferences sharedPreferences, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = -1;
        }
        return f(sharedPreferences, str, j10);
    }

    public static final SharedPreferences.Editor h(SharedPreferences.Editor editor, String key, boolean z10) {
        Object b10;
        i.f(key, "key");
        Object obj = null;
        if (editor == null) {
            return null;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(editor.putBoolean(key, z10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "Editor.putBooleanSafely error, " + d10);
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (SharedPreferences.Editor) obj;
    }

    public static final SharedPreferences.Editor i(SharedPreferences.Editor editor, String key, int i10) {
        Object b10;
        i.f(key, "key");
        Object obj = null;
        if (editor == null) {
            return null;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(editor.putInt(key, i10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "Editor.putIntSafely error, " + d10);
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (SharedPreferences.Editor) obj;
    }

    public static final void j(SharedPreferences sharedPreferences, String key, int i10) {
        SharedPreferences.Editor editor;
        i.f(key, "key");
        if (sharedPreferences != null) {
            editor = b(sharedPreferences);
        } else {
            editor = null;
        }
        a(i(editor, key, i10));
    }

    public static final SharedPreferences.Editor k(SharedPreferences.Editor editor, String key, long j10) {
        Object b10;
        i.f(key, "key");
        Object obj = null;
        if (editor == null) {
            return null;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(editor.putLong(key, j10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SharedPreferencesExt", "Editor.putLongSafely error, " + d10);
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (SharedPreferences.Editor) obj;
    }
}
