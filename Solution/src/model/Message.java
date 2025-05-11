package model;

import java.time.LocalDateTime;

public class Message {
    private String id;
    private String content;
    private User sender;
    private User receiver;
    private LocalDateTime timeStamp;

    public Message(String id, String content, User sender, User receiver, LocalDateTime timeStamp) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.timeStamp = timeStamp;
    }

    public String getContent() {
        return content;
    }
}
