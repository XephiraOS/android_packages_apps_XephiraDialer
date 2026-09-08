package com.customize.contacts.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import c.C0543d;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.w;
import com.customize.contacts.util.S;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class EditRingtoneView extends SetView implements View.OnClickListener {

    /* renamed from: g, reason: collision with root package name */
    public EntityDelta.ValuesDelta f22297g;

    /* renamed from: h, reason: collision with root package name */
    public EntityDelta f22298h;

    /* renamed from: i, reason: collision with root package name */
    public b f22299i;

    /* renamed from: j, reason: collision with root package name */
    public androidx.activity.result.b f22300j;

    /* loaded from: classes3.dex */
    public class a implements androidx.activity.result.a {
        public a() {
        }

        @Override // androidx.activity.result.a
        public void a(Object obj) {
            EditRingtoneView.this.setResult((ActivityResult) obj);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public EditRingtoneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context);
    }

    private void j(Uri uri) {
        String str;
        if (H7.a.b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleRingtonePicked(), pickedUri = ");
            if (uri != null) {
                str = uri.toString();
            } else {
                str = null;
            }
            sb.append(str);
            H7.b.b("EditRingtoneView", sb.toString());
        }
        if (uri != null && !com.customize.contacts.manager.i.j(uri)) {
            String uri2 = uri.toString();
            this.f22419e = uri2;
            this.f22297g.e0("custom_ringtone", uri2);
        } else if (!this.f22297g.f("custom_ringtone")) {
            this.f22419e = null;
            this.f22297g.n0("custom_ringtone");
        } else {
            this.f22419e = null;
            this.f22297g.e0("custom_ringtone", null);
        }
        a();
        o();
    }

    private void k(Context context) {
        if (context instanceof ComponentActivity) {
            this.f22300j = ((ComponentActivity) context).getActivityResultRegistry().j("set_ring_tone", new C0543d(), new a());
        }
    }

    public final void a() {
        String mimeType = getMimeType();
        ArrayList<EntityDelta.ValuesDelta> D10 = this.f22298h.D(mimeType);
        if (D10 != null && D10.size() > 0) {
            EntityDelta.ValuesDelta valuesDelta = this.f22298h.D(mimeType).get(0);
            this.f22298h.D(mimeType).remove(valuesDelta);
            valuesDelta.e0(getColumnKey(), this.f22419e);
            this.f22298h.d(valuesDelta);
        }
    }

    public void b() {
        if (com.customize.contacts.manager.i.k(this.f22419e)) {
            this.f22299i.b();
        }
    }

    public void f(Activity activity) {
        h0.M(getContext(), ContactEditorFragment.r3(), "incall_ringtone");
        String e10 = com.customize.contacts.manager.i.e(getContext(), this.f22419e);
        if (H7.a.b()) {
            H7.b.b("EditRingtoneView", "onClick(), mValues = " + this.f22297g + ", ringTone = " + e10);
        }
        h(activity, this.f22419e, activity.getString(R.string.oplus_incoming_ring));
        setClickable(false);
    }

    @Override // com.customize.contacts.widget.SetView
    public String getColumnKey() {
        return "custom_ringtone";
    }

    @Override // com.customize.contacts.widget.SetView
    public String getDefaultData() {
        return getContext().getString(R.string.follow_system_ringtone);
    }

    @Override // com.customize.contacts.widget.SetView
    public int getDefaultHint() {
        return R.string.oplus_incoming_ring;
    }

    @Override // com.customize.contacts.widget.SetView
    public int getLeftIconResId() {
        return R.drawable.pb_ic_ring;
    }

    @Override // com.customize.contacts.widget.SetView
    public String getMimeType() {
        return "vnd.android.cursor.item/custom_ringtone";
    }

    public final void h(Activity activity, String str, String str2) {
        Intent a10 = com.customize.contacts.manager.i.a(activity, str);
        S.a(a10, str2);
        try {
            this.f22300j.a(a10);
        } catch (Throwable th) {
            H7.b.c("EditRingtoneView", "th = " + th);
        }
        SoftKeyboardUtil.a().b(activity.getCurrentFocus());
    }

    public String i(String str) {
        return getContext().getString(getDefaultHint()) + " " + str;
    }

    public String l() {
        String defaultData = getDefaultData();
        String str = this.f22419e;
        if (str != null) {
            if (com.customize.contacts.manager.i.k(str) && !w.k(getContext(), w.e())) {
                if (H7.a.b()) {
                    H7.b.b("EditRingtoneView", "retrieveDisplayText(), isCustomRingtone and without permission");
                }
                String string = getContext().getString(R.string.click_authorize_to_view_and_edit);
                this.f22417c.setTextColor(r.d(getContext()));
                return string;
            }
            String e10 = com.customize.contacts.manager.i.e(getContext(), this.f22419e);
            if (TextUtils.isEmpty(e10)) {
                this.f22419e = null;
                this.f22297g.e0("custom_ringtone", null);
                e10 = getDefaultData();
            }
            String d10 = com.customize.contacts.manager.i.d(e10);
            if (H7.a.b()) {
                H7.b.b("EditRingtoneView", "retrieveDisplayText(), ringtone = " + d10 + ", mData = " + this.f22419e);
            }
            if (!TextUtils.isEmpty(d10)) {
                defaultData = d10;
            }
            this.f22417c.setTextColor(getContext().getColor(R.color.coui_preference_title_color));
            return defaultData;
        }
        return defaultData;
    }

    public void m(com.android.contacts.model.c cVar, EntityDelta entityDelta) {
        int i10;
        if (entityDelta.Q(cVar.f17004c)) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
    }

    public void n(EntityDelta entityDelta, EntityDelta.ValuesDelta valuesDelta) {
        this.f22298h = entityDelta;
        this.f22297g = valuesDelta;
        if (valuesDelta == null) {
            return;
        }
        this.f22419e = valuesDelta.z("custom_ringtone");
        o();
    }

    public void o() {
        String l10 = l();
        this.f22417c.setText(l10);
        this.f22417c.setContentDescription(i(l10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        if (view == this && (bVar = this.f22299i) != null) {
            bVar.a();
        }
    }

    @Override // com.customize.contacts.widget.SetView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
        setFocusableInTouchMode(false);
    }

    public void setEditRingtoneViewListener(b bVar) {
        this.f22299i = bVar;
    }

    public void setResult(ActivityResult activityResult) {
        Intent b10 = activityResult.b();
        if (H7.a.b()) {
            H7.b.b("EditRingtoneView", "setResult, result.getResultCode() = " + activityResult.d() + ", data = " + b10);
        }
        setClickable(true);
        clearFocus();
        HashMap hashMap = new HashMap();
        if (com.customize.contacts.manager.i.l(b10)) {
            H7.b.b("EditRingtoneView", "setResult, no need save ringTone from settings.");
        } else {
            String str = null;
            if (b10 != null) {
                Uri uri = (Uri) C7.e.j(b10, "android.intent.extra.ringtone.PICKED_URI");
                String str2 = this.f22419e;
                if (uri != null) {
                    str = uri.toString();
                }
                hashMap.put("ring_changed", Boolean.valueOf(true ^ TextUtils.equals(str2, str)));
                if (com.customize.contacts.manager.i.f21553c) {
                    j(uri);
                } else {
                    j(com.customize.contacts.manager.i.h(uri, getContext()));
                }
            } else if (com.customize.contacts.manager.i.f21553c) {
                j(null);
            }
        }
        A.a(getContext(), 2000310, 200030077, hashMap, false);
    }
}
