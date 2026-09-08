package com.android.contacts.group.viewmodel;

import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.v;
import com.android.contacts.group.j;
import com.android.contacts.group.model.GroupBrowseListRepository;
import com.customize.contacts.feature.OSPublicFeature;
import com.oplus.dialer.R;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;

/* compiled from: GroupBrowseListViewModel.kt */
/* loaded from: classes.dex */
public final class GroupBrowseListViewModel extends I {

    /* renamed from: g, reason: collision with root package name */
    public static final a f16706g = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final GroupBrowseListRepository f16707d = new GroupBrowseListRepository();

    /* renamed from: e, reason: collision with root package name */
    public final v<Integer> f16708e = new v<>();

    /* renamed from: f, reason: collision with root package name */
    public final v<List<j>> f16709f = new v<>();

    /* compiled from: GroupBrowseListViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final int a() {
            if (B3.a.U()) {
                return R.string.oplus_vip_contacts_tips_for_ride_mode;
            }
            if (OSPublicFeature.F()) {
                return R.string.oplus_vip_contacts_tips_for_drive_mode;
            }
            return R.string.oplus_vip_contacts_tips_without_vibrate_for_drive_mode;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final int j() {
        return f16706g.a();
    }

    public final v<List<j>> h() {
        return this.f16709f;
    }

    public final v<Integer> i() {
        return this.f16708e;
    }

    public final void k() {
        C1248i.d(J.a(this), null, null, new GroupBrowseListViewModel$loadAccountGroups$1(this, null), 3, null);
    }

    public final void l() {
        C1248i.d(J.a(this), null, null, new GroupBrowseListViewModel$loadVipGroup$1(this, null), 3, null);
    }
}
