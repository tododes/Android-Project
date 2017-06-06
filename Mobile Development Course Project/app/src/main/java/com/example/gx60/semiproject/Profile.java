package com.example.gx60.semiproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Profile extends AppCompatActivity {

    private Uri imageUri;
    private ImageView imageView;
    private Button uploadButton;
    private String imageUriStr;
    private Toolbar toolbar;
    private Button buttonToWebView;

    private Button saveURLButton;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.normal_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        imageView = (ImageView) findViewById(R.id.ProfileImage);
        if(getIntent().getStringExtra("CurrentProfileURI") != null)
        {
            if(!getIntent().getStringExtra("CurrentProfileURI").isEmpty())
            {
                imageView.setImageURI(Uri.parse(getIntent().getStringExtra("CurrentProfileURI")));
                imageUri = Uri.parse(getIntent().getStringExtra("CurrentProfileURI"));
            }
        }


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setEnabled(true);
                webView.setVisibility(View.VISIBLE);
                saveURLButton.setEnabled(true);
                saveURLButton.setVisibility(View.VISIBLE);
            }
        });

        uploadButton = (Button) findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageUriStr = imageUri.toString();
                Toast.makeText(Profile.this, "Changes saved", Toast.LENGTH_SHORT).show();
            }
        });

        buttonToWebView = (Button) findViewById(R.id.button_to_webview);
        buttonToWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, MapActivity.class);
                startActivity(i);
            }
        });

        saveURLButton = (Button) findViewById(R.id.saveimageurl);
        saveURLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webView.getUrl().contains(".jpg") || webView.getUrl().contains(".png") || webView.getUrl().contains(".bmp") ){
                    DownloadTask dTask = new DownloadTask();
                    dTask.execute(webView.getUrl());
                    webView.loadUrl("http://www.google.com");
                    saveURLButton.setEnabled(false);
                    saveURLButton.setVisibility(View.GONE);
                    webView.setEnabled(false);
                    webView.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(Profile.this, "This is not an image", Toast.LENGTH_LONG).show();
                }
            }
        });

        webView = (WebView) findViewById(R.id.WebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        saveURLButton.setEnabled(false);
        saveURLButton.setVisibility(View.GONE);

        webView.setEnabled(false);
        webView.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.standard_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 100)
        {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    public Uri getImageUri(){ return imageUri; }

    @Override
    public void onBackPressed() {
        if(!imageUri.equals(null))
            imageUriStr = imageUri.toString();
        //getIntent().putExtra("ProfileURI", imageUriStr);
        Intent i = new Intent();
        i.putExtra("ProfileURI", imageUriStr);
        setResult(RESULT_OK, i);
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings)
        {
            Intent i = new Intent(this, Profile.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
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
            imageView.setImageBitmap(bitmap);
        }
    }

}
