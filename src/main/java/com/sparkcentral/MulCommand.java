package com.sparkcentral;

public class MulCommand extends Operator
{

    public MulCommand(int priority)
    {
        super(priority);
    }

    public Integer execute(Integer num1, Integer num2)
    {
        return num1 * num2;
    }

    public int compareTo(Operator o)
    {
        return this.getPriority() - o.getPriority();
    }

}
