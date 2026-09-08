package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
import r.C1497a;

/* compiled from: ProfileVerifier.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final C1497a<c> f10794a = C1497a.q();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f10795b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f10796c = null;

    /* compiled from: ProfileVerifier.java */
    /* loaded from: classes.dex */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* compiled from: ProfileVerifier.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10797a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10798b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10799c;

        /* renamed from: d, reason: collision with root package name */
        public final long f10800d;

        public b(int i10, int i11, long j10, long j11) {
            this.f10797a = i10;
            this.f10798b = i11;
            this.f10799c = j10;
            this.f10800d = j11;
        }

        public static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f10797a);
                dataOutputStream.writeInt(this.f10798b);
                dataOutputStream.writeLong(this.f10799c);
                dataOutputStream.writeLong(this.f10800d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f10798b == bVar.f10798b && this.f10799c == bVar.f10799c && this.f10797a == bVar.f10797a && this.f10800d == bVar.f10800d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f10798b), Long.valueOf(this.f10799c), Integer.valueOf(this.f10797a), Long.valueOf(this.f10800d));
        }
    }

    /* compiled from: ProfileVerifier.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10801a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10802b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10803c;

        public c(int i10, boolean z10, boolean z11) {
            this.f10801a = i10;
            this.f10803c = z11;
            this.f10802b = z10;
        }
    }

    public static long a(Context context) {
        return a.a(context.getApplicationContext().getPackageManager(), context).lastUpdateTime;
    }

    public static c b(int i10, boolean z10, boolean z11) {
        c cVar = new c(i10, z10, z11);
        f10796c = cVar;
        f10794a.o(cVar);
        return f10796c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:19|20|21|(2:58|59)(1:23)|24|(8:31|(1:35)|(1:42)|43|(2:50|51)|47|48|49)|(1:57)|(1:35)|(3:37|40|42)|43|(1:45)|50|51|47|48|49) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c3, code lost:
    
        r6 = 196608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        r6 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.profileinstaller.e.c c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.e.c(android.content.Context, boolean):androidx.profileinstaller.e$c");
    }
}
