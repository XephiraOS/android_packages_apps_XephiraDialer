package com.android.contacts.framework.omoji.view;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.android.contacts.framework.omoji.view.GLTextureView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import m9.q;

/* compiled from: VideoRenderer.kt */
/* loaded from: classes.dex */
public final class i implements GLTextureView.m, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: p, reason: collision with root package name */
    public static final a f16287p = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final float[] f16288a;

    /* renamed from: b, reason: collision with root package name */
    public final FloatBuffer f16289b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16290c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16291d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f16292e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f16293f;

    /* renamed from: g, reason: collision with root package name */
    public int f16294g;

    /* renamed from: h, reason: collision with root package name */
    public int f16295h;

    /* renamed from: i, reason: collision with root package name */
    public int f16296i;

    /* renamed from: j, reason: collision with root package name */
    public int f16297j;

    /* renamed from: k, reason: collision with root package name */
    public int f16298k;

    /* renamed from: l, reason: collision with root package name */
    public int f16299l;

    /* renamed from: m, reason: collision with root package name */
    public SurfaceTexture f16300m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16301n;

    /* renamed from: o, reason: collision with root package name */
    public b f16302o;

    /* compiled from: VideoRenderer.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: VideoRenderer.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a(Surface surface);
    }

    public i() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f16288a = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        kotlin.jvm.internal.i.e(asFloatBuffer, "allocateDirect(\n        …eOrder()).asFloatBuffer()");
        this.f16289b = asFloatBuffer;
        this.f16290c = "uniform mat4 uMVPMatrix;\n    uniform mat4 uSTMatrix;\n    attribute vec4 aPosition;\n    attribute vec4 aTextureCoord;\n    varying highp vec2 vTextureCoord;\n    varying highp vec2 vTextureCoord2;\n    void main() {\n        gl_Position = uMVPMatrix * aPosition;\n        highp vec2 coord = (uSTMatrix * aTextureCoord).xy;\n        vTextureCoord = vec2(coord.x * 0.5, coord.y);\n        vTextureCoord2 = vec2(coord.x * 0.5 + 0.5, coord.y);\n    }";
        this.f16291d = "#extension GL_OES_EGL_image_external : require\n    precision highp float;\n    uniform samplerExternalOES sTexture;\n    varying mediump float text_alpha_out;\n    varying highp vec2 vTextureCoord;\n    varying highp vec2 vTextureCoord2;\n    void main() {\n        vec4 color1 = texture2D(sTexture, vTextureCoord);\n        vec4 color2 = texture2D(sTexture, vTextureCoord2);\n        gl_FragColor = vec4(color1.rgb, color2.r);\n    }";
        this.f16292e = new float[16];
        float[] fArr2 = new float[16];
        this.f16293f = fArr2;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(fArr2, 0);
    }

    @Override // com.android.contacts.framework.omoji.view.GLTextureView.m
    public void a(GL10 glUnused) {
        kotlin.jvm.internal.i.f(glUnused, "glUnused");
        synchronized (this) {
            try {
                if (this.f16301n) {
                    SurfaceTexture surfaceTexture = this.f16300m;
                    kotlin.jvm.internal.i.c(surfaceTexture);
                    surfaceTexture.updateTexImage();
                    SurfaceTexture surfaceTexture2 = this.f16300m;
                    kotlin.jvm.internal.i.c(surfaceTexture2);
                    surfaceTexture2.getTransformMatrix(this.f16293f);
                    this.f16301n = false;
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.f16294g);
        d("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f16295h);
        this.f16289b.position(0);
        GLES20.glVertexAttribPointer(this.f16298k, 3, 5126, false, 20, (Buffer) this.f16289b);
        d("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f16298k);
        d("glEnableVertexAttribArray aPositionHandle");
        this.f16289b.position(3);
        GLES20.glVertexAttribPointer(this.f16299l, 3, 5126, false, 20, (Buffer) this.f16289b);
        d("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f16299l);
        d("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.f16292e, 0);
        GLES20.glUniformMatrix4fv(this.f16296i, 1, false, this.f16292e, 0);
        GLES20.glUniformMatrix4fv(this.f16297j, 1, false, this.f16293f, 0);
        GLES20.glDrawArrays(5, 0, 4);
        d("glDrawArrays");
        GLES20.glFinish();
    }

    @Override // com.android.contacts.framework.omoji.view.GLTextureView.m
    public void b(GL10 glUnused, int i10, int i11) {
        kotlin.jvm.internal.i.f(glUnused, "glUnused");
        GLES20.glViewport(0, 0, i10, i11);
    }

    @Override // com.android.contacts.framework.omoji.view.GLTextureView.m
    public void c(GL10 glUnused, EGLConfig config) {
        kotlin.jvm.internal.i.f(glUnused, "glUnused");
        kotlin.jvm.internal.i.f(config, "config");
        int e10 = e(this.f16290c, this.f16291d);
        this.f16294g = e10;
        if (e10 == 0) {
            return;
        }
        this.f16298k = GLES20.glGetAttribLocation(e10, "aPosition");
        d("glGetAttribLocation aPosition");
        if (this.f16298k != -1) {
            this.f16299l = GLES20.glGetAttribLocation(this.f16294g, "aTextureCoord");
            d("glGetAttribLocation aTextureCoord");
            if (this.f16299l != -1) {
                this.f16296i = GLES20.glGetUniformLocation(this.f16294g, "uMVPMatrix");
                d("glGetUniformLocation uMVPMatrix");
                if (this.f16296i != -1) {
                    this.f16297j = GLES20.glGetUniformLocation(this.f16294g, "uSTMatrix");
                    d("glGetUniformLocation uSTMatrix");
                    if (this.f16297j != -1) {
                        g();
                        return;
                    }
                    throw new RuntimeException("Could not get attrib location for uSTMatrix");
                }
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        throw new RuntimeException("Could not get attrib location for aPosition");
    }

    public final void d(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e("VideoRender", str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public final int e(String str, String str2) {
        int f10;
        int f11 = f(35633, str);
        if (f11 == 0 || (f10 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, f11);
            d("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, f10);
            d("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e("VideoRender", "Could not link program: ");
                Log.e("VideoRender", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public final int f(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e("VideoRender", "Could not compile shader " + i10 + ":");
                Log.e("VideoRender", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    public final void g() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i10 = iArr[0];
        this.f16295h = i10;
        GLES20.glBindTexture(36197, i10);
        d("glBindTexture textureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f16295h);
        this.f16300m = surfaceTexture;
        kotlin.jvm.internal.i.c(surfaceTexture);
        surfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = new Surface(this.f16300m);
        b bVar = this.f16302o;
        kotlin.jvm.internal.i.c(bVar);
        bVar.a(surface);
        synchronized (this) {
            this.f16301n = false;
            q qVar = q.f35511a;
        }
    }

    public final void h(b bVar) {
        this.f16302o = bVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surface) {
        kotlin.jvm.internal.i.f(surface, "surface");
        this.f16301n = true;
    }
}
