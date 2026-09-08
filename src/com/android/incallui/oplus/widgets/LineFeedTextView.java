package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.incallui.R;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C1228i;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: LineFeedTextView.kt */
/* loaded from: classes.dex */
public final class LineFeedTextView extends LinearLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final a f19131j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public float f19132a;

    /* renamed from: b, reason: collision with root package name */
    public float f19133b;

    /* renamed from: c, reason: collision with root package name */
    public float f19134c;

    /* renamed from: d, reason: collision with root package name */
    public int f19135d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f19136e;

    /* renamed from: f, reason: collision with root package name */
    public List<TextView> f19137f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f19138g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f19139h;

    /* renamed from: i, reason: collision with root package name */
    public int f19140i;

    /* compiled from: LineFeedTextView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineFeedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        i.f(context, "context");
        i.f(attrs, "attrs");
        this.f19132a = -1.0f;
        this.f19133b = -1.0f;
        this.f19134c = -1.0f;
        this.f19135d = -1;
        this.f19136e = new Paint();
        this.f19137f = new ArrayList();
        this.f19140i = Integer.MAX_VALUE;
        TypedArray obtainAttributes = getResources().obtainAttributes(attrs, R.styleable.FontSizeAdapter);
        this.f19132a = obtainAttributes.getDimension(R.styleable.FontSizeAdapter_maxTextSize, -1.0f);
        this.f19133b = obtainAttributes.getDimension(R.styleable.FontSizeAdapter_minTextSize, -1.0f);
        obtainAttributes.recycle();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.LineFeedTextView);
        int integer = obtainStyledAttributes.getInteger(R.styleable.LineFeedTextView_fontScaleLevel, 1);
        float f10 = obtainStyledAttributes.getResources().getConfiguration().fontScale;
        this.f19132a = COUIChangeTextUtil.getSuitableFontSize(this.f19132a, f10, integer);
        this.f19133b = COUIChangeTextUtil.getSuitableFontSize(this.f19133b, f10, integer);
        obtainStyledAttributes.recycle();
        a(1);
    }

    public final void a(int i10) {
        if (i10 <= 0) {
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            TextView textView = new TextView(getContext());
            textView.setIncludeFontPadding(true);
            textView.setTextColor(textView.getContext().getColor(R.color.incall_call_card_location_text_color));
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(0, this.f19133b);
            this.f19137f.add(textView);
            addView(textView, -1, -2);
        }
    }

    public final String b(List<String> list, int i10, int i11) {
        if (i10 == i11) {
            return list.get(i10);
        }
        String str = list.get(i10);
        int i12 = i10 + 1;
        if (i12 <= i11) {
            while (true) {
                str = str + "  |  " + list.get(i12);
                if (i12 == i11) {
                    break;
                }
                i12++;
            }
        }
        return str;
    }

    public final void c(String str, float f10) {
        TextView textView = this.f19137f.get(0);
        if (textView != null) {
            textView.setTextSize(0, f10);
        }
        TextView textView2 = this.f19137f.get(0);
        if (textView2 != null) {
            textView2.setText(str);
        }
        int size = this.f19137f.size();
        for (int i10 = 1; i10 < size; i10++) {
            this.f19137f.get(i10).setText((CharSequence) null);
            this.f19137f.get(i10).setVisibility(8);
        }
    }

    public final void d(List<String> list) {
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            this.f19138g = list;
            setVisibility(0);
            String b10 = b(list, 0, list.size() - 1);
            if (getMeasuredWidth() > 0) {
                int measuredWidth = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
                this.f19136e.setTextSize(this.f19133b);
                float f10 = measuredWidth;
                if (this.f19136e.measureText(b10) > f10) {
                    e(list, measuredWidth);
                    return;
                }
                float f11 = this.f19132a;
                this.f19136e.setTextSize(f11);
                while (true) {
                    if (this.f19136e.measureText(b10) <= f10) {
                        break;
                    }
                    f11--;
                    float f12 = this.f19133b;
                    if (f11 < f12) {
                        f11 = f12;
                        break;
                    }
                    this.f19136e.setTextSize(f11);
                }
                c(b10, f11);
                return;
            }
            return;
        }
        setVisibility(8);
        this.f19138g = null;
    }

    public final void e(List<String> list, int i10) {
        int i11 = 0;
        TextView textView = this.f19137f.get(0);
        if (textView != null) {
            textView.setTextSize(0, this.f19133b);
        }
        int size = list.size() - 1;
        int i12 = 0;
        while (true) {
            if (i11 > size) {
                break;
            }
            if (i11 == size) {
                f(list.get(i11), i12);
                i12++;
                break;
            }
            String b10 = b(list, i11, size);
            int i13 = size;
            while (i11 < i13 && this.f19136e.measureText(b10) > i10) {
                i13--;
                b10 = b(list, i11, i13);
            }
            f(b10, i12);
            i12++;
            i11 = i13 + 1;
        }
        int size2 = this.f19137f.size();
        while (i12 < size2) {
            this.f19137f.get(i12).setText((CharSequence) null);
            this.f19137f.get(i12).setVisibility(8);
            i12++;
        }
    }

    public final void f(String str, int i10) {
        a(i10 - (this.f19137f.size() - 1));
        this.f19137f.get(i10).setText(str);
        this.f19137f.get(i10).setVisibility(0);
    }

    public final int getMOriginMaxSize$incallui_release() {
        return this.f19140i;
    }

    public final String[] getMOriginTexts$incallui_release() {
        return this.f19139h;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f19135d != getMeasuredWidth()) {
            this.f19135d = getMeasuredWidth();
            d(this.f19138g);
            super.onMeasure(i10, i11);
        }
    }

    public final void setMOriginMaxSize$incallui_release(int i10) {
        this.f19140i = i10;
    }

    public final void setMOriginTexts$incallui_release(String[] strArr) {
        this.f19139h = strArr;
    }

    public final void setMaxItemForOriginText(int i10) {
        if (i10 >= 0 && this.f19140i != i10) {
            this.f19140i = i10;
            setText(this.f19139h);
        }
    }

    public final void setText(String[] strArr) {
        Object[] o10;
        boolean z10;
        if (strArr == null) {
            return;
        }
        this.f19139h = strArr;
        int i10 = this.f19140i;
        if (i10 > strArr.length) {
            i10 = strArr.length;
        }
        o10 = C1228i.o(strArr, 0, i10);
        ArrayList arrayList = new ArrayList();
        for (Object obj : o10) {
            String str = (String) obj;
            if (str != null && str.length() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                arrayList.add(obj);
            }
        }
        d(arrayList);
    }

    public static /* synthetic */ void getMOriginMaxSize$incallui_release$annotations() {
    }

    public static /* synthetic */ void getMOriginTexts$incallui_release$annotations() {
    }
}
