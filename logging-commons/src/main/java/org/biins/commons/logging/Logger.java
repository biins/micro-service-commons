package org.biins.commons.logging;

import java.util.stream.Stream;

import org.slf4j.Marker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Logger implements org.slf4j.Logger {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	static {
		OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

	private final org.slf4j.Logger logger;
	private boolean json;

	Logger(org.slf4j.Logger logger) {
		this.logger = logger;
		json = false;
	}

	public Logger asJson() {
		this.json = true;
		return this;
	}

	public Logger asJson(boolean json) {
		this.json = json;
		return this;
	}

	@Override
	public String getName() {
		return logger.getName();
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	@Override
	public void trace(String msg) {
		logger.trace(msg);
	}

	@Override
	public void trace(String format, Object arg) {
		logger.trace(format, toJson(arg));
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		logger.trace(format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void trace(String format, Object... arguments) {
		logger.trace(format, toJson(arguments));
	}

	@Override
	public void trace(String msg, Throwable t) {
		logger.trace(msg, t);
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return logger.isTraceEnabled(marker);
	}

	@Override
	public void trace(Marker marker, String msg) {
		logger.trace(marker, msg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		logger.trace(marker, format, toJson(arg));
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		logger.trace(marker, format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		logger.trace(marker, format, toJson(argArray));
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		logger.trace(marker, msg, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public void debug(String msg) {
		logger.debug(msg);
	}

	@Override
	public void debug(String format, Object arg) {
		logger.debug(format, toJson(arg));
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		logger.debug(format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void debug(String format, Object... arguments) {
		logger.debug(format, toJson(arguments));
	}

	@Override
	public void debug(String msg, Throwable t) {
		logger.debug(msg, t);
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return logger.isDebugEnabled(marker);
	}

	@Override
	public void debug(Marker marker, String msg) {
		logger.debug(marker, msg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		logger.debug(marker, format, toJson(arg));
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		logger.debug(marker, format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		logger.debug(marker, format, toJson(arguments));
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		logger.debug(marker, msg, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public void info(String msg) {
		logger.info(msg);
	}

	@Override
	public void info(String format, Object arg) {
		logger.info(format, toJson(arg));
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		logger.info(format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void info(String format, Object... arguments) {
		logger.info(format, toJson(arguments));
	}

	@Override
	public void info(String msg, Throwable t) {
		logger.info(msg, t);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return logger.isInfoEnabled(marker);
	}

	@Override
	public void info(Marker marker, String msg) {
		logger.info(marker, msg);
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		logger.info(marker, format, toJson(arg));
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		logger.info(marker, format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		logger.info(marker, format, toJson(arguments));
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		logger.info(marker, msg, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	@Override
	public void warn(String msg) {
		logger.warn(msg);
	}

	@Override
	public void warn(String format, Object arg) {
		logger.warn(format, toJson(arg));
	}

	@Override
	public void warn(String format, Object... arguments) {
		logger.warn(format, toJson(arguments));
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		logger.warn(format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void warn(String msg, Throwable t) {
		logger.warn(msg, t);
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return logger.isWarnEnabled(marker);
	}

	@Override
	public void warn(Marker marker, String msg) {
		logger.warn(marker, msg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		logger.warn(marker, format, toJson(arg));
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		logger.warn(marker, format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		logger.warn(marker, format, toJson(arguments));
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		logger.warn(marker, msg, t);
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	@Override
	public void error(String msg) {
		logger.error(msg);
	}

	@Override
	public void error(String format, Object arg) {
		logger.error(format, toJson(arg));
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		logger.error(format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void error(String format, Object... arguments) {
		logger.error(format, toJson(arguments));
	}

	@Override
	public void error(String msg, Throwable t) {
		logger.error(msg, t);
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return logger.isErrorEnabled(marker);
	}

	@Override
	public void error(Marker marker, String msg) {
		logger.error(marker, msg);
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		logger.error(marker, format, toJson(arg));
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		logger.error(marker, format, toJson(arg1), toJson(arg2));
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		logger.error(marker, format, toJson(arguments));
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		logger.error(marker, msg, t);
	}

	private Object toJson(Object argument) {
		if (!json) {
			return argument;
		} else {
			return new JsonToStringMethodWrapper(argument);
		}
	}

	private Object[] toJson(Object... arguments) {
		return Stream.of(arguments)
				.map(this::toJson)
				.toArray();
	}

	private static class JsonToStringMethodWrapper {

		private final Object target;

		private JsonToStringMethodWrapper(Object target) {
			this.target = target;
		}

		@Override
		public String toString() {
			try {
				return OBJECT_MAPPER.writeValueAsString(target);
			} catch (JsonProcessingException ignore) {
				return target.toString();
			}
		}
	}
}
