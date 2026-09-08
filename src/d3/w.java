package d3;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import d3.o;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class w<Data> implements o<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final o<Uri, Data> f30025a;

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements p<String, AssetFileDescriptor> {
        @Override // d3.p
        public o<String, AssetFileDescriptor> d(s sVar) {
            return new w(sVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class b implements p<String, ParcelFileDescriptor> {
        @Override // d3.p
        public o<String, ParcelFileDescriptor> d(s sVar) {
            return new w(sVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class c implements p<String, InputStream> {
        @Override // d3.p
        public o<String, InputStream> d(s sVar) {
            return new w(sVar.d(Uri.class, InputStream.class));
        }
    }

    public w(o<Uri, Data> oVar) {
        this.f30025a = oVar;
    }

    public static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return f(str);
        }
        return parse;
    }

    public static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(String str, int i10, int i11, X2.d dVar) {
        Uri e10 = e(str);
        if (e10 != null && this.f30025a.a(e10)) {
            return this.f30025a.b(e10, i10, i11, dVar);
        }
        return null;
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(String str) {
        return true;
    }
}
