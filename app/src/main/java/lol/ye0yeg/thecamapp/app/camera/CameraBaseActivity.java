package lol.ye0yeg.thecamapp.app.camera;

import android.os.Bundle;

import lol.ye0yeg.thecamapp.base.BaseActivity;

/**
 * Created by Administrator on 7/14/2017.
 */
public class CameraBaseActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CameraManager.getInst().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CameraManager.getInst().removeActivity(this);
    }
}
