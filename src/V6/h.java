package V6;

import V6.f;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.utils.A;
import com.oplus.utils.C0843d;
import com.oplus.utils.C0846g;
import com.oplus.utils.X;
import h9.C1087a;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ContactPhotoManagerImpl.java */
/* loaded from: classes3.dex */
public class h extends f implements Handler.Callback {

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f4048p = new String[0];

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f4049q = {BreenoCallContract.BaseColumns._ID, "data15"};

    /* renamed from: e, reason: collision with root package name */
    public final Context f4051e;

    /* renamed from: f, reason: collision with root package name */
    public final LruCache<Object, c> f4052f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4053g;

    /* renamed from: h, reason: collision with root package name */
    public final LruCache<Object, Bitmap> f4054h;

    /* renamed from: m, reason: collision with root package name */
    public d f4059m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4060n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4061o;

    /* renamed from: d, reason: collision with root package name */
    public final Set<String> f4050d = G6.b.a();

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<ImageView, e> f4055i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public final Handler f4056j = new Handler(this);

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f4057k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f4058l = new AtomicInteger();

    /* compiled from: ContactPhotoManagerImpl.java */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f4064a;

        /* renamed from: b, reason: collision with root package name */
        public Reference<Bitmap> f4065b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f4066c;

        /* renamed from: d, reason: collision with root package name */
        public volatile boolean f4067d = true;

