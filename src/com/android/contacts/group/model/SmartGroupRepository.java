package com.android.contacts.group.model;

import R0.d;
import android.database.Cursor;
import android.net.Uri;
import com.android.contacts.ContactsApplication;
import com.android.contacts.group.l;
import com.customize.contacts.activities.SmartGroupActivity;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;

/* compiled from: SmartGroupRepository.kt */
/* loaded from: classes.dex */
public final class SmartGroupRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16700a = new a(null);

    /* compiled from: SmartGroupRepository.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SmartGroupRepository.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Uri f16701a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f16702b;

        /* renamed from: c, reason: collision with root package name */
        public String f16703c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f16704d;

        /* renamed from: e, reason: collision with root package name */
        public String f16705e;

        public final String a() {
            return this.f16705e;
        }

        public final String[] b() {
            return this.f16702b;
        }

        public final String c() {
            return this.f16703c;
        }

        public final String[] d() {
            return this.f16704d;
        }

        public final Uri e() {
            Uri uri = this.f16701a;
            if (uri != null) {
                return uri;
            }
            i.q("uri");
            return null;
        }

        public final void f(String[] strArr) {
            this.f16704d = strArr;
        }

        public final void g(Uri uri) {
            i.f(uri, "<set-?>");
            this.f16701a = uri;
        }
    }

    public final b b(int i10) {
        Uri uri;
        Cursor cursor;
        b bVar = new b();
        if (i10 == 2) {
            l.a();
            if (l.g()) {
                uri = l.d();
            } else {
                uri = d.f3227n;
            }
            i.e(uri, "{\n            LargeConta…I\n            }\n        }");
        } else {
            uri = d.f3225l;
            i.e(uri, "{\n            ContactsUr…MPANY_GROUP_URI\n        }");
        }
        bVar.g(uri);
        if (i10 == 2) {
            if (l.g()) {
                bVar.f(l.c());
            } else {
                String[] strArr = new String[0];
                try {
                    Cursor query = ContactsApplication.h().getContentResolver().query(d.f3226m, R0.b.a(), null, null, null);
                    if (query != null) {
                        try {
                            if (query.getCount() > 0) {
                                cursor = query;
                            } else {
                                cursor = null;
                            }
                            if (cursor != null) {
                                cursor.moveToPosition(-1);
                                strArr = new String[cursor.getCount() * 6];
                                for (int i11 = 0; i11 < cursor.getCount() && cursor.moveToNext(); i11++) {
                                    int i12 = i11 * 6;
                                    strArr[i12] = cursor.getString(0);
                                    strArr[i12 + 1] = cursor.getString(1);
                                    strArr[i12 + 2] = cursor.getString(2);
                                    strArr[i12 + 3] = cursor.getString(3);
                                    strArr[i12 + 4] = cursor.getString(4);
                                    strArr[i12 + 5] = cursor.getString(5);
                                }
                            }
                        } finally {
                        }
                    }
                    kotlin.io.a.a(query, null);
                } catch (Throwable th) {
                    H7.b.c("SmartGroupRepository", "getWorkArgs exception: " + th);
                }
                bVar.f(strArr);
            }
        }
        return bVar;
    }

    public final Object c(int i10, c<? super List<SmartGroupActivity.c>> cVar) {
        return C1244g.g(S.b(), new SmartGroupRepository$querySmartGroups$2(this, i10, null), cVar);
    }
}
