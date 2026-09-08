package com.coui.appcompat.panel;

import X8.j;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.COUIPanelPreferenceLinearLayoutManager;
import androidx.recyclerview.widget.COUIRecyclerView;
import c9.C0574f;
import c9.C0575g;
import c9.C0576h;
import com.coui.appcompat.panel.COUIBottomSheetChoiceListAdapter;
import com.coui.appcompat.toolbar.COUIToolbar;

/* loaded from: classes.dex */
public class COUIListBottomSheetDialog {
    private COUIBottomSheetDialog mBottomSheetDialog;

    /* loaded from: classes.dex */
    public static class Builder extends b.a {
        private View.OnClickListener mCenterButtonClickListener;
        private String mCenterButtonText;
        public int mCheckedItem;
        public boolean[] mCheckedItems;
        private Context mContext;
        private int mFinalNavColorAfterDismiss;
        private boolean mIsExecuteNavColorAnimAfterDismiss;
        private boolean mIsMultiChoice;
        private CharSequence[] mItems;
        private View mLayout;
        private View.OnClickListener mLeftButtonClickListener;
        private String mLeftButtonText;
        private COUIListBottomSheetDialog mListBottomSheetDialog;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public OnMenuItemClickListener mOnMenuItemClick;
        public DialogInterface.OnClickListener mOnRadioButtonClickListener;
        private View.OnClickListener mRightButtonClickListener;
        private String mRightButtonText;
        private CharSequence[] mSummaries;
        private CharSequence mTitle;

        public Builder(Context context) {
            super(context);
            this.mCheckedItem = -1;
            this.mListBottomSheetDialog = new COUIListBottomSheetDialog();
            this.mIsMultiChoice = false;
            init(context);
        }

        private void init(Context context) {
            this.mContext = context;
            this.mLayout = LayoutInflater.from(context).inflate(C0575g.f12927c, (ViewGroup) null);
        }

