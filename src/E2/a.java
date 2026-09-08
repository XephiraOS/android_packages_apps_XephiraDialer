package E2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.incallui.R;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.i;

/* compiled from: FontSizeAdapter.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final C0011a f482h = new C0011a(null);

    /* renamed from: a, reason: collision with root package name */
    public float f483a;

    /* renamed from: b, reason: collision with root package name */
    public float f484b;

    /* renamed from: c, reason: collision with root package name */
    public int f485c;

    /* renamed from: d, reason: collision with root package name */
    public float f486d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<TextView> f487e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f488f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f489g;

    /* compiled from: FontSizeAdapter.kt */
    /* renamed from: E2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0011a {
        public C0011a() {
        }

        public /* synthetic */ C0011a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public a(TextView v10, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        i.f(v10, "v");
        this.f483a = -1.0f;
        this.f484b = -1.0f;
        this.f485c = 1;
        this.f486d = -1.0f;
        this.f487e = new WeakReference<>(v10);
        this.f488f = new Paint();
        Context context = v10.getContext();
        if (context != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FontSizeAdapter)) != null) {
            this.f485c = obtainStyledAttributes.getInteger(R.styleable.FontSizeAdapter_fontScaleLevel, 1);
            float f10 = obtainStyledAttributes.getResources().getConfiguration().fontScale;
            this.f483a = COUIChangeTextUtil.getSuitableFontSize(obtainStyledAttributes.getDimension(R.styleable.FontSizeAdapter_maxTextSize, -1.0f), f10, this.f485c);
            this.f484b = COUIChangeTextUtil.getSuitableFontSize(obtainStyledAttributes.getDimension(R.styleable.FontSizeAdapter_minTextSize, -1.0f), f10, this.f485c);
            this.f486d = COUIChangeTextUtil.getSuitableFontSize(obtainStyledAttributes.getDimension(R.styleable.FontSizeAdapter_fontWeightChangeTextSize, -1.0f), f10, this.f485c);
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(CharSequence charSequence) {
        TextView textView;
        this.f489g = charSequence;
        float f10 = this.f483a;
        if (f10 >= 0.0f && f10 >= this.f484b && (textView = this.f487e.get()) != null) {
            float f11 = this.f483a;
            if (f11 != this.f484b && textView.getMeasuredWidth() > 0) {
                this.f488f.setTypeface(textView.getTypeface());
                this.f488f.setTextSize(f11);
                while (true) {
                    if (this.f488f.measureText(String.valueOf(charSequence)) <= (textView.getMeasuredWidth() - textView.getPaddingStart()) - textView.getPaddingEnd()) {
                        break;
                    }
                    f11--;
                    float f12 = this.f484b;
                    if (f11 < f12) {
                        f11 = f12;
                        break;
                    }
                    this.f488f.setTextSize(f11);
                }
            }
            if (textView.getTextSize() != f11) {
                textView.setTextSize(0, f11);
                b(f11);
            }
        }
    }

    public final void b(float f10) {
        TextView textView;
        Typeface create;
        if (this.f486d > 0.0f && (textView = this.f487e.get()) != null) {
            if (f10 >= this.f486d) {
                create = Typeface.create("sans-serif-light", 0);
            } else {
                create = Typeface.create("sans-serif-light", 1);
            }
            textView.setTypeface(create);
        }
    }

    public final void c(float f10) {
        TextView textView = this.f487e.get();
        if (textView != null) {
            this.f483a = COUIChangeTextUtil.getSuitableFontSize(f10, textView.getResources().getConfiguration().fontScale, this.f485c);
            a(this.f489g);
        }
    }

    public final void d(float f10) {
        TextView textView = this.f487e.get();
        if (textView != null) {
            this.f484b = COUIChangeTextUtil.getSuitableFontSize(f10, textView.getResources().getConfiguration().fontScale, this.f485c);
            a(this.f489g);
        }
    }
}
