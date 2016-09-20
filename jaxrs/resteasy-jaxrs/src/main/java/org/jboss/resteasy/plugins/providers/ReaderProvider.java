package org.jboss.resteasy.plugins.providers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.plugins.i18n.*;

import org.jboss.resteasy.util.HttpHeaderNames;

import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;

/**
 * @author <a href="mailto:bill@burkecentral.com">BillBurke</a>
 * @version $Revision: 1 $
 */
@Provider
@Produces("*/*")
@Consumes("*/*")
public class ReaderProvider implements MessageBodyReader<Reader>, MessageBodyWriter<Reader>
{
   @LogMessage(level = Level.DEBUG)
   @Message(value = "Call of provider : org.jboss.resteasy.plugins.providers.ReaderProvider , method call : isReadable .")
   public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
   {
      return type.equals(Reader.class);
   }

   @LogMessage(level = Level.DEBUG)
   @Message(value = "Call of provider : org.jboss.resteasy.plugins.providers.ReaderProvider , method call : readFrom .")
   public Reader readFrom(Class<Reader> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException
   {
      String charset = mediaType.getParameters().get("charset");
      if (charset == null) return new InputStreamReader(entityStream);
      else return new InputStreamReader(entityStream, charset);
   }

   @LogMessage(level = Level.DEBUG)
   @Message(value = "Call of provider : org.jboss.resteasy.plugins.providers.ReaderProvider , method call : isWriteable .")
   public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
   {
      return Reader.class.isAssignableFrom(type);
   }

   @LogMessage(level = Level.DEBUG)
   @Message(value = "Call of provider : org.jboss.resteasy.plugins.providers.ReaderProvider , method call : getSize .")
   public long getSize(Reader inputStream, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
   {
      return -1;
   }

   @LogMessage(level = Level.DEBUG)
   @Message(value = "Call of provider : org.jboss.resteasy.plugins.providers.ReaderProvider , method call : writeTo .")
   public void writeTo(Reader inputStream, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException
   {
	   try
	   {
		   int c = inputStream.read();
		   if (c == -1)
		   {
			   httpHeaders.putSingle(HttpHeaderNames.CONTENT_LENGTH, Integer.toString(0));
			   entityStream.write(new byte[0]); // fix RESTEASY-204
			   return;
		   }
		   else
			   entityStream.write(c);
		   while ((c = inputStream.read()) != -1)
		   {
			   entityStream.write(c);
		   }
	   }
	   finally
	   {
		   try
		   {
			   inputStream.close();
		   }
		   catch (IOException e)
		   {
			   // Drop the exception so we don't mask real IO errors
		   }
	   }
   }
}
