package com.bugqa.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

/**
 * 文件工具
 * 
 * @author s1507112
 *
 */
public final class FileUtil {

	/**
	 * 保存文件
	 * 
	 * @param file
	 *            文件
	 * @param fileName
	 *            文件名
	 * @throws IOException
	 */
	public static void saveFile(File file, String fileName) throws IOException {
		// TODO String realpath =
		// ServletActionContext.getServletContext().getRealPath("/images");
		File savefile = new File(new File(BaseConstants.FILESAVEPATH), fileName);
		if (!savefile.getParentFile().exists())
			savefile.getParentFile().mkdirs();
		FileUtils.copyFile(file, savefile);
	}

	/**
	 * 读文件
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 * @throws IOException
	 */
	public static InputStream readFile(String fileName) throws IOException {

		return new FileInputStream(new File(BaseConstants.FILESAVEPATH + fileName));
	}
}
