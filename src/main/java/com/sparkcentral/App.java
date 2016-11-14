package com.sparkcentral;

public class App
{
  public static void main(String[] args)
  {
    Calculator cal = new Calculator();
    System.out.println(cal.evaluate("10 + 2 * 6"));
    System.out.println(cal.evaluate("100 * 2 + 12"));
  }
}