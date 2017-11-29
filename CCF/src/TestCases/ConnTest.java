package TestCases;

import java.sql.Connection;

import persistLayer.DatabaseAccess;

public class ConnTest {
	
	Connection c = DatabaseAccess.connect();
	
}
