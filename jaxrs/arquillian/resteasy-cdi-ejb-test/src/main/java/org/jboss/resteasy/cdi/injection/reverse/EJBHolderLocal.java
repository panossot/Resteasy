/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.jboss.resteasy.cdi.injection.reverse;

import javax.ejb.Local;

/**
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 *
 * Copyright May 30, 2012
 */
@Local
public interface EJBHolderLocal
{
   public boolean testScopes();
   public void setup();
   public boolean test();
  
   public void sleSetup();
   public boolean sleTest();
   
   public void sfdeSetup();
   public boolean sfdeTest();
   
   public void sfreSetup();
   public boolean sfreTest();
   
   public void sfaeSetup();
   public boolean sfaeTest(); 
   
   public void sliSetup();
   public boolean sliTest();
   
   public void sfdiSetup();
   public boolean sfdiTest();
   
   public void sfriSetup();;
   public boolean sfriTest();
   
   public void sfaiSetup();
   public boolean sfaiTest();
   
   public boolean theSame(EJBHolderLocal that);
   public int theSecret();
}

