package com.oplus.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.oplus.anim.parser.moshi.JsonReader;
import e6.C0983b;
import e6.C0984c;
import j6.C1184l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: EffectiveCompositionFactory.java */
/* loaded from: classes3.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, u<C0820a>> f25807a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<v> f25808b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f25809c = {80, 75, 3, 4};

    public static boolean A(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static Boolean B(G9.d dVar) {
        try {
            G9.d peek = dVar.peek();
            for (byte b10 : f25809c) {
                if (peek.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e10) {
            l6.e.b("Failed to check zip file header", e10);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void C(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, u<C0820a>> map = f25807a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    public static /* synthetic */ C0837s D(C0820a c0820a) {
        return new C0837s(c0820a);
    }

    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, C0820a c0820a) {
        Map<String, u<C0820a>> map = f25807a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    public static /* synthetic */ C0837s H(WeakReference weakReference, Context context, int i10, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i10, str);
    }

    public static /* synthetic */ C0837s I(Context context, String str, String str2) {
        C0837s<C0820a> c10 = N.d(context).c(context, str, str2);
        if (str2 != null && c10.b() != null) {
            C0983b.b().c(str2, c10.b());
        }
        return c10;
    }

    public static void J(boolean z10) {
        ArrayList arrayList = new ArrayList(f25808b);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((v) arrayList.get(i10)).a(z10);
        }
    }

    public static String K(Context context, int i10) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (A(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i10);
        return sb.toString();
    }

    public static u<C0820a> h(final String str, Callable<C0837s<C0820a>> callable) {
        final C0820a a10;
        if (str == null) {
            a10 = null;
        } else {
            a10 = C0983b.b().a(str);
        }
        if (a10 != null) {
            return new u<>(new Callable() { // from class: com.oplus.anim.E
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C0837s D10;
                    D10 = H.D(C0820a.this);
                    return D10;
                }
            });
        }
        if (str != null) {
            Map<String, u<C0820a>> map = f25807a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        u<C0820a> uVar = new u<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            uVar.d(new InterfaceC0836q() { // from class: com.oplus.anim.F
                @Override // com.oplus.anim.InterfaceC0836q
                public final void a(Object obj) {
                    H.E(str, atomicBoolean, (C0820a) obj);
                }
            });
            uVar.c(new InterfaceC0836q() { // from class: com.oplus.anim.G
                @Override // com.oplus.anim.InterfaceC0836q
                public final void a(Object obj) {
                    H.C(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, u<C0820a>> map2 = f25807a;
                map2.put(str, uVar);
                if (map2.size() == 1) {
                    J(false);
                }
            }
        }
        return uVar;
    }

    public static I i(C0820a c0820a, String str) {
        for (I i10 : c0820a.j().values()) {
            if (i10.b().equals(str)) {
                return i10;
            }
        }
        return null;
    }

    public static u<C0820a> j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static u<C0820a> k(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: com.oplus.anim.D
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0837s m10;
                m10 = H.m(applicationContext, str, str2);
                return m10;
            }
        });
    }

    public static C0837s<C0820a> l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static C0837s<C0820a> m(Context context, String str, String str2) {
        try {
            if (!l6.h.m(str, ".zip") && !l6.h.m(str, ".lottie")) {
                return o(context.getAssets().open(str), str2);
            }
            return y(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e10) {
            return new C0837s<>((Throwable) e10);
        }
    }

    public static u<C0820a> n(final InputStream inputStream, final String str) {
        return h(str, new Callable() { // from class: com.oplus.anim.A
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0837s o10;
                o10 = H.o(inputStream, str);
                return o10;
            }
        });
    }

    public static C0837s<C0820a> o(InputStream inputStream, String str) {
        return p(inputStream, str, true);
    }

    public static C0837s<C0820a> p(InputStream inputStream, String str, boolean z10) {
        try {
            return q(JsonReader.B(G9.f.a(G9.f.c(inputStream))), str);
        } finally {
            if (z10) {
                l6.h.c(inputStream);
            }
        }
    }

    public static C0837s<C0820a> q(JsonReader jsonReader, String str) {
        return r(jsonReader, str, true);
    }

    public static C0837s<C0820a> r(JsonReader jsonReader, String str, boolean z10) {
        try {
            try {
                C0820a a10 = C1184l.a(jsonReader);
                if (str != null) {
                    C0983b.b().c(str, a10);
                }
                C0837s<C0820a> c0837s = new C0837s<>(a10);
                if (z10) {
                    l6.h.c(jsonReader);
                }
                return c0837s;
            } catch (Exception e10) {
                C0837s<C0820a> c0837s2 = new C0837s<>(e10);
                if (z10) {
                    l6.h.c(jsonReader);
                }
                return c0837s2;
            }
        } catch (Throwable th) {
            if (z10) {
                l6.h.c(jsonReader);
            }
            throw th;
        }
    }

    public static u<C0820a> s(Context context, int i10) {
        return t(context, i10, K(context, i10));
    }

    public static u<C0820a> t(Context context, final int i10, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: com.oplus.anim.C
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0837s H10;
                H10 = H.H(weakReference, applicationContext, i10, str);
                return H10;
            }
        });
    }

    public static C0837s<C0820a> u(Context context, int i10) {
        return v(context, i10, K(context, i10));
    }

    public static C0837s<C0820a> v(Context context, int i10, String str) {
        try {
            G9.d a10 = G9.f.a(G9.f.c(context.getResources().openRawResource(i10)));
            if (B(a10).booleanValue()) {
                return y(context, new ZipInputStream(a10.p0()), str);
            }
            return o(a10.p0(), str);
        } catch (Resources.NotFoundException e10) {
            return new C0837s<>((Throwable) e10);
        }
    }

    public static u<C0820a> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static u<C0820a> x(final Context context, final String str, final String str2) {
        return h(str2, new Callable() { // from class: com.oplus.anim.B
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0837s I10;
                I10 = H.I(context, str, str2);
                return I10;
            }
        });
    }

    public static C0837s<C0820a> y(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return z(context, zipInputStream, str);
        } finally {
            l6.h.c(zipInputStream);
        }
    }

    public static C0837s<C0820a> z(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C0820a c0820a = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    c0820a = r(JsonReader.B(G9.f.a(G9.f.c(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        if (!name.contains(".ttf") && !name.contains(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        String[] split = name.split("/");
                        String str2 = split[split.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Throwable th) {
                            l6.e.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Typeface createFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                l6.e.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            hashMap2.put(str3, createFromFile);
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                            break;
                        }
                    }
                    String[] split2 = name.split("/");
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c0820a == null) {
                return new C0837s<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                I i10 = i(c0820a, (String) entry.getKey());
                if (i10 != null) {
                    i10.f(l6.h.l((Bitmap) entry.getValue(), i10.e(), i10.c()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z10 = false;
                for (C0984c c0984c : c0820a.g().values()) {
                    if (c0984c.a().equals(entry2.getKey())) {
                        c0984c.e((Typeface) entry2.getValue());
                        z10 = true;
                    }
                }
                if (!z10) {
                    l6.e.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                Iterator<Map.Entry<String, I>> it = c0820a.j().entrySet().iterator();
                while (it.hasNext()) {
                    I value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String b10 = value.b();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (b10.startsWith("data:") && b10.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(b10.substring(b10.indexOf(44) + 1), 0);
                            value.f(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e10) {
                            l6.e.d("data URL did not have correct base64 format.", e10);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, I> entry3 : c0820a.j().entrySet()) {
                if (entry3.getValue().a() == null) {
                    return new C0837s<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().b()));
                }
            }
            if (str != null) {
                C0983b.b().c(str, c0820a);
            }
            return new C0837s<>(c0820a);
        } catch (IOException e11) {
            return new C0837s<>((Throwable) e11);
        }
    }
}
