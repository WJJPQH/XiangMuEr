package com.example.libentity.day02;

import com.example.libentity.Entity;
import com.example.libentity.MyRetentionPolicy;

@Entity(value = "ab", retention = MyRetentionPolicy.CLASS, str = {"123","asd"})
public class Persons {
}
