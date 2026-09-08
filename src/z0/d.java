package Z0;

import N0.f;
import U7.g;
import Z0.b;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.model.Account;
import com.google.common.collect.n;
import com.google.common.collect.y;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ContactPhotoManager.java */
/* loaded from: classes.dex */
public class d extends Z0.b implements Handler.Callback {

    /* renamed from: A, reason: collision with root package name */
    public static final c f5790A;

    /* renamed from: B, reason: collision with root package name */
    public static int f5791B;

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f5792y = new String[0];

    /* renamed from: z, reason: collision with root package name */
    public static final String[] f5793z = {BreenoCallContract.BaseColumns._ID, "data15"};

    /* renamed from: g, reason: collision with root package name */
    public final Context f5795g;

    /* renamed from: h, reason: collision with root package name */
    public final LruCache<Object, c> f5796h;

    /* renamed from: j, reason: collision with root package name */
    public final int f5798j;

    /* renamed from: k, reason: collision with root package name */
    public final LruCache<Object, Bitmap> f5799k;

    /* renamed from: n, reason: collision with root package name */
    public HandlerThreadC0091d f5802n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5803o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5804p;

    /* renamed from: x, reason: collision with root package name */
    public String f5807x;

    /* renamed from: f, reason: collision with root package name */
    public final Set<String> f5794f = y.d();

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f5797i = true;

    /* renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<ImageView, e> f5800l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public Handler f5801m = new Handler(Looper.getMainLooper(), this);

    /* renamed from: q, reason: collision with root package name */
    public final AtomicInteger f5805q = new AtomicInteger();

    /* renamed from: r, reason: collision with root package name */
    public final AtomicInteger f5806r = new AtomicInteger();

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f5810a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5811b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f5812c = true;

        /* renamed from: d, reason: collision with root package name */
        public Bitmap f5813d;

        /* renamed from: e, reason: collision with root package name */
        public Reference<Bitmap> f5814e;

        /* renamed from: f, reason: collision with root package name */
        public int f5815f;

