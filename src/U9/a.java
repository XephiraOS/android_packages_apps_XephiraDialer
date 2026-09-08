package U9;

import org.xml.sax.Attributes;

/* compiled from: AttributesImpl.java */
/* loaded from: classes4.dex */
public class a implements Attributes {

    /* renamed from: a, reason: collision with root package name */
    public int f3877a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f3878b;

    public a() {
        this.f3877a = 0;
        this.f3878b = null;
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        d(this.f3877a + 1);
        String[] strArr = this.f3878b;
        int i10 = this.f3877a;
        strArr[i10 * 5] = str;
        strArr[(i10 * 5) + 1] = str2;
        strArr[(i10 * 5) + 2] = str3;
        strArr[(i10 * 5) + 3] = str4;
        strArr[(i10 * 5) + 4] = str5;
        this.f3877a = i10 + 1;
    }

    public final void b(int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempt to modify attribute at illegal index: ");
        stringBuffer.append(i10);
        throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
    }

    public void c() {
        if (this.f3878b != null) {
            for (int i10 = 0; i10 < this.f3877a * 5; i10++) {
                this.f3878b[i10] = null;
            }
        }
        this.f3877a = 0;
    }

    public final void d(int i10) {
        int i11;
        if (i10 <= 0) {
            return;
        }
        String[] strArr = this.f3878b;
        if (strArr != null && strArr.length != 0) {
            if (strArr.length >= i10 * 5) {
                return;
            } else {
                i11 = strArr.length;
            }
        } else {
            i11 = 25;
        }
        while (i11 < i10 * 5) {
            i11 *= 2;
        }
        String[] strArr2 = new String[i11];
        int i12 = this.f3877a;
        if (i12 > 0) {
            System.arraycopy(this.f3878b, 0, strArr2, 0, i12 * 5);
        }
        this.f3878b = strArr2;
    }

    public void e(int i10) {
        int i11;
        if (i10 >= 0 && i10 < (i11 = this.f3877a)) {
            if (i10 < i11 - 1) {
                String[] strArr = this.f3878b;
                System.arraycopy(strArr, (i10 + 1) * 5, strArr, i10 * 5, ((i11 - i10) - 1) * 5);
            }
            int i12 = this.f3877a;
            int i13 = (i12 - 1) * 5;
            String[] strArr2 = this.f3878b;
            strArr2[i13] = null;
            strArr2[i13 + 1] = null;
            strArr2[i13 + 2] = null;
            strArr2[i13 + 3] = null;
            strArr2[i13 + 4] = null;
            this.f3877a = i12 - 1;
            return;
        }
        b(i10);
    }

    public void f(int i10, String str, String str2, String str3, String str4, String str5) {
        if (i10 >= 0 && i10 < this.f3877a) {
            String[] strArr = this.f3878b;
            int i11 = i10 * 5;
            strArr[i11] = str;
            strArr[i11 + 1] = str2;
            strArr[i11 + 2] = str3;
            strArr[i11 + 3] = str4;
            strArr[i11 + 4] = str5;
            return;
        }
        b(i10);
    }

    public void g(Attributes attributes) {
        c();
        int length = attributes.getLength();
        this.f3877a = length;
        if (length > 0) {
            this.f3878b = new String[length * 5];
            for (int i10 = 0; i10 < this.f3877a; i10++) {
                int i11 = i10 * 5;
                this.f3878b[i11] = attributes.getURI(i10);
                this.f3878b[i11 + 1] = attributes.getLocalName(i10);
                this.f3878b[i11 + 2] = attributes.getQName(i10);
                this.f3878b[i11 + 3] = attributes.getType(i10);
                this.f3878b[i11 + 4] = attributes.getValue(i10);
            }
        }
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        int i10 = this.f3877a * 5;
        for (int i11 = 0; i11 < i10; i11 += 5) {
            if (this.f3878b[i11].equals(str) && this.f3878b[i11 + 1].equals(str2)) {
                return i11 / 5;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        return this.f3877a;
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i10) {
        if (i10 >= 0 && i10 < this.f3877a) {
            return this.f3878b[(i10 * 5) + 1];
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i10) {
        if (i10 >= 0 && i10 < this.f3877a) {
            return this.f3878b[(i10 * 5) + 2];
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i10) {
        if (i10 < 0 || i10 >= this.f3877a) {
            return null;
        }
        return this.f3878b[(i10 * 5) + 3];
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i10) {
        if (i10 >= 0 && i10 < this.f3877a) {
            return this.f3878b[i10 * 5];
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i10) {
        if (i10 < 0 || i10 >= this.f3877a) {
            return null;
        }
        return this.f3878b[(i10 * 5) + 4];
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        int i10 = this.f3877a * 5;
        for (int i11 = 0; i11 < i10; i11 += 5) {
            if (this.f3878b[i11].equals(str) && this.f3878b[i11 + 1].equals(str2)) {
                return this.f3878b[i11 + 3];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        int i10 = this.f3877a * 5;
        for (int i11 = 0; i11 < i10; i11 += 5) {
            if (this.f3878b[i11].equals(str) && this.f3878b[i11 + 1].equals(str2)) {
                return this.f3878b[i11 + 4];
            }
        }
        return null;
    }

    public a(Attributes attributes) {
        g(attributes);
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        int i10 = this.f3877a * 5;
        for (int i11 = 0; i11 < i10; i11 += 5) {
            if (this.f3878b[i11 + 2].equals(str)) {
                return i11 / 5;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        int i10 = this.f3877a * 5;
        for (int i11 = 0; i11 < i10; i11 += 5) {
            if (this.f3878b[i11 + 2].equals(str)) {
                return this.f3878b[i11 + 3];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        int i10 = this.f3877a * 5;
        for (int i11 = 0; i11 < i10; i11 += 5) {
            if (this.f3878b[i11 + 2].equals(str)) {
                return this.f3878b[i11 + 4];
            }
        }
        return null;
    }
}
