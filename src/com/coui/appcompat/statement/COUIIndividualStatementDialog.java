package com.coui.appcompat.statement;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c9.C0576h;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.panel.COUIPanelMultiWindowUtils;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import java.util.ArrayList;

/* compiled from: COUIIndividualStatementDialog.kt */
/* loaded from: classes.dex */
public class COUIIndividualStatementDialog extends COUIBottomSheetDialog {
    public static final Companion Companion = new Companion(null);
    public static final int MEDIUM_LARGE_SCREEN_SW_THRESHOLD = 480;
    public static final float ORIGIN_STATEMENT_TEXT_SIZE = 14.0f;
    public static final float STATEMENT_TEXT_SIZE_WITH_CHECKBOX = 12.0f;
    private TextView appStatement;
    private COUIButton bottomButton;
    private CharSequence bottomButtonText;
    private TextView exitButton;
    private CharSequence exitButtonText;
    private boolean isInSmallLand;
    private boolean isInSmallPortrait;
    private COUIComponentMaxHeightScrollView mScrollViewComponent;
    private OnButtonClickListener onButtonClickListener;
    private LinearLayout scrollViewLayout;
    private LinearLayout smallLandButtonLayout;
    private COUIButton smallLandConfirmButton;
    private COUIButton smallLandExitButton;
    private CharSequence statement;
    private CharSequence titleText;
    private TextView titleView;

    /* compiled from: COUIIndividualStatementDialog.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: COUIIndividualStatementDialog.kt */
    /* loaded from: classes.dex */
    public interface OnButtonClickListener {
        void onBottomButtonClick(ArrayList<PrivacyItem> arrayList);

