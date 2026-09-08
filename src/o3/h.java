package O3;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.customize.contacts.model.IdRecord;
import java.util.ArrayList;

/* compiled from: ContactsProcessThreadsHelper.java */
/* loaded from: classes3.dex */
public class h extends g {

    /* renamed from: o, reason: collision with root package name */
    public String f2713o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<IdRecord> f2714p;

    public h(Context context, ArrayList<IdRecord> arrayList, String str) {
        super(context);
        this.f2714p = arrayList;
        this.f2713o = str;
    }

    @Override // O3.g
    public void l() {
        s();
    }

    public final ArrayList<ContentProviderOperation> r(ArrayList<IdRecord> arrayList, String str, int i10) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        ArrayList<String> h10 = h(arrayList, i10);
        if (h10 == null) {
            return null;
        }
        int size = h10.size();
        for (int i11 = 0; i11 != size; i11++) {
            String str2 = "_id IN " + h10.get(i11);
            ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContactsContract.Contacts.CONTENT_URI);
            newUpdate.withValue("custom_ringtone", this.f2713o);
            newUpdate.withSelection(str2, null);
            arrayList2.add(newUpdate.build());
        }
        return arrayList2;
    }

    public final void s() {
        ArrayList<IdRecord> arrayList = this.f2714p;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (TextUtils.isEmpty(this.f2713o)) {
                n(3);
                this.f2702g.I(4, null, null);
                return;
            }
            this.f2702g.I(1, null, null);
            ArrayList<ContentProviderOperation> r10 = r(this.f2714p, this.f2713o, 10);
            if (r10 == null) {
                H7.b.c("ContactsProcessThread", "set ring tone fail");
                n(3);
                this.f2702g.I(4, null, null);
                return;
            }
            if (!r10.isEmpty()) {
                int size = r10.size();
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                for (int i10 = 0; i10 != size && !isInterrupted(); i10++) {
                    arrayList2.clear();
                    arrayList2.add(r10.get(i10));
                    if (d(arrayList2)) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                            return;
                        }
                    } else {
                        n(3);
                        this.f2702g.I(4, null, null);
                        return;
                    }
                }
                return;
            }
            return;
        }
        n(2);
        this.f2702g.I(4, null, null);
    }
}
