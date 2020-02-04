package org.amdatu.tutorial.todo.app;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.amdatu.web.rest.jaxrs.AmdatuWebRestConstants;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.osgi.framework.Constants;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component(provides = Application.class)
@Property(name = Constants.SERVICE_RANKING, intValue = -1)
@Property(name = HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN, value = "/*")
@Property(name = HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PREFIX, value = "/web")
@Property(name = HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, value = TodoApp.CONTEXT_SELECT)

@Property(name = JaxrsWhiteboardConstants.JAX_RS_NAME, value = TodoApp.JAX_RS_APPLICATION_NAME)
@Property(name = JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE, value = "/rest")
@Property(name = AmdatuWebRestConstants.JAX_RS_APPLICATION_CONTEXT, value = TodoApp.CONTEXT_NAME)
public class TodoApp extends Application {

    public static final String JAX_RS_APPLICATION_NAME = "org.amdatu.tutorial.todo.app";

    public static final String CONTEXT_NAME = "org.amdatu.tutorial.todo.app";

    public static final String CONTEXT_SELECT =
                    "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=" + CONTEXT_NAME + ")";

    private Set<Object> singletons;

    public TodoApp() {
        singletons = Collections.singleton(new JacksonJsonProvider());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
