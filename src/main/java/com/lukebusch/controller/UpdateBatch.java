package com.lukebusch.controller;

import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBatch", urlPatterns = "/updateBatch")
/**
 * a class to update a given batch in the database
 * @author lbusch
 */
public class UpdateBatch extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // stuff to get the info from the jsp and update the appropriate record in the database
        Batch updatedBatch = new Batch();
        updatedBatch.setId(Integer.valueOf(request.getParameter("id")));
        updatedBatch.setUser(null); //TODO: DO NOT LEAVE THIS!!
        updatedBatch.setTitle(request.getParameter("title"));
        GenericDao dao = DaoFactory.createDao( Batch.class );

        dao.saveOrUpdate(updatedBatch);



    }

}
