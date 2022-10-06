package com.goodee.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class JB01_Path {

	public static void main(String[] args) {
	 Path path = Paths.get("D:/sample/abc.txt");
	 System.out.println("[파일명] " + path.getFileName());
	 System.out.println("[부모 디렉토리명] " + path.getParent().getFileName());
	 System.out.println("중첩 경로수 " + path.getNameCount());
	 
	 System.out.println("----------경로출력----------");
	 for (int i = 0; i < path.getNameCount(); i++) {
		 	System.out.println(path.getName(i));
	 	}
	 
	}
}
