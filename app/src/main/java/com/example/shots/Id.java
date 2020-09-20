package com.example.shots;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.wildma.idcardcamera.camera.IDCardCamera;
public class Id extends AppCompatActivity {

    private ImageView mIvFront;
    private ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        mIvFront = (ImageView) findViewById(R.id.iv_front);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
    }

    /**
     * Front of ID card
     */
    public void front(View view) {
        IDCardCamera.create(this).openCamera(IDCardCamera.TYPE_IDCARD_FRONT);
    }

    /**
     * Back of ID card
     */
    public void back(View view) {
        IDCardCamera.create(this).openCamera(IDCardCamera.TYPE_IDCARD_BACK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == IDCardCamera.RESULT_CODE) {
            //
            //Get image path, display image
            final String path = IDCardCamera.getImagePath(data);
            if (!TextUtils.isEmpty(path)) {
                if (requestCode == IDCardCamera.TYPE_IDCARD_FRONT) { //身份证正面
                    mIvFront.setImageBitmap(BitmapFactory.decodeFile(path));
                } else if (requestCode == IDCardCamera.TYPE_IDCARD_BACK) {  //身份证反面
                    mIvBack.setImageBitmap(BitmapFactory.decodeFile(path));
                }

                //In actual development, you need to delete all cached pictures after uploading the pictures to the server successfully
//                FileUtils.clearCache(this);
            }
        }
    }
}
