package com.android.contacts.detail;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.android.contacts.C0594d;
import com.android.contacts.ContactsApplication;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.d1;
import com.android.contacts.detail.z0;
import com.android.contacts.model.AccountType;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.MoreCallLogActivity;
import com.customize.contacts.util.C0811w;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.oplus.dialer.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import r0.C1498a;

/* compiled from: DetailEntryFactory.java */
/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f14602a = String.valueOf(';');

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14603a;

        static {
            int[] iArr = new int[PhoneNumberUtil.MatchType.values().length];
            f14603a = iArr;
            try {
                iArr[PhoneNumberUtil.MatchType.NOT_A_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14603a[PhoneNumberUtil.MatchType.NO_MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14603a[PhoneNumberUtil.MatchType.EXACT_MATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14603a[PhoneNumberUtil.MatchType.SHORT_NSN_MATCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14603a[PhoneNumberUtil.MatchType.NSN_MATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class b extends m {
        public b() {
            super(8);
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class c extends m {

        /* renamed from: e, reason: collision with root package name */
        public int f14604e;

        /* renamed from: f, reason: collision with root package name */
        public String f14605f;
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class d extends m {

        /* renamed from: e, reason: collision with root package name */
        public String f14606e;

        /* renamed from: f, reason: collision with root package name */
        public PhoneCallDetails f14607f;

        public d() {
            super(6);
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class e extends m {
        public e() {
            super(11);
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class f extends m implements C0594d.a<f> {

        /* renamed from: A, reason: collision with root package name */
        public CharSequence f14608A;

        /* renamed from: B, reason: collision with root package name */
        public boolean f14609B;

        /* renamed from: C, reason: collision with root package name */
        public String f14610C;

        /* renamed from: D, reason: collision with root package name */
        public boolean f14611D;

        /* renamed from: E, reason: collision with root package name */
        public String f14612E;

        /* renamed from: F, reason: collision with root package name */
        public boolean f14613F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f14614G;

        /* renamed from: e, reason: collision with root package name */
        public int f14615e;

        /* renamed from: f, reason: collision with root package name */
        public String f14616f;

        /* renamed from: g, reason: collision with root package name */
        public String f14617g;

        /* renamed from: h, reason: collision with root package name */
        public String f14618h;

        /* renamed from: i, reason: collision with root package name */
        public Uri f14619i;

        /* renamed from: j, reason: collision with root package name */
        public int f14620j;

        /* renamed from: k, reason: collision with root package name */
        public String f14621k;

        /* renamed from: l, reason: collision with root package name */
        public String f14622l;

        /* renamed from: m, reason: collision with root package name */
        public String f14623m;

        /* renamed from: n, reason: collision with root package name */
        public Context f14624n;

        /* renamed from: o, reason: collision with root package name */
        public String f14625o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f14626p;

        /* renamed from: q, reason: collision with root package name */
        public int f14627q;

        /* renamed from: r, reason: collision with root package name */
        public int f14628r;

        /* renamed from: s, reason: collision with root package name */
        public Intent f14629s;

        /* renamed from: t, reason: collision with root package name */
        public Intent f14630t;

        /* renamed from: u, reason: collision with root package name */
        public Intent f14631u;

        /* renamed from: v, reason: collision with root package name */
        public ArrayList<Long> f14632v;

        /* renamed from: w, reason: collision with root package name */
        public int f14633w;

        /* renamed from: x, reason: collision with root package name */
        public int f14634x;

        /* renamed from: y, reason: collision with root package name */
        public int f14635y;

        /* renamed from: z, reason: collision with root package name */
        public int f14636z;

        public f() {
            super(0);
            this.f14615e = -1;
            this.f14620j = 1;
            this.f14622l = "";
            this.f14624n = null;
            this.f14625o = null;
            this.f14626p = false;
            this.f14627q = -1;
            this.f14628r = -1;
            this.f14630t = null;
            this.f14631u = null;
            this.f14632v = new ArrayList<>();
            this.f14633w = 0;
            this.f14634x = -1;
            this.f14635y = -1;
            this.f14636z = 0;
            this.f14608A = null;
            this.f14609B = false;
            this.f14613F = false;
            this.f14614G = true;
            this.f14645c = true;
        }

        public static f h(Context context, String str, String str2) {
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14629s = new Intent();
            fVar.f14621k = "vnd.android.cursor.item/account";
            fVar.f14617g = str;
            fVar.f14618h = str2;
            return fVar;
        }

        public static f i(Context context, long j10, ArrayList<String> arrayList, boolean z10) {
            String string;
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/custom_blacklist";
            fVar.f14616f = context.getString(R.string.oplus_black_list);
            if (z10) {
                string = context.getString(R.string.remove_from_blacklist);
            } else {
                string = context.getString(R.string.oplus_intercept_contact);
            }
            fVar.f14618h = string;
            fVar.f14629s = i0.h(j10, z10, arrayList);
            fVar.f14644b = true;
            return fVar;
        }

        public static f j(Context context, String str) {
            if (H7.a.b()) {
                H7.b.b("DetailEntryFactory", "buildBusinessCardPhotoEntry: uri = " + str);
            }
            if (!TextUtils.isEmpty(str) && str.startsWith("content://")) {
                try {
                    InputStream openInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e10) {
                            H7.b.c("DetailEntryFactory", "buildBusinessCardPhotoEntry: " + e10);
                        }
                    }
                    f fVar = new f();
                    fVar.f14624n = context;
                    fVar.f14616f = context.getString(R.string.business_card);
                    fVar.f14618h = context.getString(R.string.show_business_card_photo);
                    fVar.f14621k = "vnd.android.cursor.item/business_card_photo";
                    fVar.f14629s = i0.k(context, Uri.parse(str));
                    return fVar;
                } catch (FileNotFoundException e11) {
                    H7.b.c("DetailEntryFactory", "buildBusinessCardPhotoEntry: " + e11);
                }
            }
            return null;
        }

        public static f k(Context context) {
            f fVar = new f();
            fVar.f14624n = context;
            Intent intent = new Intent(C1498a.f36244c);
            intent.putExtra("start_type", "contacts");
            fVar.f14629s = intent;
            fVar.f14621k = "vnd.android.cursor.item/emergency_contact";
            fVar.f14635y = w(context, R.attr.couiButtonNextStyle);
            fVar.f14618h = context.getString(R.string.emergency_contact);
            return fVar;
        }

        public static f l(Context context, String str, int i10, String str2, boolean z10) {
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/contact_event";
            fVar.f14617g = str;
            fVar.f14615e = i10;
            fVar.f14618h = str2;
            fVar.f14609B = z10;
            fVar.f14618h = l.b(context, str2, z10);
            fVar.f14629s = i0.j(str2, z10);
            fVar.f14644b = true;
            return fVar;
        }

        public static f m(Context context, String str) {
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/group";
            String string = context.getString(R.string.groupsLabel);
            fVar.f14616f = string;
            fVar.f14618h = str;
            fVar.f14617g = string;
            fVar.f14629s = new Intent();
            return fVar;
        }

        public static f n(Context context) {
            f fVar = new f();
            fVar.f14624n = context;
            Intent intent = new Intent(C1498a.f36243b);
            intent.putExtra("start_type", "contacts");
            fVar.f14629s = intent;
            fVar.f14621k = "vnd.android.cursor.item/first_aid";
            fVar.f14635y = w(context, R.attr.couiButtonNextStyle);
            fVar.f14618h = context.getString(R.string.medical_information);
            return fVar;
        }

        public static f o(Context context, CharSequence charSequence) {
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/name";
            fVar.f14618h = charSequence.toString();
            return fVar;
        }

        public static f p(Context context, String str, String str2) {
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14616f = context.getString(R.string.label_ringtone);
            String string = context.getString(R.string.follow_system_ringtone);
            if (TextUtils.isEmpty(str) || Settings.System.DEFAULT_RINGTONE_URI.equals(fVar.f14619i)) {
                str2 = string;
            }
            if (com.customize.contacts.manager.i.k(str) && !com.android.contacts.util.w.k(context, com.android.contacts.util.w.e())) {
                fVar.f14618h = context.getString(R.string.click_authorize_to_view_and_edit);
                fVar.f14614G = false;
            } else {
                fVar.f14618h = str2;
            }
            if (fVar.f14618h == null) {
                fVar.f14618h = string;
            }
            fVar.f14621k = "vnd.android.cursor.item/custom_ringtone";
            Intent a10 = com.customize.contacts.manager.i.a(context, str);
            fVar.f14629s = a10;
            com.customize.contacts.util.S.a(a10, context.getText(R.string.oplus_incoming_ring));
            return fVar;
        }

        public static f q(Context context) {
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/custom_send_contact";
            fVar.f14618h = context.getString(R.string.oplus_share);
            fVar.f14629s = i0.n(context);
            fVar.f14644b = true;
            return fVar;
        }

        public static f r(Context context, String str) {
            if (!com.customize.contacts.manager.h.l(context, str)) {
                return null;
            }
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14618h = com.customize.contacts.manager.h.e(context, str, null);
            fVar.f14616f = context.getString(R.string.incoming_call_vibration_title);
            fVar.f14621k = "vnd.android.cursor.item/custom_vibration";
            fVar.f14629s = com.customize.contacts.manager.h.a(context, str);
            return fVar;
        }

        public static f s(Context context, ArrayList<String> arrayList, boolean z10, boolean z11) {
            String string;
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/vip_group";
            fVar.f14616f = context.getString(R.string.oplus_black_list);
            if (z10) {
                string = context.getString(R.string.oplus_remove_contacts_from_vip);
            } else {
                string = context.getString(R.string.oplus_add_contacts_to_vip);
            }
            fVar.f14618h = string;
            fVar.f14629s = i0.l(arrayList, z10, z11);
            fVar.f14644b = true;
            return fVar;
        }

        public static f t(Context context, long j10, ArrayList<String> arrayList, boolean z10, boolean z11) {
            String string;
            boolean z12;
            f fVar = new f();
            fVar.f14624n = context;
            fVar.f14621k = "vnd.android.cursor.item/custom_blacklist";
            fVar.f14616f = context.getString(R.string.oplus_black_list);
            if (!z11 && z10) {
                string = context.getString(R.string.oplus_remove_contact_from_whitelist);
            } else {
                string = context.getString(R.string.oplus_add_contact_to_whitelist);
            }
            fVar.f14618h = string;
            if (!z11 && z10) {
                z12 = true;
            } else {
                z12 = false;
            }
            fVar.f14629s = i0.m(j10, z12, arrayList);
            fVar.f14644b = true;
            return fVar;
        }

        public static f v(Context context, String str, com.android.contacts.model.c cVar, long j10, ContentValues contentValues, boolean z10, long j11, boolean z11) {
            String str2;
            f fVar = new f();
            fVar.f14643a = j10;
            fVar.f14632v.add(Long.valueOf(j10));
            fVar.f14624n = context;
            Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, fVar.f14643a);
            fVar.f14619i = withAppendedId;
            if (z10) {
                fVar.f14619i = withAppendedId.buildUpon().appendQueryParameter("directory", String.valueOf(j11)).build();
            }
            if ("vnd.android.cursor.item/phone_v2".equals(str)) {
                fVar.f14646d = 4;
            }
            fVar.f14621k = str;
            int i10 = cVar.f17005d;
            if (i10 == -1 || i10 == 0) {
                str2 = "";
            } else {
                str2 = context.getString(i10);
            }
            fVar.f14616f = str2;
            fVar.f14618h = i0.i(cVar, contentValues, context);
            fVar.f14625o = cVar.f17003b;
            fVar.f14610C = contentValues.getAsString("raw_contact_id");
            fVar.f14611D = z11;
            fVar.f14612E = contentValues.getAsString("data6");
            String str3 = cVar.f17015n;
            if (str3 != null && contentValues.containsKey(str3)) {
                Integer asInteger = contentValues.getAsInteger(cVar.f17015n);
                if (asInteger != null) {
                    fVar.f14615e = asInteger.intValue();
                }
                fVar.f14617g = "";
                for (AccountType.c cVar2 : cVar.f17017p) {
                    if (cVar2.f16960a == fVar.f14615e) {
                        String str4 = cVar2.f16964e;
                        if (str4 == null) {
                            fVar.f14617g = context.getString(cVar2.f16961b);
                        } else {
                            fVar.f14617g = contentValues.getAsString(str4);
                        }
                    }
                }
            } else {
                fVar.f14617g = "";
            }
            try {
                if ("vnd.android.cursor.item/im".equals(str)) {
                    Long asLong = contentValues.getAsLong(cVar.f17015n);
                    if (FeatureOption.i() && (asLong.longValue() == 0 || asLong.longValue() == 1 || asLong.longValue() == 2 || asLong.longValue() == 3 || asLong.longValue() == 5 || asLong.longValue() == 6 || asLong.longValue() == 7 || asLong.longValue() == 8)) {
                        fVar.f14617g = context.getString(ContactsContract.CommonDataKinds.Im.getProtocolLabelResource(asLong.intValue()));
                    } else if (asLong.longValue() == 15 && FeatureOption.o()) {
                        fVar.f14617g = context.getString(R.string.imProtocolWeChat);
                    }
                }
            } catch (Exception unused) {
                H7.b.c("DetailEntryFactory", "IM type is wrong");
                fVar.f14617g = "";
            }
            return fVar;
        }

        public static int w(Context context, int i10) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
            try {
                return obtainStyledAttributes.getResourceId(0, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        @Override // com.android.contacts.detail.i0.m
        public void c(View view, z0.h hVar) {
            if (hVar != null && this.f14629s != null) {
                if ("vnd.android.cursor.item/phone_v2".equals(this.f14621k)) {
                    Map<String, String> b02 = com.customize.contacts.util.h0.b0(this.f14624n);
                    com.android.contacts.framework.baseui.util.A.a(this.f14624n, 2000305, 200030061, b02, false);
                    com.customize.contacts.util.h0.p(this.f14624n, "number", b02);
                } else if ("vnd.android.cursor.item/email_v2".equals(this.f14621k)) {
                    com.customize.contacts.util.h0.o(this.f14624n, "email");
                } else if ("vnd.android.cursor.item/im".equals(this.f14621k)) {
                    com.customize.contacts.util.h0.o(this.f14624n, "instant_message");
                } else if ("vnd.android.cursor.item/website".equals(this.f14621k)) {
                    com.customize.contacts.util.h0.o(this.f14624n, "website");
                } else if ("vnd.android.cursor.item/postal-address_v2".equals(this.f14621k)) {
                    com.customize.contacts.util.h0.o(this.f14624n, "address");
                } else if ("vnd.android.cursor.item/contact_event".equals(this.f14621k)) {
                    com.customize.contacts.util.h0.o(this.f14624n, BreenoCallContract.BaseColumns.DATE);
                } else {
                    if ("vnd.android.cursor.item/note".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "note");
                        return;
                    }
                    if ("vnd.android.cursor.item/relation".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "affiliated_person");
                        return;
                    }
                    if ("vnd.android.cursor.item/nickname".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "nickname");
                        return;
                    }
                    if ("vnd.android.cursor.item/group".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "group");
                        return;
                    } else if ("vnd.android.cursor.item/account".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "save_place");
                        return;
                    } else if ("vnd.android.cursor.item/custom_ringtone".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "incall_ringtone");
                    } else if ("vnd.android.cursor.item/custom_vibration".equals(this.f14621k)) {
                        com.customize.contacts.util.h0.o(this.f14624n, "incall_vibration");
                    }
                }
                hVar.d(this.f14629s);
            }
        }

        public f g(com.android.contacts.util.n nVar, boolean z10) {
            this.f14634x = nVar.d();
            if (z10 && nVar.h()) {
                this.f14618h = nVar.e().toString();
                this.f14608A = nVar.g(this.f14624n);
            }
            return this;
        }

        @Override // com.android.contacts.C0594d.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public boolean a(f fVar) {
            boolean z10 = false;
            if (!b(fVar)) {
                return false;
            }
            if (d1.a(this.f14621k, this.f14615e) > d1.a(fVar.f14621k, fVar.f14615e)) {
                this.f14615e = fVar.f14615e;
                this.f14616f = fVar.f14616f;
                this.f14617g = fVar.f14617g;
            }
            this.f14620j = Math.max(this.f14620j, fVar.f14620j);
            if (ContactsContract.StatusUpdates.getPresencePrecedence(this.f14634x) < ContactsContract.StatusUpdates.getPresencePrecedence(fVar.f14634x)) {
                this.f14634x = fVar.f14634x;
            }
            if (fVar.f14626p || this.f14626p) {
                z10 = true;
            }
            this.f14626p = z10;
            this.f14632v.add(Long.valueOf(fVar.d()));
            this.f14633w++;
            return true;
        }

        @Override // com.android.contacts.C0594d.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public boolean b(f fVar) {
            boolean z10;
            boolean z11;
            if (fVar == null) {
                return false;
            }
            if ((!this.f14611D && TextUtils.equals(this.f14610C, fVar.f14610C)) || !i0.p(this.f14621k, this.f14618h, fVar.f14621k, fVar.f14618h) || !TextUtils.equals(this.f14621k, fVar.f14621k) || !C7.e.a(this.f14629s, fVar.f14629s) || !C7.e.a(this.f14630t, fVar.f14630t)) {
                return false;
            }
            if (TextUtils.equals("vnd.android.cursor.item/phone_v2", this.f14621k)) {
                int i10 = this.f14615e;
                if (i10 != 4 && i10 != 5) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i11 = fVar.f14615e;
                if (i11 != 4 && i11 != 5) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z10 != z11) {
                    return false;
                }
            }
            if ((TextUtils.equals("vnd.android.cursor.item/contact_event", this.f14621k) || TextUtils.equals("vnd.android.cursor.item/im", this.f14621k)) && !TextUtils.equals(this.f14617g, fVar.f14617g)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class g extends m {
        public g() {
            super(1);
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class h extends m {

        /* renamed from: e, reason: collision with root package name */
        public final String f14637e;

        public String g() {
            return this.f14637e;
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class i extends m {

        /* renamed from: e, reason: collision with root package name */
        public final String f14638e;

        /* renamed from: f, reason: collision with root package name */
        public final View.OnClickListener f14639f;

        public i(String str, View.OnClickListener onClickListener) {
            super(7);
            this.f14638e = str;
            this.f14639f = onClickListener;
        }

        public View.OnClickListener g() {
            return this.f14639f;
        }

        public String h() {
            return this.f14638e;
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class j extends m {
        public j() {
            super(10);
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class k extends m {

        /* renamed from: e, reason: collision with root package name */
        public final Drawable f14640e;

        /* renamed from: f, reason: collision with root package name */
        public final CharSequence f14641f;

        /* renamed from: g, reason: collision with root package name */
        public final View.OnClickListener f14642g;

        public k(Drawable drawable, CharSequence charSequence, View.OnClickListener onClickListener) {
            super(3);
            this.f14640e = drawable;
            this.f14641f = charSequence;
            this.f14642g = onClickListener;
            this.f14645c = false;
            if (onClickListener != null) {
                this.f14644b = true;
            }
        }

        public static k g(Context context, AccountType accountType) {
            return new k(accountType.e(context), accountType.f(context), null);
        }

        @Override // com.android.contacts.detail.i0.m
        public void c(View view, z0.h hVar) {
            View.OnClickListener onClickListener = this.f14642g;
            if (onClickListener == null) {
                return;
            }
            onClickListener.onClick(view);
        }

        public Drawable h() {
            return this.f14640e;
        }

        public CharSequence i() {
            return this.f14641f;
        }

        public View.OnClickListener j() {
            return this.f14642g;
        }
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static final class l {
        public static String b(Context context, String str, boolean z10) {
            Date r10 = F7.b.r(str);
            if (r10 != null && z10) {
                return com.customize.contacts.util.N.h(context, r10.getYear() + COUIDateMonthView.MIN_YEAR, r10.getMonth() + 1, r10.getDate());
            }
            return F7.b.b(context, str);
        }

        public static int c(Integer num) {
            if (num == null) {
                return ContactsContract.CommonDataKinds.Event.getTypeResource(num);
            }
            int intValue = num.intValue();
            if (intValue != 1) {
                if (intValue != 3) {
                    if (intValue != 1000) {
                        return ContactsContract.CommonDataKinds.Event.getTypeResource(num);
                    }
                    return R.string.event_type_birthday_chinese;
                }
                if (F7.b.k(ContactsApplication.h(), FeatureOption.i())) {
                    return R.string.event_type_solar_birthday_chinese;
                }
                return R.string.eventLabelsGroup;
            }
            return R.string.oplus_anniversary;
        }
    }

    public static Intent h(long j10, boolean z10, ArrayList<String> arrayList) {
        ContactParcelable contactParcelable = new ContactParcelable();
        contactParcelable.q(j10);
        contactParcelable.i(arrayList);
        Intent intent = new Intent("com.oplus.contacts.black.action");
        intent.putExtra("black_list_data", contactParcelable);
        intent.putExtra("is_black", z10);
        return intent;
    }

    public static String i(com.android.contacts.model.c cVar, ContentValues contentValues, Context context) {
        CharSequence a10;
        AccountType.e eVar = cVar.f17013l;
        if (eVar == null || (a10 = eVar.a(context, contentValues)) == null) {
            return null;
        }
        return a10.toString();
    }

    public static Intent j(String str, boolean z10) {
        Intent intent = new Intent("oplus.intent.action.AGENDA");
        intent.putExtra("event_data", str);
        intent.putExtra("is_lunar", z10);
        return intent;
    }

    public static Intent k(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (P7.c.f(context, C0811w.c(context), false)) {
            intent.setPackage(C0811w.c(context));
        }
        Uri f10 = com.android.contacts.util.i.f(context);
        com.android.contacts.util.i.u(context, uri, f10, false);
        intent.setDataAndType(f10, "image/*");
        intent.addFlags(1);
        intent.putExtra("SingleItemOnly", true);
        return intent;
    }

    public static Intent l(ArrayList<String> arrayList, boolean z10, boolean z11) {
        Intent intent = new Intent("oplus.intent.action.VIP_GROUP");
        ContactParcelable contactParcelable = new ContactParcelable();
        contactParcelable.i(arrayList);
        intent.putExtra("black_list_data", contactParcelable);
        intent.putExtra("is_black", z11);
        intent.putExtra("is_vip_group", z10);
        return intent;
    }

    public static Intent m(long j10, boolean z10, ArrayList<String> arrayList) {
        ContactParcelable contactParcelable = new ContactParcelable();
        contactParcelable.q(j10);
        contactParcelable.i(arrayList);
        Intent intent = new Intent("com.oplus.contacts.white.action");
        intent.putExtra("black_list_data", contactParcelable);
        intent.putExtra("is_white", z10);
        return intent;
    }

    public static Intent n(Context context) {
        return new Intent("com.oplus.contacts.action.SEND_CONTACT");
    }

    public static Intent o(Context context, String[] strArr, String[] strArr2) {
        Intent intent = new Intent(context, (Class<?>) MoreCallLogActivity.class);
        intent.setAction("oplus.intent.contacts.action.VIEW_CALL_LOGS");
        intent.putExtra("calllog_numbers", strArr);
        intent.putExtra("calllog_normalized_numbers", strArr2);
        return intent;
    }

    public static final boolean p(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        if (!TextUtils.equals(charSequence, charSequence3)) {
            return false;
        }
        if (TextUtils.equals(charSequence2, charSequence4)) {
            return true;
        }
        if (charSequence2 == null || charSequence4 == null) {
            return false;
        }
        if ((TextUtils.equals(charSequence, charSequence3) && TextUtils.equals("vnd.android.cursor.item/phone_v2", charSequence) && !TextUtils.equals(charSequence2, charSequence4)) || !TextUtils.equals("vnd.android.cursor.item/phone_v2", charSequence)) {
            return false;
        }
        String charSequence5 = charSequence2.toString();
        String str = f14602a;
        String[] split = charSequence5.split(str);
        String[] split2 = charSequence4.toString().split(str);
        if (split.length != split2.length) {
            return false;
        }
        PhoneNumberUtil C10 = PhoneNumberUtil.C();
        for (int i10 = 0; i10 < split.length; i10++) {
            String str2 = split[i10];
            String str3 = split2[i10];
            if (!TextUtils.equals(str2, str3)) {
                int i11 = a.f14603a[C10.V(str2, str3).ordinal()];
                if (i11 == 1 || i11 == 2) {
                    return false;
                }
                if (i11 != 3 && i11 != 4 && i11 != 5) {
                    H7.b.c("DetailEntryFactory", "Unknown result value from phone number library");
                    return false;
                }
            }
        }
        return true;
    }

    /* compiled from: DetailEntryFactory.java */
    /* loaded from: classes.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public long f14643a = -1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f14644b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14645c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f14646d;

        public m(int i10) {
            this.f14646d = i10;
        }

        public long d() {
            return this.f14643a;
        }

        public int e() {
            return this.f14646d;
        }

        public boolean f() {
            return this.f14645c;
        }

        public void c(View view, z0.h hVar) {
        }
    }
}
