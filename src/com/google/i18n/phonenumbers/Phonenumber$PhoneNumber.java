package com.google.i18n.phonenumbers;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Phonenumber$PhoneNumber implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean hasCountryCode;
    private boolean hasCountryCodeSource;
    private boolean hasExtension;
    private boolean hasItalianLeadingZero;
    private boolean hasNationalNumber;
    private boolean hasNumberOfLeadingZeros;
    private boolean hasPreferredDomesticCarrierCode;
    private boolean hasRawInput;
    private int countryCode_ = 0;
    private long nationalNumber_ = 0;
    private String extension_ = "";
    private boolean italianLeadingZero_ = false;
    private int numberOfLeadingZeros_ = 1;
    private String rawInput_ = "";
    private String preferredDomesticCarrierCode_ = "";
    private CountryCodeSource countryCodeSource_ = CountryCodeSource.UNSPECIFIED;

    /* loaded from: classes3.dex */
    public enum CountryCodeSource {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public Phonenumber$PhoneNumber A(long j10) {
        this.hasNationalNumber = true;
        this.nationalNumber_ = j10;
        return this;
    }

    public Phonenumber$PhoneNumber B(int i10) {
        this.hasNumberOfLeadingZeros = true;
        this.numberOfLeadingZeros_ = i10;
        return this;
    }

    public Phonenumber$PhoneNumber C(String str) {
        str.getClass();
        this.hasPreferredDomesticCarrierCode = true;
        this.preferredDomesticCarrierCode_ = str;
        return this;
    }

    public Phonenumber$PhoneNumber D(String str) {
        str.getClass();
        this.hasRawInput = true;
        this.rawInput_ = str;
        return this;
    }

    public Phonenumber$PhoneNumber a() {
        this.hasCountryCodeSource = false;
        this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
        return this;
    }

    public Phonenumber$PhoneNumber b() {
        this.hasExtension = false;
        this.extension_ = "";
        return this;
    }

    public Phonenumber$PhoneNumber c() {
        this.hasPreferredDomesticCarrierCode = false;
        this.preferredDomesticCarrierCode_ = "";
        return this;
    }

    public Phonenumber$PhoneNumber d() {
        this.hasRawInput = false;
        this.rawInput_ = "";
        return this;
    }

    public boolean e(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (phonenumber$PhoneNumber == null) {
            return false;
        }
        if (this == phonenumber$PhoneNumber) {
            return true;
        }
        if (this.countryCode_ != phonenumber$PhoneNumber.countryCode_ || this.nationalNumber_ != phonenumber$PhoneNumber.nationalNumber_ || !this.extension_.equals(phonenumber$PhoneNumber.extension_) || this.italianLeadingZero_ != phonenumber$PhoneNumber.italianLeadingZero_ || this.numberOfLeadingZeros_ != phonenumber$PhoneNumber.numberOfLeadingZeros_ || !this.rawInput_.equals(phonenumber$PhoneNumber.rawInput_) || this.countryCodeSource_ != phonenumber$PhoneNumber.countryCodeSource_ || !this.preferredDomesticCarrierCode_.equals(phonenumber$PhoneNumber.preferredDomesticCarrierCode_) || s() != phonenumber$PhoneNumber.s()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Phonenumber$PhoneNumber) && e((Phonenumber$PhoneNumber) obj)) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.countryCode_;
    }

    public CountryCodeSource g() {
        return this.countryCodeSource_;
    }

    public String h() {
        return this.extension_;
    }

    public int hashCode() {
        int i10;
        int f10 = (((((2173 + f()) * 53) + Long.valueOf(i()).hashCode()) * 53) + h().hashCode()) * 53;
        int i11 = 1237;
        if (u()) {
            i10 = 1231;
        } else {
            i10 = 1237;
        }
        int j10 = (((((((((f10 + i10) * 53) + j()) * 53) + l().hashCode()) * 53) + g().hashCode()) * 53) + k().hashCode()) * 53;
        if (s()) {
            i11 = 1231;
        }
        return j10 + i11;
    }

    public long i() {
        return this.nationalNumber_;
    }

    public int j() {
        return this.numberOfLeadingZeros_;
    }

    public String k() {
        return this.preferredDomesticCarrierCode_;
    }

    public String l() {
        return this.rawInput_;
    }

    public boolean m() {
        return this.hasCountryCode;
    }

    public boolean n() {
        return this.hasCountryCodeSource;
    }

    public boolean o() {
        return this.hasExtension;
    }

    public boolean p() {
        return this.hasItalianLeadingZero;
    }

    public boolean q() {
        return this.hasNationalNumber;
    }

    public boolean r() {
        return this.hasNumberOfLeadingZeros;
    }

    public boolean s() {
        return this.hasPreferredDomesticCarrierCode;
    }

    public boolean t() {
        return this.hasRawInput;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country Code: ");
        sb.append(this.countryCode_);
        sb.append(" National Number: ");
        sb.append(this.nationalNumber_);
        if (p() && u()) {
            sb.append(" Leading Zero(s): true");
        }
        if (r()) {
            sb.append(" Number of leading zeros: ");
            sb.append(this.numberOfLeadingZeros_);
        }
        if (o()) {
            sb.append(" Extension: ");
            sb.append(this.extension_);
        }
        if (n()) {
            sb.append(" Country Code Source: ");
            sb.append(this.countryCodeSource_);
        }
        if (s()) {
            sb.append(" Preferred Domestic Carrier Code: ");
            sb.append(this.preferredDomesticCarrierCode_);
        }
        return sb.toString();
    }

    public boolean u() {
        return this.italianLeadingZero_;
    }

    public Phonenumber$PhoneNumber v(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (phonenumber$PhoneNumber.m()) {
            w(phonenumber$PhoneNumber.f());
        }
        if (phonenumber$PhoneNumber.q()) {
            A(phonenumber$PhoneNumber.i());
        }
        if (phonenumber$PhoneNumber.o()) {
            y(phonenumber$PhoneNumber.h());
        }
        if (phonenumber$PhoneNumber.p()) {
            z(phonenumber$PhoneNumber.u());
        }
        if (phonenumber$PhoneNumber.r()) {
            B(phonenumber$PhoneNumber.j());
        }
        if (phonenumber$PhoneNumber.t()) {
            D(phonenumber$PhoneNumber.l());
        }
        if (phonenumber$PhoneNumber.n()) {
            x(phonenumber$PhoneNumber.g());
        }
        if (phonenumber$PhoneNumber.s()) {
            C(phonenumber$PhoneNumber.k());
        }
        return this;
    }

    public Phonenumber$PhoneNumber w(int i10) {
        this.hasCountryCode = true;
        this.countryCode_ = i10;
        return this;
    }

    public Phonenumber$PhoneNumber x(CountryCodeSource countryCodeSource) {
        countryCodeSource.getClass();
        this.hasCountryCodeSource = true;
        this.countryCodeSource_ = countryCodeSource;
        return this;
    }

    public Phonenumber$PhoneNumber y(String str) {
        str.getClass();
        this.hasExtension = true;
        this.extension_ = str;
        return this;
    }

    public Phonenumber$PhoneNumber z(boolean z10) {
        this.hasItalianLeadingZero = true;
        this.italianLeadingZero_ = z10;
        return this;
    }
}
