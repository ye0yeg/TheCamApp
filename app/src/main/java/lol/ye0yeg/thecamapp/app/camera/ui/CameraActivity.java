package lol.ye0yeg.thecamapp.app.camera.ui;

import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import lol.ye0yeg.thecamapp.R;
import lol.ye0yeg.thecamapp.app.camera.CameraBaseActivity;
import lol.ye0yeg.thecamapp.app.camera.CameraManager;
import lol.ye0yeg.thecamapp.app.camera.util.CameraHelper;
import lol.ye0yeg.thecamapp.app.model.PhotoItem;
import lol.ye0yeg.thecamapp.com.customview.CameraGrid;
import lol.ye0yeg.thecamapp.common.util.DistanceUtil;
import lol.ye0yeg.thecamapp.common.util.FileUtils;
import lol.ye0yeg.thecamapp.common.util.ImageLoaderUtils;
import lol.ye0yeg.thecamapp.common.util.StringUtils;
import lol.ye0yeg.thecamapp.stickercamera.App;

/**
 * Created by Administrator on 7/14/2017.
 * <p>
 * /*
 * __xxxxxxxxxxxxxxxx___.
 * _gxXXXXXXXXXXXXXXXXXXXXXXXX!x_
 * __x!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!x_
 * ,gXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx_
 * ,gXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!_
 * _!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!.
 * gXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXs
 * ,!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!.
 * g!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * iXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * ,XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
 * !XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
 * ,XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
 * !XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXi
 * dXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * !XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXf~~~VXXXXXXXXXXXXXXXXXXXXXXXXXXvvvvvvvvXXXXXXXXXXXXXX!
 * !XXXXXXXXXXXXXXXf`       'XXXXXXXXXXXXXXXXXXXXXf`          '~XXXXXXXXXXP
 * vXXXXXXXXXXXX!            !XXXXXXXXXXXXXXXXXX!              !XXXXXXXXX
 * XXXXXXXXXXv`              'VXXXXXXXXXXXXXXX                !XXXXXXXX!
 * !XXXXXXXXX.                 YXXXXXXXXXXXXX!                XXXXXXXXX
 * XXXXXXXXX!                 ,XXXXXXXXXXXXXX                VXXXXXXX!
 * 'XXXXXXXX!                ,!XXXX ~~XXXXXXX               iXXXXXX~
 * 'XXXXXXXX               ,XXXXXX   XXXXXXXX!             xXXXXXX!
 * !XXXXXXX!xxxxxxs______xXXXXXXX   'YXXXXXX!          ,xXXXXXXXX
 * YXXXXXXXXXXXXXXXXXXXXXXXXXXX`    VXXXXXXX!s. __gxx!XXXXXXXXXP
 * XXXXXXXXXXXXXXXXXXXXXXXXXX!      'XXXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXXXP        'YXXXXXXXXXXXXXXXXXXXXXXX!
 * XXXXXXXXXXXXXXXXXXXXXXXX!     i    !XXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXX!     XX   !XXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXx_   iXX_,_dXXXXXXXXXXXXXXXXXXXXXXXX
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXP
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * ~vXvvvvXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXf
 * 'VXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXvvvvvv~
 * 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX~
 * _    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXv`
 * -XX!  !XXXXXXX~XXXXXXXXXXXXXXXXXXXXXX~   Xxi
 * YXX  '~ XXXXX XXXXXXXXXXXXXXXXXXXX`     iXX`
 * !XX!    !XXX` XXXXXXXXXXXXXXXXXXXX      !XX
 * !XXX    '~Vf  YXXXXXXXXXXXXXP YXXX     !XXX
 * !XXX  ,_      !XXP YXXXfXXXX!  XXX     XXXV
 * !XXX !XX           'XXP 'YXX!       ,.!XXX!
 * !XXXi!XP  XX.                  ,_  !XXXXXX!
 * iXXXx X!  XX! !Xx.  ,.     xs.,XXi !XXXXXXf
 * XXXXXXXXXXXXXXXXX! _!XXx  dXXXXXXX.iXXXXXX
 * VXXXXXXXXXXXXXXXXXXXXXXXxxXXXXXXXXXXXXXXX!
 * YXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXV
 * 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!
 * 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXf
 * VXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXf
 * VXXXXXXXXXXXXXXXXXXXXXXXXXXXXv`
 * ~vXXXXXXXXXXXXXXXXXXXXXXXf`
 * ~vXXXXXXXXXXXXXXXXv~
 * '~VvXXXXXXXV~~
 * ~~
 */

