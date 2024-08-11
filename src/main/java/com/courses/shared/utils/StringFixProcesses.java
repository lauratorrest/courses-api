package com.courses.shared.utils;

import org.springframework.stereotype.Service;

@Service
public class StringFixProcesses {

  public String removeSpaces(String name) {
    name = name.trim(); //Remove spaces before and after letters
    name = name.replaceAll("\\s+", " "); //Replace more than one straight spaces for only one
    return name;
  }
}
