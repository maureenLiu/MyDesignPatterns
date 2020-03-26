package com.maureen.dp.adapter;

import java.io.*;

//这是一个Adapter模式
public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/maureen/test.txt");
            InputStreamReader isr = new InputStreamReader(fis); //转接器，将InputStream转换为Reader
            BufferedReader br = new BufferedReader(isr); //BufferedReader按行读
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
