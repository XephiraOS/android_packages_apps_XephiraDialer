package com.android.contacts.group.viewmodel;

import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.v;
import com.android.contacts.group.model.SmartGroupRepository;
import com.customize.contacts.activities.SmartGroupActivity;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;

/* compiled from: SmartGroupViewModel.kt */
/* loaded from: classes.dex */
public final class SmartGroupViewModel extends I {

    /* renamed from: f, reason: collision with root package name */
    public static final a f16710f = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final SmartGroupRepository f16711d;

    /* renamed from: e, reason: collision with root package name */
    public final v<List<SmartGroupActivity.c>> f16712e;

    /* compiled from: SmartGroupViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SmartGroupViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final v<List<SmartGroupActivity.c>> h() {
        return this.f16712e;
    }

    public final void i(int i10) {
        C1248i.d(J.a(this), null, null, new SmartGroupViewModel$loadSmartGroups$1(this, i10, null), 3, null);
    }

    public /* synthetic */ SmartGroupViewModel(SmartGroupRepository smartGroupRepository, int i10, f fVar) {
        this((i10 & 1) != 0 ? new SmartGroupRepository() : smartGroupRepository);
    }

    public SmartGroupViewModel(SmartGroupRepository mRepository) {
        i.f(mRepository, "mRepository");
        this.f16711d = mRepository;
        this.f16712e = new v<>();
    }
}
