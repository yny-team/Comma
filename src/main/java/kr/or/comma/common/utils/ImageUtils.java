package kr.or.comma.common.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.comma.common.vo.ImageOrFileVO;

public class ImageUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);

	
	public static String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
			
		return str.replace("-", File.separator);
	
	}
	
	public static boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void makeFolder(File uploadPath) {
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
	}
	
	public static String getUuid() {
		
		return UUID.randomUUID().toString();
	}

	public static void removeFiles(List<ImageOrFileVO> fileList, String deletePath) {

		logger.info("delete FileList : {}", fileList);
		
		String uploadFullPath  = 
				"C:\\Users\\330-15\\git\\comma\\src\\main\\webapp\\resources\\upload\\" 
				 + deletePath + "\\";

		
//		String uploadFullPath = "/scthrdi/tomcat/webapps/ROOT/resources/upload" 
//									+ deletePath + "/";
		
		
		if(fileList == null || fileList.size() <= 0) {
			return;
		}
		
		fileList.forEach(deleteFile -> {
			try {
				
//				Path file = Paths.get(uploadFullPath + deleteFile.getUploadPath() + "/" + 
//						deleteFile.getUuid() + "_" + deleteFile.getFileName());
				Path file = Paths.get(uploadFullPath + deleteFile.getUploadPath() + "\\" + 
						deleteFile.getUuid() + "_" + deleteFile.getFileName());
				
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get(uploadFullPath + deleteFile.getUploadPath() + "\\s_" + 
							deleteFile.getUuid() + "_" + deleteFile.getFileName());					
//					Path thumbNail = Paths.get(uploadFullPath + deleteFile.getUploadPath() + "/s_" + 
//							deleteFile.getUuid() + "_" + deleteFile.getFileName());
					
					Files.delete(thumbNail);
				}
				
			} catch (Exception e) {
				logger.error("delete file error : " + e.getMessage());
			}// end catch
		});// end foreach
	}

	
}
