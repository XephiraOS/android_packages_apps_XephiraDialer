package com.customize.contacts.importcontact;

import android.content.Context;
import com.oplus.dialer.R;

/* compiled from: ImportErrorManager.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public Context f21440a;

    /* renamed from: b, reason: collision with root package name */
    public int f21441b = -1;

    public i(Context context) {
        this.f21440a = context;
    }

    public String a(int i10) {
        String d10 = d(R.string.error_unknown_occured);
        switch (i10) {
            case 0:
                return d(R.string.error_file_not_supported);
            case 1:
                return d(R.string.error_file_not_exist);
            case 2:
                return d(R.string.error_file_cannot_read);
            case 3:
                return d(R.string.error_file_content_empty);
            case 4:
                return d(R.string.error_file_parse_error);
            case 5:
                return d(R.string.oplus_fail_reason_vcard_not_supported_error);
            case 6:
                return d(R.string.oplus_import_msg_write_database_failed);
            case 7:
                return d(R.string.error_simcard_not_exist);
            case 8:
                return d(R.string.simcard_fullfilled);
            case 9:
                return d(R.string.error_simcard_cannot_write);
            case 10:
                return d(R.string.error_database_error);
            case 11:
                return d(R.string.database_fullfilled);
            case 12:
                return d(R.string.oplus_sim_not_ready_message);
            default:
                return d10;
        }
    }

    public String b(int i10) {
        return d(R.string.oplus_msg_failed_no_contact_imported);
    }

    public String c(int i10, int i11) {
        if (i11 <= 0) {
            return b(i10);
        }
        return String.format(this.f21440a.getResources().getQuantityText(R.plurals.oplus_msg_import_failed, i11).toString(), Integer.valueOf(i11));
    }

    public final String d(int i10) {
        return this.f21440a.getString(i10);
    }
}
