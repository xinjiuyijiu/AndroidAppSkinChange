package achao.com.androidappskinchange.core;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseSkinActivity extends AppCompatActivity {
    protected Resources pluginResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        loadSkin();
    }

    protected void loadSkin() {
        File rootFile = Environment.getExternalStorageDirectory().getAbsoluteFile();
        File skinFile = new File(rootFile, "skin_plugin.apk");
        Resources resources = getResources();
        try {
            String skinPath = skinFile.getAbsolutePath();
            // 通过反射拿到AssetManger对象
            AssetManager assetManager = AssetManager.class.newInstance();
            // 获取AssetManger中方法
            Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
            // 调用方法：将皮肤文件添加到app的assets目录中
            method.invoke(assetManager, skinPath);
            // 获取插件包Resources对象，用来获取相关资源
            pluginResources = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            Log.d("skin", "skinpath--->"+skinPath+"pluginResources"+pluginResources);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
