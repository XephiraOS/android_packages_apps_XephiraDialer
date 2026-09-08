package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.provider.Contacts;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseIntArray;
import com.android.contacts.editor.EventFieldEditorView;
import com.android.contacts.editor.PhoneticNameEditorView;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.A;
import com.android.contacts.util.q;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.K;
import com.customize.contacts.util.b0;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import n1.AbstractC1362a;
import p.C1416b;
import w0.C1643c;

/* compiled from: EntityModifier.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f17022a = {"vnd.android.cursor.item/organization", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/note", "vnd.android.cursor.item/website", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/custom_ringtone", "vnd.android.cursor.item/custom_vibration"};

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f17023b = new HashSet(Arrays.asList("vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/website", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/sip_address"));

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f17024c = new HashSet(Arrays.asList("vnd.android.cursor.item/organization", "vnd.android.cursor.item/note", "vnd.android.cursor.item/photo", "vnd.android.cursor.item/group_membership"));

    public static void A(EntityDelta entityDelta, EntityDelta entityDelta2, c cVar, boolean z10) {
        Integer num;
        int i10;
        int i11;
        List<AccountType.c> list;
        ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(cVar.f17004c);
        if (D10 != null && !D10.isEmpty()) {
            ContentValues contentValues = cVar.f17019r;
            if (contentValues != null) {
                num = contentValues.getAsInteger("data2");
            } else {
                num = null;
            }
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            if (num != null) {
                hashSet.add(num);
                hashMap.put(num, -1);
            }
            if (!"vnd.android.cursor.item/im".equals(cVar.f17004c) && (list = cVar.f17017p) != null && !list.isEmpty()) {
                for (AccountType.c cVar2 : cVar.f17017p) {
                    hashSet.add(Integer.valueOf(cVar2.f16960a));
                    hashMap.put(Integer.valueOf(cVar2.f16960a), Integer.valueOf(cVar2.f16963d));
                }
                if (num == null) {
                    num = Integer.valueOf(cVar.f17017p.get(0).f16960a);
                }
            }
            if (num == null) {
                H7.b.i("EntityModifier", "Default type isn't available for mimetype " + cVar.f17004c);
            }
            int i12 = cVar.f17016o;
            HashMap hashMap2 = new HashMap();
            Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
            int i13 = 0;
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (i12 == -1 || i13 < i12) {
                    ContentValues p10 = next.p();
                    if (p10 != null) {
                        Integer v10 = next.v("data2");
                        if (!hashSet.contains(v10)) {
                            if (num != null) {
                                p10.put("data2", num);
                                if (v10 != null && v10.intValue() == 0) {
                                    p10.remove("data3");
                                }
                                v10 = num;
                            } else {
                                p10.remove("data2");
                                v10 = null;
                            }
                        }
                        if (v10 != null) {
                            if (hashMap.containsKey(v10)) {
                                i10 = ((Integer) hashMap.get(v10)).intValue();
                            } else {
                                i10 = 0;
                            }
                            if (i10 >= 0) {
                                if (hashMap2.get(v10) != null) {
                                    i11 = ((Integer) hashMap2.get(v10)).intValue();
                                } else {
                                    i11 = 0;
                                }
                                if (i11 < i10) {
                                    hashMap2.put(v10, Integer.valueOf(i11 + 1));
                                }
                            }
                        }
                        if (z10 && "vnd.android.cursor.item/phone_v2".equals(cVar.f17004c)) {
                            if (!TextUtils.isEmpty(p10.getAsString("data1"))) {
                                entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                            }
                        } else {
                            entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                        }
                        i13++;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void B(EntityDelta entityDelta, EntityDelta entityDelta2, c cVar) {
        ArrayList<EntityDelta.ValuesDelta> d10 = d(entityDelta2, cVar, entityDelta.D(cVar.f17004c));
        if (d10 != null && !d10.isEmpty()) {
            Iterator<EntityDelta.ValuesDelta> it = d10.iterator();
            while (it.hasNext()) {
                ContentValues p10 = it.next().p();
                if (p10 != null) {
                    entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                }
            }
        }
    }

    public static void C(EntityDelta entityDelta, EntityDelta entityDelta2, c cVar) {
        String[] strArr;
        int i10;
        Iterator<EntityDelta.ValuesDelta> it;
        String str;
        HashSet hashSet;
        boolean z10;
        boolean z11;
        int i11;
        c cVar2 = cVar;
        ArrayList<EntityDelta.ValuesDelta> d10 = d(entityDelta2, cVar2, entityDelta.D("vnd.android.cursor.item/postal-address_v2"));
        if (d10 != null && !d10.isEmpty()) {
            int i12 = 0;
            String str2 = cVar2.f17018q.get(0).f16953a;
            boolean z12 = false;
            boolean z13 = false;
            for (AccountType.b bVar : cVar2.f17018q) {
                if ("data1".equals(bVar.f16953a)) {
                    z12 = true;
                }
                if ("data4".equals(bVar.f16953a)) {
                    z13 = true;
                }
            }
            HashSet hashSet2 = new HashSet();
            List<AccountType.c> list = cVar2.f17017p;
            if (list != null && !list.isEmpty()) {
                Iterator<AccountType.c> it2 = cVar2.f17017p.iterator();
                while (it2.hasNext()) {
                    hashSet2.add(Integer.valueOf(it2.next().f16960a));
                }
            }
            Iterator<EntityDelta.ValuesDelta> it3 = d10.iterator();
            while (it3.hasNext()) {
                ContentValues p10 = it3.next().p();
                if (p10 != null) {
                    Integer asInteger = p10.getAsInteger("data2");
                    if (!hashSet2.contains(asInteger)) {
                        ContentValues contentValues = cVar2.f17019r;
                        if (contentValues != null) {
                            i11 = contentValues.getAsInteger("data2").intValue();
                        } else {
                            List<AccountType.c> list2 = cVar2.f17017p;
                            if (list2 != null && list2.size() > 0) {
                                i11 = cVar2.f17017p.get(i12).f16960a;
                            } else {
                                i11 = i12;
                            }
                        }
                        p10.put("data2", Integer.valueOf(i11));
                        if (asInteger != null && asInteger.intValue() == 0) {
                            p10.remove("data3");
                        }
                    }
                    String asString = p10.getAsString("data1");
                    if (!TextUtils.isEmpty(asString)) {
                        if (!z12) {
                            p10.remove("data1");
                            if (z13) {
                                p10.put("data4", asString);
                            } else {
                                p10.put(str2, asString);
                            }
                        }
                    } else if (z12) {
                        if (K.c()) {
                            strArr = new String[]{p10.getAsString("data10"), p10.getAsString("data9"), p10.getAsString("data8"), p10.getAsString("data7"), p10.getAsString("data6"), p10.getAsString("data4"), p10.getAsString("data5")};
                            it = it3;
                            i10 = 0;
                        } else {
                            i10 = 0;
                            strArr = new String[]{p10.getAsString("data5"), p10.getAsString("data4"), p10.getAsString("data6"), p10.getAsString("data7"), p10.getAsString("data8"), p10.getAsString("data9"), p10.getAsString("data10")};
                            it = it3;
                        }
                        StringBuilder sb = new StringBuilder();
                        str = str2;
                        int length = strArr.length;
                        hashSet = hashSet2;
                        int i13 = i10;
                        while (i13 < length) {
                            int i14 = length;
                            String str3 = strArr[i13];
                            if (!TextUtils.isEmpty(str3)) {
                                z11 = z12;
                                sb.append(str3 + "\n");
                            } else {
                                z11 = z12;
                            }
                            i13++;
                            length = i14;
                            z12 = z11;
                        }
                        z10 = z12;
                        p10.put("data1", sb.toString());
                        p10.remove("data5");
                        p10.remove("data4");
                        p10.remove("data6");
                        p10.remove("data7");
                        p10.remove("data8");
                        p10.remove("data9");
                        p10.remove("data10");
                        entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                        it3 = it;
                        cVar2 = cVar;
                        str2 = str;
                        hashSet2 = hashSet;
                        z12 = z10;
                        i12 = i10;
                    }
                    it = it3;
                    str = str2;
                    i10 = i12;
                    hashSet = hashSet2;
                    z10 = z12;
                    entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                    it3 = it;
                    cVar2 = cVar;
                    str2 = str;
                    hashSet2 = hashSet;
                    z12 = z10;
                    i12 = i10;
                }
            }
        }
    }

    public static void D(Context context, EntityDelta entityDelta, EntityDelta entityDelta2, AccountType accountType, AccountType accountType2, String str) {
        int i10;
        if (accountType2 == accountType) {
            Iterator<c> it = accountType2.l().iterator();
            while (it.hasNext()) {
                c next = it.next();
                String str2 = next.f17004c;
                if ("vnd.android.cursor.item/name".equals(str2)) {
                    E(context, entityDelta, entityDelta2, next, "com.android.oplus.sim".equals(accountType2.f16944a));
                } else {
                    ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(str2);
                    if (D10 != null && !D10.isEmpty()) {
                        Iterator<EntityDelta.ValuesDelta> it2 = D10.iterator();
                        while (it2.hasNext()) {
                            ContentValues p10 = it2.next().p();
                            if (p10 != null) {
                                entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                            }
                        }
                    }
                }
            }
            return;
        }
        if ("com.android.oplus.sim".equals(accountType2.f16944a)) {
            if (str == null) {
                H7.b.i("EntityModifier", "account name is null!");
                return;
            }
            boolean P02 = b0.P0(context, com.customize.contacts.simcontacts.b.d(context, str));
            if (P02) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            Iterator<c> it3 = accountType2.l().iterator();
            while (it3.hasNext()) {
                c next2 = it3.next();
                if (next2.f17010i) {
                    String str3 = next2.f17004c;
                    if ("vnd.android.cursor.item/name".equals(str3)) {
                        E(context, entityDelta, entityDelta2, next2, true);
                    } else if ("vnd.android.cursor.item/phone_v2".equals(str3)) {
                        next2.f17016o = i10;
                        A(entityDelta, entityDelta2, next2, "com.android.oplus.sim".equals(accountType.f16944a));
                    } else if ("vnd.android.cursor.item/email_v2".equals(str3)) {
                        next2.f17016o = P02 ? 1 : 0;
                        A(entityDelta, entityDelta2, next2, "com.android.oplus.sim".equals(accountType.f16944a));
                    } else {
                        H7.b.e("EntityModifier", "not support these content!");
                    }
                }
            }
            return;
        }
        Iterator<c> it4 = accountType2.l().iterator();
        while (it4.hasNext()) {
            c next3 = it4.next();
            if (next3.f17010i) {
                String str4 = next3.f17004c;
                if (!"#displayName".equals(str4) && !"#phoneticName".equals(str4) && !"#prefixName".equals(str4) && !"#middleName".equals(str4) && !"#suffixName".equals(str4)) {
                    if ("vnd.android.cursor.item/name".equals(str4)) {
                        E(context, entityDelta, entityDelta2, next3, false);
                    } else if ("vnd.android.cursor.item/postal-address_v2".equals(str4)) {
                        C(entityDelta, entityDelta2, next3);
                    } else if (!"vnd.android.cursor.item/contact_event".equals(str4) && !"#anniversary".equals(str4)) {
                        if (f17024c.contains(str4)) {
                            B(entityDelta, entityDelta2, next3);
                        } else if (f17023b.contains(str4)) {
                            A(entityDelta, entityDelta2, next3, "com.android.oplus.sim".equals(accountType.f16944a));
                        } else {
                            H7.b.b("EntityModifier", "Unexpected editable mime-type: " + str4);
                        }
                    } else {
                        z(entityDelta, entityDelta2, next3, COUIDateMonthView.MIN_YEAR, str4);
                    }
                }
            }
        }
    }

    public static void E(Context context, EntityDelta entityDelta, EntityDelta entityDelta2, c cVar, boolean z10) {
        EntityDelta.ValuesDelta H10;
        ContentValues p10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str;
        if (entityDelta == null || (H10 = entityDelta.H("vnd.android.cursor.item/name")) == null || (p10 = H10.p()) == null) {
            return;
        }
        boolean z15 = false;
        if (!z10) {
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            for (AccountType.b bVar : cVar.f17018q) {
                if ("data1".equals(bVar.f16953a)) {
                    z15 = true;
                }
                if ("#phoneticName".equals(bVar.f16953a)) {
                    z11 = true;
                }
                if ("data9".equals(bVar.f16953a)) {
                    z12 = true;
                }
                if ("data8".equals(bVar.f16953a)) {
                    z13 = true;
                }
                if ("data7".equals(bVar.f16953a)) {
                    z14 = true;
                }
            }
        } else {
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
        }
        String asString = p10.getAsString("data1");
        if (TextUtils.isEmpty(asString)) {
            str = "data7";
            if (z15 || FeatureOption.i()) {
                p10.put("data1", q.f(context, p10));
            }
        } else if (z15) {
            str = "data7";
        } else {
            String asString2 = p10.getAsString("data3");
            String asString3 = p10.getAsString("data5");
            String asString4 = p10.getAsString("data2");
            String asString5 = p10.getAsString("data4");
            str = "data7";
            String asString6 = p10.getAsString("data6");
            if (TextUtils.isEmpty(asString2) && TextUtils.isEmpty(asString4) && TextUtils.isEmpty(asString3) && TextUtils.isEmpty(asString5) && TextUtils.isEmpty(asString6)) {
                q.b(context, asString, p10);
            } else if (FeatureOption.i()) {
                p10.put("data1", q.f(context, p10));
            }
        }
        String asString7 = p10.getAsString("#phoneticName");
        if (!TextUtils.isEmpty(asString7)) {
            if (!z11) {
                ContentValues q02 = PhoneticNameEditorView.q0(asString7, null);
                p10.remove("#phoneticName");
                if (z12) {
                    p10.put("data9", q02.getAsString("data9"));
                } else {
                    p10.remove("data9");
                }
                if (z13) {
                    p10.put("data8", q02.getAsString("data8"));
                } else {
                    p10.remove("data8");
                }
                if (z14) {
                    String str2 = str;
                    p10.put(str2, q02.getAsString(str2));
                } else {
                    p10.remove(str);
                }
            }
        } else {
            String str3 = str;
            if (z11) {
                p10.put("#phoneticName", PhoneticNameEditorView.n0(p10.getAsString("data9"), p10.getAsString("data8"), p10.getAsString(str3)));
            }
            if (!z12) {
                p10.remove("data9");
            }
            if (!z13) {
                p10.remove("data8");
            }
            if (!z14) {
                p10.remove(str3);
            }
        }
        entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
    }

    public static EntityDelta.ValuesDelta F(EntityDelta entityDelta, c cVar, Bundle bundle, String str, String str2, String str3) {
        int i10;
        CharSequence charSequence = bundle.getCharSequence(str2);
        if (cVar == null) {
            return null;
        }
        boolean c10 = c(entityDelta, cVar);
        if (charSequence == null || !TextUtils.isGraphic(charSequence) || !c10) {
            return null;
        }
        if (bundle.containsKey(str)) {
            i10 = 0;
        } else {
            i10 = Integer.MIN_VALUE;
        }
        AccountType.c g10 = g(entityDelta, cVar, false, bundle.getInt(str, i10));
        EntityDelta.ValuesDelta u10 = u(entityDelta, cVar, g10);
        u10.e0(str3, charSequence.toString());
        if (g10 != null && g10.f16964e != null) {
            u10.e0(g10.f16964e, bundle.getString(str));
        }
        return u10;
    }

    public static void G(Context context, AccountType accountType, EntityDelta entityDelta, Bundle bundle) {
        boolean z10;
        if (bundle != null && bundle.size() != 0) {
            H(context, accountType, entityDelta, bundle);
            I(accountType, entityDelta, bundle);
            c j10 = accountType.j("vnd.android.cursor.item/phone_v2");
            F(entityDelta, j10, bundle, "phone_type", "phone", "data1");
            F(entityDelta, j10, bundle, "secondary_phone_type", "secondary_phone", "data1");
            F(entityDelta, j10, bundle, "tertiary_phone_type", "tertiary_phone", "data1");
            c j11 = accountType.j("vnd.android.cursor.item/email_v2");
            F(entityDelta, j11, bundle, "email_type", "email", "data1");
            F(entityDelta, j11, bundle, "secondary_email_type", "secondary_email", "data1");
            F(entityDelta, j11, bundle, "tertiary_email_type", "tertiary_email", "data1");
            c j12 = accountType.j("vnd.android.cursor.item/im");
            f(bundle);
            F(entityDelta, j12, bundle, "im_protocol", "im_handle", "data1");
            if (C1643c.w() && C1643c.d(bundle)) {
                F(entityDelta, j12, bundle, "chatbot_serviceid_type", "serviceid", "data1");
            }
            if (!bundle.containsKey("company") && !bundle.containsKey("job_title")) {
                z10 = false;
            } else {
                z10 = true;
            }
            c j13 = accountType.j("vnd.android.cursor.item/organization");
            if (z10 && c(entityDelta, j13)) {
                EntityDelta.ValuesDelta t10 = t(entityDelta, j13);
                String string = bundle.getString("company");
                if (U7.f.c(string)) {
                    t10.e0("data1", string);
                }
                String string2 = bundle.getString("job_title");
                if (U7.f.c(string2)) {
                    t10.e0("data4", string2);
                }
            }
            boolean containsKey = bundle.containsKey("notes");
            c j14 = accountType.j("vnd.android.cursor.item/note");
            if (containsKey && c(entityDelta, j14)) {
                EntityDelta.ValuesDelta t11 = t(entityDelta, j14);
                String string3 = bundle.getString("notes");
                if (U7.f.c(string3)) {
                    t11.e0("data1", string3);
                }
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("NOTES_LIST");
            if (stringArrayList != null && !stringArrayList.isEmpty()) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (c(entityDelta, j14)) {
                        EntityDelta.ValuesDelta t12 = t(entityDelta, j14);
                        if (U7.f.c(next)) {
                            t12.e0("data1", next);
                        }
                    }
                }
            }
            if (C1643c.w()) {
                String j15 = C1643c.j(bundle);
                if (!TextUtils.isEmpty(j15) && c(entityDelta, accountType.j("vnd.android.cursor.item/website"))) {
                    EntityDelta.ValuesDelta t13 = t(entityDelta, accountType.j("vnd.android.cursor.item/website"));
                    if (U7.f.c(j15)) {
                        t13.e0("data1", j15);
                    }
                }
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("data");
            if (parcelableArrayList != null) {
                J(entityDelta, accountType, parcelableArrayList);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00db, code lost:
    
        if (r7 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f7, code lost:
    
        if (0 == 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void H(android.content.Context r16, com.android.contacts.model.AccountType r17, com.android.contacts.model.EntityDelta r18, android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.model.d.H(android.content.Context, com.android.contacts.model.AccountType, com.android.contacts.model.EntityDelta, android.os.Bundle):void");
    }

    public static void I(AccountType accountType, EntityDelta entityDelta, Bundle bundle) {
        String z10;
        c j10 = accountType.j("vnd.android.cursor.item/postal-address_v2");
        EntityDelta.ValuesDelta F10 = F(entityDelta, j10, bundle, "postal_type", "postal", "data1");
        if (F10 == null) {
            z10 = null;
        } else {
            z10 = F10.z("data1");
        }
        if (!TextUtils.isEmpty(z10)) {
            List<AccountType.b> list = j10.f17018q;
            if (list != null) {
                Iterator<AccountType.b> it = list.iterator();
                while (it.hasNext()) {
                    if ("data1".equals(it.next().f16953a)) {
                        return;
                    }
                }
            }
            if (F10 != null) {
                F10.e0("data4", z10);
                F10.k0("data1");
            }
        }
    }

    public static void J(EntityDelta entityDelta, AccountType accountType, ArrayList<ContentValues> arrayList) {
        int i10;
        Iterator<ContentValues> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentValues next = it.next();
            String asString = next.getAsString("mimetype");
            if (TextUtils.isEmpty(asString)) {
                H7.b.c("EntityModifier", "Mimetype is required. Ignoring: ");
            } else if (!"vnd.android.cursor.item/name".equals(asString)) {
                c j10 = accountType.j(asString);
                if (j10 == null) {
                    H7.b.c("EntityModifier", "Mimetype not supported for account type " + accountType.c() + ". Ignoring: " + next);
                } else {
                    EntityDelta.ValuesDelta m10 = EntityDelta.ValuesDelta.m(next);
                    if (!w(m10, j10)) {
                        ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(asString);
                        boolean z10 = false;
                        boolean z11 = true;
                        if (j10.f17016o == 1 && !"vnd.android.cursor.item/group_membership".equals(asString)) {
                            if (D10 != null && D10.size() > 0) {
                                Iterator<EntityDelta.ValuesDelta> it2 = D10.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        EntityDelta.ValuesDelta next2 = it2.next();
                                        if (!next2.H() && !w(next2, j10)) {
                                            break;
                                        }
                                    } else {
                                        z10 = true;
                                        break;
                                    }
                                }
                                if (z10) {
                                    Iterator<EntityDelta.ValuesDelta> it3 = D10.iterator();
                                    while (it3.hasNext()) {
                                        it3.next().Y();
                                    }
                                }
                                z11 = z10;
                            }
                            if (z11 && D10 != null) {
                                z11 = a(m10, D10, j10);
                            }
                            if (z11) {
                                entityDelta.d(m10);
                            } else if ("vnd.android.cursor.item/note".equals(asString)) {
                                Iterator<EntityDelta.ValuesDelta> it4 = D10.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        EntityDelta.ValuesDelta next3 = it4.next();
                                        if (!w(next3, j10)) {
                                            next3.e0("data1", next3.z("data1") + "\n" + next.getAsString("data1"));
                                            break;
                                        }
                                    }
                                }
                            } else {
                                H7.b.c("EntityModifier", "Will not override mimetype " + asString + ". Ignoring: ");
                            }
                        } else {
                            if (D10 != null && D10.size() > 0) {
                                Iterator<EntityDelta.ValuesDelta> it5 = D10.iterator();
                                i10 = 0;
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    EntityDelta.ValuesDelta next4 = it5.next();
                                    if (!next4.H()) {
                                        if (b(next4, next, j10)) {
                                            z11 = false;
                                            break;
                                        }
                                        i10++;
                                    }
                                }
                            } else {
                                i10 = 0;
                            }
                            int i11 = j10.f17016o;
                            if (i11 != -1 && i10 >= i11) {
                                H7.b.c("EntityModifier", "Mimetype allows at most " + j10.f17016o + " entries. Ignoring: ");
                            } else {
                                z10 = z11;
                            }
                            if (z10 && D10 != null) {
                                z10 = a(m10, D10, j10);
                            }
                            if (z10) {
                                entityDelta.d(m10);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void K(EntityDelta entityDelta) {
        for (String str : f17022a) {
            ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(str);
            if (D10 != null && D10.size() > 0) {
                Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EntityDelta.ValuesDelta next = it.next();
                        String z10 = next.z("data1");
                        if ("vnd.android.cursor.item/organization".equals(str)) {
                            String z11 = next.z("data4");
                            if (TextUtils.isEmpty(z10) && TextUtils.isEmpty(z11)) {
                            }
                        } else if (!TextUtils.isEmpty(z10)) {
                            break;
                        }
                    } else {
                        entityDelta.x().remove(str);
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x016e, code lost:
    
        if (r15 == false) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.Long> L(com.android.contacts.model.EntityDelta r21, com.android.contacts.model.AccountType r22, int r23) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.model.d.L(com.android.contacts.model.EntityDelta, com.android.contacts.model.AccountType, int):java.util.ArrayList");
    }

    public static boolean a(EntityDelta.ValuesDelta valuesDelta, ArrayList<EntityDelta.ValuesDelta> arrayList, c cVar) {
        List<AccountType.c> list;
        int i10;
        if (cVar.f17015n == null || (list = cVar.f17017p) == null || list.size() == 0) {
            return true;
        }
        Integer v10 = valuesDelta.v(cVar.f17015n);
        if (v10 != null) {
            i10 = v10.intValue();
        } else {
            i10 = cVar.f17017p.get(0).f16960a;
        }
        if (x(i10, arrayList, cVar)) {
            valuesDelta.b0(cVar.f17015n, i10);
            return true;
        }
        int size = cVar.f17017p.size();
        for (int i11 = 0; i11 < size; i11++) {
            AccountType.c cVar2 = cVar.f17017p.get(i11);
            if (x(cVar2.f16960a, arrayList, cVar)) {
                valuesDelta.b0(cVar.f17015n, cVar2.f16960a);
                return true;
            }
        }
        return false;
    }

    public static boolean b(EntityDelta.ValuesDelta valuesDelta, ContentValues contentValues, c cVar) {
        List<AccountType.b> list = cVar.f17018q;
        if (list == null) {
            return false;
        }
        for (AccountType.b bVar : list) {
            if (!TextUtils.equals(valuesDelta.z(bVar.f16953a), contentValues.getAsString(bVar.f16953a))) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(EntityDelta entityDelta, c cVar) {
        boolean z10;
        int F10 = entityDelta.F(cVar.f17004c, true);
        boolean r10 = r(entityDelta, cVar);
        int i10 = cVar.f17016o;
        if (i10 != -1 && F10 >= i10) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (r10 && z10) {
            return true;
        }
        return false;
    }

    public static ArrayList<EntityDelta.ValuesDelta> d(EntityDelta entityDelta, c cVar, ArrayList<EntityDelta.ValuesDelta> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int i10 = cVar.f17016o;
        if (i10 >= 0 && arrayList.size() > i10) {
            ArrayList<EntityDelta.ValuesDelta> arrayList2 = new ArrayList<>(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList2.add(arrayList.get(i11));
            }
            return arrayList2;
        }
        return arrayList;
    }

    public static void e(EntityDelta entityDelta, AccountType accountType, String str) {
        c j10 = accountType.j(str);
        if (entityDelta.F(str, true) <= 0 && j10 != null) {
            EntityDelta.ValuesDelta t10 = t(entityDelta, j10);
            if (j10.f17004c.equals("vnd.android.cursor.item/photo")) {
                t10.r0(true);
            }
        }
    }

    public static void f(Bundle bundle) {
        String string = bundle.getString("im_protocol");
        if (string == null) {
            return;
        }
        try {
            Object decodeImProtocol = Contacts.ContactMethods.decodeImProtocol(string);
            if (decodeImProtocol instanceof Integer) {
                bundle.putInt("im_protocol", ((Integer) decodeImProtocol).intValue());
            } else {
                bundle.putString("im_protocol", (String) decodeImProtocol);
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    public static AccountType.c g(EntityDelta entityDelta, c cVar, boolean z10, int i10) {
        if (cVar.f17015n == null) {
            return null;
        }
        SparseIntArray k10 = k(entityDelta, cVar);
        ArrayList<AccountType.c> n10 = n(entityDelta, cVar, null, z10, k10);
        if (n10.size() == 0) {
            return null;
        }
        if ("vnd.android.cursor.item/phone_v2".equals(cVar.f17004c)) {
            AccountType.c T10 = b.T(2);
            if (n10.contains(T10)) {
                return T10;
            }
        }
        AccountType.c cVar2 = n10.get(n10.size() - 1);
        Iterator<AccountType.c> it = n10.iterator();
        while (it.hasNext()) {
            AccountType.c next = it.next();
            int i11 = k10.get(next.f16960a);
            if (i10 == next.f16960a) {
                return next;
            }
            if (i11 > 0) {
                it.remove();
            }
        }
        if (n10.size() > 0) {
            return n10.get(0);
        }
        return cVar2;
    }

    public static AccountType.c h(EntityDelta.ValuesDelta valuesDelta, c cVar) {
        Long x10 = valuesDelta.x(cVar.f17015n);
        if (x10 == null) {
            return null;
        }
        return j(cVar, x10.intValue());
    }

    public static int i(ArrayList<EntityDelta.ValuesDelta> arrayList, String str, int i10) {
        int size = arrayList.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer v10 = arrayList.get(i12).v(str);
            if (v10 != null && v10.intValue() == i10) {
                i11++;
            }
        }
        return i11;
    }

    public static AccountType.c j(c cVar, int i10) {
        for (AccountType.c cVar2 : cVar.f17017p) {
            if (cVar2.f16960a == i10) {
                return cVar2;
            }
        }
        return null;
    }

    public static SparseIntArray k(EntityDelta entityDelta, c cVar) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(cVar.f17004c);
        if (D10 == null) {
            return sparseIntArray;
        }
        int i10 = 0;
        for (EntityDelta.ValuesDelta valuesDelta : D10) {
            if (valuesDelta.R()) {
                i10++;
                AccountType.c h10 = h(valuesDelta, cVar);
                if (h10 != null) {
                    sparseIntArray.put(h10.f16960a, sparseIntArray.get(h10.f16960a) + 1);
                }
            }
        }
        sparseIntArray.put(Integer.MIN_VALUE, i10);
        return sparseIntArray;
    }

    public static ArrayList<AccountType.c> l(EntityDelta entityDelta, c cVar) {
        return n(entityDelta, cVar, null, true, null);
    }

    public static ArrayList<AccountType.c> m(EntityDelta entityDelta, c cVar, AccountType.c cVar2) {
        return n(entityDelta, cVar, cVar2, true, null);
    }

    public static ArrayList<AccountType.c> n(EntityDelta entityDelta, c cVar, AccountType.c cVar2, boolean z10, SparseIntArray sparseIntArray) {
        boolean z11;
        boolean z12;
        ArrayList<AccountType.c> arrayList = new ArrayList<>();
        if (!q(cVar)) {
            return arrayList;
        }
        if (sparseIntArray == null) {
            sparseIntArray = k(entityDelta, cVar);
        }
        int i10 = sparseIntArray.get(Integer.MIN_VALUE);
        for (AccountType.c cVar3 : cVar.f17017p) {
            int i11 = cVar.f17016o;
            boolean z13 = false;
            if (i11 == -1 || i10 < i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (cVar3.f16963d == -1 || sparseIntArray.get(cVar3.f16960a) < cVar3.f16963d) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z10 || !cVar3.f16962c) {
                z13 = true;
            }
            if (cVar3.equals(cVar2) || (z11 && z12 && z13)) {
                arrayList.add(cVar3);
            }
        }
        return arrayList;
    }

    public static boolean o(EntityDelta entityDelta, AccountType accountType) {
        Iterator<c> it = accountType.l().iterator();
        while (it.hasNext()) {
            c next = it.next();
            ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(next.f17004c);
            if (D10 != null) {
                Iterator<EntityDelta.ValuesDelta> it2 = D10.iterator();
                while (it2.hasNext()) {
                    EntityDelta.ValuesDelta next2 = it2.next();
                    if ((next2.K() && !w(next2, next)) || next2.Q() || next2.H()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean p(EntityDelta entityDelta, AbstractC1362a abstractC1362a) {
        if (entityDelta == null) {
            return false;
        }
        EntityDelta.ValuesDelta N10 = entityDelta.N();
        if (!N10.Q() && !o(entityDelta, abstractC1362a.c(N10.z("account_type"), N10.z("data_set")))) {
            return false;
        }
        return true;
    }

    public static boolean q(c cVar) {
        List<AccountType.c> list = cVar.f17017p;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean r(EntityDelta entityDelta, c cVar) {
        if (!q(cVar) || l(entityDelta, cVar).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean s(EntityDelta entityDelta, AccountType accountType) {
        ArrayList<EntityDelta.ValuesDelta> D10;
        Iterator<c> it = accountType.l().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            c next = it.next();
            String str = next.f17004c;
            if (entityDelta != null && (D10 = entityDelta.D(str)) != null && !TextUtils.equals(str, "vnd.android.cursor.item/group_membership")) {
                Iterator<EntityDelta.ValuesDelta> it2 = D10.iterator();
                while (it2.hasNext()) {
                    EntityDelta.ValuesDelta next2 = it2.next();
                    if (!next2.P() && !w(next2, next)) {
                        boolean z11 = true;
                        if (TextUtils.equals(str, "vnd.android.cursor.item/photo")) {
                            if (next2.t("data15") == null) {
                                z11 = false;
                            }
                        } else {
                            z11 = true ^ next2.H();
                        }
                        z10 = z11;
                        if (z11) {
                            break;
                        }
                    }
                }
                if (z10) {
                    break;
                }
            }
        }
        return z10;
    }

    public static EntityDelta.ValuesDelta t(EntityDelta entityDelta, c cVar) {
        AccountType.c g10 = g(entityDelta, cVar, false, Integer.MIN_VALUE);
        if (g10 == null) {
            g10 = g(entityDelta, cVar, true, Integer.MIN_VALUE);
        }
        return u(entityDelta, cVar, g10);
    }

    public static EntityDelta.ValuesDelta u(EntityDelta entityDelta, c cVar, AccountType.c cVar2) {
        if (cVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", cVar.f17004c);
        contentValues.put("raw_contact_id", entityDelta.N().E());
        ContentValues contentValues2 = cVar.f17019r;
        if (contentValues2 != null) {
            contentValues.putAll(contentValues2);
        }
        String str = cVar.f17015n;
        if (str != null && cVar2 != null) {
            contentValues.put(str, Integer.valueOf(cVar2.f16960a));
        }
        EntityDelta.ValuesDelta m10 = EntityDelta.ValuesDelta.m(contentValues);
        entityDelta.d(m10);
        return m10;
    }

    public static EntityDelta.ValuesDelta v(EntityDelta entityDelta, c cVar) {
        if (cVar != null) {
            EntityDelta.ValuesDelta t10 = t(entityDelta, cVar);
            t10.r0(true);
            return t10;
        }
        return null;
    }

    public static boolean w(EntityDelta.ValuesDelta valuesDelta, c cVar) {
        if ("vnd.android.cursor.item/photo".equals(cVar.f17004c)) {
            if (!valuesDelta.K() || valuesDelta.t("data15") != null) {
                return false;
            }
            return true;
        }
        List<AccountType.b> list = cVar.f17018q;
        if (list == null) {
            return true;
        }
        Iterator<AccountType.b> it = list.iterator();
        while (it.hasNext()) {
            if (U7.f.c(valuesDelta.z(it.next().f16953a))) {
                return false;
            }
        }
        return true;
    }

    public static boolean x(int i10, ArrayList<EntityDelta.ValuesDelta> arrayList, c cVar) {
        int i11;
        int size = cVar.f17017p.size();
        int i12 = 0;
        while (true) {
            if (i12 < size) {
                AccountType.c cVar2 = cVar.f17017p.get(i12);
                if (cVar2.f16960a == i10) {
                    i11 = cVar2.f16963d;
                    break;
                }
                i12++;
            } else {
                i11 = 0;
                break;
            }
        }
        if (i11 == 0) {
            return false;
        }
        if (i11 != -1 && i(arrayList, cVar.f17015n, i10) >= i11) {
            return false;
        }
        return true;
    }

    public static void y(EntityDelta entityDelta, EntityDelta entityDelta2, AccountType accountType) {
        Iterator<c> it;
        ArrayMap arrayMap;
        Iterator<EntityDelta.ValuesDelta> it2;
        Iterator<c> it3;
        ArrayMap arrayMap2;
        Iterator<EntityDelta.ValuesDelta> it4;
        Iterator<EntityDelta.ValuesDelta> it5;
        C1416b c1416b = new C1416b();
        c1416b.add("data1");
        c1416b.add("data2");
        c1416b.add("data3");
        c1416b.add("data4");
        c1416b.add("data5");
        c1416b.add("data6");
        c1416b.add("data7");
        c1416b.add("data8");
        c1416b.add("data9");
        C1416b c1416b2 = new C1416b();
        c1416b2.add("data1");
        c1416b2.add("data4");
        C1416b c1416b3 = new C1416b();
        c1416b3.add("data1");
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("vnd.android.cursor.item/name", c1416b);
        arrayMap3.put("vnd.android.cursor.item/organization", c1416b2);
        arrayMap3.put("vnd.android.cursor.item/nickname", c1416b3);
        LinkedList linkedList = new LinkedList();
        C1416b c1416b4 = new C1416b();
        c1416b4.add("vnd.android.cursor.item/group_membership");
        Iterator<c> it6 = accountType.l().iterator();
        while (it6.hasNext()) {
            ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D(it6.next().f17004c);
            if (D10 != null && !D10.isEmpty()) {
                Iterator<EntityDelta.ValuesDelta> it7 = D10.iterator();
                while (it7.hasNext()) {
                    ContentValues p10 = it7.next().p();
                    if (p10 != null) {
                        String asString = p10.getAsString("mimetype");
                        ArrayList<EntityDelta.ValuesDelta> D11 = entityDelta2.D(asString);
                        if (D11 != null && D11.size() > 0) {
                            Iterator<EntityDelta.ValuesDelta> it8 = D11.iterator();
                            boolean z10 = false;
                            while (it8.hasNext()) {
                                EntityDelta.ValuesDelta next = it8.next();
                                if (arrayMap3.containsKey(asString)) {
                                    C1416b c1416b5 = (C1416b) arrayMap3.get(asString);
                                    if (c1416b5 != null) {
                                        Iterator it9 = c1416b5.iterator();
                                        while (it9.hasNext()) {
                                            String str = (String) it9.next();
                                            String asString2 = p10.getAsString(str);
                                            if (next.z(str) == null && asString2 != null) {
                                                next.e0(str, asString2);
                                            }
                                        }
                                    }
                                    H7.b.b("EntityModifier", "current type merge with , " + asString);
                                    it3 = it6;
                                    arrayMap2 = arrayMap3;
                                    it4 = it7;
                                    it5 = it8;
                                } else {
                                    String z11 = next.z("data1");
                                    String asString3 = p10.getAsString("data1");
                                    boolean equals = TextUtils.equals("vnd.android.cursor.item/phone_v2", asString);
                                    it3 = it6;
                                    String str2 = "";
                                    if (asString3 != null && equals) {
                                        arrayMap2 = arrayMap3;
                                        str2 = PhoneNumberUtils.f(asString3.replaceAll("[()\\-. ]", ""), A.c());
                                    } else {
                                        arrayMap2 = arrayMap3;
                                    }
                                    if (asString3 != null && ((equals && TextUtils.equals(z11, str2)) || TextUtils.equals(z11, asString3))) {
                                        H7.b.b("EntityModifier", "the content in old contact has been contained in new contact,discard the content of old contact for mime type : " + asString);
                                        z10 = true;
                                    }
                                    if (!z10 && equals) {
                                        String[] c10 = A.c();
                                        int length = c10.length;
                                        it4 = it7;
                                        int i10 = 0;
                                        while (i10 < length) {
                                            it5 = it8;
                                            if (TextUtils.equals(z11, c10[i10] + str2)) {
                                                H7.b.b("EntityModifier", "the content in old contact has been contained in new contact,discard the content of old contact for mime type : " + asString);
                                            } else {
                                                i10++;
                                                it8 = it5;
                                            }
                                        }
                                    } else {
                                        it4 = it7;
                                    }
                                    it5 = it8;
                                    it6 = it3;
                                    arrayMap3 = arrayMap2;
                                    it7 = it4;
                                    it8 = it5;
                                }
                                z10 = true;
                                it6 = it3;
                                arrayMap3 = arrayMap2;
                                it7 = it4;
                                it8 = it5;
                            }
                            it = it6;
                            arrayMap = arrayMap3;
                            it2 = it7;
                            if (z10) {
                            }
                        } else {
                            it = it6;
                            arrayMap = arrayMap3;
                            it2 = it7;
                        }
                        if (!c1416b4.contains(asString)) {
                            linkedList.add(EntityDelta.ValuesDelta.m(p10));
                        }
                    } else {
                        it = it6;
                        arrayMap = arrayMap3;
                        it2 = it7;
                    }
                    it6 = it;
                    arrayMap3 = arrayMap;
                    it7 = it2;
                }
            }
            it6 = it6;
            arrayMap3 = arrayMap3;
        }
        Iterator it10 = linkedList.iterator();
        while (it10.hasNext()) {
            EntityDelta.ValuesDelta valuesDelta = (EntityDelta.ValuesDelta) it10.next();
            if (!TextUtils.isEmpty(valuesDelta.z("data1"))) {
                H7.b.b("EntityModifier", "add mime type " + valuesDelta.F() + " to new state");
                entityDelta2.d(valuesDelta);
            }
        }
    }

    public static void z(EntityDelta entityDelta, EntityDelta entityDelta2, c cVar, int i10, String str) {
        ArrayList<EntityDelta.ValuesDelta> d10 = d(entityDelta2, cVar, entityDelta.D(str));
        if (d10 != null && !d10.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (AccountType.c cVar2 : cVar.f17017p) {
                hashMap.put(Integer.valueOf(cVar2.f16960a), (AccountType.d) cVar2);
            }
            Iterator<EntityDelta.ValuesDelta> it = d10.iterator();
            while (it.hasNext()) {
                ContentValues p10 = it.next().p();
                if (p10 != null) {
                    String asString = p10.getAsString("data1");
                    Integer asInteger = p10.getAsInteger("data2");
                    if (asInteger != null && hashMap.containsKey(asInteger) && !TextUtils.isEmpty(asString)) {
                        AccountType.d dVar = (AccountType.d) hashMap.get(asInteger);
                        boolean z10 = false;
                        ParsePosition parsePosition = new ParsePosition(0);
                        Date parse = F7.b.f1006d.parse(asString, parsePosition);
                        if (parse == null) {
                            parse = F7.b.f1004b.parse(asString, parsePosition);
                            z10 = true;
                        }
                        if (parse != null && z10 && !dVar.d()) {
                            Calendar calendar = Calendar.getInstance(F7.b.f1003a, Locale.US);
                            calendar.setTime(parse);
                            calendar.set(i10, calendar.get(2), calendar.get(5), EventFieldEditorView.getDefaultHourForBirthday(), 0, 0);
                            p10.put("data1", F7.b.f1005c.format(calendar.getTime()));
                        }
                        entityDelta2.d(EntityDelta.ValuesDelta.m(p10));
                    }
                }
            }
        }
    }
}
