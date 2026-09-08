package com.coui.appcompat.statement;

/* compiled from: PrivacyItem.kt */
/* loaded from: classes.dex */
public final class PrivacyItem {
    private final String summaryText;
    private final String titleText;

    public PrivacyItem(String titleText, String summaryText) {
        kotlin.jvm.internal.i.f(titleText, "titleText");
        kotlin.jvm.internal.i.f(summaryText, "summaryText");
        this.titleText = titleText;
        this.summaryText = summaryText;
    }

    public static /* synthetic */ PrivacyItem copy$default(PrivacyItem privacyItem, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = privacyItem.titleText;
        }
        if ((i10 & 2) != 0) {
            str2 = privacyItem.summaryText;
        }
        return privacyItem.copy(str, str2);
    }

    public final String component1() {
        return this.titleText;
    }

    public final String component2() {
        return this.summaryText;
    }

    public final PrivacyItem copy(String titleText, String summaryText) {
        kotlin.jvm.internal.i.f(titleText, "titleText");
        kotlin.jvm.internal.i.f(summaryText, "summaryText");
        return new PrivacyItem(titleText, summaryText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrivacyItem)) {
            return false;
        }
        PrivacyItem privacyItem = (PrivacyItem) obj;
        if (kotlin.jvm.internal.i.b(this.titleText, privacyItem.titleText) && kotlin.jvm.internal.i.b(this.summaryText, privacyItem.summaryText)) {
            return true;
        }
        return false;
    }

    public final String getSummaryText() {
        return this.summaryText;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public int hashCode() {
        return (this.titleText.hashCode() * 31) + this.summaryText.hashCode();
    }

    public String toString() {
        return "PrivacyItem(titleText=" + this.titleText + ", summaryText=" + this.summaryText + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PrivacyItem(android.content.Context r2, int r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.i.f(r2, r0)
            java.lang.String r3 = r2.getString(r3)
            java.lang.String r0 = "context.getString(titleId)"
            kotlin.jvm.internal.i.e(r3, r0)
            java.lang.String r2 = r2.getString(r4)
            java.lang.String r4 = "context.getString(summaryId)"
            kotlin.jvm.internal.i.e(r2, r4)
            r1.<init>(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.statement.PrivacyItem.<init>(android.content.Context, int, int):void");
    }
}
