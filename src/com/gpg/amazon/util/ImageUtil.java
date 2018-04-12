package com.gpg.amazon.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ImageUtil {
	public static Map<String, BufferedImage> getCode() {
		// 1. 验证码内容文本生成
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		String s = "";

		int intCount = 0;

		intCount = (new Random()).nextInt(9999);//

		if (intCount < 1000) // 数字位数补全
			intCount += 1000;

		s = intCount + "";
		// 保存入session,用于与用户的输入进行比较.
		// 注意比较完之后清除session.
		// session.setAttribute("validateCode", s);

		// 2. 通过Java2D绘图API将验证码文本转换为图片
		BufferedImage image = new BufferedImage(35, 14, // 指定宽，高
				BufferedImage.TYPE_INT_RGB);

		// 绘图对象Graphics
		Graphics gra = image.getGraphics();
		// 设置背景色
		gra.setColor(Color.GREEN);
		gra.fillRect(1, 1, 33, 12);
		// 设置字体色
		gra.setColor(Color.black);
		gra.setFont(new Font("宋体", Font.PLAIN, 12)); // 指定字体、样式、字号大小
		// 输出数字
		char c;

		for (int i = 0; i < 4; i++) {

			c = s.charAt(i);

			gra.drawString(c + "", i * 7 + 4, 11); // 7为宽度，11为上下高度位置

		}
		map.put(s, image);
		return map;
	}

}
