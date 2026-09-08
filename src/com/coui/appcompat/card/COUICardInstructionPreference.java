package com.coui.appcompat.card;

import Z8.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import androidx.preference.m;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.card.BaseCardInstructionAdapter;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.indicator.COUIPageIndicator;
import com.coui.appcompat.preference.COUIPreference;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUICardInstructionPreference.kt */
/* loaded from: classes.dex */
public final class COUICardInstructionPreference extends COUIPreference {
    public static final int CARD_INSTRUCTION_TYPE_DESCRIPTION = 1;
    public static final int CARD_INSTRUCTION_TYPE_SELECTOR = 2;
    public static final Companion Companion = new Companion(null);
    private int cardType;
    private int lastPagerItem;
    private BaseCardInstructionAdapter<?> pageAdapter;

    /* compiled from: COUICardInstructionPreference.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: COUICardInstructionPreference.kt */
    /* loaded from: classes.dex */
    public interface OnItemSelectedListener {
        void onItemSelected(int i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardInstructionPreference(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    private final BaseCardInstructionAdapter<? extends BaseCardInstructionAdapter.BaseHolder> getPageAdapter(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                return new CardInstructionDescriptionAdapter();
            }
            return new CardInstructionSelectorAdapter();
        }
        return new CardInstructionDescriptionAdapter();
    }

    private final void setPagerCallback(ViewPager2 viewPager2, final COUIPageIndicator cOUIPageIndicator) {
        viewPager2.g(new ViewPager2.i() { // from class: com.coui.appcompat.card.COUICardInstructionPreference$setPagerCallback$1
            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageScrollStateChanged(int i10) {
                super.onPageScrollStateChanged(i10);
                COUIPageIndicator.this.onPageScrollStateChanged(i10);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageScrolled(int i10, float f10, int i11) {
                super.onPageScrolled(i10, f10, i11);
                COUIPageIndicator.this.onPageScrolled(i10, f10, i11);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageSelected(int i10) {
                super.onPageSelected(i10);
                COUIPageIndicator.this.onPageSelected(i10);
                this.lastPagerItem = i10;
            }
        });
    }

    public final int getCardType() {
        return this.cardType;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        int i10 = 0;
        COUIDarkModeUtil.setForceDarkAllow(holder.itemView, false);
        View e10 = holder.e(e.f6108a0);
        i.d(e10, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        ViewPager2 viewPager2 = (ViewPager2) e10;
        View e11 = holder.e(e.f6099S);
        i.d(e11, "null cannot be cast to non-null type com.coui.appcompat.indicator.COUIPageIndicator");
        COUIPageIndicator cOUIPageIndicator = (COUIPageIndicator) e11;
        boolean z10 = true;
        if (this.pageAdapter.getItemCount() <= 1) {
            z10 = false;
        }
        if (!z10) {
            i10 = 8;
        }
        cOUIPageIndicator.setVisibility(i10);
        if (this.pageAdapter.getItemCount() > 0) {
            viewPager2.setAdapter(this.pageAdapter);
            viewPager2.setCurrentItem(this.lastPagerItem);
            viewPager2.setOffscreenPageLimit(this.pageAdapter.getItemCount());
            cOUIPageIndicator.setDotsCount(this.pageAdapter.getItemCount());
            setPagerCallback(viewPager2, cOUIPageIndicator);
        }
    }

    public final void setCardType(int i10) {
        this.cardType = i10;
        this.pageAdapter = getPageAdapter(i10);
        notifyChanged();
    }

    public final void setDisplayInfos(List<? extends BaseDisplayInfo> displayInfos) {
        i.f(displayInfos, "displayInfos");
        this.pageAdapter.updateDisplayInfos(displayInfos);
        notifyChanged();
    }

    public final void setOnItemSelected(OnItemSelectedListener onItemSelectedListener) {
        CardInstructionSelectorAdapter cardInstructionSelectorAdapter;
        i.f(onItemSelectedListener, "onItemSelectedListener");
        BaseCardInstructionAdapter<?> baseCardInstructionAdapter = this.pageAdapter;
        if (baseCardInstructionAdapter instanceof CardInstructionSelectorAdapter) {
            cardInstructionSelectorAdapter = (CardInstructionSelectorAdapter) baseCardInstructionAdapter;
        } else {
            cardInstructionSelectorAdapter = null;
        }
        if (cardInstructionSelectorAdapter != null) {
            cardInstructionSelectorAdapter.setOnSelectedCardChangedListener(onItemSelectedListener);
        }
        notifyChanged();
    }

    public final void setSelectedIndex(int i10) {
        CardInstructionSelectorAdapter cardInstructionSelectorAdapter;
        BaseCardInstructionAdapter<?> baseCardInstructionAdapter = this.pageAdapter;
        if (baseCardInstructionAdapter instanceof CardInstructionSelectorAdapter) {
            cardInstructionSelectorAdapter = (CardInstructionSelectorAdapter) baseCardInstructionAdapter;
        } else {
            cardInstructionSelectorAdapter = null;
        }
        if (cardInstructionSelectorAdapter != null) {
            cardInstructionSelectorAdapter.setSelectedIndex(i10);
        }
        notifyChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardInstructionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUICardInstructionPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ COUICardInstructionPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? m.f10636h : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUICardInstructionPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        this.cardType = 1;
        setLayoutResource(Z8.f.f6170f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6234k, i10, i11);
        setCardType(obtainStyledAttributes.getInteger(Z8.i.f6235l, 1));
        obtainStyledAttributes.recycle();
        this.pageAdapter = getPageAdapter(this.cardType);
    }
}