        public c(byte[] bArr, int i10) {
            this.f5810a = bArr;
            this.f5811b = i10;
        }
    }

    /* compiled from: ContactPhotoManager.java */
    /* renamed from: Z0.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerThreadC0091d extends HandlerThread implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f5816a;

        /* renamed from: b, reason: collision with root package name */
        public final StringBuilder f5817b;

        /* renamed from: c, reason: collision with root package name */
        public final Set<Long> f5818c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f5819d;

        /* renamed from: e, reason: collision with root package name */
        public final Set<e> f5820e;

        /* renamed from: f, reason: collision with root package name */
        public final List<Long> f5821f;

        /* renamed from: g, reason: collision with root package name */
        public Handler f5822g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f5823h;

        /* renamed from: i, reason: collision with root package name */
        public int f5824i;

        public HandlerThreadC0091d(ContentResolver contentResolver) {
            super("ContactPhotoLoader");
            this.f5817b = new StringBuilder();
            this.f5818c = y.d();
            this.f5819d = y.d();
            this.f5820e = y.d();
            this.f5821f = n.f();
            this.f5824i = 0;
            this.f5816a = contentResolver;
        }

        public void a() {
            if (this.f5822g == null && getLooper() != null) {
                this.f5822g = new Handler(getLooper(), this);
            }
        }

        public final void b() {
            if (d.this.f5795g.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
                d.this.O(this.f5818c, this.f5819d, this.f5820e);
                c(false);
                d();
                h();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x011f, code lost:
        
            if (r10 != null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0121, code lost:
        
            r10.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0148, code lost:
        
            r9 = r17.f5818c.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0152, code lost:
        
            if (r9.hasNext() == false) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0154, code lost:
        
            r0 = r9.next();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0162, code lost:
        
            if (android.provider.ContactsContract.isProfileId(r0.longValue()) == false) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0164, code lost:
        
            r10 = r17.f5816a.query(android.content.ContentUris.withAppendedId(android.provider.ContactsContract.Data.CONTENT_URI, r0.longValue()), Z0.d.f5793z, null, null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x017c, code lost:
        
            if (r10 == null) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0182, code lost:
        
            if (r10.moveToFirst() == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0184, code lost:
        
            r0 = r10.getBlob(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0188, code lost:
        
            if (r0 != null) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x018a, code lost:
        
            r0 = new byte[0];
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0192, code lost:
        
            r17.f5825j.H(java.lang.Long.valueOf(r10.getLong(0)), r0, r18, -1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x01a5, code lost:
        
            if (r10 == null) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x01a7, code lost:
        
            r10.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x01a0, code lost:
        
            r17.f5825j.H(r0, null, r18, -1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0190, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x01af, code lost:
        
            H7.b.c("ContactPhotoManager", "loadThumbnails error2:" + r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01c3, code lost:
        
            if (r10 != null) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x018d, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x018e, code lost:
        
            r8 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01c6, code lost:
        
            if (r8 != null) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01c8, code lost:
        
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01cb, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01ad, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01ae, code lost:
        
            r10 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x01ab, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01cc, code lost:
        
            r17.f5825j.H(r0, null, r18, -1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x01d3, code lost:
        
            r17.f5825j.f5801m.sendEmptyMessage(2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x01dc, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0145, code lost:
        
            if (r10 == null) goto L63;
         */
        /* JADX WARN: Removed duplicated region for block: B:103:0x01df  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x01e4  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0142  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(boolean r18) {
            /*
                Method dump skipped, instructions count: 488
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: Z0.d.HandlerThreadC0091d.c(boolean):void");
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:21|22|(2:27|(5:35|36|(3:37|38|(1:40)(1:41))|42|43)(5:29|30|(1:32)|33|34))|51|(1:53)|54|55|56|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
        
            r9.disconnect();
            r9 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x009c A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d() {
            /*
                Method dump skipped, instructions count: 331
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: Z0.d.HandlerThreadC0091d.d():void");
        }

        public final void e() {
            int i10 = this.f5824i;
            if (i10 == 2) {
                return;
            }
            if (i10 == 0) {
                f();
                if (this.f5821f.isEmpty()) {
                    this.f5824i = 2;
                } else {
                    this.f5824i = 1;
                }
                h();
                return;
            }
            if (d.this.f5796h.size() > d.this.f5798j) {
                this.f5824i = 2;
                return;
            }
            this.f5818c.clear();
            this.f5819d.clear();
            d.this.f5794f.clear();
            int size = this.f5821f.size();
            int i11 = 0;
            while (size > 0 && this.f5818c.size() < 25) {
                size--;
                i11++;
                Long l10 = this.f5821f.get(size);
                this.f5818c.add(l10);
                if (l10.longValue() < 0) {
                    d.this.f5794f.add(String.valueOf(0 - l10.longValue()));
                } else {
                    this.f5819d.add(l10.toString());
                }
                this.f5821f.remove(size);
            }
            c(true);
            if (size == 0) {
                this.f5824i = 2;
            }
            if (Log.isLoggable("ContactPhotoManager", 2)) {
                H7.b.h("ContactPhotoManager", "Preloaded " + i11 + " photos.  Cached bytes: " + d.this.f5796h.size());
            }
            h();
        }

        public final void f() {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.f5816a.query(ContactsContract.Contacts.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0L)).appendQueryParameter("limit", String.valueOf(100)).build(), new String[]{"photo_id"}, "photo_id NOT NULL AND photo_id!=0", null, "starred DESC, last_time_contacted DESC");
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            this.f5821f.add(0, Long.valueOf(cursor.getLong(0)));
                        }
                    }
                    for (int i10 = 1; i10 <= 39; i10++) {
                        this.f5821f.add(0, Long.valueOf(-i10));
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e10) {
                    H7.b.c("ContactPhotoManager", "This Exception e:" + e10);
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
            Handler handler = this.f5822g;
            if (handler == null) {
                return;
            }
            handler.removeMessages(0);
            this.f5822g.sendEmptyMessage(1);
        }

        public void h() {
            if (this.f5824i == 2) {
                return;
            }
            a();
            Handler handler = this.f5822g;
            if (handler == null || handler.hasMessages(1)) {
                return;
            }
            this.f5822g.sendEmptyMessageDelayed(0, 1000L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 == 1) {
                    b();
                }
            } else {
                e();
            }
            return true;
        }
    }

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f5826a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f5827b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5828c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5829d;

        /* renamed from: e, reason: collision with root package name */
        public final b.AbstractC0090b f5830e;

        /* renamed from: f, reason: collision with root package name */
        public final b.c f5831f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f5832g;

        public e(long j10, Uri uri, int i10, boolean z10, boolean z11, b.AbstractC0090b abstractC0090b, b.c cVar) {
            this.f5826a = j10;
            this.f5827b = uri;
            this.f5828c = z10;
            this.f5832g = z11;
            this.f5829d = i10;
            this.f5830e = abstractC0090b;
            this.f5831f = cVar;
        }

        public static e e(long j10, boolean z10, boolean z11, b.AbstractC0090b abstractC0090b, b.c cVar) {
            return new e(j10, null, -1, z10, z11, abstractC0090b, cVar);
        }

        public static e f(Uri uri, int i10, boolean z10, boolean z11, b.AbstractC0090b abstractC0090b, b.c cVar) {
            return new e(0L, uri, i10, z10, z11, abstractC0090b, cVar);
        }

        public static e g(Uri uri, long j10, int i10, boolean z10, boolean z11, b.AbstractC0090b abstractC0090b, b.c cVar) {
            return new e(j10, uri, i10, z10, z11, abstractC0090b, cVar);
        }

        public void d(ImageView imageView, boolean z10) {
            b.c cVar = this.f5831f;
            if (cVar == null) {
                return;
            }
            this.f5830e.a(imageView, this.f5829d, this.f5828c, cVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f5826a == eVar.f5826a && this.f5829d == eVar.f5829d && g.a(this.f5827b, eVar.f5827b)) {
                return true;
            }
            return false;
        }

        public long h() {
            return this.f5826a;
        }

        public int hashCode() {
            int hashCode;
            long j10 = this.f5826a;
            int i10 = (((((int) (j10 ^ (j10 >>> 32))) + 31) * 31) + this.f5829d) * 31;
            Uri uri = this.f5827b;
            if (uri == null) {
                hashCode = 0;
            } else {
                hashCode = uri.hashCode();
            }
            return i10 + hashCode;
        }

        public Object i() {
            Uri uri = this.f5827b;
            if (uri == null) {
                return Long.valueOf(this.f5826a);
            }
            return uri;
        }

        public int j() {
            return this.f5829d;
        }

        public Uri k() {
            return this.f5827b;
        }

        public boolean l() {
            if (this.f5827b != null) {
                return true;
            }
            return false;
        }
    }

    static {
        c cVar = new c(new byte[0], 0);
        f5790A = cVar;
        cVar.f5814e = new SoftReference(null);
    }

    public d(Context context) {
        float f10;
        this.f5795g = context;
        if (((ActivityManager) context.getSystemService("activity")).isLowRamDevice()) {
            f10 = 0.5f;
        } else {
            f10 = 1.0f;
        }
        this.f5799k = new a((int) (1769472.0f * f10));
        int i10 = (int) (2000000.0f * f10);
        this.f5796h = new b(i10);
        this.f5798j = (int) (i10 * 0.75d);
        H7.b.e("ContactPhotoManager", "Cache adj: " + f10);
        f5791B = context.getResources().getDimensionPixelSize(f.f1887m);
        if (this.f5807x == null) {
            this.f5807x = "";
        }
    }

    public static void L(c cVar, int i10) {
        Reference<Bitmap> reference;
        int d10 = I7.a.d(cVar.f5811b, i10);
        byte[] bArr = cVar.f5810a;
        if (bArr != null && bArr.length != 0) {
            if (d10 == cVar.f5815f && (reference = cVar.f5814e) != null) {
                Bitmap bitmap = reference.get();
                cVar.f5813d = bitmap;
                if (bitmap != null) {
                    return;
                }
            }
            try {
                Bitmap b10 = I7.a.b(bArr, d10);
                if (b10 == null) {
                    return;
                }
                int height = b10.getHeight();
                int width = b10.getWidth();
                if (height != width && Math.min(height, width) <= f5791B * 2) {
                    int min = Math.min(height, width);
                    b10 = ThumbnailUtils.extractThumbnail(b10, min, min);
                }
                cVar.f5815f = d10;
                cVar.f5813d = b10;
                cVar.f5814e = new SoftReference(b10);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    public final void H(Object obj, byte[] bArr, boolean z10, int i10) {
        int f10;
        if (bArr == null) {
            f10 = -1;
        } else {
            f10 = I7.a.f(bArr);
        }
        c cVar = new c(bArr, f10);
        if (!z10) {
            L(cVar, i10);
        }
        if (bArr != null) {
            this.f5796h.put(obj, cVar);
            if (this.f5796h.get(obj) != cVar) {
                H7.b.i("ContactPhotoManager", "Bitmap too big to fit in cache.");
                this.f5796h.put(obj, f5790A);
            }
        } else {
            this.f5796h.put(obj, f5790A);
        }
        this.f5797i = false;
    }

    public final void I(ImageView imageView, Uri uri, Account account, int i10, boolean z10, boolean z11, b.AbstractC0090b abstractC0090b) {
        b.c e10 = Z0.b.e(uri);
        e10.f5788f = z11;
        abstractC0090b.b(imageView, account, i10, z10, e10);
    }

    public void J() {
        if (this.f5802n == null) {
            HandlerThreadC0091d handlerThreadC0091d = new HandlerThreadC0091d(this.f5795g.getContentResolver());
            this.f5802n = handlerThreadC0091d;
            handlerThreadC0091d.start();
        }
    }

    public final Drawable K(Resources resources, Bitmap bitmap, e eVar) {
        if (eVar.f5832g) {
            C.c a10 = C.d.a(resources, bitmap);
            a10.e(true);
            a10.f(bitmap.getHeight() / 2);
            return a10;
        }
        return new BitmapDrawable(resources, bitmap);
    }

    public final boolean M(ImageView imageView, e eVar, boolean z10) {
        Bitmap bitmap;
        c cVar = this.f5796h.get(eVar.i());
        if (cVar == null) {
            eVar.d(imageView, eVar.f5832g);
            return false;
        }
        byte[] bArr = cVar.f5810a;
        if (bArr != null && bArr.length != 0) {
            Reference<Bitmap> reference = cVar.f5814e;
            if (reference == null) {
                bitmap = null;
            } else {
                bitmap = reference.get();
            }
            if (bitmap == null) {
                if (cVar.f5810a.length < 8192) {
                    L(cVar, eVar.j());
                    bitmap = cVar.f5813d;
                    if (bitmap == null) {
                        return false;
                    }
                } else {
                    eVar.d(imageView, eVar.f5832g);
                    return false;
                }
            }
            Drawable drawable = imageView.getDrawable();
            if (z10 && drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                if (drawable instanceof TransitionDrawable) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                    drawableArr[0] = transitionDrawable.getDrawable(transitionDrawable.getNumberOfLayers() - 1);
                } else {
                    drawableArr[0] = drawable;
                }
                drawableArr[1] = K(this.f5795g.getResources(), bitmap, eVar);
                TransitionDrawable transitionDrawable2 = new TransitionDrawable(drawableArr);
                imageView.setImageDrawable(transitionDrawable2);
                transitionDrawable2.startTransition(200);
            } else {
                imageView.setImageDrawable(K(this.f5795g.getResources(), bitmap, eVar));
            }
            if (bitmap.getByteCount() < this.f5799k.maxSize() / 6) {
                this.f5799k.put(eVar.i(), bitmap);
            }
            cVar.f5813d = null;
            return cVar.f5812c;
        }
        eVar.d(imageView, eVar.f5832g);
        return cVar.f5812c;
    }

    public final void N(ImageView imageView, e eVar) {
        if (M(imageView, eVar, false)) {
            this.f5800l.remove(imageView);
            return;
        }
        this.f5800l.put(imageView, eVar);
        if (!this.f5804p) {
            Q();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        if (r3.f5812c != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(java.util.Set<java.lang.Long> r10, java.util.Set<java.lang.String> r11, java.util.Set<Z0.d.e> r12) {
        /*
            r9 = this;
            r10.clear()
            r11.clear()
            r12.clear()
            java.util.Set<java.lang.String> r0 = r9.f5794f
            r0.clear()
            java.util.concurrent.ConcurrentHashMap<android.widget.ImageView, Z0.d$e> r0 = r9.f5800l
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L19:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L93
            java.lang.Object r2 = r0.next()
            Z0.d$e r2 = (Z0.d.e) r2
            android.util.LruCache<java.lang.Object, Z0.d$c> r3 = r9.f5796h
            java.lang.Object r4 = r2.i()
            java.lang.Object r3 = r3.get(r4)
            Z0.d$c r3 = (Z0.d.c) r3
            Z0.d$c r4 = Z0.d.f5790A
            if (r3 != r4) goto L36
            goto L19
        L36:
            if (r3 == 0) goto L53
            byte[] r4 = r3.f5810a
            if (r4 == 0) goto L53
            boolean r4 = r3.f5812c
            if (r4 == 0) goto L53
            java.lang.ref.Reference<android.graphics.Bitmap> r4 = r3.f5814e
            if (r4 == 0) goto L4a
            java.lang.Object r4 = r4.get()
            if (r4 != 0) goto L53
        L4a:
            int r1 = r2.j()
            L(r3, r1)
            r1 = 1
            goto L19
        L53:
            if (r3 == 0) goto L59
            boolean r3 = r3.f5812c
            if (r3 != 0) goto L19
        L59:
            boolean r3 = r2.l()
            if (r3 == 0) goto L63
            r12.add(r2)
            goto L19
        L63:
            long r3 = r2.h()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r10.add(r3)
            long r3 = Z0.d.e.a(r2)
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L87
            java.util.Set<java.lang.String> r3 = r9.f5794f
            long r7 = Z0.d.e.a(r2)
            long r5 = r5 - r7
            java.lang.String r2 = java.lang.String.valueOf(r5)
            r3.add(r2)
            goto L19
        L87:
            long r2 = Z0.d.e.a(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r11.add(r2)
            goto L19
        L93:
            if (r1 == 0) goto L9b
            android.os.Handler r9 = r9.f5801m
            r10 = 2
            r9.sendEmptyMessage(r10)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z0.d.O(java.util.Set, java.util.Set, java.util.Set):void");
    }

    public final void P() {
        Iterator<Map.Entry<ImageView, e>> it = this.f5800l.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ImageView, e> next = it.next();
            if (M(next.getKey(), next.getValue(), false)) {
                it.remove();
            }
        }
        R();
        if (!this.f5800l.isEmpty()) {
            Q();
        }
    }

    public final void Q() {
        if (!this.f5803o) {
            this.f5803o = true;
            this.f5801m.sendEmptyMessage(1);
        }
    }

    public final void R() {
        Iterator<c> it = this.f5796h.snapshot().values().iterator();
        while (it.hasNext()) {
            it.next().f5813d = null;
        }
    }

    @Override // Z0.b
    public void a() {
        this.f5800l.clear();
        this.f5796h.evictAll();
        this.f5799k.evictAll();
    }

    @Override // Z0.b
    public void b(long j10) {
        this.f5796h.remove(Long.valueOf(j10));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            if (!this.f5804p) {
                P();
            }
            return true;
        }
        this.f5803o = false;
        if (!this.f5804p) {
            J();
            this.f5802n.g();
        }
        return true;
    }

    @Override // Z0.b
    public void l(ImageView imageView, Uri uri, long j10, Account account, int i10, boolean z10, boolean z11, b.c cVar, b.AbstractC0090b abstractC0090b) {
        if (imageView == null) {
            return;
        }
        if (uri == null) {
            abstractC0090b.b(imageView, account, i10, z10, cVar);
            this.f5800l.remove(imageView);
        } else if (h(uri)) {
            I(imageView, uri, account, i10, z10, z11, abstractC0090b);
        } else {
            N(imageView, e.g(uri, j10, i10, z10, z11, abstractC0090b, cVar));
        }
    }

    @Override // Z0.b
    public void n(ImageView imageView, Uri uri, Account account, int i10, boolean z10, boolean z11, b.c cVar, b.AbstractC0090b abstractC0090b) {
        if (imageView == null) {
            return;
        }
        if (uri == null) {
            abstractC0090b.b(imageView, account, i10, z10, cVar);
            this.f5800l.remove(imageView);
        } else if (h(uri)) {
            I(imageView, uri, account, i10, z10, z11, abstractC0090b);
        } else {
            N(imageView, e.f(uri, i10, z10, z11, abstractC0090b, cVar));
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 >= 60) {
            a();
        }
    }

    @Override // Z0.b
    public void p(ImageView imageView, long j10, Account account, boolean z10, boolean z11, b.c cVar, b.AbstractC0090b abstractC0090b) {
        if (imageView == null) {
            return;
        }
        if (j10 == 0) {
            abstractC0090b.b(imageView, account, -1, z10, cVar);
            this.f5800l.remove(imageView);
        } else {
            N(imageView, e.e(j10, z10, z11, abstractC0090b, cVar));
        }
    }

    @Override // Z0.b
    public void r() {
        this.f5804p = true;
    }

    @Override // Z0.b
    public void s() {
        J();
        this.f5802n.h();
    }

    @Override // Z0.b
    public void t() {
        if (this.f5797i) {
            return;
        }
        this.f5797i = true;
        for (c cVar : this.f5796h.snapshot().values()) {
            if (cVar != f5790A) {
                cVar.f5812c = false;
            }
        }
    }

    @Override // Z0.b
    public void v(ImageView imageView) {
        imageView.setImageDrawable(null);
        this.f5800l.remove(imageView);
    }

    @Override // Z0.b
    public void w() {
        this.f5804p = false;
        if (!this.f5800l.isEmpty()) {
            Q();
        }
    }

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
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

    /* compiled from: ContactPhotoManager.java */
    /* loaded from: classes.dex */
    public class b extends LruCache<Object, c> {
        public b(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(Object obj, c cVar) {
            byte[] bArr = cVar.f5810a;
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
