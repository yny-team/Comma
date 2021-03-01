package kr.or.comma.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.comma.common.utils.ImageUtils;
import kr.or.comma.common.vo.ImageOrFileVO;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/file/")
public class CommonFileController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonFileController.class);

	private String uploadRealPath = 
			"C:\\Users\\330-15\\git\\comma\\src\\main\\webapp\\resources\\upload\\";
	
	@PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<ImageOrFileVO> uploadPost(MultipartFile uploadFile, String folder) {
		
		log.info("file upload  post : {}", uploadFile);
		log.info("Upload File Name : " + uploadFile.getOriginalFilename());
		log.info("Upload File Size : " + uploadFile.getSize());
		
		String uploadFolder = uploadRealPath + folder;
		String uploadFolderPath = ImageUtils.getFolder();
		
		// make folder
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("upload path : " + uploadRealPath);
			
		// make yyyy/mm/dd folder
		ImageUtils.makeFolder(uploadPath);
		
		ImageOrFileVO imageOrFileVO = new ImageOrFileVO();
		
		String uploadFileName = uploadFile.getOriginalFilename();
		
		uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
		
		log.info("real file name : " + uploadFileName);
		imageOrFileVO.setFileName(uploadFileName); // AttachDTO setFileName
		
		// 중복 방지를 위한 UUID 적용
		String uuid = ImageUtils.getUuid();
		uploadFileName = uuid + "_" + uploadFileName;
			
		try {
			File saveFile = new File(uploadPath, uploadFileName);
			log.info("savaFile 경로 : " + saveFile);
			uploadFile.transferTo(saveFile);
			
			imageOrFileVO.setUuid(uuid);
			imageOrFileVO.setUploadPath(uploadFolderPath);
			
			if(ImageUtils.checkImageType(saveFile)) { // if image
				
				imageOrFileVO.setFileType(true);
				int width = 360;
				int height = 360;
				
				if(folder.equals("my")) {
					width = 80;
					height = 80;
				} 
				
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
				Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumbnail, width, height);
				thumbnail.close();
			}
		
			} catch (Exception e) {
				log.error(e.getMessage());
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} // end catch
			
//		} // end for
		return new ResponseEntity<>(imageOrFileVO, HttpStatus.OK);
		
	}
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName, String folder){
		
		log.info("request ==> /display");
		log.info("fileName : " + fileName);
		
		String displayFolder = uploadRealPath + folder + "\\";
//		String displayFolder = uploadRealPath + folder + "/";
		File file = new File(displayFolder + fileName);
		
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type, String folder){
		
		log.info("deleteFile  ==> [fileName : {}/{}]", folder, fileName);
		
		String deleteFolder = uploadRealPath + folder + "\\";
//		String deleteFolder = uploadRealPath + folder + "/";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

		File file;
		
		try {
			
			file = new File(deleteFolder + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			if(type.equals("image")) {
				
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				
				log.info("largeFileName : " + largeFileName);
				
				file = new File(largeFileName);
				
				file.delete();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("첨부파일 삭제가 실패했습니다. 다시 한 번 시도해주세요. ", responseHeaders ,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<String>("첨부파일이 정상적으로 삭제되었습니다.", responseHeaders, HttpStatus.OK);
	}
}
