package com.impetus.serviceplatform.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.impetus.process.exception.ServicePlatformException;
import com.impetus.process.utils.ZipDirectory;

/**
 * @author amitb.kumar
 */
@Controller
@PropertySource("classpath:config.properties")
public class DownloadController
{

  /**
	 * 
	 */
  @Autowired
  private Environment env;

  /**
   * @param tenantId
   * @param response
   * @throws Exception
   */
  @RequestMapping(value = "/DownloadTemplate/download/{tenantId}", method = RequestMethod.GET)
  public void loginUser(@PathVariable
  String tenantId, HttpServletResponse response) throws ServicePlatformException
  {

    String filestore = env.getProperty("sp.filestore.path");
    String tempFolder = env.getProperty("sp.temp.path");

    String teamplate_loc = getTemplateLocation(tenantId);
    String source_folder = filestore + teamplate_loc;
    String downloadLink = tempFolder + teamplate_loc + ".zip";

    ZipDirectory.zipDir(source_folder, downloadLink);

    processDownload(response, downloadLink);

  }

  /**
   * @param response
   * @param downloadLink
   * @throws FileNotFoundException
   * @throws IOException
   */
  private void processDownload(HttpServletResponse response, String downloadLink)
    throws ServicePlatformException
 {
		try 
		{
			File downloadFile = new File(downloadLink);
			FileInputStream inputStream = new FileInputStream(downloadFile);
			// set content attributes for the response
			response.setContentType("application/octet-stream");
			response.setContentLength((int) downloadFile.length());
			// set headers for the response
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					downloadFile.getName());
			response.setHeader(headerKey, headerValue);
			// get output stream of the response
			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			// write bytes read from the input stream into the output stream
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			inputStream.close();
			outStream.close();
		} 
		catch (FileNotFoundException e) 
		{
			throw new ServicePlatformException(e.getMessage());
		} 
		catch (IOException e) 
		{
			throw new ServicePlatformException(e.getMessage());
		}
	}

  /**
   * @param tenantId
   * @return
   */
  private String getTemplateLocation(String tenantId)
  {
    // TODO: use tenantId to find correct template location
    String teamplate_loc = "client_templates\\Template A";
    return teamplate_loc;
  }
}
