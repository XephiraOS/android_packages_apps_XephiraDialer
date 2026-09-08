package com.android.incallui.oplus.third;

import A2.A;
import A2.x;
import D2.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.incallui.Log;
import com.android.incallui.OplusSpecialNumberUtils;
import com.android.incallui.R;
import com.android.incallui.mvvm.utils.e;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.ted.number.entrys.CallerIdItem$MarkerData;
import com.ted.number.entrys.RecognitionNumber;
import com.ted.number.entrys.RequestData;
import com.ted.number.service.INumCallback;
import com.ted.number.t;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class OplusTedQuery extends x {

    /* renamed from: a, reason: collision with root package name */
    public t f19112a;

    /* renamed from: b, reason: collision with root package name */
    public Context f19113b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f19114c;

    /* renamed from: d, reason: collision with root package name */
    public RecognitionNumber f19115d;

    /* renamed from: e, reason: collision with root package name */
    public String f19116e;

    /* renamed from: f, reason: collision with root package name */
    public int f19117f;

    /* renamed from: g, reason: collision with root package name */
    public int f19118g = -1;

    /* renamed from: com.android.incallui.oplus.third.OplusTedQuery$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends INumCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ A f19119f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ A.a f19120g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ OplusTedQuery f19121h;

        @Override // com.ted.number.service.INumCallback
        public void C1(RecognitionNumber recognitionNumber) {
            if (recognitionNumber != null) {
                this.f19121h.l(recognitionNumber);
            }
            Log.d("OplusTedQuery", "asyncQueryYellowPageInfo, query onSuccess, result: " + recognitionNumber);
            this.f19121h.h(this.f19119f, this.f19120g);
        }

        @Override // com.ted.number.service.INumCallback
        public void b() {
            Log.d("OplusTedQuery", "asyncQueryYellowPageInfo, query onFail");
        }
    }

    @Override // A2.x
    public void a(final A a10, Bundle bundle, final A.a aVar) {
        if (this.f19113b != null && this.f19112a != null) {
            RecognitionNumber i10 = this.f19112a.i(new RequestData.b().q(this.f19116e).o(3).r(this.f19117f).u(COUIScrollBar.SCROLLER_FADE_TIMEOUT).s(System.currentTimeMillis()).p(true).t(this.f19118g).n(), bundle, new INumCallback.Stub() { // from class: com.android.incallui.oplus.third.OplusTedQuery.2
                @Override // com.ted.number.service.INumCallback
                public void C1(RecognitionNumber recognitionNumber) {
                    if (recognitionNumber != null) {
                        OplusTedQuery.this.l(recognitionNumber);
                    }
                    Log.d("OplusTedQuery", "asyncQueryYellowPageInfo, query onSuccess, result: " + recognitionNumber);
                    OplusTedQuery.this.h(a10, aVar);
                }

                @Override // com.ted.number.service.INumCallback
                public void b() {
                    Log.d("OplusTedQuery", "asyncQueryYellowPageInfo, query onFail");
                }
            });
            Log.d("OplusTedQuery", "asyncQueryYellowPageInfo old recognitionNumber: " + this.f19115d + ", new recognitionNumber: " + i10);
            if (i10 != null) {
                l(i10);
            }
        }
        h(a10, aVar);
    }

    @Override // A2.x
    public boolean c(A a10) {
        Log.d("OplusTedQuery", "getYellowPageInfoFromLocalDB number = " + g.l(this.f19116e));
        return i(a10);
    }

    @Override // A2.x
    public boolean d(Context context, String str, int i10, int i11) {
        Log.d("OplusTedQuery", "init mQueryNumber = " + g.l(this.f19116e) + " type = " + i10);
        this.f19113b = context;
        this.f19117f = i10;
        this.f19116e = str;
        this.f19118g = i11;
        if (context != null) {
            this.f19112a = t.g(context);
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
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
            android.graphics.drawable.Drawable r2 = r6.f19114c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "OplusTedQuery"
            com.android.incallui.Log.i(r2, r1)
            android.graphics.drawable.Drawable r1 = r6.f19114c
            if (r1 == 0) goto L1f
            return r1
        L1f:
            com.ted.number.entrys.RecognitionNumber r1 = r6.f19115d
            r3 = 0
            if (r1 != 0) goto L2e
            boolean r6 = com.android.incallui.Log.sDebug
            if (r6 == 0) goto L2d
            java.lang.String r6 = "mRecognitionNumber is null return"
            com.android.incallui.Log.d(r2, r6)
        L2d:
            return r3
        L2e:
            boolean r1 = com.android.incallui.Log.sDebug
            if (r1 == 0) goto L4c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "getDrawableImageOfNumber logo string  = "
            r1.append(r4)
            com.ted.number.entrys.RecognitionNumber r4 = r6.f19115d
            java.lang.String r4 = r4.c0()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.android.incallui.Log.d(r2, r1)
        L4c:
            com.ted.number.entrys.RecognitionNumber r1 = r6.f19115d
            java.lang.String r1 = r1.c0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L9b
            com.ted.number.t r1 = r6.f19112a
            if (r1 == 0) goto L9b
            com.ted.number.entrys.RecognitionNumber r4 = r6.f19115d
            java.lang.String r4 = r4.c0()
            byte[] r1 = r1.h(r4)
            if (r1 == 0) goto L9b
            int r4 = r1.length
            if (r4 == 0) goto L9b
            int r4 = r1.length     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L74
            r5 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r1, r5, r4)     // Catch: java.lang.Exception -> L72 java.lang.OutOfMemoryError -> L74
            goto L9c
        L72:
            r1 = move-exception
            goto L76
        L74:
            r1 = move-exception
            goto L89
        L76:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            com.android.incallui.Log.d(r2, r0)
            goto L9b
        L89:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            com.android.incallui.Log.d(r2, r0)
        L9b:
            r0 = r3
        L9c:
            android.content.Context r1 = r6.f19113b
            if (r1 == 0) goto Lad
            if (r0 == 0) goto Lad
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            android.content.Context r6 = r6.f19113b
            android.content.res.Resources r6 = r6.getResources()
            r3.<init>(r6, r0)
        Lad:
            boolean r6 = com.android.incallui.Log.sDebug
            if (r6 == 0) goto Lc5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "getDrawableImageOfNumber photoDrawable = "
            r6.append(r0)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            com.android.incallui.Log.d(r2, r6)
        Lc5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.third.OplusTedQuery.f():android.graphics.drawable.Drawable");
    }

    public String g() {
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "getDrawableUriOfNumber logo string  = " + this.f19115d.c0());
        }
        return this.f19115d.c0();
    }

    public void h(A a10, A.a aVar) {
        Bitmap b10;
        RecognitionNumber recognitionNumber = this.f19115d;
        if (recognitionNumber == null) {
            if (Log.sDebug) {
                Log.d("OplusTedQuery", "handleResult  mRecognitionNumber is null return");
                return;
            }
            return;
        }
        if (a10 == null) {
            if (Log.sDebug) {
                Log.d("OplusTedQuery", "handleResult  info is null return");
                return;
            }
            return;
        }
        String name = recognitionNumber.getName();
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "handleResult  name = " + g.o(name));
        }
        Bundle b11 = this.f19115d.b();
        if (b11 != null) {
            String string = b11.getString("omoji_video_color");
            Uri uri = (Uri) b11.getParcelable("omoji_image_uri");
            Uri uri2 = (Uri) b11.getParcelable("omoji_video_uri");
            a10.f105m = string;
            if (uri2 != null) {
                a10.f107o = uri2;
            }
            if (uri != null && (b10 = e.b(uri, 2)) != null) {
                a10.f106n = new BitmapDrawable(b10);
            }
        }
        if (!TextUtils.isEmpty(name)) {
            a10.f95c = name;
            j(a10, aVar);
            Drawable f10 = f();
            a10.f102j = g();
            if (f10 != null && f10 != a10.f101i) {
                a10.f101i = f10;
                k(a10, aVar);
                return;
            }
            return;
        }
        m(a10);
        j(a10, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean i(A a10) {
        StringBuilder sb;
        OplusSpecialNumberUtils oplusSpecialNumberUtils = OplusSpecialNumberUtils.getInstance();
        if (a10 != null && oplusSpecialNumberUtils.isSpecialNumber(this.f19116e)) {
            if (Log.sDebug) {
                Log.d("OplusTedQuery", g.l(this.f19116e) + " is in table special_contacts.");
            }
            a10.f95c = oplusSpecialNumberUtils.getNameOfnumber();
            InputStream inputStream = null;
            inputStream = null;
            inputStream = null;
            try {
                try {
                    InputStream inputStreamImageOfnumber = oplusSpecialNumberUtils.getInputStreamImageOfnumber();
                    if (inputStreamImageOfnumber != null) {
                        try {
                            Drawable createFromStream = Drawable.createFromStream(inputStreamImageOfnumber, null);
                            this.f19114c = createFromStream;
                            a10.f101i = createFromStream;
                            inputStream = createFromStream;
                        } catch (Exception e10) {
                            e = e10;
                            inputStream = inputStreamImageOfnumber;
                            Log.e("OplusTedQuery", "Error happening for photo input stream: " + e);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e11) {
                                    e = e11;
                                    sb = new StringBuilder();
                                    sb.append("Unable to close input stream: ");
                                    sb.append(e);
                                    Log.e("OplusTedQuery", sb.toString());
                                    return true;
                                }
                            }
                            return true;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamImageOfnumber;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e12) {
                                    Log.e("OplusTedQuery", "Unable to close input stream: " + e12);
                                }
                            }
                            throw th;
                        }
                    }
                    if (inputStreamImageOfnumber != null) {
                        try {
                            inputStreamImageOfnumber.close();
                        } catch (IOException e13) {
                            e = e13;
                            sb = new StringBuilder();
                            sb.append("Unable to close input stream: ");
                            sb.append(e);
                            Log.e("OplusTedQuery", sb.toString());
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

    public void j(A a10, A.a aVar) {
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "sendInfoCompletedMsg info = " + a10 + " listener = " + aVar);
        }
        if (a10 != null && aVar != null) {
            a10.f103k = 2;
            aVar.a(a10);
        } else {
            Log.d("OplusTedQuery", "sendInfoCompletedMsg info or listener is null return");
        }
    }

    public void k(A a10, A.a aVar) {
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "sendPhotoCompletedMsg info = " + a10 + " listener = " + aVar);
        }
        if (a10 != null && aVar != null) {
            a10.f103k = 3;
            aVar.a(a10);
        } else {
            Log.d("OplusTedQuery", "sendPhotoCompletedMsg info or listener is null return");
        }
    }

    public void l(RecognitionNumber recognitionNumber) {
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "setRecognitionNumber  recognitionNumber = " + recognitionNumber);
        }
        synchronized (this) {
            this.f19115d = recognitionNumber;
        }
    }

    public void m(A a10) {
        String b10;
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "startQueryMarkInfo ");
        }
        RecognitionNumber recognitionNumber = this.f19115d;
        if (recognitionNumber != null) {
            if (this.f19113b != null && recognitionNumber.f()) {
                a10.f96d = this.f19113b.getResources().getString(R.string.anti_fraud_center_number);
            }
            CallerIdItem$MarkerData d10 = this.f19115d.d();
            if (this.f19113b != null && d10 != null && !TextUtils.isEmpty(d10.b()) && !d10.G()) {
                int u10 = d10.u();
                String[] stringArray = this.f19113b.getResources().getStringArray(R.array.ted_classic_marks);
                if (u10 > 0 && stringArray != null && u10 < stringArray.length) {
                    b10 = stringArray[u10];
                } else {
                    b10 = d10.b();
                }
                if (!TextUtils.isEmpty(b10)) {
                    a10.f97e = b10;
                    if (d10.a0()) {
                        a10.f98f = this.f19113b.getString(R.string.oplus_sogou_mark_local);
                        a10.f100h = 0;
                    } else if (d10.j0() != 0 && u10 != 14) {
                        a10.f100h = d10.j0();
                        a10.f98f = this.f19113b.getString(R.string.oplus_sogou_mark_not_local, String.valueOf(d10.j0()));
                    }
                    a10.f99g = u10;
                }
                if (Log.sDebug) {
                    Log.d("OplusTedQuery", "markClassify:" + b10);
                }
            } else {
                return;
            }
        }
        if (Log.sDebug) {
            Log.d("OplusTedQuery", "startQueryMarkInfo done  yellowPageInfo = " + a10);
        }
    }

    @Override // A2.x
    public void b() {
    }
}
