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

/* compiled from: EditFirstMatchFragment.kt */
/* loaded from: classes3.dex */
public final class EditFirstMatchFragment extends COUIPreferenceWithAppbarFragment {

    /* renamed from: f, reason: collision with root package name */
    public static final a f27083f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIInputPreference f27084a;

    /* renamed from: b, reason: collision with root package name */
    public COUIMenuPreference f27085b;

    /* renamed from: c, reason: collision with root package name */
    public int f27086c = 1;

    /* renamed from: d, reason: collision with root package name */
    public String f27087d;

    /* renamed from: e, reason: collision with root package name */
    public BlacklistBigButtonPreference f27088e;

    /* compiled from: EditFirstMatchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final boolean h1(EditFirstMatchFragment this$0, Ref$IntRef entries, Preference preference, Object obj) {
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
        if (this.f27087d == null) {
            Context context = getContext();
            if (context == null || (string = context.getString(u.f27688s2)) == null) {
                return "";
            }
        } else {
            Context context2 = getContext();
            if (context2 == null || (string = context2.getString(u.f27592Z0)) == null) {
                return "";
            }
        }
        return string;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        BlacklistBigButtonPreference blacklistBigButtonPreference = this.f27088e;
        if (blacklistBigButtonPreference != null) {
            blacklistBigButtonPreference.c(newConfig);
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i10;
        String str;
        COUIEditText cOUIEditText;
        int i11;
        CharSequence content;
        COUIInputPreference cOUIInputPreference;
        COUIEditText editText;
        COUIEditText editText2;
        Intent intent;
        Intent intent2;
        Intent intent3;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        boolean z10 = true;
        if (activity != null && (intent3 = activity.getIntent()) != null) {
            i10 = intent3.getIntExtra("blacklist_mode", 1);
        } else {
            i10 = 1;
        }
        this.f27086c = i10;
        addPreferencesFromResource(w.f27736b);
        this.f27084a = (COUIInputPreference) findPreference("edit_number");
        FragmentActivity activity2 = getActivity();
        COUIEditText cOUIEditText2 = null;
        if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
            str = intent2.getStringExtra("edit_number");
        } else {
            str = null;
        }
        this.f27087d = str;
        COUIInputPreference cOUIInputPreference2 = this.f27084a;
        if (cOUIInputPreference2 != null) {
            cOUIInputPreference2.setContent(str);
        }
        COUIInputPreference cOUIInputPreference3 = this.f27084a;
        if (cOUIInputPreference3 != null) {
            cOUIInputPreference3.setHint(getString(u.f27678q2));
        }
        COUIInputPreference cOUIInputPreference4 = this.f27084a;
        if (cOUIInputPreference4 != null) {
            cOUIEditText = cOUIInputPreference4.getEditText();
        } else {
            cOUIEditText = null;
        }
        if (cOUIEditText != null) {
            cOUIEditText.setInputType(3);
        }
        this.f27085b = (COUIMenuPreference) findPreference("edit_function");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = com.oplus.blacklistapp.j.f27265a;
        if (this.f27086c == 2) {
            ref$IntRef.element = com.oplus.blacklistapp.j.f27266b;
        }
        COUIMenuPreference cOUIMenuPreference = this.f27085b;
        if (cOUIMenuPreference != null) {
            cOUIMenuPreference.setEntries(ref$IntRef.element);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null) {
            i11 = intent.getIntExtra("edit_function", 0);
        } else {
            i11 = 0;
        }
        COUIMenuPreference cOUIMenuPreference2 = this.f27085b;
        if (cOUIMenuPreference2 != null) {
            cOUIMenuPreference2.setValueIndex(i11);
        }
        COUIMenuPreference cOUIMenuPreference3 = this.f27085b;
        if (cOUIMenuPreference3 != null) {
            cOUIMenuPreference3.setAssignment(getResources().getStringArray(ref$IntRef.element)[i11]);
        }
        COUIMenuPreference cOUIMenuPreference4 = this.f27085b;
        if (cOUIMenuPreference4 != null) {
            cOUIMenuPreference4.setOnPreferenceChangeListener(new Preference.c() { // from class: com.oplus.blacklistapp.fragment.m
                @Override // androidx.preference.Preference.c
                public final boolean k0(Preference preference, Object obj) {
                    boolean h12;
                    h12 = EditFirstMatchFragment.h1(EditFirstMatchFragment.this, ref$IntRef, preference, obj);
                    return h12;
                }
            });
        }
        BlacklistBigButtonPreference blacklistBigButtonPreference = (BlacklistBigButtonPreference) findPreference("edit_submit");
        this.f27088e = blacklistBigButtonPreference;
        if (blacklistBigButtonPreference != null) {
            blacklistBigButtonPreference.d(new BlacklistBigButtonPreference.a() { // from class: com.oplus.blacklistapp.fragment.EditFirstMatchFragment$onCreate$2
                /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
                
                    r0 = kotlin.text.n.t(r1, " ", "", false, 4, null);
                 */
                @Override // com.oplus.widget.BlacklistBigButtonPreference.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onButtonClick() {
                    /*
                        r8 = this;
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r0 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        com.coui.appcompat.preference.COUIInputPreference r0 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.e1(r0)
                        if (r0 == 0) goto L21
                        java.lang.CharSequence r0 = r0.getContent()
                        if (r0 == 0) goto L21
                        java.lang.String r1 = r0.toString()
                        if (r1 == 0) goto L21
                        r5 = 4
                        r6 = 0
                        java.lang.String r2 = " "
                        java.lang.String r3 = ""
                        r4 = 0
                        java.lang.String r0 = kotlin.text.f.t(r1, r2, r3, r4, r5, r6)
                        if (r0 != 0) goto L23
                    L21:
                        java.lang.String r0 = ""
                    L23:
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r1 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        java.lang.String r1 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.f1(r1)
                        boolean r1 = kotlin.jvm.internal.i.b(r0, r1)
                        if (r1 != 0) goto L51
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r1 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        java.lang.String r1 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.f1(r1)
                        if (r1 != 0) goto L38
                        goto L51
                    L38:
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r1 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.p.a(r1)
                        kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.S.b()
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment$onCreate$2$onButtonClick$2 r5 = new com.oplus.blacklistapp.fragment.EditFirstMatchFragment$onCreate$2$onButtonClick$2
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r8 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        r1 = 0
                        r5.<init>(r8, r0, r1)
                        r6 = 2
                        r7 = 0
                        r4 = 0
                        kotlinx.coroutines.C1244g.d(r2, r3, r4, r5, r6, r7)
                        goto L88
                    L51:
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r1 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                        if (r1 == 0) goto L88
                        com.oplus.blacklistapp.fragment.EditFirstMatchFragment r8 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.this
                        android.content.Intent r2 = new android.content.Intent
                        r2.<init>()
                        com.coui.appcompat.preference.COUIMenuPreference r8 = com.oplus.blacklistapp.fragment.EditFirstMatchFragment.d1(r8)
                        if (r8 == 0) goto L76
                        java.lang.String r8 = r8.getValue()
                        if (r8 == 0) goto L76
                        java.lang.String r3 = "value"
                        kotlin.jvm.internal.i.e(r8, r3)
                        int r8 = java.lang.Integer.parseInt(r8)
                        goto L77
                    L76:
                        r8 = 0
                    L77:
                        java.lang.String r3 = "edit_function"
                        r2.putExtra(r3, r8)
                        java.lang.String r8 = "edit_number"
                        r2.putExtra(r8, r0)
                        r8 = -1
                        r1.setResult(r8, r2)
                        r1.finish()
                    L88:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.fragment.EditFirstMatchFragment$onCreate$2.onButtonClick():void");
                }
            });
        }
        COUIInputPreference cOUIInputPreference5 = this.f27084a;
        if (cOUIInputPreference5 != null && (editText2 = cOUIInputPreference5.getEditText()) != null) {
            editText2.addTextChangedListener(new b());
        }
        COUIInputPreference cOUIInputPreference6 = this.f27084a;
        if (cOUIInputPreference6 != null) {
            cOUIEditText2 = cOUIInputPreference6.getEditText();
        }
        if (cOUIEditText2 != null) {
            cOUIEditText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
        }
        if (this.f27087d == null && (cOUIInputPreference = this.f27084a) != null && (editText = cOUIInputPreference.getEditText()) != null) {
            editText.requestFocus();
        }
        BlacklistBigButtonPreference blacklistBigButtonPreference2 = this.f27088e;
        if (blacklistBigButtonPreference2 != null) {
            COUIInputPreference cOUIInputPreference7 = this.f27084a;
            if (cOUIInputPreference7 == null || (content = cOUIInputPreference7.getContent()) == null || content.length() <= 0) {
                z10 = false;
            }
            blacklistBigButtonPreference2.setEnabled(z10);
        }
    }

    /* compiled from: EditFirstMatchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CharSequence content;
            BlacklistBigButtonPreference blacklistBigButtonPreference = EditFirstMatchFragment.this.f27088e;
            if (blacklistBigButtonPreference != null) {
                COUIInputPreference cOUIInputPreference = EditFirstMatchFragment.this.f27084a;
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
