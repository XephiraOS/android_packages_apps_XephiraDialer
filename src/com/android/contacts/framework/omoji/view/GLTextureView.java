package com.android.contacts.framework.omoji.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.oplus.foundation.util.display.DisplayUtil;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* renamed from: k, reason: collision with root package name */
    public static final j f16228k = new j();

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<GLTextureView> f16229a;

    /* renamed from: b, reason: collision with root package name */
    public i f16230b;

    /* renamed from: c, reason: collision with root package name */
    public m f16231c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16232d;

    /* renamed from: e, reason: collision with root package name */
    public e f16233e;

    /* renamed from: f, reason: collision with root package name */
    public f f16234f;

    /* renamed from: g, reason: collision with root package name */
    public g f16235g;

    /* renamed from: h, reason: collision with root package name */
    public int f16236h;

    /* renamed from: i, reason: collision with root package name */
    public int f16237i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16238j;

    /* loaded from: classes.dex */
    public abstract class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public int[] f16239a;

        public a(int[] iArr) {
            this.f16239a = c(iArr);
        }

        @Override // com.android.contacts.framework.omoji.view.GLTextureView.e
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f16239a, null, 0, iArr)) {
                int i10 = iArr[0];
                if (i10 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i10];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f16239a, eGLConfigArr, i10, iArr)) {
                        EGLConfig b10 = b(egl10, eGLDisplay, eGLConfigArr);
                        if (b10 != null) {
                            return b10;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        public abstract EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public final int[] c(int[] iArr) {
            if (GLTextureView.this.f16237i != 2 && GLTextureView.this.f16237i != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i10 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            iArr2[i10] = 12352;
            if (GLTextureView.this.f16237i == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* loaded from: classes.dex */
    public class b extends a {

        /* renamed from: c, reason: collision with root package name */
        public int[] f16241c;

        /* renamed from: d, reason: collision with root package name */
        public int f16242d;

        /* renamed from: e, reason: collision with root package name */
        public int f16243e;

        /* renamed from: f, reason: collision with root package name */
        public int f16244f;

        /* renamed from: g, reason: collision with root package name */
        public int f16245g;

        /* renamed from: h, reason: collision with root package name */
        public int f16246h;

        /* renamed from: i, reason: collision with root package name */
        public int f16247i;

        public b(int i10, int i11, int i12, int i13, int i14, int i15) {
            super(new int[]{12324, i10, 12323, i11, 12322, i12, 12321, i13, 12325, i14, 12326, i15, 12344});
            this.f16241c = new int[1];
            this.f16242d = i10;
            this.f16243e = i11;
            this.f16244f = i12;
            this.f16245g = i13;
            this.f16246h = i14;
            this.f16247i = i15;
        }

        @Override // com.android.contacts.framework.omoji.view.GLTextureView.a
        public EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int d10 = d(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int d11 = d(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (d10 >= this.f16246h && d11 >= this.f16247i) {
                    int d12 = d(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int d13 = d(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int d14 = d(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int d15 = d(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (d12 == this.f16242d && d13 == this.f16243e && d14 == this.f16244f && d15 == this.f16245g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int d(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10, int i11) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i10, this.f16241c)) {
                return this.f16241c[0];
            }
            return i11;
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {

        /* renamed from: a, reason: collision with root package name */
        public int f16249a;

        @Override // com.android.contacts.framework.omoji.view.GLTextureView.f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.k("eglDestroyContex", egl10.eglGetError());
            }
        }

        @Override // com.android.contacts.framework.omoji.view.GLTextureView.f
        public EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f16249a, GLTextureView.this.f16237i, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.f16237i == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public c() {
            this.f16249a = 12440;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements g {
        public d() {
        }

        @Override // com.android.contacts.framework.omoji.view.GLTextureView.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        @Override // com.android.contacts.framework.omoji.view.GLTextureView.g
        public EGLSurface b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            int[] iArr;
            if (DisplayUtil.s()) {
                iArr = new int[]{12445, 13456, 12344};
            } else {
                iArr = null;
            }
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
            } catch (IllegalArgumentException e10) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e10);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);

        EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);

        EGLSurface b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<GLTextureView> f16251a;

        /* renamed from: b, reason: collision with root package name */
        public EGL10 f16252b;

        /* renamed from: c, reason: collision with root package name */
        public EGLDisplay f16253c;

        /* renamed from: d, reason: collision with root package name */
        public EGLSurface f16254d;

        /* renamed from: e, reason: collision with root package name */
        public EGLConfig f16255e;

        /* renamed from: f, reason: collision with root package name */
        public EGLContext f16256f;

        public h(WeakReference<GLTextureView> weakReference) {
            this.f16251a = weakReference;
        }

        public static String f(String str, int i10) {
            return str + " failed: " + i10;
        }

        public static void g(String str, String str2, int i10) {
            Log.w(str, f(str2, i10));
        }

        public static void k(String str, int i10) {
            throw new RuntimeException(f(str, i10));
        }

        public GL a() {
            l lVar;
            GL gl = this.f16256f.getGL();
            GLTextureView gLTextureView = this.f16251a.get();
            if (gLTextureView != null) {
                GLTextureView.f(gLTextureView);
                if ((gLTextureView.f16236h & 3) != 0) {
                    int i10 = 1;
                    if ((gLTextureView.f16236h & 1) == 0) {
                        i10 = 0;
                    }
                    if ((gLTextureView.f16236h & 2) != 0) {
                        lVar = new l();
                    } else {
                        lVar = null;
                    }
                    return GLDebugHelper.wrap(gl, i10, lVar);
                }
                return gl;
            }
            return gl;
        }

        public boolean b() {
            if (this.f16252b != null) {
                if (this.f16253c != null) {
                    if (this.f16255e != null) {
                        d();
                        GLTextureView gLTextureView = this.f16251a.get();
                        if (gLTextureView != null) {
                            this.f16254d = gLTextureView.f16235g.b(this.f16252b, this.f16253c, this.f16255e, gLTextureView.getSurfaceTexture());
                        } else {
                            this.f16254d = null;
                        }
                        EGLSurface eGLSurface = this.f16254d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (!this.f16252b.eglMakeCurrent(this.f16253c, eGLSurface, eGLSurface, this.f16256f)) {
                                g("EGLHelper", "eglMakeCurrent", this.f16252b.eglGetError());
                                return false;
                            }
                            return true;
                        }
                        if (this.f16252b.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            d();
        }

        public final void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f16254d;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.f16252b.eglMakeCurrent(this.f16253c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.f16251a.get();
                if (gLTextureView != null) {
                    gLTextureView.f16235g.a(this.f16252b, this.f16253c, this.f16254d);
                }
                this.f16254d = null;
            }
        }

        public void e() {
            if (this.f16256f != null) {
                GLTextureView gLTextureView = this.f16251a.get();
                if (gLTextureView != null) {
                    gLTextureView.f16234f.a(this.f16252b, this.f16253c, this.f16256f);
                }
                this.f16256f = null;
            }
            EGLDisplay eGLDisplay = this.f16253c;
            if (eGLDisplay != null) {
                this.f16252b.eglTerminate(eGLDisplay);
                this.f16253c = null;
            }
        }

        public void h() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f16252b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f16253c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f16252b.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.f16251a.get();
                    if (gLTextureView == null) {
                        this.f16255e = null;
                        this.f16256f = null;
                    } else {
                        this.f16255e = gLTextureView.f16233e.a(this.f16252b, this.f16253c);
                        this.f16256f = gLTextureView.f16234f.b(this.f16252b, this.f16253c, this.f16255e);
                    }
                    EGLContext eGLContext = this.f16256f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f16256f = null;
                        j("createContext");
                    }
                    this.f16254d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int i() {
            if (!this.f16252b.eglSwapBuffers(this.f16253c, this.f16254d)) {
                return this.f16252b.eglGetError();
            }
            return 12288;
        }

        public final void j(String str) {
            k(str, this.f16252b.eglGetError());
        }
    }

    /* loaded from: classes.dex */
    public static class i extends Thread {

        /* renamed from: A, reason: collision with root package name */
        public WeakReference<GLTextureView> f16257A;

        /* renamed from: a, reason: collision with root package name */
        public boolean f16258a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16259b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16260c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f16261d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f16262e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f16263f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16264g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f16265h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f16266i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f16267j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f16268k;

        /* renamed from: q, reason: collision with root package name */
        public boolean f16274q;

        /* renamed from: z, reason: collision with root package name */
        public h f16278z;

        /* renamed from: r, reason: collision with root package name */
        public ArrayList<Runnable> f16275r = new ArrayList<>();

        /* renamed from: x, reason: collision with root package name */
        public boolean f16276x = true;

        /* renamed from: y, reason: collision with root package name */
        public Runnable f16277y = null;

        /* renamed from: l, reason: collision with root package name */
        public int f16269l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f16270m = 0;

        /* renamed from: o, reason: collision with root package name */
        public boolean f16272o = true;

        /* renamed from: n, reason: collision with root package name */
        public int f16271n = 1;

        /* renamed from: p, reason: collision with root package name */
        public boolean f16273p = false;

        public i(WeakReference<GLTextureView> weakReference) {
            this.f16257A = weakReference;
        }

        public boolean b() {
            if (this.f16265h && this.f16266i && f()) {
                return true;
            }
            return false;
        }

        public int c() {
            int i10;
            synchronized (GLTextureView.f16228k) {
                i10 = this.f16271n;
            }
            return i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:148:0x0231  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x0146 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:197:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d() {
            /*
                Method dump skipped, instructions count: 606
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.omoji.view.GLTextureView.i.d():void");
        }

        public void e(int i10, int i11) {
            synchronized (GLTextureView.f16228k) {
                try {
                    this.f16269l = i10;
                    this.f16270m = i11;
                    this.f16276x = true;
                    this.f16272o = true;
                    this.f16274q = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    GLTextureView.f16228k.notifyAll();
                    while (!this.f16259b && !this.f16261d && !this.f16274q && b()) {
                        try {
                            GLTextureView.f16228k.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean f() {
            if (!this.f16261d && this.f16262e && !this.f16263f && this.f16269l > 0 && this.f16270m > 0 && (this.f16272o || this.f16271n == 1)) {
                return true;
            }
            return false;
        }

        public void g() {
            synchronized (GLTextureView.f16228k) {
                this.f16258a = true;
                GLTextureView.f16228k.notifyAll();
                while (!this.f16259b) {
                    try {
                        GLTextureView.f16228k.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (GLTextureView.f16228k) {
                this.f16272o = true;
                GLTextureView.f16228k.notifyAll();
            }
        }

        public void i(int i10) {
            if (i10 >= 0 && i10 <= 1) {
                synchronized (GLTextureView.f16228k) {
                    this.f16271n = i10;
                    GLTextureView.f16228k.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public final void j() {
            if (this.f16265h) {
                this.f16278z.e();
                this.f16265h = false;
                GLTextureView.f16228k.a(this);
            }
        }

        public final void k() {
            if (this.f16266i) {
                this.f16266i = false;
                this.f16278z.c();
            }
        }

        public void l() {
            synchronized (GLTextureView.f16228k) {
                this.f16262e = true;
                this.f16267j = false;
                GLTextureView.f16228k.notifyAll();
                while (this.f16264g && !this.f16267j && !this.f16259b) {
                    try {
                        GLTextureView.f16228k.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m() {
            synchronized (GLTextureView.f16228k) {
                this.f16262e = false;
                GLTextureView.f16228k.notifyAll();
                while (!this.f16264g && !this.f16259b) {
                    try {
                        GLTextureView.f16228k.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                d();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.f16228k.b(this);
                throw th;
            }
            GLTextureView.f16228k.b(this);
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        public j() {
        }

        public void a(i iVar) {
            notifyAll();
        }

        public synchronized void b(i iVar) {
            iVar.f16259b = true;
            notifyAll();
        }
    }

    /* loaded from: classes.dex */
    public interface k {
    }

    /* loaded from: classes.dex */
    public static class l extends Writer {

        /* renamed from: a, reason: collision with root package name */
        public final StringBuilder f16279a = new StringBuilder();

        public final void a() {
            if (this.f16279a.length() > 0) {
                Log.v("GLTextureView", this.f16279a.toString());
                StringBuilder sb = this.f16279a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                char c10 = cArr[i10 + i12];
                if (c10 == '\n') {
                    a();
                } else {
                    this.f16279a.append(c10);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m {
        void a(GL10 gl10);

        void b(GL10 gl10, int i10, int i11);

        void c(GL10 gl10, EGLConfig eGLConfig);
    }

    /* loaded from: classes.dex */
    public class n extends b {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public n(boolean r10) {
            /*
                r8 = this;
                com.android.contacts.framework.omoji.view.GLTextureView.this = r9
                if (r10 == 0) goto L8
                r10 = 16
            L6:
                r6 = r10
                goto La
            L8:
                r10 = 0
                goto L6
            La:
                r7 = 0
                r2 = 8
                r3 = 8
                r4 = 8
                r5 = 0
                r0 = r8
                r1 = r9
                r0.<init>(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.omoji.view.GLTextureView.n.<init>(com.android.contacts.framework.omoji.view.GLTextureView, boolean):void");
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16229a = new WeakReference<>(this);
        l();
    }

    public static /* bridge */ /* synthetic */ k f(GLTextureView gLTextureView) {
        gLTextureView.getClass();
        return null;
    }

    private void l() {
        setSurfaceTextureListener(this);
    }

    public void finalize() {
        try {
            i iVar = this.f16230b;
            if (iVar != null) {
                iVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.f16236h;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f16238j;
    }

    public int getRenderMode() {
        return this.f16230b.c();
    }

    public final void j() {
        if (this.f16230b == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void k() {
        i iVar = this.f16230b;
        if (iVar != null) {
            iVar.g();
        }
    }

    public void m() {
        this.f16230b.h();
    }

    public void n(int i10, int i11, int i12, int i13, int i14, int i15) {
        setEGLConfigChooser(new b(i10, i11, i12, i13, i14, i15));
    }

    public void o(SurfaceTexture surfaceTexture, int i10, int i11, int i12) {
        this.f16230b.e(i11, i12);
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        int i10;
        super.onAttachedToWindow();
        if (this.f16232d && this.f16231c != null) {
            i iVar = this.f16230b;
            if (iVar != null) {
                i10 = iVar.c();
            } else {
                i10 = 1;
            }
            i iVar2 = new i(this.f16229a);
            this.f16230b = iVar2;
            if (i10 != 1) {
                iVar2.i(i10);
            }
            this.f16230b.start();
        }
        this.f16232d = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        i iVar = this.f16230b;
        if (iVar != null) {
            iVar.g();
        }
        this.f16232d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        o(getSurfaceTexture(), 0, i12 - i10, i13 - i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        p(surfaceTexture);
        o(surfaceTexture, 0, i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        q(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        o(surfaceTexture, 0, i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        m();
    }

    public void p(SurfaceTexture surfaceTexture) {
        this.f16230b.l();
    }

    public void q(SurfaceTexture surfaceTexture) {
        this.f16230b.m();
    }

    public void setDebugFlags(int i10) {
        this.f16236h = i10;
    }

    public void setEGLConfigChooser(e eVar) {
        j();
        this.f16233e = eVar;
    }

    public void setEGLContextClientVersion(int i10) {
        j();
        this.f16237i = i10;
    }

    public void setEGLContextFactory(f fVar) {
        j();
        this.f16234f = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        j();
        this.f16235g = gVar;
    }

    public void setPreserveEGLContextOnPause(boolean z10) {
        this.f16238j = z10;
    }

    public void setRenderMode(int i10) {
        this.f16230b.i(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRenderer(m mVar) {
        j();
        if (this.f16233e == null) {
            this.f16233e = new n(this, true);
        }
        Object[] objArr = 0;
        if (this.f16234f == null) {
            this.f16234f = new c();
        }
        if (this.f16235g == null) {
            this.f16235g = new d();
        }
        this.f16231c = mVar;
        i iVar = new i(this.f16229a);
        this.f16230b = iVar;
        iVar.start();
    }

    public void setEGLConfigChooser(boolean z10) {
        setEGLConfigChooser(new n(this, z10));
    }

    public void setGLWrapper(k kVar) {
    }
}
