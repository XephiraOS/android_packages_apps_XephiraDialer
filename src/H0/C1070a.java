package h0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.K;

/* compiled from: CircleImageView.java */
/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1070a extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public Animation.AnimationListener f31997a;

    /* renamed from: b, reason: collision with root package name */
    public int f31998b;

    /* compiled from: CircleImageView.java */
    /* renamed from: h0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0300a extends OvalShape {

        /* renamed from: a, reason: collision with root package name */
        public RadialGradient f31999a;

        /* renamed from: b, reason: collision with root package name */
        public Paint f32000b = new Paint();

        public C0300a(int i10) {
            C1070a.this.f31998b = i10;
            a((int) rect().width());
        }

        public final void a(int i10) {
            float f10 = i10 / 2;
            RadialGradient radialGradient = new RadialGradient(f10, f10, C1070a.this.f31998b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f31999a = radialGradient;
            this.f32000b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = C1070a.this.getWidth() / 2;
            float height = C1070a.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f32000b);
            canvas.drawCircle(width, height, r0 - C1070a.this.f31998b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    public C1070a(Context context, int i10) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f10 = getContext().getResources().getDisplayMetrics().density;
        int i11 = (int) (1.75f * f10);
        int i12 = (int) (0.0f * f10);
        this.f31998b = (int) (3.5f * f10);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            K.r0(this, f10 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0300a(this.f31998b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f31998b, i12, i11, 503316480);
            int i13 = this.f31998b;
            setPadding(i13, i13, i13, i13);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i10);
        K.n0(this, shapeDrawable);
    }

    public final boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f31997a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f31997a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f31997a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f31998b * 2), getMeasuredHeight() + (this.f31998b * 2));
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
        }
    }
}
