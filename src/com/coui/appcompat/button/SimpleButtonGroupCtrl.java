package com.coui.appcompat.button;

import X8.f;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.coui.appcompat.button.listener.OnSizeChangeListener;
import com.coui.appcompat.button.listener.OnTextChangeListener;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.state.IViewStateController;
import com.coui.appcompat.state.Processor;
import com.coui.appcompat.state.SizeProcessor;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class SimpleButtonGroupCtrl implements IViewStateController, OnTextChangeListener, OnSizeChangeListener, View.OnLayoutChangeListener {
    public static final int MAX_SIZE = 2;
    public static final int MULTI_LINE = 2;
    public static final int SINGLE_LINE = 1;
    private static final String TAG = "SimpleButtonGroupCtrl";
    private COUIButton mCustomButton;
    private SingleButtonWrap mCustomButtonWarp;
    private LinearLayout mCustomLayout;
    private COUIButton mTextChangeBtn;
    private List<SingleButtonWrap> mSingleButtonWrapList = new LinkedList();
    private int mLineCountIndex = -1;
    private int mCurLineCount = 1;
    private int mType = 1;

    private int getButtonLineCount(COUIButton cOUIButton) {
        Context context = cOUIButton.getContext();
        if (TextUtils.isEmpty(cOUIButton.getText())) {
            return 1;
        }
        if (!(cOUIButton.getParent() instanceof COUIButtonLayout)) {
            return cOUIButton.getLineCount();
        }
        if (cOUIButton.isDescType()) {
            return 1;
        }
        COUIButtonLayout cOUIButtonLayout = (COUIButtonLayout) cOUIButton.getParent();
        int measureMaxWidth = cOUIButton.getMeasureMaxWidth();
        float measureText = cOUIButton.getPaint().measureText(cOUIButton.getText().toString());
        if (!COUIResponsiveUtils.isSmallScreen(context, context.getResources().getDisplayMetrics().widthPixels)) {
            if (cOUIButtonLayout.getOrientation() == 0) {
                measureMaxWidth = context.getResources().getDimensionPixelSize(f.f4548M2);
            } else {
                measureMaxWidth = context.getResources().getDimensionPixelSize(f.f4758o2);
            }
        }
        if (measureText <= (measureMaxWidth - cOUIButton.getPaddingStart()) - cOUIButton.getPaddingEnd() || measureMaxWidth == 0) {
            return 1;
        }
        return 2;
    }

    private int getButtonMaxHeight(COUIButton cOUIButton, int i10) {
        if (cOUIButton == null) {
            return 0;
        }
        if (cOUIButton.isDescType()) {
            return (int) COUIChangeTextUtil.getDpG2Size(cOUIButton.getContext().getResources().getDimensionPixelSize(f.f4764p0), cOUIButton.getContext().getResources().getConfiguration().fontScale);
        }
        return (((cOUIButton.getLineHeight() * i10) + cOUIButton.getPaddingTop()) + cOUIButton.getPaddingBottom()) - ((int) (cOUIButton.getLineHeight() - (cOUIButton.getLineHeight() / cOUIButton.getLineSpacingMultiplier())));
    }

    private void handleExtraLongLogic(int i10, List<SingleButtonWrap> list) {
        boolean z10;
        int buttonMaxHeight;
        SingleButtonWrap singleButtonWrap = list.get(i10);
        if (singleButtonWrap != null) {
            COUIButton cOUIButton = (COUIButton) singleButtonWrap.getProcessView();
            if (cOUIButton != null) {
                if (!(cOUIButton.getParent() instanceof COUIButtonLayout)) {
                    return;
                }
                Context context = cOUIButton.getContext();
                COUIButtonLayout cOUIButtonLayout = (COUIButtonLayout) cOUIButton.getParent();
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(f.f4548M2);
                int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(f.f4828x5);
                int height = cOUIButton.getHeight();
                boolean isSmallScreen = COUIResponsiveUtils.isSmallScreen(context, context.getResources().getDisplayMetrics().widthPixels);
                context.getResources().getDimensionPixelSize(f.f4541L2);
                if ((height * 2) + dimensionPixelSize2 <= cOUIButtonLayout.getMaxHeight() && cOUIButtonLayout.getMaxHeight() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i11 = -1;
                if (this.mCurLineCount == 2 && z10 && !cOUIButtonLayout.isLimitHeight()) {
                    cOUIButtonLayout.setOrientation(1);
                    if (!isSmallScreen) {
                        i11 = context.getResources().getDimensionPixelSize(f.f4758o2);
                    }
                    buttonMaxHeight = -2;
                } else {
                    cOUIButtonLayout.setOrientation(0);
                    if (isSmallScreen || cOUIButtonLayout.isForceSmallScreenWidth()) {
                        dimensionPixelSize = -1;
                    }
                    buttonMaxHeight = getButtonMaxHeight(cOUIButton, this.mCurLineCount);
                    i11 = dimensionPixelSize;
                }
                SizeProcessor create = new SizeProcessor.Builder(this.mCurLineCount).setHeight(buttonMaxHeight).setWidth(i11).create();
                for (int i12 = 0; i12 < list.size(); i12++) {
                    List<Processor> list2 = list.get(i12).getProcessorMap().get(this.mCurLineCount);
                    if (list2 != null) {
                        for (Processor processor : list2) {
                            if (processor instanceof SizeProcessor) {
                                create.process(list.get(i12).getProcessView());
                            } else {
                                processor.process(list.get(i12).getProcessView());
                            }
                        }
                    }
                }
                setHorizontalButtonMargin(list);
                return;
            }
            throw new IllegalArgumentException("ButtonGroupStateController: button == null");
        }
        throw new IllegalArgumentException("ButtonGroupStateController: buttonWrap == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLayoutChange$0(COUIButton cOUIButton) {
        List<SingleButtonWrap> list = this.mSingleButtonWrapList;
        if (list != null && list.size() > 0) {
            int i10 = 1;
            if (this.mCurLineCount > 1) {
                i10 = 2;
            }
            onViewStateChanged(i10);
            postProcessExtraLongLogic(cOUIButton, this.mLineCountIndex, this.mSingleButtonWrapList);
        }
    }

    private void postProcessExtraLongLogic(COUIButton cOUIButton, int i10, List<SingleButtonWrap> list) {
        if (list != null && list.size() > 0) {
            handleExtraLongLogic(i10, list);
        }
    }

    private void processSameSize() {
        COUIButton cOUIButton = this.mCustomButton;
        if (cOUIButton != null && this.mCustomLayout != null) {
            int dimensionPixelSize = cOUIButton.getContext().getResources().getDimensionPixelSize(f.f4548M2);
            int i10 = 2;
            if (getButtonLineCount(this.mCustomButton) != 2) {
                i10 = 1;
            }
            int buttonMaxHeight = getButtonMaxHeight(this.mCustomButton, i10);
            SingleButtonWrap singleButtonWrap = this.mCustomButtonWarp;
            if (singleButtonWrap != null) {
                singleButtonWrap.onViewStateChanged(i10);
            }
            if (!(this.mCustomButton.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                return;
            }
            boolean isSmallScreen = COUIResponsiveUtils.isSmallScreen(this.mCustomButton.getContext(), this.mCustomButton.getContext().getResources().getDisplayMetrics().widthPixels);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mCustomButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mCustomLayout.getLayoutParams();
            if (isSmallScreen) {
                layoutParams.weight = 1.0f;
                layoutParams2.weight = 1.0f;
                dimensionPixelSize = -1;
            } else {
                layoutParams.weight = 0.0f;
                layoutParams2.weight = 0.0f;
            }
            SizeProcessor create = new SizeProcessor.Builder(i10).setHeight(buttonMaxHeight).setWidth(dimensionPixelSize).create();
            create.process(this.mCustomLayout);
            create.process(this.mCustomButton);
            this.mCustomButton.setLayoutParams(layoutParams);
            this.mCustomLayout.setLayoutParams(layoutParams2);
        }
    }

    private void setHorizontalButtonMargin(List<SingleButtonWrap> list) {
        if (list.size() != 2) {
            return;
        }
        SingleButtonWrap singleButtonWrap = list.get(0);
        int i10 = 1;
        SingleButtonWrap singleButtonWrap2 = list.get(1);
        COUIButton cOUIButton = (COUIButton) singleButtonWrap.getProcessView();
        COUIButton cOUIButton2 = (COUIButton) singleButtonWrap2.getProcessView();
        Context context = cOUIButton.getContext();
        if (!(cOUIButton.getParent() instanceof COUIButtonLayout)) {
            return;
        }
        boolean isSmallScreen = COUIResponsiveUtils.isSmallScreen(context, context.getResources().getDisplayMetrics().widthPixels);
        COUIButtonLayout cOUIButtonLayout = (COUIButtonLayout) cOUIButton.getParent();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cOUIButton.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cOUIButton2.getLayoutParams();
        cOUIButtonLayout.removeAllViews();
        if (cOUIButtonLayout.getOrientation() == 0) {
            if (!isSmallScreen && !cOUIButtonLayout.isForceSmallScreenWidth()) {
                i10 = 0;
            }
            Resources resources = context.getResources();
            int i11 = f.f4596T1;
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(i11));
            layoutParams.setMarginStart(0);
            layoutParams.topMargin = 0;
            float f10 = i10;
            layoutParams.weight = f10;
            cOUIButton.setLayoutParams(layoutParams);
            layoutParams2.setMarginEnd(0);
            layoutParams2.setMarginStart(context.getResources().getDimensionPixelSize(i11));
            layoutParams2.topMargin = 0;
            layoutParams2.weight = f10;
            cOUIButton2.setLayoutParams(layoutParams2);
            cOUIButtonLayout.addView(cOUIButton);
            cOUIButtonLayout.addView(cOUIButton2);
            return;
        }
        layoutParams.setMarginEnd(0);
        layoutParams.setMarginStart(0);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(f.f4828x5);
        float f11 = 0;
        layoutParams.weight = f11;
        cOUIButton.setLayoutParams(layoutParams);
        layoutParams2.setMarginEnd(0);
        layoutParams2.setMarginStart(0);
        layoutParams2.topMargin = 0;
        layoutParams2.weight = f11;
        cOUIButton2.setLayoutParams(layoutParams2);
        cOUIButtonLayout.addView(cOUIButton2);
        cOUIButtonLayout.addView(cOUIButton);
    }

    public int getSingleButtonWrapListSize() {
        return this.mSingleButtonWrapList.size();
    }

    public int getType() {
        return this.mType;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Iterator<SingleButtonWrap> it = this.mSingleButtonWrapList.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
        SingleButtonWrap singleButtonWrap = this.mCustomButtonWarp;
        if (singleButtonWrap != null) {
            singleButtonWrap.onConfigurationChanged(configuration);
            processSameSize();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if ((view instanceof COUIButton) && view == this.mTextChangeBtn) {
            this.mTextChangeBtn = null;
            final COUIButton cOUIButton = (COUIButton) view;
            int buttonLineCount = getButtonLineCount(cOUIButton);
            int i18 = -1;
            int i19 = -1;
            for (int i20 = 0; i20 < this.mSingleButtonWrapList.size(); i20++) {
                COUIButton cOUIButton2 = (COUIButton) this.mSingleButtonWrapList.get(i20).getProcessView();
                int buttonLineCount2 = getButtonLineCount(cOUIButton2);
                if (cOUIButton2 == view) {
                    this.mLineCountIndex = i20;
                } else if (buttonLineCount2 > i18) {
                    i19 = i20;
                    i18 = buttonLineCount2;
                }
            }
            if (buttonLineCount > i18) {
                this.mCurLineCount = buttonLineCount;
            } else {
                this.mCurLineCount = i18;
                this.mLineCountIndex = i19;
            }
            cOUIButton.post(new Runnable() { // from class: com.coui.appcompat.button.b
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleButtonGroupCtrl.this.lambda$onLayoutChange$0(cOUIButton);
                }
            });
        }
    }

    @Override // com.coui.appcompat.button.listener.OnSizeChangeListener
    public void onSizeChanged(View view, int i10, int i11, int i12, int i13) {
        processSameSize();
    }

    @Override // com.coui.appcompat.button.listener.OnTextChangeListener
    public void onTextChanged(View view, CharSequence charSequence, int i10, int i11, int i12) {
        this.mTextChangeBtn = (COUIButton) view;
        view.requestLayout();
    }

    @Override // com.coui.appcompat.state.IViewStateController
    public void onViewStateChanged(int i10) {
        int i11 = this.mLineCountIndex;
        if (i11 < 0) {
            COUILog.e(TAG, "The mLineCountIndex cannot be less than zero");
            return;
        }
        SingleButtonWrap singleButtonWrap = this.mSingleButtonWrapList.get(i11);
        if (singleButtonWrap != null) {
            singleButtonWrap.onViewStateChanged(i10);
        }
        SingleButtonWrap singleButtonWrap2 = this.mCustomButtonWarp;
        if (singleButtonWrap2 != null) {
            singleButtonWrap2.onViewStateChanged(i10);
        }
    }

    public void registerButton(COUIButton cOUIButton) {
        registerButton(cOUIButton, 1);
    }

    public void registerButtonAndCustomView(COUIButton cOUIButton, LinearLayout linearLayout, int i10) {
        this.mCustomButtonWarp = new SingleButtonWrap(cOUIButton, i10);
        this.mCustomButton = cOUIButton;
        this.mCustomLayout = linearLayout;
        cOUIButton.setOnSizeChangeListener(this);
        cOUIButton.setText(cOUIButton.getText());
        processSameSize();
    }

    @Override // com.coui.appcompat.state.IViewStateController
    public void release() {
        for (SingleButtonWrap singleButtonWrap : this.mSingleButtonWrapList) {
            singleButtonWrap.getProcessView().removeOnLayoutChangeListener(this);
            singleButtonWrap.release();
        }
        this.mSingleButtonWrapList.clear();
        this.mTextChangeBtn = null;
        SingleButtonWrap singleButtonWrap2 = this.mCustomButtonWarp;
        if (singleButtonWrap2 != null) {
            singleButtonWrap2.release();
        }
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public void unregisterButton(COUIButton cOUIButton) {
        if (cOUIButton != null && this.mSingleButtonWrapList.size() != 0) {
            Iterator<SingleButtonWrap> it = this.mSingleButtonWrapList.iterator();
            while (it.hasNext()) {
                SingleButtonWrap next = it.next();
                if (next.getProcessView() == cOUIButton) {
                    next.release();
                    it.remove();
                }
            }
        }
    }

    public void registerButton(COUIButton cOUIButton, int i10) {
        if (this.mSingleButtonWrapList.size() >= 2) {
            return;
        }
        setType(i10);
        this.mSingleButtonWrapList.add(new SingleButtonWrap(cOUIButton, i10));
        cOUIButton.setOnTextChangeListener(this);
        cOUIButton.addOnLayoutChangeListener(this);
        cOUIButton.setText(cOUIButton.getText());
    }
}
