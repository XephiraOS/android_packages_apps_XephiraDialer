package com.oplus.blacklistapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIMenuPreference;
import com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment;
import com.oplus.blacklistapp.u;
import com.oplus.blacklistapp.w;
import com.oplus.widget.BlacklistBigButtonPreference;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: EditFunctionFragment.kt */
/* loaded from: classes3.dex */
public final class o extends COUIPreferenceWithAppbarFragment implements BlacklistBigButtonPreference.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f27201c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIMenuPreference f27202a;

    /* renamed from: b, reason: collision with root package name */
    public int f27203b = 1;

    /* compiled from: EditFunctionFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final boolean d1(o this$0, Ref$IntRef entries, Preference preference, Object obj) {
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
        String str;
        Context context = getContext();
        if (context != null) {
            str = context.getString(u.f27572U0);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.oplus.widget.BlacklistBigButtonPreference.a
    public void onButtonClick() {
        int i10;
        String value;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            COUIMenuPreference cOUIMenuPreference = this.f27202a;
            if (cOUIMenuPreference != null && (value = cOUIMenuPreference.getValue()) != null) {
                kotlin.jvm.internal.i.e(value, "value");
                i10 = Integer.parseInt(value);
            } else {
                i10 = 0;
            }
            intent.putExtra("edit_function", i10);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Intent intent;
        Intent intent2;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        int i10 = 1;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            i10 = intent2.getIntExtra("blacklist_mode", 1);
        }
        this.f27203b = i10;
        addPreferencesFromResource(w.f27737c);
        this.f27202a = (COUIMenuPreference) findPreference("edit_function");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = com.oplus.blacklistapp.j.f27265a;
        if (this.f27203b == 2) {
            ref$IntRef.element = com.oplus.blacklistapp.j.f27266b;
        }
        COUIMenuPreference cOUIMenuPreference = this.f27202a;
        if (cOUIMenuPreference != null) {
            cOUIMenuPreference.setEntries(ref$IntRef.element);
        }
        FragmentActivity activity2 = getActivity();
        int i11 = 0;
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            i11 = intent.getIntExtra("edit_function", 0);
        }
        COUIMenuPreference cOUIMenuPreference2 = this.f27202a;
        if (cOUIMenuPreference2 != null) {
            cOUIMenuPreference2.setValueIndex(i11);
        }
        COUIMenuPreference cOUIMenuPreference3 = this.f27202a;
        if (cOUIMenuPreference3 != null) {
            cOUIMenuPreference3.setAssignment(getResources().getStringArray(ref$IntRef.element)[i11]);
        }
        COUIMenuPreference cOUIMenuPreference4 = this.f27202a;
        if (cOUIMenuPreference4 != null) {
            cOUIMenuPreference4.setOnPreferenceChangeListener(new Preference.c() { // from class: com.oplus.blacklistapp.fragment.n
                @Override // androidx.preference.Preference.c
                public final boolean k0(Preference preference, Object obj) {
                    boolean d12;
                    d12 = o.d1(o.this, ref$IntRef, preference, obj);
                    return d12;
                }
            });
        }
    }
}
