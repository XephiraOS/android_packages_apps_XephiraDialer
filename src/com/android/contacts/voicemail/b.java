package com.android.contacts.voicemail;

import android.database.Cursor;
import android.net.Uri;
import java.util.List;

/* compiled from: VoicemailStatusHelper.java */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: VoicemailStatusHelper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f17939a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17940b;

        /* renamed from: c, reason: collision with root package name */
        public final int f17941c;

        /* renamed from: d, reason: collision with root package name */
        public final int f17942d;

        /* renamed from: e, reason: collision with root package name */
        public final Uri f17943e;

        public a(String str, int i10, int i11, int i12, Uri uri) {
            this.f17939a = str;
            this.f17940b = i10;
            this.f17941c = i11;
            this.f17942d = i12;
            this.f17943e = uri;
        }

        public boolean a() {
            if (this.f17941c != -1) {
                return true;
            }
            return false;
        }
    }

    List<a> a(Cursor cursor);
}
