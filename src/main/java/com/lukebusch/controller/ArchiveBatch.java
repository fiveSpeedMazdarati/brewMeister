package com.lukebusch.controller;

import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.GenericDao;
import com.lukebusch.persistence.SessionFactoryProvider;
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

@WebServlet(name = "archiveBatch", urlPatterns = "/archiveBatch")
/**
 * A servlet to handle a delete request
 *
 * @author lbusch
 */
public class ArchiveBatch extends HttpServlet {
    // just a logger, nothing to see here...
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Handles POST requests
     *
     * @param request the request
     * @param response the response
     * @throws ServletException if there is an exception, this contains the information
     * @throws IOException if there is an exception, this contains the needed information
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao<Batch> batchGenericDao = DaoFactory.createDao( Batch.class );
        Batch batchToDelete = batchGenericDao.getById(Integer.valueOf(request.getParameter("id")));
        logger.info("Archiving batch #" + batchToDelete.getId());
        batchGenericDao.delete(batchToDelete);

        request.setAttribute("archivedBatch", true);
        request.setAttribute("archivedBatchId", batchToDelete.getId());
        request.setAttribute("archivedBatchName", batchToDelete.getTitle());

        // send them off to the new batch page
        RequestDispatcher dispatcher = request.getRequestDispatcher("getAllBatchesForUser");
        dispatcher.include(request, response);

    }

}

