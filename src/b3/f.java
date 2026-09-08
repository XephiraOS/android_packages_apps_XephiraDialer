package b3;

import android.content.Context;
import b3.C0523d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends C0523d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* loaded from: classes.dex */
    public class a implements C0523d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12116a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12117b;

        public a(Context context, String str) {
            this.f12116a = context;
            this.f12117b = str;
        }

        @Override // b3.C0523d.a
        public File a() {
            File cacheDir = this.f12116a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.f12117b != null) {
                return new File(cacheDir, this.f12117b);
            }
            return cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
