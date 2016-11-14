package com.sparkcentral;

public abstract class Operator implements Comparable<Operator>
{
  private int priority;

  public int getPriority()
  {
    return priority;
  }

  public Operator(int priority)
  {
    super();
    this.priority = priority;
  }

  public abstract Integer execute(Integer num1, Integer num2);
}
