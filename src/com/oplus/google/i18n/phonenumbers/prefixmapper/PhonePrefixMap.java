package com.oplus.google.i18n.phonenumbers.prefixmapper;

import X7.a;
import X7.b;
import X7.c;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedSet;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class PhonePrefixMap implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f28378a = Logger.getLogger(PhonePrefixMap.class.getName());
    private c phonePrefixMapStorage;
    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.C();

    public final int a(int i10, int i11, long j10) {
        int i12 = 0;
        while (i10 <= i11) {
            i12 = (i10 + i11) >>> 1;
            long d10 = this.phonePrefixMapStorage.d(i12);
            if (d10 == j10) {
                return i12;
            }
            if (d10 > j10) {
                i12--;
                i11 = i12;
            } else {
                i10 = i12 + 1;
            }
        }
        return i12;
    }

    public String b(long j10) {
        int b10 = this.phonePrefixMapStorage.b();
        if (b10 == 0) {
            return null;
        }
        int i10 = b10 - 1;
        SortedSet c10 = this.phonePrefixMapStorage.c();
        while (c10.size() > 0) {
            Integer num = (Integer) c10.last();
            String valueOf = String.valueOf(j10);
            if (valueOf.length() > num.intValue()) {
                j10 = Long.parseLong(valueOf.substring(0, num.intValue()));
            }
            i10 = a(0, i10, j10);
            if (i10 < 0) {
                return null;
            }
            if (j10 == this.phonePrefixMapStorage.d(i10)) {
                return this.phonePrefixMapStorage.a(i10);
            }
            c10 = c10.headSet(num);
        }
        return null;
    }

    public String c(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        return b(Long.parseLong(phonenumber$PhoneNumber.f() + this.phoneUtil.G(phonenumber$PhoneNumber)));
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            this.phonePrefixMapStorage = new b();
        } else {
            this.phonePrefixMapStorage = new a();
        }
        this.phonePrefixMapStorage.e(objectInput);
    }

    public String toString() {
        return this.phonePrefixMapStorage.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.phonePrefixMapStorage instanceof b);
        this.phonePrefixMapStorage.f(objectOutput);
    }
}
