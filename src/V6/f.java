package V6;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.oplus.blacklistapp.m;
import com.oplus.blacklistapp.o;

/* compiled from: ContactPhotoManager.java */
/* loaded from: classes3.dex */
public abstract class f implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    public static f f4044a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f4045b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final c f4046c = new b();

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes3.dex */
    public static class a extends c {
        @Override // V6.f.c
        public void a(ImageView imageView, boolean z10, boolean z11) {
            imageView.setImageResource(f.a(z10, z11));
        }

        public a() {
        }
    }

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        public static Drawable f4047a;

        @Override // V6.f.c
        public void a(ImageView imageView, boolean z10, boolean z11) {
            if (f4047a == null) {
                f4047a = new ColorDrawable(imageView.getContext().getColor(m.f27274b));
            }
            imageView.setImageDrawable(f4047a);
        }

        public b() {
        }
    }

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes3.dex */
    public static abstract class c {
        public abstract void a(ImageView imageView, boolean z10, boolean z11);
    }

    public static int a(boolean z10, boolean z11) {
        return o.f27315r;
    }

    public static synchronized f b(Context context) {
        f fVar;
        synchronized (f.class) {
            try {
                if (f4044a == null) {
                    h hVar = new h(context.getApplicationContext());
                    f4044a = hVar;
                    context.registerComponentCallbacks(hVar);
                }
                fVar = f4044a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public final void c(ImageView imageView, long j10, boolean z10, boolean z11) {
        if (imageView == null) {
            return;
        }
        d(imageView, j10, z10, z11, f4045b);
    }

    public abstract void d(ImageView imageView, long j10, boolean z10, boolean z11, c cVar);

    public final void e(ImageView imageView, Uri uri, boolean z10, boolean z11) {
        if (imageView == null) {
            return;
        }
        f(imageView, uri, z10, z11, f4045b);
    }

    public abstract void f(ImageView imageView, Uri uri, boolean z10, boolean z11, c cVar);

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
