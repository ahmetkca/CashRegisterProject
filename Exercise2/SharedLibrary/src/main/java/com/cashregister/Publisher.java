package com.cashregister;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    public List<Subscriber> subscribers = new ArrayList<Subscriber>();
    
    public abstract void subscribe(Subscriber subscriber);
    public abstract void unsubscribe(Subscriber subscriber);
    public abstract void notify(String text);
}
