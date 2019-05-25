package le.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolImpl implements ConnectionPool {

    static final int DEFAULT_POOL_SIZE = 3;    

    static final long MAX_IDLE_TIME = 2000;    

    static final long HEALTH_CHECK_INTERVAL = 5000;    

    private ScheduledExecutorService healthPoolChecker = Executors.newSingleThreadScheduledExecutor(); 
    
    private List<Connection> pool = null;

    private static ConnectionPool poolInstance = null;

    public static synchronized ConnectionPool getConnectionPool(){
        if(null== poolInstance) {                   
                if(null== poolInstance) {                   
                    poolInstance = new ConnectionPoolImpl();
                }               
        }
        return poolInstance;
    }

    private ConnectionPoolImpl() {

        this.pool = new ArrayList<Connection>(DEFAULT_POOL_SIZE);

        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {

            pool.add(new ConnectionImpl(false, i));

        }
        
        healthPoolChecker.scheduleAtFixedRate(new ConnectionPoolHealthChecker(), HEALTH_CHECK_INTERVAL, HEALTH_CHECK_INTERVAL, TimeUnit.MILLISECONDS);

    }

    private synchronized void healthCheck(){
    	long current = System.currentTimeMillis();
        for (Connection connection : pool) {
			if (!connection.isClosed() && (current - connection.getLastUsed() > MAX_IDLE_TIME)) {
				if (connection.isShrinkable()) {
					pool.remove(connection);
					continue;
				}
				connection.execute("kind of basic query, eg: from dual");
			}
        }
    }
    
    @Override
    public synchronized Connection getConnection() {
        
    	for (Connection connection : pool) {
            if (!connection.isClosed()) {
                return connection;
            }
        }
        
        ConnectionImpl connectionImpl = new ConnectionImpl(true,getSize()+1);
        pool.add(connectionImpl);
        
        return connectionImpl;
    }
    
    public int getSize(){
    	return pool.size();
    }

     static class ConnectionImpl implements Connection {
    	
        private boolean closed = false;

        private boolean shrinkable = false;

        private long lastUsed = -1; 
        
        private int order = -1;
        
        public ConnectionImpl(boolean shrinkable, int order) {
        	this.lastUsed = System.currentTimeMillis();
        	this.shrinkable = shrinkable;
		}

         @Override
         public long lastUsedTime() {
             return 0;
         }

         @Override
        public Object execute(Object param) {
        	this.lastUsed = System.currentTimeMillis();
            return null;
        }

        @Override
        public void close() {
            closed = true;
        }

        @Override
        public boolean isClosed() {
            return closed;
        }
        
        public long getLastUsed() {
			return lastUsed;
		}
        
        public boolean isShrinkable() {
			return shrinkable;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + order;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ConnectionImpl other = (ConnectionImpl) obj;
			if (order != other.order)
				return false;
			return true;
		}   
    }

    class ConnectionPoolHealthChecker implements Runnable{
		@Override
		public void run() {			
			((ConnectionPoolImpl)getConnectionPool()).healthCheck();			
		}	  
    }


}
