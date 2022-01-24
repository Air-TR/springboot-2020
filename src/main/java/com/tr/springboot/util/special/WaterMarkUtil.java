package com.tr.springboot.util.special;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

/**
 * 图片加水印
 *
 * @author rtao
 * @date 2022/1/17 18:10
 */
public class WaterMarkUtil {

    public static void main(String[] args) {
        Font font = new Font("宋体", Font.PLAIN, 20); // 水印字体
        String srcImgPath = "/Users/taorun/pair.jpg"; // 源图片地址
        String tarImgPath = "/Users/taorun/pair2.jpg"; // 待存储的地址
        String content = "图片来源：http://www.tr.com"; // 水印内容
        Color color = new Color(100, 100, 100, 100); // 水印图片色彩以及透明度
        new WaterMarkUtil().addWaterMark(srcImgPath, tarImgPath, content, color, font);
    }

    /**
     * 加水印
     *
     * @param srcImgPath 源图片路径
     * @param tarImgPath 保存的图片路径
     * @param waterMarkContent 水印内容
     * @param markContentColor 水印颜色
     * @param font 水印字体
     */
    public void addWaterMark(String srcImgPath, String tarImgPath, String waterMarkContent, Color markContentColor, Font font) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath); // 得到文件
            Image srcImg = ImageIO.read(srcImgFile); // 文件转化为图片
            int srcImgWidth = srcImg.getWidth(null); // 获取图片的宽
            int srcImgHeight = srcImg.getHeight(null); // 获取图片的高

            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); // 根据图片的背景设置水印颜色
            g.setFont(font); // 设置字体

            // 设置水印的坐标
            int x = (int) ((srcImgWidth - getWatermarkLength(waterMarkContent, g)) * 0.5);
            int y = (int) (srcImgHeight * 0.5);
            g.drawString(waterMarkContent, x, y); // 画出水印
            g.dispose();

            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("添加水印完成");
            outImgStream.flush();
            outImgStream.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

}
