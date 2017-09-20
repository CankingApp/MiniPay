package com.canking.minipay;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by changxing on 2017/9/8.
 */

public class WeZhi {
    /*package*/ static void startWeZhi(Context c, View view) {
        File dir = c.getExternalFilesDir("pay_img");
        if (dir != null &&
                !dir.exists() && !dir.mkdirs()) {
            return;
        }
        String fileName = "weixin_qa.png";
        File file = new File(dir, fileName);

        if (!file.exists()) {
            snapShot(c, file, view);
        } else {
            try {
                file.setLastModified(System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
            startWechat(c);
        }
    }

    private static void snapShot(Context context, @NonNull File file, @NonNull View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmap);
        view.draw(canvas);

        FileOutputStream fos = null;
        boolean isSuccess = false;
        try {
            fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            isSuccess = bitmap.compress(Bitmap.CompressFormat.PNG, 80, fos);
            fos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MiniPayUtils.closeIO(fos);
        }
        if (isSuccess) {
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues values = new ContentValues(4);
            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
            values.put(MediaStore.Images.Media.ORIENTATION, 0);
            values.put(MediaStore.Images.Media.TITLE, "捐赠");
            values.put(MediaStore.Images.Media.DESCRIPTION, "捐赠二维码");
            values.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());
            Uri url = null;

            try {
                url = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values); //其实质是返回 Image.Meida.DATA中图片路径path的转变而成的uri
                OutputStream imageOut = contentResolver.openOutputStream(url);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, imageOut);
                } finally {
                    MiniPayUtils.closeIO(imageOut);
                }

                long id = ContentUris.parseId(url);
                MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, MediaStore.Images.Thumbnails.MINI_KIND, null);//获取缩略图

            } catch (Exception e) {
                if (url != null) {
                    contentResolver.delete(url, null, null);
                }
            }
        }
    }

    /*package*/ static void startWechat(Context c) {
        Intent intent = new Intent();
        ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(cmp);
        if (MiniPayUtils.isActivityAvailable(c, intent)) {
            c.startActivity(intent);
        } else {
            Toast.makeText(c, "未安装微信～", Toast.LENGTH_SHORT).show();
        }
    }
}
