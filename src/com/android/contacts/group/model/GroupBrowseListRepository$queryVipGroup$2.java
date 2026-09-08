package com.android.contacts.group.model;

import R0.d;
import android.database.Cursor;
import com.android.contacts.ContactsApplication;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.a;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GroupBrowseListRepository.kt */
@InterfaceC1470d(c = "com.android.contacts.group.model.GroupBrowseListRepository$queryVipGroup$2", f = "GroupBrowseListRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GroupBrowseListRepository$queryVipGroup$2 extends SuspendLambda implements p<E, c<? super Integer>, Object> {
    int label;

    public GroupBrowseListRepository$queryVipGroup$2(c<? super GroupBrowseListRepository$queryVipGroup$2> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GroupBrowseListRepository$queryVipGroup$2(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Cursor cursor;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b("GroupBrowseListRepository", "queryVipGroup");
            try {
                Cursor query = ContactsApplication.h().getContentResolver().query(d.f3229p.buildUpon().query("Vip in ColorOS").build(), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            cursor = query;
                        } else {
                            cursor = null;
                        }
                        if (cursor != null) {
                            cursor.moveToFirst();
                            int i10 = cursor.getInt(cursor.getColumnIndex("group_member_count"));
                            H7.b.e("GroupBrowseListRepository", "groupMemberCount = " + i10);
                            Integer d10 = C1467a.d(i10);
                            a.a(query, null);
                            return d10;
                        }
                    } finally {
                    }
                }
                a.a(query, null);
            } catch (Throwable th) {
                H7.b.c("GroupBrowseListRepository", "queryVipGroup exception: " + th);
            }
            return C1467a.d(0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super Integer> cVar) {
        return ((GroupBrowseListRepository$queryVipGroup$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
