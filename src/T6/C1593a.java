package t6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.oplus.blacklistapp.callintercept.policy.f;
import com.oplus.blacklistapp.callintercept.policy.g;
import com.oplus.blacklistapp.j;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.V;
import com.ted.phonenumber.entrys.CallerIdItem$MarkerData;
import com.ted.phonenumber.entrys.RecognitionNumber;
import h9.C1087a;
import java.io.IOException;
import java.io.InputStream;
import v6.C1627a;

/* compiled from: TedQuery.java */
/* renamed from: t6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1593a extends g {

    /* renamed from: a, reason: collision with root package name */
    public C1087a f37270a;

    /* renamed from: b, reason: collision with root package name */
    public Context f37271b;

    /* renamed from: c, reason: collision with root package name */
    public String f37272c;

    /* renamed from: d, reason: collision with root package name */
    public int f37273d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f37274e;

    /* renamed from: f, reason: collision with root package name */
    public RecognitionNumber f37275f;

    /* renamed from: g, reason: collision with root package name */
    public int f37276g = -1;

    @Override // com.oplus.blacklistapp.callintercept.policy.g
    public void a(f fVar, f.a aVar) {
        boolean z10;
        if (!C0844e.i()) {
            z10 = C1087a.m(this.f37271b);
        } else {
            z10 = true;
        }
        if (C1627a.f37411c) {
            C1627a.c("TedQuery", "asyncQueryYellowPageInfo network accessible: " + z10);
        }
        RecognitionNumber r10 = this.f37270a.r(this.f37272c, this.f37273d, 4000, z10);
        if (r10 != null) {
            k(r10);
        } else {
            C1627a.q("TedQuery", "queryNumberInfo recognitionNumber is null");
            k(new RecognitionNumber());
        }
        g(fVar, aVar);
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.g
    public boolean c(f fVar) {
        C1627a.c("TedQuery", "getYellowPageInfoFromLocalDB number = " + C0846g.f(this.f37272c));
        return h(fVar);
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.g
    public boolean d(Context context, String str, int i10, int i11) {
        this.f37271b = context;
        this.f37273d = i10;
        this.f37272c = str;
        this.f37276g = i11;
        this.f37270a = C1087a.e(context);
        C1627a.c("TedQuery", "init mQueryNumber = " + C0846g.f(this.f37272c) + " type = " + i10);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Drawable f() {
        /*
            r6 = this;
            java.lang.String r0 = "getDrawableImageOfNumber, exception = "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getDrawableImageOfNumber:"
            r1.append(r2)
            android.graphics.drawable.Drawable r2 = r6.f37274e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TedQuery"
            v6.C1627a.k(r2, r1)
            android.graphics.drawable.Drawable r1 = r6.f37274e
            if (r1 == 0) goto L1f
            return r1
        L1f:
            com.ted.phonenumber.entrys.RecognitionNumber r1 = r6.f37275f
            r3 = 0
            if (r1 != 0) goto L2e
            boolean r6 = v6.C1627a.f37411c
            if (r6 == 0) goto L2d
            java.lang.String r6 = "mRecognitionNumber is null return"
            v6.C1627a.c(r2, r6)
        L2d:
            return r3
        L2e:
            boolean r1 = v6.C1627a.f37411c
            if (r1 == 0) goto L4c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "getDrawableImageOfNumber logo string  = "
            r1.append(r4)
            com.ted.phonenumber.entrys.RecognitionNumber r4 = r6.f37275f
            java.lang.String r4 = r4.c0()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            v6.C1627a.c(r2, r1)
        L4c:
            com.ted.phonenumber.entrys.RecognitionNumber r1 = r6.f37275f
            java.lang.String r1 = r1.c0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L99
            h9.a r1 = r6.f37270a
            com.ted.phonenumber.entrys.RecognitionNumber r4 = r6.f37275f
            java.lang.String r4 = r4.c0()
            byte[] r1 = r1.o(r4)
            if (r1 == 0) goto L99
            int r4 = r1.length
            if (r4 == 0) goto L99
            int r4 = r1.length     // Catch: java.lang.Exception -> L70 java.lang.OutOfMemoryError -> L72
            r5 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r1, r5, r4)     // Catch: java.lang.Exception -> L70 java.lang.OutOfMemoryError -> L72
            goto L9a
        L70:
            r1 = move-exception
            goto L74
        L72:
            r1 = move-exception
            goto L87
        L74:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            v6.C1627a.h(r2, r0)
            goto L99
        L87:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            v6.C1627a.h(r2, r0)
        L99:
            r0 = r3
        L9a:
            if (r0 == 0) goto La7
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            android.content.Context r6 = r6.f37271b
            android.content.res.Resources r6 = r6.getResources()
            r3.<init>(r6, r0)
        La7:
            boolean r6 = v6.C1627a.f37411c
            if (r6 == 0) goto Lbf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "getDrawableImageOfNumber photoDrawable = "
            r6.append(r0)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            v6.C1627a.c(r2, r6)
        Lbf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.C1593a.f():android.graphics.drawable.Drawable");
    }

    public final void g(f fVar, f.a aVar) {
        RecognitionNumber recognitionNumber = this.f37275f;
        if (recognitionNumber == null) {
            if (C1627a.f37411c) {
                C1627a.c("TedQuery", "handleResult  mRecognitionNumber is null return");
                return;
            }
            return;
        }
        String name = recognitionNumber.getName();
        if (!TextUtils.isEmpty(name)) {
            fVar.f26720c = name;
            i(fVar, aVar);
            Drawable f10 = f();
            if (f10 != null && f10 != fVar.f26725h) {
                fVar.f26725h = f10;
                j(fVar, aVar);
                return;
            }
            return;
        }
        l(fVar);
        i(fVar, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h(f fVar) {
        StringBuilder sb;
        V v10 = new V(this.f37271b);
        if (v10.c(this.f37272c)) {
            if (C1627a.f37411c) {
                C1627a.c("TedQuery", this.f37272c + " is in table special_contacts.");
            }
            fVar.f26720c = v10.b();
            InputStream inputStream = null;
            inputStream = null;
            inputStream = null;
            try {
                try {
                    InputStream a10 = v10.a();
                    if (a10 != null) {
                        try {
                            Drawable createFromStream = Drawable.createFromStream(a10, null);
                            this.f37274e = createFromStream;
                            fVar.f26725h = createFromStream;
                            inputStream = createFromStream;
                        } catch (Exception e10) {
                            e = e10;
                            inputStream = a10;
                            C1627a.h("TedQuery", "Error happening for photo input stream: " + e);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e11) {
                                    e = e11;
                                    sb = new StringBuilder();
                                    sb.append("Unable to close input stream: ");
                                    sb.append(e);
                                    C1627a.h("TedQuery", sb.toString());
                                    return true;
                                }
                            }
                            return true;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = a10;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e12) {
                                    C1627a.h("TedQuery", "Unable to close input stream: " + e12);
                                }
                            }
                            throw th;
                        }
                    }
                    if (a10 != null) {
                        try {
                            a10.close();
                        } catch (IOException e13) {
                            e = e13;
                            sb = new StringBuilder();
                            sb.append("Unable to close input stream: ");
                            sb.append(e);
                            C1627a.h("TedQuery", sb.toString());
                            return true;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e14) {
                e = e14;
            }
            return true;
        }
        return false;
    }

    public final void i(f fVar, f.a aVar) {
        if (C1627a.f37411c) {
            C1627a.c("TedQuery", "sendInfoCompletedMsg info = " + fVar + " listener = " + aVar);
        }
        fVar.f26726i = 2;
        aVar.a(fVar);
    }

    public final void j(f fVar, f.a aVar) {
        if (C1627a.f37411c) {
            C1627a.c("TedQuery", "sendPhotoCompletedMsg info = " + fVar + " listener = " + aVar);
        }
        fVar.f26726i = 3;
        aVar.a(fVar);
    }

    public void k(RecognitionNumber recognitionNumber) {
        synchronized (this) {
            this.f37275f = recognitionNumber;
        }
    }

    public void l(f fVar) {
        String b10;
        if (C1627a.f37411c) {
            C1627a.c("TedQuery", "startQueryMarkInfo ");
        }
        RecognitionNumber recognitionNumber = this.f37275f;
        if (recognitionNumber != null) {
            CallerIdItem$MarkerData b11 = recognitionNumber.b();
            fVar.f26728k = this.f37275f.a();
            if (this.f37271b != null && b11 != null && !TextUtils.isEmpty(b11.b()) && !b11.G()) {
                int u10 = b11.u();
                String[] stringArray = this.f37271b.getResources().getStringArray(j.f27269e);
                if (u10 > 0 && stringArray != null && u10 < stringArray.length) {
                    b10 = stringArray[u10];
                } else {
                    b10 = b11.b();
                }
                if (!TextUtils.isEmpty(b10)) {
                    fVar.f26721d = b10;
                    if (b11.a0()) {
                        fVar.f26722e = this.f37271b.getString(u.f27609c3);
                        fVar.f26724g = -1;
                    } else if (b11.j0() != 0 && u10 != 14) {
                        fVar.f26724g = b11.j0();
                        fVar.f26722e = this.f37271b.getString(u.f27614d3, C0849j.d(b11.j0()));
                    }
                    fVar.f26723f = u10;
                }
                if (C1627a.f37411c) {
                    C1627a.c("TedQuery", "markClassify:" + b10);
                }
            } else {
                return;
            }
        }
        if (C1627a.f37411c) {
            C1627a.c("TedQuery", "startQueryMarkInfo done  yellowPageInfo = " + fVar);
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.g
    public void b() {
    }
}