        void onExitButtonClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIIndividualStatementDialog(Context context) {
        this(context, 0, 0.0f, 0.0f, 14, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addPrivacyList$lambda$16$lambda$15$lambda$14(COUIIndividualStatementDialog this$0, COUICheckBox cOUICheckBox, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.resetBottomButton();
    }

    private final ArrayList<PrivacyItem> getCheckedFunctionList() {
        ArrayList<PrivacyItem> arrayList = new ArrayList<>();
        LinearLayout linearLayout = this.scrollViewLayout;
        if (linearLayout.getChildCount() > 1) {
            int childCount = linearLayout.getChildCount();
            for (int i10 = 1; i10 < childCount; i10++) {
                View childAt = linearLayout.getChildAt(i10);
                kotlin.jvm.internal.i.d(childAt, "null cannot be cast to non-null type com.coui.appcompat.statement.COUICheckBoxItemView");
                COUICheckBoxItemView cOUICheckBoxItemView = (COUICheckBoxItemView) childAt;
                if (cOUICheckBoxItemView.isChecked()) {
                    arrayList.add(cOUICheckBoxItemView.getPrivacyItem());
                }
            }
        }
        return arrayList;
    }

    private final void initView() {
        int dimensionPixelOffset;
        TextView textView = this.appStatement;
        COUIDarkModeUtil.setForceDarkAllow(textView, false);
        textView.setTextColor(COUIContextUtil.getAttrColor(textView.getContext(), X8.c.f4351J));
        COUIChangeTextUtil.adaptFontSize(textView, 2);
        textView.setMovementMethod(COUILinkMovementMethod.INSTANCE);
        TextView textView2 = this.exitButton;
        COUIChangeTextUtil.adaptFontSize(textView2, 4);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIIndividualStatementDialog.initView$lambda$3$lambda$2(COUIIndividualStatementDialog.this, view);
            }
        });
        COUITextViewCompatUtil.setPressRippleDrawable(textView2);
        COUIButton cOUIButton = this.bottomButton;
        ViewGroup.LayoutParams layoutParams = cOUIButton.getLayoutParams();
        if (this.isInSmallPortrait) {
            dimensionPixelOffset = cOUIButton.getContext().getResources().getDimensionPixelOffset(Z8.c.f6015e0);
        } else {
            dimensionPixelOffset = cOUIButton.getContext().getResources().getDimensionPixelOffset(Z8.c.f6023i0);
        }
        layoutParams.width = dimensionPixelOffset;
        cOUIButton.setLayoutParams(layoutParams);
        cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIIndividualStatementDialog.initView$lambda$6$lambda$5(COUIIndividualStatementDialog.this, view);
            }
        });
        this.smallLandConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIIndividualStatementDialog.initView$lambda$7(COUIIndividualStatementDialog.this, view);
            }
        });
        this.smallLandExitButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIIndividualStatementDialog.initView$lambda$8(COUIIndividualStatementDialog.this, view);
            }
        });
        updateBottomButton(this.isInSmallLand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(COUIIndividualStatementDialog this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        OnButtonClickListener onButtonClickListener = this$0.onButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onExitButtonClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6$lambda$5(COUIIndividualStatementDialog this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        OnButtonClickListener onButtonClickListener = this$0.onButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onBottomButtonClick(this$0.getCheckedFunctionList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(COUIIndividualStatementDialog this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        OnButtonClickListener onButtonClickListener = this$0.onButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onBottomButtonClick(this$0.getCheckedFunctionList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(COUIIndividualStatementDialog this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        OnButtonClickListener onButtonClickListener = this$0.onButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onExitButtonClick();
        }
    }

    private final boolean isSmallScreen(Configuration configuration) {
        if (configuration.smallestScreenWidthDp < 480) {
            return true;
        }
        return false;
    }

    private final void resetBottomButton() {
        LinearLayout linearLayout = this.scrollViewLayout;
        boolean z10 = false;
        if (linearLayout.getChildCount() > 1) {
            int childCount = linearLayout.getChildCount();
            for (int i10 = 1; i10 < childCount; i10++) {
                View childAt = linearLayout.getChildAt(i10);
                kotlin.jvm.internal.i.d(childAt, "null cannot be cast to non-null type com.coui.appcompat.statement.COUICheckBoxItemView");
                if (((COUICheckBoxItemView) childAt).isChecked()) {
                    z10 = true;
                }
            }
        }
        this.bottomButton.setEnabled(z10);
        this.smallLandConfirmButton.setEnabled(z10);
    }

    private final void updateBottomButton(boolean z10) {
        int i10;
        int i11;
        TextView textView = this.exitButton;
        int i12 = 0;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        textView.setVisibility(i10);
        COUIButton cOUIButton = this.bottomButton;
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        cOUIButton.setVisibility(i11);
        LinearLayout linearLayout = this.smallLandButtonLayout;
        if (!z10) {
            i12 = 8;
        }
        linearLayout.setVisibility(i12);
    }

    private final void updateUI(Configuration configuration) {
        boolean z10;
        int dimensionPixelOffset;
        boolean z11 = false;
        if (isSmallScreen(configuration) && !COUIPanelMultiWindowUtils.isPortrait(configuration)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.isInSmallLand != z10) {
            this.isInSmallLand = z10;
            updateBottomButton(z10);
        }
        if (isSmallScreen(configuration) && COUIPanelMultiWindowUtils.isPortrait(configuration)) {
            z11 = true;
        }
        if (this.isInSmallPortrait != z11) {
            this.isInSmallPortrait = z11;
            COUIButton cOUIButton = this.bottomButton;
            ViewGroup.LayoutParams layoutParams = cOUIButton.getLayoutParams();
            if (this.isInSmallPortrait) {
                dimensionPixelOffset = cOUIButton.getContext().getResources().getDimensionPixelOffset(Z8.c.f6015e0);
            } else {
                dimensionPixelOffset = cOUIButton.getContext().getResources().getDimensionPixelOffset(Z8.c.f6023i0);
            }
            layoutParams.width = dimensionPixelOffset;
            cOUIButton.setLayoutParams(layoutParams);
        }
    }

    public final void addPrivacyList(ArrayList<PrivacyItem> arrayList) {
        int dimensionPixelOffset;
        float f10;
        int dimensionPixelOffset2;
        if (arrayList != null) {
            int i10 = 0;
            for (Object obj : arrayList) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.o.o();
                }
                Context context = getContext();
                kotlin.jvm.internal.i.e(context, "context");
                COUICheckBoxItemView cOUICheckBoxItemView = new COUICheckBoxItemView(context, (PrivacyItem) obj);
                cOUICheckBoxItemView.setOnStateChangeListener(new COUICheckBox.OnStateChangeListener() { // from class: com.coui.appcompat.statement.b
                    @Override // com.coui.appcompat.checkbox.COUICheckBox.OnStateChangeListener
                    public final void onStateChanged(COUICheckBox cOUICheckBox, int i12) {
                        COUIIndividualStatementDialog.addPrivacyList$lambda$16$lambda$15$lambda$14(COUIIndividualStatementDialog.this, cOUICheckBox, i12);
                    }
                });
                this.scrollViewLayout.addView(cOUICheckBoxItemView, -1, -2);
                this.bottomButton.setEnabled(false);
                this.smallLandConfirmButton.setEnabled(false);
                if (i10 == arrayList.size() - 1) {
                    cOUICheckBoxItemView.findViewById(Z8.e.f6127k).setVisibility(8);
                }
                i10 = i11;
            }
        }
        COUIComponentMaxHeightScrollView cOUIComponentMaxHeightScrollView = this.mScrollViewComponent;
        if (arrayList != null && !arrayList.isEmpty()) {
            dimensionPixelOffset = cOUIComponentMaxHeightScrollView.getResources().getDimensionPixelOffset(Z8.c.f5987H);
        } else {
            dimensionPixelOffset = cOUIComponentMaxHeightScrollView.getResources().getDimensionPixelOffset(Z8.c.f5986G);
        }
        cOUIComponentMaxHeightScrollView.setPadding(cOUIComponentMaxHeightScrollView.getPaddingLeft(), dimensionPixelOffset, cOUIComponentMaxHeightScrollView.getPaddingRight(), cOUIComponentMaxHeightScrollView.getPaddingBottom());
        TextView textView = this.appStatement;
        if (arrayList != null && !arrayList.isEmpty()) {
            f10 = 12.0f;
        } else {
            f10 = 14.0f;
        }
        textView.setTextSize(f10);
        if (arrayList != null && !arrayList.isEmpty()) {
            dimensionPixelOffset2 = textView.getResources().getDimensionPixelOffset(Z8.c.f5985F);
        } else {
            dimensionPixelOffset2 = textView.getResources().getDimensionPixelOffset(Z8.c.f5984E);
        }
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), dimensionPixelOffset2);
    }

    public final CharSequence getBottomButtonText() {
        return this.bottomButtonText;
    }

    public final CharSequence getExitButtonText() {
        return this.exitButtonText;
    }

    public final OnButtonClickListener getOnButtonClickListener() {
        return this.onButtonClickListener;
    }

    public final CharSequence getStatement() {
        return this.statement;
    }

    public final CharSequence getTitleText() {
        return this.titleText;
    }

    @Override // com.coui.appcompat.panel.COUIBottomSheetDialog, com.google.android.material.bottomsheet.a, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Configuration configuration = getContext().getResources().getConfiguration();
        kotlin.jvm.internal.i.e(configuration, "context.resources.configuration");
        updateUI(configuration);
    }

    public final void setBottomButtonText(CharSequence charSequence) {
        this.bottomButtonText = charSequence;
        this.bottomButton.setText(charSequence);
        this.smallLandConfirmButton.setText(charSequence);
    }

    public final void setExitButtonText(CharSequence charSequence) {
        this.exitButtonText = charSequence;
        this.exitButton.setText(charSequence);
        this.smallLandExitButton.setText(charSequence);
    }

    public final void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public final void setStatement(CharSequence charSequence) {
        this.statement = charSequence;
        this.appStatement.setText(charSequence);
    }

    public final void setTitleText(CharSequence charSequence) {
        this.titleText = charSequence;
        this.titleView.setText(charSequence);
    }

    @Override // com.coui.appcompat.panel.COUIBottomSheetDialog
    public void updateLayoutWhileConfigChange(Configuration configuration) {
        kotlin.jvm.internal.i.f(configuration, "configuration");
        super.updateLayoutWhileConfigChange(configuration);
        updateUI(configuration);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIIndividualStatementDialog(Context context, int i10) {
        this(context, i10, 0.0f, 0.0f, 12, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIIndividualStatementDialog(Context context, int i10, float f10) {
        this(context, i10, f10, 0.0f, 8, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public final void setStatement(int i10) {
        setStatement(getContext().getString(i10));
    }

    public final void setTitleText(int i10) {
        setTitleText(getContext().getString(i10));
    }

    public /* synthetic */ COUIIndividualStatementDialog(Context context, int i10, float f10, float f11, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? C0576h.f12933c : i10, (i11 & 4) != 0 ? Float.MIN_VALUE : f10, (i11 & 8) != 0 ? Float.MIN_VALUE : f11);
    }

    public final void setBottomButtonText(int i10) {
        setBottomButtonText(getContext().getString(i10));
    }

    public final void setExitButtonText(int i10) {
        setExitButtonText(getContext().getString(i10));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIIndividualStatementDialog(Context context, int i10, float f10, float f11) {
        super(context, i10, f10, f11);
        kotlin.jvm.internal.i.f(context, "context");
        View inflate = LayoutInflater.from(context).inflate(Z8.f.f6175k, (ViewGroup) null);
        View findViewById = inflate.findViewById(Z8.e.f6083F0);
        kotlin.jvm.internal.i.e(findViewById, "findViewById(R.id.txt_statement)");
        this.appStatement = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(Z8.e.f6119g);
        kotlin.jvm.internal.i.e(findViewById2, "findViewById(R.id.btn_confirm)");
        this.bottomButton = (COUIButton) findViewById2;
        View findViewById3 = inflate.findViewById(Z8.e.f6134n0);
        kotlin.jvm.internal.i.e(findViewById3, "findViewById(R.id.scroll_text)");
        this.mScrollViewComponent = (COUIComponentMaxHeightScrollView) findViewById3;
        View findViewById4 = inflate.findViewById(Z8.e.f6103W);
        kotlin.jvm.internal.i.e(findViewById4, "findViewById(R.id.layout_scroll_text)");
        this.scrollViewLayout = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(Z8.e.f6079D0);
        kotlin.jvm.internal.i.e(findViewById5, "findViewById(R.id.txt_exit)");
        this.exitButton = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(Z8.e.f6087H0);
        kotlin.jvm.internal.i.e(findViewById6, "findViewById(R.id.txt_title)");
        this.titleView = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(Z8.e.f6144s0);
        kotlin.jvm.internal.i.e(findViewById7, "findViewById(R.id.small_land_button_layout)");
        this.smallLandButtonLayout = (LinearLayout) findViewById7;
        View findViewById8 = inflate.findViewById(Z8.e.f6140q0);
        kotlin.jvm.internal.i.e(findViewById8, "findViewById(R.id.small_land_btn_confirm)");
        this.smallLandConfirmButton = (COUIButton) findViewById8;
        View findViewById9 = inflate.findViewById(Z8.e.f6142r0);
        kotlin.jvm.internal.i.e(findViewById9, "findViewById(R.id.small_land_btn_exit)");
        this.smallLandExitButton = (COUIButton) findViewById9;
        setContentView(inflate);
        super.setCanceledOnTouchOutside(false);
        Configuration configuration = context.getResources().getConfiguration();
        kotlin.jvm.internal.i.e(configuration, "context.resources.configuration");
        this.isInSmallLand = isSmallScreen(configuration) && !COUIPanelMultiWindowUtils.isPortrait(context);
        Configuration configuration2 = context.getResources().getConfiguration();
        kotlin.jvm.internal.i.e(configuration2, "context.resources.configuration");
        this.isInSmallPortrait = isSmallScreen(configuration2) && COUIPanelMultiWindowUtils.isPortrait(context);
        getBehavior().setDraggable(false);
        Object parent = getDragableLinearLayout().getDragView().getParent();
        kotlin.jvm.internal.i.d(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setVisibility(8);
        initView();
    }
}
