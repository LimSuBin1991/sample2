package com.goodee.main;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class JB04_Buffer {

	public static void main(String[] args) {
	
		ByteBuffer buffer1 = ByteBuffer.allocate(100);
		//non 다이렉트 버퍼로 힙 메모리에 선언
		ByteBuffer buffer2 = ByteBuffer.allocateDirect(200);
		//다이렉트 버퍼로 선언
		
		System.out.println("저장 용량 : "+buffer1.capacity() + " 바이트");
		System.out.println("저장 용량 : "+buffer2.capacity() + " 바이트");
		
		byte[] byte1 = new byte[100];
		byte[] byte2 = new byte[7];
		
		ByteBuffer buffer3 = ByteBuffer.wrap(byte1);
		ByteBuffer buffer4 = ByteBuffer.wrap(byte2);
		//[] wrap으로 선언 다이렉트 버퍼로 들어감
		
		System.out.println("저장 용량 : "+buffer3.capacity() + " 바이트");
		System.out.println("저장 용량 : "+buffer4.capacity() + " 바이트");
		
		System.out.println("------------------데이터 제어-------------------");
		
printState(buffer4);
		
		buffer4.put((byte)10);
		buffer4.put((byte)11);
		System.out.println("[2바이트 저장 후]");
		printState(buffer4);
		
		buffer4.put((byte)12);
		buffer4.put((byte)13);
		buffer4.put((byte)14);
		System.out.println("[3바이트 저장 후]");
		printState(buffer4);
		
		buffer4.flip(); // position은 위치 0으로 limit는 채워진 데이터의 끝에 위치함
		System.out.println("[filp 실행 후]");
		printState(buffer4);
		
		byte[] byte3 = new byte[3];
		buffer4.get(byte3);
		System.out.println(byte3[0]+","+byte3[1]+","+byte3[2]);
		System.out.println("[3바이트 읽은 후]");
		printState(buffer4);
		
		buffer4.mark();
		System.out.println("------------[현재 위치를 마크 해놓음]");
		
		byte[] byte4 = new byte[2];
		buffer4.get(byte4);
		System.out.println(byte4[0]+","+byte4[1]);
		System.out.println("[2바이트 읽은 후]");
		printState(buffer4);
		
		buffer4.reset();
		System.out.println("------------[position을 mark 위치로 옮김]");
		printState(buffer4);
		
		buffer4.rewind();
		System.out.println("[rewind 실행 후]");
		printState(buffer4);
		
		buffer4.clear();
		System.out.println("[clear() 실행 후]");
		printState(buffer4);
		
		
 	}
	
	public static void printState(Buffer buffer) {
		System.out.println("\tposition : "+buffer.position());
		System.out.println("\tlimit : "+buffer.limit());
		System.out.println("\tcapacity : "+buffer.capacity());

	}
}
