package com.seunghoshin.android.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
    클릭리스너 구현하는 방법 3가지
    1. 위젯을 사용하는 객체가 상속받아서 구현한다.
    2. 객체 내에서 변수로 생성
    3. setOnclickListener 함수에 익명 객체로 전달
 */



public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    TextView tv;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String text = "주소150";


        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btnClick);


        //1번형태로 구현
        btn.setOnClickListener(this);




//        //2번형태로 구현 - 아래에 구현된 리스너를 등록해준다
//        View.OnClickListener listener = new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                tv.setText("안녕 안드로이드!!!");
//            }
//        });


//        // btn.setOnClickListener(new O);   new하고 대문자 O를 하면 자동으로 코드가 완성된다 (3번)
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 주소150
//                tv.setText(text);
//            }
//        });



    }
    public void main(String args[]){
        MainActivity clazz = new MainActivity(); //주소 150; 처음에는 clazz변수에 담김 (지역변수)

        clazz.setObject(clazz); // 150이 담김 clazz에 / 여기서 넘길때 주의해야함 !

        clazz = new MainActivity(); // 주소 160전달받음 왼쪽에 clazz /
    }

    public void setObject(MainActivity aaa){ //주소 150이 넘어감 clazz가 넘어가는게 아님 !!! 변수는 사라짐 객체에 들어가는 순간
        // 이게 다 지역변수 되었을때 문제가됨

        new SubActivity(){
            public void onClick(MainActivity activity){
                MainActivity bbb = aaa; //주소 150

            }
        }
    }

    //1번형태
    @Override
    public void onClick(View v) {
        tv.setText("안녕 안드로이드!!");
    }

    class SubActivity{

    }
}

