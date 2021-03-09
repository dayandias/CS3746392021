package com.example.asynctaskproject1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.asynctaskproject1.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cscharff.
 */

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    private Activity activity;

    public ImageDownloader(FragmentActivity myActivity) {
        activity = myActivity;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.i("hello1", "hello1");
        publishProgress(1);
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
            publishProgress(0);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        TextView tv = (TextView) activity.findViewById(R.id.textview_first);
        if (values[0] == 1) {
            tv.setText("The Image is loading. Please wait...");
        } else {
            tv.setText("");
        }
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        Log.i("hello4", "hello4");
        ImageView iv = (ImageView) activity.findViewById(R.id.imageView);
        Log.i("hello5", "hello5");
        if (iv != null && img != null) {
            Log.i("hello6", "hello6");
            iv.setImageBitmap(img);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}