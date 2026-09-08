package com.coui.appcompat.preference;

import X8.c;
import X8.f;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.preference.l;
import androidx.preference.s;
import b9.C0532b;
import b9.C0537g;
import b9.k;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.edittext.COUIInputView;
import com.coui.appcompat.edittext.COUIScrolledEditText;

/* loaded from: classes.dex */
public class COUIInputPreference extends COUIPreference {
    private CharSequence mContent;
    private COUIEditText mEditText;
    private COUICardListItemInputView mInputView;
    private View mPreferenceView;
    private CharSequence mTitle;

    /* loaded from: classes.dex */
    public static class COUICardListItemInputView extends COUIInputView {
        boolean mJustShowFocusLine;

        public COUICardListItemInputView(Context context) {
            this(context, null);
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        public int getEdittextPaddingBottom() {
            int dimension = (int) getResources().getDimension(f.f4638Z1);
            if (!TextUtils.isEmpty(this.mTitle)) {
                return getResources().getDimensionPixelSize(f.f4617W1);
            }
            return dimension;
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        public int getEdittextPaddingTop() {
            int dimension = (int) getResources().getDimension(f.f4654b2);
            if (!TextUtils.isEmpty(this.mTitle)) {
                return getResources().getDimensionPixelSize(f.f4624X1);
            }
            return dimension;
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        public COUIEditText instanceCOUIEditText(Context context, AttributeSet attributeSet) {
            COUIScrolledEditText cOUIScrolledEditText = new COUIScrolledEditText(context, attributeSet, c.f4359R);
            cOUIScrolledEditText.setShowDeleteIcon(false);
            cOUIScrolledEditText.setVerticalScrollBarEnabled(false);
            return cOUIScrolledEditText;
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        public boolean isIsCardSingleInput() {
            return true;
        }

        public void setJustShowFocusLine(boolean z10) {
            if (this.mJustShowFocusLine != z10) {
                this.mJustShowFocusLine = z10;
                COUIEditText cOUIEditText = this.mEditText;
                if (cOUIEditText != null) {
                    cOUIEditText.setJustShowFocusLine(z10);
                }
            }
        }

        public COUICardListItemInputView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public COUICardListItemInputView(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.mJustShowFocusLine = false;
        }
    }

    public COUIInputPreference(Context context) {
        this(context, null);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (this.mEditText.isErrorState()) {
            return false;
        }
        return super.drawDivider();
    }

    public CharSequence getContent() {
        COUIEditText cOUIEditText = this.mEditText;
        if (cOUIEditText != null) {
            return cOUIEditText.getCouiEditTexttNoEllipsisText();
        }
        return this.mContent;
    }

    public COUIEditText getEditText() {
        return this.mEditText;
    }

    public CharSequence getHint() {
        return this.mInputView.getHint();
    }

    public COUIInputView getInputView() {
        return this.mInputView;
    }

    public View getPreferenceView() {
        return this.mPreferenceView;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        View view = lVar.itemView;
        this.mPreferenceView = view;
        if (view instanceof COUICardListSelectedItemLayout) {
            ((COUICardListSelectedItemLayout) view).consumeDispatchingEventForState(true);
        }
        ViewGroup viewGroup = (ViewGroup) this.mPreferenceView.findViewById(C0537g.f12493v);
        if (viewGroup != null) {
            if (!this.mInputView.equals((COUICardListItemInputView) viewGroup.findViewById(R.id.input))) {
                ViewParent parent = this.mInputView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.mInputView);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.mInputView, -1, -2);
                int positionInGroup = COUICardListHelper.getPositionInGroup(this);
                if (positionInGroup == 3 || positionInGroup == 4) {
                    this.mInputView.getEditText().setBoxBackgroundMode(3);
                }
            }
        }
        this.mInputView.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setContent(savedState.mText);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        CharSequence charSequence = this.mContent;
        if (charSequence != null) {
            savedState.mText = charSequence.toString();
        }
        return savedState;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(boolean z10, Object obj) {
        String str;
        if (TextUtils.isEmpty(this.mContent)) {
            return;
        }
        if (z10) {
            str = getPersistedString(this.mContent.toString());
        } else {
            str = (String) obj;
        }
        setContent(str);
    }

    public void setContent(CharSequence charSequence) {
        COUIEditText cOUIEditText = this.mEditText;
        if (cOUIEditText != null) {
            cOUIEditText.setCouiEditTexttNoEllipsisText((String) charSequence);
            this.mContent = charSequence;
            return;
        }
        if (!TextUtils.equals(this.mContent, charSequence)) {
            notifyChanged();
        }
        boolean shouldDisableDependents = shouldDisableDependents();
        this.mContent = charSequence;
        if (charSequence != null) {
            persistString(charSequence.toString());
        }
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
    }

    public void setHint(CharSequence charSequence) {
        CharSequence hint = getHint();
        if ((charSequence == null && hint != null) || (charSequence != null && !charSequence.equals(hint))) {
            this.mInputView.setHint(charSequence);
            notifyChanged();
        }
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        if (!TextUtils.isEmpty(this.mContent) && !super.shouldDisableDependents()) {
            return false;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.preference.COUIInputPreference.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        String mText;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.mText);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12346e);
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12527e);
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12557G, i10, i11);
        this.mContent = obtainStyledAttributes.getText(b9.l.f12560H);
        boolean z10 = obtainStyledAttributes.getBoolean(b9.l.f12562I, true);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.f10676J, i10, i11);
        this.mTitle = obtainStyledAttributes2.getText(s.f10686O);
        obtainStyledAttributes2.recycle();
        COUICardListItemInputView cOUICardListItemInputView = new COUICardListItemInputView(context, attributeSet);
        this.mInputView = cOUICardListItemInputView;
        cOUICardListItemInputView.setId(R.id.input);
        this.mInputView.setTitle(this.mTitle);
        this.mEditText = this.mInputView.getEditText();
        this.mInputView.setJustShowFocusLine(z10);
    }
}
