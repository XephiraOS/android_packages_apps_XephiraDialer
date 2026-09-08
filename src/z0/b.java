package Z0;

import N0.g;
import android.R;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.contacts.model.Account;

/* compiled from: ContactPhotoManager.java */
/* loaded from: classes.dex */
public abstract class b implements ComponentCallbacks2 {

    /* renamed from: c, reason: collision with root package name */
    public static b f5775c;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f5773a = Uri.parse("defaultimage://");

    /* renamed from: b, reason: collision with root package name */
    public static Drawable f5774b = null;

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC0090b f5776d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC0090b f5777e = new a();

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
    public static class a extends AbstractC0090b {

        /* renamed from: a, reason: collision with root package name */
        public static Drawable f5778a;

        @Override // Z0.b.AbstractC0090b
        public void a(ImageView imageView, int i10, boolean z10, c cVar) {
            if (f5778a == null) {
                f5778a = new ColorDrawable(imageView.getContext().getResources().getColor(R.color.darker_gray));
            }
            imageView.setImageDrawable(f5778a);
        }

        public a() {
        }
    }

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
    public static class d extends AbstractC0090b {
        public static Drawable c(Resources resources, c cVar, Account account) {
            e eVar = new e(resources, account);
            if (cVar != null) {
                if (TextUtils.isEmpty(cVar.f5784b)) {
                    eVar.o(null, cVar.f5783a);
                } else {
                    eVar.o(cVar.f5783a, cVar.f5784b);
                }
                eVar.m(cVar.f5785c);
                eVar.r(cVar.f5786d);
                eVar.p(cVar.f5787e);
                eVar.n(cVar.f5788f);
                eVar.q(cVar.f5789g);
            }
            return eVar;
        }

        @Override // Z0.b.AbstractC0090b
        public void a(ImageView imageView, int i10, boolean z10, c cVar) {
            b(imageView, null, i10, z10, cVar);
        }

        @Override // Z0.b.AbstractC0090b
        public void b(ImageView imageView, Account account, int i10, boolean z10, c cVar) {
            if (imageView == null) {
                return;
            }
            imageView.setImageDrawable(c(imageView.getResources(), cVar, account));
        }

        public d() {
        }
    }

    public static synchronized b c(Context context) {
        Z0.d dVar;
        synchronized (b.class) {
            dVar = new Z0.d(context);
        }
        return dVar;
    }

    public static int d(boolean z10, boolean z11) {
        return g.f1915o;
    }

