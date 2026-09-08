package com.android.contacts.editor;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.contacts.model.EntityDelta;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class PhoneticNameEditorView extends TextFieldsEditorView {

    /* loaded from: classes.dex */
    public static class PhoneticValuesDelta extends EntityDelta.ValuesDelta {

        /* renamed from: h, reason: collision with root package name */
        public EntityDelta.ValuesDelta f15350h;

        /* renamed from: i, reason: collision with root package name */
        public String f15351i;

        public PhoneticValuesDelta(EntityDelta.ValuesDelta valuesDelta) {
            this.f15350h = valuesDelta;
            v0();
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public Long E() {
            return this.f15350h.E();
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public boolean R() {
            return this.f15350h.R();
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public void e0(String str, String str2) {
            if (str.equals("#phoneticName")) {
                this.f15351i = str2;
                w0(str2);
            } else {
                this.f15350h.e0(str, str2);
                v0();
            }
        }

        public final void v0() {
            this.f15351i = PhoneticNameEditorView.n0(this.f15350h.z("data9"), this.f15350h.z("data8"), this.f15350h.z("data7"));
        }

        public final void w0(String str) {
            ContentValues q02 = PhoneticNameEditorView.q0(str, null);
            this.f15350h.e0("data9", q02.getAsString("data9"));
            this.f15350h.e0("data8", q02.getAsString("data8"));
            this.f15350h.e0("data7", q02.getAsString("data7"));
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public String z(String str) {
            if (str.equals("#phoneticName")) {
                return this.f15351i;
            }
            return this.f15350h.z(str);
        }
    }

    public PhoneticNameEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static String n0(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str.trim());
            sb.append(' ');
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2.trim());
            sb.append(' ');
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3.trim());
            sb.append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static boolean p0(String str) {
        return "#phoneticName".equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.ContentValues q0(java.lang.String r5, android.content.ContentValues r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L1f
            java.lang.String r0 = " "
            r2 = 2
            java.lang.String[] r5 = r5.split(r0, r2)
            int r0 = r5.length
            r3 = 0
            r4 = 1
            if (r0 == r4) goto L1b
            if (r0 == r2) goto L16
            goto L1f
        L16:
            r0 = r5[r3]
            r5 = r5[r4]
            goto L21
        L1b:
            r0 = r5[r3]
            r5 = r1
            goto L21
        L1f:
            r5 = r1
            r0 = r5
        L21:
            if (r6 != 0) goto L28
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
        L28:
            java.lang.String r2 = "data9"
            r6.put(r2, r0)
            java.lang.String r0 = "data8"
            r6.put(r0, r1)
            java.lang.String r0 = "data7"
            r6.put(r0, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.PhoneticNameEditorView.q0(java.lang.String, android.content.ContentValues):android.content.ContentValues");
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.A
    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        EntityDelta.ValuesDelta valuesDelta2;
        if (!(valuesDelta instanceof PhoneticValuesDelta)) {
            valuesDelta2 = new PhoneticValuesDelta(valuesDelta);
        } else {
            valuesDelta2 = valuesDelta;
        }
        super.g(cVar, valuesDelta2, entityDelta, z10, viewIdGenerator);
    }

    public boolean o0() {
        EntityDelta.ValuesDelta entry = getEntry();
        String z10 = entry.z("data9");
        String z11 = entry.z("data8");
        String z12 = entry.z("data7");
        if (TextUtils.isEmpty(z10) && TextUtils.isEmpty(z11) && TextUtils.isEmpty(z12)) {
            return false;
        }
        return true;
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ImageView imageView = (ImageView) findViewById(R.id.left_icon_view);
        imageView.setImageResource(R.drawable.pb_ic_name);
        imageView.setVisibility(4);
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView
    public void x(String str, String str2) {
        if (!u(str, str2)) {
            return;
        }
        if (c0()) {
            if ((!Y()) == p0(str)) {
                super.x(str, str2);
                return;
            }
            return;
        }
        super.x(str, str2);
    }
}
