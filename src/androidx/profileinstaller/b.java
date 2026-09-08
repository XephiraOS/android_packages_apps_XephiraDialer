package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: DeviceProfileWriter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f10779a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f10780b;

    /* renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0134c f10781c;

    /* renamed from: e, reason: collision with root package name */
    public final File f10783e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10784f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10785g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10786h;

    /* renamed from: j, reason: collision with root package name */
    public Z.b[] f10788j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f10789k;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10787i = false;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f10782d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0134c interfaceC0134c, String str, String str2, String str3, File file) {
        this.f10779a = assetManager;
        this.f10780b = executor;
        this.f10781c = interfaceC0134c;
        this.f10784f = str;
        this.f10785g = str2;
        this.f10786h = str3;
        this.f10783e = file;
    }

    public static byte[] d() {
        return null;
    }

    public static boolean k() {
        return false;
    }

    public final b b(Z.b[] bVarArr, byte[] bArr) {
        InputStream h10;
        try {
            h10 = h(this.f10779a, this.f10786h);
        } catch (FileNotFoundException e10) {
            this.f10781c.b(9, e10);
        } catch (IOException e11) {
            this.f10781c.b(7, e11);
        } catch (IllegalStateException e12) {
            this.f10788j = null;
            this.f10781c.b(8, e12);
        }
        if (h10 != null) {
            try {
                this.f10788j = d.q(h10, d.o(h10, d.f10793b), bArr, bVarArr);
                h10.close();
                return this;
            } catch (Throwable th) {
                try {
                    h10.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (h10 != null) {
            h10.close();
        }
        return null;
    }

    public final void c() {
        if (this.f10787i) {
        } else {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f10782d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.f10783e.exists()) {
            if (!this.f10783e.canWrite()) {
                l(4, null);
                return false;
            }
        } else {
            try {
                this.f10783e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        }
        this.f10787i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f10785g);
        } catch (FileNotFoundException e10) {
            this.f10781c.b(6, e10);
            return null;
        } catch (IOException e11) {
            this.f10781c.b(7, e11);
            return null;
        }
    }

    public final /* synthetic */ void g(int i10, Object obj) {
        this.f10781c.b(i10, obj);
    }

    public final InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f10781c.a(5, null);
            }
            return null;
        }
    }

    public b i() {
        b b10;
        c();
        if (this.f10782d == null) {
            return this;
        }
        InputStream f10 = f(this.f10779a);
        if (f10 != null) {
            this.f10788j = j(f10);
        }
        Z.b[] bVarArr = this.f10788j;
        if (bVarArr != null && k() && (b10 = b(bVarArr, this.f10782d)) != null) {
            return b10;
        }
        return this;
    }

    public final Z.b[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        Z.b[] w10 = d.w(inputStream, d.o(inputStream, d.f10792a), this.f10784f);
                        try {
                            inputStream.close();
                            return w10;
                        } catch (IOException e10) {
                            this.f10781c.b(7, e10);
                            return w10;
                        }
                    } catch (IOException e11) {
                        this.f10781c.b(7, e11);
                        return null;
                    }
                } catch (IllegalStateException e12) {
                    this.f10781c.b(8, e12);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e13) {
                this.f10781c.b(7, e13);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.f10781c.b(7, e14);
            }
            throw th;
        }
    }

    public final void l(final int i10, final Object obj) {
        this.f10780b.execute(new Runnable() { // from class: Z.a
            @Override // java.lang.Runnable
            public final void run() {
                androidx.profileinstaller.b.this.g(i10, obj);
            }
        });
    }

    public b m() {
        ByteArrayOutputStream byteArrayOutputStream;
        Z.b[] bVarArr = this.f10788j;
        byte[] bArr = this.f10782d;
        if (bVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    d.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                this.f10781c.b(7, e10);
            } catch (IllegalStateException e11) {
                this.f10781c.b(8, e11);
            }
            if (!d.B(byteArrayOutputStream, bArr, bVarArr)) {
                this.f10781c.b(5, null);
                this.f10788j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f10789k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f10788j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f10789k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f10783e);
                    try {
                        Z.c.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.f10789k = null;
                this.f10788j = null;
            }
        } catch (FileNotFoundException e10) {
            l(6, e10);
            return false;
        } catch (IOException e11) {
            l(7, e11);
            return false;
        }
    }
}
