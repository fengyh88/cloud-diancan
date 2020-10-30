package com.fish.cloud.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageUtil {

    //protected static Logger logger = LogManager.getLogger();
    /**
     * 保存图片到磁盘
     * @param instreams 二进制流
     * @param imgPath 图片的保存路径
     * @param imgName 图片的名称
     * @return 1：保存正常 0：保存失败
     */
    public static int saveImgByInputStream(InputStream instreams, String imgPath, String imgName) {
        //如果没有files文件夹，则创建
        Path pathDir = Paths.get(imgPath);
        try {
            if (!Files.isWritable(pathDir)) {
                Files.createDirectories(pathDir);
            }
        } catch (IOException ex) {
            //logger.error(ex.getStackTrace());
            return 0;
        }

        int r = 1;
        if (instreams == null) {
            return r;
        }

        try {
            File file = new File(imgPath + imgName);// 可以是任何图片格式.jpg,.png等
            FileOutputStream fos = new FileOutputStream(file);

            byte[] b = new byte[1024];
            int nRead = 0;
            while ((nRead = instreams.read(b)) != -1) {
                fos.write(b, 0, nRead);
            }
            fos.flush();
            fos.close();
        } catch (Exception e) {
            r = 0;
            e.printStackTrace();
        } finally {
            try {
                instreams.close();
            } catch (IOException e) {
                r = 0;
                e.printStackTrace();
            }
        }
        return r;
    }
}
