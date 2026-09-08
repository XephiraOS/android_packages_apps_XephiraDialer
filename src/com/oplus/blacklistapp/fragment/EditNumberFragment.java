package com.oplus.blacklistapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.preference.COUIInputPreference;
import com.coui.appcompat.preference.COUIMenuPreference;
import com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment;
import com.oplus.blacklistapp.u;
import com.oplus.blacklistapp.w;
import com.oplus.widget.BlacklistBigButtonPreference;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: EditNumberFragment.kt */
/* loaded from: classes3.dex */
public final class EditNumberFragment extends COUIPreferenceWithAppbarFragment {

    /* renamed from: g, reason: collision with root package name */
    public static final a f27091g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIInputPreference f27092a;

    /* renamed from: b, reason: collision with root package name */
    public COUIInputPreference f27093b;

    /* renamed from: c, reason: collision with root package name */
    public COUIMenuPreference f27094c;

    /* renamed from: d, reason: collision with root package name */
    public int f27095d = 1;

    /* renamed from: e, reason: collision with root package name */
    public String f27096e;

    /* renamed from: f, reason: collision with root package name */
    public BlacklistBigButtonPreference f27097f;

    /* compiled from: EditNumberFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final boolean j1(EditNumberFragment this$0, Ref$IntRef entries, Preference preference, Object obj) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(entries, "$entries");
        if ((preference instanceof COUIMenuPreference) && (obj instanceof String)) {
            ((COUIMenuPreference) preference).setAssignment(this$0.getResources().getStringArray(entries.element)[Integer.parseInt((String) obj)]);
            return true;
        }
        return true;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        String string;
        if (this.f27096e == null) {
            Context context = getContext();
            if (context == null || (string = context.getString(u.f27564S0)) == null) {
                return "";
            }
        } else {
            Context context2 = getContext();
            if (context2 == null || (string = context2.getString(u.f27588Y0)) == null) {
                return "";
            }
        }
        return string;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        BlacklistBigButtonPreference blacklistBigButtonPreference = this.f27097f;
        if (blacklistBigButtonPreference != null) {
            blacklistBigButtonPreference.c(newConfig);
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i10;
        String str;
        COUIEditText cOUIEditText;
        String str2;
        COUIEditText cOUIEditText2;
        int i11;
        CharSequence content;
        COUIInputPreference cOUIInputPreference;
        COUIEditText editText;
        COUIEditText editText2;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        boolean z10 = true;
        if (activity != null && (intent4 = activity.getIntent()) != null) {
            i10 = intent4.getIntExtra("blacklist_mode", 1);
        } else {
            i10 = 1;
        }
        this.f27095d = i10;
        addPreferencesFromResource(w.f27738d);
        this.f27092a = (COUIInputPreference) findPreference("edit_number");
        FragmentActivity activity2 = getActivity();
        COUIEditText cOUIEditText3 = null;
        if (activity2 != null && (intent3 = activity2.getIntent()) != null) {
            str = intent3.getStringExtra("edit_number");
        } else {
            str = null;
        }
        this.f27096e = str;
        COUIInputPreference cOUIInputPreference2 = this.f27092a;
        if (cOUIInputPreference2 != null) {
            cOUIInputPreference2.setContent(str);
        }
        COUIInputPreference cOUIInputPreference3 = this.f27092a;
        if (cOUIInputPreference3 != null) {
            cOUIInputPreference3.setHint(getString(u.f27662n1));
        }
        COUIInputPreference cOUIInputPreference4 = this.f27092a;
        if (cOUIInputPreference4 != null) {
            cOUIEditText = cOUIInputPreference4.getEditText();
        } else {
            cOUIEditText = null;
        }
        if (cOUIEditText != null) {
            cOUIEditText.setInputType(3);
        }
        this.f27093b = (COUIInputPreference) findPreference("edit_note");
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
            str2 = intent2.getStringExtra("edit_note");
        } else {
            str2 = null;
        }
        COUIInputPreference cOUIInputPreference5 = this.f27093b;
        if (cOUIInputPreference5 != null) {
            cOUIInputPreference5.setContent(str2);
        }
        COUIInputPreference cOUIInputPreference6 = this.f27093b;
        if (cOUIInputPreference6 != null) {
            cOUIInputPreference6.setHint(getString(u.f27503D));
        }
        COUIInputPreference cOUIInputPreference7 = this.f27093b;
        if (cOUIInputPreference7 != null) {
            cOUIEditText2 = cOUIInputPreference7.getEditText();
        } else {
            cOUIEditText2 = null;
        }
        if (cOUIEditText2 != null) {
            cOUIEditText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        }
        this.f27094c = (COUIMenuPreference) findPreference("edit_function");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = com.oplus.blacklistapp.j.f27265a;
        if (this.f27095d == 2) {
            ref$IntRef.element = com.oplus.blacklistapp.j.f27266b;
        }
        COUIMenuPreference cOUIMenuPreference = this.f27094c;
        if (cOUIMenuPreference != null) {
            cOUIMenuPreference.setEntries(ref$IntRef.element);
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent = activity4.getIntent()) != null) {
            i11 = intent.getIntExtra("edit_function", 0);
        } else {
            i11 = 0;
        }
        COUIMenuPreference cOUIMenuPreference2 = this.f27094c;
        if (cOUIMenuPreference2 != null) {
            cOUIMenuPreference2.setValueIndex(i11);
        }
        COUIMenuPreference cOUIMenuPreference3 = this.f27094c;
        if (cOUIMenuPreference3 != null) {
            cOUIMenuPreference3.setAssignment(getResources().getStringArray(ref$IntRef.element)[i11]);
        }
        COUIMenuPreference cOUIMenuPreference4 = this.f27094c;
        if (cOUIMenuPreference4 != null) {
            cOUIMenuPreference4.setOnPreferenceChangeListener(new Preference.c() { // from class: com.oplus.blacklistapp.fragment.p
                @Override // androidx.preference.Preference.c
                public final boolean k0(Preference preference, Object obj) {
                    boolean j12;
                    j12 = EditNumberFragment.j1(EditNumberFragment.this, ref$IntRef, preference, obj);
                    return j12;
                }
            });
        }
        BlacklistBigButtonPreference blacklistBigButtonPreference = (BlacklistBigButtonPreference) findPreference("edit_submit");
        this.f27097f = blacklistBigButtonPreference;
        if (blacklistBigButtonPreference != null) {
            blacklistBigButtonPreference.d(new BlacklistBigButtonPreference.a() { // from class: com.oplus.blacklistapp.fragment.EditNumberFragment$onCreate$2
                /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
                
                    r0 = kotlin.text.n.t(r2, " ", "", false, 4, null);
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
                @Override // com.oplus.widget.BlacklistBigButtonPreference.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onButtonClick() {
                    /*
                        r10 = this;
                        com.oplus.blacklistapp.fragment.EditNumberFragment r0 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        com.coui.appcompat.preference.COUIInputPreference r0 = com.oplus.blacklistapp.fragment.EditNumberFragment.f1(r0)
                        java.lang.String r1 = ""
                        if (r0 == 0) goto L23
                        java.lang.CharSequence r0 = r0.getContent()
                        if (r0 == 0) goto L23
                        java.lang.String r2 = r0.toString()
                        if (r2 == 0) goto L23
                        r6 = 4
                        r7 = 0
                        java.lang.String r3 = " "
                        java.lang.String r4 = ""
                        r5 = 0
                        java.lang.String r0 = kotlin.text.f.t(r2, r3, r4, r5, r6, r7)
                        if (r0 != 0) goto L24
                    L23:
                        r0 = r1
                    L24:
                        com.oplus.blacklistapp.fragment.EditNumberFragment r2 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        java.lang.String r2 = com.oplus.blacklistapp.fragment.EditNumberFragment.h1(r2)
                        boolean r2 = kotlin.jvm.internal.i.b(r0, r2)
                        r3 = 0
                        if (r2 != 0) goto L52
                        com.oplus.blacklistapp.fragment.EditNumberFragment r2 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        java.lang.String r2 = com.oplus.blacklistapp.fragment.EditNumberFragment.h1(r2)
                        if (r2 != 0) goto L3a
                        goto L52
                    L3a:
                        com.oplus.blacklistapp.fragment.EditNumberFragment r1 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        androidx.lifecycle.LifecycleCoroutineScope r4 = androidx.lifecycle.p.a(r1)
                        kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.S.b()
                        com.oplus.blacklistapp.fragment.EditNumberFragment$onCreate$2$onButtonClick$2 r7 = new com.oplus.blacklistapp.fragment.EditNumberFragment$onCreate$2$onButtonClick$2
                        com.oplus.blacklistapp.fragment.EditNumberFragment r10 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        r7.<init>(r10, r0, r3)
                        r8 = 2
                        r9 = 0
                        r6 = 0
                        kotlinx.coroutines.C1244g.d(r4, r5, r6, r7, r8, r9)
                        goto La1
                    L52:
                        com.oplus.blacklistapp.fragment.EditNumberFragment r2 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                        if (r2 == 0) goto La1
                        com.oplus.blacklistapp.fragment.EditNumberFragment r10 = com.oplus.blacklistapp.fragment.EditNumberFragment.this
                        android.content.Intent r4 = new android.content.Intent
                        r4.<init>()
                        com.coui.appcompat.preference.COUIMenuPreference r5 = com.oplus.blacklistapp.fragment.EditNumberFragment.d1(r10)
                        if (r5 == 0) goto L77
                        java.lang.String r5 = r5.getValue()
                        if (r5 == 0) goto L77
                        java.lang.String r6 = "value"
                        kotlin.jvm.internal.i.e(r5, r6)
                        int r5 = java.lang.Integer.parseInt(r5)
                        goto L78
                    L77:
                        r5 = 0
                    L78:
                        java.lang.String r6 = "edit_function"
                        r4.putExtra(r6, r5)
                        java.lang.String r5 = "edit_number"
                        r4.putExtra(r5, r0)
                        com.coui.appcompat.preference.COUIInputPreference r10 = com.oplus.blacklistapp.fragment.EditNumberFragment.e1(r10)
                        if (r10 == 0) goto L8c
                        java.lang.CharSequence r3 = r10.getContent()
                    L8c:
                        if (r3 != 0) goto L8f
                        goto L95
                    L8f:
                        java.lang.String r10 = "editNote?.content ?: \"\""
                        kotlin.jvm.internal.i.e(r3, r10)
                        r1 = r3
                    L95:
                        java.lang.String r10 = "edit_note"
                        r4.putExtra(r10, r1)
                        r10 = -1
                        r2.setResult(r10, r4)
                        r2.finish()
                    La1:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.fragment.EditNumberFragment$onCreate$2.onButtonClick():void");
                }
            });
        }
        COUIInputPreference cOUIInputPreference8 = this.f27092a;
        if (cOUIInputPreference8 != null && (editText2 = cOUIInputPreference8.getEditText()) != null) {
            editText2.addTextChangedListener(new b());
        }
        COUIInputPreference cOUIInputPreference9 = this.f27092a;
        if (cOUIInputPreference9 != null) {
            cOUIEditText3 = cOUIInputPreference9.getEditText();
        }
        if (cOUIEditText3 != null) {
            cOUIEditText3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
        }
        if (this.f27096e == null && (cOUIInputPreference = this.f27092a) != null && (editText = cOUIInputPreference.getEditText()) != null) {
            editText.requestFocus();
        }
        BlacklistBigButtonPreference blacklistBigButtonPreference2 = this.f27097f;
        if (blacklistBigButtonPreference2 != null) {
            COUIInputPreference cOUIInputPreference10 = this.f27092a;
            if (cOUIInputPreference10 == null || (content = cOUIInputPreference10.getContent()) == null || content.length() <= 0) {
                z10 = false;
            }
            blacklistBigButtonPreference2.setEnabled(z10);
        }
    }

    /* compiled from: EditNumberFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CharSequence content;
            BlacklistBigButtonPreference blacklistBigButtonPreference = EditNumberFragment.this.f27097f;
            if (blacklistBigButtonPreference != null) {
                COUIInputPreference cOUIInputPreference = EditNumberFragment.this.f27092a;
                boolean z10 = false;
                if (cOUIInputPreference != null && (content = cOUIInputPreference.getContent()) != null && content.length() > 0) {
                    z10 = true;
                }
                blacklistBigButtonPreference.setEnabled(z10);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
