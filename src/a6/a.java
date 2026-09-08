package A6;

import com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AppInfoCompatApiImpl.kt */
/* loaded from: classes3.dex */
public final class a implements IAppInfoCompatApi {

    /* renamed from: b, reason: collision with root package name */
    public static final C0001a f199b = new C0001a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final a f200c = new a();

    /* compiled from: AppInfoCompatApiImpl.kt */
    /* renamed from: A6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0001a {
        public C0001a() {
        }

        public final a a() {
            return a.f200c;
        }

        public /* synthetic */ C0001a(f fVar) {
            this();
        }
    }

    @Override // com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String a() {
        return "com.oplus.dialer.black_list";
    }

    @Override // com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String b() {
        return "com.oplus.dialer";
    }

    @Override // com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String c() {
        return "com.oplus.dialer.inquirenoarea";
    }

    @Override // com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi
    public boolean d(String str) {
        return i.b(str, "com.oplus.dialer");
    }

    @Override // com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String e() {
        return "com.oplus.dialer";
    }
}
