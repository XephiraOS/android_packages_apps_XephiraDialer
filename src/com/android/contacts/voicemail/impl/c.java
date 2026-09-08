package com.android.contacts.voicemail.impl;

import android.content.ContentValues;
import android.content.Context;
import android.provider.VoicemailContract;
import android.telecom.PhoneAccountHandle;

/* compiled from: VoicemailStatus.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: VoicemailStatus.java */
    /* loaded from: classes.dex */
    public static class a extends b {
        @Override // com.android.contacts.voicemail.impl.c.b
        public boolean a() {
            return true;
        }

        public void i() {
            super.a();
        }

        public a(Context context, PhoneAccountHandle phoneAccountHandle) {
            super(context, phoneAccountHandle);
        }
    }

    /* compiled from: VoicemailStatus.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f18034a;

        /* renamed from: b, reason: collision with root package name */
        public final PhoneAccountHandle f18035b;

        /* renamed from: c, reason: collision with root package name */
        public ContentValues f18036c;

        public boolean a() {
            PhoneAccountHandle phoneAccountHandle = this.f18035b;
            if (phoneAccountHandle == null) {
                C1.a.b("VvmStatus", "apply mPhoneAccountHandle == null");
                return false;
            }
            this.f18036c.put("phone_account_component_name", phoneAccountHandle.getComponentName().flattenToString());
            this.f18036c.put("phone_account_id", this.f18035b.getId());
            try {
                this.f18034a.getContentResolver().insert(VoicemailContract.Status.buildSourceUri(this.f18034a.getPackageName()), this.f18036c);
                this.f18036c.clear();
                return true;
            } catch (IllegalArgumentException e10) {
                H7.b.c("VvmStatus", "apply :: failed to insert content resolver iae = " + e10);
                this.f18036c.clear();
                return false;
            }
        }

        public PhoneAccountHandle b() {
            return this.f18035b;
        }

        public ContentValues c() {
            return this.f18036c;
        }

        public b d(int i10) {
            this.f18036c.put("configuration_state", Integer.valueOf(i10));
            return this;
        }

        public b e(int i10) {
            this.f18036c.put("data_channel_state", Integer.valueOf(i10));
            return this;
        }

        public b f(int i10) {
            this.f18036c.put("notification_channel_state", Integer.valueOf(i10));
            return this;
        }

        public b g(int i10, int i11) {
            if (i10 == -1 && i11 == -1) {
                return this;
            }
            this.f18036c.put("quota_occupied", Integer.valueOf(i10));
            this.f18036c.put("quota_total", Integer.valueOf(i11));
            return this;
        }

        public b h(String str) {
            this.f18036c.put("source_type", str);
            return this;
        }

        public b(Context context, PhoneAccountHandle phoneAccountHandle) {
            this.f18036c = new ContentValues();
            this.f18034a = context;
            this.f18035b = phoneAccountHandle;
            if (phoneAccountHandle == null) {
                H7.b.i("VvmStatus", "VoicemailStatus.Editor created with null phone account, status will not be written");
            }
        }
    }

    public static a a(Context context, PhoneAccountHandle phoneAccountHandle) {
        return new a(context, phoneAccountHandle);
    }

    public static void b(Context context, PhoneAccountHandle phoneAccountHandle) {
        c(context, phoneAccountHandle).d(1).e(1).f(1).a();
    }

    public static b c(Context context, PhoneAccountHandle phoneAccountHandle) {
        return new b(context, phoneAccountHandle);
    }
}
