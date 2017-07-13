package lol.ye0yeg.thecamapp.stickercamera;

import android.os.Environment;

/**
 * Created by Administrator on 7/13/2017.
 */
public class AppConstants{

        public static final String APP_DIR = Environment.getExternalStorageDirectory() + "/StickerCamera";
        public static final String APP_TEMP = APP_DIR + "/temp";
        public static final String APP_IMAGE = APP_DIR + "/image";

        public static final String FEED_INFO = "FEED_INFO";
}
