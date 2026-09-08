package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class d extends f {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragmentCompat.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.values";
    CharSequence[] mEntries;
    CharSequence[] mEntryValues;
    Set<String> mNewValues = new HashSet();
    boolean mPreferenceChanged;

    /* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i10, boolean z10) {
            if (z10) {
                d dVar = d.this;
                dVar.mPreferenceChanged |= dVar.mNewValues.add(dVar.mEntryValues[i10].toString());
            } else {
                d dVar2 = d.this;
                dVar2.mPreferenceChanged |= dVar2.mNewValues.remove(dVar2.mEntryValues[i10].toString());
            }
        }
    }

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    public static d newInstance(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.getEntries() != null && listPreference.getEntryValues() != null) {
                this.mNewValues.clear();
                this.mNewValues.addAll(listPreference.getValues());
                this.mPreferenceChanged = false;
                this.mEntries = listPreference.getEntries();
                this.mEntryValues = listPreference.getEntryValues();
                return;
            }
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.mNewValues.clear();
        this.mNewValues.addAll(bundle.getStringArrayList(SAVE_STATE_VALUES));
        this.mPreferenceChanged = bundle.getBoolean(SAVE_STATE_CHANGED, false);
        this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    @Override // androidx.preference.f
    public void onDialogClosed(boolean z10) {
        if (z10 && this.mPreferenceChanged) {
            MultiSelectListPreference listPreference = getListPreference();
            if (listPreference.callChangeListener(this.mNewValues)) {
                listPreference.setValues(this.mNewValues);
            }
        }
        this.mPreferenceChanged = false;
    }

    @Override // androidx.preference.f
    public void onPrepareDialogBuilder(b.a aVar) {
        super.onPrepareDialogBuilder(aVar);
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = this.mNewValues.contains(this.mEntryValues[i10].toString());
        }
        aVar.setMultiChoiceItems(this.mEntries, zArr, new a());
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList<>(this.mNewValues));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.mPreferenceChanged);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }
}
