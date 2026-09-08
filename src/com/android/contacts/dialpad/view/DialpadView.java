package com.android.contacts.dialpad.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.dialpad.view.DialpadImageButton;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import com.oplus.screenshot.OplusLongshotUnsupported;

/* loaded from: classes.dex */
public class DialpadView extends ViewGroup implements OplusLongshotUnsupported {

    /* renamed from: a, reason: collision with root package name */
    public DialpadImageButton[] f15010a;

    /* renamed from: b, reason: collision with root package name */
    public Resources f15011b;

    /* renamed from: c, reason: collision with root package name */
    public int f15012c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f15013d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f15014e;

    /* renamed from: f, reason: collision with root package name */
    public DialpadMode f15015f;

    /* renamed from: g, reason: collision with root package name */
    public a f15016g;

    /* renamed from: h, reason: collision with root package name */
    public int f15017h;

    /* renamed from: i, reason: collision with root package name */
    public int f15018i;

    /* renamed from: j, reason: collision with root package name */
    public int f15019j;

    /* renamed from: k, reason: collision with root package name */
    public int f15020k;

    /* renamed from: l, reason: collision with root package name */
    public int f15021l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f15022m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f15023n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f15024o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15025p;

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f15005q = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.star, R.id.zero, R.id.pound};

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f15006r = {OplusPhoneUtils.DeviceState.LOCK_DEVICE, "2", "3", "4", "5", "6", "7", "8", "9", "", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, ""};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f15007x = {R.string.description_image_button_one, R.string.description_image_button_two, R.string.description_image_button_three, R.string.description_image_button_four, R.string.description_image_button_five, R.string.description_image_button_six, R.string.description_image_button_seven, R.string.description_image_button_eight, R.string.description_image_button_nine, R.string.image_button_star_description, R.string.description_image_button_zero, R.string.image_button_pound_description};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f15008y = {R.drawable.pb_ic_dial_key_one, R.drawable.pb_ic_dial_key_two, R.drawable.pb_ic_dial_key_three, R.drawable.pb_ic_dial_key_four, R.drawable.pb_ic_dial_key_five, R.drawable.pb_ic_dial_key_six, R.drawable.pb_ic_dial_key_seven, R.drawable.pb_ic_dial_key_eight, R.drawable.pb_ic_dial_key_nine, R.drawable.pb_ic_dial_key_star, R.drawable.pb_ic_dial_key_zero, R.drawable.pb_ic_dial_key_pound};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f15009z = {R.array.dialpad_letters, R.array.dialpad_letters_stroke, R.array.dialpad_letters_indonesian, R.array.dialpad_letters_thailand, R.array.dialpad_letters_vietnam, R.array.dialpad_letters_russian, R.array.dialpad_letters_taiwan, R.array.dialpad_letters_ukrainian};

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f15002A = {R.array.talkback_dialpad_letters, R.array.talkback_dialpad_letters_stroke, R.array.talkback_dialpad_letters_indonesian, R.array.talkback_dialpad_letters_thailand, R.array.talkback_dialpad_letters_vietnam, R.array.talkback_dialpad_letters_russian, R.array.talkback_dialpad_letters_taiwan, R.array.talkback_dialpad_letters_ukrainian};

    /* renamed from: B, reason: collision with root package name */
    public static final int[] f15003B = {R.drawable.pb_ic_dial_key_voicemail, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: C, reason: collision with root package name */
    public static final int[] f15004C = {R.drawable.pb_ic_dial_key_heng, R.drawable.pb_ic_dial_key_shu, R.drawable.pb_ic_dial_key_pie, R.drawable.pb_ic_dial_key_na, R.drawable.pb_ic_dial_key_henggou, -1, -1, -1, -1, -1, -1, -1};

    /* loaded from: classes.dex */
    public enum DialpadMode {
        PINYIN_MODE,
        STROKE_MODE,
        INDONESIAN_MODE_EXP,
        TAVEN_MODE_EXP,
        VIETNAMESE_MODE_EXP,
        RUSSIAN_MODE_EXP,
        TAIWAN_MODE_EXP,
        UKRAINIAN_MODE_EXP
    }

    /* loaded from: classes.dex */
    public interface a {
        boolean G();
    }

    public DialpadView(Context context, DialpadMode dialpadMode) {
        super(context);
        this.f15010a = null;
        this.f15011b = null;
        this.f15012c = -1;
        this.f15013d = null;
        this.f15014e = null;
        this.f15017h = getResources().getDimensionPixelSize(R.dimen.dialpad_button_height);
        this.f15018i = getResources().getDimensionPixelSize(R.dimen.fold_dialpad_padding);
        this.f15019j = getResources().getDimensionPixelSize(R.dimen.dialpad_buttons_paddingTop);
        this.f15020k = R.color.pb_color_dialpad_letter;
        this.f15021l = R.color.pb_color_dialpad_number;
        this.f15022m = f15008y;
        this.f15023n = f15003B;
        this.f15024o = f15004C;
        this.f15025p = false;
        this.f15015f = dialpadMode;
    }

    public static DialpadMode b(int i10) {
        if (i10 == 1) {
            return DialpadMode.STROKE_MODE;
        }
        if (i10 == 0) {
            return DialpadMode.PINYIN_MODE;
        }
        if (i10 == 4) {
            return DialpadMode.TAVEN_MODE_EXP;
        }
        if (i10 == 5) {
            return DialpadMode.VIETNAMESE_MODE_EXP;
        }
        if (i10 == 7) {
            return DialpadMode.RUSSIAN_MODE_EXP;
        }
        if (i10 == 8) {
            return DialpadMode.TAIWAN_MODE_EXP;
        }
        if (i10 == 9) {
            return DialpadMode.UKRAINIAN_MODE_EXP;
        }
        return DialpadMode.INDONESIAN_MODE_EXP;
    }

    public static boolean e(com.customize.contacts.startupspeed.a aVar) {
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    public void a(DialpadMode dialpadMode) {
        int[] iArr;
        if (dialpadMode == this.f15015f) {
            return;
        }
        this.f15015f = dialpadMode;
        int[] iArr2 = f15007x;
        int[] iArr3 = this.f15022m;
        DialpadMode dialpadMode2 = DialpadMode.STROKE_MODE;
        if (dialpadMode == dialpadMode2) {
            iArr = this.f15024o;
        } else {
            iArr = this.f15023n;
        }
        Resources resources = this.f15011b;
        int[] iArr4 = f15009z;
        String[] stringArray = resources.getStringArray(iArr4[0]);
        if (FeatureOption.o()) {
            if (iArr4.length == DialpadMode.values().length) {
                stringArray = this.f15011b.getStringArray(iArr4[this.f15015f.ordinal()]);
            }
        } else if (iArr4.length == DialpadMode.values().length) {
            stringArray = this.f15015f == dialpadMode2 ? this.f15011b.getStringArray(iArr4[dialpadMode2.ordinal()]) : this.f15011b.getStringArray(iArr4[DialpadMode.PINYIN_MODE.ordinal()]);
        }
        int i10 = 0;
        while (true) {
            DialpadImageButton[] dialpadImageButtonArr = this.f15010a;
            if (i10 < dialpadImageButtonArr.length && i10 < stringArray.length && i10 < iArr2.length && i10 < iArr3.length && i10 < iArr.length) {
                dialpadImageButtonArr[i10].e(iArr3[i10], i10, f15006r[i10]);
                this.f15010a[i10].setLetterText(stringArray[i10]);
                this.f15010a[i10].setLetterIcon(iArr[i10]);
                this.f15010a[i10].f(dialpadMode, i10);
                this.f15010a[i10].n(i10, false);
                if (i10 == 0) {
                    if (this.f15015f != DialpadMode.STROKE_MODE && !this.f15025p) {
                        this.f15010a[i10].setContentDescription(((Object) this.f15011b.getText(iArr2[i10])) + " " + this.f15011b.getString(R.string.type_voicemail) + " " + stringArray[i10]);
                    } else {
                        this.f15010a[i10].setContentDescription(((Object) this.f15011b.getText(iArr2[i10])) + " " + stringArray[i10]);
                    }
                } else {
                    this.f15010a[i10].setContentDescription(((Object) this.f15011b.getText(iArr2[i10])) + " " + stringArray[i10]);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public void c() {
        d(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(com.customize.contacts.startupspeed.a r19) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialpadView.d(com.customize.contacts.startupspeed.a):void");
    }

    public void f(DialpadImageButton.b bVar, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener) {
        for (DialpadImageButton dialpadImageButton : this.f15010a) {
            dialpadImageButton.setOnPressedListener(bVar);
            dialpadImageButton.setOnLongClickListener(onLongClickListener);
            dialpadImageButton.setOnClickListener(onClickListener);
        }
    }

    public void g(boolean z10, boolean z11) {
        int i10;
        int i11 = 0;
        while (true) {
            DialpadImageButton[] dialpadImageButtonArr = this.f15010a;
            if (i11 < dialpadImageButtonArr.length) {
                dialpadImageButtonArr[i11].i(z10, z11, i11);
                DialpadImageButton dialpadImageButton = this.f15010a[i11];
                if (z10) {
                    i10 = R.drawable.pb_bg_dialpad_button_small_ripple;
                } else {
                    i10 = R.drawable.pb_bg_dialpad_button_ripple;
                }
                dialpadImageButton.setBackgroundResource(i10);
                i11++;
            } else {
                return;
            }
        }
    }

    public boolean isLongshotUnsupported() {
        a aVar = this.f15016g;
        if (aVar == null) {
            return true;
        }
        boolean G10 = aVar.G();
        H7.b.e("DialpadView", "isDialpadShowed: " + G10);
        return G10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = this.f15018i;
        int i15 = i10 + i14;
        int i16 = i11 + this.f15019j;
        int i17 = i12 - i14;
        int dimensionPixelSize = this.f15011b.getDimensionPixelSize(R.dimen.dialpad_content_max_width);
        if (i17 - i15 > dimensionPixelSize) {
            int width = (getWidth() - dimensionPixelSize) / 2;
            int i18 = this.f15018i;
            i15 = (i15 - i18) + width;
            i17 = (i17 + i18) - width;
        }
        int i19 = (i17 - i15) / 3;
        int i20 = (i13 - i16) / 4;
        for (int i21 = 0; i21 < 3; i21++) {
            for (int i22 = 0; i22 < 4; i22++) {
                int i23 = (i19 * i21) + i15;
                int i24 = (i20 * i22) + i16;
                this.f15010a[(i22 * 3) + i21].layout(i23, i24, i23 + i19, i24 + i20);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int resolveSize = View.resolveSize(0, i10);
        int floor = (int) Math.floor((this.f15017h * 4.0d) + this.f15019j);
        for (DialpadImageButton dialpadImageButton : this.f15010a) {
            dialpadImageButton.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        setMeasuredDimension(resolveSize, floor);
    }

    public void setButtonDrawableIds(int[] iArr) {
        this.f15022m = iArr;
    }

    public void setButtonLetterIconDrawableIds(int[] iArr) {
        this.f15023n = iArr;
    }

    public void setButtonStrokeLetterIconDrawableIds(int[] iArr) {
        this.f15024o = iArr;
    }

    public void setDialPadLetterColor(int i10) {
        this.f15020k = i10;
    }

    public void setDialpadButtonHeight(int i10) {
        this.f15017h = i10;
    }

    public void setDialpadPadding(int i10) {
        this.f15018i = i10;
    }

    public void setDialpadPaddingTop(int i10) {
        this.f15019j = i10;
    }

    public void setIsScene(boolean z10) {
        this.f15025p = z10;
    }

    public void setListener(a aVar) {
        this.f15016g = aVar;
    }

    public void setNumberTextColor(int i10) {
        this.f15021l = i10;
    }

    public void setSilkType(int i10) {
        this.f15015f = b(i10);
    }

    public void setTouchListener(View.OnTouchListener onTouchListener) {
        for (DialpadImageButton dialpadImageButton : this.f15010a) {
            dialpadImageButton.setOnTouchListener(onTouchListener);
        }
    }

    public DialpadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialpadView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, 0);
        this.f15010a = null;
        this.f15011b = null;
        this.f15012c = -1;
        this.f15013d = null;
        this.f15014e = null;
        this.f15017h = getResources().getDimensionPixelSize(R.dimen.dialpad_button_height);
        this.f15018i = getResources().getDimensionPixelSize(R.dimen.fold_dialpad_padding);
        this.f15019j = getResources().getDimensionPixelSize(R.dimen.dialpad_buttons_paddingTop);
        this.f15020k = R.color.pb_color_dialpad_letter;
        this.f15021l = R.color.pb_color_dialpad_number;
        this.f15022m = f15008y;
        this.f15023n = f15003B;
        this.f15024o = f15004C;
        this.f15025p = false;
    }
}
