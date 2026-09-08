package com.android.contacts.group.model;

import R0.a;
import android.database.Cursor;
import com.android.contacts.ContactsApplication;
import com.android.contacts.L0;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.group.j;
import com.android.contacts.model.Account;
import com.customize.contacts.util.C0810v;
import com.google.common.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GroupBrowseListRepository.kt */
@InterfaceC1470d(c = "com.android.contacts.group.model.GroupBrowseListRepository$queryAccountGroups$2", f = "GroupBrowseListRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GroupBrowseListRepository$queryAccountGroups$2 extends SuspendLambda implements p<E, c<? super List<j>>, Object> {
    int label;

    public GroupBrowseListRepository$queryAccountGroups$2(c<? super GroupBrowseListRepository$queryAccountGroups$2> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GroupBrowseListRepository$queryAccountGroups$2(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Cursor cursor;
        LinkedHashMap linkedHashMap;
        boolean z10;
        int i10;
        boolean z11;
        String string;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b("GroupBrowseListRepository", "queryAccountGroups");
            ContactsApplication h10 = ContactsApplication.h();
            ArrayList arrayList = new ArrayList();
            try {
                if (a.f3165a == null) {
                    str = "auto_add=0 AND favorites=0 AND deleted=0 AND title!='Business Card in ColorOS'";
                } else {
                    str = "account_type NOT NULL AND account_name NOT NULL AND auto_add=0 AND favorites=0 AND deleted=0 AND title!='Business Card in ColorOS'";
                }
                Cursor query = h10.getContentResolver().query(L0.f13144a, L0.f13146c, str, null, L0.f13145b);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            cursor = query;
                        } else {
                            cursor = null;
                        }
                        if (cursor != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(BreenoCallContract.SummaryColumns.COUNT, C1467a.d(cursor.getCount()));
                            int i11 = 0;
                            A.a(h10, 2000308, 200030046, hashMap, false);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            int count = cursor.getCount();
                            int i12 = 0;
                            while (i12 < count) {
                                cursor.moveToPosition(i12);
                                String string2 = cursor.getString(i11);
                                String string3 = cursor.getString(1);
                                String string4 = cursor.getString(2);
                                long j10 = cursor.getLong(3);
                                String string5 = cursor.getString(4);
                                int i13 = cursor.getInt(5);
                                if (i.b("Vip in ColorOS", string5)) {
                                    Account account = new Account(string2, string3);
                                    linkedHashMap2.put(account, C1467a.e(j10));
                                    Long l10 = (Long) linkedHashMap2.get(account);
                                    if (l10 != null) {
                                        C0810v.h(account, l10.longValue());
                                    }
                                    linkedHashMap = linkedHashMap2;
                                } else {
                                    int i14 = i12 - 1;
                                    if (i14 >= linkedHashMap2.size() && cursor.moveToPosition(i14)) {
                                        String string6 = cursor.getString(i11);
                                        String string7 = cursor.getString(1);
                                        linkedHashMap = linkedHashMap2;
                                        String string8 = cursor.getString(2);
                                        if (i.b(string2, string6) && i.b(string3, string7) && h.a(string4, string8)) {
                                            z10 = false;
                                            i10 = i12 + 1;
                                            if (i10 < count && cursor.moveToPosition(i10)) {
                                                string = cursor.getString(0);
                                                String string9 = cursor.getString(1);
                                                String string10 = cursor.getString(2);
                                                if (i.b(string2, string) && i.b(string3, string9) && h.a(string4, string10)) {
                                                    z11 = false;
                                                    arrayList.add(new j(string2, string3, string4, j10, string5, z10, i13, z11));
                                                }
                                            }
                                            z11 = true;
                                            arrayList.add(new j(string2, string3, string4, j10, string5, z10, i13, z11));
                                        }
                                    } else {
                                        linkedHashMap = linkedHashMap2;
                                    }
                                    z10 = true;
                                    i10 = i12 + 1;
                                    if (i10 < count) {
                                        string = cursor.getString(0);
                                        String string92 = cursor.getString(1);
                                        String string102 = cursor.getString(2);
                                        if (i.b(string2, string)) {
                                            z11 = false;
                                            arrayList.add(new j(string2, string3, string4, j10, string5, z10, i13, z11));
                                        }
                                    }
                                    z11 = true;
                                    arrayList.add(new j(string2, string3, string4, j10, string5, z10, i13, z11));
                                }
                                i12++;
                                linkedHashMap2 = linkedHashMap;
                                i11 = 0;
                            }
                        }
                    } finally {
                    }
                }
                kotlin.io.a.a(query, null);
            } catch (Throwable th) {
                H7.b.c("GroupBrowseListRepository", "queryAccountGroups exception: " + th);
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super List<j>> cVar) {
        return ((GroupBrowseListRepository$queryAccountGroups$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
