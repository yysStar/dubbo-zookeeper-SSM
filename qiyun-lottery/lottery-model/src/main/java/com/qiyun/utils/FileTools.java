package com.qiyun.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.qiyun.commonModel.PlayType;
import com.qiyun.model.FuHao;
import com.qiyun.model.ImageFilter;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;
import org.apache.commons.io.FileUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class FileTools {
	public static String getPath(){
		URL fileUrl=FileTools.class.getResource("/");
		File file=new File(fileUrl.getFile());
		return file.getPath();
	}
	
	public static String getRealPath(String abPath){
		return getPath()+abPath;
	}
	
	public static void uploadFile(File file, String toFilePath) throws FileNotFoundException, IOException {
		InputStream is = null;
		BufferedOutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new BufferedOutputStream(new FileOutputStream(toFilePath));
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (os != null)
				os.close();
			if (is != null)
				is.close();
		}
	}

	public static void uploadFile(InputStream fis, String toFilePath) throws FileNotFoundException, IOException {
		InputStream is = null;
		BufferedOutputStream os = null;
		try {
			is = fis;
			os = new BufferedOutputStream(new FileOutputStream(toFilePath));
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (os != null)
				os.close();
			if (is != null)
				is.close();
		}
	}

	public static String getFileContent(String filePath, String charSet) throws Exception {
		InputStreamReader isr = null;
		BufferedReader in = null;
		try {
			isr = new InputStreamReader(new FileInputStream(filePath), charSet);
			in = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					sb.append(temp).append("\n");
				}
			}
			return sb.toString();
		} finally {
			if(in != null) in.close();
			if(isr != null) isr.close();
		}

	}
	
	public static String getFileContent(String filePath) throws Exception {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					sb.append(temp).append("\n");
				}
			}
			return sb.toString();
		} finally {
			if (in != null)
				in.close();
		}

	}

	/**
	 * 双色球文件转换成单式格式字符串
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */

	public static String getFileSsqContent(String filePath) throws Exception {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			StringBuffer sb = new StringBuffer();
			String preStr;
			String endStr;
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					temp = temp.trim().replaceAll(" ", ",");
					preStr = temp.substring(0, temp.lastIndexOf(","));
					endStr = temp.substring(temp.lastIndexOf(",") + 1);
					sb.append(preStr).append("|").append(endStr).append(FuHao.ZS);
				}
			}
			return sb.toString();
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (in != null)
				in.close();
		}

	}
	
	/**
	 * 获取排列五单式上传
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static String getFilePL5DSUPLOADContent(String filePath,PlayType playType) throws Exception{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					String templet="";
					for(int i=0;i<temp.length();i++){
						if(i!=0){
							templet+=","+temp.charAt(i);
						}else{
							templet+=temp.charAt(i);
						}
					}
					String []arr=templet.split(",");
					sb.append(playType.getValue()+":").append(arr[0]+"|").append(arr[1]+"|").append(arr[2]+"|").append(arr[3]+"|").append(arr[4]).append("~");
				}
			}
			return sb.toString();
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	public static String getFileDltContent(String filePath) throws Exception{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			StringBuffer sb = new StringBuffer();
			String preStr;
			String endStr;
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					temp = temp.trim().replaceAll(" ", ",");
					preStr = temp.substring(0, temp.lastIndexOf(","));
					endStr = temp.substring(temp.lastIndexOf(",") + 1);
					sb.append(preStr).append(",").append(endStr).append(FuHao.ZS);
				}
			}
			return full2HalfChange(sb.toString());
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	public static String getFileSDContent(String filePath) throws Exception{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					temp = temp.trim();
					String[] codes = temp.split("\\B");
					sb.append(codes[0]+"|"+codes[1]+"|"+codes[2]).append(FuHao.ZS);
				}
			}
			return sb.toString();
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	public static String getFileContentForUploadPlan(String filePath, String filterString) throws Exception {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				if (temp.trim().length() > 0) {
					temp = temp.trim();
					String[] filterCode = filterString.split("#");
					for (int i = 0; i < filterCode.length; i++) {
						temp = temp.replaceAll(filterCode[i], "");
					}
					sb.append(temp.trim()).append("\n");
				}
			}
			return sb.toString();
		} finally {
			if (in != null)
				in.close();
		}

	}
	
	//获取文件内容，不需要全角到半角转化
	public static String getFileContentNotQj2bj(File file) throws Exception {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = in.readLine()) != null) {
				sb.append(temp).append("\n");
			}
			return sb.toString();
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	//获取文件内容，默认需要全角到半角转化
	public static String getFileContent(File file) throws Exception {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = full2HalfChange(in.readLine())) != null) {
				sb.append(temp).append("\n");
			}
			return sb.toString();
		} finally {
			if (in != null)
				in.close();
		}
	}

	public static void setFileContent(String content, String filePath) throws Exception {
		FileWriter fw = null;
		try {
			File file = new File(filePath);
			if(!file.exists()){
				LogUtil.info("文件不存在 创建文件:"+filePath);
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			fw = new FileWriter(filePath);
			fw.write(content);
		} finally {
			if (fw != null) {
				fw.close();
			}
		}

	}
	
	public static void setFileContent(String content, String filePath,String chatset) throws Exception {
		try {
			File file = new File(filePath);
			if(!file.exists()){
				LogUtil.info("文件不存在 创建文件:"+filePath);
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			FileUtils.writeStringToFile(file, content, chatset);
		} finally {
		}
	}

	public static boolean createFile(String filePath){
		 File file = new File(filePath); 
		 if (file.exists()) { 
			 LogUtil.warn("创建单个文件" + filePath + "失败，目标文件已存在！"); 
			 return false; 
		 } 
		 if (filePath.endsWith(File.separator)) { 
			 LogUtil.warn("创建单个文件" + filePath + "失败，目标不能是目录！"); 
			 return false; 
		 } 
		 if (!file.getParentFile().exists()) { 
			 LogUtil.info("目标文件所在路径不存在，准备创建。。。"); 
			 if (!file.getParentFile().mkdirs()) { 
				 LogUtil.warn("创建目录文件所在的目录失败！"); 
				 return false; 
			 }
		 }	 
		// 创建目标文件
		 try { 
			 if (file.createNewFile()) { 
				 LogUtil.info("创建单个文件" + filePath + "成功！"); 
				 return true; 
			 } else { 
				 LogUtil.warn("创建单个文件" + filePath + "失败！"); 
				 return false; 
			 } 
			 } catch (IOException e) {
				 LogUtil.error("创建单个文件" + filePath + "失败！",e);
				 return false; 
			 } 
	}
	
	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);
		return file.delete();
	}

	public static boolean mkdir(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return file.mkdir();
		}
		return true;
	}
	
	public static boolean exists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	public static boolean mkdirs(String filePath) {
		File file = new File(filePath);
		return file.mkdirs();
	}

	public static void deleteDirectory(File dir) throws IOException {
		if ((dir == null) || !dir.isDirectory()) {
			throw new IllegalArgumentException("Argument " + dir + " is not a directory. ");
		}
		File[] entries = dir.listFiles();
		for (int i = 0; i < entries.length; i++) {
			if (entries[i].isDirectory()) {
				deleteDirectory(entries[i]);
			} else {
				entries[i].delete();
			}
		}
		dir.delete();
	}

	public static void buildHtml(String target_url, String save_path) throws FileNotFoundException, IOException {
		try {
			URL openurl = new URL(target_url);
			URLConnection urlConn = openurl.openConnection();
			urlConn.setConnectTimeout(30000);
			urlConn.setReadTimeout(60000);
			urlConn.setDoInput(true);
			urlConn.setDoOutput(false);
			urlConn.setUseCaches(false);
			urlConn.connect();
			InputStream is = urlConn.getInputStream();
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(save_path));
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			is.close();
			os = null;
			is = null;

		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		}
	}

	public static String getFileExt(String name) {
		if (name.lastIndexOf(".") == -1) {
			return "";
		}
		return name.substring(name.lastIndexOf(".") + 1, name.length());
	}

	public static String getFileName(String name) {
		if (name.lastIndexOf(".") == -1) {
			return "";
		}
		return name.substring(0, name.lastIndexOf("."));

	}

	/**
	 * 读取文件得到注数
	 * 
	 */
	public static int getFileCount(String filePath) throws Exception {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			int count = 0;
			while (full2HalfChange(in.readLine()) != null) {
				count++;
			}
			return count;
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (in != null)
				in.close();
		}

	}

	public static String getRandomFileName() {
		java.util.Date dt = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = fmt.format(dt);
		fileName = fileName + ".txt"; // extension, you can change it.
		return fileName;
	}

	public static Document getDocument(String filePath) {
		String fileContent;
		Reader in = null;
		try {
			fileContent = getFileContent(filePath);
			SAXBuilder builder = new SAXBuilder();
			in = new StringReader(fileContent);
			Document doc = builder.build(in);
			return doc;
		} catch (FileNotFoundException fnfe) {
			return null;
		} catch (IOException ioe) {
			return null;
		} catch (Exception e) {
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
		}
	}
	
	public static Document getDocument(String filePath,String charset) {
		String fileContent;
		Reader in = null;
		try {
			fileContent = getFileContent(filePath);
			fileContent = new String (fileContent.getBytes(),charset);
			SAXBuilder builder = new SAXBuilder();
			in = new StringReader(fileContent);
			Document doc = builder.build(in);
			return doc;
		} catch (FileNotFoundException fnfe) {
			return null;
		} catch (IOException ioe) {
			return null;
		} catch (Exception e) {
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
		}
	}
	
	//创建document再返回
	public static Document getXMLDocument() {
		Reader reader = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			reader = new StringReader("<?xml version=\"1.0\" encoding=\"GBK\" ?><xml></xml>");
			return sb.build(reader);
		} catch (Exception e) {
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
		}
	}
	
	//根据document和filePath保存文件
	public static void saveXMLFile(Document doc,String filePath) {
		FileWriter fw = null;
		Long startTime = System.currentTimeMillis();
		try {
			XMLOutputter xo = new XMLOutputter();
			Format format = xo.getFormat();
			format.setEncoding("GBK");
			format.setLineSeparator("");
			xo.setFormat(format);
			
			fw = new FileWriter(filePath);
			xo.output(doc, fw);
			try{
				Long endTime1 = System.currentTimeMillis();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
			try{
				Long endTime2 = System.currentTimeMillis();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 按行读取文件,以List保存每一行内容,返回List
	 * @param path 文件路径
	 * @return 返回每一行内容的list
	 */
	public static List<String> readFileByLine(String path){
		File file=new File(path);
        List<String> lineList = new ArrayList<String>();
        if(!file.exists()){
        	return null;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
            	lineList.add(line);
                line = br.readLine();
            }
            br.close();
            return lineList;
        } catch (IOException e) {
            LogUtil.error(e);
            return null;
        }
	}
	/***
	 * 全角转换成半角
	 * @param str
	 * @return
	 */
	public static final String full2HalfChange(String str)  {
		return BCConvert.qj2bj(str);
	}
	
	private static String MESSAGE = ""; 
	
	public static boolean copyFile(String srcFileName, String destFileName,  
            boolean overlay) {  
        File srcFile = new File(srcFileName);  
  
        // 判断源文件是否存在  
        if (!srcFile.exists()) {  
            MESSAGE = "源文件：" + srcFileName + "不存在！";   
            return false;  
        } else if (!srcFile.isFile()) {  
            MESSAGE = "复制文件失败，源文件：" + srcFileName + "不是一个文件！";  
            return false;  
        }  
  
        // 判断目标文件是否存在  
        File destFile = new File(destFileName);  
        if (destFile.exists()) {  
            // 如果目标文件存在并允许覆盖  
            if (overlay) {  
                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件  
                new File(destFileName).delete();  
            }  
        } else {  
            // 如果目标文件所在目录不存在，则创建目录  
            if (!destFile.getParentFile().exists()) {  
                // 目标文件所在目录不存在  
                if (!destFile.getParentFile().mkdirs()) {  
                    // 复制文件失败：创建目标文件所在目录失败  
                    return false;  
                }  
            }  
        }  
  
        // 复制文件  
        int byteread = 0; // 读取的字节数  
        InputStream in = null;  
        OutputStream out = null;  
  
        try {  
            in = new FileInputStream(srcFile);  
            out = new FileOutputStream(destFile);  
            byte[] buffer = new byte[1024];  
  
            while ((byteread = in.read(buffer)) != -1) {  
                out.write(buffer, 0, byteread);  
            }  
            return true;  
        } catch (FileNotFoundException e) {  
            return false;  
        } catch (IOException e) {  
            return false;  
        } finally {  
            try {  
                if (out != null)  
                    out.close();  
                if (in != null)  
                    in.close();  
            } catch (IOException e) {  
                LogUtil.error(e);  
            }  
        }  
    }  
  
    /** 
     * 复制整个目录的内容 
     *  
     * @param srcDirName 
     *            待复制目录的目录名 
     * @param destDirName 
     *            目标目录名 
     * @param overlay 
     *            如果目标目录存在，是否覆盖 
     * @return 如果复制成功返回true，否则返回false 
     */  
    public static boolean copyDirectory(String srcDirName, String destDirName,  
            boolean overlay) {  
    	LogUtil.info("复制目录 " + srcDirName + "->" + destDirName);
        // 判断源目录是否存在  
        File srcDir = new File(srcDirName);  
        if (!srcDir.exists()) {  
            MESSAGE = "复制目录失败：源目录" + srcDirName + "不存在！";  
            return false;  
        } else if (!srcDir.isDirectory()) {  
            MESSAGE = "复制目录失败：" + srcDirName + "不是目录！";  
            return false;  
        }
  
        // 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        File destDir = new File(destDirName);  
        // 如果目标文件夹存在  
        if (destDir.exists()) {  
            // 如果允许覆盖则删除已存在的目标目录  
            if (overlay) {  
                new File(destDirName).delete();  
            } else {  
                MESSAGE = "复制目录失败：目的目录" + destDirName + "已存在！";  
                return false;  
            }  
        } else {  
            // 创建目的目录  
            if (!destDir.mkdirs()) {
            	LogUtil.warn("复制目录失败：创建目的目录失败！");  
                return false;  
            }
        }
  
        boolean flag = true;  
        File[] files = srcDir.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            // 复制文件  
            if (files[i].isFile()) {  
                flag = copyFile(files[i].getAbsolutePath(),  
                        destDirName + files[i].getName(), overlay);  
                if (!flag)  
                    break;  
            } else if (files[i].isDirectory()) {  
                flag = copyDirectory(files[i].getAbsolutePath(),  
                        destDirName + files[i].getName(), overlay);  
                if (!flag)  
                    break;  
            }
        }
        if (!flag) {
            MESSAGE = "复制目录" + srcDirName + "至" + destDirName + "失败！";  
            return false;  
        } else {
            return true;  
        }
    }  
    
    /**
     * 随机返回指定路径下的一个图片文件
     * @param path
     * @return 正常返回一个文件，如果目录为空或者随机的不是一个文件则返回null
     */
    public static File randomImageFile(String path) {
    	File srcDir = new File(path);  
        if (!srcDir.exists() || !srcDir.isDirectory()) {  
        	return null;
        }
        File[] files = srcDir.listFiles(new ImageFilter());
        int fileSize = files.length;
        int random = RandomUtil.getRandom(fileSize,0);
        for (int i = 0; i < fileSize; i++) {  
        	if (files[i].isFile()) {  
        		return files[random];
        	} else {
        		continue;
        	}
        }
        return null;
    }
    
    public static void writeObjectToFile(Object obj, String filePath) throws Exception {
    	File file = new File(filePath);
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;
        
        try {
            out = new FileOutputStream(file);
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
        } finally {
        	if (out != null) {
        		out.close();
        	}
        	
        	if (objOut != null) {
        		objOut.close();
        	}
        }
    }
    
    public static Object readObjectFromFile(String filePath) throws Exception {
        Object obj = null;
        File file = new File(filePath);
        FileInputStream in = null;
        ObjectInputStream objIn = null;
        
        try {
            in = new FileInputStream(file);
            objIn = new ObjectInputStream(in);
            obj = objIn.readObject();
        } finally {
        	if (in != null) {
        		in.close();
        	}
        	
        	if (objIn != null) {
        		objIn.close();
        	}
        }
        
        return obj;
    }
    
    /**
     * 根据遗漏xml文件获取指定元素下的集合转成List<Element>
     * @param itemName 可以为空
     * @return 正常返回一个List<Element>，如果文件为空返回null
     */
    @SuppressWarnings("unchecked")
    public static List<Element> readMissFileToList(String filePath,String itemName) {
    	Document document = getDocument(filePath);
    	if(document == null) {
    		return null;
    	}
    	Element root = document.getRootElement();
    	if(StringTools.isNullOrBlank(itemName)) {
    		return root.getChildren();
    	}
    	List<Element> itemList = root.getChildren(itemName);
		Element item = (Element) itemList.get(0);
		List<Element> subItemList = item.getChildren();
		return subItemList;
    }
    
	/**
	 * 获得指定目录下的所有文件夹名，并按文件名从大到小排序
	 * @param dirPath
	 * @return
	 */
	public static List<String> getAllDirectoryName(String dirPath) {
		File root = new File(dirPath);
		File[] files = root.listFiles();
		List<String> dirNameList = new ArrayList<String>();
		if(files != null && files.length > 0){
			for (File file : files) {
				if (file.isDirectory()) {
					dirNameList.add(file.getName());
				}
			}
			Collections.sort(dirNameList,new Comparator<Object>(){
				public int compare(Object o1, Object o2) {
					return Integer.valueOf(o2.toString())-Integer.valueOf(o1.toString());
				}
			});
		}
		return dirNameList;
	}
}
/** 
 * <PRE> 
 * 提供对字符串的全角-&gt;半角，半角-&gt;全角转换 
 * </PRE> 
 */  
 class BCConvert {  
    /** 
     * ASCII表中可见字符从!开始，偏移位值为33(Decimal) 
     */  
    static final char DBC_CHAR_START = 33; // 半角!  
  
    /** 
     * ASCII表中可见字符到~结束，偏移位值为126(Decimal) 
     */  
    static final char DBC_CHAR_END = 126; // 半角~  
  
    /** 
     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281 
     */  
    static final char SBC_CHAR_START = 65281; // 全角！  
  
    /** 
     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374 
     */  
    static final char SBC_CHAR_END = 65374; // 全角～  
  
    /** 
     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移 
     */  
    static final int CONVERT_STEP = 65248; // 全角半角转换间隔  
  
    /** 
     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理 
     */  
    static final char SBC_SPACE = 12288; // 全角空格 12288  
  
    /** 
     * 半角空格的值，在ASCII中为32(Decimal) 
     */  
    static final char DBC_SPACE = ' '; // 半角空格  
  
    /** 
     * <PRE> 
     * 半角字符->全角字符转换   
     * 只处理空格，!到&tilde;之间的字符，忽略其他 
     * </PRE> 
     */  
    public static String bj2qj(String src) {  
        if (src == null) {  
            return src;  
        }  
        StringBuilder buf = new StringBuilder(src.length());  
        char[] ca = src.toCharArray();  
        for (int i = 0; i < ca.length; i++) {  
            if (ca[i] == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代  
                buf.append(SBC_SPACE);  
            } else if ((ca[i] >= DBC_CHAR_START) && (ca[i] <= DBC_CHAR_END)) { // 字符是!到~之间的可见字符  
                buf.append((char) (ca[i] + CONVERT_STEP));  
            } else { // 不对空格以及ascii表中其他可见字符之外的字符做任何处理  
                buf.append(ca[i]);  
            }  
        }  
        return buf.toString();  
    }  
  
    /** 
     * <PRE> 
     * 全角字符->半角字符转换   
     * 只处理全角的空格，全角！到全角～之间的字符，忽略其他 
     * </PRE> 
     */  
    public static String qj2bj(String src) {  
        if (src == null) {  
            return src;  
        }  
        StringBuilder buf = new StringBuilder(src.length());  
        char[] ca = src.toCharArray();  
        for (int i = 0; i < src.length(); i++) {  
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内  
                buf.append((char) (ca[i] - CONVERT_STEP));  
            } else if (ca[i] == SBC_SPACE) { // 如果是全角空格  
                buf.append(DBC_SPACE);  
            } else { // 不处理全角空格，全角！到全角～区间外的字符  
                buf.append(ca[i]);  
            }  
        }  
        return buf.toString();  
    }  
}  
