package com.android.contacts.voicemail.impl.mail;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FetchProfile extends ArrayList<c> {

    /* loaded from: classes.dex */
    public enum Item implements c {
        FLAGS,
        ENVELOPE,
        STRUCTURE,
        BODY_SANE,
        BODY
    }

    public h a() {
        Iterator<c> it = iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next instanceof h) {
                return (h) next;
            }
        }
        return null;
    }
}
