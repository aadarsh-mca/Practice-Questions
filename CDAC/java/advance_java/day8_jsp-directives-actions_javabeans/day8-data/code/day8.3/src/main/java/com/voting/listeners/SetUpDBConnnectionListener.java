package com.voting.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static com.voting.utils.DBUtils.*;

import java.sql.SQLException;

@WebListener
public class SetUpDBConnnectionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("ctx inited");
        ServletContext ctx=sce.getServletContext();
        try {
			openConnection(ctx.getInitParameter("db_url"),
					ctx.getInitParameter("user_name"), 
					ctx.getInitParameter("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("in ctx destroyed");
        try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
	
}
