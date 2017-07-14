package lol.ye0yeg.thecamapp.app.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Stack;

import lol.ye0yeg.thecamapp.app.model.PhotoItem;
import lol.ye0yeg.thecamapp.common.util.ImageUtils;
import lol.ye0yeg.thecamapp.stickercamera.AppConstants;

/**
 * 相机管理类
 * Created by Administrator on 7/14/2017.
 */
public class CameraManager {

    private static CameraManager mInstance;

    private Stack<Activity> cameras = new Stack<Activity>();

    public static CameraManager getInst() {
        if (mInstance == null) {
            synchronized (CameraManager.class) {
                if (mInstance == null)
                    mInstance = new CameraManager();
            }
        }
        return mInstance;
    }

    //Open Camera
    public void openCamera(Context context) {
        //Camera Open!!
//        Intent intent = new Intent(context);
//        context.startActivity(intent);
    }

    //Judge if cut those pic !  !  !PhotoItem
    public void processPhotoItem(Activity activity) {
    }

    public void addActivity(Activity act) {
        cameras.add(act);
    }

    public void removeActivity(Activity act) {
        cameras.remove(act);
    }

    //判断图片是否需要裁剪
    public void processPhotoItem(Activity activity, PhotoItem photo) {
        Uri uri = photo.getImageUri().startsWith("file:") ? Uri.parse(photo
                .getImageUri()) : Uri.parse("file://" + photo.getImageUri());
        if (ImageUtils.isSquare(photo.getImageUri())) {
            Intent newIntent = new Intent(activity, PhotoProcessActivity.class);
            newIntent.setData(uri);
            activity.startActivity(newIntent);
        } else {
            Intent i = new Intent(activity, CropPhotoActivity.class);
            i.setData(uri);
            //TODO稍后添加
            activity.startActivityForResult(i, AppConstants.REQUEST_CROP);
        }
    }

}
