package com.example.amos.youshi;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amos on 17-4-18.
 */

public class RemoteImageHelper extends BaseActivity {
    private final Map<String, Drawable> cache = new HashMap<String, Drawable>();

    private InputStream download(String urlString) throws MalformedURLException, IOException {
        InputStream inputStream = (InputStream) new URL(urlString).getContent();
        return inputStream;
    }

    public void loadImage(final ImageView imageView, final String urlString, boolean useCache) {
        if (useCache && cache.containsKey(urlString)) {
            imageView.setImageDrawable(cache.get(urlString));
        }

        //Show a "Loading" image here
        imageView.setImageResource(R.drawable.ing);

        Log.d(this.getClass().getSimpleName(), "Image url:" + urlString);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                imageView.setImageDrawable((Drawable) message.obj);
            }
        };

        Runnable runnable = new Runnable() {
            public void run() {
                Drawable drawable = null;
                try {
                    InputStream is = download(urlString);
                    drawable = Drawable.createFromStream(is, "src");

                    if (drawable != null) {
                        cache.put(urlString, drawable);
                    }
                } catch (Exception e) {
                    Log.e(this.getClass().getSimpleName(), "Image download failed", e);
                    //Show a "download fail" image
                    drawable = imageView.getResources().getDrawable(R.drawable.fail);
                }

                //Notify UI thread to show this image using Handler
                Message msg = handler.obtainMessage(1, drawable);
                handler.sendMessage(msg);
            }
        };
        new Thread(runnable).start();
    }

}
