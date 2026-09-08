package Z2;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f5870a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final c f5871b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final c f5872c = new C0092c();

    /* renamed from: d, reason: collision with root package name */
    public static final c f5873d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final c f5874e = new e();

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    public class a extends c {
        @Override // Z2.c
        public boolean a() {
            return true;
        }

        @Override // Z2.c
        public boolean b() {
            return true;
        }

        @Override // Z2.c
        public boolean c(DataSource dataSource) {
            if (dataSource == DataSource.REMOTE) {
                return true;
            }
            return false;
        }

        @Override // Z2.c
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    public class b extends c {
        @Override // Z2.c
        public boolean a() {
            return false;
        }

        @Override // Z2.c
        public boolean b() {
            return false;
        }

        @Override // Z2.c
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // Z2.c
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: Z2.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0092c extends c {
        @Override // Z2.c
        public boolean a() {
            return true;
        }

        @Override // Z2.c
        public boolean b() {
            return false;
        }

        @Override // Z2.c
        public boolean c(DataSource dataSource) {
            if (dataSource != DataSource.DATA_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                return true;
            }
            return false;
        }

        @Override // Z2.c
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    public class d extends c {
        @Override // Z2.c
        public boolean a() {
            return false;
        }

        @Override // Z2.c
        public boolean b() {
            return true;
        }

        @Override // Z2.c
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // Z2.c
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    public class e extends c {
        @Override // Z2.c
        public boolean a() {
            return true;
        }

        @Override // Z2.c
        public boolean b() {
            return true;
        }

        @Override // Z2.c
        public boolean c(DataSource dataSource) {
            if (dataSource == DataSource.REMOTE) {
                return true;
            }
            return false;
        }

        @Override // Z2.c
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (((z10 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED) {
                return true;
            }
            return false;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy);
}
