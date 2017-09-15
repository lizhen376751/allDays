package com.dudu.lizhen.test;

/**
 * 被观察者
 * Created by lizhen on 2017/9/13.
 */
public interface Watched {
    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String str);
}
