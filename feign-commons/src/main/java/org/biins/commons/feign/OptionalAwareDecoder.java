package org.biins.commons.feign;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

import feign.Response;
import feign.codec.Decoder;

public class OptionalAwareDecoder implements Decoder {

	private static final int SC_NOT_FOUND = 404;

	private final Decoder delegate;

	public OptionalAwareDecoder(Decoder delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object decode(Response response, Type type) throws IOException {
		if (type instanceof ParameterizedType
				&& ((ParameterizedType)type).getRawType().equals(Optional.class)) {
			return handleOptional(response, type);
		}

		return delegate.decode(response, type);
	}

	private Optional handleOptional(Response response, Type type) throws IOException {
		if (response.status() == SC_NOT_FOUND) {
			return Optional.empty();
		} else {
			return Optional.of(delegate.decode(response, ((ParameterizedType)type).getActualTypeArguments()[0]));
		}
	}

}
