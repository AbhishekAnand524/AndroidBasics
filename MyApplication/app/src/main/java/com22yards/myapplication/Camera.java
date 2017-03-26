package com22yards.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera extends AppCompatActivity {

    ImageView imageView;
    Button cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = (ImageView) findViewById(R.id.imageDisplay);
        cameraButton = (Button) findViewById(R.id.cameraButton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
            }
        });
    }

    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        if(requestcode == 0 && resultcode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            storeImage(photo);
        }
    }

    private void storeImage(Bitmap image){
        File pictureFile = mediaOutputFile();
        if(pictureFile == null){
            Log.e("Error","check permsissions");
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG,90,fos);
            fos.close();
        }
        catch (FileNotFoundException e){
            Log.e("Error","File not found");
        }
        catch (IOException e){
            Log.e("Error","Accessing the file");
        }
    }

    private File mediaOutputFile(){
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory() + "/" + getApplicationContext().getPackageName() + "/images");
        if(!mediaStorageDir.exists()){
            if(! mediaStorageDir.mkdirs()){
                Toast.makeText(Camera.this,"Permissions not available",Toast.LENGTH_LONG).show();
                return null;
            }
        }
        String timesStamp = new SimpleDateFormat("ddMMyyyy_hhmm").format(new Date());
        File mediaFile;
        String imageName = "IMAGE_" + timesStamp + ".jpg";
        mediaFile = new File((mediaStorageDir.getPath()) + File.separator + imageName);
        return mediaFile;
    }
}