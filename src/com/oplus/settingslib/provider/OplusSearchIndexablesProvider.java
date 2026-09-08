package com.oplus.settingslib.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes3.dex */
public abstract class OplusSearchIndexablesProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public String f28977a;

    /* renamed from: b, reason: collision with root package name */
    public UriMatcher f28978b;

    public abstract Cursor a(String[] strArr);

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.f28977a = providerInfo.authority;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f28978b = uriMatcher;
        uriMatcher.addURI(this.f28977a, "settings/indexables_xml_res", 1);
        this.f28978b.addURI(this.f28977a, "settings/indexables_raw", 2);
        this.f28978b.addURI(this.f28977a, "settings/non_indexables_key", 3);
        this.f28978b.addURI(this.f28977a, "settings/site_map_pairs", 4);
        if (providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                if ("android.permission.READ_SEARCH_INDEXABLES".equals(providerInfo.readPermission)) {
                    super.attachInfo(context, providerInfo);
                    return;
                }
                throw new SecurityException("Provider must be protected by READ_SEARCH_INDEXABLES");
            }
            throw new SecurityException("Provider must grantUriPermissions");
        }
        throw new SecurityException("Provider must be exported");
    }

    public abstract Cursor b(String[] strArr);

    public Cursor c() {
        return null;
    }

    public abstract Cursor d(String[] strArr);

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete not supported");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int match = this.f28978b.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match == 3) {
                    return "vnd.android.cursor.dir/non_indexables_key";
                }
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            return "vnd.android.cursor.dir/indexables_raw";
        }
        return "vnd.android.cursor.dir/indexables_xml_res";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert not supported");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.f28978b.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match == 4) {
                        return c();
                    }
                    throw new UnsupportedOperationException("Unknown Uri " + uri);
                }
                return a(null);
            }
            return b(null);
        }
        return d(null);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Update not supported");
    }
}
