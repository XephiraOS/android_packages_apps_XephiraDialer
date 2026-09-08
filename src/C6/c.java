package C6;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import android.util.Log;
import kotlin.jvm.internal.i;

/* compiled from: NavigationModeUtils.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f381a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static a f382b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f383c;

    /* compiled from: NavigationModeUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final Context f384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(null);
            i.f(context, "context");
            this.f384a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Log.i("NavigationModeObserver", "selfChange = " + z10);
            c.d(this.f384a);
        }
    }

    public static final void a(Context context) {
        i.f(context, "context");
        f382b = new a(context);
        d(context);
        try {
            a aVar = f382b;
            if (aVar != null) {
                context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("navigation_mode"), true, aVar);
            }
        } catch (Throwable th) {
            Log.e("NavigationModeObserver", "init th =  " + th);
        }
    }

    public static final boolean b() {
        return f383c;
    }

    public static final void d(Context context) {
        i.f(context, "context");
        f383c = f381a.c(context);
    }

    public final boolean c(Context context) {
        if (z6.b.c(context, 2, "navigation_mode", 0) != 2) {
            return false;
        }
        return true;
    }
}
