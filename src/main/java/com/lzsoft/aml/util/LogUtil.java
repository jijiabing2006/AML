package com.lzsoft.aml.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.SystemUtils;

public class LogUtil {
	/**
	 * 生成LOGs
	 * 
	 * @param logPath
	 *            　文件存放目录
	 * @param content
	 *            待定写入内容
	 * @throws Exception
	 */
	public static void generateLog(String logPath, String content)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		FileUtil.newFolder(logPath);
		String path = logPath + "\\auto_" + date + "short.log";
		writeLog(content + "\r\n", path);
	}

	/**
	 * 
	 * @param content
	 * @param path
	 *            logfilepath+filename
	 * @throws Exception
	 */
	public static void writeLog(String content, String path) throws Exception {
		RandomAccessFile f = new RandomAccessFile(path, "rw");
		FileChannel ccc = f.getChannel();
		ccc.position(ccc.size());
		ccc.write(ByteBuffer.wrap(content.getBytes()));
		ccc.close();
		f.close();
	}

	private static boolean hasFile = false;

	/**
	 * 生成写入Exception的文件
	 * 
	 * @param filepath
	 */
	private static void generateLogFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException EX) {
				System.out.println(EX.toString());
			}
		}
		hasFile = true;
	}

	/**
	 * 将Exception写入到文件中
	 * 
	 * @param logpath
	 *            Exception文件存放目录
	 * @param ex
	 */
	public static void handle(String logpath, Exception ex) {
		String filepath = logpath + "exception.log";
		if (!hasFile) {
			generateLogFile(filepath);
		}

		File file = new File(filepath);
		if (file.canWrite()) {
			PrintWriter streamWriter = null;
			try {
				streamWriter = new PrintWriter(new FileOutputStream(file, true));
				streamWriter
						.write("----------------------------------------------------------------");
				streamWriter.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()));
				streamWriter
						.write("----------------------------------------------------------------");
				streamWriter.write(SystemUtils.LINE_SEPARATOR);
				ex.printStackTrace(streamWriter);
				streamWriter.write(SystemUtils.LINE_SEPARATOR);
				streamWriter.close();
			} catch (IOException EX) {
				System.out.println(EX.toString());
			} finally {
				streamWriter.close();
			}
		} else {
			System.out.println("异常日志文件没有写权限");
		}
	}

}
