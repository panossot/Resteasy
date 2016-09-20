package org.jboss.resteasy.plugins.providers.jaxb.json;

import org.jboss.resteasy.plugins.providers.jaxb.JAXBElementProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@Provider
@Produces("application/*+json")
@Consumes("application/*+json")
public class JettisonElementProvider extends JAXBElementProvider
{
   @Override
   @LogMessage(level = Level.DEBUG)
   @Message(value = "Call of provider : org.jboss.resteasy.plugins.providers.jaxb.json.JettisonElementProvider , method call : needsSecurity .")
   protected boolean needsSecurity()
   {
      return false;
   }
}
