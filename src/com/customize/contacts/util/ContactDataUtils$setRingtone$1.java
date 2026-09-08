package com.customize.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.customize.contacts.util.ContactDataUtils;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import p9.InterfaceC1470d;

/* compiled from: ContactDataUtils.kt */
@InterfaceC1470d(c = "com.customize.contacts.util.ContactDataUtils$setRingtone$1", f = "ContactDataUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactDataUtils$setRingtone$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ ContactDataUtils.a $callBack;
    final /* synthetic */ Uri $contactUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $ringtone;
    int label;

    /* compiled from: ContactDataUtils.kt */
    @InterfaceC1470d(c = "com.customize.contacts.util.ContactDataUtils$setRingtone$1$1", f = "ContactDataUtils.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.customize.contacts.util.ContactDataUtils$setRingtone$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ ContactDataUtils.a $callBack;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContactDataUtils.a aVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$callBack = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$callBack, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                ContactDataUtils.a aVar = this.$callBack;
                if (aVar != null) {
                    aVar.a();
                }
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactDataUtils$setRingtone$1(String str, Context context, Uri uri, ContactDataUtils.a aVar, kotlin.coroutines.c<? super ContactDataUtils$setRingtone$1> cVar) {
        super(2, cVar);
        this.$ringtone = str;
        this.$context = context;
        this.$contactUri = uri;
        this.$callBack = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactDataUtils$setRingtone$1(this.$ringtone, this.$context, this.$contactUri, this.$callBack, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("custom_ringtone", this.$ringtone);
            G7.c.g(this.$context.getContentResolver(), R0.d.a(this.$contactUri), contentValues, null, null);
            C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.c(), null, new AnonymousClass1(this.$callBack, null), 2, null);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactDataUtils$setRingtone$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
