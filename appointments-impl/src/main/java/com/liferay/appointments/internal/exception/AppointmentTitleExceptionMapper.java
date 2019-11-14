/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.appointments.internal.exception;

/**
 * @author Víctor Galán
 */

import com.liferay.journal.exception.ArticleTitleException;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Converts any {@code ArticleTitleException} to a {@code 400} error.
 *
 * @author Víctor Galán
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Appointments)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Appointments.AppointmentTitleExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class AppointmentTitleExceptionMapper
	implements ExceptionMapper<ArticleTitleException> {

	@Override
	public Response toResponse(ArticleTitleException articleTitleException) {
		return Response.status(
			400
		).entity(
			"Appointment title is mandatory"
		).type(
			MediaType.TEXT_PLAIN
		).build();
	}

}
