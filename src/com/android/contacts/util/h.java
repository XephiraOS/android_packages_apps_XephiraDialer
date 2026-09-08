package com.android.contacts.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.ContactsContract;

/* compiled from: ContactLoaderUtils.java */
/* loaded from: classes.dex */
public final class h {
    public static Uri a(ContentResolver contentResolver, Uri uri) {
        if (uri != null) {
            String authority = uri.getAuthority();
            if ("com.android.contacts".equals(authority)) {
                String type = contentResolver.getType(uri);
                if ("vnd.android.cursor.item/contact".equals(type)) {
                    return uri;
                }
                if ("vnd.android.cursor.item/raw_contact".equals(type)) {
                    return ContactsContract.RawContacts.getContactLookupUri(contentResolver, ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ContentUris.parseId(uri)));
                }
                throw new IllegalArgumentException("uri format is unknown");
            }
            if ("contacts".equals(authority)) {
                return ContactsContract.RawContacts.getContactLookupUri(contentResolver, ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ContentUris.parseId(uri)));
            }
            throw new IllegalArgumentException("uri authority is unknown");
        }
        throw new IllegalArgumentException("uri must not be null");
    }
}
