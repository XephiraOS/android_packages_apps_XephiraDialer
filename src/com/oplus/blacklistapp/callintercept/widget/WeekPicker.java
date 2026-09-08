package com.oplus.blacklistapp.callintercept.widget;

import android.content.Context;
import android.icu.text.DateFormatSymbols;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.chip.COUIChip;
import com.oplus.blacklistapp.callintercept.widget.WeekPicker;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* compiled from: WeekPicker.kt */
/* loaded from: classes3.dex */
public final class WeekPicker extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final a f27004e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f27005a;

    /* renamed from: b, reason: collision with root package name */
    public b f27006b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f27007c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f27008d;

    /* compiled from: WeekPicker.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: WeekPicker.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void onClick(View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WeekPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public static final void c(WeekPicker this$0, View it) {
        i.f(this$0, "this$0");
        b bVar = this$0.f27006b;
        if (bVar != null) {
            i.e(it, "it");
            bVar.onClick(it);
        }
    }

    public final void b() {
        COUIChip cOUIChip;
        int childCount = this.f27005a.getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = this.f27005a.getChildAt(i10);
                if (childAt instanceof COUIChip) {
                    cOUIChip = (COUIChip) childAt;
                } else {
                    cOUIChip = null;
                }
                if (cOUIChip != null) {
                    cOUIChip.setText(this.f27007c[i10 + 1]);
                    cOUIChip.setTag(Integer.valueOf(this.f27008d[i10]));
                    cOUIChip.setOnClickListener(new View.OnClickListener() { // from class: w6.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WeekPicker.c(WeekPicker.this, view);
                        }
                    });
                }
                if (i10 != childCount) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public final void d() {
        boolean v10;
        boolean v11;
        int i10 = 1;
        int firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek() - 1;
        String languageTag = Locale.getDefault().toLanguageTag();
        i.e(languageTag, "languageTag");
        v10 = n.v(languageTag, "bn", false, 2, null);
        if (!v10) {
            v11 = n.v(languageTag, "pt", false, 2, null);
            if (!v11) {
                i10 = firstDayOfWeek;
            }
        } else {
            i10 = 5;
        }
        e(i10);
    }

    public final void e(int i10) {
        if (i10 != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                int[] iArr = this.f27008d;
                int i12 = iArr[0];
                int length = iArr.length;
                for (int i13 = 1; i13 < length; i13++) {
                    int[] iArr2 = this.f27008d;
                    iArr2[i13 - 1] = iArr2[i13];
                }
                int[] iArr3 = this.f27008d;
                iArr3[iArr3.length - 1] = i12;
            }
            for (int i14 = 0; i14 < i10; i14++) {
                String str = this.f27007c[1];
                i.e(str, "days[1]");
                int length2 = this.f27007c.length;
                for (int i15 = 2; i15 < length2; i15++) {
                    String[] strArr = this.f27007c;
                    strArr[i15 - 1] = strArr[i15];
                }
                String[] strArr2 = this.f27007c;
                strArr2[strArr2.length - 1] = str;
            }
        }
    }

    public final void f(int i10, boolean z10) {
        COUIChip cOUIChip;
        int childCount = this.f27005a.getChildCount();
        if (childCount >= 0) {
            int i11 = 0;
            while (true) {
                View childAt = this.f27005a.getChildAt(i11);
                if (childAt instanceof COUIChip) {
                    cOUIChip = (COUIChip) childAt;
                } else {
                    cOUIChip = null;
                }
                if (cOUIChip != null) {
                    Object tag = cOUIChip.getTag();
                    if ((tag instanceof Integer) && i10 == ((Number) tag).intValue()) {
                        cOUIChip.setChecked(z10);
                    }
                }
                if (i11 != childCount) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setAllChecked(boolean z10) {
        COUIChip cOUIChip;
        int childCount = this.f27005a.getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = this.f27005a.getChildAt(i10);
                if (childAt instanceof COUIChip) {
                    cOUIChip = (COUIChip) childAt;
                } else {
                    cOUIChip = null;
                }
                if (cOUIChip != null) {
                    cOUIChip.setChecked(z10);
                }
                if (i10 != childCount) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setOnWeekPickerClickListener(b listener) {
        i.f(listener, "listener");
        this.f27006b = listener;
    }

    public /* synthetic */ WeekPicker(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeekPicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f27007c = new DateFormatSymbols().getWeekdays(1, 2);
        this.f27008d = new int[]{1, 2, 3, 4, 5, 6, 7};
        View.inflate(context, r.f27444P, this);
        View findViewById = findViewById(p.f27425y0);
        i.c(findViewById);
        this.f27005a = (ConstraintLayout) findViewById;
        d();
        b();
    }
}
