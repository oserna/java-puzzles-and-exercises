package le.pool.impl;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import le.pool.Connection;
import le.pool.ConnectionPool;

/**
 * Try to implement ConnectionPool, which keeps a pool of Connections. 
 * When there are connection that is closed. return it. 
 * When All connections in the pool are open, create a new connection in pool then return it.
 * 
 * @author oserna
 */
public enum NaivePool implements ConnectionPool {
	
	INSTANCE;

	private final int ABANDON_TIME = 5000;
	private final int ABANDON_CHECK_INTERVAL = 2000;
	
	private final int POOL_MAX_CAPACITY = 20;
	private final AtomicInteger createCount = new AtomicInteger(0);

	private final BlockingQueue<Connection> idle = new LinkedBlockingDeque<>();

	private final ConcurrentLinkedQueue<Connection> allConns = new ConcurrentLinkedQueue<>();

	private final ScheduledExecutorService healthChecker = Executors.newSingleThreadScheduledExecutor();
	
	private NaivePool(){
		healthChecker.scheduleAtFixedRate(new Checker(), 0, ABANDON_CHECK_INTERVAL, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public Connection getConnection() {

		Connection conn = idle.poll();

		// try to create the object because the pool is empty (all
		// connections are in use or there are no connections yet)
		if (conn == null) 
			conn = create();

		if (conn == null)
			throw new NoSuchElementException("Max number of connections reached");

		return conn;
	}
	
	
	private Connection create() {

		int newCreateCount = createCount.incrementAndGet();
		if (newCreateCount > POOL_MAX_CAPACITY) {
			createCount.decrementAndGet();
			return null;
		}
		
		Connection conn = new Connection() {
			
			volatile long lastUsed = System.currentTimeMillis();

			@Override
			public Object execute(Object param) {
				lastUsed = System.currentTimeMillis();
				return "Executed with param " + param;
			}

			@Override
			public void close() {
				idle.add(this);
			}

			@Override
			public boolean isClosed() {
				return false;
			}

			@Override
			public boolean isShrinkable() {
				return false;
			}

			@Override
			public long getLastUsed() {
				return 0;
			}

			@Override
			public long lastUsedTime() {
				return lastUsed;
			}
		};
			
		allConns.add(conn);
		
		return conn;
	}

	private class Checker implements Runnable{
		@Override
		public void run() {
			for (Connection conn : allConns) {
				if ((System.currentTimeMillis() - conn.lastUsedTime()) > ABANDON_TIME) {
					conn.close();
				}
			}
			
		}
		
	}
	
}
