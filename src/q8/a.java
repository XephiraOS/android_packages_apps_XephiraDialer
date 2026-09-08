package Q8;

import O8.b;
import O8.d;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: VideoShowTextureView.kt */
/* loaded from: classes4.dex */
public final class a extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: e, reason: collision with root package name */
    public static final C0061a f3139e = new C0061a(null);

    /* renamed from: a, reason: collision with root package name */
    public Rect f3140a;

    /* renamed from: b, reason: collision with root package name */
    public d f3141b;

    /* renamed from: c, reason: collision with root package name */
    public Surface f3142c;

    /* renamed from: d, reason: collision with root package name */
    public SurfaceTexture f3143d;

    /* compiled from: VideoShowTextureView.kt */
    /* renamed from: Q8.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0061a {
        public C0061a() {
        }

        public /* synthetic */ C0061a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, d dVar, Rect mVideoSourceRect) {
        super(context);
        i.f(context, "context");
        i.f(mVideoSourceRect, "mVideoSourceRect");
        this.f3140a = mVideoSourceRect;
        R8.a.f3357a.b("VideoShowTextureView", "SurfaceView  init");
        setSurfaceTextureListener(this);
        setVideoShowMediaPlayerControl(dVar);
    }

    private final void setVideoShowMediaPlayerControl(d dVar) {
        this.f3141b = dVar;
    }

    public final void a() {
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "cleanup");
        }
        b();
        setSurfaceTextureListener(null);
    }

    public final void b() {
        R8.a.f3357a.b("VideoShowTextureView", "release surface");
        Surface surface = this.f3142c;
        if (surface != null) {
            surface.release();
        }
        this.f3142c = null;
    }

    public final void c() {
        int height;
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "updateScaleToFitWithCropping");
        }
        int width = getWidth();
        if (width <= 0 || (height = getHeight()) <= 0) {
            return;
        }
        Matrix matrix = new Matrix();
        Rect rect = this.f3140a;
        int width2 = rect.width();
        int height2 = rect.height();
        if (width2 <= 0 || height2 <= 0) {
            return;
        }
        if (width == width2 && height == height2) {
            return;
        }
        float f10 = width;
        float f11 = height;
        float f12 = width2;
        float f13 = height2;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "updateScaleToFitWithCropping textureViewWidth = " + width + " textureViewHeight =  " + height + " videoWidth = " + width2 + "   videoHeight = " + height2);
        }
        float f14 = 2;
        float f15 = (f10 - f12) / f14;
        float f16 = (f11 - f13) / f14;
        float f17 = f10 / f12;
        float f18 = f11 / f13;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "updateScaleToFitWithCropping done sx = " + f17 + " sy = " + f18);
        }
        try {
            matrix.preTranslate(f15, f16);
            float f19 = 1;
            matrix.preScale(f19 / f17, f19 / f18);
            matrix.postScale(f18, f18, f10 / f14, f11 / f14);
            setTransform(matrix);
            postInvalidate();
        } catch (Exception e10) {
            R8.a aVar2 = R8.a.f3357a;
            if (aVar2.f()) {
                aVar2.b("VideoShowTextureView", "updateScaleToFitWithCropping " + e10.getMessage());
            }
        }
    }

    public final void d() {
        b a10;
        d dVar = this.f3141b;
        if (dVar != null && (a10 = dVar.a()) != null) {
            a10.b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "onDetachedFromWindow   ");
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        c();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int i10, int i11) {
        O8.a aVar;
        N8.d g10;
        i.f(surface, "surface");
        R8.a aVar2 = R8.a.f3357a;
        if (aVar2.f()) {
            aVar2.b("VideoShowTextureView", "onSurfaceTextureAvailable surfaceTexture=" + surface + ", mSurfaceTexture=" + this.f3143d);
        }
        d dVar = this.f3141b;
        if (dVar == null) {
            return;
        }
        if (dVar != null && (g10 = dVar.g()) != null) {
            aVar = g10.a();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            if (aVar2.f()) {
                aVar2.h("VideoShowTextureView", "surfaceCreated playerControl is null return");
                return;
            }
            return;
        }
        if (this.f3143d == null) {
            this.f3143d = surface;
            d();
            c();
            b();
            Surface surface2 = new Surface(this.f3143d);
            this.f3142c = surface2;
            aVar.d(surface2);
            if (aVar.a()) {
                if (aVar2.f()) {
                    aVar2.b("VideoShowTextureView", "surfaceCreated    isPlaying  just set surface ");
                    return;
                }
                return;
            } else {
                if (aVar2.f()) {
                    aVar2.b("VideoShowTextureView", "surfaceCreated need to set surface and start play ");
                }
                d dVar2 = this.f3141b;
                if (dVar2 != null) {
                    dVar2.h();
                    return;
                }
                return;
            }
        }
        if (aVar2.f()) {
            aVar2.b("VideoShowTextureView", "reuse the already created surface texture");
        }
        SurfaceTexture surfaceTexture = this.f3143d;
        if (surfaceTexture != null) {
            setSurfaceTexture(surfaceTexture);
        }
        c();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        i.f(surface, "surface");
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "onSurfaceTextureDestroyed state");
        }
        this.f3143d = surface;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i10, int i11) {
        i.f(surface, "surface");
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowTextureView", "onSurfaceTextureSizeChanged state");
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        i.f(surface, "surface");
        R8.a aVar = R8.a.f3357a;
        if (aVar.g()) {
            aVar.b("VideoShowTextureView", "onSurfaceTextureUpdated state");
        }
    }

    public final void setVideoSourceRect(Rect rect) {
        i.f(rect, "rect");
        if (i.b(this.f3140a, rect)) {
            return;
        }
        this.f3140a = rect;
        c();
    }
}
