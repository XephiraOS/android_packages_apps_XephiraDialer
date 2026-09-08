package n1;

import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: AccountTypeWithDataSet.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f35592c = {BreenoCallContract.BaseColumns._ID};

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f35593d = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("limit", OplusPhoneUtils.DeviceState.LOCK_DEVICE).build();

    /* renamed from: a, reason: collision with root package name */
    public final String f35594a;

    /* renamed from: b, reason: collision with root package name */
    public final String f35595b;

    public d(String str, String str2) {
        this.f35594a = TextUtils.isEmpty(str) ? null : str;
        this.f35595b = TextUtils.isEmpty(str2) ? null : str2;
    }

    public static d a(String str, String str2) {
        return new d(str, str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!com.google.common.base.h.a(this.f35594a, dVar.f35594a) || !com.google.common.base.h.a(this.f35595b, dVar.f35595b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f35594a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        String str2 = this.f35595b;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "[" + this.f35594a + "/" + this.f35595b + "]";
    }
}
