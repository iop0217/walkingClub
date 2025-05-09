package com.example.walkingclub.dto;

public class View {
    public static class All {}                  // 전체
    public static class Create extends All {}   // 생성
    public static class Gets extends All {}     // 전체 조회
    public static class Get extends All {}      // 단건 조회
    public static class Update extends All {}   // 수정

    public interface Content {}     // 아이디, 내용
    public interface Id {}          // 아이디
    public interface Contents {}    // 내용
}
