package sjagxhiu.DbConn.services;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver 
implements ContextResolver<ObjectMapper> {
	
	private ObjectMapper objectMapper;

    public JacksonContextResolver() throws Exception {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setAnnotationIntrospector(
        		new JacksonAnnotationIntrospector());
    }

    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
	

}
