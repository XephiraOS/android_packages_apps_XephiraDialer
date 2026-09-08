package com.customize.contacts.pushnotification.model;

import com.oplus.dialer.R;

/* compiled from: PushNotificationResource.kt */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    public static final a f21789f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f21790a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21791b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21792c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21793d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21794e;

    /* compiled from: PushNotificationResource.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final i a(c cVar) {
            String str;
            if (cVar != null) {
                str = cVar.h();
            } else {
                str = null;
            }
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case -437939055:
                    if (!str.equals("cloud recommend")) {
                        return null;
                    }
                    return new i(R.drawable.pb_ic_cloud_off, 0, 0, 0, false);
                case -373373530:
                    if (!str.equals("cloud sync")) {
                        return null;
                    }
                    return new i(R.drawable.pb_ic_cloud_off, R.string.contacts_cloud_sync_open_guide, R.string.oplus_start_switch, R.string.ignore, false, 16, null);
                case -167176721:
                    if (!str.equals("move to google")) {
                        return null;
                    }
                    return new i(R.drawable.pb_ic_move_to_google, R.string.move_local_contacts_to_google, R.string.to_move, R.string.ignore, false, 16, null);
                case 1229549512:
                    if (!str.equals("duplicate contacts")) {
                        return null;
                    }
                    return new i(R.drawable.pb_ic_duplicate_contacts_tips, R.string.duplicate_contact_detected_tips, R.string.merge, R.string.ignore, false, 16, null);
                default:
                    return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public i(int i10, int i11, int i12, int i13, boolean z10) {
        this.f21790a = i10;
        this.f21791b = i11;
        this.f21792c = i12;
        this.f21793d = i13;
        this.f21794e = z10;
    }

    public final int a() {
        return this.f21792c;
    }

    public final int b() {
        return this.f21790a;
    }

    public final int c() {
        return this.f21793d;
    }

    public final boolean d() {
        return this.f21794e;
    }

    public final int e() {
        return this.f21791b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f21790a == iVar.f21790a && this.f21791b == iVar.f21791b && this.f21792c == iVar.f21792c && this.f21793d == iVar.f21793d && this.f21794e == iVar.f21794e) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.f21790a) * 31) + Integer.hashCode(this.f21791b)) * 31) + Integer.hashCode(this.f21792c)) * 31) + Integer.hashCode(this.f21793d)) * 31;
        boolean z10 = this.f21794e;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "PushNotificationResource(iconResId=" + this.f21790a + ", messageResId=" + this.f21791b + ", firstActionButtonTextResId=" + this.f21792c + ", ignoreButtonTextResId=" + this.f21793d + ", internalRes=" + this.f21794e + ")";
    }

    public /* synthetic */ i(int i10, int i11, int i12, int i13, boolean z10, int i14, kotlin.jvm.internal.f fVar) {
        this(i10, i11, i12, i13, (i14 & 16) != 0 ? true : z10);
    }
}
