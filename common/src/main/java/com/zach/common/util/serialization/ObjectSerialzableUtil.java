package com.zach.common.util.serialization;

//transient关键字可以不进行序列化private transient Integer infoId;
public class ObjectSerialzableUtil {
//	//序列化
//	public static void ObjectSerialzable(String className,Object obj,HttpServletRequest request){
//		String fileName=className+".dat";
//		String uploadPath = request.getSession().getServletContext().getRealPath("/cache/");
//		File file = new File(uploadPath);
//		if(!file.isDirectory()){
//			file.mkdirs();
//		}
//		ObjectOutputStream oos;
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream(uploadPath+"/"+fileName));
//			oos.writeObject(obj);
//			oos.flush();
//			oos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	//反序列化
//	public static Object ObjectReSerialzable(String className,HttpServletRequest request){
//		String fileName=className+".dat";
//		String uploadPath = request.getSession().getServletContext().getRealPath("/cache/"+fileName);
//		File file = new File(uploadPath);
//		if(!file.isFile()){
//			return null;
//		}
//		ObjectInputStream ois;
//		try {
//			ois = new ObjectInputStream(new FileInputStream(file));
//			Object obj = ois.readObject();
//			ois.close();
//			return obj;
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	//反序列化
//	public static Object ObjectReSerialzable(String className, String filePath){
//		String fileName=className+".dat";
//		String uploadPath = filePath;
//		File file = new File(uploadPath);
//		if(!file.isFile()){
//			return null;
//		}
//		ObjectInputStream ois;
//		try {
//			ois = new ObjectInputStream(new FileInputStream(file));
//			Object obj = ois.readObject();
//			ois.close();
//			return obj;
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//    /**
//     * 删除目录（文件夹）以及目录下的文件
//     * @param   sPath 被删除目录的文件路径
//     * @return  目录删除成功返回true，否则返回false
//     */
//    public static boolean deleteDirectory(String sPath) {
//        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
//        if (!sPath.endsWith(File.separator)) {
//            sPath = sPath + File.separator;
//        }
//        File dirFile = new File(sPath);
//        //如果dir对应的文件不存在，或者不是一个目录，则退出
//        if (!dirFile.exists() || !dirFile.isDirectory()) {
//            return false;
//        }
//        boolean flag = true;
//        //删除文件夹下的所有文件(包括子目录)
//        File[] files = dirFile.listFiles();
//        for (int i = 0; i < files.length; i++) {
//            //删除子文件
//            if (files[i].isFile()) {
//                flag = deleteFile(files[i].getAbsolutePath());
//                if (!flag) break;
//            } //删除子目录
//            else {
//                flag = deleteDirectory(files[i].getAbsolutePath());
//                if (!flag) break;
//            }
//        }
//        if (!flag) return false;
//        //删除当前目录
//        if (dirFile.delete()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * 删除单个文件
//     * @param   sPath    被删除文件的文件名
//     * @return 单个文件删除成功返回true，否则返回false
//     */
//    public static boolean deleteFile(String sPath) {
//        boolean flag = false;
//        File file = new File(sPath);
//        // 路径为文件且不为空则进行删除
//        if (file.isFile() && file.exists()) {
//            file.delete();
//            flag = true;
//        }
//        return flag;
//    }
    
}