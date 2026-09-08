package com.android.contacts.editor;

import X0.b;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.oplus.dialer.R;
import h1.C1074c;

/* loaded from: classes.dex */
public class CustomizeTextFieldsEditorView extends x {

    /* renamed from: l, reason: collision with root package name */
    public COUIEditText[] f15214l;

    /* renamed from: m, reason: collision with root package name */
    public ViewGroup f15215m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15216n;

    /* renamed from: o, reason: collision with root package name */
    public LayoutInflater f15217o;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f15218a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f15219b;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15219b.length);
            parcel.writeIntArray(this.f15219b);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            int[] iArr = new int[parcel.readInt()];
            this.f15219b = iArr;
            parcel.readIntArray(iArr);
        }
    }

    public CustomizeTextFieldsEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15214l = null;
        this.f15215m = null;
        this.f15216n = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(COUIEditText cOUIEditText, View view, boolean z10) {
        s(cOUIEditText);
    }

    private void s(COUIEditText cOUIEditText) {
        String str;
        String str2 = (String) cOUIEditText.getTag(X0.b.f4269s);
        if (str2 != null) {
            for (b.a aVar : getOnFieldContentEditListeners()) {
                boolean hasFocus = cOUIEditText.hasFocus();
                if (cOUIEditText.getText() != null) {
                    str = cOUIEditText.getText().toString();
                } else {
                    str = null;
                }
                aVar.onFocusStateChanged(str2, hasFocus, str);
            }
        }
    }

    @Override // com.android.contacts.editor.x, X0.b
    public void b(b.a aVar) {
        COUIEditText[] cOUIEditTextArr;
        super.b(aVar);
        if (!getOnFieldContentEditListeners().isEmpty() && (cOUIEditTextArr = this.f15214l) != null) {
            for (COUIEditText cOUIEditText : cOUIEditTextArr) {
                s(cOUIEditText);
            }
        }
    }

    @Override // com.android.contacts.editor.A
    public void c() {
        COUIEditText[] cOUIEditTextArr = this.f15214l;
        if (cOUIEditTextArr != null) {
            for (COUIEditText cOUIEditText : cOUIEditTextArr) {
                cOUIEditText.setText("");
            }
        }
    }

    @Override // X0.b
    public void e(String str, String str2) {
        for (COUIEditText cOUIEditText : this.f15214l) {
            if (str.equals(cOUIEditText.getTag(X0.b.f4269s))) {
                cOUIEditText.setText(str2);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v24 */
    @Override // com.android.contacts.editor.x, com.android.contacts.editor.A
    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        boolean z11;
        boolean z12;
        boolean z13;
        super.g(cVar, valuesDelta, entityDelta, z10, viewIdGenerator);
        COUIEditText[] cOUIEditTextArr = this.f15214l;
        ?? r42 = 0;
        if (cOUIEditTextArr != null) {
            for (COUIEditText cOUIEditText : cOUIEditTextArr) {
                this.f15215m.removeView(cOUIEditText);
            }
        }
        int size = cVar.f17018q.size();
        this.f15214l = new COUIEditText[size];
        int i10 = 0;
        boolean z14 = false;
        while (i10 < size) {
            AccountType.b bVar = cVar.f17018q.get(i10);
            COUIEditText cOUIEditText2 = new COUIEditText(getContext());
            cOUIEditText2.setIsEllipsisEnabled(r42);
            cOUIEditText2.setTextAlignment(5);
            cOUIEditText2.setTextAppearance(R.style.ContactEditorEditTextStyle);
            cOUIEditText2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            View view = null;
            if ("vnd.android.cursor.item/organization".equals(cVar.f17004c)) {
                cOUIEditText2.setMinimumHeight(this.f15496b);
                cOUIEditText2.setBackground(null);
                if (i10 == 0) {
                    view = this.f15217o.inflate(R.layout.edittext_underline, this.f15215m, (boolean) r42);
                }
            } else {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.DP_12);
                cOUIEditText2.setPadding(dimensionPixelSize, r42, dimensionPixelSize, r42);
            }
            int i11 = bVar.f16956d;
            if (i11 != 0) {
                cOUIEditText2.setMinLines(i11);
            }
            cOUIEditText2.setGravity(16);
            this.f15214l[i10] = cOUIEditText2;
            cOUIEditText2.setId(viewIdGenerator.d(entityDelta, cVar, valuesDelta, i10));
            int i12 = bVar.f16954b;
            if (i12 > 0) {
                cOUIEditText2.setHint(i12);
            }
            int i13 = bVar.f16955c;
            cOUIEditText2.setInputType(i13);
            if (i13 == 3) {
                cOUIEditText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            } else if ("vnd.android.cursor.item/organization".equals(cVar.f17004c)) {
                cOUIEditText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
            } else {
                cOUIEditText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
            }
            if (i13 == 3) {
                cOUIEditText2.setTextDirection(3);
                C1074c.d(getContext(), cOUIEditText2);
            }
            cOUIEditText2.setImeOptions(5);
            String str = bVar.f16953a;
            String z15 = valuesDelta.z(str);
            cOUIEditText2.setText(z15);
            cOUIEditText2.setTag(X0.b.f4269s, str);
            boolean z16 = true;
            if (z15 != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            setDeleteButtonVisible(z11);
            cOUIEditText2.addTextChangedListener(new a(str));
            if (isEnabled() && !z10) {
                z12 = true;
            } else {
                z12 = false;
            }
            cOUIEditText2.setEnabled(z12);
            int i14 = 8;
            if (bVar.f16958f) {
                if (this.f15216n) {
                    i14 = 0;
                }
                cOUIEditText2.setVisibility(i14);
            } else if (bVar.f16959g) {
                if (!this.f15216n) {
                    i14 = 0;
                }
                cOUIEditText2.setVisibility(i14);
            } else {
                if (!U7.f.c(z15) && bVar.f16957e) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!this.f15216n || !z13) {
                    i14 = 0;
                }
                cOUIEditText2.setVisibility(i14);
                if (!z14 && !z13) {
                    z16 = false;
                }
            }
            z14 = z16;
            this.f15215m.addView(cOUIEditText2);
            if (view != null) {
                this.f15215m.addView(view);
            }
            i10++;
            r42 = 0;
        }
        t(z14, this.f15216n);
        for (final COUIEditText cOUIEditText3 : this.f15214l) {
            if (cOUIEditText3.getOnFocusChangeListener() == null && cOUIEditText3.getTag(X0.b.f4269s) != null) {
                cOUIEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.android.contacts.editor.y
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view2, boolean z17) {
                        CustomizeTextFieldsEditorView.this.r(cOUIEditText3, view2, z17);
                    }
                });
            }
        }
    }

    public COUIEditText getEditText() {
        COUIEditText[] cOUIEditTextArr = this.f15214l;
        if (cOUIEditTextArr != null && cOUIEditTextArr.length > 0) {
            return cOUIEditTextArr[0];
        }
        return null;
    }

    public COUIEditText getPositionEditText() {
        COUIEditText[] cOUIEditTextArr = this.f15214l;
        if (cOUIEditTextArr != null && cOUIEditTextArr.length > 1) {
            return cOUIEditTextArr[1];
        }
        return null;
    }

    @Override // com.android.contacts.editor.A
    public boolean isEmpty() {
        for (int i10 = 0; i10 < this.f15215m.getChildCount(); i10++) {
            View childAt = this.f15215m.getChildAt(i10);
            if (childAt instanceof COUIEditText) {
                if (!TextUtils.isEmpty(((COUIEditText) childAt).getText())) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        this.f15215m = (ViewGroup) findViewById(R.id.editors);
        this.f15217o = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15216n = savedState.f15218a;
        int min = Math.min(this.f15214l.length, savedState.f15219b.length);
        for (int i10 = 0; i10 < min; i10++) {
            this.f15214l[i10].setVisibility(savedState.f15219b[i10]);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        int length;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15218a = this.f15216n;
        COUIEditText[] cOUIEditTextArr = this.f15214l;
        if (cOUIEditTextArr == null) {
            length = 0;
        } else {
            length = cOUIEditTextArr.length;
        }
        savedState.f15219b = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            savedState.f15219b[i10] = this.f15214l[i10].getVisibility();
        }
        return savedState;
    }

    @Override // com.android.contacts.editor.x, android.view.View
    public void setEnabled(boolean z10) {
        boolean z11;
        super.setEnabled(z10);
        if (this.f15214l != null) {
            int i10 = 0;
            while (true) {
                COUIEditText[] cOUIEditTextArr = this.f15214l;
                if (i10 < cOUIEditTextArr.length) {
                    COUIEditText cOUIEditText = cOUIEditTextArr[i10];
                    if (!k() && z10) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    cOUIEditText.setEnabled(z11);
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    private void t(boolean z10, boolean z11) {
    }

    /* loaded from: classes.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15220a;

        public a(String str) {
            this.f15220a = str;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CustomizeTextFieldsEditorView.this.m(this.f15220a, editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
