package com.oua.ocr.bc;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class BBox {

    /* renamed from: c, reason: collision with root package name */
    int[][] f29375c;
    float[][] centers;
    float[] dims;
    ArrayList<String[]> fields;
    int idx;
    int lang;
    float prop;
    String text;

    public BBox() {
        this.f29375c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 2);
        this.idx = 0;
        this.dims = new float[2];
        this.centers = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, 2);
        this.fields = new ArrayList<>();
        this.lang = 11;
        this.text = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean addBack(com.oua.ocr.bc.BBox r17, float r18) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oua.ocr.bc.BBox.addBack(com.oua.ocr.bc.BBox, float):java.lang.Boolean");
    }

    public float get_distance(int[] iArr, int[] iArr2) {
        return (float) Math.sqrt(Math.pow(iArr[0] - iArr2[0], 2.0d) + Math.pow(iArr[1] - iArr2[1], 2.0d));
    }

    public void get_parameters() {
        float[] fArr = this.dims;
        int[][] iArr = this.f29375c;
        float f10 = get_distance(iArr[0], iArr[1]);
        int[][] iArr2 = this.f29375c;
        fArr[0] = (int) ((f10 + get_distance(iArr2[2], iArr2[3])) / 2.0d);
        float[] fArr2 = this.dims;
        int[][] iArr3 = this.f29375c;
        float f11 = get_distance(iArr3[0], iArr3[3]);
        int[][] iArr4 = this.f29375c;
        fArr2[1] = (int) ((f11 + get_distance(iArr4[2], iArr4[1])) / 2.0d);
        float[][] fArr3 = this.centers;
        float[] fArr4 = fArr3[0];
        int[][] iArr5 = this.f29375c;
        int i10 = iArr5[0][0];
        int[] iArr6 = iArr5[3];
        fArr4[0] = (float) ((i10 + iArr6[0]) / 2.0d);
        fArr4[1] = (float) ((r3[1] + iArr6[1]) / 2.0d);
        float[] fArr5 = fArr3[2];
        int i11 = iArr5[1][0];
        int[] iArr7 = iArr5[2];
        fArr5[0] = (float) ((i11 + iArr7[0]) / 2.0d);
        fArr5[1] = (float) ((r6[1] + iArr7[1]) / 2.0d);
        float[] fArr6 = fArr3[1];
        fArr6[0] = (float) ((fArr4[0] + r5) / 2.0d);
        fArr6[1] = (float) ((fArr4[1] + r12) / 2.0d);
    }

    public void set_values(int[][] iArr, String str, int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            for (int i12 = 0; i12 < 2; i12++) {
                this.f29375c[i11][i12] = iArr[i11][i12];
            }
        }
        this.text = str;
        this.idx = i10;
        get_parameters();
    }

    public BBox(BBox bBox) {
        this.f29375c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 2);
        this.idx = 0;
        this.dims = new float[2];
        this.centers = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, 2);
        this.fields = new ArrayList<>();
        this.lang = 11;
        set_values(bBox.f29375c, bBox.text, bBox.idx);
        get_parameters();
    }

    public Boolean addBack(BBox bBox, int i10, float f10) {
        if (!addBack(bBox, f10).booleanValue()) {
            return Boolean.FALSE;
        }
        this.idx = i10;
        return Boolean.TRUE;
    }
}
