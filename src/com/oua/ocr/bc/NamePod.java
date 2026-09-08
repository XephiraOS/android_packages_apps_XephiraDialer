package com.oua.ocr.bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class NamePod {
    public String FirstName;
    public String LastName;
    public String MiddleName = "";
    String condition;
    float dist;
    int idx;
    int lang;
    String name;

    public NamePod(int i10, String str, float f10, String str2, int i11) {
        this.FirstName = "";
        this.LastName = "";
        this.idx = i10;
        this.name = str;
        this.dist = f10;
        this.condition = str2;
        this.lang = i11;
        if (i11 == 5) {
            this.LastName = str.substring(0, 1);
            this.FirstName = this.name.substring(1);
            return;
        }
        String[] split = str.split(" ");
        for (int i12 = 0; i12 < split.length; i12++) {
            if (i12 == 0) {
                this.FirstName = split[i12];
            } else if (i12 == split.length - 1) {
                this.LastName = split[i12];
            } else if (split[i12].length() > 0) {
                this.MiddleName += split[i12];
                if (i12 != split.length - 2) {
                    this.MiddleName += " ";
                }
            }
        }
    }

    public String toString() {
        return "idx = " + this.idx + "\nname = " + this.name + "\ndist = " + this.dist + "\ncondition = " + this.condition + "\nFirstName = " + this.FirstName + "\nMiddleName = " + this.MiddleName + "\nLastName = " + this.LastName;
    }
}
