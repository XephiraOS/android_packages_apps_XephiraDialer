package androidx.preference;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10536a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayAdapter f10537b;

    /* renamed from: c, reason: collision with root package name */
    public Spinner f10538c;

    /* renamed from: d, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f10539d;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f10631c);
    }

    public ArrayAdapter a() {
        return new ArrayAdapter(this.f10536a, R.layout.simple_spinner_dropdown_item);
    }

    public final int b(String str) {
        CharSequence[] entryValues = getEntryValues();
        if (str != null && entryValues != null) {
            for (int length = entryValues.length - 1; length >= 0; length--) {
                if (TextUtils.equals(entryValues[length].toString(), str)) {
                    return length;
                }
            }
            return -1;
        }
        return -1;
    }

    public final void c() {
        this.f10537b.clear();
        if (getEntries() != null) {
            for (CharSequence charSequence : getEntries()) {
                this.f10537b.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.f10537b;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        Spinner spinner = (Spinner) lVar.itemView.findViewById(o.f10646e);
        this.f10538c = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f10537b);
        this.f10538c.setOnItemSelectedListener(this.f10539d);
        this.f10538c.setSelection(b(getValue()));
        super.onBindViewHolder(lVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        this.f10538c.performClick();
    }

    @Override // androidx.preference.ListPreference
    public void setEntries(CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        c();
    }

    @Override // androidx.preference.ListPreference
    public void setValueIndex(int i10) {
        setValue(getEntryValues()[i10].toString());
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f10539d = new a();
        this.f10536a = context;
        this.f10537b = a();
        c();
    }

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (i10 >= 0) {
                String charSequence = DropDownPreference.this.getEntryValues()[i10].toString();
                if (!charSequence.equals(DropDownPreference.this.getValue()) && DropDownPreference.this.callChangeListener(charSequence)) {
                    DropDownPreference.this.setValue(charSequence);
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
