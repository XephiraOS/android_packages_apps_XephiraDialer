package K0;

import com.android.contacts.framework.api.permission.IPermissionApi;
import java.util.List;
import kotlin.jvm.internal.f;

/* compiled from: PermissionApiImpl.kt */
/* loaded from: classes.dex */
public final class a implements IPermissionApi {

    /* renamed from: b, reason: collision with root package name */
    public static final C0035a f1611b = new C0035a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final a f1612c = new a();

    /* compiled from: PermissionApiImpl.kt */
    /* renamed from: K0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0035a {
        public C0035a() {
        }

        public final a a() {
            return a.f1612c;
        }

        public /* synthetic */ C0035a(f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.framework.api.permission.IPermissionApi
    public List<String> a() {
        return R2.a.b();
    }

    @Override // com.android.contacts.framework.api.permission.IPermissionApi
    public boolean b() {
        return false;
    }
}
