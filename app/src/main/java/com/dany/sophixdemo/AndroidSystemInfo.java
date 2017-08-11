package com.dany.sophixdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * add by dan.y 2017/2/16.
 */

public class AndroidSystemInfo {
	public final static String PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"";//sd卡根目录路径

	/**
	 * 获取应用版本号
	 */
	public static String getVersion(Context context){
		PackageManager manager = context.getPackageManager();
		PackageInfo info = null;
		try {
			info = manager.getPackageInfo(context.getPackageName(),0 );
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		String version = info.versionName;
		return version;
	}
	
	/**
	 * 安装apk
	 */
	 public static void installApk(Context context, String fileName)
	 {
	  File file = new File(fileName);
      chmod("777", file.getAbsolutePath());
	  Intent intent = new Intent();
	  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	  intent.setAction(Intent.ACTION_VIEW);
	  String type = "application/vnd.android.package-archive";
	  intent.setDataAndType(Uri.fromFile(file), type);
	  context.startActivity(intent);
	 }
	 
	 /**
	  * 获得权限
	  */
	 public static void chmod(String permission, String path){
		 String command = "chmod "+permission+" "+path;
		 Runtime runtime = Runtime.getRuntime();
		 try {
			runtime.exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 

}
