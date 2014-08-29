package com.mftvanak.edusys.common.messaging.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;

import com.mftvanak.edusys.common.messaging.SmsSender;


public class HttpSmsSender implements SmsSender {

  private String username;
  private String password;
  private String url;
  private String from;

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String getUrl () {
    return url;
  }

  public void setUrl (String url) {
    this.url = url;
  }

  public String getFrom () {
    return from;
  }

  public void setFrom (String from) {
    this.from = from;
  }

  public String send (String to, String body) {
    try {
      String targetUrl = this.url;
      targetUrl += "?username=" + username + "&password=" + password;
      targetUrl += "&to=" + to + "&from=" + from + "&text=" + URLEncoder.encode (body, "UTF-8");
      URL url = new URL (targetUrl);
      URLConnection con = url.openConnection ();
      InputStream in = con.getInputStream ();
      String encoding = con.getContentEncoding ();
      encoding = encoding == null ? "UTF-8" : encoding;
      String response = IOUtils.toString (in, encoding);
      System.out.println ("---> " + response);
      if (response.startsWith ("1-")) {
        return response.substring (2);
      }
      throw new RuntimeException ("Sending sms is failed. Response: '" + response + "'");
    } catch (MalformedURLException e) {
      e.printStackTrace ();
      throw new RuntimeException (e);
    } catch (IOException e) {
      e.printStackTrace ();
      throw new RuntimeException (e);
    }
  }

  public String[] send (String[] tos, String body) {
    String toss = "";
    for (String to : tos) {
      toss += to + ",";
    }
    toss = toss.substring (0, toss.length () - 1);
    try {
      String targetUrl = this.url;
      targetUrl += "?username=" + username + "&password=" + password;
      targetUrl += "&to=" + toss + "&from=" + from + "&text=" + URLEncoder.encode (body, "UTF-8");
      System.out.println (targetUrl);
      URL url = new URL (targetUrl);
      URLConnection con = url.openConnection ();
      InputStream in = con.getInputStream ();
      String encoding = con.getContentEncoding ();
      encoding = encoding == null ? "UTF-8" : encoding;
      String response = IOUtils.toString (in, encoding);
      System.out.println ("---> " + response);
      if (response.startsWith ("1-")) {
        String[] tokens = response.substring (2).split (",");
        if (tokens.length != tos.length) {
          throw new RuntimeException ("Wrong returned results. Response: '" + response + "'");
        }
        return tokens;
      }
      throw new RuntimeException ("Sending sms is failed. Response: '" + response + "'");
    } catch (MalformedURLException e) {
      e.printStackTrace ();
      throw new RuntimeException (e);
    } catch (IOException e) {
      e.printStackTrace ();
      throw new RuntimeException (e);
    }
  }
}
