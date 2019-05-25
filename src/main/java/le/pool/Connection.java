package le.pool;

public interface Connection {
	
		long lastUsedTime();
	
        Object execute(Object param);
        
        void close();

    boolean isClosed();

    boolean isShrinkable();

    long getLastUsed();
}