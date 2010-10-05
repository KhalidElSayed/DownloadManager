
package novoda.net.dm.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class DownloadProvider extends ContentProvider {

    private static final String DB_NAME = "downloads.db";

    private static final int DB_VERSION = 1;

    private static final String DB_TABLE = "downloads";

    private static final String DOWNLOAD_LIST_TYPE = "vnd.android.cursor.dir/novoda.net.dm.download";

    private static final String DOWNLOAD_TYPE = "vnd.android.cursor.item/novoda.net.dm.download";

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int DOWNLOADS = 1;

    private static final int DOWNLOADS_ID = 2;

    static {
        sURIMatcher.addURI("downloads", "download", DOWNLOADS);
        sURIMatcher.addURI("downloads", "download/#", DOWNLOADS_ID);
    }

    private static final String[] sAppReadableColumnsArray = new String[] {
            Downloads.Columns._ID, Downloads.Columns._DATA, Downloads.Columns.MIME_TYPE,
            Downloads.Columns.STATUS, Downloads.Columns.LAST_MODIFIED,
            Downloads.Columns.TOTAL_BYTES, Downloads.Columns.CURRENT_BYTES
    };

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        switch (sURIMatcher.match(uri)) {
            case DOWNLOADS:
                return DOWNLOAD_LIST_TYPE;
            case DOWNLOADS_ID:
                return DOWNLOAD_TYPE;
        }
        throw new IllegalStateException("Unknown uri: " + uri);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
