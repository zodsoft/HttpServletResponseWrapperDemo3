package com.acme.filter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GenericResponseWrapper extends HttpServletResponseWrapper {
	private PrintWriter pw;
	public FilterServletOutputStream filterOutputStream;
	private int contentLength;
	private String contentType;
	public ByteArrayOutputStream output = new ByteArrayOutputStream();
	public GenericResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	public byte[] getData() {
		return output.toByteArray();
	}
	public ServletOutputStream getOutputStream() throws IOException {
		if (filterOutputStream == null) {
			filterOutputStream = new FilterServletOutputStream();
		}
		return filterOutputStream;
	}

	public PrintWriter getWriter() throws IOException {
		if (pw == null) {
			pw = new PrintWriter(new FileOutputStream(new File("/home/maijunjin/mycode/jekyll/test")));
		}
		return pw;
	}

	public void setContentLength(int length) {
		this.contentLength = length;
		super.setContentLength(length);
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentType(String type) {
		this.contentType = type;
		super.setContentType(type);
	}

	public String getContentType() {
		return contentType;
	}
}
