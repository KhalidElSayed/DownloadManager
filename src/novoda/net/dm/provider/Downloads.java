
package novoda.net.dm.provider;

import android.provider.BaseColumns;

public interface Downloads {
    public interface Columns extends BaseColumns {
        String _DATA = "_data";

        String MIME_TYPE = "mimeType";

        String STATUS = "status";

        String LAST_MODIFIED = "lastModified";

        String TOTAL_BYTES = "totalBytes";

        String CURRENT_BYTES = "currentBytes";

        String IS_NO_MEDIA = "noMedia";
    }
}
