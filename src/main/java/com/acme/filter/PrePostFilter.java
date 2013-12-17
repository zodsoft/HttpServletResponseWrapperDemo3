package com.acme.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class PrePostFilter implements javax.servlet.Filter {

	public void doFilter(final ServletRequest request,
			final ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		OutputStream out = response.getOutputStream();
		out.write("<HR>PRE<HR>".getBytes());
		GenericResponseWrapper wrapper = new GenericResponseWrapper(
				(HttpServletResponse) response);
		chain.doFilter(request, wrapper);
		wrapper.getWriter().flush();
		//test2 is empty,so HttpServletResponseWrapper's getOutputStream never used
		FileInputStream fis = new FileInputStream(new File("/home/maijunjin/mycode/jekyll/test"));
		byte[] b = new byte[fis.available()];
		fis.read(b);
		fis.close();
		out.write(b);
		out.write("<HR>POST<HR>".getBytes());
		out.close();
	}

	public void destroy() {

	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}