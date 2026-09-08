package I0;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.android.contacts.framework.api.appstore.application.IApplicationApi;
import com.oplus.blacklistapp.BlackListAppUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ApplicationApiImpl.kt */
/* loaded from: classes.dex */
public final class a implements IApplicationApi {

    /* renamed from: b, reason: collision with root package name */
    public static final C0027a f1302b = new C0027a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final a f1303c = new a();

    /* compiled from: ApplicationApiImpl.kt */
    /* renamed from: I0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0027a {
        public C0027a() {
        }

        public final a a() {
            return a.f1303c;
        }

        public /* synthetic */ C0027a(f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.framework.api.appstore.application.IApplicationApi
    public void a(Application application) {
        i.f(application, "application");
        Context applicationContext = application.getApplicationContext();
        i.e(applicationContext, "application.applicationContext");
        BlackListAppUtil.b(applicationContext);
        R2.a.d(application);
    }

    @Override // com.android.contacts.framework.api.appstore.application.IApplicationApi
    public void b(Context context, Application application) {
        i.f(context, "context");
        i.f(application, "application");
        BlackListAppUtil.a(context, application);
        R2.a.a(context);
    }

    @Override // com.android.contacts.framework.api.appstore.application.IApplicationApi
    public void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        BlackListAppUtil.g();
        R2.a.c(newConfig);
    }
}
