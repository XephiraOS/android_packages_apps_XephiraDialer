package f9;

import android.content.Context;
import android.text.SpannableString;
import com.ted.number.protection.RevokeStatusSource;
import kotlin.jvm.internal.i;

/* compiled from: RevokeStatusManager.kt */
/* renamed from: f9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1023a {

    /* renamed from: a, reason: collision with root package name */
    public final RevokeStatusSource f31801a = new RevokeStatusSource();

    public SpannableString a(Context context) {
        i.f(context, "context");
        return this.f31801a.a(context);
    }

    public CharSequence b(Context context) {
        i.f(context, "context");
        return this.f31801a.b(context);
    }

    public boolean c() {
        return this.f31801a.c();
    }

    public boolean d() {
        return this.f31801a.d();
    }

    public void e() {
        this.f31801a.f();
    }
}
