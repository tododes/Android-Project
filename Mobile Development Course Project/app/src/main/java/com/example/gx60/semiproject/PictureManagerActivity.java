package com.example.gx60.semiproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static com.example.gx60.semiproject.R.id.imageView;

public class PictureManagerActivity extends AppCompatActivity {

  /*  private static final int PICK_IMAGE = 100;
    private Button takePictureButton, downloadImageButton, saveURLButton;
    private WebView webView;

    private String urlStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_manager);

        takePictureButton = (Button) findViewById(R.id.takepicture);
        downloadImageButton = (Button) findViewById(R.id.downloadimage);
        saveURLButton = (Button) findViewById(R.id.saveimageurl);

        webView = (WebView) findViewById(R.id.profilesearch);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        saveURLButton.setVisibility(View.GONE);
        webView.setVisibility(View.GONE);

        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetGallery();
            }
        });

        downloadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveURLButton.setVisibility(View.VISIBLE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        saveURLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadTask dTask = new DownloadTask();
                dTask.execute(webView.getUrl());
            }
        });
    }

    private InputStream getHttpInputStream(String u)
    {
        InputStream i = null;
        try {
            URL url = new URL(u);
            URLConnection conn = url.openConnection();
            if(conn instanceof HttpURLConnection){
                HttpURLConnection httpCon = (HttpURLConnection) conn;
                httpCon.connect();
                int response = httpCon.getResponseCode();
                if(response == HttpURLConnection.HTTP_OK){
                    i = httpCon.getInputStream();
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    private Bitmap ImageBitmap(InputStream is){
        Bitmap b = BitmapFactory.decodeStream(is);
        return b;
    }

    private void SetGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    public class DownloadTask extends AsyncTask<String, Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... strings) {
            InputStream is = getHttpInputStream(strings[0]);
            Bitmap bitmap = ImageBitmap(is);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView iv = null;
            iv.setImageBitmap(bitmap);
        }
    }
*/
}
