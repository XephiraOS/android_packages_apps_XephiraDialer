package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p.C1416b;

/* compiled from: EmojiCompat.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f9751o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static final Object f9752p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static volatile e f9753q;

    /* renamed from: b, reason: collision with root package name */
    public final Set<f> f9755b;

    /* renamed from: e, reason: collision with root package name */
    public final b f9758e;

    /* renamed from: f, reason: collision with root package name */
    public final h f9759f;

    /* renamed from: g, reason: collision with root package name */
    public final j f9760g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f9761h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9762i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f9763j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9764k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9765l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9766m;

    /* renamed from: n, reason: collision with root package name */
    public final InterfaceC0121e f9767n;

    /* renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f9754a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    public volatile int f9756c = 3;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f9757d = new Handler(Looper.getMainLooper());

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.h f9768b;

        /* renamed from: c, reason: collision with root package name */
        public volatile m f9769c;

        /* compiled from: EmojiCompat.java */
        /* renamed from: androidx.emoji2.text.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0120a extends i {
            public C0120a() {
            }

            @Override // androidx.emoji2.text.e.i
            public void a(Throwable th) {
                a.this.f9771a.n(th);
            }

            @Override // androidx.emoji2.text.e.i
            public void b(m mVar) {
                a.this.d(mVar);
            }
        }

        public a(e eVar) {
            super(eVar);
        }

        @Override // androidx.emoji2.text.e.b
        public void a() {
            try {
                this.f9771a.f9759f.a(new C0120a());
            } catch (Throwable th) {
                this.f9771a.n(th);
            }
        }

        @Override // androidx.emoji2.text.e.b
        public CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f9768b.h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.e.b
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f9769c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f9771a.f9761h);
        }

        public void d(m mVar) {
            if (mVar == null) {
                this.f9771a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f9769c = mVar;
            m mVar2 = this.f9769c;
            j jVar = this.f9771a.f9760g;
            InterfaceC0121e interfaceC0121e = this.f9771a.f9767n;
            e eVar = this.f9771a;
            this.f9768b = new androidx.emoji2.text.h(mVar2, jVar, interfaceC0121e, eVar.f9762i, eVar.f9763j, androidx.emoji2.text.g.a());
            this.f9771a.o();
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final e f9771a;

        public b(e eVar) {
            this.f9771a = eVar;
        }

        public void a() {
            throw null;
        }

        public CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            throw null;
        }

        public void c(EditorInfo editorInfo) {
            throw null;
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final h f9772a;

        /* renamed from: b, reason: collision with root package name */
        public j f9773b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9774c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9775d;

        /* renamed from: e, reason: collision with root package name */
        public int[] f9776e;

        /* renamed from: f, reason: collision with root package name */
        public Set<f> f9777f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f9778g;

        /* renamed from: h, reason: collision with root package name */
        public int f9779h = -16711936;

        /* renamed from: i, reason: collision with root package name */
        public int f9780i = 0;

        /* renamed from: j, reason: collision with root package name */
        public InterfaceC0121e f9781j = new androidx.emoji2.text.d();

        public c(h hVar) {
            I.h.f(hVar, "metadataLoader cannot be null.");
            this.f9772a = hVar;
        }

        public final h a() {
            return this.f9772a;
        }

        public c b(int i10) {
            this.f9780i = i10;
            return this;
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static class d implements j {
        @Override // androidx.emoji2.text.e.j
        public androidx.emoji2.text.i a(o oVar) {
            return new p(oVar);
        }
    }

    /* compiled from: EmojiCompat.java */
    /* renamed from: androidx.emoji2.text.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0121e {
        boolean a(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final List<f> f9782a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f9783b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9784c;

        public g(f fVar, int i10) {
            this(Arrays.asList((f) I.h.f(fVar, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f9782a.size();
            int i10 = 0;
            if (this.f9784c != 1) {
                while (i10 < size) {
                    this.f9782a.get(i10).a(this.f9783b);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    this.f9782a.get(i10).b();
                    i10++;
                }
            }
        }

        public g(Collection<f> collection, int i10) {
            this(collection, i10, null);
        }

        public g(Collection<f> collection, int i10, Throwable th) {
            I.h.f(collection, "initCallbacks cannot be null");
            this.f9782a = new ArrayList(collection);
            this.f9784c = i10;
            this.f9783b = th;
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public interface h {
        void a(i iVar);
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(m mVar);
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public interface j {
        androidx.emoji2.text.i a(o oVar);
    }

    public e(c cVar) {
        this.f9761h = cVar.f9774c;
        this.f9762i = cVar.f9775d;
        this.f9763j = cVar.f9776e;
        this.f9764k = cVar.f9778g;
        this.f9765l = cVar.f9779h;
        this.f9759f = cVar.f9772a;
        this.f9766m = cVar.f9780i;
        this.f9767n = cVar.f9781j;
        C1416b c1416b = new C1416b();
        this.f9755b = c1416b;
        j jVar = cVar.f9773b;
        this.f9760g = jVar == null ? new d() : jVar;
        Set<f> set = cVar.f9777f;
        if (set != null && !set.isEmpty()) {
            c1416b.addAll(cVar.f9777f);
        }
        this.f9758e = new a(this);
        m();
    }

    public static e c() {
        e eVar;
        boolean z10;
        synchronized (f9751o) {
            eVar = f9753q;
            if (eVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            I.h.h(z10, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        return androidx.emoji2.text.h.b(inputConnection, editable, i10, i11, z10);
    }

    public static boolean g(Editable editable, int i10, KeyEvent keyEvent) {
        return androidx.emoji2.text.h.c(editable, i10, keyEvent);
    }

    public static e h(c cVar) {
        e eVar = f9753q;
        if (eVar == null) {
            synchronized (f9751o) {
                try {
                    eVar = f9753q;
                    if (eVar == null) {
                        eVar = new e(cVar);
                        f9753q = eVar;
                    }
                } finally {
                }
            }
        }
        return eVar;
    }

    public static boolean i() {
        if (f9753q != null) {
            return true;
        }
        return false;
    }

    public int d() {
        return this.f9765l;
    }

    public int e() {
        this.f9754a.readLock().lock();
        try {
            return this.f9756c;
        } finally {
            this.f9754a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f9764k;
    }

    public final boolean k() {
        if (e() == 1) {
            return true;
        }
        return false;
    }

    public void l() {
        boolean z10 = true;
        if (this.f9766m != 1) {
            z10 = false;
        }
        I.h.h(z10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f9754a.writeLock().lock();
        try {
            if (this.f9756c == 0) {
                return;
            }
            this.f9756c = 0;
            this.f9754a.writeLock().unlock();
            this.f9758e.a();
        } finally {
            this.f9754a.writeLock().unlock();
        }
    }

    public final void m() {
        this.f9754a.writeLock().lock();
        try {
            if (this.f9766m == 0) {
                this.f9756c = 0;
            }
            this.f9754a.writeLock().unlock();
            if (e() == 0) {
                this.f9758e.a();
            }
        } catch (Throwable th) {
            this.f9754a.writeLock().unlock();
            throw th;
        }
    }

    public void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f9754a.writeLock().lock();
        try {
            this.f9756c = 2;
            arrayList.addAll(this.f9755b);
            this.f9755b.clear();
            this.f9754a.writeLock().unlock();
            this.f9757d.post(new g(arrayList, this.f9756c, th));
        } catch (Throwable th2) {
            this.f9754a.writeLock().unlock();
            throw th2;
        }
    }

    public void o() {
        ArrayList arrayList = new ArrayList();
        this.f9754a.writeLock().lock();
        try {
            this.f9756c = 1;
            arrayList.addAll(this.f9755b);
            this.f9755b.clear();
            this.f9754a.writeLock().unlock();
            this.f9757d.post(new g(arrayList, this.f9756c));
        } catch (Throwable th) {
            this.f9754a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        int length;
        if (charSequence == null) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        return q(charSequence, 0, length);
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11) {
        return r(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12) {
        return s(charSequence, i10, i11, i12, 0);
    }

    public CharSequence s(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        I.h.h(k(), "Not initialized yet");
        I.h.d(i10, "start cannot be negative");
        I.h.d(i11, "end cannot be negative");
        I.h.d(i12, "maxEmojiCount cannot be negative");
        boolean z14 = false;
        if (i10 <= i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        I.h.b(z10, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        if (i10 <= charSequence.length()) {
            z11 = true;
        } else {
            z11 = false;
        }
        I.h.b(z11, "start should be < than charSequence length");
        if (i11 <= charSequence.length()) {
            z12 = true;
        } else {
            z12 = false;
        }
        I.h.b(z12, "end should be < than charSequence length");
        if (charSequence.length() != 0 && i10 != i11) {
            if (i13 != 1) {
                if (i13 != 2) {
                    z14 = this.f9761h;
                }
                z13 = z14;
            } else {
                z13 = true;
            }
            return this.f9758e.b(charSequence, i10, i11, i12, z13);
        }
        return charSequence;
    }

    public void t(f fVar) {
        I.h.f(fVar, "initCallback cannot be null");
        this.f9754a.writeLock().lock();
        try {
            if (this.f9756c != 1 && this.f9756c != 2) {
                this.f9755b.add(fVar);
                this.f9754a.writeLock().unlock();
            }
            this.f9757d.post(new g(fVar, this.f9756c));
            this.f9754a.writeLock().unlock();
        } catch (Throwable th) {
            this.f9754a.writeLock().unlock();
            throw th;
        }
    }

    public void u(f fVar) {
        I.h.f(fVar, "initCallback cannot be null");
        this.f9754a.writeLock().lock();
        try {
            this.f9755b.remove(fVar);
        } finally {
            this.f9754a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (k() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f9758e.c(editorInfo);
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }
}
