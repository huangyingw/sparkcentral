package com.sparkcentral;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class AppTest
{
    @Test
    @FileParameters("src/test/resources/test.csv")
    public void loadParamsFromFileWithIdentityMapper(int age, String name)
    {
        System.out.println("age -->" + age);
        System.out.println("name -->" + name);
        assertThat(age).isGreaterThan(0);
    }
}
