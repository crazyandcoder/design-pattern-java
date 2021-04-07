package design_pattern.create.singleinstance;

import java.util.concurrent.atomic.AtomicLong;

public enum EnumSingleInstance {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
