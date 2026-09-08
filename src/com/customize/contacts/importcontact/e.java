package com.customize.contacts.importcontact;

import android.content.Context;
import com.android.contacts.model.Account;
import com.customize.contacts.util.b0;
import java.util.ArrayList;

/* compiled from: CsvImportRunnable.java */
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: i, reason: collision with root package name */
    public H3.a f21428i;

    /* renamed from: j, reason: collision with root package name */
    public I3.d f21429j;

    /* renamed from: k, reason: collision with root package name */
    public String f21430k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<I3.b> f21431l;

    public e(Context context, String str, Account account) {
        super(context, str, account);
        this.f21431l = new ArrayList<>();
    }

    @Override // com.customize.contacts.importcontact.c
    public void d() {
        this.f21415g = true;
        if (H7.a.b()) {
            H7.b.b("CsvImportRunnable", "----------cancel called---------");
        }
    }

    @Override // com.customize.contacts.importcontact.c
    public int f() {
        if (H7.a.b()) {
            H7.b.b("CsvImportRunnable", "----------Thread start run ---------");
        }
        try {
            H3.a aVar = new H3.a(this.f21414f);
            this.f21428i = aVar;
            if (aVar.e() == 0) {
                return 3;
            }
            String[] g10 = this.f21428i.g();
            if (g10 == null) {
                if (H7.a.b()) {
                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                }
                I3.d dVar = this.f21429j;
                if (dVar != null) {
                    dVar.a();
                    this.f21429j.h();
                }
                H3.a aVar2 = this.f21428i;
                if (aVar2 != null) {
                    aVar2.b();
                }
                ArrayList<I3.b> arrayList = this.f21431l;
                if (arrayList != null) {
                    arrayList.clear();
                    this.f21431l.trimToSize();
                    this.f21431l = null;
                }
                return 3;
            }
            I3.d m10 = I3.d.m(this.f21410b, this.f21428i.h(), g10);
            this.f21429j = m10;
            m10.B(g10);
            this.f21429j.A(this.f21409a);
            if (!this.f21428i.i()) {
                if (H7.a.b()) {
                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                }
                I3.d dVar2 = this.f21429j;
                if (dVar2 != null) {
                    dVar2.a();
                    this.f21429j.h();
                }
                H3.a aVar3 = this.f21428i;
                if (aVar3 != null) {
                    aVar3.b();
                }
                ArrayList<I3.b> arrayList2 = this.f21431l;
                if (arrayList2 != null) {
                    arrayList2.clear();
                    this.f21431l.trimToSize();
                    this.f21431l = null;
                }
                return 888;
            }
            String[] f10 = this.f21428i.f();
            int i10 = 0;
            while (f10 != null) {
                if (this.f21415g) {
                    if (H7.a.b()) {
                        H7.b.b("CsvImportRunnable", "----------parsing count canceled---------");
                    }
                    if (H7.a.b()) {
                        H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                    }
                    I3.d dVar3 = this.f21429j;
                    if (dVar3 != null) {
                        dVar3.a();
                        this.f21429j.h();
                    }
                    H3.a aVar4 = this.f21428i;
                    if (aVar4 != null) {
                        aVar4.b();
                    }
                    ArrayList<I3.b> arrayList3 = this.f21431l;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                        this.f21431l.trimToSize();
                        this.f21431l = null;
                    }
                    return 888;
                }
                if (!this.f21429j.w(f10)) {
                    f10 = this.f21428i.f();
                } else {
                    i10++;
                    this.f21429j.y();
                    f10 = this.f21428i.f();
                }
            }
            if (H7.a.b()) {
                H7.b.b("CsvImportRunnable", "" + i10 + " contacts contained in this CSV file.");
            }
            b(i10);
            if (this.f21429j.v()) {
                if (H7.a.b()) {
                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                }
                I3.d dVar4 = this.f21429j;
                if (dVar4 != null) {
                    dVar4.a();
                    this.f21429j.h();
                }
                H3.a aVar5 = this.f21428i;
                if (aVar5 != null) {
                    aVar5.b();
                }
                ArrayList<I3.b> arrayList4 = this.f21431l;
                if (arrayList4 != null) {
                    arrayList4.clear();
                    this.f21431l.trimToSize();
                    this.f21431l = null;
                    return 4;
                }
                return 4;
            }
            if (i10 == 0 && this.f21429j.v()) {
                if (H7.a.b()) {
                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                }
                I3.d dVar5 = this.f21429j;
                if (dVar5 != null) {
                    dVar5.a();
                    this.f21429j.h();
                }
                H3.a aVar6 = this.f21428i;
                if (aVar6 != null) {
                    aVar6.b();
                }
                ArrayList<I3.b> arrayList5 = this.f21431l;
                if (arrayList5 != null) {
                    arrayList5.clear();
                    this.f21431l.trimToSize();
                    this.f21431l = null;
                }
                return 0;
            }
            if (!this.f21428i.i()) {
                H7.b.c("CsvImportRunnable", "Can't move to the first record.");
                if (H7.a.b()) {
                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                }
                I3.d dVar6 = this.f21429j;
                if (dVar6 != null) {
                    dVar6.a();
                    this.f21429j.h();
                }
                H3.a aVar7 = this.f21428i;
                if (aVar7 != null) {
                    aVar7.b();
                }
                ArrayList<I3.b> arrayList6 = this.f21431l;
                if (arrayList6 != null) {
                    arrayList6.clear();
                    this.f21431l.trimToSize();
                    this.f21431l = null;
                }
                return 888;
            }
            int[] iArr = new int[2];
            this.f21429j.y();
            String[] f11 = this.f21428i.f();
            while (true) {
                if (f11 == null) {
                    break;
                }
                if (e()) {
                    this.f21413e = 10;
                } else {
                    this.f21413e = 60;
                }
                if (this.f21415g) {
                    if (H7.a.b()) {
                        H7.b.b("CsvImportRunnable", "----------importing contacts canceled---------");
                    }
                } else if (!this.f21429j.w(f11)) {
                    f11 = this.f21428i.f();
                } else {
                    l();
                    if (this.f21411c) {
                        if (k(iArr)) {
                            a(this.f21430k, 1);
                            int i11 = iArr[0];
                            if (i11 == 1 || i11 == 2) {
                                c(iArr[1]);
                                iArr[1] = 0;
                            }
                            f11 = this.f21428i.f();
                        } else {
                            c(iArr[1]);
                            if (b0.N(this.f21410b, this.f21409a.f16941a) == -1) {
                                if (H7.a.b()) {
                                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                                }
                                I3.d dVar7 = this.f21429j;
                                if (dVar7 != null) {
                                    dVar7.a();
                                    this.f21429j.h();
                                }
                                H3.a aVar8 = this.f21428i;
                                if (aVar8 != null) {
                                    aVar8.b();
                                }
                                ArrayList<I3.b> arrayList7 = this.f21431l;
                                if (arrayList7 != null) {
                                    arrayList7.clear();
                                    this.f21431l.trimToSize();
                                    this.f21431l = null;
                                    return 12;
                                }
                                return 12;
                            }
                            if (b0.r0(this.f21410b, this.f21409a.f16941a)) {
                                if (H7.a.b()) {
                                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                                }
                                I3.d dVar8 = this.f21429j;
                                if (dVar8 != null) {
                                    dVar8.a();
                                    this.f21429j.h();
                                }
                                H3.a aVar9 = this.f21428i;
                                if (aVar9 != null) {
                                    aVar9.b();
                                }
                                ArrayList<I3.b> arrayList8 = this.f21431l;
                                if (arrayList8 != null) {
                                    arrayList8.clear();
                                    this.f21431l.trimToSize();
                                    this.f21431l = null;
                                    return 8;
                                }
                                return 8;
                            }
                            if (H7.a.b()) {
                                H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                            }
                            I3.d dVar9 = this.f21429j;
                            if (dVar9 != null) {
                                dVar9.a();
                                this.f21429j.h();
                            }
                            H3.a aVar10 = this.f21428i;
                            if (aVar10 != null) {
                                aVar10.b();
                            }
                            ArrayList<I3.b> arrayList9 = this.f21431l;
                            if (arrayList9 != null) {
                                arrayList9.clear();
                                this.f21431l.trimToSize();
                                this.f21431l = null;
                                return 9;
                            }
                            return 9;
                        }
                    } else {
                        I3.b n10 = this.f21429j.n();
                        if (n10 != null) {
                            this.f21431l.add(n10);
                        }
                        int size = this.f21431l.size();
                        if (size < this.f21413e) {
                            if (H7.a.b()) {
                                H7.b.b("CsvImportRunnable", "Current size :" + size + ", Continue Read Next.");
                                H7.b.b("CsvImportRunnable", "isBackground() = " + e() + "mBatchSize = " + this.f21413e);
                            }
                            f11 = this.f21428i.f();
                        } else {
                            boolean j10 = j(iArr, this.f21431l);
                            this.f21431l.clear();
                            this.f21431l.trimToSize();
                            if (H7.a.b()) {
                                H7.b.b("CsvImportRunnable", "-----saveDatabaseRecords: " + size + ", " + j10);
                            }
                            if (j10) {
                                a(null, size);
                                c(size);
                                f11 = this.f21428i.f();
                            } else {
                                if (H7.a.b()) {
                                    H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                                }
                                I3.d dVar10 = this.f21429j;
                                if (dVar10 != null) {
                                    dVar10.a();
                                    this.f21429j.h();
                                }
                                H3.a aVar11 = this.f21428i;
                                if (aVar11 != null) {
                                    aVar11.b();
                                }
                                ArrayList<I3.b> arrayList10 = this.f21431l;
                                if (arrayList10 != null) {
                                    arrayList10.clear();
                                    this.f21431l.trimToSize();
                                    this.f21431l = null;
                                }
                                return 6;
                            }
                        }
                    }
                }
            }
            if (!this.f21431l.isEmpty()) {
                boolean j11 = j(iArr, this.f21431l);
                if (H7.a.b()) {
                    H7.b.b("CsvImportRunnable", "save the last : size = " + this.f21431l.size() + ", success = " + j11);
                }
                if (j11) {
                    int size2 = this.f21431l.size();
                    a(null, size2);
                    c(size2);
                } else {
                    if (H7.a.b()) {
                        H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
                    }
                    I3.d dVar11 = this.f21429j;
                    if (dVar11 != null) {
                        dVar11.a();
                        this.f21429j.h();
                    }
                    H3.a aVar12 = this.f21428i;
                    if (aVar12 != null) {
                        aVar12.b();
                    }
                    ArrayList<I3.b> arrayList11 = this.f21431l;
                    if (arrayList11 != null) {
                        arrayList11.clear();
                        this.f21431l.trimToSize();
                        this.f21431l = null;
                    }
                    return 6;
                }
            }
            if (H7.a.b()) {
                H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
            }
            I3.d dVar12 = this.f21429j;
            if (dVar12 != null) {
                dVar12.a();
                this.f21429j.h();
            }
            H3.a aVar13 = this.f21428i;
            if (aVar13 != null) {
                aVar13.b();
            }
            ArrayList<I3.b> arrayList12 = this.f21431l;
            if (arrayList12 != null) {
                arrayList12.clear();
                this.f21431l.trimToSize();
                this.f21431l = null;
            }
            return 888;
        } finally {
            if (H7.a.b()) {
                H7.b.b("CsvImportRunnable", "--------------finally clear----------------");
            }
            I3.d dVar13 = this.f21429j;
            if (dVar13 != null) {
                dVar13.a();
                this.f21429j.h();
            }
            H3.a aVar14 = this.f21428i;
            if (aVar14 != null) {
                aVar14.b();
            }
            ArrayList<I3.b> arrayList13 = this.f21431l;
            if (arrayList13 != null) {
                arrayList13.clear();
                this.f21431l.trimToSize();
                this.f21431l = null;
            }
        }
    }

    public final boolean i(int[] iArr) {
        boolean z10 = this.f21429j.z();
        iArr[0] = this.f21429j.q();
        iArr[1] = this.f21429j.l();
        this.f21430k = this.f21429j.o();
        return z10;
    }

    public final boolean j(int[] iArr, ArrayList<I3.b> arrayList) {
        boolean j10 = this.f21429j.j(arrayList);
        iArr[0] = this.f21429j.q();
        iArr[1] = this.f21429j.l();
        return j10;
    }

    public final boolean k(int[] iArr) {
        return i(iArr);
    }

    public void l() {
        m(150L);
    }

    public void m(long j10) {
        if (e()) {
            try {
                Thread.sleep(j10);
            } catch (Exception e10) {
                H7.b.c("CsvImportRunnable", "Exception e: " + e10);
            }
        }
    }
}
