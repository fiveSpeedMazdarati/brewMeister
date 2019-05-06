package com.lukebusch.controller;

import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
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
        GenericDao dao = DaoFactory.createDao( Batch.class );

        Batch originalBatch;

        // get the original batch values from the database using the id passed along from the page
        originalBatch = (Batch) dao.getById(Integer.valueOf(request.getParameter("id")));

        // get the info from the request and update the batch


        //  update the batch in the database
        dao.saveOrUpdate(originalBatch);
        request.setAttribute("batchUpdated", true);
        request.setAttribute("updatedBatchTitle", originalBatch.getTitle());
        request.setAttribute("updatedBatchId", originalBatch.getId());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/getAllBatchesForUser");
        dispatcher.forward(request, response);

    }

}
