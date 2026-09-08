package com.oplus.contacts.list.cursorloader;

import G7.c;
import W.b;
import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor.RecyclerViewScrollStateMonitor;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m1.C1322s;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: ContactsMainListCursorLoader.kt */
/* loaded from: classes3.dex */
public final class ContactsMainListCursorLoader extends b {

    /* renamed from: B, reason: collision with root package name */
    public static final a f27894B = new a(null);

    /* renamed from: C, reason: collision with root package name */
    public static final String[] f27895C = {BreenoCallContract.BaseColumns._ID, "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization"};

    /* renamed from: D, reason: collision with root package name */
    public static final String[] f27896D = {BreenoCallContract.BaseColumns._ID, "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization", "phonenumber"};

    /* renamed from: E, reason: collision with root package name */
    public static final String[] f27897E = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization"};

    /* renamed from: F, reason: collision with root package name */
    public static final String[] f27898F = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization", "phonenumber"};

    /* renamed from: A, reason: collision with root package name */
    public boolean f27899A;

    /* renamed from: x, reason: collision with root package name */
    public final Context f27900x;

    /* renamed from: y, reason: collision with root package name */
    public final com.oplus.contacts.list.settings.a f27901y;

    /* renamed from: z, reason: collision with root package name */
    public final RecyclerViewScrollStateMonitor f27902z;

    /* compiled from: ContactsMainListCursorLoader.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListCursorLoader(Context ctx, com.oplus.contacts.list.settings.a contactListSettingData, RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor) {
        super(ctx);
        i.f(ctx, "ctx");
        i.f(contactListSettingData, "contactListSettingData");
        this.f27900x = ctx;
        this.f27901y = contactListSettingData;
        this.f27902z = recyclerViewScrollStateMonitor;
        H7.b.b("ContactsMainListCursorLoader", "scrollStateMonitor:" + recyclerViewScrollStateMonitor);
        T(Z(contactListSettingData));
        P(V(contactListSettingData));
        Q(W(contactListSettingData));
        R(X(contactListSettingData));
        S(Y(contactListSettingData));
        this.f27899A = true;
    }

    private final Cursor a0() {
        return c.e(this.f27900x.getContentResolver(), ContactsContract.Contacts.CONTENT_URI, M(), "starred=?", new String[]{OplusPhoneUtils.DeviceState.LOCK_DEVICE}, S0.a.f3371a + " ASC");
    }

    private final void b0(Cursor cursor, Cursor cursor2, Cursor cursor3) {
        int[] intArray;
        String[] stringArray;
        if (cursor2 == null) {
            H7.b.i("ContactsMainListCursorLoader", "contactsCursor is null");
            return;
        }
        Bundle extras = cursor2.getExtras();
        if (cursor != null && cursor.getCount() > 0 && extras != null) {
            if (extras.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES") && (stringArray = extras.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES")) != null) {
                String[] strArr = new String[stringArray.length + 1];
                strArr[0] = "*";
                System.arraycopy(stringArray, 0, strArr, 1, stringArray.length);
                extras.putStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES", strArr);
            }
            if (extras.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS") && (intArray = extras.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS")) != null) {
                int[] iArr = new int[intArray.length + 1];
                iArr[0] = cursor.getCount();
                System.arraycopy(intArray, 0, iArr, 1, intArray.length);
                extras.putIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS", iArr);
            }
        }
        cursor3.setExtras(extras);
    }

    @Override // W.b, W.c
    /* renamed from: L */
    public void f(final Cursor cursor) {
        RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor = this.f27902z;
        if (recyclerViewScrollStateMonitor != null) {
            recyclerViewScrollStateMonitor.e(new InterfaceC1637a<q>() { // from class: com.oplus.contacts.list.cursorloader.ContactsMainListCursorLoader$deliverResult$1
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
                    super/*W.b*/.f(cursor);
                }
            });
        } else {
            super.f(cursor);
        }
    }

    @Override // W.b, W.a
    /* renamed from: N */
    public Cursor I() {
        if (this.f27899A) {
            ArrayList arrayList = new ArrayList();
            Cursor a02 = a0();
            if (a02 != null) {
                arrayList.add(a02);
            }
            Cursor c02 = c0();
            if (c02 != null) {
                arrayList.add(c02);
            } else {
                Thread.sleep(1000L);
                c02 = c0();
                if (c02 != null) {
                    arrayList.add(c02);
                }
            }
            if (!arrayList.isEmpty()) {
                MergeCursor mergeCursor = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
                b0(a02, c02, mergeCursor);
                return new C1322s(mergeCursor);
            }
            H7.b.c("ContactsMainListCursorLoader", "loadInBackground: null cursor!");
            return null;
        }
        return c0();
    }

    public final String[] V(com.oplus.contacts.list.settings.a aVar) {
        if (aVar.g() == 1) {
            if (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) {
                return f27896D;
            }
            return f27895C;
        }
        if (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) {
            return f27898F;
        }
        return f27897E;
    }

    public final String W(com.oplus.contacts.list.settings.a aVar) {
        StringBuilder sb = new StringBuilder();
        int h10 = aVar.h();
        if (h10 != -6) {
            if (h10 != -5) {
                if (h10 != -4) {
                    if (h10 != -3) {
                        if (h10 != -2) {
                            if (h10 == 0) {
                                sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                                if (aVar.j()) {
                                    sb.append(" AND has_phone_number=1");
                                }
                            }
                        } else {
                            sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                            if (aVar.j()) {
                                sb.append(" AND has_phone_number=1");
                            }
                        }
                    } else {
                        sb.append("in_visible_group=1");
                        if (aVar.j()) {
                            sb.append(" AND has_phone_number=1");
                        }
                    }
                } else {
                    sb.append("starred!=0");
                }
            } else {
                sb.append("has_phone_number=1");
            }
        } else {
            sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        }
        if (sb.length() > 0) {
            sb.append(" AND starred=0");
        }
        String sb2 = sb.toString();
        i.e(sb2, "selection.toString()");
        return sb2;
    }

    public final String[] X(com.oplus.contacts.list.settings.a aVar) {
        return new String[0];
    }

    public final String Y(com.oplus.contacts.list.settings.a aVar) {
        if (aVar.k() == 1) {
            return "sort_key";
        }
        return "sort_key_alt";
    }

    public final Uri Z(com.oplus.contacts.list.settings.a aVar) {
        Uri.Builder appendQueryParameter = ContactsContract.Contacts.CONTENT_URI.buildUpon().appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true");
        Integer valueOf = Integer.valueOf(aVar.h());
        int intValue = valueOf.intValue();
        if (intValue == -3 || intValue == -6) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue2 = valueOf.intValue();
            appendQueryParameter.appendQueryParameter("directory", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            if (intValue2 == 0) {
                appendQueryParameter.appendQueryParameter("account_name", aVar.c());
                appendQueryParameter.appendQueryParameter("account_type", aVar.d());
                String e10 = aVar.e();
                if (e10 != null && e10.length() != 0) {
                    appendQueryParameter.appendQueryParameter("data_set", aVar.e());
                }
            }
        }
        Uri build = appendQueryParameter.build();
        i.e(build, "uriBuild.build()");
        return build;
    }

    public final Cursor c0() {
        Object b10;
        C1322s c1322s;
        Object obj = null;
        try {
            Result.a aVar = Result.f34166a;
            Cursor I10 = super.I();
            if (I10 != null) {
                c1322s = new C1322s(I10);
            } else {
                c1322s = null;
            }
            b10 = Result.b(c1322s);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (Cursor) obj;
    }
}
