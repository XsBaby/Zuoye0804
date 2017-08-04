package com.xushuai.zuoye0804.view.photoView.tools;

public class Config {

    //	public static int limit;
    static String savePathString;

    static {
        savePathString = "/temp";
    }

    public static void setSavePath(String path) {
        Config.savePathString = path;
    }

    public static String getSavePath() {
        return savePathString;
    }
}