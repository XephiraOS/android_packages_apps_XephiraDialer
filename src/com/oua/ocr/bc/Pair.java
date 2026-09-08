package com.oua.ocr.bc;

/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
class Pair {
    float dist;
    int idx;
    String str;

    public Pair(int i10, String str) {
        this.idx = i10;
        this.str = str;
    }

    public Pair(int i10, String str, float f10) {
        this.idx = i10;
        this.str = str;
        this.dist = f10;
    }
}
