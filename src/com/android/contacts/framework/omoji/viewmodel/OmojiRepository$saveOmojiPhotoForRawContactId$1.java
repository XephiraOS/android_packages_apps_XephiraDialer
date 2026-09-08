package com.android.contacts.framework.omoji.viewmodel;

import R0.d;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OmojiRepository.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.viewmodel.OmojiRepository$saveOmojiPhotoForRawContactId$1", f = "OmojiRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OmojiRepository$saveOmojiPhotoForRawContactId$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isUserProfile;
    final /* synthetic */ Bundle $omojiData;
    final /* synthetic */ long $rawContactId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OmojiRepository$saveOmojiPhotoForRawContactId$1(boolean z10, long j10, Bundle bundle, Context context, c<? super OmojiRepository$saveOmojiPhotoForRawContactId$1> cVar) {
        super(2, cVar);
        this.$isUserProfile = z10;
        this.$rawContactId = j10;
        this.$omojiData = bundle;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OmojiRepository$saveOmojiPhotoForRawContactId$1(this.$isUserProfile, this.$rawContactId, this.$omojiData, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Uri uri;
        Object b10;
        Object b11;
        Object b12;
        Cursor cursor;
        ContentResolver contentResolver;
        Object b13;
        ContentResolver contentResolver2;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (this.$isUserProfile) {
                uri = ContactsContract.Profile.CONTENT_URI.buildUpon().appendPath("data").build();
                i.e(uri, "{\n                Contac…a\").build()\n            }");
            } else {
                uri = ContactsContract.Data.CONTENT_URI;
                i.e(uri, "{\n                Contac…CONTENT_URI\n            }");
            }
            String[] strArr = {String.valueOf(this.$rawContactId), "vnd.android.cursor.item/omoji_photo"};
            Object obj2 = null;
            if (this.$omojiData == null) {
                Context context = this.$context;
                try {
                    Result.a aVar = Result.f34166a;
                    if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
                        obj2 = C1467a.d(contentResolver2.delete(d.a(uri), "raw_contact_id =?  AND mimetype=?", strArr));
                    }
                    b13 = Result.b(obj2);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b13 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b13);
                if (d10 != null) {
                    H7.b.c("OmojiRepository", d10.getMessage());
                }
                return q.f35511a;
            }
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Context context2 = this.$context;
            try {
                Result.a aVar3 = Result.f34166a;
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
                    cursor = contentResolver.query(uri, new String[]{BreenoCallContract.BaseColumns._ID}, "raw_contact_id =?  AND mimetype=?", strArr, null);
                } else {
                    cursor = null;
                }
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ref$IntRef.element = cursor.getInt(0);
                        }
                    } finally {
                    }
                }
                q qVar = q.f35511a;
                kotlin.io.a.a(cursor, null);
                b10 = Result.b(q.f35511a);
            } catch (Throwable th2) {
                Result.a aVar4 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th2));
            }
            Throwable d11 = Result.d(b10);
            if (d11 != null) {
                H7.b.c("OmojiRepository", d11.getMessage());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("raw_contact_id", C1467a.e(this.$rawContactId));
            contentValues.put("mimetype", "vnd.android.cursor.item/omoji_photo");
            contentValues.put("data1", String.valueOf(this.$omojiData.getParcelable("output_uri")));
            contentValues.put("data2", this.$omojiData.getString("extra_data"));
            if (ref$IntRef.element >= 0) {
                Context context3 = this.$context;
                if (context3 != null) {
                    try {
                        ContentResolver contentResolver3 = context3.getContentResolver();
                        if (contentResolver3 != null) {
                            obj2 = C1467a.d(contentResolver3.update(d.a(uri), contentValues, "_id = " + ref$IntRef.element, null));
                        }
                    } catch (Throwable th3) {
                        Result.a aVar5 = Result.f34166a;
                        b12 = Result.b(kotlin.b.a(th3));
                    }
                }
                b12 = Result.b(obj2);
                Throwable d12 = Result.d(b12);
                if (d12 != null) {
                    H7.b.c("OmojiRepository", d12.getMessage());
                }
            } else {
                Context context4 = this.$context;
                if (context4 != null) {
                    try {
                        ContentResolver contentResolver4 = context4.getContentResolver();
                        if (contentResolver4 != null) {
                            obj2 = contentResolver4.insert(d.a(uri), contentValues);
                        }
                    } catch (Throwable th4) {
                        Result.a aVar6 = Result.f34166a;
                        b11 = Result.b(kotlin.b.a(th4));
                    }
                }
                b11 = Result.b(obj2);
                Throwable d13 = Result.d(b11);
                if (d13 != null) {
                    H7.b.c("OmojiRepository", d13.getMessage());
                }
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OmojiRepository$saveOmojiPhotoForRawContactId$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
