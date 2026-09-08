package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.android.incallui.OplusPhoneUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f7907l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap<String, Method> f7908m = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f7916h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f7917i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f7918j;

    /* renamed from: a, reason: collision with root package name */
    public int f7909a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7910b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f7911c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f7912d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f7913e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f7914f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f7915g = false;

    /* renamed from: k, reason: collision with root package name */
    public final d f7919k = new c();

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                dVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    public static class b extends d {
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    public static class c extends b {
        @Override // androidx.appcompat.widget.r.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.r.d
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* loaded from: classes.dex */
    public static class d {
        public void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        public boolean b(TextView textView) {
            throw null;
        }
    }

    public r(TextView textView) {
        this.f7917i = textView;
        this.f7918j = textView.getContext();
    }

    public static Method k(String str) {
        try {
            Method method = f7908m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                f7908m.put(str, method);
            }
            return method;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    public static <T> T m(Object obj, String str, T t10) {
        try {
            return (T) k(str).invoke(obj, null);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return t10;
        }
    }

    public void a() {
        int measuredWidth;
        if (!n()) {
            return;
        }
        if (this.f7910b) {
            if (this.f7917i.getMeasuredHeight() > 0 && this.f7917i.getMeasuredWidth() > 0) {
                if (this.f7919k.b(this.f7917i)) {
                    measuredWidth = OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
                } else {
                    measuredWidth = (this.f7917i.getMeasuredWidth() - this.f7917i.getTotalPaddingLeft()) - this.f7917i.getTotalPaddingRight();
                }
                int height = (this.f7917i.getHeight() - this.f7917i.getCompoundPaddingBottom()) - this.f7917i.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = f7907l;
                    synchronized (rectF) {
                        try {
                            rectF.setEmpty();
                            rectF.right = measuredWidth;
                            rectF.bottom = height;
                            float e10 = e(rectF);
                            if (e10 != this.f7917i.getTextSize()) {
                                t(0, e10);
                            }
                        } finally {
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f7910b = true;
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    public final void c() {
        this.f7909a = 0;
        this.f7912d = -1.0f;
        this.f7913e = -1.0f;
        this.f7911c = -1.0f;
        this.f7914f = new int[0];
        this.f7910b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        return a.a(charSequence, alignment, i10, i11, this.f7917i, this.f7916h, this.f7919k);
    }

    public final int e(RectF rectF) {
        int length = this.f7914f.length;
        if (length != 0) {
            int i10 = 1;
            int i11 = length - 1;
            int i12 = 0;
            while (i10 <= i11) {
                int i13 = (i10 + i11) / 2;
                if (x(this.f7914f[i13], rectF)) {
                    int i14 = i13 + 1;
                    i12 = i10;
                    i10 = i14;
                } else {
                    i12 = i13 - 1;
                    i11 = i12;
                }
            }
            return this.f7914f[i12];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public int f() {
        return Math.round(this.f7913e);
    }

    public int g() {
        return Math.round(this.f7912d);
    }

    public int h() {
        return Math.round(this.f7911c);
    }

    public int[] i() {
        return this.f7914f;
    }

    public int j() {
        return this.f7909a;
    }

    public void l(int i10) {
        TextPaint textPaint = this.f7916h;
        if (textPaint == null) {
            this.f7916h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f7916h.set(this.f7917i.getPaint());
        this.f7916h.setTextSize(i10);
    }

    public boolean n() {
        if (y() && this.f7909a != 0) {
            return true;
        }
        return false;
    }

    public void o(AttributeSet attributeSet, int i10) {
        float f10;
        float f11;
        float f12;
        int resourceId;
        Context context = this.f7918j;
        int[] iArr = e.j.f30456i0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f7917i;
        androidx.core.view.K.h0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i10, 0);
        int i11 = e.j.f30481n0;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f7909a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = e.j.f30476m0;
        if (obtainStyledAttributes.hasValue(i12)) {
            f10 = obtainStyledAttributes.getDimension(i12, -1.0f);
        } else {
            f10 = -1.0f;
        }
        int i13 = e.j.f30466k0;
        if (obtainStyledAttributes.hasValue(i13)) {
            f11 = obtainStyledAttributes.getDimension(i13, -1.0f);
        } else {
            f11 = -1.0f;
        }
        int i14 = e.j.f30461j0;
        if (obtainStyledAttributes.hasValue(i14)) {
            f12 = obtainStyledAttributes.getDimension(i14, -1.0f);
        } else {
            f12 = -1.0f;
        }
        int i15 = e.j.f30471l0;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (y()) {
            if (this.f7909a == 1) {
                if (!this.f7915g) {
                    DisplayMetrics displayMetrics = this.f7918j.getResources().getDisplayMetrics();
                    if (f11 == -1.0f) {
                        f11 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (f12 == -1.0f) {
                        f12 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (f10 == -1.0f) {
                        f10 = 1.0f;
                    }
                    z(f11, f12, f10);
                }
                u();
                return;
            }
            return;
        }
        this.f7909a = 0;
    }

    public void p(int i10, int i11, int i12, int i13) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f7918j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(int[] iArr, int i10) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f7918j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f7914f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f7915g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i10) {
        if (y()) {
            if (i10 != 0) {
                if (i10 == 1) {
                    DisplayMetrics displayMetrics = this.f7918j.getResources().getDisplayMetrics();
                    z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (u()) {
                        a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            c();
        }
    }

    public final void s(float f10) {
        if (f10 != this.f7917i.getPaint().getTextSize()) {
            this.f7917i.getPaint().setTextSize(f10);
            boolean isInLayout = this.f7917i.isInLayout();
            if (this.f7917i.getLayout() != null) {
                this.f7910b = false;
                try {
                    Method k10 = k("nullLayouts");
                    if (k10 != null) {
                        k10.invoke(this.f7917i, null);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (!isInLayout) {
                    this.f7917i.requestLayout();
                } else {
                    this.f7917i.forceLayout();
                }
                this.f7917i.invalidate();
            }
        }
    }

    public void t(int i10, float f10) {
        Resources resources;
        Context context = this.f7918j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        s(TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f7909a == 1) {
            if (!this.f7915g || this.f7914f.length == 0) {
                int floor = ((int) Math.floor((this.f7913e - this.f7912d) / this.f7911c)) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f7912d + (i10 * this.f7911c));
                }
                this.f7914f = b(iArr);
            }
            this.f7910b = true;
        } else {
            this.f7910b = false;
        }
        return this.f7910b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f7914f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        boolean z10;
        if (this.f7914f.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f7915g = z10;
        if (z10) {
            this.f7909a = 1;
            this.f7912d = r0[0];
            this.f7913e = r0[r1 - 1];
            this.f7911c = -1.0f;
        }
        return z10;
    }

    public final boolean x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f7917i.getText();
        TransformationMethod transformationMethod = this.f7917i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f7917i)) != null) {
            text = transformation;
        }
        int maxLines = this.f7917i.getMaxLines();
        l(i10);
        StaticLayout d10 = d(text, (Layout.Alignment) m(this.f7917i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        if ((maxLines != -1 && (d10.getLineCount() > maxLines || d10.getLineEnd(d10.getLineCount() - 1) != text.length())) || d10.getHeight() > rectF.bottom) {
            return false;
        }
        return true;
    }

    public final boolean y() {
        return !(this.f7917i instanceof AppCompatEditText);
    }

    public final void z(float f10, float f11, float f12) {
        if (f10 > 0.0f) {
            if (f11 > f10) {
                if (f12 > 0.0f) {
                    this.f7909a = 1;
                    this.f7912d = f10;
                    this.f7913e = f11;
                    this.f7911c = f12;
                    this.f7915g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
    }
}
