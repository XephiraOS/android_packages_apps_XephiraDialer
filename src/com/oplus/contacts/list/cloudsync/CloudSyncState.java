package com.oplus.contacts.list.cloudsync;

import android.content.Context;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.oplus.contacts.list.cloudsync.CloudSyncState;
import com.oplus.dialer.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: CloudSyncState.kt */
/* loaded from: classes3.dex */
public abstract class CloudSyncState {

    /* compiled from: CloudSyncState.kt */
    /* loaded from: classes3.dex */
    public static final class a extends CloudSyncState {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f27865a;

        public final boolean c() {
            return this.f27865a;
        }
    }

    /* compiled from: CloudSyncState.kt */
    /* loaded from: classes3.dex */
    public static final class b extends CloudSyncState {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f27866a;

        /* renamed from: b, reason: collision with root package name */
        public final CloudSyncPauseType f27867b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z10, CloudSyncPauseType type) {
            super(null);
            i.f(type, "type");
            this.f27866a = z10;
            this.f27867b = type;
        }

        public final boolean c() {
            return this.f27866a;
        }

        public final CloudSyncPauseType d() {
            return this.f27867b;
        }
    }

    /* compiled from: CloudSyncState.kt */
    /* loaded from: classes3.dex */
    public static final class c extends CloudSyncState {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f27868a;

        public c(boolean z10) {
            super(null);
            this.f27868a = z10;
        }

        public final boolean c() {
            return this.f27868a;
        }
    }

    /* compiled from: CloudSyncState.kt */
    /* loaded from: classes3.dex */
    public static final class d extends CloudSyncState {

        /* renamed from: a, reason: collision with root package name */
        public static final d f27869a = new d();

        public d() {
            super(null);
        }
    }

    /* compiled from: CloudSyncState.kt */
    /* loaded from: classes3.dex */
    public static final class e extends CloudSyncState {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f27870a;

        public e(boolean z10) {
            super(null);
            this.f27870a = z10;
        }

        public final boolean c() {
            return this.f27870a;
        }
    }

    public CloudSyncState() {
    }

    public final Integer a() {
        boolean z10 = this instanceof c;
        int i10 = R.drawable.pb_ic_cloud_syncing;
        if (z10) {
            if (!((c) this).c()) {
                i10 = R.drawable.pb_ic_cloud_querying;
            }
            return Integer.valueOf(i10);
        }
        if (this instanceof e) {
            ((e) this).c();
            return Integer.valueOf(R.drawable.pb_ic_cloud_syncing);
        }
        if (this instanceof a) {
            return Integer.valueOf(R.drawable.pb_ic_cloud_synced);
        }
        if (this instanceof b) {
            if (!((b) this).c()) {
                i10 = R.drawable.pb_ic_cloud_sync_paused;
            }
            return Integer.valueOf(i10);
        }
        if (i.b(this, d.f27869a)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final CharSequence b(final Context context) {
        int i10;
        i.f(context, "context");
        boolean z10 = this instanceof c;
        int i11 = R.string.retrying_synch_contacts;
        if (z10) {
            if (!((c) this).c()) {
                i11 = R.string.cloud_querying;
            }
            String string = context.getString(i11);
            i.e(string, "context.getString(if (sh… R.string.cloud_querying)");
            return string;
        }
        if (this instanceof e) {
            if (!((e) this).c()) {
                i11 = R.string.cloud_syncing;
            }
            String string2 = context.getString(i11);
            i.e(string2, "context.getString(if (sh…e R.string.cloud_syncing)");
            return string2;
        }
        if (this instanceof a) {
            if (((a) this).c()) {
                i10 = R.string.download_success_tips;
            } else {
                i10 = R.string.cloud_synced;
            }
            String string3 = context.getString(i10);
            i.e(string3, "context.getString(if (is…se R.string.cloud_synced)");
            return string3;
        }
        if (this instanceof b) {
            if (((b) this).c()) {
                String string4 = context.getString(R.string.retrying_synch_contacts);
                i.e(string4, "{\n                    co…ntacts)\n                }");
                return string4;
            }
            String string5 = context.getString(R.string.look_over);
            i.e(string5, "context.getString(R.string.look_over)");
            String string6 = context.getString(R.string.cloud_sync_paused, string5);
            i.e(string6, "context.getString(R.stri…d_sync_paused, clickText)");
            return U7.d.b(context, string6, string5, Integer.valueOf(COUIContextUtil.getAttrColor(context, R.attr.couiColorContainerTheme)), new InterfaceC1637a<q>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncState$getStateTip$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // v9.InterfaceC1637a
                public /* bridge */ /* synthetic */ q invoke() {
                    invoke2();
                    return q.f35511a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((CloudSyncState.b) CloudSyncState.this).d().a(context);
                }
            });
        }
        if (i.b(this, d.f27869a)) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ CloudSyncState(f fVar) {
        this();
    }
}
