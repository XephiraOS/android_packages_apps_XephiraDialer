package com.coui.appcompat.tips.marquee;

import android.content.Context;
import android.util.AttributeSet;
import com.coui.appcompat.tips.def.COUIDefaultTopTips;
import com.coui.appcompat.tips.def.COUIDefaultTopTipsView;
import com.coui.appcompat.tips.def.IDefaultTopTips;

/* loaded from: classes3.dex */
public class COUIMarqueeTopTips extends COUIDefaultTopTips {
    private COUIDefaultTopTipsView mCOUIDefaultTopTipsView;

    public COUIMarqueeTopTips(Context context) {
        this(context, null);
    }

    @Override // com.coui.appcompat.tips.def.COUIDefaultTopTips
    public IDefaultTopTips generateView() {
        COUIDefaultTopTipsView cOUIDefaultTopTipsView = (COUIDefaultTopTipsView) super.generateView();
        this.mCOUIDefaultTopTipsView = cOUIDefaultTopTipsView;
        return cOUIDefaultTopTipsView;
    }

    public void startRoll() {
        this.mCOUIDefaultTopTipsView.startRoll();
    }

    public void stopRoll() {
        this.mCOUIDefaultTopTipsView.stopRoll();
    }

    public COUIMarqueeTopTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIMarqueeTopTips(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
