package com.example.netmeeting.mychat;

import android.content.Intent;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMessage extends AppCompatActivity {

    TextView tv_Meeting ;
    String mMeeting;
    ArrayList<String> arrayList2= new ArrayList<>();
    DatabaseReference mReference;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    EditText et_Msg;
    ImageButton iBtn;
    List<User> users;
    User user;
    ArrayList<User> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        Intent it = getIntent();
        mMeeting =  it.getStringExtra("mMeeting");
        Log.d("mMeeting1:",mMeeting+"");
        findView();
        tv_Meeting.setText(mMeeting);

        mReference = FirebaseDatabase.getInstance().getReference("meeting").child(mMeeting);
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str = dataSnapshot.getValue().toString();
                Log.d("str",str);
                int start ;
                String str1;
                for (start=0;start<str.length();start++){
                    str1 = str.substring(start,start+1);
                    if(str1.equals("-")){
                        Log.d("str1",str1+"/"+start+"/"+str.substring(start,start+22));
                        if(str.substring(start+20,start+22).equals("={")){
                            Log.d("str3",str.substring(start,start+20));
                            arrayList2.add(0,str.substring(start,start+20));
                        }
                    }
                }
                mList= new ArrayList<>();
                for(int j=0;j<arrayList2.size();j++){
                    user = dataSnapshot.child(arrayList2.get(j)).getValue(User.class);
                    Log.d("dataSnapshot:",user.getName());
                    mList.add(user);
                }
                compare();
                setupRecyclerView(mList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        mReference = FirebaseDatabase.getInstance().getReference("meeting").child(mMeeting).child("-L7hRRbK_QbvU60lNSRg");
//        mReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                User users = dataSnapshot.getValue(User.class);
//                Log.d("dataSnapshot:",users+"");
//                Log.d("dataSnapshot:",users.getStfn()+"");
//                Log.d("dataSnapshot:",users.getName()+"");
//                Log.d("dataSnapshot:",users.getTag()+"");
//                Log.d("dataSnapshot:",users.getText()+"");
//                Log.d("dataSnapshot:",users.getTimestamp()+"");
//                Log.d("dataSnapshot:",users.getLike()+"");
//                Log.d("dataSnapshot:",users.getLikes()+"");
//                Log.d("dataSnapshot:",users.getTopicSN()+"");
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });



        setMassages();
    }
    void setupRecyclerView(List<User> users){
        mRecyclerView = (RecyclerView)findViewById(R.id.recycleView);
        mAdapter = new MyAdapter(users);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(mAdapter.getItemCount()-1);

    }
    void findView(){
        tv_Meeting = (TextView) findViewById(R.id.tv_meeting);
        et_Msg = (EditText) findViewById(R.id.editText);
        iBtn = (ImageButton) findViewById(R.id.imageButton);
    }
    void setMassages(){
        final User user = new User();
        iBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TopicSN = "18888";
                String name = "陳慶軒";
                String stfn = "180317";
                int tag = 0;
                String text = et_Msg.getText().toString();
                long timestamp = Long.valueOf(new Date().getTime());
                user.setTopicSN(TopicSN);
                user.setName(name);
                user.setStfn(stfn);
                user.setTag(tag);
                user.setText(text);
                user.setTimestamp(timestamp);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference userRef = db.getReference("meeting").child(mMeeting);
                DatabaseReference mSet = userRef.push();
                Map<String,Object> mMap = new HashMap<>();
                mMap.put("TopicSN",TopicSN);
                mMap.put("name",name);
                mMap.put("stfn",stfn);
                mMap.put("like",0);
                mMap.put("likes",null);
                mMap.put("tag",0);
                mMap.put("text",text);
                mMap.put("timestamp",timestamp);
                mSet.setValue(mMap);
                et_Msg.setText("");
            }
        });
    }

    void compare(){
        Collections.sort(mList, new Comparator<User>(){
            @Override
            public int compare(User o1, User o2) {
                if (o1.getTimestamp()>o2.getTimestamp()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });

    }
}
