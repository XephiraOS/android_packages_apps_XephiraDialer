package com.android.contacts.group.model;

import com.android.contacts.group.j;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;

/* compiled from: GroupBrowseListRepository.kt */
/* loaded from: classes.dex */
public final class GroupBrowseListRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16699a = new a(null);

    /* compiled from: GroupBrowseListRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final Object a(c<? super List<j>> cVar) {
        return C1244g.g(S.b(), new GroupBrowseListRepository$queryAccountGroups$2(null), cVar);
    }

    public final Object b(c<? super Integer> cVar) {
        return C1244g.g(S.b(), new GroupBrowseListRepository$queryVipGroup$2(null), cVar);
    }
}
