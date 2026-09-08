package com.android.contacts.group.model;

import android.database.Cursor;
import com.android.contacts.ContactsApplication;
import com.android.contacts.group.l;
import com.android.contacts.group.model.SmartGroupRepository;
import com.customize.contacts.activities.SmartGroupActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.a;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SmartGroupRepository.kt */
@InterfaceC1470d(c = "com.android.contacts.group.model.SmartGroupRepository$querySmartGroups$2", f = "SmartGroupRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SmartGroupRepository$querySmartGroups$2 extends SuspendLambda implements p<E, c<? super List<SmartGroupActivity.c>>, Object> {
    final /* synthetic */ int $groupMode;
    int label;
    final /* synthetic */ SmartGroupRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartGroupRepository$querySmartGroups$2(SmartGroupRepository smartGroupRepository, int i10, c<? super SmartGroupRepository$querySmartGroups$2> cVar) {
        super(2, cVar);
        this.this$0 = smartGroupRepository;
        this.$groupMode = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new SmartGroupRepository$querySmartGroups$2(this.this$0, this.$groupMode, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SmartGroupRepository.b b10;
        Cursor cursor;
        SmartGroupActivity.c cVar;
        SmartGroupActivity.c cVar2;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b("SmartGroupRepository", "querySmartGroups");
            ArrayList arrayList = new ArrayList();
            ContactsApplication h10 = ContactsApplication.h();
            b10 = this.this$0.b(this.$groupMode);
            try {
                Cursor query = h10.getContentResolver().query(b10.e(), b10.b(), b10.c(), b10.d(), b10.a());
                int i10 = this.$groupMode;
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            cursor = query;
                        } else {
                            cursor = null;
                        }
                        if (cursor != null) {
                            int count = cursor.getCount();
                            for (int i11 = 0; i11 < count; i11++) {
                                cursor.moveToPosition(i11);
                                if (2 == i10) {
                                    if (l.g()) {
                                        i.e(cursor, "this");
                                        cVar2 = l.b(cursor);
                                        arrayList.add(cVar2);
                                    } else {
                                        String string = cursor.getString(2);
                                        i.e(string, "getString(LOCATION_CITYNAME_INDEX)");
                                        cVar = new SmartGroupActivity.c(string, cursor.getInt(3), cursor.getString(1), i10);
                                    }
                                } else {
                                    String string2 = cursor.getString(1);
                                    i.e(string2, "getString(COMPANY_TITLE_INDEX)");
                                    cVar = new SmartGroupActivity.c(string2, cursor.getInt(2), cursor.getString(0), i10);
                                }
                                cVar2 = cVar;
                                arrayList.add(cVar2);
                            }
                        }
                    } finally {
                    }
                }
                a.a(query, null);
            } catch (Throwable th) {
                H7.b.c("SmartGroupRepository", "querySmartGroups Exception: " + th);
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super List<SmartGroupActivity.c>> cVar) {
        return ((SmartGroupRepository$querySmartGroups$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
