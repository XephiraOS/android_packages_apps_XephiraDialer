package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$NumberFormat implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasDomesticCarrierCodeFormattingRule;
    private boolean hasFormat;
    private boolean hasNationalPrefixFormattingRule;
    private boolean hasNationalPrefixOptionalWhenFormatting;
    private boolean hasPattern;
    private String pattern_ = "";
    private String format_ = "";
    private List<String> leadingDigitsPattern_ = new ArrayList();
    private String nationalPrefixFormattingRule_ = "";
    private boolean nationalPrefixOptionalWhenFormatting_ = false;
    private String domesticCarrierCodeFormattingRule_ = "";

    public String a() {
        return this.domesticCarrierCodeFormattingRule_;
    }

    public String b() {
        return this.format_;
    }

    public String c(int i10) {
        return this.leadingDigitsPattern_.get(i10);
    }

    public int d() {
        return this.leadingDigitsPattern_.size();
    }

    public String e() {
        return this.nationalPrefixFormattingRule_;
    }

    public boolean f() {
        return this.nationalPrefixOptionalWhenFormatting_;
    }

    public String g() {
        return this.pattern_;
    }

    @Deprecated
    public int h() {
        return d();
    }

    public Phonemetadata$NumberFormat i(String str) {
        this.hasDomesticCarrierCodeFormattingRule = true;
        this.domesticCarrierCodeFormattingRule_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat j(String str) {
        this.hasFormat = true;
        this.format_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat k(String str) {
        this.hasNationalPrefixFormattingRule = true;
        this.nationalPrefixFormattingRule_ = str;
        return this;
    }

    public Phonemetadata$NumberFormat l(boolean z10) {
        this.hasNationalPrefixOptionalWhenFormatting = true;
        this.nationalPrefixOptionalWhenFormatting_ = z10;
        return this;
    }

    public Phonemetadata$NumberFormat m(String str) {
        this.hasPattern = true;
        this.pattern_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        m(objectInput.readUTF());
        j(objectInput.readUTF());
        int readInt = objectInput.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.leadingDigitsPattern_.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            k(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            i(objectInput.readUTF());
        }
        l(objectInput.readBoolean());
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.pattern_);
        objectOutput.writeUTF(this.format_);
        int h10 = h();
        objectOutput.writeInt(h10);
        for (int i10 = 0; i10 < h10; i10++) {
            objectOutput.writeUTF(this.leadingDigitsPattern_.get(i10));
        }
        objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
        if (this.hasNationalPrefixFormattingRule) {
            objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
        }
        objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
        if (this.hasDomesticCarrierCodeFormattingRule) {
            objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
        }
        objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
    }
}
