package com.acme.filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class FilterServletOutputStream extends ServletOutputStream {

	FileOutputStream fos;
	public FilterServletOutputStream(){
		try {
			fos = new FileOutputStream(new File("/home/maijunjin/mycode/jekyll/test2"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void write(int b) throws IOException {
		fos.write(b);
	}

	@Override
	public void write(byte b[]) throws IOException {
		fos.write(b);
	}

	@Override
	public void write(byte buf[], int offset, int len) throws IOException {
		fos.write(buf, offset, len);
	}

	@Override
	public void flush() throws IOException {
		fos.flush();
	}

	@Override
	public void close() throws IOException {
		fos.close();
	}
}
