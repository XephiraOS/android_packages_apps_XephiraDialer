package i3;

import Z2.j;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import s3.C1540k;

/* compiled from: ResourceDrawableDecoder.java */
/* renamed from: i3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1096e implements X2.e<Uri, Drawable> {

    /* renamed from: b, reason: collision with root package name */
    public static final X2.c<Resources.Theme> f32156b = X2.c.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* renamed from: a, reason: collision with root package name */
    public final Context f32157a;

    public C1096e(Context context) {
        this.f32157a = context.getApplicationContext();
    }

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j<Drawable> b(Uri uri, int i10, int i11, X2.d dVar) {
        Resources.Theme theme;
        Drawable a10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context d10 = d(uri, authority);
            int g10 = g(d10, uri);
            if (((String) C1540k.d(authority)).equals(this.f32157a.getPackageName())) {
                theme = (Resources.Theme) dVar.c(f32156b);
            } else {
                theme = null;
            }
            if (theme == null) {
                a10 = C1093b.b(this.f32157a, d10, g10);
            } else {
                a10 = C1093b.a(this.f32157a, g10, theme);
            }
            return C1095d.f(a10);
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    public final Context d(Uri uri, String str) {
        if (str.equals(this.f32157a.getPackageName())) {
            return this.f32157a;
        }
        try {
            return this.f32157a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (str.contains(this.f32157a.getPackageName())) {
                return this.f32157a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e10);
        }
    }

    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e10) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
        }
    }

    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // X2.e
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, X2.d dVar) {
        String scheme = uri.getScheme();
        if (scheme != null && scheme.equals("android.resource")) {
            return true;
        }
        return false;
    }
}
