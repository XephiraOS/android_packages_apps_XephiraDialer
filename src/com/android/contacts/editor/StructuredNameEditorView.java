package com.android.contacts.editor;

import X0.b;
import android.content.ContentValues;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.contacts.model.EntityDelta;
import com.oplus.dialer.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class StructuredNameEditorView extends TextFieldsEditorView {

    /* renamed from: a0, reason: collision with root package name */
    public ContentValues f15412a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f15413b0;

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f15414a;

        /* renamed from: b, reason: collision with root package name */
        public ContentValues f15415b;

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f15416c;

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

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f15416c, 0);
            parcel.writeInt(this.f15414a ? 1 : 0);
            parcel.writeParcelable(this.f15415b, 0);
        }

        public SavedState(Parcelable parcelable) {
            this.f15416c = parcelable;
        }

        public SavedState(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.f15416c = parcel.readParcelable(classLoader);
            this.f15414a = parcel.readInt() != 0;
            this.f15415b = (ContentValues) parcel.readParcelable(classLoader);
        }
    }

    public StructuredNameEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.A
    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        super.g(cVar, valuesDelta, entityDelta, z10, viewIdGenerator);
        if (this.f15412a0 == null) {
            this.f15412a0 = new ContentValues(getEntry().C());
            this.f15413b0 = valuesDelta.K();
        } else {
            this.f15413b0 = false;
        }
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView
    public void g0() {
        if (c0()) {
            if (Y()) {
                s0();
            } else {
                t0();
            }
        }
        super.g0();
    }

    public final void n0(EntityDelta.ValuesDelta valuesDelta) {
        valuesDelta.k0("data1");
    }

    public final void o0(EntityDelta.ValuesDelta valuesDelta) {
        for (String str : com.android.contacts.util.q.e()) {
            valuesDelta.k0(str);
        }
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ((ImageView) findViewById(R.id.left_icon_view)).setImageResource(R.drawable.pb_ic_name);
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f15416c);
        this.f15413b0 = savedState.f15414a;
        this.f15412a0 = savedState.f15415b;
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15414a = this.f15413b0;
        savedState.f15415b = this.f15412a0;
        return savedState;
    }

    public final void p0(String str, String str2) {
        Iterator<b.a> it = getOnFieldContentEditListeners().iterator();
        while (it.hasNext()) {
            it.next().onFieldContentChanged(str, str2);
        }
    }

    public final void q0(EntityDelta.ValuesDelta valuesDelta) {
        valuesDelta.e0("data1", com.android.contacts.util.q.g(getContext(), u0(valuesDelta)));
    }

    public final void r0(EntityDelta.ValuesDelta valuesDelta) {
        Map<String, String> c10 = com.android.contacts.util.q.c(getContext(), valuesDelta.z("data1"));
        for (String str : c10.keySet()) {
            valuesDelta.e0(str, c10.get(str));
        }
    }

    public final void s0() {
        EntityDelta.ValuesDelta entry = getEntry();
        if (!this.f15413b0) {
            for (String str : com.android.contacts.util.q.e()) {
                entry.e0(str, this.f15412a0.getAsString(str));
            }
            return;
        }
        String z10 = entry.z("data1");
        Map<String, String> c10 = com.android.contacts.util.q.c(getContext(), z10);
        if (!c10.isEmpty()) {
            n0(entry);
            for (String str2 : c10.keySet()) {
                entry.e0(str2, c10.get(str2));
            }
        }
        this.f15412a0.clear();
        this.f15412a0.putAll(entry.C());
        this.f15412a0.put("data1", z10);
    }

    public final void t0() {
        EntityDelta.ValuesDelta entry = getEntry();
        if (!this.f15413b0) {
            entry.e0("data1", this.f15412a0.getAsString("data1"));
            return;
        }
        Map<String, String> u02 = u0(entry);
        String g10 = com.android.contacts.util.q.g(getContext(), u02);
        if (!TextUtils.isEmpty(g10)) {
            o0(entry);
            entry.e0("data1", g10);
        }
        this.f15412a0.clear();
        this.f15412a0.put("data1", entry.z("data1"));
        for (String str : u02.keySet()) {
            this.f15412a0.put(str, u02.get(str));
        }
    }

    public final Map<String, String> u0(EntityDelta.ValuesDelta valuesDelta) {
        HashMap hashMap = new HashMap();
        for (String str : com.android.contacts.util.q.e()) {
            hashMap.put(str, valuesDelta.z(str));
        }
        return hashMap;
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView
    public void x(String str, String str2) {
        if (!u(str, str2)) {
            return;
        }
        super.x(str, str2);
        this.f15413b0 = true;
        if (c0()) {
            if (Y()) {
                q0(getEntry());
            } else {
                r0(getEntry());
            }
        }
        p0(str, str2);
    }
}
