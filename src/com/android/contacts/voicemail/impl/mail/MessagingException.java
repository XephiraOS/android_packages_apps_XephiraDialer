package com.android.contacts.voicemail.impl.mail;

/* loaded from: classes.dex */
public class MessagingException extends Exception {
    public static final long serialVersionUID = -1;
    protected Object mExceptionData;
    protected int mExceptionType;

    public MessagingException(String str, Throwable th) {
        this(0, str, th);
    }

    public MessagingException(int i10, String str, Throwable th) {
        super(str, th);
        this.mExceptionType = i10;
        this.mExceptionData = null;
    }

    public MessagingException(String str) {
        this(0, str, null);
    }

    public MessagingException(int i10, String str) {
        this(i10, str, null);
    }
}
