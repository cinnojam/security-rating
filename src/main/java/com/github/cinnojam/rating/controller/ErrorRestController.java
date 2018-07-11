package com.github.cinnojam.rating.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("error")
public class ErrorRestController implements ErrorController {
	
	@RequestMapping(value = "/")
	public @ResponseBody String handleDefault(HttpEntity<String> httpEntity, HttpServletRequest req) {
		return handleError(httpEntity, req);
	}
	
	@RequestMapping(value = "/error")
	public @ResponseBody String handleError(HttpEntity<String> httpEntity, HttpServletRequest req) {
		String out = "== Request Information ==\n\n";
		out += "\t- Request URL: " + req.getRequestURL();
		out += "\n\t- Request URI: " + req.getRequestURI();
		out += "\n\t- Query String: " + req.getQueryString();
		out += "\n\t- Remote Host: " + req.getRemoteHost();
		out += "\n\t- Remote Port: " + req.getRemotePort();
		out += "\n\t- Remote Address: " + req.getRemoteAddr() + "\n";
		out += "\t- Local Host: " + req.getLocalName();
		out += "\n\t- Local Port: " + req.getLocalPort();
		out += "\n\t- Local Address: " + req.getLocalAddr() + "\n";
		out += "\t- Context Path: " + req.getContextPath() + "\n";
		Enumeration<String> names = req.getHeaderNames();
		out += getNameValuePairs(req, "Request Headers", names);
		names = req.getParameterNames();
		out += getNameValuePairs(req, "Request Parameters", names);
		names = req.getAttributeNames();
		out += getNameValuePairs(req, "Request Attributes", names);
		return out;
	}

	private String getNameValuePairs(HttpServletRequest req, String header, Enumeration<String> names) {
		String out = "\n\t==== " + header + " ====\n";
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			out += ("\t\t- " + name + ": " + req.getHeader(name) + "\n");
		}
		return out;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