        public COUIListBottomSheetDialog createDialog() {
            COUIBottomSheetChoiceListAdapter cOUIBottomSheetChoiceListAdapter;
            this.mListBottomSheetDialog.mBottomSheetDialog = new COUIBottomSheetDialog(this.mContext, C0576h.f12933c);
            this.mListBottomSheetDialog.mBottomSheetDialog.setContentView(this.mLayout);
            this.mListBottomSheetDialog.mBottomSheetDialog.setExecuteNavColorAnimAfterDismiss(this.mIsExecuteNavColorAnimAfterDismiss);
            this.mListBottomSheetDialog.mBottomSheetDialog.setFinalNavColorAfterDismiss(this.mFinalNavColorAfterDismiss);
            COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) this.mListBottomSheetDialog.mBottomSheetDialog.findViewById(C0574f.f12920n);
            COUIPanelPreferenceLinearLayoutManager cOUIPanelPreferenceLinearLayoutManager = new COUIPanelPreferenceLinearLayoutManager(this.mContext);
            cOUIPanelPreferenceLinearLayoutManager.setOrientation(1);
            cOUIRecyclerView.setLayoutManager(cOUIPanelPreferenceLinearLayoutManager);
            cOUIRecyclerView.setItemAnimator(null);
            COUIToolbar cOUIToolbar = (COUIToolbar) this.mListBottomSheetDialog.mBottomSheetDialog.findViewById(C0574f.f12922p);
            cOUIToolbar.setTitle(this.mTitle);
            cOUIToolbar.setIsTitleCenterStyle(true);
            if (this.mIsMultiChoice) {
                ((LinearLayout.LayoutParams) cOUIRecyclerView.getLayoutParams()).bottomMargin = 0;
                cOUIBottomSheetChoiceListAdapter = new COUIBottomSheetChoiceListAdapter(this.mContext, j.f4983n, this.mItems, this.mSummaries, -1, this.mCheckedItems, true);
            } else {
                cOUIBottomSheetChoiceListAdapter = new COUIBottomSheetChoiceListAdapter(this.mContext, j.f4984o, this.mItems, this.mSummaries, this.mCheckedItem);
            }
            this.mListBottomSheetDialog.mBottomSheetDialog.getDragableLinearLayout().getDragView().setVisibility(4);
            cOUIRecyclerView.setAdapter(cOUIBottomSheetChoiceListAdapter);
            cOUIBottomSheetChoiceListAdapter.setOnItemClickListener(new COUIBottomSheetChoiceListAdapter.OnItemClickListener() { // from class: com.coui.appcompat.panel.COUIListBottomSheetDialog.Builder.1
                @Override // com.coui.appcompat.panel.COUIBottomSheetChoiceListAdapter.OnItemClickListener
                public void onItemClick(View view, int i10, int i11) {
                    boolean z10;
                    if (Builder.this.mIsMultiChoice) {
                        Builder builder = Builder.this;
                        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = builder.mOnCheckboxClickListener;
                        if (onMultiChoiceClickListener != null) {
                            COUIBottomSheetDialog cOUIBottomSheetDialog = builder.mListBottomSheetDialog.mBottomSheetDialog;
                            if (i11 == 2) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            onMultiChoiceClickListener.onClick(cOUIBottomSheetDialog, i10, z10);
                            return;
                        }
                        return;
                    }
                    Builder builder2 = Builder.this;
                    DialogInterface.OnClickListener onClickListener = builder2.mOnRadioButtonClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(builder2.mListBottomSheetDialog.mBottomSheetDialog, i10);
                    }
                }
            });
            return this.mListBottomSheetDialog;
        }

        public Dialog getBottomSheetDialog() {
            return this.mListBottomSheetDialog.mBottomSheetDialog;
        }

        public Builder setCenterButton(String str, View.OnClickListener onClickListener) {
            this.mCenterButtonText = str;
            this.mCenterButtonClickListener = onClickListener;
            return this;
        }

        public Builder setExecuteNavColorAnimAfterDismiss(boolean z10) {
            this.mIsExecuteNavColorAnimAfterDismiss = z10;
            return this;
        }

        public Builder setFinalNavColorAfterDismiss(int i10) {
            this.mFinalNavColorAfterDismiss = i10;
            return this;
        }

        public Builder setLeftButton(String str, View.OnClickListener onClickListener) {
            this.mLeftButtonText = str;
            this.mLeftButtonClickListener = onClickListener;
            return this;
        }

        @Deprecated
        public Builder setMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
            this.mOnMenuItemClick = onMenuItemClickListener;
            return this;
        }

        public Builder setRightButton(String str, View.OnClickListener onClickListener) {
            this.mRightButtonText = str;
            this.mRightButtonClickListener = onClickListener;
            return this;
        }

        public Builder setSummaries(int i10) {
            this.mSummaries = this.mContext.getResources().getTextArray(i10);
            return this;
        }

        public Builder setSummaries(CharSequence[] charSequenceArr) {
            this.mSummaries = charSequenceArr;
            return this;
        }

        @Override // androidx.appcompat.app.b.a
        public Builder setMultiChoiceItems(int i10, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.mItems = this.mContext.getResources().getTextArray(i10);
            this.mCheckedItems = zArr;
            this.mIsMultiChoice = true;
            this.mOnCheckboxClickListener = onMultiChoiceClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b.a
        public Builder setSingleChoiceItems(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            this.mItems = this.mContext.getResources().getTextArray(i10);
            this.mOnRadioButtonClickListener = onClickListener;
            this.mCheckedItem = i11;
            this.mIsMultiChoice = false;
            return this;
        }

        @Override // androidx.appcompat.app.b.a
        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        @Override // androidx.appcompat.app.b.a
        public Builder setTitle(int i10) {
            this.mTitle = this.mContext.getString(i10);
            return this;
        }

        public Builder(Context context, int i10) {
            super(context, i10);
            this.mCheckedItem = -1;
            this.mListBottomSheetDialog = new COUIListBottomSheetDialog();
            this.mIsMultiChoice = false;
            init(new ContextThemeWrapper(context, i10));
        }

        @Override // androidx.appcompat.app.b.a
        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.mItems = charSequenceArr;
            this.mCheckedItems = zArr;
            this.mIsMultiChoice = true;
            this.mOnCheckboxClickListener = onMultiChoiceClickListener;
            return this;
        }

        @Override // androidx.appcompat.app.b.a
        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            this.mItems = charSequenceArr;
            this.mOnRadioButtonClickListener = onClickListener;
            this.mCheckedItem = i10;
            this.mIsMultiChoice = false;
            return this;
        }

        public Builder setMultiChoiceItems(int i10, boolean[] zArr, int i11, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.mItems = this.mContext.getResources().getTextArray(i10);
            this.mCheckedItems = zArr;
            this.mIsMultiChoice = true;
            this.mSummaries = this.mContext.getResources().getTextArray(i11);
            this.mOnCheckboxClickListener = onMultiChoiceClickListener;
            return this;
        }

        public Builder setSingleChoiceItems(int i10, int i11, int i12, DialogInterface.OnClickListener onClickListener) {
            this.mItems = this.mContext.getResources().getTextArray(i10);
            this.mOnRadioButtonClickListener = onClickListener;
            this.mCheckedItem = i11;
            this.mIsMultiChoice = false;
            this.mSummaries = this.mContext.getResources().getTextArray(i12);
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, CharSequence[] charSequenceArr2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.mItems = charSequenceArr;
            this.mCheckedItems = zArr;
            this.mIsMultiChoice = true;
            this.mSummaries = charSequenceArr2;
            this.mOnCheckboxClickListener = onMultiChoiceClickListener;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i10, CharSequence[] charSequenceArr2, DialogInterface.OnClickListener onClickListener) {
            this.mItems = charSequenceArr;
            this.mOnRadioButtonClickListener = onClickListener;
            this.mCheckedItem = i10;
            this.mIsMultiChoice = false;
            this.mSummaries = charSequenceArr2;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        void onCancelItemClick();

        void onSaveItemClick();
    }

    public void dismiss() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss();
        }
    }

    public boolean isShowing() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            return cOUIBottomSheetDialog.isShowing();
        }
        return false;
    }

    public void refresh() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.refresh();
        }
    }

    public void show() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.show();
        }
    }
}
