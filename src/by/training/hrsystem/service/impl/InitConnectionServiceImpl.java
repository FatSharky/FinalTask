package by.training.hrsystem.service.impl;

import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.service.InitConnectionService;
import by.training.hrsystem.service.exeption.ServiceException;

public class InitConnectionServiceImpl implements InitConnectionService {

	@Override
	public void initConnection() throws ServiceException {
		ConnectionPool conn = null;
		try {
			conn = ConnectionPool.getInstance();
			conn.initConnectionPool();
		} catch (ConnectionPoolException e) {
			throw new ServiceException("Cannot init a pool", e);
		}
	}

	@Override
	public void destroyConnection() throws ServiceException {
		ConnectionPool conn = null;
		try {
			conn = ConnectionPool.getInstance();
			conn.dispose();
		} catch (ConnectionPoolException e) {
			throw new ServiceException("Cannot destroy pool", e);
		}

	}
}
