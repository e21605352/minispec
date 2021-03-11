package com.minispec.utils;

import java.util.Collections;

public class StringUtils
{

  private StringUtils()
  {
    throw new IllegalStateException("Utility class");
  }

  public static String repeat(String text, int number)
  {
    return String.join("", Collections.nCopies(number, text));
  }

  public static String capitalize(String word)
  {
    return word.substring(0, 1).toUpperCase() + word.substring(1);
  }
}
