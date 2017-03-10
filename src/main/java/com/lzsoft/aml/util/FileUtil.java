package com.lzsoft.aml.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

@Component
public class FileUtil {

	/**
	 * 为下一步的文件操作准备路径。可处理"/path","c:/path","c:/path/file"
	 * 
	 * @param path
	 * @return 准备好的路径
	 */
	public String preparePath(File path) {
		return preparePath(path.getPath());
	}

	/**
	 * 为下一步的文件操作准备路径。可处理"/path","c:/path","c:/path/file"
	 * 
	 * @param path
	 * @return 准备好的路径
	 */
	public String preparePath(String path) {
		URL url = Thread.currentThread().getContextClassLoader()
				.getResource(".");
		if (File.separatorChar == '\\' && path.indexOf(':') < 0) {
			String rootPath = url.getPath();
			rootPath = rootPath.substring(0, rootPath.indexOf(':') + 1);
			path = rootPath + path;
		}

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		} else if (file.isFile()) {
			file.delete();
			path = file.getParent();
		}

		return path;
	}

	/**
	 * 
	 * @param filename
	 * @param wildcardFilenameFilter
	 * @return 相似（满足同一文件名通配符字符串）文件的数量
	 */
	public int getSimilarFileCount(String filename,
			WildcardFilenameFilter wildcardFilenameFilter) {
		return getSimilarFileCount(new File(filename), wildcardFilenameFilter);
	}

	/**
	 * 
	 * @param filename
	 * @param wildcardFilenameFilter
	 * @return 相似（满足同一文件名通配符字符串）文件的数量
	 */
	public int getSimilarFileCount(File file,
			WildcardFilenameFilter wildcardFilenameFilter) {
		if (file.exists() && file.isFile()) {
			String[] foundFiles = file.list(wildcardFilenameFilter);
			return foundFiles == null ? 0 : foundFiles.length;
		}
		return 0;
	}

	/**
	 * 
	 * @param file
	 * @return 无扩展名的文件名
	 */
	public String getShortNameWithoutExtendsname(File file) {
		String absolutePath = file.getAbsolutePath();
		int start = absolutePath.lastIndexOf(File.separator) + 1;
		int end = absolutePath.lastIndexOf('.');
		if (start >= 0 && end >= 0 && start < end) {
			return absolutePath.substring(start, end);
		}
		return null;
	}

	/**
	 * 复制文件
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 */
	public void copyFile(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		byte[] buffer = new byte[1024 * 10];

		BufferedInputStream bis = new BufferedInputStream(inputStream);
		BufferedOutputStream bos = new BufferedOutputStream(outputStream);

		while (true) {
			int length = bis.read(buffer);
			if (length == -1) {
				break;
			}
			bos.write(buffer, 0, length);
		}
		bis.close();
		bos.close();
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public String getExtendsFilename(String filename) {
//		String extendsName = null;
//		Matcher m = Pattern.compile("^.*(\\.[^.]+)$").matcher(filename);
//		if (m.matches()) {
//			extendsName = m.group(1);
//		}
		int index = filename.lastIndexOf('.');
		return index < 0 ? "" : filename.substring(index);
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param file
	 * @return
	 */
	public String getExtendsFilename(File file) {
		return file.getName();
	}

	/**
	 * 返回相对路径
	 * 
	 * @param basePath
	 * @param file
	 * @return
	 */
	public String getRelativePath(String basePath, File file) {
		String relativePath = file.getParent();

		basePath = new File(basePath).getAbsolutePath() + File.separator;
		if (relativePath.startsWith(basePath)) {
			relativePath = relativePath.substring(basePath.length());
		}
		return relativePath;
	}

	/**
	 * 文件更名
	 * 
	 * @param oldFilename
	 * @param newFilename
	 * @return
	 */
	public boolean renameFilename(String oldFilename, String newFilename)
			throws RuntimeException {
		File f = new File(oldFilename);
		return f.exists() && f.isFile() && f.renameTo(new File(newFilename));
	}

	/**
	 * 
	 * @return 程序当前运行路径
	 */
	public String getBasePath() {
		URL url = Thread.currentThread().getContextClassLoader()
				.getResource(".");
		return url.getPath();
	}

	/**
	 * 复制文件
	 * 
	 * @param sourceFilename
	 * @param destinationFilename
	 * @throws IOException
	 */
	public void copyFile(String sourceFilename, String destinationFilename)
			throws IOException {
		copyFile(new File(sourceFilename), new File(destinationFilename));
	}

	/**
	 * 复制文件
	 * 
	 * @param sourceFile
	 * @param destinationFile
	 * @throws IOException
	 */
	public void copyFile(File sourceFile, File destinationFile)
			throws IOException {
		FileInputStream fis = new FileInputStream(sourceFile);
		FileOutputStream fos = new FileOutputStream(destinationFile);

		copyFile(fis, fos);
	}
	
	/**
	 * 检测有效的文件路径，返回规范的绝对路径名字符串
	 * 
	 * @param path
	 * @return
	 */
	public String cardingPath(String path) {
		File file = new File(path);
		return file.exists() ? file.getAbsolutePath() : null;
	}
	/**
	 * 读取配置文件的属性到Map
	 * 
	 * @param filePath
	 *            配置文件的路径
	 * @return 各种属性配置的Map
	 * @throws ConfigurationException
	 *             解析文件异常
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getMapByPorpFile(String filePath)
			throws ConfigurationException {

		Configuration config;
		config = new PropertiesConfiguration(filePath);
		Iterator<String> iter = config.getKeys();

		Map<String, String> map = new HashMap<String, String>();

		while (iter.hasNext()) {

			String key = iter.next().toString();

			map.put(key, config.getString(key));

		}
		return map;

	}

	/**
	 * 目录不存在，新建目录
	 * 
	 * @param folderPath
	 *            String 如 c:/fqf
	 * @return boolean
	 */
	public static boolean newFolder(String folderPath) {
		try {
			String splitStr = "";
			if (folderPath.indexOf("/") != -1)
				splitStr = "/";
			else
				splitStr = "\\";
			StringTokenizer st = new StringTokenizer(folderPath, splitStr);
			String folder = st.nextToken() + splitStr;
			String subFolder = folder;
			while (st.hasMoreTokens()) {
				folder = st.nextToken() + splitStr;
				subFolder += folder;
				File myFilePath = new File(subFolder);
				if (!myFilePath.exists())
					myFilePath.mkdir();
			}
			return true;
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 递归删除文件夹(删除文件夹,包括path里的最后一个文件夹)
	 * 
	 * @param path
	 * @return true：删除文件夹成功 false：失败
	 * @throws Exception
	 */
	public static boolean delDir(String path) throws Exception {
		boolean bIsSuccess = false;
		File dir = new File(path);
		if (dir.exists()) {
			File[] tmp = dir.listFiles();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].isDirectory()) {
					delDir(path + "/" + tmp[i].getName());
				} else {
					tmp[i].delete();
				}
			}
			bIsSuccess = dir.delete();
		} else {
			System.out.println(path + "不存在......");
			bIsSuccess = false;
		}
		return bIsSuccess;
	}

	/**
	 * 递归删除文件夹(删除文件夹,不包括path里的最后一个文件夹)
	 * 
	 * @param path
	 * @return true：删除文件夹成功 false：失败
	 * @throws Exception
	 */
	public static boolean deleteDir(String path) throws Exception {
		boolean bIsSuccess = false;
		File dir = new File(path);
		if (dir.exists()) {
			File[] tmp = dir.listFiles();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].isDirectory()) {
					delDir(path + "/" + tmp[i].getName());
				} else {
					tmp[i].delete();
				}
			}
		} else {
			System.out.println(path + "不存在......");
			bIsSuccess = false;
		}
		return bIsSuccess;
	}

	/**
	 * 返回一个目录下的文件
	 * 
	 * @param file
	 *            目录
	 * @param pattern
	 *            后缀名
	 * @return
	 */
	public static List<File> getFiles(File file, String pattern) {

		File[] files = null;

		List<File> result = new ArrayList<File>();

		if (file.isDirectory()) {
			files = file.listFiles();
			if (null != files && files.length != 0) {
				for (int i = 0; i < files.length; i++) {
					File f = files[i];
					if (pattern.equals("")) {
						result.add(f);
					} else {
						if (f.getPath().indexOf("复件") == -1
								&& f.getPath().substring(
										f.getPath().lastIndexOf(".") + 1)
										.equals(pattern))
							result.add(f);
					}
				}
			}
		}

		return result;

	}
	
	/**
	 * 判断指定的文件或文件夹是否存在
	 * @param filePath 文件或文件夹路径
	 * @param flag true表示文件夹，false表示文件
	 * @return 是否存在
	 */
	public static boolean isExists(String filePath,boolean flag){
		File file=new File(filePath);
		if(file.exists()){
			if(flag){
				if(file.isDirectory())
					return true;
				else
					return false;
			}
			return true;
		}else{
			return false;
		}
	}

}
