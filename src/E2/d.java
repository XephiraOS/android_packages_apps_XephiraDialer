package E2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import java.util.HashMap;

/* compiled from: OplusCurvedDisplayView.java */
/* loaded from: classes.dex */
public class d extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f491a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f492b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f493c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f494d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuffXfermode f495e;

    /* renamed from: f, reason: collision with root package name */
    public int f496f;

    /* renamed from: g, reason: collision with root package name */
    public int f497g;

    /* renamed from: h, reason: collision with root package name */
    public int f498h;

    /* renamed from: i, reason: collision with root package name */
    public String f499i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f500j;

    /* renamed from: k, reason: collision with root package name */
    public int f501k;

    /* renamed from: l, reason: collision with root package name */
    public int f502l;

    /* renamed from: m, reason: collision with root package name */
    public int f503m;

    /* renamed from: n, reason: collision with root package name */
    public Rect f504n;

    /* renamed from: o, reason: collision with root package name */
    public Rect f505o;

    /* renamed from: p, reason: collision with root package name */
    public Rect f506p;

    /* renamed from: q, reason: collision with root package name */
    public float f507q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f508r;

    /* renamed from: x, reason: collision with root package name */
    public ValueAnimator f509x;

    /* renamed from: y, reason: collision with root package name */
    public AnimatorSet f510y;

    /* compiled from: OplusCurvedDisplayView.java */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() != null) {
                d.this.f501k = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            d.this.invalidate();
        }
    }

    public d(Context context, String str) {
        super(context);
        this.f503m = 5250;
        this.f507q = 1.0f;
        setAlpha(1.0f);
        OplusPhoneUtils.setDefaultDisplayResources(getResources());
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        this.f497g = point.x;
        this.f498h = point.y;
        this.f499i = str;
        this.f494d = new Paint(1);
        this.f495e = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        f(context);
    }

    public final void d() {
        Log.d("OplusCurvedDisplayView", "clearAnimatorListener ");
        ValueAnimator valueAnimator = this.f508r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f508r.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.f509x;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f509x.removeAllListeners();
        }
        AnimatorSet animatorSet = this.f510y;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
    }

    public final Bitmap e(Bitmap bitmap) {
        if (this.f507q != 1.0f && bitmap != null) {
            try {
                Matrix matrix = new Matrix();
                float f10 = this.f507q;
                matrix.postScale(f10, f10);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (createBitmap != null) {
                    bitmap.recycle();
                }
                return createBitmap;
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    public final void f(Context context) {
        int intValue;
        Resources resources = context.getResources();
        HashMap hashMap = new HashMap();
        hashMap.put("red", Integer.valueOf(R.array.incall_curved_display_pic_names_red));
        hashMap.put("blue", Integer.valueOf(R.array.incall_curved_display_pic_names_blue));
        hashMap.put("gold", Integer.valueOf(R.array.incall_curved_display_pic_names_gold));
        if (this.f499i.equals("red")) {
            intValue = ((Integer) hashMap.get("red")).intValue();
        } else if (this.f499i.equals("blue")) {
            intValue = ((Integer) hashMap.get("blue")).intValue();
        } else if (this.f499i.equals("gold")) {
            intValue = ((Integer) hashMap.get("gold")).intValue();
        } else {
            intValue = ((Integer) hashMap.get("red")).intValue();
        }
        TypedArray obtainTypedArray = getResources().obtainTypedArray(intValue);
        this.f500j = new int[2];
        for (int i10 = 0; i10 < 2; i10++) {
            this.f500j[i10] = obtainTypedArray.getResourceId(i10, -1);
        }
        obtainTypedArray.recycle();
        this.f491a = BitmapFactory.decodeResource(resources, this.f500j[0]);
        this.f492b = BitmapFactory.decodeResource(resources, this.f500j[1]);
        Bitmap bitmap = this.f491a;
        if (bitmap != null && bitmap.getHeight() != 0) {
            this.f507q = (this.f498h * 1.0f) / this.f491a.getHeight();
        }
        this.f491a = e(this.f491a);
        this.f492b = e(this.f492b);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.incall_curved_display_mask_call);
        this.f493c = decodeResource;
        this.f502l = decodeResource.getHeight();
        this.f496f = this.f497g - this.f492b.getWidth();
        this.f503m = getResources().getDimensionPixelSize(R.dimen.oplus_curved_display_view_incall_mask_move_end);
        if (Log.sDebug) {
            Log.d("OplusCurvedDisplayView", "mIncallMaskMoveEnd = " + this.f503m + ", mScreenWidth = " + this.f497g + ", mScreenHeight = " + this.f498h + ", mViewMaskHeight = " + this.f502l + ", mViewRightX = " + this.f496f);
        }
        this.f504n = new Rect(0, 0, this.f497g, this.f498h);
        this.f505o = new Rect(0, 0, 1, this.f502l);
        this.f506p = new Rect(0, 0, this.f497g, this.f502l);
    }

    public final /* synthetic */ void g(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedValue() != null) {
            this.f494d.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public String getColor() {
        return this.f499i;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f498h);
        this.f508r = ofInt;
        ofInt.setDuration(5000L);
        this.f508r.setInterpolator(new PathInterpolator(0.37f, 0.57f, 0.35f, 0.62f));
        this.f508r.addUpdateListener(new a());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(255, 0);
        this.f509x = ofInt2;
        ofInt2.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.52f, 1.0f));
        this.f509x.setDuration(2500L);
        this.f509x.setStartDelay(2500L);
        this.f509x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: E2.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.g(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f510y = animatorSet;
        animatorSet.play(this.f508r).with(this.f509x);
        this.f510y.addListener(new b());
        this.f510y.start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("OplusCurvedDisplayView", "onDetachedFromWindow ");
        Bitmap bitmap = this.f491a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f491a.recycle();
            this.f491a = null;
        }
        Bitmap bitmap2 = this.f492b;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f492b.recycle();
            this.f492b = null;
        }
        Bitmap bitmap3 = this.f493c;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f493c.recycle();
            this.f493c = null;
        }
        d();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Rect rect = this.f504n;
        int i10 = this.f498h;
        int i11 = this.f501k;
        rect.set(0, (i10 / 2) - i11, this.f497g, (i10 / 2) + i11);
        this.f494d.setXfermode(null);
        canvas.clipRect(this.f504n);
        canvas.drawBitmap(this.f492b, this.f496f, 0.0f, this.f494d);
        canvas.drawBitmap(this.f491a, 0.0f, 0.0f, this.f494d);
        this.f494d.setXfermode(this.f495e);
        Rect rect2 = this.f506p;
        int i12 = this.f498h;
        int i13 = this.f501k;
        rect2.set(0, (i12 / 2) - i13, this.f497g, (i12 / 2) + i13);
        canvas.drawBitmap(this.f493c, this.f505o, this.f506p, this.f494d);
        canvas.restoreToCount(saveLayer);
        int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Rect rect3 = this.f504n;
        int i14 = this.f498h;
        int i15 = this.f501k;
        rect3.set(0, (i14 / 2) - i15, this.f497g, (i14 / 2) + i15);
        this.f494d.setXfermode(null);
        canvas.clipRect(this.f504n);
        canvas.drawBitmap(this.f492b, this.f496f, 0.0f, this.f494d);
        canvas.drawBitmap(this.f491a, 0.0f, 0.0f, this.f494d);
        this.f494d.setXfermode(this.f495e);
        Rect rect4 = this.f506p;
        int i16 = this.f498h;
        int i17 = this.f501k;
        rect4.set(0, (i16 / 2) - i17, this.f497g, (i16 / 2) + i17);
        canvas.drawBitmap(this.f493c, this.f505o, this.f506p, this.f494d);
        canvas.restoreToCount(saveLayer2);
    }

    /* compiled from: OplusCurvedDisplayView.java */
    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f510y.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
