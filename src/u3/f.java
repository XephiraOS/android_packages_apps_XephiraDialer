package U3;

import U3.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.oua.ocr.ContactInfo;
import com.oua.ocr.ContactScanner;
import java.util.List;

/* compiled from: BCRunner.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: g, reason: collision with root package name */
    public static volatile f f3844g;

    /* renamed from: a, reason: collision with root package name */
    public ContactScanner f3845a;

    /* renamed from: d, reason: collision with root package name */
    public HandlerThread f3848d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f3849e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3846b = false;

    /* renamed from: c, reason: collision with root package name */
    public S3.e f3847c = new S3.e();

    /* renamed from: f, reason: collision with root package name */
    public Handler f3850f = new Handler(Looper.getMainLooper());

    /* compiled from: BCRunner.java */
    /* loaded from: classes3.dex */
    public interface a<Param> {
        void a(Param param);
    }

    public static f i() {
        if (f3844g == null) {
            synchronized (f.class) {
                try {
                    if (f3844g == null) {
                        f3844g = new f();
                    }
                } finally {
                }
            }
        }
        return f3844g;
    }

    public static /* synthetic */ void n(a aVar) {
        aVar.a(new Exception("bitmap is null"));
    }

    public static /* synthetic */ void o(Exception exc, a aVar) {
        H7.b.c("BCRunner", exc.toString());
        aVar.a(exc);
    }

    public void f() {
        Handler handler = this.f3849e;
        if (handler != null) {
            handler.post(new Runnable() { // from class: U3.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.l();
                }
            });
        }
    }

    public final void g() {
        ContactScanner contactScanner = this.f3845a;
        if (contactScanner != null) {
            contactScanner.close();
            this.f3845a = null;
        }
    }

    public void h(final String str, final a<List<ContactInfo.ContactItem>> aVar, final a<Exception> aVar2) {
        if (this.f3846b) {
            this.f3849e.post(new Runnable() { // from class: U3.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.p(str, aVar, aVar2);
                }
            });
        }
    }

    public boolean j(Context context) {
        try {
            boolean z10 = true;
            if (this.f3846b) {
                return true;
            }
            HandlerThread handlerThread = new HandlerThread("oua_bc");
            this.f3848d = handlerThread;
            handlerThread.start();
            this.f3849e = new Handler(this.f3848d.getLooper());
            if (k(context) == null) {
                z10 = false;
            }
            this.f3846b = z10;
            return z10;
        } catch (Exception e10) {
            H7.b.c("BCRunner", e10.toString());
            this.f3846b = false;
            return false;
        }
    }

    public final ContactScanner k(Context context) {
        ContactScanner create = ContactScanner.create();
        this.f3845a = create;
        create.init(context.getApplicationContext(), "55c28c17-e754-4e3a-a9b0-74143fd44668");
        H7.b.b("BCRunner", "initOCR ");
        return this.f3845a;
    }

    public final /* synthetic */ void l() {
        try {
            H7.b.b("BCRunner", "close");
            g();
            this.f3848d.quitSafely();
            this.f3846b = false;
        } catch (Exception e10) {
            H7.b.c("BCRunner", e10.toString());
        }
    }

    public final /* synthetic */ void p(String str, final a aVar, final a aVar2) {
        try {
            H7.b.b("BCRunner", "success!");
            Bitmap b10 = this.f3847c.b(str, 800, 800);
            if (b10 != null) {
                final List<ContactInfo.ContactItem> list = this.f3845a.getContactInfo(b10).contactItems;
                this.f3850f.post(new Runnable() { // from class: U3.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.this.a(list);
                    }
                });
            } else {
                this.f3850f.post(new Runnable() { // from class: U3.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.n(f.a.this);
                    }
                });
            }
        } catch (Exception e10) {
            this.f3850f.post(new Runnable() { // from class: U3.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.o(e10, aVar2);
                }
            });
        }
    }
}
