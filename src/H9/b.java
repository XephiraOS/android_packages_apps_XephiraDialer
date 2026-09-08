package H9;

import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import m9.q;

/* compiled from: ByteString.kt */
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1294a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int b(byte[] bArr, int i10) {
        int i11;
        byte b10;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int length = bArr.length;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        loop0: while (i17 < length) {
            byte b11 = bArr[i17];
            if (b11 >= 0) {
                int i20 = i19 + 1;
                if (i19 == i10) {
                    return i18;
                }
                if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && b11 < 32) || (Byte.MAX_VALUE <= b11 && b11 < 160))) || b11 == 65533) {
                    return -1;
                }
                if (b11 < 65536) {
                    i11 = 1;
                } else {
                    i11 = 2;
                }
                i18 += i11;
                i17++;
                while (true) {
                    i19 = i20;
                    if (i17 < length && (b10 = bArr[i17]) >= 0) {
                        i17++;
                        i20 = i19 + 1;
                        if (i19 == i10) {
                            return i18;
                        }
                        if ((b10 == 10 || b10 == 13 || ((b10 < 0 || b10 >= 32) && (Byte.MAX_VALUE > b10 || b10 >= 160))) && b10 != 65533) {
                            if (b10 < 65536) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            i18 += i12;
                        }
                    }
                }
            } else {
                if ((b11 >> 5) == -2) {
                    int i21 = i17 + 1;
                    if (length <= i21) {
                        if (i19 != i10) {
                            return -1;
                        }
                        return i18;
                    }
                    byte b12 = bArr[i21];
                    if ((b12 & 192) == 128) {
                        int i22 = (b12 ^ BtDirectAdvertiseSetting.FLAG_PAIRING_STATE) ^ (b11 << 6);
                        if (i22 < 128) {
                            if (i19 != i10) {
                                return -1;
                            }
                            return i18;
                        }
                        i13 = i19 + 1;
                        if (i19 == i10) {
                            return i18;
                        }
                        if ((i22 != 10 && i22 != 13 && ((i22 >= 0 && i22 < 32) || (127 <= i22 && i22 < 160))) || i22 == 65533) {
                            return -1;
                        }
                        if (i22 < 65536) {
                            i16 = 1;
                        } else {
                            i16 = 2;
                        }
                        i18 += i16;
                        q qVar = q.f35511a;
                        i17 += 2;
                    } else {
                        if (i19 != i10) {
                            return -1;
                        }
                        return i18;
                    }
                } else if ((b11 >> 4) == -2) {
                    int i23 = i17 + 2;
                    if (length <= i23) {
                        if (i19 != i10) {
                            return -1;
                        }
                        return i18;
                    }
                    byte b13 = bArr[i17 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i23];
                        if ((b14 & 192) == 128) {
                            int i24 = ((b13 << 6) ^ ((-123008) ^ b14)) ^ (b11 << 12);
                            if (i24 < 2048) {
                                if (i19 != i10) {
                                    return -1;
                                }
                                return i18;
                            }
                            if (55296 <= i24 && i24 < 57344) {
                                if (i19 != i10) {
                                    return -1;
                                }
                                return i18;
                            }
                            i13 = i19 + 1;
                            if (i19 == i10) {
                                return i18;
                            }
                            if ((i24 != 10 && i24 != 13 && ((i24 >= 0 && i24 < 32) || (127 <= i24 && i24 < 160))) || i24 == 65533) {
                                return -1;
                            }
                            if (i24 < 65536) {
                                i15 = 1;
                            } else {
                                i15 = 2;
                            }
                            i18 += i15;
                            q qVar2 = q.f35511a;
                            i17 += 3;
                        } else {
                            if (i19 != i10) {
                                return -1;
                            }
                            return i18;
                        }
                    } else {
                        if (i19 != i10) {
                            return -1;
                        }
                        return i18;
                    }
                } else if ((b11 >> 3) == -2) {
                    int i25 = i17 + 3;
                    if (length <= i25) {
                        if (i19 != i10) {
                            return -1;
                        }
                        return i18;
                    }
                    byte b15 = bArr[i17 + 1];
                    if ((b15 & 192) == 128) {
                        byte b16 = bArr[i17 + 2];
                        if ((b16 & 192) == 128) {
                            byte b17 = bArr[i25];
                            if ((b17 & 192) == 128) {
                                int i26 = (((b17 ^ BtDirectAdvertiseSetting.FLAG_PAIRING_STATE) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
                                if (i26 > 1114111) {
                                    if (i19 != i10) {
                                        return -1;
                                    }
                                    return i18;
                                }
                                if (55296 <= i26 && i26 < 57344) {
                                    if (i19 != i10) {
                                        return -1;
                                    }
                                    return i18;
                                }
                                if (i26 < 65536) {
                                    if (i19 != i10) {
                                        return -1;
                                    }
                                    return i18;
                                }
                                i13 = i19 + 1;
                                if (i19 == i10) {
                                    return i18;
                                }
                                if ((i26 != 10 && i26 != 13 && ((i26 >= 0 && i26 < 32) || (127 <= i26 && i26 < 160))) || i26 == 65533) {
                                    return -1;
                                }
                                if (i26 < 65536) {
                                    i14 = 1;
                                } else {
                                    i14 = 2;
                                }
                                i18 += i14;
                                q qVar3 = q.f35511a;
                                i17 += 4;
                            } else {
                                if (i19 != i10) {
                                    return -1;
                                }
                                return i18;
                            }
                        } else {
                            if (i19 != i10) {
                                return -1;
                            }
                            return i18;
                        }
                    } else {
                        if (i19 != i10) {
                            return -1;
                        }
                        return i18;
                    }
                } else {
                    if (i19 != i10) {
                        return -1;
                    }
                    return i18;
                }
                i19 = i13;
            }
        }
        return i18;
    }

    public static final char[] c() {
        return f1294a;
    }
}
