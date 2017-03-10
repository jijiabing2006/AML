package com;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @version: Feb 25, 2010 4:03:07 PM
 * @desc: 
 */
public class AutoJavaBean {
	static final String FILE_PATH = "config/javabean.xml";
//	private static Log log = LogFactory.getLog(AutoJavaBean.class);
	public static String className; // 要生产的javabean的类名
	public static String packageName; // 要生产的javabean的包名
	public ArrayList arraylist = new ArrayList(); // 属性容器
	public PrintWriter pw;
	public StringBuffer sb = new StringBuffer();

	/**
	 * 定义javabean中的属性. 这个javabean生成器只是一个小工具，为让它尽量小巧就用了内部类
	 */
	class Property {
		public String name; // 属性名字
		public String type; // 属性类型

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	/**
	 * 从文件读取XML，输入文件名，返回XML文档
	 */
	public Document read(String fileName) throws Exception {
		SAXReader reader = new SAXReader();
		String path = ClassPathUtil.getClassPath(AutoJavaBean.class);
		Document document = reader.read(new File(path + "//" +fileName));
		
		
		
		
		System.out.println("配置文件路径：" + path + "//" +fileName);
		return document;
	}

	/**
	 * 解析XML文档. 得到类名包名. 把所有属性放入容器
	 */
	public void parse(Document doc) {

		Element root = doc.getRootElement(); // 得到根节点
		//System.out.println("根节点名称：" + root.getName());
		
		packageName = root.attributeValue("name"); // 得到包名
		System.out.println("包名：" + packageName);
		
		className = root.element("class").attributeValue("name"); // 得到类名
		System.out.println("类名：" + className);

		// 枚举所有子节点，把所有属性放入容器
		for (Iterator i = root.element("class").elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			Property pro = null;
			String name = null;
			String type = null;
			if (element.getQualifiedName().equals("parameter")) {
				name = element.attributeValue("name");
				type = element.attributeValue("type");
				
				System.out.println("属性名称：" + name + "    属性类型：" + type);

				// 设置属性类
				pro = (new AutoJavaBean()).new Property();
				pro.setName(name);
				pro.setType(type);

				// 向容器添加属性
				arraylist.add(pro);
			}
		}

	}

	/**
	 * 写出javabean的开始部分. package import class
	 */
	public void start() {
		if (packageName.length() != 0) {
			sb.append("package " + packageName + "; ");
		}
		sb.append("import java.io.Serializable; ");
		sb.append("public class " + className + " implements Serializable {  ");
	}

	/**
	 * 写javabean的属性部分
	 */
	public void generateProperties() {
		ListIterator lit = arraylist.listIterator();
		Property pro = null;
		while (lit.hasNext()) {
			pro = (Property) lit.next();
			sb.append("	private " + pro.getType() + " " + pro.getName() + "; ");
		}
		sb.append(" ");
	}

	/**
	 * 写每个属性的 set() and get()
	 */
	public void generateMethods() {
		ListIterator lit = arraylist.listIterator();
		Property pro = null;
		String name = null;
		String type = null;
		while (lit.hasNext()) {
			pro = (Property) lit.next();
			name = pro.getName();
			type = pro.getType();

			// set()
			sb.append("	public void set" + name.substring(0, 1).toUpperCase()
					+ name.substring(1, name.length()) + "(" + type + " "
					+ name + ") { ");
			sb.append("		this." + name + " = " + name + "; ");
			sb.append("	} ");

			// get() 处理boolean类型
			if(!"boolean".equals(type)) {
				sb.append("	public " + type + " get"
						+ name.substring(0, 1).toUpperCase()
						+ name.substring(1, name.length()) + "(){ ");
				sb.append("		return " + name + "; ");
				sb.append("	} ");
			}
			else {
				sb.append("	public " + type + " is"
						+ name.substring(0, 1).toUpperCase()
						+ name.substring(1, name.length()) + "(){ ");
				sb.append("		return " + name + "; ");
				sb.append("	} ");
			}
		}
	}

	/**
	 * 添加结尾"}"
	 */
	public void end() {
		sb.append("} ");
	}

	/**
	 * 把生产的所有内容输出到真正的文件中
	 */
	public void makeFile() {
		try {
			String path = ClassPathUtil.getClassPath(AutoJavaBean.class);
			File file = new File(path + "//" + className + ".java");
			pw = new PrintWriter(file);
			
			pw.print(sb.toString());
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除classes下的javabean源文件
	 */
	public static void delTempFile() {
		String path = ClassPathUtil.getClassPath(AutoJavaBean.class);
		File file = new File(path + "//" + className + ".java");
		if(file.exists()) {
			file.delete();
		}
	}
	
	/**
	 * 把产生的javabean源文件输出到工作空间对应目录下
	 */
	public void makeFileToSrc() {
		try {
			String path = ClassPathUtil.getClassPath(AutoJavaBean.class);
//			path = path.substring(0, path.length()-16);
			int lastSlash = path.lastIndexOf(File.separator);
			
			path = path.substring(0, lastSlash) +File.separator+ "src";	//src路径
			
			packageName = packageName.replaceAll("//.", "////");
			String[] pack=StringUtils.split(packageName,".");
			String packagepath="";
			for (String string : pack) {
				packagepath+=string+File.separator;
			}
			File file = new File(path + File.separator + packagepath);
			file.mkdirs();	//创建包目录
		
			file = new File(path + File.separator + packagepath + File.separator + className + ".java");
			pw = new PrintWriter(file);
			
			pw.print(sb.toString());
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void execute() {
		try {
			
//			InputStream is = InverseTest.class.getClassLoader()
//					.getResourceAsStream(FILE_PATH);
//			Document document =(Document) DocumentFactory.getInstance().getDocument(is);
//			
//			
//			parse(document);
			parse(read("javabean.xml"));
			start();
			generateProperties();
			generateMethods();
			end();
			makeFileToSrc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(AutoJavaBean javaBean){
	
		
		
		try {
			Runtime rt = Runtime.getRuntime();
			String command = "javac -d ";
			String path = ClassPathUtil.getClassPath(AutoJavaBean.class);
			
			String pathSrc = path.substring(0, path.length()-16);
			int lastSlash = pathSrc.lastIndexOf("//");
			pathSrc = pathSrc.substring(0, lastSlash) + "//src";	//src目录地址路径
			
			//完整源文件地址
			pathSrc += "//" + packageName.replaceAll("//.", "////") + "//" + javaBean.className + ".java";
			
			System.out.println("编译命令：" + command + path + " " + pathSrc);
			rt.exec(command + path + " " + pathSrc);
			rt.gc();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AutoJavaBean javaBean = new AutoJavaBean();
		
		javaBean.execute();
		javaBean.run(javaBean);
	}
}	