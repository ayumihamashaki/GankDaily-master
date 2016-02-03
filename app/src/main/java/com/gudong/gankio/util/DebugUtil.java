package com.gudong.gankio.util;

import android.util.Log;
/**
 * ���Թ�����
 * @author rmtic
 *
 */
public class DebugUtil {
    
	private static String year = "2015";
	private static String copyright="mondu";
	private static String version = "1.0";
    private static final boolean DEBUG = true;
    private static String TAG = "DebugUtil";
    
    public DebugUtil(String tag) {
    	this.TAG = tag;
	}
    
    
    public static void LogError(String log) {
        if (DEBUG)
            Log.e(TAG, "" + log);
    }

    public static void LogDebug(String log) {
        if (DEBUG)
            Log.d(TAG, "" + log);
    }

    public static void i(String log) {
        if (DEBUG)
            Log.i(TAG, "" + log);
    }
    
    public static void error(String code,String msg){
    	if (!DEBUG)return;
    	StringBuffer  buffer= new StringBuffer();
    	buffer.append("["+year+",@"+copyright+","+version+"] : ***********************************************************\n");
    	buffer.append("������� = "+code+"\n");
    	buffer.append("������Ϣ = "+msg+"\n");
    	buffer.append("***********************************************************");
    	Log.e(TAG, "" + buffer.toString());
    }
    
}//end of class
