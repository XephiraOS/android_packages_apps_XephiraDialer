package com.coui.appcompat.card;

import Z8.f;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.l;
import b9.C0532b;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.theme.COUIThemeOverlay;
import kotlin.jvm.internal.i;

/* compiled from: COUICardEntrancePreference.kt */
/* loaded from: classes.dex */
public class COUICardEntrancePreference extends COUIPressFeedbackJumpPreference {
    public static final int CARD_TYPE_LARGE = 2;
    public static final int CARD_TYPE_SMALL = 1;
    public static final int TINT_ICON_ANYWAY = 2;
    public static final int TINT_ICON_BY_GLOBAL_THEME = 1;
    public static final int TINT_ICON_NONE = 0;
    private int cardType;
    private boolean showSummary;
    private boolean statusOn;
    private TextView summaryView;
    private int tintIcon;
    public static final Companion Companion = new Companion(null);
    private static final int LAYOUT_RES_TYPE_SMALL = f.f6167c;
    private static final int LAYOUT_RES_TYPE_LARGE = f.f6166b;

    /* compiled from: COUICardEntrancePreference.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardEntrancePreference(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    private final void applyIconToTintType(l lVar) {
        ImageView imageView;
        int i10 = this.tintIcon;
        boolean z10 = true;
        if (i10 == 2 || i10 == 1) {
            COUIThemeOverlay cOUIThemeOverlay = COUIThemeOverlay.getInstance();
            Context context = getContext();
            View e10 = lVar.e(R.id.icon);
            if (e10 instanceof ImageView) {
                imageView = (ImageView) e10;
            } else {
                imageView = null;
            }
            if (this.tintIcon != 2) {
                z10 = false;
            }
            cOUIThemeOverlay.applyCOUITintIcon(context, imageView, z10);
        }
    }

    private final int getLayoutResByCardType(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                return LAYOUT_RES_TYPE_SMALL;
            }
            return LAYOUT_RES_TYPE_LARGE;
        }
        return LAYOUT_RES_TYPE_SMALL;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final boolean getShowSummary() {
        return this.showSummary;
    }

    public final boolean getStatusOn() {
        return this.statusOn;
    }

    public final int getTintIcon() {
        return this.tintIcon;
    }

    public final void initSummaryView(l holder) {
        i.f(holder, "holder");
        View e10 = holder.e(R.id.summary);
        i.d(e10, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) e10;
        this.summaryView = textView;
        if (textView != null) {
            COUIDarkModeUtil.setForceDarkAllow(textView, false);
        }
        setSummaryStatus(this.statusOn);
    }

    @Override // com.coui.appcompat.card.COUIPressFeedbackJumpPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        COUIDarkModeUtil.setForceDarkAllow(holder.itemView, false);
        initSummaryView(holder);
        applyIconToTintType(holder);
    }

    public final void setCardType(int i10) {
        setLayoutResource(getLayoutResByCardType(i10));
        this.cardType = i10;
        notifyChanged();
    }

    public final void setShowSummary(boolean z10) {
        this.showSummary = z10;
        notifyChanged();
    }

    public final void setStatusOn(boolean z10) {
        this.statusOn = z10;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence charSequence) {
        if (this.showSummary) {
            super.setSummary(charSequence);
        } else {
            setStatusText1(charSequence);
        }
    }

    public final void setSummaryStatus(boolean z10) {
        int attrColor = COUIContextUtil.getAttrColor(getContext(), X8.c.f4351J, 0);
        int attrColor2 = COUIContextUtil.getAttrColor(getContext(), X8.c.f4349H, 0);
        TextView textView = this.summaryView;
        if (textView != null) {
            if (z10) {
                attrColor = attrColor2;
            }
            textView.setTextColor(attrColor);
        }
    }

    public final void setTintIcon(int i10) {
        this.tintIcon = i10;
        notifyChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardEntrancePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardEntrancePreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ COUICardEntrancePreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? C0532b.f12347f : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    @Override // androidx.preference.Preference
    public void setSummary(int i10) {
        setSummary(getContext().getString(i10));
    }

    public final void setSummary(CharSequence summary, boolean z10) {
        i.f(summary, "summary");
        if (z10) {
            super.setSummary(summary);
        } else {
            setSummary(summary);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUICardEntrancePreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        this.cardType = 1;
        this.showSummary = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6230g, i10, i11);
        setCardType(obtainStyledAttributes.getInteger(Z8.i.f6231h, 1));
        setShowSummary(obtainStyledAttributes.getBoolean(Z8.i.f6232i, true));
        setTintIcon(obtainStyledAttributes.getInteger(Z8.i.f6233j, 0));
        obtainStyledAttributes.recycle();
    }
}
