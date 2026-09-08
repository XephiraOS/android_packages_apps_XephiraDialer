package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$PhoneNumberDesc implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasExampleNumber;
    private boolean hasNationalNumberPattern;
    private String nationalNumberPattern_ = "";
    private List<Integer> possibleLength_ = new ArrayList();
    private List<Integer> possibleLengthLocalOnly_ = new ArrayList();
    private String exampleNumber_ = "";

    public String a() {
        return this.nationalNumberPattern_;
    }

    public int b(int i10) {
        return this.possibleLength_.get(i10).intValue();
    }

    public int c() {
        return this.possibleLength_.size();
    }

    public List<Integer> d() {
        return this.possibleLength_;
    }

    public int e() {
        return this.possibleLengthLocalOnly_.size();
    }

    public List<Integer> f() {
        return this.possibleLengthLocalOnly_;
    }

    public Phonemetadata$PhoneNumberDesc g(String str) {
        this.hasExampleNumber = true;
        this.exampleNumber_ = str;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc h(String str) {
        this.hasNationalNumberPattern = true;
        this.nationalNumberPattern_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            h(objectInput.readUTF());
        }
        int readInt = objectInput.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.possibleLength_.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i11 = 0; i11 < readInt2; i11++) {
            this.possibleLengthLocalOnly_.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            g(objectInput.readUTF());
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.hasNationalNumberPattern);
        if (this.hasNationalNumberPattern) {
            objectOutput.writeUTF(this.nationalNumberPattern_);
        }
        int c10 = c();
        objectOutput.writeInt(c10);
        for (int i10 = 0; i10 < c10; i10++) {
            objectOutput.writeInt(this.possibleLength_.get(i10).intValue());
        }
        int e10 = e();
        objectOutput.writeInt(e10);
        for (int i11 = 0; i11 < e10; i11++) {
            objectOutput.writeInt(this.possibleLengthLocalOnly_.get(i11).intValue());
        }
        objectOutput.writeBoolean(this.hasExampleNumber);
        if (this.hasExampleNumber) {
            objectOutput.writeUTF(this.exampleNumber_);
        }
    }
}
