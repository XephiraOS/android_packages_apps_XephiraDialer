package com.oplus.anim.parser.moshi;

import G9.b;
import G9.d;
import com.oplus.anim.parser.moshi.JsonReader;
import java.io.EOFException;
import okio.ByteString;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes3.dex */
public final class a extends JsonReader {

    /* renamed from: n, reason: collision with root package name */
    public static final ByteString f26147n = ByteString.b("'\\");

    /* renamed from: o, reason: collision with root package name */
    public static final ByteString f26148o = ByteString.b("\"\\");

    /* renamed from: p, reason: collision with root package name */
    public static final ByteString f26149p = ByteString.b("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q, reason: collision with root package name */
    public static final ByteString f26150q = ByteString.b("\n\r");

    /* renamed from: r, reason: collision with root package name */
    public static final ByteString f26151r = ByteString.b("*/");

    /* renamed from: h, reason: collision with root package name */
    public final d f26152h;

    /* renamed from: i, reason: collision with root package name */
    public final b f26153i;

    /* renamed from: j, reason: collision with root package name */
    public int f26154j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f26155k;

    /* renamed from: l, reason: collision with root package name */
    public int f26156l;

    /* renamed from: m, reason: collision with root package name */
    public String f26157m;

    public a(d dVar) {
        if (dVar != null) {
            this.f26152h = dVar;
            this.f26153i = dVar.k();
            I(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public JsonReader.Token G() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        switch (i10) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public int L(JsonReader.a aVar) {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return Z(this.f26157m, aVar);
        }
        int E10 = this.f26152h.E(aVar.f26146b);
        if (E10 != -1) {
            this.f26154j = 0;
            this.f26130c[this.f26128a - 1] = aVar.f26145a[E10];
            return E10;
        }
        String str = this.f26130c[this.f26128a - 1];
        String u10 = u();
        int Z9 = Z(u10, aVar);
        if (Z9 == -1) {
            this.f26154j = 15;
            this.f26157m = u10;
            this.f26130c[this.f26128a - 1] = str;
        }
        return Z9;
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public void O() {
        if (!this.f26133f) {
            int i10 = this.f26154j;
            if (i10 == 0) {
                i10 = X();
            }
            if (i10 == 14) {
                q0();
            } else if (i10 == 13) {
                l0(f26148o);
            } else if (i10 == 12) {
                l0(f26147n);
            } else if (i10 != 15) {
                throw new JsonDataException("Expected a name but was " + G() + " at path " + d());
            }
            this.f26154j = 0;
            this.f26130c[this.f26128a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + G() + " at " + d());
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public void S() {
        if (!this.f26133f) {
            int i10 = 0;
            do {
                int i11 = this.f26154j;
                if (i11 == 0) {
                    i11 = X();
                }
                if (i11 == 3) {
                    I(1);
                } else if (i11 == 1) {
                    I(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f26128a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + G() + " at path " + d());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f26128a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + G() + " at path " + d());
                        }
                    } else if (i11 != 14 && i11 != 10) {
                        if (i11 != 9 && i11 != 13) {
                            if (i11 != 8 && i11 != 12) {
                                if (i11 == 17) {
                                    this.f26153i.V(this.f26156l);
                                } else if (i11 == 18) {
                                    throw new JsonDataException("Expected a value but was " + G() + " at path " + d());
                                }
                            } else {
                                l0(f26147n);
                            }
                        } else {
                            l0(f26148o);
                        }
                    } else {
                        q0();
                    }
                    this.f26154j = 0;
                }
                i10++;
                this.f26154j = 0;
            } while (i10 != 0);
            int[] iArr = this.f26131d;
            int i12 = this.f26128a;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f26130c[i12 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + G() + " at " + d());
    }

    public final void V() {
        if (this.f26132e) {
        } else {
            throw U("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int X() {
        int[] iArr = this.f26129b;
        int i10 = this.f26128a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int c02 = c0(true);
            this.f26153i.readByte();
            if (c02 != 44) {
                if (c02 != 59) {
                    if (c02 == 93) {
                        this.f26154j = 4;
                        return 4;
                    }
                    throw U("Unterminated array");
                }
                V();
            }
        } else if (i11 != 3 && i11 != 5) {
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int c03 = c0(true);
                this.f26153i.readByte();
                if (c03 != 58) {
                    if (c03 == 61) {
                        V();
                        if (this.f26152h.W(1L) && this.f26153i.l(0L) == 62) {
                            this.f26153i.readByte();
                        }
                    } else {
                        throw U("Expected ':'");
                    }
                }
            } else if (i11 == 6) {
                iArr[i10 - 1] = 7;
            } else if (i11 == 7) {
                if (c0(false) == -1) {
                    this.f26154j = 18;
                    return 18;
                }
                V();
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i10 - 1] = 4;
            if (i11 == 5) {
                int c04 = c0(true);
                this.f26153i.readByte();
                if (c04 != 44) {
                    if (c04 != 59) {
                        if (c04 == 125) {
                            this.f26154j = 2;
                            return 2;
                        }
                        throw U("Unterminated object");
                    }
                    V();
                }
            }
            int c05 = c0(true);
            if (c05 != 34) {
                if (c05 != 39) {
                    if (c05 != 125) {
                        V();
                        if (a0((char) c05)) {
                            this.f26154j = 14;
                            return 14;
                        }
                        throw U("Expected name");
                    }
                    if (i11 != 5) {
                        this.f26153i.readByte();
                        this.f26154j = 2;
                        return 2;
                    }
                    throw U("Expected name");
                }
                this.f26153i.readByte();
                V();
                this.f26154j = 12;
                return 12;
            }
            this.f26153i.readByte();
            this.f26154j = 13;
            return 13;
        }
        int c06 = c0(true);
        if (c06 != 34) {
            if (c06 != 39) {
                if (c06 != 44 && c06 != 59) {
                    if (c06 != 91) {
                        if (c06 != 93) {
                            if (c06 != 123) {
                                int h02 = h0();
                                if (h02 != 0) {
                                    return h02;
                                }
                                int i02 = i0();
                                if (i02 != 0) {
                                    return i02;
                                }
                                if (a0(this.f26153i.l(0L))) {
                                    V();
                                    this.f26154j = 10;
                                    return 10;
                                }
                                throw U("Expected value");
                            }
                            this.f26153i.readByte();
                            this.f26154j = 1;
                            return 1;
                        }
                        if (i11 == 1) {
                            this.f26153i.readByte();
                            this.f26154j = 4;
                            return 4;
                        }
                    } else {
                        this.f26153i.readByte();
                        this.f26154j = 3;
                        return 3;
                    }
                }
                if (i11 != 1 && i11 != 2) {
                    throw U("Unexpected value");
                }
                V();
                this.f26154j = 7;
                return 7;
            }
            V();
            this.f26153i.readByte();
            this.f26154j = 8;
            return 8;
        }
        this.f26153i.readByte();
        this.f26154j = 9;
        return 9;
    }

    public final int Z(String str, JsonReader.a aVar) {
        int length = aVar.f26145a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f26145a[i10])) {
                this.f26154j = 0;
                this.f26130c[this.f26128a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    public final boolean a0(int i10) {
        if (i10 != 9 && i10 != 10 && i10 != 12 && i10 != 13 && i10 != 32) {
            if (i10 != 35) {
                if (i10 != 44) {
                    if (i10 != 47 && i10 != 61) {
                        if (i10 != 123 && i10 != 125 && i10 != 58) {
                            if (i10 != 59) {
                                switch (i10) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            V();
            return false;
        }
        return false;
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public void c() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 3) {
            I(1);
            this.f26131d[this.f26128a - 1] = 0;
            this.f26154j = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + G() + " at path " + d());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f26153i.V(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        V();
        o0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.f26152h.W(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        V();
        r3 = r6.f26153i.l(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.f26153i.readByte();
        r6.f26153i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (m0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw U("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.f26153i.readByte();
        r6.f26153i.readByte();
        o0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c0(boolean r7) {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            G9.d r2 = r6.f26152h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.W(r4)
            if (r2 == 0) goto L80
            G9.b r2 = r6.f26153i
            long r4 = (long) r1
            byte r2 = r2.l(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            G9.b r3 = r6.f26153i
            long r4 = (long) r1
            r3.V(r4)
            r1 = 47
            if (r2 != r1) goto L72
            G9.d r3 = r6.f26152h
            r4 = 2
            boolean r3 = r3.W(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.V()
            G9.b r3 = r6.f26153i
            r4 = 1
            byte r3 = r3.l(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            G9.b r1 = r6.f26153i
            r1.readByte()
            G9.b r1 = r6.f26153i
            r1.readByte()
            r6.o0()
            goto L1
        L5a:
            G9.b r1 = r6.f26153i
            r1.readByte()
            G9.b r1 = r6.f26153i
            r1.readByte()
            boolean r1 = r6.m0()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            com.oplus.anim.parser.moshi.JsonEncodingException r6 = r6.U(r7)
            throw r6
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.V()
            r6.o0()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r6 = -1
            return r6
        L84:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "End of input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.parser.moshi.a.c0(boolean):int");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f26154j = 0;
        this.f26129b[0] = 8;
        this.f26128a = 1;
        this.f26153i.a();
        this.f26152h.close();
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public void e() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 1) {
            I(3);
            this.f26154j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + G() + " at path " + d());
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public void f() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 4) {
            int i11 = this.f26128a;
            this.f26128a = i11 - 1;
            int[] iArr = this.f26131d;
            int i12 = i11 - 2;
            iArr[i12] = iArr[i12] + 1;
            this.f26154j = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + G() + " at path " + d());
    }

    public final String f0(ByteString byteString) {
        StringBuilder sb = null;
        while (true) {
            long A10 = this.f26152h.A(byteString);
            if (A10 != -1) {
                if (this.f26153i.l(A10) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.f26153i.S(A10));
                    this.f26153i.readByte();
                    sb.append(j0());
                } else {
                    if (sb == null) {
                        String S10 = this.f26153i.S(A10);
                        this.f26153i.readByte();
                        return S10;
                    }
                    sb.append(this.f26153i.S(A10));
                    this.f26153i.readByte();
                    return sb.toString();
                }
            } else {
                throw U("Unterminated string");
            }
        }
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public void g() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 2) {
            int i11 = this.f26128a;
            int i12 = i11 - 1;
            this.f26128a = i12;
            this.f26130c[i12] = null;
            int[] iArr = this.f26131d;
            int i13 = i11 - 2;
            iArr[i13] = iArr[i13] + 1;
            this.f26154j = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + G() + " at path " + d());
    }

    public final String g0() {
        long A10 = this.f26152h.A(f26149p);
        b bVar = this.f26153i;
        if (A10 != -1) {
            return bVar.S(A10);
        }
        return bVar.O();
    }

    public final int h0() {
        String str;
        String str2;
        int i10;
        byte l10 = this.f26153i.l(0L);
        if (l10 != 116 && l10 != 84) {
            if (l10 != 102 && l10 != 70) {
                if (l10 != 110 && l10 != 78) {
                    return 0;
                }
                str = "null";
                str2 = "NULL";
                i10 = 7;
            } else {
                str = "false";
                str2 = "FALSE";
                i10 = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        }
        int length = str.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f26152h.W(i12)) {
                return 0;
            }
            byte l11 = this.f26153i.l(i11);
            if (l11 != str.charAt(i11) && l11 != str2.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f26152h.W(length + 1) && a0(this.f26153i.l(length))) {
            return 0;
        }
        this.f26153i.V(length);
        this.f26154j = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (a0(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.f26155k = r8;
        r16.f26153i.V(r5);
        r16.f26154j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.f26156l = r5;
        r16.f26154j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i0() {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.parser.moshi.a.i0():int");
    }

    public final char j0() {
        int i10;
        if (this.f26152h.W(1L)) {
            byte readByte = this.f26153i.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.f26132e) {
                                        return (char) readByte;
                                    }
                                    throw U("Invalid escape sequence: \\" + ((char) readByte));
                                }
                                if (this.f26152h.W(4L)) {
                                    char c10 = 0;
                                    for (int i11 = 0; i11 < 4; i11++) {
                                        byte l10 = this.f26153i.l(i11);
                                        char c11 = (char) (c10 << 4);
                                        if (l10 >= 48 && l10 <= 57) {
                                            i10 = l10 - 48;
                                        } else if (l10 >= 97 && l10 <= 102) {
                                            i10 = l10 - 87;
                                        } else {
                                            if (l10 < 65 || l10 > 70) {
                                                throw U("\\u" + this.f26153i.S(4L));
                                            }
                                            i10 = l10 - 55;
                                        }
                                        c10 = (char) (c11 + i10);
                                    }
                                    this.f26153i.V(4L);
                                    return c10;
                                }
                                throw new EOFException("Unterminated escape sequence at path " + d());
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw U("Unterminated escape sequence");
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public boolean l() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 != 2 && i10 != 4 && i10 != 18) {
            return true;
        }
        return false;
    }

    public final void l0(ByteString byteString) {
        while (true) {
            long A10 = this.f26152h.A(byteString);
            if (A10 != -1) {
                if (this.f26153i.l(A10) == 92) {
                    this.f26153i.V(A10 + 1);
                    j0();
                } else {
                    this.f26153i.V(A10 + 1);
                    return;
                }
            } else {
                throw U("Unterminated string");
            }
        }
    }

    public final boolean m0() {
        boolean z10;
        long U10;
        long v10 = this.f26152h.v(f26151r);
        if (v10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        b bVar = this.f26153i;
        if (z10) {
            U10 = v10 + r1.o();
        } else {
            U10 = bVar.U();
        }
        bVar.V(U10);
        return z10;
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public boolean o() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 5) {
            this.f26154j = 0;
            int[] iArr = this.f26131d;
            int i11 = this.f26128a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (i10 == 6) {
            this.f26154j = 0;
            int[] iArr2 = this.f26131d;
            int i12 = this.f26128a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + G() + " at path " + d());
    }

    public final void o0() {
        long U10;
        long A10 = this.f26152h.A(f26150q);
        b bVar = this.f26153i;
        if (A10 != -1) {
            U10 = A10 + 1;
        } else {
            U10 = bVar.U();
        }
        bVar.V(U10);
    }

    public final void q0() {
        long A10 = this.f26152h.A(f26149p);
        b bVar = this.f26153i;
        if (A10 == -1) {
            A10 = bVar.U();
        }
        bVar.V(A10);
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public double r() {
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 16) {
            this.f26154j = 0;
            int[] iArr = this.f26131d;
            int i11 = this.f26128a - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f26155k;
        }
        if (i10 == 17) {
            this.f26157m = this.f26153i.S(this.f26156l);
        } else if (i10 == 9) {
            this.f26157m = f0(f26148o);
        } else if (i10 == 8) {
            this.f26157m = f0(f26147n);
        } else if (i10 == 10) {
            this.f26157m = g0();
        } else if (i10 != 11) {
            throw new JsonDataException("Expected a double but was " + G() + " at path " + d());
        }
        this.f26154j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f26157m);
            if (!this.f26132e && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + d());
            }
            this.f26157m = null;
            this.f26154j = 0;
            int[] iArr2 = this.f26131d;
            int i12 = this.f26128a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f26157m + " at path " + d());
        }
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public int s() {
        String f02;
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 16) {
            long j10 = this.f26155k;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f26154j = 0;
                int[] iArr = this.f26131d;
                int i12 = this.f26128a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new JsonDataException("Expected an int but was " + this.f26155k + " at path " + d());
        }
        if (i10 == 17) {
            this.f26157m = this.f26153i.S(this.f26156l);
        } else if (i10 != 9 && i10 != 8) {
            if (i10 != 11) {
                throw new JsonDataException("Expected an int but was " + G() + " at path " + d());
            }
        } else {
            if (i10 == 9) {
                f02 = f0(f26148o);
            } else {
                f02 = f0(f26147n);
            }
            this.f26157m = f02;
            try {
                int parseInt = Integer.parseInt(f02);
                this.f26154j = 0;
                int[] iArr2 = this.f26131d;
                int i13 = this.f26128a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f26154j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f26157m);
            int i14 = (int) parseDouble;
            if (i14 == parseDouble) {
                this.f26157m = null;
                this.f26154j = 0;
                int[] iArr3 = this.f26131d;
                int i15 = this.f26128a - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new JsonDataException("Expected an int but was " + this.f26157m + " at path " + d());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f26157m + " at path " + d());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f26152h + ")";
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public String u() {
        String str;
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 14) {
            str = g0();
        } else if (i10 == 13) {
            str = f0(f26148o);
        } else if (i10 == 12) {
            str = f0(f26147n);
        } else if (i10 == 15) {
            str = this.f26157m;
        } else {
            throw new JsonDataException("Expected a name but was " + G() + " at path " + d());
        }
        this.f26154j = 0;
        this.f26130c[this.f26128a - 1] = str;
        return str;
    }

    @Override // com.oplus.anim.parser.moshi.JsonReader
    public String y() {
        String S10;
        int i10 = this.f26154j;
        if (i10 == 0) {
            i10 = X();
        }
        if (i10 == 10) {
            S10 = g0();
        } else if (i10 == 9) {
            S10 = f0(f26148o);
        } else if (i10 == 8) {
            S10 = f0(f26147n);
        } else if (i10 == 11) {
            S10 = this.f26157m;
            this.f26157m = null;
        } else if (i10 == 16) {
            S10 = Long.toString(this.f26155k);
        } else if (i10 == 17) {
            S10 = this.f26153i.S(this.f26156l);
        } else {
            throw new JsonDataException("Expected a string but was " + G() + " at path " + d());
        }
        this.f26154j = 0;
        int[] iArr = this.f26131d;
        int i11 = this.f26128a - 1;
        iArr[i11] = iArr[i11] + 1;
        return S10;
    }
}
