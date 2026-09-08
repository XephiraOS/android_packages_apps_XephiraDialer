package com.coui.appcompat.tips.def;

import X8.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.coui.appcompat.tips.COUICustomTopTips;

/* loaded from: classes3.dex */
public class COUIDefaultTopTips extends COUICustomTopTips implements IDefaultTopTips {
    private IDefaultTopTips mDefaultTopTips;

    public COUIDefaultTopTips(Context context) {
        this(context, null);
    }

    public IDefaultTopTips generateView() {
        COUIDefaultTopTipsView cOUIDefaultTopTipsView = new COUIDefaultTopTipsView(getContext());
        cOUIDefaultTopTipsView.setOnLinesChangedListener(new OnLinesChangedListener() { // from class: com.coui.appcompat.tips.def.COUIDefaultTopTips.1
            @Override // com.coui.appcompat.tips.def.OnLinesChangedListener
            public void onLinesChanged(int i10) {
            }
        });
        cOUIDefaultTopTipsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setContentView(cOUIDefaultTopTipsView);
        return cOUIDefaultTopTipsView;
    }

    @Override // com.coui.appcompat.tips.COUICustomTopTips
    public int getContentViewId() {
        return 0;
    }

    @Override // com.coui.appcompat.tips.COUICustomTopTips
    public void init() {
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mDefaultTopTips = generateView();
        if (RoundCornerUtil.isVersionSupport()) {
            setRadius(COUIContextUtil.getAttrDimens(getContext(), c.f4375d0));
            setWeight(COUIContextUtil.getAttrFloat(getContext(), c.f4377e0));
        } else {
            setRadius(COUIContextUtil.getAttrDimens(getContext(), c.f4373c0));
        }
        setCardBackgroundColor(ColorStateList.valueOf(COUIContextUtil.getAttrColor(getContext(), c.f4390l)));
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setCloseBtnListener(View.OnClickListener onClickListener) {
        this.mDefaultTopTips.setCloseBtnListener(onClickListener);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setCloseDrawable(Drawable drawable) {
        this.mDefaultTopTips.setCloseDrawable(drawable);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setNegativeButton(CharSequence charSequence) {
        this.mDefaultTopTips.setNegativeButton(charSequence);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setNegativeButtonColor(int i10) {
        this.mDefaultTopTips.setNegativeButtonColor(i10);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setNegativeButtonListener(View.OnClickListener onClickListener) {
        this.mDefaultTopTips.setNegativeButtonListener(onClickListener);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setPositiveButton(CharSequence charSequence) {
        this.mDefaultTopTips.setPositiveButton(charSequence);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setPositiveButtonColor(int i10) {
        this.mDefaultTopTips.setPositiveButtonColor(i10);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setPositiveButtonListener(View.OnClickListener onClickListener) {
        this.mDefaultTopTips.setPositiveButtonListener(onClickListener);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setStartIcon(Drawable drawable) {
        this.mDefaultTopTips.setStartIcon(drawable);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setTipsText(CharSequence charSequence) {
        this.mDefaultTopTips.setTipsText(charSequence);
    }

    @Override // com.coui.appcompat.tips.def.IDefaultTopTips
    public void setTipsTextColor(int i10) {
        this.mDefaultTopTips.setTipsTextColor(i10);
    }

    public COUIDefaultTopTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIDefaultTopTips(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
