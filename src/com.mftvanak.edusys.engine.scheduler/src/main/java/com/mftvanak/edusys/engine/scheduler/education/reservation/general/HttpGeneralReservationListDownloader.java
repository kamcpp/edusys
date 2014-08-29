package com.mftvanak.edusys.engine.scheduler.education.reservation.general;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.mftvanak.edusys.engine.scheduler.education.Downloader;


public class HttpGeneralReservationListDownloader implements Downloader {

  private String url;

  public HttpGeneralReservationListDownloader () {
  }

  public HttpGeneralReservationListDownloader (String url) {
    setUrl (url);
  }

  public String getUrl () {
    return url;
  }

  public void setUrl (String url) {
    this.url = url;
  }

  @Override
  public String download () {
    try {
      URL url = new URL (this.url);
      URLConnection con = url.openConnection ();
      InputStream in = con.getInputStream ();
      String encoding = con.getContentEncoding ();
      encoding = encoding == null ? "UTF-8" : encoding;
      String body = IOUtils.toString (in, encoding);
      body = body.replace ('&', '-');
      return body;
    } catch (MalformedURLException e) {
      e.printStackTrace ();
      return null;
    } catch (IOException e) {
      e.printStackTrace ();
      return null;
    }
  }
}
