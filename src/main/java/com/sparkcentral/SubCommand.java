package com.sparkcentral;

public class SubCommand extends Operator
{
    public SubCommand(int priority)
    {
        super(priority);
    }

    public Integer execute(Integer num1, Integer num2)
    {
        return num1 - num2;
    }

    public int compareTo(Operator o)
    {
        return this.getPriority() - o.getPriority();
    }

}
