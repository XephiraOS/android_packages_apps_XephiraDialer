package org.apache.james.mime4j;

import java.io.IOException;

/* loaded from: classes4.dex */
public class MimeIOException extends IOException {
    private static final long serialVersionUID = 5393613459533735409L;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MimeIOException(org.apache.james.mime4j.MimeException r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L4
            r0 = 0
            goto L8
        L4:
            java.lang.String r0 = r2.getMessage()
        L8:
            r1.<init>(r0)
            r1.initCause(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.MimeIOException.<init>(org.apache.james.mime4j.MimeException):void");
    }

    @Override // java.lang.Throwable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MimeException getCause() {
        return (MimeException) super.getCause();
    }
}
