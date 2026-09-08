package com.android.contacts.scenecard;

import a4.C0421a;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.telecom.PhoneAccountHandle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.calllog.z;
import com.android.contacts.dialpad.HighLightNumber;
import com.android.contacts.dialpad.view.HighLightView;
import com.android.contacts.framework.baseui.util.AiVoiceDetectUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.InterfaceC1265l0;
import v9.InterfaceC1637a;

/* compiled from: SceneCallLogAdapter.kt */
/* loaded from: classes.dex */
public final class SceneCallLogAdapter extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: H, reason: collision with root package name */
    public static final a f17107H = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public SceneDialtactsFragment f17108A;

    /* renamed from: B, reason: collision with root package name */
    public InterfaceC1265l0 f17109B;

    /* renamed from: C, reason: collision with root package name */
    public final boolean f17110C;

    /* renamed from: D, reason: collision with root package name */
    public int f17111D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f17112E;

    /* renamed from: F, reason: collision with root package name */
    public final m9.d f17113F;

    /* renamed from: G, reason: collision with root package name */
    public final ContentObserver f17114G;

    /* renamed from: a, reason: collision with root package name */
    public final Context f17115a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.E f17116b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f17117c;

    /* renamed from: d, reason: collision with root package name */
    public com.android.contacts.framework.baseui.calllog.b f17118d;

    /* renamed from: e, reason: collision with root package name */
    public final GregorianCalendar f17119e;

    /* renamed from: f, reason: collision with root package name */
    public DateFormat f17120f;

    /* renamed from: g, reason: collision with root package name */
    public DateFormat f17121g;

    /* renamed from: h, reason: collision with root package name */
    public int f17122h;

    /* renamed from: i, reason: collision with root package name */
    public long f17123i;

    /* renamed from: j, reason: collision with root package name */
    public long f17124j;

    /* renamed from: k, reason: collision with root package name */
    public int f17125k;

    /* renamed from: l, reason: collision with root package name */
    public b f17126l;

    /* renamed from: m, reason: collision with root package name */
    public com.android.contacts.calllog.I f17127m;

    /* renamed from: n, reason: collision with root package name */
    public com.android.contacts.framework.baseui.util.w f17128n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f17129o;

    /* renamed from: p, reason: collision with root package name */
    public int f17130p;

    /* renamed from: q, reason: collision with root package name */
    public int f17131q;

    /* renamed from: r, reason: collision with root package name */
    public E3.o f17132r;

    /* renamed from: x, reason: collision with root package name */
    public int f17133x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList<SpannableStringBuilder> f17134y;

    /* renamed from: z, reason: collision with root package name */
    public E3.q f17135z;

    /* compiled from: SceneCallLogAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SceneCallLogAdapter.kt */
    /* loaded from: classes.dex */
    public interface b {
        void onContentChanged();
    }

    /* compiled from: SceneCallLogAdapter.kt */
    /* loaded from: classes.dex */
    public static final class c extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final x0.z f17136a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x0.z dataBinding) {
            super(dataBinding.K0());
            kotlin.jvm.internal.i.f(dataBinding, "dataBinding");
            this.f17136a = dataBinding;
        }

        public final x0.z e() {
            return this.f17136a;
        }
    }

    /* compiled from: SceneCallLogAdapter.kt */
    /* loaded from: classes.dex */
    public static final class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            if (H7.a.b()) {
                H7.b.b("SceneCallLogAdapter", "onContentChanged");
            }
            b bVar = SceneCallLogAdapter.this.f17126l;
            if (bVar != null) {
                bVar.onContentChanged();
            }
        }
    }

    public SceneCallLogAdapter(Context context, kotlinx.coroutines.E coroutineScope) {
        boolean z10;
        m9.d b10;
        int i10;
        kotlin.jvm.internal.i.f(coroutineScope, "coroutineScope");
        this.f17115a = context;
        this.f17116b = coroutineScope;
        this.f17118d = new com.android.contacts.framework.baseui.calllog.b();
        this.f17119e = new GregorianCalendar();
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        kotlin.jvm.internal.i.e(timeFormat, "getTimeFormat(context)");
        this.f17120f = timeFormat;
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        kotlin.jvm.internal.i.e(dateInstance, "getDateInstance(DateFormat.SHORT)");
        this.f17121g = dateInstance;
        this.f17123i = -1L;
        this.f17124j = -1L;
        this.f17125k = -1;
        this.f17134y = new ArrayList<>();
        if (!B3.a.Z() && !B3.a.a0()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f17110C = z10;
        b10 = kotlin.a.b(new InterfaceC1637a<com.android.contacts.calllog.z>() { // from class: com.android.contacts.scenecard.SceneCallLogAdapter$contactInfoCache$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.android.contacts.calllog.z invoke() {
                Context context2;
                Context context3;
                context2 = SceneCallLogAdapter.this.f17115a;
                context3 = SceneCallLogAdapter.this.f17115a;
                return new com.android.contacts.calllog.z(context2, new com.android.contacts.calllog.A(context3, null), new a(SceneCallLogAdapter.this));
            }

            /* compiled from: SceneCallLogAdapter.kt */
            /* loaded from: classes.dex */
            public static final class a implements z.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SceneCallLogAdapter f17137a;

                public a(SceneCallLogAdapter sceneCallLogAdapter) {
                    this.f17137a = sceneCallLogAdapter;
                }

                @Override // com.android.contacts.calllog.z.b
                public void a() {
                    this.f17137a.S();
                }

                @Override // com.android.contacts.calllog.z.b
                public void i() {
                }
            }
        });
        this.f17113F = b10;
        this.f17114G = new d(new Handler());
        this.f17127m = new com.android.contacts.calllog.I(context);
        this.f17128n = com.android.contacts.framework.baseui.util.w.e();
        C().v(this.f17128n);
        if (context != null) {
            i10 = context.getColor(R.color.scene_color_primary_green);
        } else {
            i10 = 0;
        }
        this.f17130p = i10;
        this.f17131q = context != null ? context.getColor(R.color.scene_color_primary_neutral) : 0;
    }

    private final int F(Cursor cursor, int i10) {
        int position = cursor.getPosition();
        int i11 = 0;
        for (int i12 = 0; i12 < i10 && cursor.getInt(4) == 3; i12++) {
            i11++;
            cursor.moveToNext();
        }
        cursor.moveToPosition(position);
        if (i11 < 2) {
            return 0;
        }
        return i11;
    }

    private final void K(HighLightView highLightView, String str, String str2, String str3) {
        List Y9;
        int J10;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String y10 = y(str);
        if (!TextUtils.isEmpty(y10)) {
            kotlin.jvm.internal.i.c(y10);
            Y9 = StringsKt__StringsKt.Y(y10, new String[]{" "}, false, 0, 6, null);
            String[] strArr = (String[]) Y9.toArray(new String[0]);
            if (str3 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int length = strArr.length - 1;
            for (int i10 = 0; i10 < length; i10++) {
                char[] charArray = strArr[i10].toCharArray();
                kotlin.jvm.internal.i.e(charArray, "toCharArray(...)");
                sb.append(charArray[0]);
            }
            char[] charArray2 = strArr[strArr.length - 1].toCharArray();
            kotlin.jvm.internal.i.e(charArray2, "toCharArray(...)");
            sb.append(charArray2[0]);
            String c10 = HighLightView.c(sb.toString());
            kotlin.jvm.internal.i.e(c10, "convertString2Digitals(firstSb.toString())");
            J10 = StringsKt__StringsKt.J(c10, str3, 0, false, 6, null);
            if (J10 != -1) {
                this.f17134y.clear();
                for (String str4 : strArr) {
                    this.f17134y.add(new SpannableStringBuilder(str4));
                }
                if (str3.length() != 0) {
                    if (str3.length() > strArr.length) {
                        if (J10 == strArr.length - 1) {
                            for (int i11 = 0; i11 < J10; i11++) {
                                spannableStringBuilder.append((CharSequence) this.f17134y.get(i11));
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                            this.f17134y.get(J10).setSpan(new ForegroundColorSpan(this.f17130p), 0, str3.length(), 33);
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(J10));
                            highLightView.setText(spannableStringBuilder);
                        } else if (J10 == 0) {
                            int length2 = strArr.length - 1;
                            for (int i12 = 0; i12 < length2; i12++) {
                                this.f17134y.get(i12).setSpan(new ForegroundColorSpan(this.f17130p), 0, 1, 33);
                                spannableStringBuilder.append((CharSequence) this.f17134y.get(i12));
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                            this.f17134y.get(strArr.length - 1).setSpan(new ForegroundColorSpan(this.f17130p), 0, (str3.length() - strArr.length) + 1, 33);
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(strArr.length - 1));
                            highLightView.setText(spannableStringBuilder);
                        } else {
                            highLightView.f15044a = false;
                            N(highLightView, str, str2, str3);
                        }
                    } else if (J10 == 0) {
                        int length3 = str3.length();
                        for (int i13 = 0; i13 < length3; i13++) {
                            this.f17134y.get(i13).setSpan(new ForegroundColorSpan(this.f17130p), 0, 1, 33);
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(i13));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        int length4 = strArr.length;
                        for (int length5 = str3.length(); length5 < length4; length5++) {
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(length5));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        highLightView.setText(spannableStringBuilder);
                    } else if (J10 == strArr.length - 1) {
                        for (int i14 = 0; i14 < J10; i14++) {
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(i14));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        this.f17134y.get(J10).setSpan(new ForegroundColorSpan(this.f17130p), 0, str3.length(), 33);
                        spannableStringBuilder.append((CharSequence) this.f17134y.get(J10));
                        highLightView.setText(spannableStringBuilder);
                    } else {
                        int length6 = str3.length();
                        for (int i15 = 0; i15 < length6; i15++) {
                            if (J10 < this.f17134y.size()) {
                                this.f17134y.get(J10).setSpan(new ForegroundColorSpan(this.f17130p), 0, 1, 33);
                                J10++;
                            } else {
                                ArrayList<SpannableStringBuilder> arrayList = this.f17134y;
                                arrayList.get(arrayList.size() - 1).setSpan(new ForegroundColorSpan(this.f17130p), 0, (str3.length() - i15) + 1, 33);
                            }
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(i15));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        int length7 = strArr.length;
                        for (int length8 = str3.length(); length8 < length7; length8++) {
                            spannableStringBuilder.append((CharSequence) this.f17134y.get(length8));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        highLightView.setText(spannableStringBuilder);
                    }
                    this.f17134y.clear();
                    spannableStringBuilder.clear();
                    return;
                }
                return;
            }
            highLightView.f15044a = false;
            N(highLightView, str, str2, str3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
    
        if (r2 <= 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009f, code lost:
    
        if (r19[r2 - 1] != (r14 - 1)) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a1, code lost:
    
        r5.setSpan(new android.text.style.ForegroundColorSpan(r16.f17130p), r14, r15, 34);
        r2 = r2 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:6:0x0014, B:10:0x0023, B:12:0x0029, B:14:0x003f, B:17:0x004d, B:22:0x0049, B:25:0x0062, B:27:0x007c, B:30:0x0084, B:36:0x00fa, B:52:0x0099, B:55:0x00a1, B:60:0x00b7, B:62:0x00bb, B:68:0x00c3, B:70:0x00db, B:73:0x00e3, B:77:0x00f1, B:43:0x0113, B:45:0x0119), top: B:5:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void M(com.android.contacts.dialpad.view.HighLightView r17, java.lang.String r18, int[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.scenecard.SceneCallLogAdapter.M(com.android.contacts.dialpad.view.HighLightView, java.lang.String, int[], int):void");
    }

    private final void N(HighLightView highLightView, String str, String str2, String str3) {
        highLightView.setTextPaintColor(this.f17131q);
        highLightView.setHightTextColor(this.f17130p);
        highLightView.q(str2, str, str3, this.f17133x);
    }

    public static final void T(SceneCallLogAdapter this$0, View itemView) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(itemView, "itemView");
        this$0.V(itemView);
    }

    public static /* synthetic */ void f0(SceneCallLogAdapter sceneCallLogAdapter, Cursor cursor, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        sceneCallLogAdapter.e0(cursor, z10);
    }

    private final void r(TextView textView, String str, String str2, int i10, int i11) {
        s(textView, str, false, null, str2, i10, i11);
    }

    public static /* synthetic */ void w(SceneCallLogAdapter sceneCallLogAdapter, Context context, String str, long j10, int i10, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j10 = -1;
        }
        long j11 = j10;
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            str2 = null;
        }
        sceneCallLogAdapter.v(context, str, j11, i12, str2);
    }

    public final int A(int i10, int i11) {
        if (i11 != -1) {
            return i11 - i10;
        }
        Cursor cursor = this.f17117c;
        kotlin.jvm.internal.i.c(cursor);
        return cursor.getCount() - i10;
    }

    public final com.android.contacts.calllog.y B(Cursor cursor) {
        com.android.contacts.calllog.y yVar = new com.android.contacts.calllog.y();
        yVar.f14057b = U7.g.b(cursor.getString(8));
        yVar.f14058c = cursor.getString(7);
        yVar.f14059d = cursor.getInt(4);
        yVar.f14061f = cursor.getString(1);
        yVar.f14063h = cursor.getString(9);
        yVar.f14062g = cursor.getString(11);
        yVar.f14070o = cursor.getLong(2);
        yVar.f14071p = cursor.getInt(12);
        yVar.f14074s = cursor.getString(16);
        yVar.f14075t = cursor.getString(17);
        yVar.f14080y = cursor.getInt(15);
        yVar.f14066k = cursor.getLong(10);
        yVar.f14067l = U7.g.b(cursor.getString(14));
        int i10 = this.f17125k;
        if (i10 != -1) {
            yVar.f14081z = cursor.getString(i10);
        }
        return yVar;
    }

    public final com.android.contacts.calllog.z C() {
        return (com.android.contacts.calllog.z) this.f17113F.getValue();
    }

    public final int[] D(String str) {
        boolean v10;
        if (str != null && str.length() >= 12) {
            int i10 = 0;
            v10 = kotlin.text.n.v(str, "999", false, 2, null);
            if (!v10) {
                int length = str.length();
                if (length % 3 != 0) {
                    return null;
                }
                int[] iArr = new int[(length / 3) - 3];
                int i11 = 9;
                while (i11 < length) {
                    if (kotlin.jvm.internal.i.g(48, str.charAt(i11)) <= 0 && kotlin.jvm.internal.i.g(str.charAt(i11), 57) <= 0) {
                        int i12 = i11 + 1;
                        if (kotlin.jvm.internal.i.g(48, str.charAt(i12)) <= 0 && kotlin.jvm.internal.i.g(str.charAt(i12), 57) <= 0) {
                            int i13 = i11 + 2;
                            if (kotlin.jvm.internal.i.g(48, str.charAt(i13)) <= 0 && kotlin.jvm.internal.i.g(str.charAt(i13), 57) <= 0) {
                                iArr[i10] = ((str.charAt(i11) - '0') * 100) + ((str.charAt(i12) - '0') * 10) + (str.charAt(i13) - '0');
                                i11 += 3;
                                i10++;
                            }
                        }
                    }
                    return null;
                }
                return iArr;
            }
        }
        return null;
    }

    public final int E(String str) {
        boolean v10;
        if (str == null || str.length() < 12) {
            return 0;
        }
        v10 = kotlin.text.n.v(str, "999", false, 2, null);
        if (v10 || kotlin.jvm.internal.i.g(48, str.charAt(4)) > 0 || kotlin.jvm.internal.i.g(str.charAt(4), 57) > 0 || kotlin.jvm.internal.i.g(48, str.charAt(5)) > 0 || kotlin.jvm.internal.i.g(str.charAt(5), 57) > 0 || kotlin.jvm.internal.i.g(48, str.charAt(6)) > 0 || kotlin.jvm.internal.i.g(str.charAt(6), 57) > 0) {
            return 0;
        }
        return ((str.charAt(4) - '0') * 100) + ((str.charAt(5) - '0') * 10) + (str.charAt(6) - '0');
    }

    public final int G(int i10, int i11) {
        if (i10 >= i11 - 1) {
            return -1;
        }
        return this.f17118d.k(i10 + 1);
    }

    public final com.android.contacts.calllog.I H() {
        return this.f17127m;
    }

    public final E3.q I() {
        return this.f17135z;
    }

    public final int J(String str) {
        if (str == null) {
            return -1;
        }
        try {
            int charAt = str.charAt(8) - '0';
            if (charAt != 1 && charAt != 2) {
                return 0;
            }
            return charAt;
        } catch (Exception unused) {
            return -1;
        }
    }

    public final void L(HighLightView contactName, HighLightNumber highLightNumber, String str, String str2, String str3) {
        kotlin.jvm.internal.i.f(contactName, "contactName");
        if (str != null && str2 != null && str3 != null) {
            try {
                if (this.f17133x != 1 && str3.length() > 0 && new Regex("^[a-zA-Z0-9 ,]*").a(str) && O(str)) {
                    contactName.f15044a = true;
                    K(contactName, str, str2, str3);
                } else {
                    contactName.f15044a = false;
                    if (FeatureOption.o()) {
                        contactName.f15045b = true;
                    }
                    N(contactName, str, str2, str3);
                }
            } catch (Exception e10) {
                H7.b.c("SceneCallLogAdapter", "Exception e: " + e10);
            }
            if (highLightNumber == null) {
                return;
            }
            if (contactName.a()) {
                highLightNumber.setNormalMode(true);
            } else if (FeatureOption.o()) {
                highLightNumber.f14872a = true;
            }
            highLightNumber.setTextPaintColor(com.android.contacts.calllog.k.f13899u0);
            highLightNumber.setHightTextColor(this.f17130p);
            highLightNumber.d(str2, str3, this.f17133x);
        }
    }

    public final boolean O(String string) {
        kotlin.jvm.internal.i.f(string, "string");
        int length = string.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (string.charAt(i10) == ' ') {
                return true;
            }
        }
        return false;
    }

    public final void P() {
        C().p();
    }

    public final boolean Q(int i10) {
        if ((i10 & 1) == 1) {
            return true;
        }
        return false;
    }

    public final boolean R(int i10) {
        if (this.f17110C && ((i10 & 524288) == 524288 || (i10 & 8) == 8)) {
            return true;
        }
        return false;
    }

    public final void S() {
        InterfaceC1265l0 interfaceC1265l0 = this.f17109B;
        if (interfaceC1265l0 != null && interfaceC1265l0.c()) {
            H7.b.i("SceneCallLogAdapter", "callLogGroupJob is running");
            return;
        }
        if (this.f17111D == 0) {
            notifyDataSetChanged();
        } else {
            this.f17112E = true;
        }
        if (H7.a.b()) {
            H7.b.b("SceneCallLogAdapter", "onContactInfoChanged, mNeedPostponeDataChanged = " + this.f17112E + ",mCurrentScrollState = " + this.f17111D);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        x0.z dataBinding = (x0.z) androidx.databinding.g.h(LayoutInflater.from(this.f17115a), R.layout.scene_item_call_log, parent, false);
        kotlin.jvm.internal.i.e(dataBinding, "dataBinding");
        return new c(dataBinding);
    }

    public final void V(View view) {
        String str;
        SceneDialtactsFragment sceneDialtactsFragment = this.f17108A;
        Intent intent = null;
        if (sceneDialtactsFragment != null) {
            str = sceneDialtactsFragment.B1();
        } else {
            str = null;
        }
        long j10 = -1;
        int i10 = -1;
        if (str != null && str.length() != 0) {
            Object tag = view.getTag();
            if (tag instanceof Intent) {
                intent = (Intent) tag;
            }
            String l10 = C7.e.l(intent, "number");
            String l11 = C7.e.l(intent, "countryiso");
            long f10 = C7.e.f(intent, "person_id", -1L);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            if (b0.i(this.f17115a) && this.f17122h > 1) {
                int g10 = C0801l.g(this.f17115a, l10);
                ref$IntRef.element = g10;
                if (g10 == -1) {
                    SceneDialtactsFragment sceneDialtactsFragment2 = this.f17108A;
                    if (sceneDialtactsFragment2 != null) {
                        i10 = sceneDialtactsFragment2.A1();
                    }
                    ref$IntRef.element = i10;
                }
            } else {
                SceneDialtactsFragment sceneDialtactsFragment3 = this.f17108A;
                if (sceneDialtactsFragment3 != null) {
                    i10 = sceneDialtactsFragment3.A1();
                }
                ref$IntRef.element = i10;
            }
            C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.a(), null, new SceneCallLogAdapter$onItemClick$2(this, l10, f10, ref$IntRef, l11, null), 2, null);
            SceneDialtactsFragment sceneDialtactsFragment4 = this.f17108A;
            if (sceneDialtactsFragment4 != null) {
                sceneDialtactsFragment4.G1(true);
                return;
            }
            return;
        }
        Object tag2 = view.getTag();
        if (tag2 instanceof Intent) {
            intent = (Intent) tag2;
        }
        String l12 = C7.e.l(intent, "number");
        int d10 = C7.e.d(intent, "simid", -1);
        if (!com.android.contacts.calllog.I.a(l12)) {
            return;
        }
        com.android.contacts.calllog.y o10 = C().o(l12, d10, -1, com.android.contacts.calllog.y.f14054B, true, false);
        kotlin.jvm.internal.i.e(o10, "contactInfoCache.getValu…tInfo.EMPTY, true, false)");
        if (TextUtils.equals(l12, o10.f14061f)) {
            j10 = o10.f14056a;
            Uri uri = o10.f14057b;
            if (j10 < 0 && uri != null) {
                j10 = ContentUris.parseId(uri);
            }
        }
        long j11 = j10;
        if (b0.i(this.f17115a)) {
            if (H7.a.b()) {
                H7.b.b("SceneCallLogAdapter", "autoCallback");
            }
            long j12 = d10;
            if (j12 == this.f17123i) {
                i10 = 0;
            } else if (j12 == this.f17124j) {
                i10 = 1;
            }
        }
        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.a(), null, new SceneCallLogAdapter$onItemClick$1(this, l12, j11, i10, null), 2, null);
        SceneDialtactsFragment sceneDialtactsFragment5 = this.f17108A;
        if (sceneDialtactsFragment5 != null) {
            sceneDialtactsFragment5.G1(true);
        }
    }

    public final void W(b listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f17126l = listener;
    }

    public final void X(int i10) {
        this.f17133x = i10;
    }

    public final void Y(SceneDialtactsFragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f17108A = fragment;
    }

    public final void Z(boolean z10) {
        C().r(z10);
    }

    public final void a0(E3.o oVar) {
        this.f17132r = oVar;
    }

    public final void b0(E3.q qVar) {
        this.f17135z = qVar;
    }

    public final void c0(boolean z10) {
        C().w(z10);
    }

    public final void d0() {
        C().y();
    }

    public final void e0(Cursor cursor, boolean z10) {
        int i10;
        InterfaceC1265l0 d10;
        if (kotlin.jvm.internal.i.b(cursor, this.f17117c)) {
            return;
        }
        if (cursor != null) {
            i10 = cursor.getColumnIndex("virtual_call_id");
        } else {
            i10 = -1;
        }
        this.f17125k = i10;
        H7.b.e("SceneCallLogAdapter", "updateCursor async = " + z10 + "; uniqueIdIndex = " + i10);
        InterfaceC1265l0 interfaceC1265l0 = this.f17109B;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        d10 = C1248i.d(this.f17116b, null, null, new SceneCallLogAdapter$updateCursor$1(this, z10, cursor, null), 3, null);
        this.f17109B = d10;
    }

    public final void g0(int i10, long j10, long j11) {
        this.f17122h = i10;
        this.f17123i = j10;
        this.f17124j = j11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f17118d.j();
    }

    public final void h0() {
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this.f17115a);
        kotlin.jvm.internal.i.e(timeFormat, "getTimeFormat(context)");
        this.f17120f = timeFormat;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.B r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.i.f(r6, r0)
            int r0 = r5.getItemCount()
            int r0 = r5.G(r7, r0)
            com.android.contacts.framework.baseui.calllog.b r1 = r5.f17118d
            int r7 = r1.k(r7)
            android.database.Cursor r1 = r5.f17117c
            r2 = 0
            if (r1 == 0) goto L5d
            boolean r3 = r1.isClosed()
            if (r3 != 0) goto L1f
            goto L20
        L1f:
            r1 = r2
        L20:
            if (r1 == 0) goto L5d
            boolean r3 = r1.moveToPosition(r7)
            if (r3 == 0) goto L5a
            int r3 = r1.getColumnCount()
            java.lang.String[] r4 = com.android.contacts.framework.baseui.calllog.d.a()
            int r4 = r4.length
            if (r3 != r4) goto L42
            r3 = r6
            com.android.contacts.scenecard.SceneCallLogAdapter$c r3 = (com.android.contacts.scenecard.SceneCallLogAdapter.c) r3
            int r7 = r5.A(r7, r0)
            int r7 = r5.F(r1, r7)
            r5.t(r3, r7)
            goto L48
        L42:
            r7 = r6
            com.android.contacts.scenecard.SceneCallLogAdapter$c r7 = (com.android.contacts.scenecard.SceneCallLogAdapter.c) r7
            r5.u(r7, r1)
        L48:
            android.view.View r7 = r6.itemView
            r0 = 2131232748(0x7f0807ec, float:1.8081614E38)
            r7.setBackgroundResource(r0)
            android.view.View r6 = r6.itemView
            com.android.contacts.scenecard.b r7 = new com.android.contacts.scenecard.b
            r7.<init>()
            r6.setOnClickListener(r7)
        L5a:
            m9.q r6 = m9.q.f35511a
            goto L5e
        L5d:
            r6 = r2
        L5e:
            if (r6 != 0) goto L8a
            android.database.Cursor r5 = r5.f17117c
            if (r5 == 0) goto L6c
            boolean r6 = r5.isClosed()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)
        L6c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "cursor = "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = " isclosed = "
            r6.append(r5)
            r6.append(r2)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "SceneCallLogAdapter"
            H7.b.b(r6, r5)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.scenecard.SceneCallLogAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$B, int):void");
    }

    public final CharSequence q(CharSequence charSequence, int i10) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, charSequence.length(), 18);
        return spannableString;
    }

    public final void s(TextView textView, String str, boolean z10, String str2, String str3, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        E3.s sVar = new E3.s(textView);
        sVar.f684j = str;
        sVar.f683i = z10;
        sVar.f682h = str2;
        sVar.f681g = str3;
        sVar.f680f = i10;
        sVar.f679e = i11;
        E3.q I10 = I();
        if (I10 != null) {
            I10.q(sVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    public final void t(c cVar, int i10) {
        Boolean valueOf;
        String string;
        String str;
        ?? r12;
        Integer num;
        int i11;
        boolean z10;
        int i12;
        Drawable drawable;
        T t10;
        Cursor cursor = this.f17117c;
        kotlin.jvm.internal.i.c(cursor);
        com.android.contacts.calllog.y B10 = B(cursor);
        com.android.contacts.calllog.y o10 = C().o(B10.f14061f, B10.f14071p, B10.f14059d, B10, true, false);
        kotlin.jvm.internal.i.e(o10, "contactInfoCache.getValu…atabaseInfo, true, false)");
        if (this.f17125k != -1 && FeatureOption.m() && com.android.contacts.framework.baseui.calllog.c.f15784a.c(B10.f14080y, B10.f14081z)) {
            cVar.e().f37810G.setVisibility(0);
            cVar.e().f37811H.setVisibility(0);
        } else {
            cVar.e().f37810G.setVisibility(8);
            cVar.e().f37811H.setVisibility(8);
        }
        String str2 = null;
        if (this.f17122h > 1) {
            com.android.contacts.calllog.I i13 = this.f17127m;
            if (i13 != null) {
                valueOf = Boolean.valueOf(i13.j(B10.f14071p, B10.f14061f, this.f17123i, this.f17124j));
            }
            valueOf = null;
        } else {
            com.android.contacts.calllog.I i14 = this.f17127m;
            if (i14 != null) {
                valueOf = Boolean.valueOf(i14.k(B10.f14061f));
            }
            valueOf = null;
        }
        if (kotlin.jvm.internal.i.b(valueOf, Boolean.TRUE)) {
            Context context = this.f17115a;
            kotlin.jvm.internal.i.c(context);
            string = context.getResources().getString(R.string.voicemail);
        } else if (!TextUtils.isEmpty(o10.f14058c)) {
            Uri uri = o10.f14057b;
            if (uri != null) {
                str = uri.toString();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                string = o10.f14058c;
                kotlin.jvm.internal.i.c(string);
            } else {
                if (!TextUtils.equals(B10.f14075t, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE)) {
                    string = o10.f14058c;
                    kotlin.jvm.internal.i.c(string);
                }
                string = "";
            }
        } else {
            if (o10.f14072q) {
                Context context2 = this.f17115a;
                kotlin.jvm.internal.i.c(context2);
                string = context2.getResources().getString(R.string.oplus_calllog_emergency_number);
            }
            string = "";
        }
        kotlin.jvm.internal.i.e(string, "if (isVoicemailNumber ==…\n            \"\"\n        }");
        if (TextUtils.isEmpty(string)) {
            com.android.contacts.calllog.I i15 = this.f17127m;
            if (i15 != null) {
                r12 = i15.d(B10.f14061f, B10.f14062g, i10);
            }
            r12 = 0;
        } else {
            com.android.contacts.calllog.I i16 = this.f17127m;
            if (i16 != null) {
                r12 = i16.e(string, i10);
            }
            r12 = 0;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = r12;
        Context context3 = this.f17115a;
        if (context3 != null) {
            num = com.android.contacts.calllog.w.b(context3, B10.f14059d);
        } else {
            num = null;
        }
        if (num != null) {
            if (r12 != 0) {
                t10 = q(r12, num.intValue());
            } else {
                t10 = 0;
            }
            ref$ObjectRef.element = t10;
        }
        cVar.e().f37814K.setText((CharSequence) ref$ObjectRef.element);
        this.f17119e.setTimeInMillis(System.currentTimeMillis());
        cVar.e().f37813J.setVisibility(0);
        TextView textView = cVar.e().f37813J;
        long j10 = B10.f14070o;
        GregorianCalendar gregorianCalendar = this.f17119e;
        DateFormat dateFormat = this.f17120f;
        DateFormat dateFormat2 = this.f17121g;
        Context context4 = this.f17115a;
        kotlin.jvm.internal.i.c(context4);
        textView.setText(F7.b.a(j10, gregorianCalendar, dateFormat, dateFormat2, context4.getString(R.string.oplus_yesterday)));
        int i17 = B10.f14059d;
        Cursor cursor2 = this.f17117c;
        if (cursor2 != null) {
            i11 = cursor2.getInt(15);
        } else {
            i11 = -1;
        }
        cVar.e().f37812I.setImageDrawable(z(i17, i11));
        cVar.e().f37812I.setVisibility(0);
        cVar.e().f37815L.setVisibility(8);
        cVar.e().f37816M.setVisibility(8);
        if (this.f17122h > 1) {
            long j11 = B10.f14071p;
            if (j11 == this.f17123i) {
                Context context5 = this.f17115a;
                kotlin.jvm.internal.i.c(context5);
                drawable = context5.getDrawable(R.drawable.scene_ic_call_log_sim1);
            } else if (j11 == this.f17124j) {
                Context context6 = this.f17115a;
                kotlin.jvm.internal.i.c(context6);
                drawable = context6.getDrawable(R.drawable.scene_ic_call_log_sim2);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                cVar.e().f37816M.setImageDrawable(drawable);
                cVar.e().f37816M.setVisibility(0);
            }
        }
        if (B10.f14057b == null && !TextUtils.isEmpty(B10.f14061f)) {
            str2 = E0.b.t(this.f17115a, B10.f14061f);
            i12 = E0.b.o(B10.f14061f);
            z10 = E0.b.w(B10.f14061f);
        } else {
            z10 = false;
            i12 = -1;
        }
        if (o10.f14079x) {
            cVar.e().f37817N.setTextColor(com.android.contacts.framework.baseui.util.r.c(this.f17115a));
            cVar.e().f37817N.setText(this.f17115a.getText(R.string.nafc_fraud_number));
            cVar.e().f37817N.setVisibility(0);
        } else if (str2 != null && com.customize.contacts.util.J.o(B10.f14075t, z10, i12, B10.f14059d)) {
            if (com.customize.contacts.util.J.l(i12)) {
                cVar.e().f37817N.setTextColor(com.android.contacts.framework.baseui.util.r.d(this.f17115a));
            } else {
                cVar.e().f37817N.setTextColor(com.android.contacts.framework.baseui.util.r.c(this.f17115a));
            }
            cVar.e().f37817N.setText(str2);
            cVar.e().f37817N.setVisibility(0);
        } else if (AiVoiceDetectUtils.a(this.f17115a, B10.f14080y)) {
            cVar.e().f37817N.setTextColor(com.android.contacts.framework.baseui.util.r.c(this.f17115a));
            cVar.e().f37817N.setText(this.f17115a.getText(R.string.oplus_ai_voice_detect));
            cVar.e().f37817N.setVisibility(0);
        } else {
            cVar.e().f37817N.setVisibility(8);
        }
        Intent intent = new Intent();
        intent.putExtra("number", B10.f14061f);
        intent.putExtra("simid", B10.f14071p);
        cVar.itemView.setTag(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(com.android.contacts.scenecard.SceneCallLogAdapter.c r32, android.database.Cursor r33) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.scenecard.SceneCallLogAdapter.u(com.android.contacts.scenecard.SceneCallLogAdapter$c, android.database.Cursor):void");
    }

    public final void v(Context context, String str, long j10, int i10, String str2) {
        String str3;
        PhoneAccountHandle s10;
        if (str.length() > 0) {
            str3 = str;
        } else {
            str3 = null;
        }
        if (str3 != null) {
            Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", str, null));
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            if (j10 > 0 && PrimaryUserUtils.a()) {
                Uri withAppendedId = ContentUris.withAppendedId(R0.d.c(str), j10);
                kotlin.jvm.internal.i.e(withAppendedId, "withAppendedId(phoneUri, contactId)");
                intent.putExtra(R0.c.f3186d, withAppendedId.toString());
                C0794e.b(context, intent, str);
            }
            if (i10 > -1 && (s10 = b0.s(context, i10)) != null) {
                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", s10);
            }
            if (str2 != null) {
                intent.putExtra("countryiso", str2);
            }
            C0802m.a(context, intent);
        }
    }

    public final void x(int i10) {
        if (i10 == 0 && this.f17112E) {
            if (H7.a.b()) {
                H7.b.b("SceneCallLogAdapter", "changeScrollState:notifyDataSetChanged");
            }
            notifyDataSetChanged();
            this.f17112E = false;
        }
        this.f17111D = i10;
    }

    public final String y(String str) {
        int i10;
        boolean z10;
        if (str != null && str.length() != 0) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                if (!z11) {
                    i10 = i11;
                } else {
                    i10 = length;
                }
                if (kotlin.jvm.internal.i.g(str.charAt(i10), 32) <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z11) {
                    if (!z10) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else {
                    if (!z10) {
                        break;
                    }
                    length--;
                }
            }
            String obj = str.subSequence(i11, length + 1).toString();
            StringBuilder sb = new StringBuilder();
            char[] charArray = obj.toCharArray();
            kotlin.jvm.internal.i.e(charArray, "toCharArray(...)");
            int length2 = charArray.length;
            for (int i12 = 0; i12 < length2; i12++) {
                if (charArray[i12] == ' ' && charArray[i12 + 1] == ' ') {
                    charArray[i12] = '$';
                }
            }
            for (char c10 : charArray) {
                if (c10 != '$') {
                    sb.append(c10);
                }
            }
            return sb.toString();
        }
        return null;
    }

    public final Drawable z(int i10, int i11) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        boolean Q10 = Q(i11);
        boolean R10 = R(i11);
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5 && i10 != 10) {
                            if (i10 != 100) {
                                if (i10 != 101) {
                                    if (R10) {
                                        Context context = this.f17115a;
                                        kotlin.jvm.internal.i.c(context);
                                        drawable7 = context.getDrawable(R.drawable.scene_ic_call_incoming_vowifi);
                                        kotlin.jvm.internal.i.c(drawable7);
                                    } else {
                                        Context context2 = this.f17115a;
                                        kotlin.jvm.internal.i.c(context2);
                                        drawable7 = context2.getDrawable(R.drawable.scene_ic_call_incoming);
                                        kotlin.jvm.internal.i.c(drawable7);
                                    }
                                    kotlin.jvm.internal.i.e(drawable7, "{\n                if (is…          }\n            }");
                                    return drawable7;
                                }
                                if (this.f17110C) {
                                    if (Q10) {
                                        Context context3 = this.f17115a;
                                        kotlin.jvm.internal.i.c(context3);
                                        drawable6 = context3.getDrawable(R.drawable.scene_ic_call_incoming_vowifi_video);
                                        kotlin.jvm.internal.i.c(drawable6);
                                    } else {
                                        Context context4 = this.f17115a;
                                        kotlin.jvm.internal.i.c(context4);
                                        drawable6 = context4.getDrawable(R.drawable.scene_ic_call_incoming_vowifi);
                                        kotlin.jvm.internal.i.c(drawable6);
                                    }
                                } else if (Q10) {
                                    Context context5 = this.f17115a;
                                    kotlin.jvm.internal.i.c(context5);
                                    drawable6 = context5.getDrawable(R.drawable.scene_ic_call_incoming_video);
                                    kotlin.jvm.internal.i.c(drawable6);
                                } else {
                                    Context context6 = this.f17115a;
                                    kotlin.jvm.internal.i.c(context6);
                                    drawable6 = context6.getDrawable(R.drawable.scene_ic_call_incoming);
                                    kotlin.jvm.internal.i.c(drawable6);
                                }
                                kotlin.jvm.internal.i.e(drawable6, "{\n                if (is…          }\n            }");
                                return drawable6;
                            }
                            if (this.f17110C) {
                                if (Q10) {
                                    Context context7 = this.f17115a;
                                    kotlin.jvm.internal.i.c(context7);
                                    drawable5 = context7.getDrawable(R.drawable.scene_ic_call_outgoing_vowifi_video);
                                    kotlin.jvm.internal.i.c(drawable5);
                                } else {
                                    Context context8 = this.f17115a;
                                    kotlin.jvm.internal.i.c(context8);
                                    drawable5 = context8.getDrawable(R.drawable.scene_ic_call_outgoing_vowifi);
                                    kotlin.jvm.internal.i.c(drawable5);
                                }
                            } else if (Q10) {
                                Context context9 = this.f17115a;
                                kotlin.jvm.internal.i.c(context9);
                                drawable5 = context9.getDrawable(R.drawable.scene_ic_call_outgoing_video);
                                kotlin.jvm.internal.i.c(drawable5);
                            } else {
                                Context context10 = this.f17115a;
                                kotlin.jvm.internal.i.c(context10);
                                drawable5 = context10.getDrawable(R.drawable.scene_ic_call_outgoing);
                                kotlin.jvm.internal.i.c(drawable5);
                            }
                            kotlin.jvm.internal.i.e(drawable5, "{\n                if (is…          }\n            }");
                            return drawable5;
                        }
                        if (Q10) {
                            if (R10) {
                                Context context11 = this.f17115a;
                                kotlin.jvm.internal.i.c(context11);
                                drawable4 = context11.getDrawable(R.drawable.scene_ic_call_rejected_vowifi_video);
                                kotlin.jvm.internal.i.c(drawable4);
                            } else {
                                Context context12 = this.f17115a;
                                kotlin.jvm.internal.i.c(context12);
                                drawable4 = context12.getDrawable(R.drawable.scene_ic_call_declined_video);
                                kotlin.jvm.internal.i.c(drawable4);
                            }
                        } else if (R10) {
                            Context context13 = this.f17115a;
                            kotlin.jvm.internal.i.c(context13);
                            drawable4 = context13.getDrawable(R.drawable.scene_ic_call_rejected_vowifi);
                            kotlin.jvm.internal.i.c(drawable4);
                        } else {
                            Context context14 = this.f17115a;
                            kotlin.jvm.internal.i.c(context14);
                            drawable4 = context14.getDrawable(R.drawable.scene_ic_call_declined);
                            kotlin.jvm.internal.i.c(drawable4);
                        }
                        kotlin.jvm.internal.i.e(drawable4, "{\n                if (is…          }\n            }");
                        return drawable4;
                    }
                    Context context15 = this.f17115a;
                    kotlin.jvm.internal.i.c(context15);
                    Drawable drawable8 = context15.getDrawable(R.drawable.scene_ic_call_voicemail);
                    kotlin.jvm.internal.i.c(drawable8);
                    kotlin.jvm.internal.i.e(drawable8, "{\n                contex…oicemail)!!\n            }");
                    return drawable8;
                }
                if (Q10) {
                    if (R10) {
                        Context context16 = this.f17115a;
                        kotlin.jvm.internal.i.c(context16);
                        drawable3 = context16.getDrawable(R.drawable.scene_ic_call_missed_vowifi_video);
                        kotlin.jvm.internal.i.c(drawable3);
                    } else {
                        Context context17 = this.f17115a;
                        kotlin.jvm.internal.i.c(context17);
                        drawable3 = context17.getDrawable(R.drawable.scene_ic_call_missed_video);
                        kotlin.jvm.internal.i.c(drawable3);
                    }
                } else if (R10) {
                    Context context18 = this.f17115a;
                    kotlin.jvm.internal.i.c(context18);
                    drawable3 = context18.getDrawable(R.drawable.scene_ic_call_missed_vowifi);
                    kotlin.jvm.internal.i.c(drawable3);
                } else {
                    Context context19 = this.f17115a;
                    kotlin.jvm.internal.i.c(context19);
                    drawable3 = context19.getDrawable(R.drawable.scene_ic_call_missed);
                    kotlin.jvm.internal.i.c(drawable3);
                }
                kotlin.jvm.internal.i.e(drawable3, "{\n                if (is…          }\n            }");
                return drawable3;
            }
            if (Q10) {
                if (R10) {
                    Context context20 = this.f17115a;
                    kotlin.jvm.internal.i.c(context20);
                    drawable2 = context20.getDrawable(R.drawable.scene_ic_call_outgoing_vowifi_video);
                    kotlin.jvm.internal.i.c(drawable2);
                } else {
                    Context context21 = this.f17115a;
                    kotlin.jvm.internal.i.c(context21);
                    drawable2 = context21.getDrawable(R.drawable.scene_ic_call_outgoing_video);
                    kotlin.jvm.internal.i.c(drawable2);
                }
            } else if (R10) {
                Context context22 = this.f17115a;
                kotlin.jvm.internal.i.c(context22);
                drawable2 = context22.getDrawable(R.drawable.scene_ic_call_outgoing_vowifi);
                kotlin.jvm.internal.i.c(drawable2);
            } else {
                Context context23 = this.f17115a;
                kotlin.jvm.internal.i.c(context23);
                drawable2 = context23.getDrawable(R.drawable.scene_ic_call_outgoing);
                kotlin.jvm.internal.i.c(drawable2);
            }
            kotlin.jvm.internal.i.e(drawable2, "{\n                if (is…          }\n            }");
            return drawable2;
        }
        if (Q10) {
            if (R10) {
                Context context24 = this.f17115a;
                kotlin.jvm.internal.i.c(context24);
                drawable = context24.getDrawable(R.drawable.scene_ic_call_incoming_vowifi_video);
                kotlin.jvm.internal.i.c(drawable);
            } else {
                Context context25 = this.f17115a;
                kotlin.jvm.internal.i.c(context25);
                drawable = context25.getDrawable(R.drawable.scene_ic_call_incoming_video);
                kotlin.jvm.internal.i.c(drawable);
            }
        } else if (R10) {
            Context context26 = this.f17115a;
            kotlin.jvm.internal.i.c(context26);
            drawable = context26.getDrawable(R.drawable.scene_ic_call_incoming_vowifi);
            kotlin.jvm.internal.i.c(drawable);
        } else {
            Context context27 = this.f17115a;
            kotlin.jvm.internal.i.c(context27);
            drawable = context27.getDrawable(R.drawable.scene_ic_call_incoming);
            kotlin.jvm.internal.i.c(drawable);
        }
        kotlin.jvm.internal.i.e(drawable, "{\n                if (is…          }\n            }");
        return drawable;
    }
}
