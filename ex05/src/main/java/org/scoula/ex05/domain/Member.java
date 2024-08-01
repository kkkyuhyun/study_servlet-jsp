package org.scoula.ex05.domain;

public class Member {
    private String name;
    private String userid;

    public Member(){
    }
    public Member(String name, String userid){
        //필드란  값을 담을 수 있는 곳이다.
        this.name = name;
        this.userid = userid;
        //메소드 => ()달고 다닌다.

        //필드 와 메소드는 클래스 내부에 그 외는 바깥에서 생성된다. 바깥은 import 와 패키지
        //모든 것은 클래스 내부에서 작업이 진행되어야 한다
        //메소드는 어디서 호출되는 것일까?
        //1. 클래스 내부에서 직접 (X) Member member = new Member();
        //2. 메소드/ 생성자 내에서 호출하는 방법(O)
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

}
