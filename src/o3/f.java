package O3;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import com.android.contacts.model.Account;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.b0;
import java.util.ArrayList;

/* compiled from: ContactsProcessThreadsHelper.java */
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: o, reason: collision with root package name */
    public int f2687o;

    /* renamed from: p, reason: collision with root package name */
    public Account f2688p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<IdRecord> f2689q;

    /* renamed from: r, reason: collision with root package name */
    public Uri f2690r;

    /* compiled from: ContactsProcessThreadsHelper.java */
    /* loaded from: classes3.dex */
    public class a extends AsyncTask<Integer, Integer, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public ContentResolver f2691a;

        /* renamed from: b, reason: collision with root package name */
        public StringBuilder[] f2692b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2693c;

        public final void a(int i10, boolean z10) {
            String sb;
            int i11 = i10 / f.this.f2687o;
            int i12 = (i10 % f.this.f2687o) + 1;
            int i13 = f.this.f2687o;
            if (z10 || i12 < f.this.f2687o) {
                i13 = i12;
            }
            if (z10) {
                String[] split = this.f2692b[i11].toString().split(",");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(split[0]);
                for (int i14 = 1; i14 < i12; i14++) {
                    sb2.append(",");
                    sb2.append(split[i14]);
                }
                sb = "_id IN (" + sb2.toString() + ")";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("_id IN (");
                StringBuilder sb4 = this.f2692b[i11];
                sb3.append(sb4.replace(sb4.length() - 1, this.f2692b[i11].length(), ")").toString());
                sb = sb3.toString();
            }
            try {
                if (this.f2691a.delete(f.this.f2690r, sb, null) == i13) {
                    return;
                }
            } catch (Exception e10) {
                H7.b.c("ContactsProcessThread", "Exception e: " + e10);
            }
            H7.b.c("ContactsProcessThread", "delete rawId error!");
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Integer... numArr) {
            a(numArr[0].intValue(), this.f2693c);
            return null;
        }

        public a(Context context, StringBuilder[] sbArr, boolean z10) {
            this.f2691a = context.getContentResolver();
            this.f2692b = sbArr;
            this.f2693c = z10;
        }
    }

    public f(Context context, ArrayList<IdRecord> arrayList) {
        super(context);
        this.f2687o = 5;
        this.f2690r = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        this.f2689q = arrayList;
    }

    public static void t(StringBuilder sb, String str) {
        if (str != null) {
            sb.append(str);
        }
    }

    @Override // O3.g
    public void l() {
        if (M3.c.t(this.f2688p)) {
            v();
        } else {
            u();
        }
        C0798i.b(this.f2696a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02d6, code lost:
    
        if (r15 != r7) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d8, code lost:
    
        w(r8, r15, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02e3, code lost:
    
        H7.b.c("ContactsProcessThread", "delete simCard error! simId = " + r4[r15] + ", simUri = " + r5[r15]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0307, code lost:
    
        if ((r15 % r23.f2687o) == 0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0309, code lost:
    
        w(r8, r15 - 1, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x030e, code lost:
    
        n(7);
        r23.f2702g.I(4, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x031e, code lost:
    
        if ((r15 % r23.f2687o) == 0) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0320, code lost:
    
        w(r8, r15 - 1, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0259, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0257, code lost:
    
        if (r7 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0297, code lost:
    
        if (r7 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x029a, code lost:
    
        r15 = r3;
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x029d, code lost:
    
        if (r15 >= r9) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02a1, code lost:
    
        if (r23.f2700e != false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02a7, code lost:
    
        if (isInterrupted() != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02a9, code lost:
    
        m(r0);
        r12 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02b9, code lost:
    
        if (com.customize.contacts.util.b0.g(r23.f2696a, r12, r4[r15], r5[r15]) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02bb, code lost:
    
        a(1);
        r23.f2702g.I(2, null, null);
        r6 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02cc, code lost:
    
        if ((r6 % r23.f2687o) != 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ce, code lost:
    
        w(r8, r15, r3);
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02db, code lost:
    
        r0 = r0 + 1;
        r15 = r6;
        r20 = r7;
        r16 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02d4, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0328  */
    /* JADX WARN: Type inference failed for: r0v31, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u() {
        /*
            Method dump skipped, instructions count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O3.f.u():void");
    }

    public final void v() {
        ArrayList<IdRecord> arrayList = this.f2689q;
        if (arrayList != null && !arrayList.isEmpty()) {
            q(this.f2689q.size());
            this.f2702g.I(1, null, null);
            int size = this.f2689q.size();
            ContentResolver contentResolver = this.f2696a.getContentResolver();
            if (size > 0) {
                Uri I02 = b0.I0(this.f2696a, b0.K(this.f2696a, this.f2688p.f16941a));
                int i10 = 0;
                int i11 = 0;
                while (i10 < size && !this.f2700e && !isInterrupted()) {
                    m(i11);
                    if (b0.g(this.f2696a, contentResolver, this.f2689q.get(i10).b(), I02)) {
                        a(1);
                        this.f2702g.I(2, null, null);
                        i10++;
                        i11++;
                    } else {
                        H7.b.c("ContactsProcessThread", "delete simCard error! simId = " + this.f2689q.get(i10).b() + ", simUri = " + I02);
                        n(7);
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

    public final void w(StringBuilder[] sbArr, int i10, boolean z10) {
        new a(this.f2696a, sbArr, z10).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Integer.valueOf(i10));
    }

    public final int x(int i10) {
        return 60;
    }

    public f(Context context, Account account, ArrayList<IdRecord> arrayList) {
        super(context);
        this.f2687o = 5;
        this.f2690r = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        this.f2688p = account;
        this.f2689q = arrayList;
    }
}
