package com.profill.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileUploadException;
import org.apache.commons.fileupload2.javax.JavaxServletDiskFileUpload;





public class FileUploadUtil {

	private static String[] ALLOWED = { ".jpg", ".jpeg", ".png", ".gif", ".webp" };

	private FileUploadUtil() {}


	public static String parseAndSave(HttpServletRequest request, Map<String, String> fields,
	                                   String filePartName, String subDir) throws Exception {

		JavaxServletDiskFileUpload upload = new JavaxServletDiskFileUpload();
		upload.setFileSizeMax(5L * 1024 * 1024);
		upload.setSizeMax(10L * 1024 * 1024);

		List<DiskFileItem> items;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			throw new Exception("업로드 용량이 너무 큽니다. 5MB 이하의 이미지만 올릴 수 있습니다.", e);
		}

		String savedFileName = null;

		for (int i = 0; i < items.size(); i++) {
			DiskFileItem item = items.get(i);

			if (item.isFormField()) {
				fields.put(item.getFieldName(), item.getString(StandardCharsets.UTF_8));
			} else if (filePartName.equals(item.getFieldName())) {
				savedFileName = save(item, request, subDir);
			}
		}

		return savedFileName;
	}

	private static String save(DiskFileItem item, HttpServletRequest request, String subDir) throws Exception {

		String origin = item.getName();
		if (origin == null || origin.trim().length() == 0 || item.getSize() == 0) {
			return null;
		}

		String ext = "";
		int dot = origin.lastIndexOf('.');
		if (dot > -1) {
			ext = origin.substring(dot).toLowerCase();
		}

		boolean ok = false;
		for (int i = 0; i < ALLOWED.length; i++) {
			if (ALLOWED[i].equals(ext)) {
				ok = true;
				break;
			}
		}
		if (!ok) {
			throw new Exception("이미지 파일만 올릴 수 있습니다 : " + origin);
		}

		String saveDir = request.getServletContext().getRealPath(subDir);
		Path dir = Paths.get(saveDir);
		if (!Files.exists(dir)) {
			Files.createDirectories(dir);
		}

		String name = System.currentTimeMillis() + ext;
		item.write(dir.resolve(name));

		return name;
	}
}