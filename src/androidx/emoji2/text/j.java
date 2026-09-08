package androidx.emoji2.text;

import G.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.e;
import androidx.emoji2.text.j;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: FontRequestEmojiCompatConfig.java */
/* loaded from: classes.dex */
public class j extends e.c {

    /* renamed from: k, reason: collision with root package name */
    public static final a f9809k = new a();

    /* compiled from: FontRequestEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return G.g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, G.e eVar) {
            return G.g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* compiled from: FontRequestEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class b implements e.h {

        /* renamed from: a, reason: collision with root package name */
        public final Context f9810a;

        /* renamed from: b, reason: collision with root package name */
        public final G.e f9811b;

        /* renamed from: c, reason: collision with root package name */
        public final a f9812c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f9813d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Handler f9814e;

        /* renamed from: f, reason: collision with root package name */
        public Executor f9815f;

        /* renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f9816g;

        /* renamed from: h, reason: collision with root package name */
        public e.i f9817h;

        /* renamed from: i, reason: collision with root package name */
        public ContentObserver f9818i;

        /* renamed from: j, reason: collision with root package name */
        public Runnable f9819j;

        public b(Context context, G.e eVar, a aVar) {
            I.h.f(context, "Context cannot be null");
            I.h.f(eVar, "FontRequest cannot be null");
            this.f9810a = context.getApplicationContext();
            this.f9811b = eVar;
            this.f9812c = aVar;
        }

        @Override // androidx.emoji2.text.e.h
        public void a(e.i iVar) {
            I.h.f(iVar, "LoaderCallback cannot be null");
            synchronized (this.f9813d) {
                this.f9817h = iVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f9813d) {
                try {
                    this.f9817h = null;
                    ContentObserver contentObserver = this.f9818i;
                    if (contentObserver != null) {
                        this.f9812c.c(this.f9810a, contentObserver);
                        this.f9818i = null;
                    }
                    Handler handler = this.f9814e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f9819j);
                    }
                    this.f9814e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f9816g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f9815f = null;
                    this.f9816g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.f9813d) {
                try {
                    if (this.f9817h == null) {
                        return;
                    }
                    try {
                        g.b e10 = e();
                        int b10 = e10.b();
                        if (b10 == 2) {
                            synchronized (this.f9813d) {
                            }
                        }
                        if (b10 == 0) {
                            try {
                                F.h.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                Typeface a10 = this.f9812c.a(this.f9810a, e10);
                                ByteBuffer a11 = B.h.a(this.f9810a, null, e10.d());
                                if (a11 != null && a10 != null) {
                                    m b11 = m.b(a10, a11);
                                    F.h.b();
                                    synchronized (this.f9813d) {
                                        try {
                                            e.i iVar = this.f9817h;
                                            if (iVar != null) {
                                                iVar.b(b11);
                                            }
                                        } finally {
                                        }
                                    }
                                    b();
                                    return;
                                }
                                throw new RuntimeException("Unable to open file.");
                            } catch (Throwable th) {
                                F.h.b();
                                throw th;
                            }
                        }
                        throw new RuntimeException("fetchFonts result is not OK. (" + b10 + ")");
                    } catch (Throwable th2) {
                        synchronized (this.f9813d) {
                            try {
                                e.i iVar2 = this.f9817h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void d() {
            synchronized (this.f9813d) {
                try {
                    if (this.f9817h == null) {
                        return;
                    }
                    if (this.f9815f == null) {
                        ThreadPoolExecutor b10 = androidx.emoji2.text.b.b("emojiCompat");
                        this.f9816g = b10;
                        this.f9815f = b10;
                    }
                    this.f9815f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.b.this.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final g.b e() {
            try {
                g.a b10 = this.f9812c.b(this.f9810a, this.f9811b);
                if (b10.e() == 0) {
                    g.b[] c10 = b10.c();
                    if (c10 != null && c10.length != 0) {
                        return c10[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b10.e() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        public void f(Executor executor) {
            synchronized (this.f9813d) {
                this.f9815f = executor;
            }
        }
    }

    public j(Context context, G.e eVar) {
        super(new b(context, eVar, f9809k));
    }

    public j c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
