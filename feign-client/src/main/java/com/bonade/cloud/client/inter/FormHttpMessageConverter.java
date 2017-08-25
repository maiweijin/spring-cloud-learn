package com.bonade.cloud.client.inter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class FormHttpMessageConverter implements HttpMessageConverter<Object> {

	Map<Class<?>, List<Method>> writePropertiesCache = new HashMap<>();

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return false;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (!MediaType.APPLICATION_FORM_URLENCODED.equals(mediaType)) {
			return false;
		}
		Method[] methods = clazz.getMethods();
		List<Method> collect = Arrays.asList(methods).stream().filter((method) -> {
			if ("getClass".equals(method.getName())) {
				return false;
			}
			if (method.getName().startsWith("get")) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		if (collect.size() == 0) {
			return false;
		}
		writePropertiesCache.put(clazz, collect);
		return true;
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED);
	}

	@Override
	public Object read(Class<?> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	public void write(Object t, MediaType contentType, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		StringBuilder body = new StringBuilder();
		Class<? extends Object> clazz = t.getClass();
		List<Method> list = writePropertiesCache.get(clazz);
		for (Method method : list) {
			try {
				String value = method.invoke(t).toString();
				String name = method.getName();
				String substring = name.substring(4);
				Character c = Character.toLowerCase(name.charAt(3));
				String key = c + substring;
				body.append(key).append('=').append(value).append('&');
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		Writer writer = new OutputStreamWriter(outputMessage.getBody());
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(body.toString().substring(0, body.length() - 1));
		bw.flush();
		bw.close();
	}

}
