package org.biins.commons.feign;

import static javax.ws.rs.core.Response.status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import feign.Response;
import feign.codec.ErrorDecoder;

public class JaxRsErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		Status status = Status.fromStatusCode(response.status());
		switch (status.getFamily()) {
			case INFORMATIONAL:
			case SUCCESSFUL:
			case REDIRECTION:
				throw new IllegalStateException("Not in exceptional state");
			case CLIENT_ERROR:
				return handleClientError(status, response);
			case SERVER_ERROR:
				return handleServerError(status, response);
			case OTHER:
			default:
				return handleOther(status, response);
		}
	}

	private static Exception handleClientError(Status status, Response response) {
		switch (status) {
			case BAD_REQUEST:
				return new BadRequestException(message(response), status(status).build());
			case FORBIDDEN:
				return new ForbiddenException(message(response), status(status).build());
			case NOT_ACCEPTABLE:
				return new NotAcceptableException(message(response), status(status).build());
			case NOT_FOUND:
				return new NotFoundException(message(response), status(status).build());
			case PRECONDITION_FAILED:
			default:
				return new ClientErrorException(message(response), status);
		}
	}

	private static Exception handleServerError(Status status, Response response) {
		switch (status) {
			case SERVICE_UNAVAILABLE:
				return new ServiceUnavailableException(message(response), status(status).build());
			case INTERNAL_SERVER_ERROR:
				return new InternalServerErrorException(message(response), status(status).build());
			default:
				return new ServerErrorException(message(response), status);
		}
	}

	private static Exception handleOther(Status status, Response response) {
		return new WebApplicationException(message(response), status);
	}

	private static String message(Response response) {
		return String.format("{reason: '%s', status: '%s', body: %s}",
				response.reason(), response.status(), read(response.body()));
	}


	private static String read(Response.Body body) {
		try {
			try (BufferedReader buffer = new BufferedReader(new InputStreamReader(body.asInputStream()))) {
				return buffer.lines().collect(Collectors.joining("\n"));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
