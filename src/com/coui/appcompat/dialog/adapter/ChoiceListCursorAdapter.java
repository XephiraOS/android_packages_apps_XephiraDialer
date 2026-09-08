package com.coui.appcompat.dialog.adapter;

import X8.h;
import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cursoradapter.widget.a;
import com.coui.appcompat.checkbox.COUICheckBox;
import java.util.HashSet;

/* loaded from: classes.dex */
public class ChoiceListCursorAdapter extends a {
    private HashSet<Integer> mCheckBoxStates;
    private String mIsCheckedColumn;
    private int mIsCheckedIndex;
    private boolean mIsMultiChoice;
    private String mLabelColumn;
    private int mLabelIndex;
    private int mLayoutResId;
    private String mSummaryColumn;
    private int mSummaryIndex;

    public ChoiceListCursorAdapter(Context context, Cursor cursor, int i10, String str, String str2) {
        this(context, cursor, i10, str, null, str2, false);
    }

    @Override // androidx.cursoradapter.widget.a
    public void bindView(View view, Context context, Cursor cursor) {
        int i10;
        TextView textView = (TextView) view.findViewById(R.id.text1);
        TextView textView2 = (TextView) view.findViewById(h.f4955w0);
        if (this.mCheckBoxStates.contains(Integer.valueOf(cursor.getPosition()))) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        if (this.mIsMultiChoice) {
            ((COUICheckBox) view.findViewById(h.f4940p)).setState(i10);
        }
        textView.setText(cursor.getString(this.mLabelIndex));
        if (this.mSummaryColumn == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(cursor.getString(this.mSummaryIndex));
        }
    }

    @Override // androidx.cursoradapter.widget.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.mLayoutResId, viewGroup, false);
    }

    public void setCheckboxState(int i10, int i11, ListView listView) {
        int firstVisiblePosition = i11 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((COUICheckBox) listView.getChildAt(firstVisiblePosition).findViewById(h.f4940p)).setState(i10);
            if (i10 == 2) {
                this.mCheckBoxStates.add(Integer.valueOf(i11));
            } else {
                this.mCheckBoxStates.remove(Integer.valueOf(i11));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
    
        if (r2.moveToNext() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        r2.moveToFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0034, code lost:
    
        if (r2.moveToFirst() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        if (r2.getInt(r0.mIsCheckedIndex) != 1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        r0.mCheckBoxStates.add(java.lang.Integer.valueOf(r2.getPosition()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChoiceListCursorAdapter(android.content.Context r1, android.database.Cursor r2, int r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.mIsMultiChoice = r7
            r0.mLabelColumn = r4
            r0.mSummaryColumn = r6
            r0.mIsCheckedColumn = r5
            r0.mLayoutResId = r3
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r0.mCheckBoxStates = r1
            java.lang.String r1 = r0.mLabelColumn
            int r1 = r2.getColumnIndexOrThrow(r1)
            r0.mLabelIndex = r1
            java.lang.String r1 = r0.mSummaryColumn
            if (r1 == 0) goto L26
            int r1 = r2.getColumnIndexOrThrow(r1)
            r0.mSummaryIndex = r1
        L26:
            if (r7 == 0) goto L55
            java.lang.String r1 = r0.mIsCheckedColumn
            int r1 = r2.getColumnIndexOrThrow(r1)
            r0.mIsCheckedIndex = r1
            boolean r1 = r2.moveToFirst()
            if (r1 == 0) goto L52
        L36:
            int r1 = r0.mIsCheckedIndex
            int r1 = r2.getInt(r1)
            r3 = 1
            if (r1 != r3) goto L4c
            java.util.HashSet<java.lang.Integer> r1 = r0.mCheckBoxStates
            int r3 = r2.getPosition()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.add(r3)
        L4c:
            boolean r1 = r2.moveToNext()
            if (r1 != 0) goto L36
        L52:
            r2.moveToFirst()
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.dialog.adapter.ChoiceListCursorAdapter.<init>(android.content.Context, android.database.Cursor, int, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public ChoiceListCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.mIsMultiChoice = false;
        this.mIsCheckedIndex = 0;
    }
}
