package i6;

import android.content.Context;
import android.util.Pair;
import com.oplus.anim.C0820a;
import com.oplus.anim.C0837s;
import com.oplus.anim.H;
import com.oplus.anim.network.FileExtension;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import l6.h;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final f f32191a;

    /* renamed from: b, reason: collision with root package name */
    public final e f32192b;

    public g(f fVar, e eVar) {
        this.f32191a = fVar;
        this.f32192b = eVar;
    }

    public final C0820a a(Context context, String str, String str2) {
        f fVar;
        Pair<FileExtension, InputStream> a10;
        C0837s<C0820a> o10;
        if (str2 == null || (fVar = this.f32191a) == null || (a10 = fVar.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a10.first;
        InputStream inputStream = (InputStream) a10.second;
        if (fileExtension == FileExtension.ZIP) {
            o10 = H.y(context, new ZipInputStream(inputStream), str2);
        } else {
            o10 = H.o(inputStream, str2);
        }
        if (o10.b() != null) {
            return o10.b();
        }
        return null;
    }

    public final C0837s<C0820a> b(Context context, String str, String str2) {
        boolean z10;
        l6.e.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                c a10 = this.f32192b.a(str);
                if (a10.d0()) {
                    C0837s<C0820a> d10 = d(context, str, a10.Q(), a10.J(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    if (d10.b() != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    sb.append(z10);
                    l6.e.a(sb.toString());
                    try {
                        a10.close();
                    } catch (IOException e10) {
                        l6.e.d("EffectiveFetchResult close failed ", e10);
                    }
                    return d10;
                }
                C0837s<C0820a> c0837s = new C0837s<>(new IllegalArgumentException(a10.N()));
                try {
                    a10.close();
                } catch (IOException e11) {
                    l6.e.d("EffectiveFetchResult close failed ", e11);
                }
                return c0837s;
            } catch (Exception e12) {
                C0837s<C0820a> c0837s2 = new C0837s<>(e12);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e13) {
                        l6.e.d("EffectiveFetchResult close failed ", e13);
                    }
                }
                return c0837s2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e14) {
                    l6.e.d("EffectiveFetchResult close failed ", e14);
                }
            }
            throw th;
        }
    }

    public C0837s<C0820a> c(Context context, String str, String str2) {
        C0820a a10 = a(context, str, str2);
        if (a10 != null) {
            return new C0837s<>(a10);
        }
        l6.e.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }

    public final C0837s<C0820a> d(Context context, String str, InputStream inputStream, String str2, String str3) {
        C0837s<C0820a> f10;
        FileExtension fileExtension;
        f fVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !h.m(str.split("\\?")[0], ".lottie")) {
            l6.e.a("Received json response.");
            fileExtension = FileExtension.JSON;
            f10 = e(str, inputStream, str3);
        } else {
            l6.e.a("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            f10 = f(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        }
        if (str3 != null && f10.b() != null && (fVar = this.f32191a) != null) {
            fVar.e(str, fileExtension);
        }
        return f10;
    }

    public final C0837s<C0820a> e(String str, InputStream inputStream, String str2) {
        f fVar;
        if (str2 != null && (fVar = this.f32191a) != null) {
            return H.o(new FileInputStream(fVar.f(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
        }
        return H.o(inputStream, null);
    }

    public final C0837s<C0820a> f(Context context, String str, InputStream inputStream, String str2) {
        f fVar;
        if (str2 != null && (fVar = this.f32191a) != null) {
            return H.y(context, new ZipInputStream(new FileInputStream(fVar.f(str, inputStream, FileExtension.ZIP))), str);
        }
        return H.y(context, new ZipInputStream(inputStream), null);
    }
}
