package com.coui.appcompat.textview;

import X8.o;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatTextView;
import com.oua.ocr.BuildConfig;

/* loaded from: classes3.dex */
public class COUITextView extends AppCompatTextView {
    private static final String TAG = "COUITextViewDebug";
    private final Context mContext;
    private boolean mDebug;

    public COUITextView(Context context) {
        this(context, null);
    }

    private void applyLineSpaceFromViewAppearance(Resources.Theme theme, int i10) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i10, o.f5245X5);
        float f10 = obtainStyledAttributes.getFloat(o.f5253Y5, 1.0f);
        if (f10 >= 1.0f) {
            setLineSpacing(0.0f, f10);
        }
        obtainStyledAttributes.recycle();
    }

    private static int findViewAppearanceResourceId(Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, o.f5348k6, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(o.f5356l6, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static boolean viewAttrsHasAddLineSpace(Context context, Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, o.f5348k6, i10, i11);
        float f10 = obtainStyledAttributes.getFloat(o.f5364m6, 1.0f);
        obtainStyledAttributes.recycle();
        if (f10 != 1.0f) {
            return true;
        }
        return false;
    }

    public void setDebug(Boolean bool) {
        this.mDebug = bool.booleanValue();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        applyLineSpaceFromViewAppearance(this.mContext.getTheme(), i10);
    }

    public COUITextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public COUITextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int findViewAppearanceResourceId;
        this.mDebug = false;
        this.mContext = context;
        if (BuildConfig.BUILD_TYPE.equals((String) getTag())) {
            setDebug(Boolean.TRUE);
        }
        if (!viewAttrsHasAddLineSpace(context, context.getTheme(), attributeSet, i10, -1) && (findViewAppearanceResourceId = findViewAppearanceResourceId(context.getTheme(), attributeSet, i10, -1)) != -1) {
            applyLineSpaceFromViewAppearance(context.getTheme(), findViewAppearanceResourceId);
        }
        if (this.mDebug) {
            int fontMetricsInt = getPaint().getFontMetricsInt(null);
            Log.i(TAG, "textSize: " + getTextSize() + ", lineHeight: " + getLineHeight() + ", fontHeight: " + fontMetricsInt + ", Multiplier: " + getLineSpacingMultiplier());
        }
    }
}
