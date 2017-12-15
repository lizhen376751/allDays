package com.dudu.lizhen.socket;

import java.util.Vector;

/**
 * Created by Administrator on 2017/11/24.
 */
public class ChatManager {
    private ChatManager(){}
    private static final ChatManager cm = new ChatManager();
    public static ChatManager getChatManager(){
        return cm;
    }
    Vector<ChatSocket> vector = new Vector<ChatSocket>();
    public void add(ChatSocket cs){
        vector.add(cs);
    }
    public void publish(ChatSocket cs,String out){
        for (int i=0;i<vector.size();i++){
            ChatSocket chatSocket = vector.get(i);
            if (!cs.equals(chatSocket)){
                chatSocket.out(out);
            }
        }
    }
}
