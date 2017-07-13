package lol.ye0yeg.thecamapp.stickercamera;

import android.app.Application;
import android.util.DisplayMetrics;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * Created by Administrator on 7/13/2017.
 */

public class App extends Application {
    protected static App mInstance;
    DisplayMetrics mDisplayMetrics = null;


    public static App getApp() {
        if (mInstance != null && mInstance instanceof App) {
            return mInstance;
        } else {
            mInstance = new App();
            mInstance.onCreate();
            return mInstance;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
        mInstance = this;
    }

    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .imageScaleType(ImageScaleType.EXACTLY)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .defaultDisplayImageOptions(defaultOptions)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCache(new UnlimitedDiskCache(StorageUtils
                        .getOwnCacheDirectory(this, AppConstants.APP_IMAGE)))
                .diskCacheSize(100 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(3)
                .build();
        ImageLoader.getInstance().init(config);
    }

    public float getScreenDensity() {
        if (this.mDisplayMetrics == null) {

        }
        return this.mDisplayMetrics.density;
    }

    public int getScreenHeight() {
        if (this.mDisplayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.mDisplayMetrics.heightPixels;
    }

    public int getScreenWidth() {
        if (this.mDisplayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.mDisplayMetrics.widthPixels;
    }

    public void setDisplayMetrics(DisplayMetrics DisplayMetrics) {
        this.mDisplayMetrics = DisplayMetrics;
    }

    public int dp2px(float f) {
        return (int) (0.5f + f * getScreenDensity());
    }

    public String getFileDirPath() {
        return getFilesDir().getAbsolutePath();
    }


    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }

}