        public c(byte[] bArr) {
            this.f4066c = bArr;
        }
    }

    /* compiled from: ContactPhotoManagerImpl.java */
    /* loaded from: classes3.dex */
    public class d extends HandlerThread implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f4068a;

        /* renamed from: b, reason: collision with root package name */
        public final StringBuilder f4069b;

        /* renamed from: c, reason: collision with root package name */
        public final Set<Long> f4070c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f4071d;

        /* renamed from: e, reason: collision with root package name */
        public final Set<e> f4072e;

        /* renamed from: f, reason: collision with root package name */
        public final List<Long> f4073f;

        /* renamed from: g, reason: collision with root package name */
        public Handler f4074g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f4075h;

        /* renamed from: i, reason: collision with root package name */
        public int f4076i;

        public d(ContentResolver contentResolver) {
            super("ContactPhotoLoader");
            this.f4069b = new StringBuilder();
            this.f4070c = G6.b.a();
            this.f4071d = G6.b.a();
            this.f4072e = G6.b.a();
            this.f4073f = G6.a.a();
            this.f4076i = 0;
            this.f4068a = contentResolver;
        }

        public void a() {
            if (this.f4074g == null) {
                this.f4074g = new Handler(getLooper(), this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0124, code lost:
        
            if (r11 != null) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0126, code lost:
        
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x014b, code lost:
        
            r10 = r18.f4070c.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0155, code lost:
        
            if (r10.hasNext() == false) goto L110;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0157, code lost:
        
            r0 = r10.next();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0165, code lost:
        
            if (android.provider.ContactsContract.isProfileId(r0.longValue()) == false) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0167, code lost:
        
            r11 = r18.f4068a.query(android.content.ContentUris.withAppendedId(android.provider.ContactsContract.Data.CONTENT_URI, r0.longValue()), V6.h.f4049q, null, null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0180, code lost:
        
            if (r11 == null) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0186, code lost:
        
            if (r11.moveToFirst() == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0188, code lost:
        
            r18.f4077j.p(java.lang.Long.valueOf(r11.getLong(0)), r11.getBlob(1), r19, -1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01a4, code lost:
        
            if (r11 == null) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x01a6, code lost:
        
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x019f, code lost:
        
            r18.f4077j.p(r0, null, r19, -1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x019d, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x01ae, code lost:
        
            android.util.Log.e("ContactPhotoManager", "" + r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x01c0, code lost:
        
            if (r11 != null) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x019a, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x019b, code lost:
        
            r9 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x01c3, code lost:
        
            if (r9 != null) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01c5, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x01c8, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01ac, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x01ad, code lost:
        
            r11 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x01aa, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01c9, code lost:
        
            r18.f4077j.p(r0, null, r19, -1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
        
            r18.f4077j.f4056j.sendEmptyMessage(2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x01d8, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0148, code lost:
        
            if (r11 == null) goto L60;
         */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0145  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01db  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01e0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(boolean r19) {
            /*
                Method dump skipped, instructions count: 484
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: V6.h.d.b(boolean):void");
        }

        public final void c() {
            h.this.w(this.f4070c, this.f4071d, this.f4072e);
            b(false);
            d();
            h();
        }

        public final void d() {
            for (e eVar : this.f4072e) {
                Uri uri = eVar.f4079b;
                String trim = uri.toString().trim();
                if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                    if (this.f4075h == null) {
                        this.f4075h = new byte[16384];
                    }
                    try {
                        InputStream openInputStream = this.f4068a.openInputStream(uri);
                        if (openInputStream != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = openInputStream.read(this.f4075h);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(this.f4075h, 0, read);
                                    }
                                } catch (Throwable th) {
                                    openInputStream.close();
                                    throw th;
                                    break;
                                }
                            }
                            openInputStream.close();
                            h.this.p(uri, byteArrayOutputStream.toByteArray(), false, eVar.h());
                            h.this.f4056j.sendEmptyMessage(2);
                        } else {
                            Log.v("ContactPhotoManager", "Cannot load photo " + C0846g.h(uri));
                            h.this.p(uri, null, false, eVar.h());
                        }
                    } catch (Exception e10) {
                        Log.v("ContactPhotoManager", "Cannot load photo " + C0846g.h(uri) + e10);
                        if (eVar.f4078a > 0) {
                            eVar.f4079b = null;
                        } else {
                            h.this.p(uri, null, false, eVar.h());
                        }
                    }
                } else {
                    byte[] n10 = C1087a.e(h.this.f4051e).n(uri.toString());
                    h.this.p(uri, n10, false, eVar.h());
                    if (n10 != null) {
                        h.this.f4056j.sendEmptyMessage(2);
                    }
                }
            }
            h.this.f4056j.sendEmptyMessage(2);
        }

        public final void e() {
            int i10 = this.f4076i;
            if (i10 == 2) {
                return;
            }
            if (i10 == 0) {
                f();
                if (this.f4073f.isEmpty()) {
                    this.f4076i = 2;
                } else {
                    this.f4076i = 1;
                }
                h();
                return;
            }
            if (h.this.f4052f.size() > h.this.f4053g) {
                this.f4076i = 2;
                return;
            }
            this.f4070c.clear();
            this.f4071d.clear();
            h.this.f4050d.clear();
            int size = this.f4073f.size();
            while (size > 0 && this.f4070c.size() < 25) {
                size--;
                Long l10 = this.f4073f.get(size);
                this.f4070c.add(l10);
                if (l10.longValue() < 0) {
                    h.this.f4050d.add(String.valueOf(0 - l10.longValue()));
                } else {
                    this.f4071d.add(l10.toString());
                }
                this.f4073f.remove(size);
            }
            b(true);
            if (size == 0) {
                this.f4076i = 2;
            }
            h();
        }

        public final void f() {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.f4068a.query(ContactsContract.Contacts.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0L)).appendQueryParameter("limit", String.valueOf(100)).build(), new String[]{"photo_id"}, "photo_id NOT NULL AND photo_id!=0", null, "starred DESC, last_time_contacted DESC");
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            this.f4073f.add(0, Long.valueOf(cursor.getLong(0)));
                        }
                    }
                    for (int i10 = 1; i10 <= 39; i10++) {
                        this.f4073f.add(0, Long.valueOf(-i10));
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e10) {
                    Log.e("ContactPhotoManager", "" + e10);
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        public void g() {
            a();
            this.f4074g.removeMessages(0);
            this.f4074g.sendEmptyMessage(1);
        }

        public void h() {
            if (this.f4076i == 2) {
                return;
            }
            a();
            if (this.f4074g.hasMessages(1)) {
                return;
            }
            this.f4074g.sendEmptyMessageDelayed(0, 1000L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 == 1) {
                    c();
                }
            } else {
                e();
            }
            return true;
        }
    }

    /* compiled from: ContactPhotoManagerImpl.java */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f4078a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f4079b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4080c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f4081d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4082e;

        /* renamed from: f, reason: collision with root package name */
        public final f.c f4083f;

        public e(long j10, Uri uri, int i10, boolean z10, boolean z11, f.c cVar) {
            this.f4078a = j10;
            this.f4079b = uri;
            this.f4080c = z11;
            this.f4081d = z10;
            this.f4082e = i10;
            this.f4083f = cVar;
        }

        public static e e(long j10, boolean z10, boolean z11, f.c cVar) {
            return new e(j10, null, -1, z10, z11, cVar);
        }

        public static e f(Uri uri, int i10, boolean z10, boolean z11, f.c cVar) {
            return new e(0L, uri, i10, z10, z11, cVar);
        }

        public void d(ImageView imageView) {
            this.f4083f.a(imageView, this.f4081d, this.f4080c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f4078a != eVar.f4078a || !X.a(this.f4079b, eVar.f4079b)) {
                return false;
            }
            return true;
        }

        public Object g() {
            Uri uri = this.f4079b;
            if (uri == null) {
                return Long.valueOf(this.f4078a);
            }
            return uri;
        }

        public int h() {
            return this.f4082e;
        }

        public int hashCode() {
            Uri uri = this.f4079b;
            if (uri != null) {
                return uri.hashCode();
            }
            long j10 = this.f4078a;
            return (int) (j10 ^ (j10 >>> 32));
        }

        public boolean i() {
            if (this.f4079b != null) {
                return true;
            }
            return false;
        }
    }

    public h(Context context) {
        float f10;
        this.f4051e = context;
        if (A.a(context) >= 671088640) {
            f10 = 1.0f;
        } else {
            f10 = 0.5f;
        }
        this.f4054h = new a((int) (1769472.0f * f10));
        int i10 = (int) (f10 * 2000000.0f);
        this.f4052f = new b(i10);
        this.f4053g = (int) (i10 * 0.75d);
    }

    public static void s(c cVar, int i10) {
        int i11;
        byte[] bArr = cVar.f4066c;
        if (bArr != null && bArr.length != 0) {
            Reference<Bitmap> reference = cVar.f4065b;
            if (reference != null) {
                Bitmap bitmap = reference.get();
                cVar.f4064a = bitmap;
                if (bitmap != null) {
                    return;
                }
            }
            try {
                int c10 = C0843d.c(bArr);
                if (c10 > i10) {
                    i11 = C0843d.b(c10, i10);
                } else {
                    i11 = 1;
                }
                if (C0846g.c()) {
                    Log.d("ContactPhotoManager", "requestedExtent = " + i10 + " ,originalSmallerExtent = " + c10 + " ,sampleSize = " + i11);
                }
                Bitmap a10 = C0843d.a(bArr, i11);
                cVar.f4064a = a10;
                cVar.f4065b = new SoftReference(a10);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    @Override // V6.f
    public void d(ImageView imageView, long j10, boolean z10, boolean z11, f.c cVar) {
        if (imageView == null) {
            return;
        }
        if (j10 == 0) {
            cVar.a(imageView, z10, z11);
            this.f4055i.remove(imageView);
        } else {
            v(imageView, e.e(j10, z10, z11, cVar));
        }
    }

    @Override // V6.f
    public void f(ImageView imageView, Uri uri, boolean z10, boolean z11, f.c cVar) {
        u(imageView, uri, -1, z10, z11, cVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            if (!this.f4061o) {
                x();
            }
            return true;
        }
        this.f4060n = false;
        if (!this.f4061o) {
            r();
            this.f4059m.g();
        }
        return true;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 >= 60) {
            q();
        }
    }

    public final void p(Object obj, byte[] bArr, boolean z10, int i10) {
        c cVar = new c(bArr);
        cVar.f4067d = true;
        if (!z10) {
            s(cVar, i10);
        }
        this.f4052f.put(obj, cVar);
    }

    public void q() {
        d dVar = this.f4059m;
        if (dVar != null) {
            dVar.quit();
            this.f4059m = null;
        }
        this.f4055i.clear();
        this.f4052f.evictAll();
        this.f4054h.evictAll();
    }

    public void r() {
        if (this.f4059m == null) {
            d dVar = new d(this.f4051e.getContentResolver());
            this.f4059m = dVar;
            dVar.start();
        }
    }

    public final boolean t(ImageView imageView, e eVar) {
        c cVar = this.f4052f.get(eVar.g());
        if (cVar == null) {
            eVar.d(imageView);
            return false;
        }
        if (cVar.f4066c == null) {
            eVar.d(imageView);
            return cVar.f4067d;
        }
        s(cVar, eVar.h());
        Bitmap bitmap = cVar.f4064a;
        if (bitmap == null) {
            if (C0846g.c()) {
                Log.d("ContactPhotoManager", "holder.bitmap is null");
            }
            eVar.d(imageView);
            return cVar.f4067d;
        }
        imageView.setImageBitmap(bitmap);
        Bitmap bitmap2 = cVar.f4064a;
        if (bitmap2 != null) {
            this.f4054h.put(eVar, bitmap2);
        }
        cVar.f4064a = null;
        return cVar.f4067d;
    }

    public void u(ImageView imageView, Uri uri, int i10, boolean z10, boolean z11, f.c cVar) {
        if (imageView == null) {
            return;
        }
        if (uri == null) {
            cVar.a(imageView, z10, z11);
            this.f4055i.remove(imageView);
        } else {
            v(imageView, e.f(uri, i10, z10, z11, cVar));
        }
    }

    public final void v(ImageView imageView, e eVar) {
        if (t(imageView, eVar)) {
            this.f4055i.remove(imageView);
            return;
        }
        this.f4055i.put(imageView, eVar);
        if (!this.f4061o) {
            y();
        }
    }

    public final void w(Set<Long> set, Set<String> set2, Set<e> set3) {
        set.clear();
        set2.clear();
        set3.clear();
        this.f4050d.clear();
        for (e eVar : this.f4055i.values()) {
            c cVar = this.f4052f.get(eVar);
            if (cVar == null || !cVar.f4067d) {
                if (eVar.i()) {
                    set3.add(eVar);
                } else {
                    set.add(Long.valueOf(eVar.f4078a));
                    if (eVar.f4078a < 0) {
                        this.f4050d.add(String.valueOf(0 - eVar.f4078a));
                    } else {
                        set2.add(String.valueOf(eVar.f4078a));
                    }
                }
            }
        }
    }

    public final void x() {
        Iterator<Map.Entry<ImageView, e>> it = this.f4055i.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ImageView, e> next = it.next();
            if (t(next.getKey(), next.getValue())) {
                it.remove();
            }
        }
        z();
        if (!this.f4055i.isEmpty()) {
            y();
        }
    }

    public final void y() {
        if (!this.f4060n) {
            this.f4060n = true;
            this.f4056j.sendEmptyMessage(1);
        }
    }

    public final void z() {
        Iterator<c> it = this.f4052f.snapshot().values().iterator();
        while (it.hasNext()) {
            it.next().f4064a = null;
        }
    }

    /* compiled from: ContactPhotoManagerImpl.java */
    /* loaded from: classes3.dex */
    public class a extends LruCache<Object, Bitmap> {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(Object obj, Bitmap bitmap) {
            return bitmap.getByteCount();
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z10, Object obj, Bitmap bitmap, Bitmap bitmap2) {
        }
    }

    /* compiled from: ContactPhotoManagerImpl.java */
    /* loaded from: classes3.dex */
    public class b extends LruCache<Object, c> {
        public b(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(Object obj, c cVar) {
            byte[] bArr = cVar.f4066c;
            if (bArr != null) {
                return bArr.length;
            }
            return 0;
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z10, Object obj, c cVar, c cVar2) {
        }
    }
}
