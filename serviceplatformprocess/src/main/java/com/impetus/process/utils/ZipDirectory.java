package com.impetus.process.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Deque;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author amitb.kumar
 */
public class ZipDirectory
{

  /**
   * @param directory
   * @param zipfile
   * @throws IOException
   */
  private static void zip(File directory, File zipfile) throws IOException
  {
    URI base = directory.toURI();
    Deque<File> queue = new LinkedList<File>();
    queue.push(directory);
    OutputStream out = new FileOutputStream(zipfile);
    Closeable res = out;
    try
    {
      ZipOutputStream zout = new ZipOutputStream(out);
      res = zout;
      while (!queue.isEmpty())
      {
        directory = queue.pop();
        for (File kid : directory.listFiles())
        {
          String name = base.relativize(kid.toURI()).getPath();
          if (kid.isDirectory())
          {
            queue.push(kid);
            name = name.endsWith("/") ? name : name + "/";
            zout.putNextEntry(new ZipEntry(name));
          }
          else
          {
            zout.putNextEntry(new ZipEntry(name));
            copy(kid, zout);
            zout.closeEntry();
          }
        }
      }
    }
    finally
    {
      res.close();
    }
  }

  /**
   * @param in
   * @param out
   * @throws IOException
   */
  private static void copy(InputStream in, OutputStream out) throws IOException
  {
    byte[] buffer = new byte[1024];
    while (true)
    {
      int readCount = in.read(buffer);
      if (readCount < 0)
      {
        break;
      }
      out.write(buffer, 0, readCount);
    }
  }

  /**
   * @param file
   * @param out
   * @throws IOException
   */
  private static void copy(File file, OutputStream out) throws IOException
  {
    InputStream in = new FileInputStream(file);
    try
    {
      copy(in, out);
    }
    finally
    {
      in.close();
    }
  }

  /**
   * @param inputFile
   * @param outputFile
   * @throws Exception
   */
  public static void zipDir(String inputFile, String outputFile) throws Exception
  {
    File inpFile = new File(inputFile);
    File outFile = new File(outputFile);
    zip(inpFile, outFile);
  }
}