package l6;

import android.util.Log;
import com.oplus.anim.J;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* loaded from: classes3.dex */
public class d implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f34719a = new HashSet();

    @Override // com.oplus.anim.J
    public void b(String str) {
        e(str, null);
    }

    @Override // com.oplus.anim.J
    public void c(String str, Throwable th) {
        Set<String> set = f34719a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOG_Effective", str, th);
        set.add(str);
    }

    @Override // com.oplus.anim.J
    public void d(String str) {
        c(str, null);
    }

    @Override // com.oplus.anim.J
    public void a(String str, Throwable th) {
    }

    public void e(String str, Throwable th) {
    }
}
