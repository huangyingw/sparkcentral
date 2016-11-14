package com.sparkcentral;

import java.util.Stack;

public class Calculator
{
  public int evaluate(String expression)
  {
    char[] tokens = expression.toCharArray();
    // Stack for numbers: 'values'
    Stack<Integer> values = new Stack<Integer>();
    // Stack for Operators: 'ops'
    Stack<Operator> ops = new Stack<Operator>();

    for (int i = 0; i < tokens.length; i++ )
    {
      // Current token is a whitespace, skip it
      if (tokens[i] == ' ')
      {
        continue;
      }

      // Current token is a number, push it to stack for numbers
      if (tokens[i] >= '0' && tokens[i] <= '9')
      {
        StringBuffer sbuf = new StringBuffer();

        // There may be more than one digits in number
        while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
        {
          sbuf.append(tokens[i++ ]);
        }

        values.push(Integer.parseInt(sbuf.toString()));
      }
      // Current token is an operator.
      else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*'
        || tokens[i] == '/')
      {
        // While top of 'ops' has same or greater precedence to current
        // token, which is an operator. Apply operator on top of 'ops'
        // to top two elements in values stack
        while (!ops.empty()
          && (operatorParser(tokens[i]).compareTo(ops.peek()) < 0))
        {
          values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        // Push current token to 'ops'.
        ops.push(operatorParser(tokens[i]));
      }
    }

    // Entire expression has been parsed at this point, apply remaining
    // ops to remaining values
    while (!ops.empty())
    {
      values.push(applyOp(ops.pop(), values.pop(), values.pop()));
    }

    // Top of 'values' contains result, return it
    return values.pop();
  }

  private Operator operatorParser(char c)
  {
    switch (c)
    {
      case '+':
        return new AddCommand(0);

      case '-':
        return new SubCommand(0);

      case '*':
        return new MulCommand(1);

      case '/':
        return new DivCommand(1);
    }

    return null;
  }

  public int applyOp(Operator operator, int b, int a)
  {
    return operator.execute(a, b);
  }
}
