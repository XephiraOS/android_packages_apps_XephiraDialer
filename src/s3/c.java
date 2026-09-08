package S3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.loader.app.a;
import com.android.contacts.ContactLoader;

/* compiled from: ContactInfoLoader.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public W.c<ContactLoader.Result> f3439a;

    /* renamed from: b, reason: collision with root package name */
    public Context f3440b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f3441c;

    /* renamed from: d, reason: collision with root package name */
    public b f3442d;

    /* renamed from: e, reason: collision with root package name */
    public final a.InterfaceC0129a<ContactLoader.Result> f3443e = new a();

    /* compiled from: ContactInfoLoader.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(ContactLoader.Result result);

        void onError(String str);
    }

    public c(Context context, Uri uri) {
        this.f3441c = uri;
        this.f3440b = context;
    }

    public void d(Fragment fragment, b bVar) {
        this.f3442d = bVar;
        Bundle bundle = new Bundle();
        bundle.putParcelable("contactUri", this.f3441c);
        this.f3439a = fragment.getLoaderManager().g(1, bundle, this.f3443e);
    }

    /* compiled from: ContactInfoLoader.java */
    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0129a<ContactLoader.Result> {
        public a() {
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public W.c<ContactLoader.Result> Z(int i10, Bundle bundle) {
            return new ContactLoader(c.this.f3440b, (Uri) bundle.getParcelable("contactUri"), false);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void S0(W.c<ContactLoader.Result> cVar, ContactLoader.Result result) {
            if (c.this.f3441c == null) {
                return;
            }
            H7.b.b("LoadContactInfo", "data.getRequestedUri() : " + result.U());
            try {
                if (!result.U().getLastPathSegment().equals(c.this.f3441c.getLastPathSegment())) {
                    return;
                }
            } catch (Exception e10) {
                H7.b.c("LoadContactInfo", e10.toString());
            }
            if (result.c0()) {
                String str = "Error loading the contact: " + result.E();
                H7.b.b("LoadContactInfo", str);
                c.this.f3442d.onError(str);
                return;
            }
            if (result.e0()) {
                String str2 = "No contact found: " + ((ContactLoader) cVar).d0();
                H7.b.b("LoadContactInfo", str2);
                c.this.f3442d.onError(str2);
                return;
            }
            c.this.f3442d.a(result);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public void Q(W.c<ContactLoader.Result> cVar) {
        }
    }
}
