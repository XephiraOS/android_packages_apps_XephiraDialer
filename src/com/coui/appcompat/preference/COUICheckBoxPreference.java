package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import b9.C0532b;
import b9.C0535e;
import b9.k;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import kotlin.jvm.internal.i;

/* compiled from: COUICheckBoxPreference.kt */
/* loaded from: classes.dex */
public final class COUICheckBoxPreference extends CheckBoxPreference implements COUIRecyclerView.b {
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private COUICheckBox mCheckBox;
    private Context mContext;
    private int mDividerDefaultHorizontalPadding;
    private View mItemView;
    private TextView mTitleView;

    public COUICheckBoxPreference(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
            return false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.mItemView instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int positionInGroup = COUICardListHelper.getPositionInGroup(this);
        if (positionInGroup != 1 && positionInGroup != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public /* bridge */ /* synthetic */ View getDividerEndAlignView() {
        return super.getDividerEndAlignView();
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.mTitleView;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        View view;
        View view2;
        TextView textView;
        View view3;
        View view4;
        int i10;
        super.onBindViewHolder(lVar);
        COUICheckBox cOUICheckBox = null;
        if (lVar != null) {
            view = lVar.itemView;
        } else {
            view = null;
        }
        this.mItemView = view;
        if (lVar != null) {
            view2 = lVar.e(R.id.title);
        } else {
            view2 = null;
        }
        if (view2 instanceof TextView) {
            textView = (TextView) view2;
        } else {
            textView = null;
        }
        this.mTitleView = textView;
        if (lVar != null) {
            view3 = lVar.e(R.id.checkbox);
        } else {
            view3 = null;
        }
        if (view3 instanceof COUICheckBox) {
            cOUICheckBox = (COUICheckBox) view3;
        }
        this.mCheckBox = cOUICheckBox;
        if (cOUICheckBox != null) {
            if (this.mChecked) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            cOUICheckBox.setState(i10);
        }
        if (lVar != null && (view4 = lVar.itemView) != null) {
            view4.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view5, MotionEvent motionEvent) {
                    boolean onBindViewHolder$lambda$0;
                    onBindViewHolder$lambda$0 = COUICheckBoxPreference.onBindViewHolder$lambda$0(view5, motionEvent);
                    return onBindViewHolder$lambda$0;
                }
            });
        }
        COUIPreferenceUtils.bindAssignmentView(lVar, this.mAssignment, this.mAssignmentColor);
        i.c(lVar);
        COUICardListHelper.setItemCardBackground(lVar.itemView, COUICardListHelper.getPositionInGroup(this));
    }

    public final void setAssignment(CharSequence assignment) {
        i.f(assignment, "assignment");
        if (!TextUtils.equals(this.mAssignment, assignment)) {
            this.mAssignment = assignment;
            notifyChanged();
        }
    }

    public final void setAssignmentColor(int i10) {
        if (this.mAssignmentColor != i10) {
            this.mAssignmentColor = i10;
            notifyChanged();
        }
    }

    public COUICheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12344c);
    }

    public COUICheckBoxPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12525c);
    }

    public COUICheckBoxPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mContext = context;
        this.mDividerDefaultHorizontalPadding = getContext().getResources().getDimensionPixelSize(C0535e.f12370B);
        i.c(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12614f0, i10, i11);
        this.mAssignmentColor = obtainStyledAttributes.getInt(b9.l.f12623i0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b9.l.f12655t, i10, i11);
        this.mAssignment = obtainStyledAttributes2.getText(b9.l.f12658u);
        obtainStyledAttributes2.recycle();
    }
}