    public static c e(Uri uri) {
        c cVar = new c(uri.getQueryParameter("display_name"), uri.getQueryParameter("identifier"), false);
        try {
            String queryParameter = uri.getQueryParameter("contact_type");
            if (!TextUtils.isEmpty(queryParameter)) {
                cVar.f5785c = Integer.parseInt(queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("scale");
            if (!TextUtils.isEmpty(queryParameter2)) {
                cVar.f5786d = Float.valueOf(queryParameter2).floatValue();
            }
            String queryParameter3 = uri.getQueryParameter("offset");
            if (!TextUtils.isEmpty(queryParameter3)) {
                cVar.f5787e = Float.valueOf(queryParameter3).floatValue();
            }
            String queryParameter4 = uri.getQueryParameter("is_circular");
            if (!TextUtils.isEmpty(queryParameter4)) {
                cVar.f5788f = Boolean.valueOf(queryParameter4).booleanValue();
            }
        } catch (NumberFormatException unused) {
            H7.b.i("ContactPhotoManager", "Invalid DefaultImageRequest image parameters provided, ignoring and using defaults.");
        }
        return cVar;
    }

    public static Drawable f(Context context, String str, String str2) {
        e eVar = new e(context.getResources());
        eVar.o(str, str2);
        eVar.q(2);
        return eVar;
    }

    public static b g(Context context) {
        if (f5775c == null) {
            Context applicationContext = context.getApplicationContext();
            b c10 = c(applicationContext);
            f5775c = c10;
            applicationContext.registerComponentCallbacks(c10);
            if (context.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
                f5775c.s();
            }
        }
        return f5775c;
    }

    public static void injectContactPhotoManagerForTesting(b bVar) {
        f5775c = bVar;
    }

    public static Uri u(Uri uri) {
        if (!TextUtils.isEmpty(uri.getEncodedFragment())) {
            Uri.Builder buildUpon = uri.buildUpon();
            buildUpon.encodedFragment(null);
            return buildUpon.build();
        }
        return uri;
    }

    public abstract void a();

    public abstract void b(long j10);

    public boolean h(Uri uri) {
        return "defaultimage".equals(uri.getScheme());
    }

    public final void i(ImageView imageView, Uri uri, Account account, boolean z10, boolean z11, c cVar) {
        n(imageView, uri, account, -1, z10, z11, cVar, f5776d);
    }

    public final void j(ImageView imageView, Uri uri, int i10, boolean z10, boolean z11, c cVar) {
        n(imageView, uri, null, i10, z10, z11, cVar, f5776d);
    }

    public final void k(ImageView imageView, Uri uri, long j10, Account account, int i10, boolean z10, boolean z11, c cVar) {
        l(imageView, uri, j10, account, i10, z10, z11, cVar, f5776d);
    }

    public abstract void l(ImageView imageView, Uri uri, long j10, Account account, int i10, boolean z10, boolean z11, c cVar, AbstractC0090b abstractC0090b);

    public final void m(ImageView imageView, Uri uri, Account account, int i10, boolean z10, boolean z11, c cVar) {
        n(imageView, uri, account, i10, z10, z11, cVar, f5776d);
    }

    public abstract void n(ImageView imageView, Uri uri, Account account, int i10, boolean z10, boolean z11, c cVar, AbstractC0090b abstractC0090b);

    public final void o(ImageView imageView, long j10, Account account, boolean z10, boolean z11, c cVar) {
        p(imageView, j10, account, z10, z11, cVar, f5776d);
    }

    public abstract void p(ImageView imageView, long j10, Account account, boolean z10, boolean z11, c cVar, AbstractC0090b abstractC0090b);

    public final void q(ImageView imageView, long j10, boolean z10, boolean z11, c cVar) {
        p(imageView, j10, null, z10, z11, cVar, f5776d);
    }

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void v(ImageView imageView);

    public abstract void w();

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: h, reason: collision with root package name */
        public static final c f5779h = new c();

        /* renamed from: i, reason: collision with root package name */
        public static final c f5780i = new c(null, null, 2, false);

        /* renamed from: j, reason: collision with root package name */
        public static final c f5781j = new c(null, null, true);

        /* renamed from: k, reason: collision with root package name */
        public static final c f5782k = new c(null, null, 2, true);

        /* renamed from: a, reason: collision with root package name */
        public String f5783a;

        /* renamed from: b, reason: collision with root package name */
        public String f5784b;

        /* renamed from: c, reason: collision with root package name */
        public int f5785c;

        /* renamed from: d, reason: collision with root package name */
        public float f5786d;

        /* renamed from: e, reason: collision with root package name */
        public float f5787e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f5788f;

        /* renamed from: g, reason: collision with root package name */
        public int f5789g;

        public c() {
            this.f5785c = 1;
            this.f5786d = 1.0f;
            this.f5787e = 0.0f;
            this.f5788f = false;
            this.f5789g = 1;
        }

        public c(String str, String str2, boolean z10) {
            this(str, str2, 1, 1.0f, 0.0f, z10);
        }

        public c(String str, String str2, int i10, boolean z10) {
            this(str, str2, i10, 1.0f, 0.0f, z10);
        }

        public c(String str, String str2, int i10, float f10, float f11, boolean z10) {
            this.f5789g = 1;
            this.f5783a = str;
            this.f5784b = str2;
            this.f5785c = i10;
            this.f5786d = f10;
            this.f5787e = f11;
            this.f5788f = z10;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* compiled from: ContactPhotoManager.java */
    /* renamed from: Z0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0090b {
        public abstract void a(ImageView imageView, int i10, boolean z10, c cVar);

        public void b(ImageView imageView, Account account, int i10, boolean z10, c cVar) {
        }
    }
}
