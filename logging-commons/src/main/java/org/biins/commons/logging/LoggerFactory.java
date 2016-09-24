package org.biins.commons.logging;

public class LoggerFactory {

	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	public static Logger getLogger(String name) {
		return new Logger(org.slf4j.LoggerFactory.getLogger(name));
	}

}
