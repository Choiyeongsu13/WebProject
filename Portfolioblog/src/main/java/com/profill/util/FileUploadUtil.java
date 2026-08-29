package com.profill.util;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/** 글쓰기/글수정 화면에서 올린 이미지를 서버 폴더에 저장한다. */
public class FileUploadUtil {

	private static String[] ALLOWED = { ".jpg", ".jpeg", ".png", ".gif", ".webp" };

	private FileUploadUtil() {}

	public static String saveImage(HttpServletRequest request, String partName, String subDir) throws Exception {

		Part part = request.getPart(partName);
		if (part == null || part.getSize() == 0) {
			return null;
		}

		String origin = part.getSubmittedFileName();
		if (origin == null || origin.trim().length() == 0) {
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
		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String name = System.currentTimeMillis() + ext;

		InputStream in = null;
		try {
			in = part.getInputStream();
			Files.copy(in, new File(dir, name).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return name;
	}
}
