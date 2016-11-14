package com.sparkcentral;

public class AddCommand extends Operator
{

  public AddCommand(int priority)
  {
    super(priority);
  }

  public Integer execute(Integer num1, Integer num2)
  {
    return num1 + num2;
  }

  public int compareTo(Operator o)
  {
    return this.getPriority() - o.getPriority();
  }
}
