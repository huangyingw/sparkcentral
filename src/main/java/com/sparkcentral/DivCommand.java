package com.sparkcentral;

public class DivCommand extends Operator
{

    public DivCommand(int priority)
    {
        super(priority);
    }

    public Integer execute(Integer num1, Integer num2)
    {
        if (num2 == 0)
        {
            throw new UnsupportedOperationException("Cannot divide by zero");
        }

        return num1 / num2;
    }

    public int compareTo(Operator o)
    {
        return this.getPriority() - o.getPriority();
    }

}
