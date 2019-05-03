package com.mervynlam.mergeMultiTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class App {

	private final static String encoding = "UTF-8";
	
	public static void main(String[] args) {
		merge();
	}
	
	private static void merge() {
		//获取当前目录路径
		File nowDir = new File(System.getProperty("user.dir"));
		File[] dirs = nowDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.isDirectory();
			}
		});
		for(File dir : dirs) {
			//目标文件名，就是文件夹名
			String fileName = dir.getName()+".txt";	
			File novel = new File(fileName);
			System.out.println("输出"+fileName);
			//不存在就创建
			if (!novel.exists()) {
				try {
					novel.createNewFile();
				} catch (IOException e1) {
					System.out.println(fileName+"文件创建失败");
					e1.printStackTrace();
				}
			}
			//当前目录下的所有.txt文件
			File[] files = dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".txt");
				}
			});
			//输出流
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), encoding));
			} catch (Exception e1) {
				System.out.println("BufferedWriter实例化错误");
				e1.printStackTrace();
			}
			//遍历文件夹下的txt
			for(File file : files) {
				try {
					//输入流
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsoluteFile()), encoding));
					String str = null;
					while((str = br.readLine()) != null){
						str = str.replaceAll("@无限好文，尽在晋江文学城", "");
						bw.write(str);
						bw.newLine();
					}
					bw.newLine();
					br.close();
					System.out.println("输出--"+file.getName());
				} catch(Exception e) {
					System.out.println(file.getName()+"输出错误");
					e.printStackTrace();
				}
			}
			try {
				bw.flush();
				bw.close();
			} catch(Exception e) {
				System.out.println("合成错误");
				e.printStackTrace();
			}
			System.out.println("输出"+fileName+"完成");
			System.out.println("--------------------------");
		}
	}
}
