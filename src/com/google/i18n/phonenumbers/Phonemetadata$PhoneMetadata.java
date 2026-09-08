package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Phonemetadata$PhoneMetadata implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasCarrierSpecific;
    private boolean hasCountryCode;
    private boolean hasEmergency;
    private boolean hasFixedLine;
    private boolean hasGeneralDesc;
    private boolean hasId;
    private boolean hasInternationalPrefix;
    private boolean hasLeadingDigits;
    private boolean hasMainCountryForCode;
    private boolean hasMobile;
    private boolean hasMobileNumberPortableRegion;
    private boolean hasNationalPrefix;
    private boolean hasNationalPrefixForParsing;
    private boolean hasNationalPrefixTransformRule;
    private boolean hasNoInternationalDialling;
    private boolean hasPager;
    private boolean hasPersonalNumber;
    private boolean hasPreferredExtnPrefix;
    private boolean hasPreferredInternationalPrefix;
    private boolean hasPremiumRate;
    private boolean hasSameMobileAndFixedLinePattern;
    private boolean hasSharedCost;
    private boolean hasShortCode;
    private boolean hasSmsServices;
    private boolean hasStandardRate;
    private boolean hasTollFree;
    private boolean hasUan;
    private boolean hasVoicemail;
    private boolean hasVoip;
    private Phonemetadata$PhoneNumberDesc generalDesc_ = null;
    private Phonemetadata$PhoneNumberDesc fixedLine_ = null;
    private Phonemetadata$PhoneNumberDesc mobile_ = null;
    private Phonemetadata$PhoneNumberDesc tollFree_ = null;
    private Phonemetadata$PhoneNumberDesc premiumRate_ = null;
    private Phonemetadata$PhoneNumberDesc sharedCost_ = null;
    private Phonemetadata$PhoneNumberDesc personalNumber_ = null;
    private Phonemetadata$PhoneNumberDesc voip_ = null;
    private Phonemetadata$PhoneNumberDesc pager_ = null;
    private Phonemetadata$PhoneNumberDesc uan_ = null;
    private Phonemetadata$PhoneNumberDesc emergency_ = null;
    private Phonemetadata$PhoneNumberDesc voicemail_ = null;
    private Phonemetadata$PhoneNumberDesc shortCode_ = null;
    private Phonemetadata$PhoneNumberDesc standardRate_ = null;
    private Phonemetadata$PhoneNumberDesc carrierSpecific_ = null;
    private Phonemetadata$PhoneNumberDesc smsServices_ = null;
    private Phonemetadata$PhoneNumberDesc noInternationalDialling_ = null;
    private String id_ = "";
    private int countryCode_ = 0;
    private String internationalPrefix_ = "";
    private String preferredInternationalPrefix_ = "";
    private String nationalPrefix_ = "";
    private String preferredExtnPrefix_ = "";
    private String nationalPrefixForParsing_ = "";
    private String nationalPrefixTransformRule_ = "";
    private boolean sameMobileAndFixedLinePattern_ = false;
    private List<Phonemetadata$NumberFormat> numberFormat_ = new ArrayList();
    private List<Phonemetadata$NumberFormat> intlNumberFormat_ = new ArrayList();
    private boolean mainCountryForCode_ = false;
    private String leadingDigits_ = "";
    private boolean mobileNumberPortableRegion_ = false;

    public boolean A() {
        return this.hasPreferredExtnPrefix;
    }

    @Deprecated
    public int B() {
        return f();
    }

    @Deprecated
    public int C() {
        return n();
    }

    public Phonemetadata$PhoneMetadata D(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasCarrierSpecific = true;
        this.carrierSpecific_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata E(int i10) {
        this.hasCountryCode = true;
        this.countryCode_ = i10;
        return this;
    }

    public Phonemetadata$PhoneMetadata F(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasEmergency = true;
        this.emergency_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata G(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasFixedLine = true;
        this.fixedLine_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata H(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasGeneralDesc = true;
        this.generalDesc_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata I(String str) {
        this.hasId = true;
        this.id_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata J(String str) {
        this.hasInternationalPrefix = true;
        this.internationalPrefix_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata K(String str) {
        this.hasLeadingDigits = true;
        this.leadingDigits_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata L(boolean z10) {
        this.hasMainCountryForCode = true;
        this.mainCountryForCode_ = z10;
        return this;
    }

    public Phonemetadata$PhoneMetadata M(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasMobile = true;
        this.mobile_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata N(boolean z10) {
        this.hasMobileNumberPortableRegion = true;
        this.mobileNumberPortableRegion_ = z10;
        return this;
    }

    public Phonemetadata$PhoneMetadata O(String str) {
        this.hasNationalPrefix = true;
        this.nationalPrefix_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata P(String str) {
        this.hasNationalPrefixForParsing = true;
        this.nationalPrefixForParsing_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata Q(String str) {
        this.hasNationalPrefixTransformRule = true;
        this.nationalPrefixTransformRule_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata R(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasNoInternationalDialling = true;
        this.noInternationalDialling_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata S(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasPager = true;
        this.pager_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata T(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasPersonalNumber = true;
        this.personalNumber_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata U(String str) {
        this.hasPreferredExtnPrefix = true;
        this.preferredExtnPrefix_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata V(String str) {
        this.hasPreferredInternationalPrefix = true;
        this.preferredInternationalPrefix_ = str;
        return this;
    }

    public Phonemetadata$PhoneMetadata W(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasPremiumRate = true;
        this.premiumRate_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata X(boolean z10) {
        this.hasSameMobileAndFixedLinePattern = true;
        this.sameMobileAndFixedLinePattern_ = z10;
        return this;
    }

    public Phonemetadata$PhoneMetadata Y(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasSharedCost = true;
        this.sharedCost_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneMetadata Z(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasShortCode = true;
        this.shortCode_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public int a() {
        return this.countryCode_;
    }

    public Phonemetadata$PhoneMetadata a0(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasSmsServices = true;
        this.smsServices_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc b() {
        return this.fixedLine_;
    }

    public Phonemetadata$PhoneMetadata b0(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasStandardRate = true;
        this.standardRate_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public Phonemetadata$PhoneNumberDesc c() {
        return this.generalDesc_;
    }

    public Phonemetadata$PhoneMetadata c0(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasTollFree = true;
        this.tollFree_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public String d() {
        return this.id_;
    }

    public Phonemetadata$PhoneMetadata d0(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasUan = true;
        this.uan_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public String e() {
        return this.internationalPrefix_;
    }

    public Phonemetadata$PhoneMetadata e0(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasVoicemail = true;
        this.voicemail_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public int f() {
        return this.intlNumberFormat_.size();
    }

    public Phonemetadata$PhoneMetadata f0(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        phonemetadata$PhoneNumberDesc.getClass();
        this.hasVoip = true;
        this.voip_ = phonemetadata$PhoneNumberDesc;
        return this;
    }

    public List<Phonemetadata$NumberFormat> g() {
        return this.intlNumberFormat_;
    }

    public String h() {
        return this.leadingDigits_;
    }

    public Phonemetadata$PhoneNumberDesc i() {
        return this.mobile_;
    }

    public String j() {
        return this.nationalPrefix_;
    }

    public String k() {
        return this.nationalPrefixForParsing_;
    }

    public String l() {
        return this.nationalPrefixTransformRule_;
    }

    public Phonemetadata$PhoneNumberDesc m() {
        return this.noInternationalDialling_;
    }

    public int n() {
        return this.numberFormat_.size();
    }

    public List<Phonemetadata$NumberFormat> o() {
        return this.numberFormat_;
    }

    public Phonemetadata$PhoneNumberDesc p() {
        return this.pager_;
    }

    public Phonemetadata$PhoneNumberDesc q() {
        return this.personalNumber_;
    }

    public String r() {
        return this.preferredExtnPrefix_;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            H(phonemetadata$PhoneNumberDesc);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc2 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc2.readExternal(objectInput);
            G(phonemetadata$PhoneNumberDesc2);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc3 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc3.readExternal(objectInput);
            M(phonemetadata$PhoneNumberDesc3);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc4 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc4.readExternal(objectInput);
            c0(phonemetadata$PhoneNumberDesc4);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc5 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc5.readExternal(objectInput);
            W(phonemetadata$PhoneNumberDesc5);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc6 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc6.readExternal(objectInput);
            Y(phonemetadata$PhoneNumberDesc6);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc7 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc7.readExternal(objectInput);
            T(phonemetadata$PhoneNumberDesc7);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc8 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc8.readExternal(objectInput);
            f0(phonemetadata$PhoneNumberDesc8);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc9 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc9.readExternal(objectInput);
            S(phonemetadata$PhoneNumberDesc9);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc10 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc10.readExternal(objectInput);
            d0(phonemetadata$PhoneNumberDesc10);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc11 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc11.readExternal(objectInput);
            F(phonemetadata$PhoneNumberDesc11);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc12 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc12.readExternal(objectInput);
            e0(phonemetadata$PhoneNumberDesc12);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc13 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc13.readExternal(objectInput);
            Z(phonemetadata$PhoneNumberDesc13);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc14 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc14.readExternal(objectInput);
            b0(phonemetadata$PhoneNumberDesc14);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc15 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc15.readExternal(objectInput);
            D(phonemetadata$PhoneNumberDesc15);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc16 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc16.readExternal(objectInput);
            a0(phonemetadata$PhoneNumberDesc16);
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc17 = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc17.readExternal(objectInput);
            R(phonemetadata$PhoneNumberDesc17);
        }
        I(objectInput.readUTF());
        E(objectInput.readInt());
        J(objectInput.readUTF());
        if (objectInput.readBoolean()) {
            V(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            O(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            U(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            P(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            Q(objectInput.readUTF());
        }
        X(objectInput.readBoolean());
        int readInt = objectInput.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            Phonemetadata$NumberFormat phonemetadata$NumberFormat = new Phonemetadata$NumberFormat();
            phonemetadata$NumberFormat.readExternal(objectInput);
            this.numberFormat_.add(phonemetadata$NumberFormat);
        }
        int readInt2 = objectInput.readInt();
        for (int i11 = 0; i11 < readInt2; i11++) {
            Phonemetadata$NumberFormat phonemetadata$NumberFormat2 = new Phonemetadata$NumberFormat();
            phonemetadata$NumberFormat2.readExternal(objectInput);
            this.intlNumberFormat_.add(phonemetadata$NumberFormat2);
        }
        L(objectInput.readBoolean());
        if (objectInput.readBoolean()) {
            K(objectInput.readUTF());
        }
        N(objectInput.readBoolean());
    }

    public Phonemetadata$PhoneNumberDesc s() {
        return this.premiumRate_;
    }

    public boolean t() {
        return this.sameMobileAndFixedLinePattern_;
    }

    public Phonemetadata$PhoneNumberDesc u() {
        return this.sharedCost_;
    }

    public Phonemetadata$PhoneNumberDesc v() {
        return this.tollFree_;
    }

    public Phonemetadata$PhoneNumberDesc w() {
        return this.uan_;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.hasGeneralDesc);
        if (this.hasGeneralDesc) {
            this.generalDesc_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasFixedLine);
        if (this.hasFixedLine) {
            this.fixedLine_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasMobile);
        if (this.hasMobile) {
            this.mobile_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasTollFree);
        if (this.hasTollFree) {
            this.tollFree_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPremiumRate);
        if (this.hasPremiumRate) {
            this.premiumRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSharedCost);
        if (this.hasSharedCost) {
            this.sharedCost_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPersonalNumber);
        if (this.hasPersonalNumber) {
            this.personalNumber_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoip);
        if (this.hasVoip) {
            this.voip_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPager);
        if (this.hasPager) {
            this.pager_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasUan);
        if (this.hasUan) {
            this.uan_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasEmergency);
        if (this.hasEmergency) {
            this.emergency_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoicemail);
        if (this.hasVoicemail) {
            this.voicemail_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasShortCode);
        if (this.hasShortCode) {
            this.shortCode_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasStandardRate);
        if (this.hasStandardRate) {
            this.standardRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasCarrierSpecific);
        if (this.hasCarrierSpecific) {
            this.carrierSpecific_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSmsServices);
        if (this.hasSmsServices) {
            this.smsServices_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasNoInternationalDialling);
        if (this.hasNoInternationalDialling) {
            this.noInternationalDialling_.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.id_);
        objectOutput.writeInt(this.countryCode_);
        objectOutput.writeUTF(this.internationalPrefix_);
        objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
        if (this.hasPreferredInternationalPrefix) {
            objectOutput.writeUTF(this.preferredInternationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefix);
        if (this.hasNationalPrefix) {
            objectOutput.writeUTF(this.nationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
        if (this.hasPreferredExtnPrefix) {
            objectOutput.writeUTF(this.preferredExtnPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
        if (this.hasNationalPrefixForParsing) {
            objectOutput.writeUTF(this.nationalPrefixForParsing_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
        if (this.hasNationalPrefixTransformRule) {
            objectOutput.writeUTF(this.nationalPrefixTransformRule_);
        }
        objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
        int C10 = C();
        objectOutput.writeInt(C10);
        for (int i10 = 0; i10 < C10; i10++) {
            this.numberFormat_.get(i10).writeExternal(objectOutput);
        }
        int B10 = B();
        objectOutput.writeInt(B10);
        for (int i11 = 0; i11 < B10; i11++) {
            this.intlNumberFormat_.get(i11).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.mainCountryForCode_);
        objectOutput.writeBoolean(this.hasLeadingDigits);
        if (this.hasLeadingDigits) {
            objectOutput.writeUTF(this.leadingDigits_);
        }
        objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
    }

    public Phonemetadata$PhoneNumberDesc x() {
        return this.voicemail_;
    }

    public Phonemetadata$PhoneNumberDesc y() {
        return this.voip_;
    }

    public boolean z() {
        return this.hasLeadingDigits;
    }
}