public class CameraActivity extends CameraBaseActivity {

    private CameraHelper mCameraHelper;
    private Camera.Parameters parameters = null;
    private Camera cameraInst = null;
    private Bundle bundle = null;
    private int photoWidth = DistanceUtil.getCameraPhotoWidth();
    private int photoNumber = 4;
    private int photoMargin = App.getApp().dp2px(1);
    private float pointX, pointY;
    static final int FOCUS = 1;            // 聚焦
    static final int ZOOM = 2;            // 缩放
    private int mode;                      //0是聚焦 1是放大
    private float dist;
    private int PHOTO_SIZE = 2000;
    private int mCurrentCameraId = 0;  //1是前置 0是后置
    private Handler handler = new Handler();

    @InjectView(R.id.masking)
    CameraGrid cameraGrid;
    @InjectView(R.id.photo_area)
    LinearLayout photoArea;
    @InjectView(R.id.panel_take_photo)
    View takePhotoPanel;
    @InjectView(R.id.takepicture)
    Button takePicture;
    @InjectView(R.id.flashBtn)
    ImageView flashBtn;
    @InjectView(R.id.change)
    ImageView changeBtn;
    @InjectView(R.id.back)
    ImageView backBtn;
    @InjectView(R.id.next)
    ImageView galleryBtn;
    @InjectView(R.id.focus_index)
    View focusIndex;
    @InjectView(R.id.surfaceView)
    SurfaceView surfaceView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mCameraHelper = new CameraHelper(this);
        ButterKnife.inject(this);
        initView();
        initEvent();
    }

    private void initView() {
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.setFocusable(true);
        surfaceView.setBackgroundColor(TRIM_MEMORY_BACKGROUND);
        surfaceView.getHolder().addCallback(new SurfaceCallback());//为SurfaceView的句柄添加一个回调函数

        //设置相机界面，照片列表，拍照布局以及高度
        ViewGroup.LayoutParams layoutParams = cameraGrid.getLayoutParams();
        layoutParams.height = App.getApp().getScreenWidth();
        layoutParams = photoArea.getLayoutParams();
        layoutParams.height = DistanceUtil.getCameraPhotoAreaHeight();
        layoutParams = takePhotoPanel.getLayoutParams();
        layoutParams.height = App.getApp().getScreenHeight()
                - App.getApp().getScreenWidth()
                - DistanceUtil.getCameraPhotoAreaHeight();

        //添加系统相册图片
        ArrayList<PhotoItem> sysPhotos = FileUtils.getInst().findPicsInDir(
                FileUtils.getInst().getSystemPhotoPath());
        int showNumber = sysPhotos.size() > photoNumber ? photoNumber
                : sysPhotos.size();
        for (int i = 0; i < showNumber; i++) {
            addPhoto(sysPhotos.get(showNumber - 1 - i));
        }
    }

    private void addPhoto(PhotoItem photoItem) {
        ImageView photo = new ImageView(this);
        if (StringUtils.isNotBlank(photoItem.getImageUri())) {
            ImageLoaderUtils.displayLocalImage(photoItem.getImageUri(), photo, null);
        } else {
            photo.setImageResource(R.drawable.default_img);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                photoWidth, photoWidth);
        params.leftMargin = photoMargin;
        params.rightMargin = photoMargin;
        params.gravity = Gravity.CENTER;
        photo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        photo.setTag(photoItem.getImageUri());

        if (photoArea.getChildCount() >= photoNumber) {
            photoArea.removeViewAt(photoArea.getChildCount() - 1);
            photoArea.addView(photo, 0, params);
        } else {
            photoArea.addView(photo, 0, params);
        }
        photo.setOnClickListener(v -> {
            if (v instanceof ImageView && v.getTag() instanceof String) {
                CameraManager.getInst().processPhotoItem(CameraActivity.this,
                        new PhotoItem((String) v.getTag(), System.currentTimeMillis()));
            }
        });
    }

    private void initEvent() {


    }


}
