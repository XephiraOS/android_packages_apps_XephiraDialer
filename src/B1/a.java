package B1;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.VoicemailContract;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.voicemail.impl.Voicemail;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t1.C1580a;

/* compiled from: VoicemailsQueryHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f224d = {BreenoCallContract.BaseColumns._ID, "source_data", "is_read", "deleted", "transcription"};

    /* renamed from: a, reason: collision with root package name */
    public Context f225a;

    /* renamed from: b, reason: collision with root package name */
    public ContentResolver f226b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f227c;

    public a(Context context) {
        this.f225a = context;
        this.f226b = context.getContentResolver();
        this.f227c = VoicemailContract.Voicemails.buildSourceUri(this.f225a.getPackageName());
    }

    public int a(List<Voicemail> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb.append(",");
            }
            sb.append(list.get(i10).h());
        }
        return this.f226b.delete(VoicemailContract.Voicemails.CONTENT_URI, String.format("_id IN (%s)", sb.toString()), null);
    }

    public void b(Voicemail voicemail) {
        this.f226b.delete(VoicemailContract.Voicemails.CONTENT_URI, "_id=? AND archived= 0", new String[]{Long.toString(voicemail.h())});
    }

    public List<Voicemail> c(PhoneAccountHandle phoneAccountHandle) {
        return e(phoneAccountHandle, null);
    }

    public List<Voicemail> d(PhoneAccountHandle phoneAccountHandle) {
        return e(phoneAccountHandle, "deleted=1");
    }

    public final List<Voicemail> e(PhoneAccountHandle phoneAccountHandle, String str) {
        Cursor query = this.f226b.query(this.f227c, f224d, str, null, null);
        if (query == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                boolean z10 = false;
                long j10 = query.getLong(0);
                String string = query.getString(1);
                if (query.getInt(2) == 1) {
                    z10 = true;
                }
                arrayList.add(Voicemail.d(j10, string).d(z10).j(query.getString(4)).a());
            }
            return arrayList;
        } finally {
            query.close();
        }
    }

    public List<Voicemail> f(PhoneAccountHandle phoneAccountHandle) {
        return e(phoneAccountHandle, "dirty=1 AND deleted!=1 AND is_read=1");
    }

    public boolean g(Voicemail voicemail) {
        PhoneAccountHandle j10 = voicemail.j();
        if (j10 != null) {
            String flattenToString = j10.getComponentName().flattenToString();
            String id = j10.getId();
            String k10 = voicemail.k();
            if (flattenToString != null && id != null && k10 != null) {
                Cursor cursor = null;
                try {
                    cursor = this.f226b.query(this.f227c, f224d, "subscription_component_name=? AND subscription_id=? AND source_data=?", new String[]{flattenToString, id, k10}, null);
                    if (cursor.getCount() == 0) {
                        cursor.close();
                        return true;
                    }
                    cursor.close();
                    return false;
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
        return true;
    }

    public void h(Voicemail voicemail) {
        Uri withAppendedId = ContentUris.withAppendedId(this.f227c, voicemail.h());
        ContentValues contentValues = new ContentValues();
        contentValues.put("archived", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        this.f226b.update(withAppendedId, contentValues, null, null);
    }

    public void i(List<Voicemail> list) {
        Iterator<Voicemail> it = list.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }

    public int j(List<Voicemail> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            k(list.get(i10));
        }
        return size;
    }

    public void k(Voicemail voicemail) {
        this.f226b.update(ContentUris.withAppendedId(this.f227c, voicemail.h()), new ContentValues(), null, null);
    }

    public void l(Voicemail voicemail) {
        Uri withAppendedId = ContentUris.withAppendedId(this.f227c, voicemail.h());
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_read", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        this.f226b.update(withAppendedId, contentValues, null, null);
    }

    public List<Voicemail> m(int i10) {
        if (i10 <= 0) {
            C1580a.b("Query for remote voicemails cannot be <= 0");
        }
        Cursor query = this.f226b.query(this.f227c, f224d, "archived=0", null, "date ASC limit " + i10);
        try {
            ArrayList arrayList = new ArrayList();
            while (query != null && query.moveToNext()) {
                arrayList.add(Voicemail.d(query.getLong(0), query.getString(1)).a());
            }
            if (arrayList.size() != i10) {
                C1580a.b(String.format("voicemail count (%d) doesn't matched expected (%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(i10)));
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void n(Voicemail voicemail, String str) {
        Uri withAppendedId = ContentUris.withAppendedId(this.f227c, voicemail.h());
        ContentValues contentValues = new ContentValues();
        contentValues.put("transcription", str);
        this.f226b.update(withAppendedId, contentValues, null, null);
    }
}
