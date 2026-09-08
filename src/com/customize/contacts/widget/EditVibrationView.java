package com.customize.contacts.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import c.C0543d;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: EditVibrationView.kt */
/* loaded from: classes3.dex */
public final class EditVibrationView extends SetView implements View.OnClickListener {

    /* renamed from: j, reason: collision with root package name */
    public static final a f22302j = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public EntityDelta.ValuesDelta f22303g;

    /* renamed from: h, reason: collision with root package name */
    public EntityDelta f22304h;

    /* renamed from: i, reason: collision with root package name */
    public androidx.activity.result.b<Intent> f22305i;

    /* compiled from: EditVibrationView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public EditVibrationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(this);
        setFocusableInTouchMode(false);
        i(context);
    }

    private final void b() {
        ArrayList<EntityDelta.ValuesDelta> D10;
        EntityDelta entityDelta = this.f22304h;
        if (entityDelta != null && (D10 = entityDelta.D(getMimeType())) != null && D10.size() > 0) {
            EntityDelta.ValuesDelta valuesDelta = D10.get(0);
            D10.remove(valuesDelta);
            valuesDelta.e0(getColumnKey(), this.f22419e);
            entityDelta.d(valuesDelta);
        }
    }

    private final void h(int i10, String str) {
        if (H7.a.b()) {
            H7.b.b("EditVibrationView", "handleVibrationPicked(): resultType = " + i10 + ", resultResId = " + str);
        }
        if (!com.customize.contacts.manager.h.h(i10, str)) {
            EntityDelta.ValuesDelta valuesDelta = this.f22303g;
            if (valuesDelta != null && valuesDelta.f("custom_vibration")) {
                this.f22419e = null;
                EntityDelta.ValuesDelta valuesDelta2 = this.f22303g;
                if (valuesDelta2 != null) {
                    valuesDelta2.k0("custom_vibration");
                }
            } else {
                this.f22419e = null;
                EntityDelta.ValuesDelta valuesDelta3 = this.f22303g;
                if (valuesDelta3 != null) {
                    valuesDelta3.n0("custom_vibration");
                }
            }
        } else {
            String b10 = com.customize.contacts.manager.h.b(Integer.valueOf(i10), str);
            this.f22419e = b10;
            EntityDelta.ValuesDelta valuesDelta4 = this.f22303g;
            if (valuesDelta4 != null) {
                valuesDelta4.e0("custom_vibration", b10);
            }
        }
        b();
        n();
    }

    private final void i(Context context) {
        if (context instanceof ComponentActivity) {
            this.f22305i = ((ComponentActivity) context).getActivityResultRegistry().j("set_vibration", new C0543d(), new androidx.activity.result.a() { // from class: com.customize.contacts.widget.j
                @Override // androidx.activity.result.a
                public final void a(Object obj) {
                    EditVibrationView.j(EditVibrationView.this, (ActivityResult) obj);
                }
            });
        }
    }

    public static final void j(EditVibrationView this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.setResult(activityResult);
    }

    public String f(String str) {
        return getContext().getString(getDefaultHint()) + " " + str;
    }

    @Override // com.customize.contacts.widget.SetView
    public String getColumnKey() {
        return "custom_vibration";
    }

    @Override // com.customize.contacts.widget.SetView
    public String getDefaultData() {
        String string = getContext().getString(R.string.default_vibration_mode);
        kotlin.jvm.internal.i.e(string, "context.getString(R.string.default_vibration_mode)");
        return string;
    }

    @Override // com.customize.contacts.widget.SetView
    public int getDefaultHint() {
        return R.string.incoming_call_vibration_title;
    }

    @Override // com.customize.contacts.widget.SetView
    public int getLeftIconResId() {
        return R.drawable.pb_ic_vibration;
    }

    @Override // com.customize.contacts.widget.SetView
    public String getMimeType() {
        return "vnd.android.cursor.item/custom_vibration";
    }

    public String k() {
        String defaultData = getDefaultData();
        if (this.f22419e != null) {
            defaultData = com.customize.contacts.manager.h.e(getContext(), this.f22419e, getContext().getResources().getString(R.string.default_vibration_mode));
            if (TextUtils.isEmpty(defaultData)) {
                this.f22419e = null;
                EntityDelta.ValuesDelta valuesDelta = this.f22303g;
                if (valuesDelta != null) {
                    valuesDelta.k0("custom_vibration");
                }
                defaultData = getDefaultData();
            }
            if (H7.a.b()) {
                H7.b.b("EditVibrationView", "retrieveDisplayText(), vibration = " + defaultData + ", mData = " + this.f22419e);
            }
        }
        return defaultData;
    }

    public void l(com.android.contacts.model.c kind, EntityDelta state) {
        int i10;
        kotlin.jvm.internal.i.f(kind, "kind");
        kotlin.jvm.internal.i.f(state, "state");
        if (state.Q(kind.f17004c)) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
    }

    public void m(EntityDelta entry, EntityDelta.ValuesDelta values) {
        kotlin.jvm.internal.i.f(entry, "entry");
        kotlin.jvm.internal.i.f(values, "values");
        this.f22304h = entry;
        this.f22419e = values.z("custom_vibration");
        n();
        this.f22303g = values;
    }

    public void n() {
        String k10 = k();
        this.f22417c.setText(k10);
        this.f22417c.setContentDescription(f(k10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        androidx.activity.result.b<Intent> bVar;
        kotlin.jvm.internal.i.f(v10, "v");
        if (v10 == this) {
            if (H7.a.b()) {
                H7.b.b("EditVibrationView", "onClick(): values = " + this.f22303g + " ,mData = " + this.f22419e);
            }
            Context context = getContext();
            kotlin.jvm.internal.i.e(context, "context");
            h0.M(context, ContactEditorFragment.r3(), "incall_vibration");
            Intent a10 = com.customize.contacts.manager.h.a(getContext(), this.f22419e);
            if (a10 != null && (bVar = this.f22305i) != null) {
                T7.b.b(bVar, getContext(), a10, 0);
            }
            setClickable(false);
        }
    }

    public final void setResult(ActivityResult activityResult) {
        if (activityResult != null) {
            Intent b10 = activityResult.b();
            if (H7.a.b()) {
                H7.b.b("EditVibrationView", "onActivityResultCall: resultCode = " + activityResult.d() + ", data = " + b10);
            }
            setClickable(true);
            clearFocus();
            if (b10 != null) {
                int d10 = C7.e.d(b10, "final_vibrate_type", -1);
                String pickedResId = C7.e.l(b10, "final_vibrate_title_res_key");
                kotlin.jvm.internal.i.e(pickedResId, "pickedResId");
                h(d10, pickedResId);
            }
        }
    }
}
